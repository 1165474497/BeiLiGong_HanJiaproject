package org.vrlab.chemistrydatabase.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.vrlab.chemistrydatabase.entity.MaterialEntity;
import org.vrlab.chemistrydatabase.entity.MaterialResultEntity;
import org.vrlab.chemistrydatabase.model.Result;
import org.vrlab.chemistrydatabase.service.impl.MaterialServiceImpl;
import org.vrlab.chemistrydatabase.service.impl.MaterialTypeServiceImpl;
import org.vrlab.chemistrydatabase.utils.MaterialDataUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/material")
public class MaterialController {
    @Autowired
    private MaterialServiceImpl materialService;
    @Autowired
    private MaterialTypeServiceImpl materialTypeService;
    private MaterialResultEntity convertToMaterialResultEntity(MaterialEntity materialEntity) {
        Integer typeId = materialEntity.getMaterial_type_id();
        String type = materialTypeService.findById(typeId).getMaterial_type();
        return new MaterialResultEntity(
                materialEntity.getId(),
                materialEntity.getName_cn(),
                materialEntity.getName_zh(),
                materialEntity.getAbbreviation(),
                materialEntity.getCas(),
                type,
                materialEntity.getMolecular_formula(),
                materialEntity.getMolecular_weight()
        );
    }
    private List<MaterialResultEntity> convertToMaterialResultEntityList(List<MaterialEntity> materialEntityList) {
        List<MaterialResultEntity> materialResultEntityList = new ArrayList<>();
        for (MaterialEntity materialEntity : materialEntityList) {
            materialResultEntityList.add(convertToMaterialResultEntity(materialEntity));
        }
        return materialResultEntityList;
    }

    @GetMapping("/all")
    private Result findAll() {
        return Result.success(convertToMaterialResultEntityList(materialService.findAll()), "查询成功");
    }

    @GetMapping("/type/{id}")
    private Result findByType(@PathVariable Integer id) {
        return Result.success(convertToMaterialResultEntityList(materialService.findByTypeID(id)), "查询成功");
    }

    @GetMapping("/count")
    private Result getMaterialCount() {
        return Result.success(materialService.getMaterialCount(), "查询成功");
    }

    @GetMapping("/count/{id}")
    private Result getMaterialCountByTypeID(@PathVariable Integer id) {
        return Result.success(materialService.getMaterialCountByTypeID(id), "查询成功");
    }

    @GetMapping("/count/list")
    private Result getMaterialCountList() {
        return Result.success(materialService.getMaterialTypeCount(), "查询成功");
    }

    @PostMapping("/all")
    private Result findAllPagination(@RequestBody Map<String, Integer> data) {
        Integer page = data.get("page");
        Integer size = data.get("size");
        return Result.success(convertToMaterialResultEntityList(materialService.findAllPagination(page, size)), "查询成功");
    }

    @PostMapping("/type/{id}")
    private Result findByTypePagination(@PathVariable Integer id, @RequestBody Map<String, Integer> data) {
        Integer page = data.get("page");
        Integer size = data.get("size");
        return Result.success(convertToMaterialResultEntityList(materialService.findByTypeIDPagination(id, page, size)), "查询成功");
    }

    @PostMapping("/search")
    private Result search(@RequestBody Map<String, String> data) {
        String keyword = data.get("keyword");
        return Result.success(convertToMaterialResultEntityList(materialService.search(keyword)), "查询成功");
    }

    @PostMapping("/search/pagination")
    private Result searchPagination(@RequestBody Map<String, Object> data) {
        String keyword = (String) data.get("keyword");
        Integer page = (Integer) data.get("page");
        Integer size = (Integer) data.get("size");
        return Result.success(convertToMaterialResultEntityList(materialService.searchPagination(keyword, page, size)),String.valueOf( materialService.getSearchedMaterialCount(keyword)));
    }

    @GetMapping("/data/{cas}")
    private Result getMaterialData(@PathVariable String cas) {
        return Result.success(MaterialDataUtils.getMaterialData(cas), "查询成功");
    }
}
