package com.brilife.backend.services.impl;

import com.brilife.backend.entities.Province;
import com.brilife.backend.repositories.ProvinceRepository;
import com.brilife.backend.services.ProvinceService;

import org.springframework.stereotype.Service;

@Service
public class ProvinceServiceImpl extends CommonServiceImpl<Province, Integer, ProvinceRepository> implements ProvinceService {
    
}