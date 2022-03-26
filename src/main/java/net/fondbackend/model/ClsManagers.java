package net.fondbackend.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "cls_managers", schema = "public")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder(toBuilder = true)
public class ClsManagers {

  @Id
  @Column(name = "id", nullable = false)
  @SequenceGenerator(name = "CLS_MANAGERS_SEQ_GEN", sequenceName = "cls_managersr_id_seq", allocationSize = 1, schema = "public")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CLS_MANAGERS_SEQ_GEN")
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "is_deleted")
  private Boolean isDeleted;

  @Column(name = "is_hidden")
  private Boolean isHidden;

  @Column(name = "time_create")
  private Timestamp timeCreate;

}
