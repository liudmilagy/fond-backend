package net.fondbackend.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "cls_tab", schema = "public")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder(toBuilder = true)
public class ClsTab {

    @Id
    @Column(name = "id", nullable = false)
    @SequenceGenerator(name = "CLS_TAB_GEN", sequenceName = "cls_tab_id_seq", allocationSize = 1, schema = "public")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CLS_TAB_GEN")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @Column(name = "html_text")
    private String htmlText;
}