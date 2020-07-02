package com.brilife.backend.services;

import com.brilife.backend.entities.Usage;
import com.brilife.backend.models.UsageReport;

public interface UsageService extends CommonService<Usage, Integer> {
    UsageReport getReport();
}