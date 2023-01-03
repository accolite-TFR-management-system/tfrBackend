package com.accolite.tfr.service;


import com.accolite.tfr.DTOmodel.RiskModel;
import com.accolite.tfr.model.Risk;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface RiskService {

    public Risk addRisk(RiskModel orgDto);

    public List<Risk> getRisk(int p_id);
    public ResponseEntity<?> updateRisk(int riskId, Map<Object, Object> fields);

}
