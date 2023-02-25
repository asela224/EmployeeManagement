package lk.gov.nw.cs.EmployeeManagement.entity;


import lk.gov.nw.cs.EmployeeManagement.util.enums.InstituteType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Table(name = "tbl_institute")
    @Entity
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class Institute {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "institute_id")
        private int instituteId;

        @Column(name = "institute_name", nullable = false)
        private String instituteName;

        @Column(name = "institute_oic", nullable = false)
        private String oic;

        @Enumerated(EnumType.STRING) @Column(name = "institute_type")
        private InstituteType instituteType;


        private boolean activeStatus;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "parent_institute_id")
        private Institute parentInstituteId;

        @OneToMany(fetch = FetchType.LAZY,mappedBy = "parentInstituteId")
        private Set<Institute> childInstituteSet;


      @OneToMany(mappedBy = "currentInstitute")
        private Set<Employee> employeeSetOfInstitute;

      @JoinColumn(name = "location_id")
      @ManyToOne
      private Location location;



}
