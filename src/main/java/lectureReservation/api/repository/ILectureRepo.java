package lectureReservation.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import lectureReservation.api.entity.LectureEntity;

@Repository
public interface ILectureRepo extends JpaRepository<LectureEntity, String>{

	@Query(value = "SELECT * FROM lecture o WHERE o.lecture_day < TIMESTAMPADD(DAY, 8, CURRENT_DATE)  AND  TIMESTAMPADD(DAY, 1, o.lecture_day) >= CURRENT_DATE", nativeQuery = true)
	List<LectureEntity> findByDay();	
}
