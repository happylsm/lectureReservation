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
import lectureReservation.api.dto.LectureListDto;
import lectureReservation.api.repository.ILectureRepo;
import lectureReservation.api.service.BoService;

@RestController
@RequestMapping("/api/BO")
public class BoController {
	
	@Autowired
	private BoService boService;

	@ApiOperation(
			value = "강연 목록 조회"
			, notes = "전체 강연 목록을 조회하는 api")
	@GetMapping("/lectures")
	public Map<String, Object> getLectures() {
		return boService.getLectures();
	}
	
	@ApiOperation(
			value = "강연 등록"
			, notes = "강연을 등록하는 api")
	@PostMapping("/addLecture")
	public LectureListDto.Response addLecture(@RequestBody LectureListDto.Request request) {
		return boService.addLectures(request);
	}
	
	@ApiOperation(
			value = "강연 신청자 목록"
			, notes = "강연별 신청한 사번 목록을 가져오는 api")
	@GetMapping("/lecturesApplicants/{lectureId}")
	public Map<String, Object> getApplicants(@PathVariable String lectureId) {
		return boService.getApplicants(lectureId);
	}

}
