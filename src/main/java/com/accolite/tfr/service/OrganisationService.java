package com.accolite.tfr.service;


import java.util.List;

import com.accolite.tfr.DTOmodel.OrganisationModel;
import com.accolite.tfr.model.Organisation;


public interface OrganisationService {
    public Organisation addOrganisation(OrganisationModel od);
    public Organisation getOrganisation(int org_id);
    public List<Organisation> getdivision(String div);
    public List<Organisation> getsupdept(String div);
    public List<Organisation> getdept(String div);
}
