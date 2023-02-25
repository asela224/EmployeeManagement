package lk.gov.nw.cs.EmployeeManagement.entity;


import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.List;

@Table(name = "tbl_employee_personal")
    @Entity
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @TypeDefs({
            @TypeDef(name = "json", typeClass = JsonType.class)
    })
    public class EmployeePersonal {


         @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int employeeId;

        @Column(name = "permanent_address")
        private String permanentAddress;


        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "location_id")
        private Location location;

        @Type(type = "json")
        @Column(columnDefinition = "json")
        private List<String> contactNumbers;


        @OneToOne
        @JoinColumn(name = "employee_personal_data_id")
        private Employee employee;

    }