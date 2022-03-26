package net.fondbackend.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cls_provision", schema = "public")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder(toBuilder = true)
public class ClsProvision implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    @SequenceGenerator(name = "CLS_PROVISION_SEQ_GEN", sequenceName = "cls_provision_id_seq", allocationSize = 1, schema = "public")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CLS_PROVISION_SEQ_GEN")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "code")
    private String code;
}
