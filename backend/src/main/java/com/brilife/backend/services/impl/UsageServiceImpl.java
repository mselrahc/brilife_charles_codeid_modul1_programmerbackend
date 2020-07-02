package com.brilife.backend.services.impl;

import java.util.List;

import com.brilife.backend.entities.Contraception;
import com.brilife.backend.entities.Province;
import com.brilife.backend.entities.Usage;
import com.brilife.backend.models.UsageReport;
import com.brilife.backend.repositories.ContraceptionRepository;
import com.brilife.backend.repositories.ProvinceRepository;
import com.brilife.backend.repositories.UsageRepository;
import com.brilife.backend.services.UsageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsageServiceImpl extends CommonServiceImpl<Usage, Integer, UsageRepository> implements UsageService {
    @Autowired
    private ProvinceRepository provinceRepository;

    @Autowired
    private ContraceptionRepository contraceptionRepository;

	@Override
	public UsageReport getReport() {
        List<Province> provinces = provinceRepository.findAll();
        List<Contraception> contraceptions = contraceptionRepository.findAll();
        UsageReport report = new UsageReport(provinces, contraceptions);
        
        List<Usage> usages = getRepository().findAll();
        report.addUsages(usages);

		return report;
	}
    
}