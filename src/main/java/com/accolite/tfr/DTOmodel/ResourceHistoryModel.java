package com.accolite.tfr.DTOmodel;

import com.accolite.tfr.entity.Designation;
import com.accolite.tfr.entity.Project;
import com.accolite.tfr.entity.Resource;
import lombok.Data;

import java.util.Date;

@Data
public class ResourceHistoryModel {

    private int id;

    private Resource ResourceIdForHistory;

    private Date start_date;

    private Date end_date;

    private String remark;

    private  Date date_of_add;

    private Designation ResourceHistoryList;

    private Resource  ResourceHistorycreatedBy;

    private Project ResourceHistoryProject;

}
