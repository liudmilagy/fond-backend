package net.fondbackend.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "reg_client_appointment", schema = "public")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder(toBuilder = true)
public class RegClientAppointment {
        @Id
        @Column(name = "id", nullable = false)
        @SequenceGenerator(name = "REG_CLIENT_APPOINTMENT_GEN", sequenceName = "reg_client_appointment_id_seq", allocationSize = 1, schema = "public")
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "REG_CLIENT_APPOINTMENT_GEN")
        private Long id;

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "id_type_appointment", referencedColumnName = "id")
        private ClsTypeAppointment clsTypeAppointment;

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "id_manager", referencedColumnName = "id")
        private ClsManagers clsManager;

        @Column(name = "time")
        private Time time;

        @Column(name = "text_time_appointment")
        private String textTimeAppointment;

        @Column(name = "client_name")
        private String clientName;

        @Column(name = "inn")
        private String inn;

        @Column(name = "phone_number")
        private String phoneNumber;

        @Column(name = "email")
        private String email;

        @Column(name = "message")
        private String message;

        @Column(name = "changed_by_admin")
        private Boolean changedByAdmin;

        @Column(name = "date")
        private Date date;
}
