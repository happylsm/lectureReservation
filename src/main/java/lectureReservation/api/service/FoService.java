package lectureReservation.api.service;

import java.util.Map;

import lectureReservation.api.dto.ApplicantListDto;

public interface FoService {

	Map<String, Object> getLectures();

	Map<String, Object> getMyLectures(String employeeId);

	ApplicantListDto.Response requestLecture(ApplicantListDto.Request request);

}
