package com.accolite.tfr.service;

import com.accolite.tfr.dto.OrganisationDto;
import com.accolite.tfr.exception.Exception;
import com.accolite.tfr.model.Organisation;
import com.accolite.tfr.repository.OrganisationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrganisationServiceImp implements OrganisationService{
    @Autowired
    private OrganisationRepository organisationRepository;
    @Autowired
    public ModelMapper modelMapper;

    public Organisation addOrganisation(OrganisationDto od) {
        Organisation organisation = this.mapToEntity(od);
        return this.organisationRepository.save(organisation);
    }

    public OrganisationDto mapToDto(Organisation org) {
        OrganisationDto od = modelMapper.map(org,OrganisationDto.class);
        return od;
    }

    public Organisation mapToEntity(OrganisationDto od) {
        Organisation org = modelMapper.map(od, Organisation.class);
        return org;
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
}
