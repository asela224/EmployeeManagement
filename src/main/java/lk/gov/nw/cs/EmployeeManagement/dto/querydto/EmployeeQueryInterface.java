package lk.gov.nw.cs.EmployeeManagement.dto.querydto;

import lk.gov.nw.cs.EmployeeManagement.entity.Institute;
import lk.gov.nw.cs.EmployeeManagement.util.previousInstitute;

import java.util.List;

public interface EmployeeQueryInterface {
     int getEmployeeId();
     String getName();
     String getNic();
     String getDesignation();
     List<previousInstitute> getPreviousInstituteList();
     String getPermanentAddress();
     String getInstituteName();
     List<String> getContactNumbers();
     String getProvince();
     String getDistrict();
     String getAgaDivision();
     String getGnDivision();
     String getVillageAurStreet();

}
