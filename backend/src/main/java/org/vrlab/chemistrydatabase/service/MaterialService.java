package org.vrlab.chemistrydatabase.service;

import org.vrlab.chemistrydatabase.entity.MaterialEntity;
import org.vrlab.chemistrydatabase.model.KeyValueModel;

import java.util.List;

public interface MaterialService {
    List<MaterialEntity> findAll();
    List<MaterialEntity> findByTypeID(Integer typeId);
    Integer getMaterialCount();
    Integer getMaterialCountByTypeID(Integer typeId);
    List<MaterialEntity> findAllPagination(Integer offset, Integer limit);
    List<MaterialEntity> findByTypeIDPagination(Integer typeId, Integer offset, Integer limit);
    List<MaterialEntity> search(String keyword);
    List<KeyValueModel> getMaterialTypeCount();
}
