package org.vrlab.chemistrydatabase.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vrlab.chemistrydatabase.entity.MaterialEntity;
import org.vrlab.chemistrydatabase.mapper.MaterialMapper;
import org.vrlab.chemistrydatabase.service.MaterialService;

import java.util.List;


@Service
public class MaterialServiceImpl implements MaterialService {

    @Autowired
    private MaterialMapper materialMapper;
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

}
