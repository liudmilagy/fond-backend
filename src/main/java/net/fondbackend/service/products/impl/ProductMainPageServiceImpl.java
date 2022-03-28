package net.fondbackend.service.products.impl;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import net.fondbackend.dto.ProductResponse;
import net.fondbackend.model.ClsProduct;
import net.fondbackend.model.ProvisionCodes;
import net.fondbackend.model.RegProductFile;
import net.fondbackend.model.RegProductProvision;
import net.fondbackend.repository.reg_product_file.RegProductFileRepo;
import net.fondbackend.repository.reg_product_provision.RegProductProvisionRepo;
import net.fondbackend.service.products.ProductMainPageService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductMainPageServiceImpl implements ProductMainPageService {

    RegProductProvisionRepo productProvisionRepo;
    RegProductFileRepo productFileRepo;

    @Override
    public List<ProductResponse> getProductsInfoForMainPage() {
        List<RegProductProvision> productProvisions = productProvisionRepo.getProvisionsOfNotHiddenProducts();
        Set<ClsProduct> products = productProvisions.stream()
                                        .map(RegProductProvision::getProduct)
                                        .collect(Collectors.toSet());

        Map<ClsProduct, RegProductFile> productFileMap = getProductFileMap(products);
        Map<ClsProduct, Map<String, RegProductProvision>> productMap = productProvisionsToMap(productProvisions);

        return productMap.entrySet().stream()
                .map(entry -> {
                    ClsProduct product = entry.getKey();
                    Map<String, RegProductProvision> provisionMap = entry.getValue();
                    ProductResponse.ProductProvisionDto wDeposit = getProductProvisionDto(provisionMap.get(ProvisionCodes.WITH_DEPOSIT.getValue()));
                    ProductResponse.ProductProvisionDto woDeposit = getProductProvisionDto(provisionMap.get(ProvisionCodes.WITHOUT_DEPOSIT.getValue()));
                    RegProductFile productFile = productFileMap.get(product);
                    String attachmentFile = (productFile != null) ? productFile.getAttachmentPath() : "";

                    return ProductResponse.builder()
                            .id(product.getId())
                            .name(product.getName())
                            .value(product.getName())
                            .limitation(product.getLimitation())
                            .isHidden(product.getIsHidden())
                            .htmlText(product.getHtmlText())
                            .notActive(product.getNotActive())
                            .iconName(product.getIconName())
                            .attachmentPath(attachmentFile)
                            .weight(product.getWeight())
                            .calculationType(product.getCalculationType())
                            .targetReport(product.getTargetReport())
                            .productProvisionWithDeposit(wDeposit)
                            .productProvisionWithoutDeposit(woDeposit)
                            .build();
                })
                .collect(Collectors.toList());
    }

    /**
     * Получение Map по продукту c Map по типу условий (с депозитом/без):
     *
     * @param productProvisions - все данные по продуктовой линейке с/без депозита
     * @return Map<продукт, Map<код с депозитом/без депозита, provision>
     */
    Map<ClsProduct, Map<String, RegProductProvision>> productProvisionsToMap(List<RegProductProvision> productProvisions) {
        Map<ClsProduct, Map<String, RegProductProvision>> productMap = new HashMap<>();
        productProvisions.forEach(productProvision -> {
            ClsProduct product = productProvision.getProduct();
            String provisionCode = productProvision.getProvision().getCode();

            Map<String, RegProductProvision> provisionMap = productMap.getOrDefault(product, new HashMap<>());
            provisionMap.put(provisionCode, productProvision);

            productMap.put(product, provisionMap);
        });

        return productMap;
    }

    Map<ClsProduct, RegProductFile> getProductFileMap(Set<ClsProduct> products) {
        Set<Long> productImageIds = products.stream()
                                    .map(ClsProduct::getIdImgCover)
                                    .filter(Objects::nonNull)
                                    .collect(Collectors.toSet());
        List<RegProductFile> productFiles = productFileRepo.findAllById(productImageIds);
        return productFiles.stream()
                .collect(Collectors.toMap(RegProductFile::getProduct, regProductFile -> regProductFile));
    }

    ProductResponse.ProductProvisionDto getProductProvisionDto(RegProductProvision productProvision) {
        if (productProvision != null) {
            return ProductResponse.ProductProvisionDto.builder()
                    .id(productProvision.getId())
                    .minAmount(productProvision.getMinAmount())
                    .maxAmount(productProvision.getMaxAmount())
                    .interestRate(productProvision.getInterestRate())
                    .hasKeyRate(productProvision.getHasKeyRate())
                    .coefKeyRate(productProvision.getCoefKeyRate())
                    .textRate(productProvision.getTextRate())
                    .hidden(productProvision.getIsHidden())
                    .build();
        }

        return null;
    }

}
