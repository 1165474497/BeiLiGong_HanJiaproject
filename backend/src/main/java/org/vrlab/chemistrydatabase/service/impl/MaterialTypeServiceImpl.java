package org.vrlab.chemistrydatabase.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vrlab.chemistrydatabase.entity.MaterialTypeEntity;
import org.vrlab.chemistrydatabase.mapper.MaterialTypeMapper;
import org.vrlab.chemistrydatabase.service.MaterialTypeService;

import java.util.List;

@Service
public class MaterialTypeServiceImpl implements MaterialTypeService {

    @Autowired
    private MaterialTypeMapper materialTypeMapper;

    @Override
    public List<MaterialTypeEntity> findAll() {
        return materialTypeMapper.findAll();
    }

    @Override
    public MaterialTypeEntity findById(Integer id) {
        return materialTypeMapper.findById(id);
    }
}
