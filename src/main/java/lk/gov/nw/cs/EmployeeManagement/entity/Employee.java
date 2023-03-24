package lk.gov.nw.cs.EmployeeManagement.entity;


import com.vladmihalcea.hibernate.type.json.JsonType;

import lk.gov.nw.cs.EmployeeManagement.util.previousInstitute;
import lombok.*;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Table(name = "tbl_employee")
@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@TypeDefs({
        @TypeDef(name = "json",
                typeClass = JsonType.class)
})

public class Employee {

    @Id

    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="emp_id_seq")
    @SequenceGenerator(name="emp_id_seq", sequenceName="seq_emp_id", allocationSize=1)

    @Column(name = "employee_id")
    private int employeeId;

    @Column(name = "employee_name",nullable = false)
    private String name;

    @Column(name = "nic",nullable = false)
    private String nic;

    @Column(name = "designation",nullable = false)
    private String designation;

    @Column(name = "appointed_date_to_position")
    @Temporal(TemporalType.DATE)
   // @CreationTimestamp

    private Date appointedDateToCurrentDesignation;

    @Column(name = "transfer_date_to_position")
    @Temporal(TemporalType.DATE)
    private Date transferDateToCurrentPermanentWorkPlace;


    @ManyToOne
    @JoinColumn(name = "current_institute",foreignKey = @ForeignKey(name = "FK_Employee_Current_Institute") )
    private Institute currentInstitute;


    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
    private EmployeePersonal employeePersonal;

    @Column(name = "previous_institutes", columnDefinition = "json")
    @Type(type = "json")
    private List<previousInstitute> previousInstituteList;

}
