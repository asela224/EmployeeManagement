package lk.gov.nw.cs.EmployeeManagement.entity;


import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.Set;

    @Table( name = "tbl_location",
            uniqueConstraints = {
            @UniqueConstraint(name = "uniqueLocation",columnNames = {"province","district","aga_diviion","gn_division","village_or_street"})
            }
    )
    @Entity
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @TypeDefs({
            @TypeDef(name = "json",
                    typeClass = JsonType.class)
    })


    public class Location {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int locationId;

        @Column(name = "province",nullable = false)
        private String province;
        @Column(name = "district",nullable = false)
        private String district;

        @Column(name = "aga_diviion",nullable = false)
        private String agaDivision;

        @Column(name = "gn_division",nullable = false)
        private String gnDivision;

        @Column(name = "village_or_street",nullable = false)
        private String villageOrStreet;

        @OneToMany(mappedBy = "location")
        private Set<EmployeePersonal> employeePersonalSet;

        @OneToMany(mappedBy = "location")
        private Set<Institute> instituteSet;

}
