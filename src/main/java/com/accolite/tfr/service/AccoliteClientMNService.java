package com.accolite.tfr.service;

public interface AccoliteClientMNService {
    public AccoliteClientMN addAccoliteClientMN(AccoliteClientMNModel accoliteClientMNModel);
    public AccoliteClientMNModel mapToDto(AccoliteClientMN org);
    public AccoliteClientMN mapToEntity(AccoliteClientMNModel dto);
}
