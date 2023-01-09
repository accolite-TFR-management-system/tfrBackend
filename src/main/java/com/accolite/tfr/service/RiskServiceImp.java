package com.accolite.tfr.service;

import com.accolite.tfr.DTO.RiskDTO;
import com.accolite.tfr.DTOmodel.RiskModel;
import com.accolite.tfr.exception.Exception;
import com.accolite.tfr.model.Project;
import com.accolite.tfr.model.Risk;
import com.accolite.tfr.repository.ProjectRepository;
import com.accolite.tfr.repository.RiskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.Comparator.nullsLast;

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
                list.sort(nullsLast(Comparator.comparing(Risk::getRisk_mitigation)));
                return newList.get();
            } else {
                throw new Exception("Risk  not found");
            }
        }
        else {
            throw new Exception("project not found");
        }
    }

    public ResponseEntity<?> updateRisk(int riskId, Map<Object, Object> fields) {
        Optional<Risk> getRisk = this.riskRepository.findById(riskId);
        if(getRisk.isPresent()){
            fields.forEach((key,value)->{
                Field field = ReflectionUtils.findField(Risk.class,(String) key);
                field.setAccessible(true);
                ReflectionUtils.setField(field,getRisk.get(),value);
            });
            Risk updatedRisk = this.riskRepository.save(getRisk.get());
            RiskModel riskModel=this.riskDTO.entityToModel(updatedRisk);
            return new ResponseEntity<>(updatedRisk, HttpStatus.OK);
        }
        else {
            throw new Exception("Risk not found");
        }
    }
}
