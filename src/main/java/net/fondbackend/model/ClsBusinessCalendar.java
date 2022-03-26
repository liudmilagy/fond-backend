package net.fondbackend.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "cls_business_calendar", schema = "public")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder(toBuilder = true)
public class ClsBusinessCalendar implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    @SequenceGenerator(name = "CLS_BUSINESS_CALENDAR_SEQ_GEN", sequenceName = "cls_business_calendar_id_seq", allocationSize = 1, schema = "public")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CLS_BUSINESS_CALENDAR_SEQ_GEN")
    private Long id;

    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "is_holiday")
    private Boolean isHoliday;

    @Column(name = "is_shortened")
    private Boolean isShortened;
}
