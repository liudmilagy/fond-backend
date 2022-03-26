package net.fondbackend.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "general_table", schema = "public")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder(toBuilder = true)
public class GeneralTable {
    @Id
    @Column(name = "id", nullable = false)
    @SequenceGenerator(name = "GENERAL_TABLE_SEQ_GEN", sequenceName = "general_table_id_seq", allocationSize = 1, schema = "public")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GENERAL_TABLE_SEQ_GEN")
    private Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "int_value")
    private Integer intValue;

    @Column(name = "float_value")
    private Float floatValue;

    @Column(name = "string_value")
    private String stringValue;

    @Column(name = "boolean_value")
    private Boolean booleanValue;

    @Column(name = "file_id")
    private Long fileId;
}
