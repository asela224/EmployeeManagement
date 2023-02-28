package lk.gov.nw.cs.EmployeeManagement.entity;


import com.vladmihalcea.hibernate.type.json.JsonType;
import lk.gov.nw.cs.EmployeeManagement.util.enums.InstituteType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.Set;

@Table(name = "tbl_institute")
    @Entity
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @TypeDefs({
        @TypeDef(name = "json",
                typeClass = JsonType.class)
    })

    public class Institute {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "institute_id")
        private int instituteId;

        @Column(name = "institute_name", nullable = false)
        private String instituteName;

        @Column(name = "institute_oic", nullable = false)
        private String oic;

        @Column(name = "institute_postal_address", nullable = false)
        private String postalAddress;

        @Type(type = "json")
        @Column(name = "institute_contact_numbers", nullable = false,columnDefinition = "json")
        private String contactNumbers;

        @Column(name = "institute_email", nullable = false)
        private String email;



        @Enumerated(EnumType.STRING) @Column(name = "institute_type")
        private InstituteType instituteType;


        private boolean activeStatus;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "parent_institute_id")
        private Institute parentInstitute;

        @OneToMany(fetch = FetchType.LAZY,mappedBy = "parentInstitute")
        private Set<Institute> childInstituteSet;


      @OneToMany(mappedBy = "currentInstitute")
        private Set<Employee> employeeSetOfInstitute;

      @JoinColumn(name = "location_id")
      @ManyToOne
      private Location location;



}
