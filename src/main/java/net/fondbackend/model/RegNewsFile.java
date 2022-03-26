package net.fondbackend.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "reg_news_file", schema = "public")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder(toBuilder = true)
public class RegNewsFile {

    @Id
    @Column(name = "id", nullable = false)
    @SequenceGenerator(name = "REG_NEWS_FILE_GEN", sequenceName = "reg_news_file_id_seq", allocationSize = 1, schema = "public")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "REG_NEWS_FILE_GEN")
    private Long id;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

    @Column(name = "is_hidden")
    private Boolean isHidden;

    @Column(name = "time_create", nullable = false)
    private Timestamp timeCreate;

    @Column(name = "attachment_path")
    private String attachmentPath;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "original_file_name")
    private String originalFileName;

    @Column(name = "file_extension", nullable = false, length = 16)
    private String fileExtension;

    @Column(name = "hash")
    private String hash;

    @Column(name = "file_size")
    private Long fileSize;

    @ManyToOne
    @JoinColumn(name = "id_news", referencedColumnName = "id")
    private ClsNews news;
}
