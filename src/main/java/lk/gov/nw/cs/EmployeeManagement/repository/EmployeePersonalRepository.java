package lk.gov.nw.cs.EmployeeManagement.repository;

import lk.gov.nw.cs.EmployeeManagement.entity.EmployeePersonal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface EmployeePersonalRepository extends JpaRepository<EmployeePersonal,Integer> {
}
