package com.brilife.backend.controllers;

import java.lang.reflect.Type;
import java.util.List;

import com.brilife.backend.entities.Province;
import com.brilife.backend.models.PageableList;
import com.brilife.backend.models.ProvinceModel;
import com.brilife.backend.models.ResponseMessage;
import com.brilife.backend.services.ProvinceService;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/provinces")
public class ProvinceController {
    @Autowired
    private ProvinceService service;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public ResponseMessage<PageableList<ProvinceModel>> getAllProvince(
        @RequestParam(required = false) String q,
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "20") int size,
        @RequestParam(defaultValue = "ASC") String sort
    ) {
        Direction direction = Direction
            .fromOptionalString(sort)
            .orElse(Direction.ASC);
        Province province = new Province(q);
        Page<Province> provincePage = service.findAllByExample(
            province,
            page,
            size,
            direction
        );
        List<Province> provinces = provincePage.toList();

        Type type = new TypeToken<List<ProvinceModel>>() {}.getType();
        List<ProvinceModel> provinceModels = modelMapper.map(provinces, type);
        PageableList<ProvinceModel> list = new PageableList<>(
            provinceModels,
            provincePage.getTotalElements()
        );
        return ResponseMessage.ok(list);
    }
}