package org.vrlab.chemistrydatabase.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.vrlab.chemistrydatabase.entity.MaterialEntity;

import java.util.List;

@Mapper
public interface MaterialMapper {
    /**
     * 查询所有材料
     * @return 材料列表
     */
    List<MaterialEntity> findAll();
    /**
     * 根据材料类型ID查询材料
     * @param typeId 材料类型ID
     * @return 材料列表
     */
    List<MaterialEntity> findByTypeID(Integer typeId);
    /**
     * 查询材料总数
     * @return 材料总数
     */
    Integer getMaterialCount();
    /**
     * 根据材料类型ID查询材料总数
     * @param typeId 材料类型ID
     * @return 材料总数
     */
    Integer getMaterialCountByTypeID(Integer typeId);
    /**
     * 分页查询所有材料
     * @param offset 偏移量
     * @param limit 限制量
     * @return 材料列表
     */
    List<MaterialEntity> findAllPagination(Integer offset, Integer limit);
    /**
     * 根据材料类型ID分页查询材料
     * @param typeId 材料类型ID
     * @param offset 偏移量
     * @param limit 限制量
     * @return 材料列表
     */
    List<MaterialEntity> findByTypeIDPagination(Integer typeId, Integer offset, Integer limit);
    /**
     * 根据关键字查询材料
     * @param keyword 关键字
     * @return 材料列表
     */
    List<MaterialEntity> search(String keyword);
    List<MaterialEntity> searchPagination(String keyword, Integer offset, Integer limit);
    Integer getSearchedMaterialCount(String keyword);
}
