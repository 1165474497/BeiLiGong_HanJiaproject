package org.vrlab.chemistrydatabase.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MaterialResultEntity {
    private Integer id;
    private String name_cn;
    private String name_zh;
    private String abbreviation;
    private String cas;
    private String material_type;
    private String molecular_formula;
    private String molecular_weight;
}
