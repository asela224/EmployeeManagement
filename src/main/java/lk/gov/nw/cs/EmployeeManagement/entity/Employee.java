package lk.gov.nw.cs.EmployeeManagement.entity;


import com.vladmihalcea.hibernate.type.json.JsonType;

import lk.gov.nw.cs.EmployeeManagement.util.previousInstitute;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Table(name = "tbl_employee")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@TypeDefs({
        @TypeDef(name = "json",
                typeClass = JsonType.class)
})

public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private int employeeId;

    @Column(name = "employee_name",nullable = false)
    private String name;

    @Column(name = "nic",nullable = false)
    private String nic;

    @Column(name = "designation",nullable = false)
    private String designation;

    @Column(name = "appointed_date_to_position")
    private Date appointedDateToCurrentDesignation;

    @Column(name = "transfer_date_to_position")
    private Date transferDateToCurrentPermanentWorkPlace;


    @ManyToOne
    @JoinColumn(name = "current_institute" )
    private Institute currentInstitute;


    @OneToOne(mappedBy = "employee")
    private EmployeePersonal employeePersonal;

    @Column(name = "previous_institutes", columnDefinition = "json")
    @Type(type = "json")
    private List<previousInstitute> previousInstituteList;

}
