package net.fondbackend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "reg_type_appointment_file", schema = "public")
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class RegTypeAppointmentFile {


    @Id
    @Column(name = "id", nullable = false)
    @SequenceGenerator(name = "REG_TYPE_APPOINTMENT_FILE_GEN", sequenceName = "reg_type_appointment_file_id_seq", allocationSize = 1, schema = "public")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "REG_TYPE_APPOINTMENT_FILE_GEN")
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

    @Column(name = "file_extension")
    private String fileExtension;

    @Column(name = "hash")
    private String hash;

    @Column(name = "file_size")
    private Long fileSize;

    @OneToOne
    @JoinColumn(name = "id_type_appointment", referencedColumnName = "id")
    private ClsTypeAppointment clsTypeAppointment;
}
