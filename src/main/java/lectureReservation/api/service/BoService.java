package lectureReservation.api.service;

import java.util.Map;

import lectureReservation.api.dto.LectureListDto;

public interface BoService {

	Map<String, Object> getLectures();

	LectureListDto.Response addLectures(LectureListDto.Request request);

	Map<String, Object> getApplicants(String lectureId);

}
