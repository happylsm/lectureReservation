package lectureReservation.api.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import lectureReservation.api.dto.ApplicantListDto;
import lectureReservation.api.service.FoService;

@RestController
@RequestMapping("/api/FO")
public class FoController {
	
	@Autowired
	private FoService foService;
	
	@ApiOperation(
			value = "강연 목록 조회"
			, notes = "신청 가능한 싯점부터 강연시간 1일 후 까지의 강연 목록을 가져오는 api")
	@GetMapping("/lectures")
	public Map<String, Object> getLectures() {
		return foService.getLectures();
	}
	
	@ApiOperation(
			value = "강연 신청"
			, notes = "강연을 신청하는 api")
	@PostMapping("/requestLecture")
	public ApplicantListDto.Response requestLecture(@RequestBody ApplicantListDto.Request request) {
		return foService.requestLecture(request);
	}
	
	@ApiOperation(
			value = "강연 신청 내역 조회"
			, notes = "사번별 강연 신청 내역을 조회하는 api")
	@GetMapping(value = "/myLectures/{employeeId}")
	public Map<String, Object> getMyLectures(@PathVariable String employeeId) {
		return foService.getMyLectures(employeeId);
	}

}
