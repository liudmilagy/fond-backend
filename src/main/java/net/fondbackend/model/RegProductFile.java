package net.fondbackend.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "reg_product_file", schema = "public")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder(toBuilder = true)
public class RegProductFile {

    @Id
    @Column(name = "id", nullable = false)
    @SequenceGenerator(name = "REG_PRODUCT_FILE_GEN", sequenceName = "reg_product_file_id_seq", allocationSize = 1, schema = "public")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "REG_PRODUCT_FILE_GEN")
    private Long id;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

    @Column(name = "time_create", nullable = false)
    private Timestamp timeCreate;

    @Column(name = "attachment_path")
    private String attachmentPath;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "original_file_name")
    private String originalFileName;

    @Column(name = "file_extension", length = 16)
    private String fileExtension;

    @Column(name = "hash")
    private String hash;

    @Column(name = "file_size")
    private Long fileSize;

    @Column(name = "is_hidden")
    private Boolean isHidden;

    @ManyToOne
    @JoinColumn(name = "id_product", referencedColumnName = "id")
    private ClsProduct product;
}
