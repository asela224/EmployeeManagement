package lk.gov.nw.cs.EmployeeManagement.repository;

import lk.gov.nw.cs.EmployeeManagement.entity.Location;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface LocationRepository extends JpaRepository<Location,Integer> {
    Page<Location> findAllByProvinceEqualsIgnoreCase(String parameter, PageRequest of);
    List<Location> findAllByProvinceLikeIgnoreCase(String parameter);

    Page<Location> findAllByDistrictEqualsIgnoreCase(String parameter, PageRequest of);
    List<Location> findAllByDistrictLikeIgnoreCase(String parameter);


    Page<Location> findAllByAgaDivisionLikeIgnoreCase(String parameter, PageRequest of);
    List<Location> findAllByAgaDivisionLikeIgnoreCase(String parameter);


    Page<Location> findAllByGnDivisionLikeIgnoreCase(String parameter, PageRequest of);
    List<Location> findAllByGnDivisionLikeIgnoreCase(String parameter);


    Page<Location> findAllByVillageAurStreetLikeIgnoreCase(String parameter, PageRequest of);
    List<Location> findAllByVillageAurStreetLikeIgnoreCase(String parameter);


}
