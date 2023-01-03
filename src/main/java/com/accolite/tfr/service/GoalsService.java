package com.accolite.tfr.service;

import com.accolite.tfr.DTOmodel.GoalsModel;
import com.accolite.tfr.model.Goals;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface GoalsService {

    public Goals addGoals(GoalsModel orgDto);

    public Goals getGoal(int g_id);

    public List<Goals> getGoals(int m_id);
    public ResponseEntity<?> updateGoals(int goalId, Map<Object, Object> fields);


}
