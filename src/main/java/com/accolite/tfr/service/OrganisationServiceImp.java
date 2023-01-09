package com.accolite.tfr.service;

import com.accolite.tfr.DTO.OrganisationDTO;
import com.accolite.tfr.DTOmodel.OrganisationModel;
import com.accolite.tfr.exception.Exception;
import com.accolite.tfr.model.Organisation;
import com.accolite.tfr.repository.OrganisationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrganisationServiceImp implements OrganisationService{
    @Autowired
    private OrganisationRepository organisationRepository;
    @Autowired(required = false)
    public OrganisationDTO organisationDTO;

    public Organisation addOrganisation(OrganisationModel od) {
        Organisation organisation = organisationDTO.modelToEntity(od);
        return this.organisationRepository.save(organisation);
    }

    public Organisation getOrganisation(int org_id) {
        Optional<Organisation> org=this.organisationRepository.findById(org_id);
        if(org.isPresent()) {
            return org.get();
        }
        else{
            throw new Exception("User didn't found with ID: " + org_id);
        }
    }
    
    public List<Organisation> getdivision(String div){
    	return this.organisationRepository.FindbyDepartment_type(div);
    }
    
    public List<Organisation> getsupdept(String div){
    	return this.organisationRepository.Findbysuperdept(div);
    }
    
    public List<Organisation> getdept(String div){
    	return this.organisationRepository.Findbydept(div);
    }
    
    
}
