package net.fondbackend.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cls_type_appointment", schema = "public")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder(toBuilder = true)
public class ClsTypeAppointment implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    @SequenceGenerator(name = "CLS_TYPE_APPOINTMENT_SEQ_GEN", sequenceName = "cls_type_appointment_id_seq", allocationSize = 1, schema = "public")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CLS_TYPE_APPOINTMENT_SEQ_GEN")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "code")
    private String code;

    @Column(name = "description")
    private String description;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

    @Column(name = "id_img_cover")
    private Long idImgCover;
}
