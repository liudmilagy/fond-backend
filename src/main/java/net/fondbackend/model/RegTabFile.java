package net.fondbackend.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "reg_tab_file", schema = "public")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder(toBuilder = true)
public class RegTabFile {
    @Id
    @Column(name = "id", nullable = false)
    @SequenceGenerator(name = "REG_TAB_FILE_GEN", sequenceName = "reg_tab_file_id_seq", allocationSize = 1, schema = "public")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "REG_TAB_FILE_GEN")
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

    @ManyToOne
    @JoinColumn(name = "id_tab", referencedColumnName = "id")
    private ClsTab tab;
}
