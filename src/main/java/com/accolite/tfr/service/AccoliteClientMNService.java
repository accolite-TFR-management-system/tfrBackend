package com.accolite.tfr.service;

import com.accolite.tfr.DTOmodel.AccoliteClientMNModel;
import com.accolite.tfr.model.AccoliteClientMN;

public interface AccoliteClientMNService {
    public AccoliteClientMN addAccoliteClientMN(AccoliteClientMNModel accoliteClientMNModel);
    public AccoliteClientMNModel mapToDto(AccoliteClientMN org);
    public AccoliteClientMN mapToEntity(AccoliteClientMNModel dto);
}
