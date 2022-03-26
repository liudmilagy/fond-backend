package net.fondbackend.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "reg_product_provision", schema = "public")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder(toBuilder = true)
public class RegProductProvision {
        @Id
        @Column(name = "id", nullable = false)
        @SequenceGenerator(name = "REG_PRODUCT_PROVISION_GEN", sequenceName = "reg_product_provision_id_seq", allocationSize = 1, schema = "public")
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "REG_PRODUCT_PROVISION_GEN")
        private Long id;

        @OneToOne
        @JoinColumn(name = "id_product", referencedColumnName = "id")
        private ClsProduct product;

        @OneToOne
        @JoinColumn(name = "id_provision", referencedColumnName = "id")
        private ClsProvision provision;

        @Column(name = "min_amount")
        private Integer minAmount;

        @Column(name = "max_amount")
        private Integer maxAmount;

        @Column(name = "interest_rate")
        private Float interestRate;

        @Column(name = "has_key_rate")
        private Boolean hasKeyRate;

        @Column(name = "coef_key_rate")
        private Float coefKeyRate;

        @Column(name = "text_rate")
        private String textRate;

        @Column(name = "is_hidden")
        private Boolean isHidden;
}
