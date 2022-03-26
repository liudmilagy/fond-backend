package net.fondbackend.model;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "cls_news", schema = "public")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder(toBuilder = true)
public class ClsNews {

    @Id
    @Column(name = "id", nullable = false)
    @SequenceGenerator(name = "CLS_NEWS_GEN", sequenceName = "cls_news_id_seq", allocationSize = 1, schema = "public")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CLS_NEWS_GEN")
    private Long id;

    @Column(name = "heading", nullable = false)
    private String heading;

    @Column(name = "message")
    private String message;

    @Column(name = "start_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;

    @Column(name = "hash_id")
    private String hashId;

    @Column(name = "html_text")
    private String htmlText;

    @Column(name = "id_img_cover")
    private Long idImgCover;

    @Column(name = "is_deleted")
    private Boolean isDeleted;
}
