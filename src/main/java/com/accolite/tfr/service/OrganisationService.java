package com.accolite.tfr.service;


import com.accolite.tfr.dto.OrganisationDto;
import com.accolite.tfr.model.Organisation;


public interface OrganisationService {
    public Organisation addOrganisation(OrganisationDto od);
    public OrganisationDto mapToDto(Organisation org);
    public Organisation mapToEntity(OrganisationDto od);
    public Organisation getOrganisation(int org_id);
}
