package net.fondbackend.model;

import javax.persistence.*;

@Entity
@NamedNativeQuery(
        name = "get_products_for_calculator",
        query =
                "SELECT cls_product.id as id, cls_product.name as name, cls_product.name as value,\n" +
                        "       cls_product.limitation as limitation, cls_product.is_hidden as is_hidden, cls_product.html_text as html_text, \n" +
                        "       cls_product.not_active as not_active, cls_product.icon_name as icon_name,\n" +
                        "       cls_product.weight as weight,\n" +
                        "       cls_product.calculation_type as calculation_type,\n" +
                        "       cls_product.target_report as target_report,\n" +
                        "       COALESCE(rpf.attachment_path, '') as attachment_path,\n" +
                        "       rpp_w.id as id_with_deposit,\n" +
                        "       rpp_w.min_amount as min_amount_with_deposit,\n" +
                        "       rpp_w.max_amount as max_amount_with_deposit,\n" +
                        "       rpp_w.interest_rate as interest_rate_with_deposit,\n" +
                        "       rpp_w.has_key_rate as has_key_rate_with_deposit,\n" +
                        "       rpp_w.coef_key_rate as coef_key_rate_with_deposit,\n" +
                        "       rpp_w.text_rate as text_rate_with_deposit,\n" +
                        "       rpp_w.is_hidden as hidden_with_deposit,\n" +
                        "       rpp_wo.id as id_without_deposit,\n" +
                        "       rpp_wo.min_amount as min_amount_without_deposit,\n" +
                        "       rpp_wo.max_amount as max_amount_without_deposit,\n" +
                        "       rpp_wo.interest_rate as interest_rate_without_deposit,\n" +
                        "       rpp_wo.has_key_rate as has_key_rate_without_deposit,\n" +
                        "       rpp_wo.coef_key_rate as coef_key_rate_without_deposit,\n" +
                        "       rpp_wo.text_rate as text_rate_without_deposit,\n" +
                        "       rpp_wo.is_hidden as hidden_without_deposit\n" +
                        "FROM cls_product\n" +
                        "LEFT JOIN reg_product_provision rpp_w\n" +
                        "    ON cls_product.id = rpp_w.id_product\n" +
                        "        AND rpp_w.id_provision = :id_provision_with_deposit\n" +
                        "LEFT JOIN reg_product_provision rpp_wo\n" +
                        "    ON cls_product.id = rpp_wo.id_product\n" +
                        "        AND rpp_wo.id_provision = :id_provision_without_deposit\n" +
                        "LEFT JOIN reg_product_file rpf\n" +
                        "    ON cls_product.id_img_cover = rpf.id\n" +
                        "WHERE cls_product.is_hidden = false",
        resultSetMapping = "product_entity_result"
)
@SqlResultSetMapping(
        name = "product_entity_result",
        entities = @EntityResult(
                entityClass  = ClsProductEntity.class,
                fields = {
                        @FieldResult(name = "id", column = "id"),
                        @FieldResult(name = "name", column = "name"),
                        @FieldResult(name = "value", column = "value"),
                        @FieldResult(name = "limitation", column = "limitation"),
                        @FieldResult(name = "isHidden", column = "is_hidden"),
                        @FieldResult(name = "htmlText", column = "html_text"),
                        @FieldResult(name = "notActive", column = "not_active"),
                        @FieldResult(name = "iconName", column = "icon_name"),
                        @FieldResult(name = "attachmentPath", column = "attachment_path"),
                        @FieldResult(name = "weight", column = "weight"),
                        @FieldResult(name = "calculationType", column = "calculation_type"),
                        @FieldResult(name = "targetReport", column = "target_report"),


                        @FieldResult(name = "idWithDeposit", column = "id_with_deposit"),
                        @FieldResult(name = "minAmountWithDeposit", column = "min_amount_with_deposit"),
                        @FieldResult(name = "maxAmountWithDeposit", column = "max_amount_with_deposit"),
                        @FieldResult(name = "interestRateWithDeposit", column = "interest_rate_with_deposit"),
                        @FieldResult(name = "hasKeyRateWithDeposit", column = "has_key_rate_with_deposit"),
                        @FieldResult(name = "coefKeyRateWithDeposit", column = "coef_key_rate_with_deposit"),
                        @FieldResult(name = "textRateWithDeposit", column = "text_rate_with_deposit"),
                        @FieldResult(name = "hiddenWithDeposit", column = "hidden_with_deposit"),


                        @FieldResult(name = "idWithoutDeposit", column = "id_without_deposit"),
                        @FieldResult(name = "minAmountWithoutDeposit", column = "min_amount_without_deposit"),
                        @FieldResult(name = "maxAmountWithoutDeposit", column = "max_amount_without_deposit"),
                        @FieldResult(name = "interestRateWithoutDeposit", column = "interest_rate_without_deposit"),
                        @FieldResult(name = "hasKeyRateWithoutDeposit", column = "has_key_rate_without_deposit"),
                        @FieldResult(name = "coefKeyRateWithoutDeposit", column = "coef_key_rate_without_deposit"),
                        @FieldResult(name = "textRateWithoutDeposit", column = "text_rate_without_deposit"),
                        @FieldResult(name = "hiddenWithoutDeposit", column = "hidden_without_deposit"),

                }
        )
)
public class ClsProductEntity {

    @Id
    private Long            id;

    private String          name;
    private String          value; // для richselect в калькуляторе
    private Integer         limitation;
    private Boolean         isHidden;
    private String          htmlText;
    private Boolean         notActive;
    private String          iconName;
    private String          attachmentPath;
    private Integer         weight;
    private Integer         calculationType;
    private String          targetReport;


    private Long            idWithDeposit;
    private Integer         minAmountWithDeposit;
    private Integer         maxAmountWithDeposit;
    private Float           interestRateWithDeposit;
    private Boolean         hasKeyRateWithDeposit;
    private Float           coefKeyRateWithDeposit;
    private String          textRateWithDeposit;
    private Boolean         hiddenWithDeposit;


    private Long            idWithoutDeposit;
    private Integer         minAmountWithoutDeposit;
    private Integer         maxAmountWithoutDeposit;
    private Float           interestRateWithoutDeposit;
    private Boolean         hasKeyRateWithoutDeposit;
    private Float           coefKeyRateWithoutDeposit;
    private String          textRateWithoutDeposit;
    private Boolean         hiddenWithoutDeposit;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getLimitation() {
        return limitation;
    }

    public void setLimitation(Integer limitation) {
        this.limitation = limitation;
    }

    public Boolean getHidden() {
        return isHidden;
    }

    public void setHidden(Boolean hidden) {
        isHidden = hidden;
    }

    public String getHtmlText() {
        return htmlText;
    }

    public void setHtmlText(String htmlText) {
        this.htmlText = htmlText;
    }

    public Long getIdWithDeposit() {
        return idWithDeposit;
    }

    public void setIdWithDeposit(Long idWithDeposit) {
        this.idWithDeposit = idWithDeposit;
    }

    public Integer getMinAmountWithDeposit() {
        return minAmountWithDeposit;
    }

    public void setMinAmountWithDeposit(Integer minAmountWithDeposit) {
        this.minAmountWithDeposit = minAmountWithDeposit;
    }

    public Integer getMaxAmountWithDeposit() {
        return maxAmountWithDeposit;
    }

    public void setMaxAmountWithDeposit(Integer maxAmountWithDeposit) {
        this.maxAmountWithDeposit = maxAmountWithDeposit;
    }

    public Float getInterestRateWithDeposit() {
        return interestRateWithDeposit;
    }

    public void setInterestRateWithDeposit(Float interestRateWithDeposit) {
        this.interestRateWithDeposit = interestRateWithDeposit;
    }

    public Boolean getHasKeyRateWithDeposit() {
        return hasKeyRateWithDeposit;
    }

    public void setHasKeyRateWithDeposit(Boolean hasKeyRateWithDeposit) {
        this.hasKeyRateWithDeposit = hasKeyRateWithDeposit;
    }

    public Float getCoefKeyRateWithDeposit() {
        return coefKeyRateWithDeposit;
    }

    public void setCoefKeyRateWithDeposit(Float coefKeyRateWithDeposit) {
        this.coefKeyRateWithDeposit = coefKeyRateWithDeposit;
    }

    public Long getIdWithoutDeposit() {
        return idWithoutDeposit;
    }

    public void setIdWithoutDeposit(Long idWithoutDeposit) {
        this.idWithoutDeposit = idWithoutDeposit;
    }

    public Integer getMinAmountWithoutDeposit() {
        return minAmountWithoutDeposit;
    }

    public void setMinAmountWithoutDeposit(Integer minAmountWithoutDeposit) {
        this.minAmountWithoutDeposit = minAmountWithoutDeposit;
    }

    public Integer getMaxAmountWithoutDeposit() {
        return maxAmountWithoutDeposit;
    }

    public void setMaxAmountWithoutDeposit(Integer maxAmountWithoutDeposit) {
        this.maxAmountWithoutDeposit = maxAmountWithoutDeposit;
    }

    public Float getInterestRateWithoutDeposit() {
        return interestRateWithoutDeposit;
    }

    public void setInterestRateWithoutDeposit(Float interestRateWithoutDeposit) {
        this.interestRateWithoutDeposit = interestRateWithoutDeposit;
    }

    public Boolean getHasKeyRateWithoutDeposit() {
        return hasKeyRateWithoutDeposit;
    }

    public void setHasKeyRateWithoutDeposit(Boolean hasKeyRateWithoutDeposit) {
        this.hasKeyRateWithoutDeposit = hasKeyRateWithoutDeposit;
    }

    public Float getCoefKeyRateWithoutDeposit() {
        return coefKeyRateWithoutDeposit;
    }

    public void setCoefKeyRateWithoutDeposit(Float coefKeyRateWithoutDeposit) {
        this.coefKeyRateWithoutDeposit = coefKeyRateWithoutDeposit;
    }

    public String getTextRateWithDeposit() {
        return textRateWithDeposit;
    }

    public void setTextRateWithDeposit(String textRateWithDeposit) {
        this.textRateWithDeposit = textRateWithDeposit;
    }

    public String getTextRateWithoutDeposit() {
        return textRateWithoutDeposit;
    }

    public void setTextRateWithoutDeposit(String textRateWithoutDeposit) {
        this.textRateWithoutDeposit = textRateWithoutDeposit;
    }

    public Boolean getNotActive() {
        return notActive;
    }

    public void setNotActive(Boolean notActive) {
        this.notActive = notActive;
    }

    public String getIconName() {
        return iconName;
    }

    public void setIconName(String iconName) {
        this.iconName = iconName;
    }

    public String getAttachmentPath() {
        return attachmentPath;
    }

    public void setAttachmentPath(String attachmentPath) {
        this.attachmentPath = attachmentPath;
    }

    public Boolean getHiddenWithDeposit() {
        return hiddenWithDeposit;
    }

    public void setHiddenWithDeposit(Boolean hiddenWithDeposit) {
        this.hiddenWithDeposit = hiddenWithDeposit;
    }

    public Boolean getHiddenWithoutDeposit() {
        return hiddenWithoutDeposit;
    }

    public void setHiddenWithoutDeposit(Boolean hiddenWithoutDeposit) {
        this.hiddenWithoutDeposit = hiddenWithoutDeposit;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getCalculationType() {
        return calculationType;
    }

    public void setCalculationType(Integer calculationType) {
        this.calculationType = calculationType;
    }

    public String getTargetReport() {
        return targetReport;
    }

    public void setTargetReport(String targetReport) {
        this.targetReport = targetReport;
    }
}


