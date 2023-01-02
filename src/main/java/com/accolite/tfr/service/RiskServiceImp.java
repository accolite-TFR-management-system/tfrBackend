package com.accolite.tfr.service;

import com.accolite.tfr.DTO.RiskDTO;
import com.accolite.tfr.DTOmodel.RiskModel;
import com.accolite.tfr.exception.Exception;
import com.accolite.tfr.model.Project;
import com.accolite.tfr.model.Risk;
import com.accolite.tfr.repository.ProjectRepository;
import com.accolite.tfr.repository.RiskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class RiskServiceImp implements RiskService{

    @Autowired
    private RiskRepository riskRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired(required = false)
    public RiskDTO riskDTO;

    public Risk addRisk(RiskModel od) {
        Risk risk = this.riskDTO.modelToEntity(od);
        return this.riskRepository.save(risk);
    }

    public List<Risk> getRisk(int p_id) {
        Optional<Project> newProject = Optional.ofNullable(this.projectRepository.findProjectById(p_id));
        if(newProject.isPresent()) {
            Optional<List<Risk>> newList = Optional.ofNullable(this.riskRepository.findRiskByProjectId(p_id));
            if (newList.isPresent()) {
                List<Risk> list = newList.get();
                list.sort(Comparator.comparing(Risk::getDate_of_add));
                return newList.get();
            } else {
                throw new Exception("Risk  not found");
            }
        }
        else {
            throw new Exception("project not found");
        }
    }
}
