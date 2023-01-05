package com.accolite.tfr.service;


import com.accolite.tfr.DTOmodel.OrganisationModel;
import com.accolite.tfr.model.Organisation;

import java.util.List;


public interface OrganisationService {
    public Organisation addOrganisation(OrganisationModel od);
    public Organisation getOrganisation(int org_id);

    List<Organisation> getAllDiv();

    List<Organisation> getAllSupDep();
}
