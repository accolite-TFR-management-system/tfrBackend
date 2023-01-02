package com.accolite.tfr.DTOmodel;

import com.accolite.tfr.model.Resource;
import com.accolite.tfr.model.ResourceHistory;
import lombok.Data;
import java.util.List;

@Data
public class DesignationModel {

    private int id;

    private String designation_name;

    private int designation_code;

    private List<ResourceHistory> ResourceHistoryList;

    private List<Resource> ResourceList;

}
