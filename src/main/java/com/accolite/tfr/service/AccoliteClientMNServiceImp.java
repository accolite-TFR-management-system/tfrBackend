package com.accolite.tfr.service;

import com.accolite.tfr.DTOmodel.AccoliteClientMNModel;
import com.accolite.tfr.model.AccoliteClientMN;
import com.accolite.tfr.repository.AccoliteClientMNRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccoliteClientMNServiceImp implements AccoliteClientMNService{
    @Autowired
    private AccoliteClientMNRepository accoliteClientMNRepository;
    @Autowired
    public ModelMapper modelMapper;

    public AccoliteClientMN addAccoliteClientMN(AccoliteClientMNModel accoliteClientMNModel) {
        AccoliteClientMN accoliteClientMN = this.mapToEntity(accoliteClientMNModel);
        return this.accoliteClientMNRepository.save(accoliteClientMN);
    }

    public AccoliteClientMNModel mapToDto(AccoliteClientMN org) {
        AccoliteClientMNModel od = modelMapper.map(org, AccoliteClientMNModel.class);
        return od;
    }

    public AccoliteClientMN mapToEntity(AccoliteClientMNModel od) {
        AccoliteClientMN org = modelMapper.map(od, AccoliteClientMN.class);
        return org;
    }
}
