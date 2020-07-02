package com.brilife.backend.services.impl;

import com.brilife.backend.entities.Contraception;
import com.brilife.backend.repositories.ContraceptionRepository;
import com.brilife.backend.services.ContraceptionService;

import org.springframework.stereotype.Service;

@Service
public class ContraceptionServiceImpl extends CommonServiceImpl<Contraception, Integer, ContraceptionRepository> implements ContraceptionService {
    
}