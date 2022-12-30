package com.accolite.tfr.DTOmodel;

import com.accolite.tfr.entity.Resource;
import com.accolite.tfr.entity.ResourceHistory;
import lombok.Data;
import java.util.List;

@Data
public class DesignationModel {

    private int id;

    private String designation_name;

    private int designation_code;

    private List<Resource> ResourceList;

    private List<ResourceHistory> ResourceHistoryList;

}
