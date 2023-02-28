package lk.gov.nw.cs.EmployeeManagement.repository;

import lk.gov.nw.cs.EmployeeManagement.entity.Location;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface LocationRepository extends JpaRepository<Location,Integer> {
    Page<Location> findAllByProvinceEqualsIgnoreCase(String parameter, PageRequest of);

    Page<Location> findAllByDistrictEqualsIgnoreCase(String parameter, PageRequest of);

    Page<Location> findAllByAgaDivisionLikeIgnoreCase(String parameter, PageRequest of);
    Page<Location> findAllByGnDivisionLikeIgnoreCase(String parameter, PageRequest of);
    Page<Location> findAllByVillageAurStreetLikeIgnoreCase(String parameter, PageRequest of);

}
