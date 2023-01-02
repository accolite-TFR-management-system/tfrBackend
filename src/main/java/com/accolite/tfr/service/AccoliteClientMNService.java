package com.accolite.tfr.service;

import com.accolite.tfr.dto.AccoliteClientMNDto;
import com.accolite.tfr.dto.OrganisationDto;
import com.accolite.tfr.model.AccoliteClientMN;
import com.accolite.tfr.model.Organisation;

public interface AccoliteClientMNService {
    public AccoliteClientMN addAccoliteCientMN(AccoliteClientMNDto accoliteClientMNDto);
    public AccoliteClientMNDto mapToDto(AccoliteClientMN org);
    public AccoliteClientMN mapToEntity(AccoliteClientMNDto dto);
}
