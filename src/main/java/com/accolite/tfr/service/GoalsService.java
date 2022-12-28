package com.accolite.tfr.service;

import com.accolite.tfr.dto.GoalsDto;
import com.accolite.tfr.model.Goals;

public interface GoalsService {

    public Goals addGoals(GoalsDto orgDto);
    public GoalsDto mapToDto(Goals org);
    public Goals mapToEntity(GoalsDto od);

}
