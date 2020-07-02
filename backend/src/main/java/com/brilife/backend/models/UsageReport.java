package com.brilife.backend.models;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.brilife.backend.entities.Contraception;
import com.brilife.backend.entities.Province;
import com.brilife.backend.entities.Usage;
import com.brilife.backend.models.UsageReport.ProvinceEntry.ContraceptionEntry;

import org.modelmapper.ModelMapper;

public class UsageReport {
    public static class ProvinceEntry {
        public static class ContraceptionEntry {
            ContraceptionModel contraception;
            Integer count;
            ContraceptionEntry(ContraceptionModel contraception, Integer count) {
                this.contraception = contraception;
                this.count = count;
            }
            public ContraceptionModel getContraception() {
                return contraception;
            }
            public Integer getCount() {
                return count;
            }
        }
        ProvinceModel province;
        List<ContraceptionEntry> contraceptions;
        Integer count;
        ProvinceEntry(ProvinceModel province, List<ContraceptionEntry> contraceptions, Integer count) {
            this.province = province;
            this.contraceptions = contraceptions;
            this.count = count;
        }
        public ProvinceModel getProvince() {
            return province;
        }
        public List<ContraceptionEntry> getContraceptions() {
            return contraceptions;
        }
        public Integer getCount() {
            return count;
        }
    }
    private Map<Province, Map<Contraception, Integer>> data;
    private ModelMapper modelMapper = new ModelMapper();

    public UsageReport(List<Province> provinces, List<Contraception> contraceptions) {
        this.data = provinces.stream().collect(Collectors.toMap(province -> province, province -> {
            return contraceptions.stream().collect(Collectors.toMap(contraception -> contraception, contraception -> 0));
        }));
    }

    public Map<Province, Map<Contraception, Integer>> addUsages(List<Usage> usages) {
        for (Usage usage : usages) {
            Map<Contraception, Integer> cMap = data.get(usage.getProvince());
            if (cMap != null) {
                Integer count = cMap.get(usage.getContraception());
                if (count != null) {
                    cMap.put(usage.getContraception(), count + usage.getCount());
                }
            }
        }
        return this.data;
    }

    public Map<Province, Map<Contraception, Integer>> getData() {
        return this.data;
    }

    public void setData(Map<Province, Map<Contraception, Integer>>  data) {
        this.data = data;
    }

    public List<ProvinceEntry> convert() {
        List<ProvinceEntry> report = new ArrayList<>();

        for (Map.Entry<Province, Map<Contraception, Integer>> row : this.data.entrySet()) {
            ProvinceModel province = modelMapper.map(row.getKey(), ProvinceModel.class);
            List<ContraceptionEntry> contraceptions = new ArrayList<>();
            Integer sum = 0;
            for (Map.Entry<Contraception, Integer> entry : row.getValue().entrySet()) {
                ContraceptionModel contraception = modelMapper.map(entry.getKey(), ContraceptionModel.class);
                contraceptions.add(new ContraceptionEntry(contraception, entry.getValue()));
                sum += entry.getValue();
            }
            contraceptions.sort(Comparator.comparingInt(entry -> entry.getContraception().getId()));
            report.add(new ProvinceEntry(province, contraceptions, sum));
        }
        report.sort(Comparator.comparingInt(entry -> entry.getProvince().getId()));
        return report;
    }
}