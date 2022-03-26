package net.fondbackend.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "reg_partner_file", schema = "public")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder(toBuilder = true)
public class RegPartnerFile {

    @Id
    @Column(name = "id", nullable = false)
    @SequenceGenerator(name = "REG_PARTNER_FILE_GEN", sequenceName = "reg_partner_file_id_seq", allocationSize = 1, schema = "public")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "REG_PARTNER_FILE_GEN")
    private Long id;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

    @Column(name = "time_create", nullable = false)
    private Timestamp timeCreate;

    @Column(name = "attachment_path", length = -1)
    private String attachmentPath;

    @Column(name = "file_name", length = -1)
    private String fileName;

    @Column(name = "original_file_name", length = -1)
    private String originalFileName;

    @Column(name = "file_extension", length = 16)
    private String fileExtension;

    @Column(name = "hash", length = -1)
    private String hash;

    @Column(name = "file_size")
    private Long fileSize;

    @OneToOne
    @JoinColumn(name = "id_partner", referencedColumnName = "id")
    private ClsPartner partner;
}
