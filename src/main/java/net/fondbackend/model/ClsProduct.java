package net.fondbackend.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "cls_product", schema = "public")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder(toBuilder = true)
public class ClsProduct {

    @Id
    @Column(name = "id", nullable = false)
    @SequenceGenerator(name = "CLS_PRODUCT_SEQ_GEN", sequenceName = "cls_product_id_seq", allocationSize = 1, schema = "public")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CLS_PRODUCT_SEQ_GEN")
    private Long            id;

    @Column(name = "name")
    private String          name;

    @Column(name = "limitation")
    private Integer         limitation;

    @Column(name = "is_hidden")
    private Boolean         isHidden;

    @Column(name = "html_text")
    private String          htmlText;

    @Column(name = "not_active")
    private Boolean         notActive;

    @Column(name = "icon_name")
    private String          iconName;

    @Column(name = "id_img_cover")
    private Long            idImgCover;

    @Column(name = "weight")
    private Integer         weight;

    @Column(name = "calculation_type")
    private Integer         calculationType;

    @Column(name = "target_report")
    private String          targetReport;
}
