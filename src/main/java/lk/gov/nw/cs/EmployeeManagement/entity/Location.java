package lk.gov.nw.cs.EmployeeManagement.entity;


import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.*;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

    @Table( name = "tbl_location",
            uniqueConstraints = {
            @UniqueConstraint(name = "uniqueLocation",columnNames = {"province","district","aga_diviion","gn_division","village_or_street"})
            }
    )
    @Entity
  @Getter @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @TypeDefs({
            @TypeDef(name = "json",
                    typeClass = JsonType.class)
    })
    @Builder

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
        private String villageAurStreet;

        @OneToMany(mappedBy = "location")
        private List<EmployeePersonal> employeePersonalSet;

        @OneToMany(mappedBy = "location")
        private List<Institute> instituteSet;

}
