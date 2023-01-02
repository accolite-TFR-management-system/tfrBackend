package com.accolite.tfr.service;

import com.accolite.tfr.dto.AccoliteClientMNDto;
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

    public AccoliteClientMN addAccoliteCientMN(AccoliteClientMNDto accoliteClientMNDto) {
        AccoliteClientMN accoliteClientMN = this.mapToEntity(accoliteClientMNDto);
        return this.accoliteClientMNRepository.save(accoliteClientMN);
    }

    public AccoliteClientMNDto mapToDto(AccoliteClientMN org) {
        AccoliteClientMNDto od = modelMapper.map(org,AccoliteClientMNDto.class);
        return od;
    }

    public AccoliteClientMN mapToEntity(AccoliteClientMNDto od) {
        AccoliteClientMN org = modelMapper.map(od, AccoliteClientMN.class);
        return org;
    }
}
