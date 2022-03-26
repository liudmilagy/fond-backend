package net.fondbackend.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "reg_time_type_appointment", schema = "public")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder(toBuilder = true)
public class RegTimeTypeAppointment {
        @Id
        @Column(name = "id", nullable = false)
        @SequenceGenerator(name = "REG_TIME_TYPE_APPOINTMENT_GEN", sequenceName = "reg_time_type_appointment_id_seq", allocationSize = 1, schema = "public")
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "REG_TIME_TYPE_APPOINTMENT_GEN")
        private Long id;

        @OneToOne
        @JoinColumn(name = "id_type_appointment", referencedColumnName = "id")
        private ClsTypeAppointment clsTypeAppointment;

        @Column(name = "time")
        private Time time;
}
