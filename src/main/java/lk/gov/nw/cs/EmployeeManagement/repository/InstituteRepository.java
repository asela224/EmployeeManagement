package lk.gov.nw.cs.EmployeeManagement.repository;

import lk.gov.nw.cs.EmployeeManagement.entity.Institute;
import lk.gov.nw.cs.EmployeeManagement.entity.Location;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
@EnableJpaRepositories
public interface InstituteRepository extends JpaRepository<Institute,Integer> {



    Page<Institute> findInstitutesByActiveStatusIsTrueAndLocationIn(List<Location> locations, Pageable pageable);
    int countDistinctByActiveStatusIsTrueAndLocationIn(List<Location> locations);
}
