package org.vrlab.chemistrydatabase.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.vrlab.chemistrydatabase.entity.MaterialTypeEntity;

import java.util.List;

@Mapper
public interface MaterialTypeMapper {
    List<MaterialTypeEntity> findAll();
    MaterialTypeEntity findById(Integer id);
}
