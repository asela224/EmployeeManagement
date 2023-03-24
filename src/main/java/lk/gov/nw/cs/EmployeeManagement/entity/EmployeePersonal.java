package lk.gov.nw.cs.EmployeeManagement.entity;


import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.*;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.List;

@Table(name = "tbl_employee_personal")
    @Entity
@Getter
@Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @TypeDefs({
            @TypeDef(name = "json", typeClass = JsonType.class)
    })
    public class EmployeePersonal {


         @Id
         @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="emp_id_seq")
         @SequenceGenerator(name="emp_id_seq", sequenceName="seq_emp_personal_id", allocationSize=1)

        private int employeeId;

        @Column(name = "permanent_address")
        private String permanentAddress;


        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "location_id",foreignKey = @ForeignKey(name = "FK_Employee_Location_ID"))
        private Location location;

        @Type(type = "json")
        @Column(columnDefinition = "json")
        private List<String> contactNumbers;


        @OneToOne
        @JoinColumn(name = "employee_personal_data_id",foreignKey = @ForeignKey(name = "FK_Employee_ID_for_Personal"))
        private Employee employee;

    }