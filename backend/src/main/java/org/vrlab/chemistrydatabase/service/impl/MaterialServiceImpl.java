package org.vrlab.chemistrydatabase.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vrlab.chemistrydatabase.entity.MaterialEntity;
import org.vrlab.chemistrydatabase.entity.MaterialTypeEntity;
import org.vrlab.chemistrydatabase.mapper.MaterialMapper;
import org.vrlab.chemistrydatabase.mapper.MaterialTypeMapper;
import org.vrlab.chemistrydatabase.model.KeyValueModel;
import org.vrlab.chemistrydatabase.service.MaterialService;

import java.util.ArrayList;
import java.util.List;


@Service
public class MaterialServiceImpl implements MaterialService {

    @Autowired
    private MaterialMapper materialMapper;
    @Autowired
    private MaterialTypeMapper materialTypeMapper;
    @Override
    public List<MaterialEntity> findAll() {
        return materialMapper.findAll();
    }

    @Override
    public List<MaterialEntity> findByTypeID(Integer typeId) {
        return materialMapper.findByTypeID(typeId);
    }

    @Override
    public Integer getMaterialCount() {
        return materialMapper.getMaterialCount();
    }

    @Override
    public Integer getMaterialCountByTypeID(Integer typeId) {
        return materialMapper.getMaterialCountByTypeID(typeId);
    }

    @Override
    public List<MaterialEntity> findAllPagination(Integer page, Integer size) {
        Integer offset = (page - 1) * size;
        return materialMapper.findAllPagination(offset, size);
    }

    @Override
    public List<MaterialEntity> findByTypeIDPagination(Integer typeId, Integer page, Integer size) {
        Integer offset = (page - 1) * size;
        return materialMapper.findByTypeIDPagination(typeId, offset, size);
    }

    @Override
    public List<MaterialEntity> search(String keyword) {
        keyword = "%" + keyword + "%";
        return materialMapper.search(keyword);
    }

    @Override
    public List<MaterialEntity> searchPagination(String keyword, Integer page, Integer size) {
        Integer offset = (page - 1) * size;
        keyword = "%" + keyword + "%";
        return materialMapper.searchPagination(keyword, offset, size);
    }

    @Override
    public List<KeyValueModel> getMaterialTypeCount() {
        List<KeyValueModel> keyValueModelList = new ArrayList<>();
        List<MaterialTypeEntity> materialTypeEntityList = materialTypeMapper.findAll();
        for (MaterialTypeEntity materialTypeEntity : materialTypeEntityList) {
            Integer typeId = materialTypeEntity.getId();
            String type = materialTypeEntity.getMaterial_type();
            Integer count = materialMapper.getMaterialCountByTypeID(typeId);
            KeyValueModel keyValueModel = new KeyValueModel(materialTypeEntity.getId(),type, String.valueOf(count));
            keyValueModelList.add(keyValueModel);
        }
        return keyValueModelList;
    }

}
