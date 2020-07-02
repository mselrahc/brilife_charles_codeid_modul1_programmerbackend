package com.brilife.backend.controllers;

import java.lang.reflect.Type;
import java.util.List;

import com.brilife.backend.entities.Contraception;
import com.brilife.backend.models.PageableList;
import com.brilife.backend.models.ContraceptionModel;
import com.brilife.backend.models.ResponseMessage;
import com.brilife.backend.services.ContraceptionService;

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
@RequestMapping("/contraceptions")
public class ContraceptionController {
    @Autowired
    private ContraceptionService service;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public ResponseMessage<PageableList<ContraceptionModel>> getAllContraception(
        @RequestParam(required = false) String q,
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "20") int size,
        @RequestParam(defaultValue = "ASC") String sort
    ) {
        Direction direction = Direction
            .fromOptionalString(sort)
            .orElse(Direction.ASC);
        Contraception contraception = new Contraception(q);
        Page<Contraception> contraceptionPage = service.findAllByExample(
            contraception,
            page,
            size,
            direction
        );
        List<Contraception> contraceptions = contraceptionPage.toList();

        Type type = new TypeToken<List<ContraceptionModel>>() {}.getType();
        List<ContraceptionModel> contraceptionModels = modelMapper.map(contraceptions, type);
        PageableList<ContraceptionModel> list = new PageableList<>(
            contraceptionModels,
            contraceptionPage.getTotalElements()
        );
        return ResponseMessage.ok(list);
    }
}