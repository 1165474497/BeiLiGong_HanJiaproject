package org.vrlab.chemistrydatabase.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "cd_raw_material")
public class MaterialEntity {
    @Id
    private Integer id;
    @Column(name = "name_cn")
    private String name_cn;
    @Column(name = "name_zh")
    private String name_zh;
    @Column(name = "abbreviation")
    private String abbreviation;
    @Column(name = "cas")
    private String cas;
    @Column(name = "material_type_id")
    private Integer material_type_id;
    @Column(name = "molecular_formula")
    private String molecular_formula;
    @Column(name = "molecular_weight")
    private String molecular_weight;
}
