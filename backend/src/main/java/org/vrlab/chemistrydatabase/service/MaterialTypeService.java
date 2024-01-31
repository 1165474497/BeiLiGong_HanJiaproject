package org.vrlab.chemistrydatabase.service;

import org.vrlab.chemistrydatabase.entity.MaterialTypeEntity;

import java.util.List;

public interface MaterialTypeService {
    List<MaterialTypeEntity> findAll();
    MaterialTypeEntity findById(Integer id);
}
