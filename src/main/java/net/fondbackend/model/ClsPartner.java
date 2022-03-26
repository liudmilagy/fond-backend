package net.fondbackend.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "cls_partners", schema = "public")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder(toBuilder = true)
public class ClsPartner {
    @Id
    @Column(name = "id", nullable = false)
    @SequenceGenerator(name = "CLS_PARTNERS_SEQ_GEN", sequenceName = "cls_partners_id_seq", allocationSize = 1, schema = "public")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CLS_PARTNERS_SEQ_GEN")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

    @Column(name = "url")
    private String url;

    @Column(name = "file_id")
    private Long fileId;
}
