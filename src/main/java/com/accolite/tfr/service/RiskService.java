package com.accolite.tfr.service;


import com.accolite.tfr.DTOmodel.RiskModel;
import com.accolite.tfr.model.Risk;

import java.util.List;

public interface RiskService {

    public Risk addRisk(RiskModel orgDto);

    public List<Risk> getRisk(int p_id);
}
