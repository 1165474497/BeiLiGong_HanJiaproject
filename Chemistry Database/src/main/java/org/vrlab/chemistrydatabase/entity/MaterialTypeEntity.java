package org.vrlab.chemistrydatabase.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "cd_material_type")
public class MaterialTypeEntity {
    @Id
    private Integer id;
    @Column(name = "material_type")
    private String material_type;
    @Column(name = "describe")
    private String describe;
}
