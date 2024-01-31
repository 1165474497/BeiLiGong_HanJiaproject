package org.vrlab.chemistrydatabase.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.vrlab.chemistrydatabase.model.Result;
import org.vrlab.chemistrydatabase.service.impl.MaterialTypeServiceImpl;

@RestController
@Slf4j
@RequestMapping("/materialtype")
public class MaterialTypeController {

    @Autowired
    private MaterialTypeServiceImpl materialTypeService;

    @GetMapping("/all")
    private Result findAll() {
        return Result.success(materialTypeService.findAll(), "查询成功");
    }

    @GetMapping("/{id}")
    private Result findById(@PathVariable Integer id) {
        return Result.success(materialTypeService.findById(id), "查询成功");
    }
}
