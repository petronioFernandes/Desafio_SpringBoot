package next.school.cesar.desafioSpring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import next.school.cesar.desafioSpring.entities.Insurance;

@Repository
public interface InsuranceRepository extends JpaRepository<Insurance, Long>{
    
}
