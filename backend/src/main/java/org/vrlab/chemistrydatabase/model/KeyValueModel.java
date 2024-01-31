package org.vrlab.chemistrydatabase.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KeyValueModel {
    private Integer id;
    private String name;
    private String value;
}
