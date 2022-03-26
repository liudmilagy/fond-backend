package net.fondbackend.service.products;

import net.fondbackend.dto.ProductResponse;

import java.util.List;

public interface ProductMainPageService {
    List<ProductResponse> getProductsInfoForMainPage();
}
