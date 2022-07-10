package lectureReservation.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import lectureReservation.api.entity.ApplicantEntity;

@Repository
public interface IApplicantRepo extends JpaRepository<ApplicantEntity, String>{
	
	@Query(value = "SELECT employeeId FROM ApplicantEntity o WHERE o.lectureId = :lectureId")
	List<String> findByletureId(@Param("lectureId") String lectureId);
	
	@Query(value = "SELECT lectureId FROM ApplicantEntity o WHERE o.employeeId = :employeeId")
	List<String> findByEmployeeId(@Param("employeeId") String employeeId);
	
}
