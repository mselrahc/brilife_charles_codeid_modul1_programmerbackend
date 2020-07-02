package com.brilife.backend.controllers;

import java.util.List;

import javax.validation.Valid;

import com.brilife.backend.entities.Usage;
import com.brilife.backend.models.ResponseMessage;
import com.brilife.backend.models.UsageModel;
import com.brilife.backend.models.UsageReport;
import com.brilife.backend.services.UsageService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("usages")
@Validated
public class UsageController {
    @Autowired
    private UsageService service;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/report")
    public ResponseMessage<List<UsageReport.ProvinceEntry>> getReport() {
        return ResponseMessage.ok(service.getReport().convert());
    }

    @PostMapping
    public ResponseMessage<UsageModel> add(@RequestBody @Valid UsageModel model) {
        Usage usage = service.save(modelMapper.map(model, Usage.class));
        UsageModel data = modelMapper.map(usage, UsageModel.class);
        return ResponseMessage.ok(data);
      }
}