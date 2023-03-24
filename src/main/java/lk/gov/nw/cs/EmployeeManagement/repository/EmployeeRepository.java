package lk.gov.nw.cs.EmployeeManagement.repository;

import lk.gov.nw.cs.EmployeeManagement.dto.querydto.EmployeeQueryDTO;
import lk.gov.nw.cs.EmployeeManagement.dto.querydto.EmployeeQueryInterface;
import lk.gov.nw.cs.EmployeeManagement.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    Optional<Employee> getEmployeeByNicEqualsIgnoreCase(String nic);

    boolean existsEmployeeByNicEqualsIgnoreCase(String nic);

  @Query( value = "" +
          "SELECT  employeeId, name,nic,designation,instituteName, " +
          "contactNumbers,permanentAddress,province,district,agaDivision,gnDivision,villageAurStreet,previousInstituteList " +
          "FROM " +
              "( " +
          "SELECT emp.employee_id as employeeId,emp.employee_name as name, emp.appointed_date_to_position as appointedDateToCurrentDesignation," +
              "emp.designation as designation,emp.nic as nic,emp.previous_institutes as previousInstituteList," +
              "emp.transfer_date_to_position as transferDateToCurrentPermanentWorkPlace,emp.current_institute as currentInstitute,personal.contact_numbers as contactNumbers," +

              "personal.permanent_address as permanentAddress,personal.employee_personal_data_id ,personal.location_id as perloc, " +

              "loc.location_id, loc.aga_diviion as agaDivision,loc.district as district,loc.gn_division as gnDivision,loc.province as province," +
              "loc.village_or_street as villageAurStreet," +

              "ins.institute_name as instituteName " +

          "From tbl_employee emp," +
                    "tbl_employee_personal personal," +
                    "tbl_location loc," +
                    "tbl_institute ins " +

          "WHERE " +
          "personal.employee_personal_data_id=emp.employee_id AND       " +
          "personal.location_id=loc.location_id AND       " +
          "ins.institute_id=emp.current_institute )AS Sub",
          nativeQuery = true)
  List<EmployeeQueryInterface>  getEmployeeList();


    @Query( value = "" +
            "SELECT  employeeId, name,nic,designation,instituteName, " +
            "contactNumbers,permanentAddress,province,district,agaDivision,gnDivision,villageAurStreet,previousInstituteList " +
            "FROM " +
            "( " +
            "SELECT emp.employee_id as employeeId,emp.employee_name as name, emp.appointed_date_to_position as appointedDateToCurrentDesignation," +
            "emp.designation as designation,emp.nic as nic,emp.previous_institutes as previousInstituteList," +
            "emp.transfer_date_to_position as transferDateToCurrentPermanentWorkPlace,emp.current_institute as currentInstitute,personal.contact_numbers as contactNumbers," +

            "personal.permanent_address as permanentAddress,personal.employee_personal_data_id ,personal.location_id as perloc, " +

            "loc.location_id, loc.aga_diviion as agaDivision,loc.district as district,loc.gn_division as gnDivision,loc.province as province," +
            "loc.village_or_street as villageAurStreet," +

            "ins.institute_name as instituteName " +

            "From tbl_employee emp," +
            "tbl_employee_personal personal," +
            "tbl_location loc," +
            "tbl_institute ins " +

            "WHERE " +
            "personal.employee_personal_data_id=emp.employee_id AND       " +
            "personal.location_id=loc.location_id AND       " +
            "ins.institute_id=emp.current_institute )AS Sub " +
            "/*#pageable*/",
            nativeQuery = true)
    Page<EmployeeQueryInterface> getEmployeePage(Pageable pageable);




}

