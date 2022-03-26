package net.fondbackend.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class ProductResponse {
    Long            id;

    String          name;
    String          value; // для richselect в калькуляторе
    Integer         limitation;
    Boolean         isHidden;
    String          htmlText;
    Boolean         notActive;
    String          iconName;
    String          attachmentPath;
    Integer         weight;
    Integer         calculationType;
    String          targetReport;

    ProductProvisionDto productProvisionWithDeposit;
    ProductProvisionDto productProvisionWithoutDeposit;

    @Getter
    @Setter
    @FieldDefaults(level = AccessLevel.PRIVATE)
    @Builder
    @EqualsAndHashCode(onlyExplicitlyIncluded = true)
    public static class ProductProvisionDto {
        Long            id;
        Integer         minAmount;
        Integer         maxAmount;
        Float           interestRate;
        Boolean         hasKeyRate;
        Float           coefKeyRate;
        String          textRate;
        Boolean         hidden;
    }
}
