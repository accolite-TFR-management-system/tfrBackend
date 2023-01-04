package com.accolite.tfr.controller;


import com.accolite.tfr.DTO.OrganisationDTO;
import com.accolite.tfr.model.Organisation;
import com.accolite.tfr.DTOmodel.OrganisationModel;
import com.accolite.tfr.repository.OrganisationRepository;
import com.accolite.tfr.service.OrganisationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/tfr")
public class OrganisationController {

    @Autowired
    private OrganisationRepository organisationRepository;
    @Autowired
    public OrganisationService organisationService;
    @Autowired(required = false)
    public OrganisationDTO organisationDTO;

    @PostMapping("/addDivision")
    private ResponseEntity<OrganisationModel> addOrganisation(@RequestBody OrganisationModel organisationModel) {
        Organisation organisation = this.organisationService.addOrganisation(organisationModel);
        OrganisationModel organisationModel1 = this.organisationDTO.entityToModel(organisation);
        return ResponseEntity.ok().body(organisationModel1);
    }
}
