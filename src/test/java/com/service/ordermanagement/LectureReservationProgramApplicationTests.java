package com.service.ordermanagement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import lectureReservation.api.dto.LectureListDto;
import lectureReservation.api.entity.LectureEntity;
import lectureReservation.api.repository.IApplicantRepo;
import lectureReservation.api.repository.ILectureRepo;
import lectureReservation.common.exception.CustomException;
import lectureReservation.common.exception.ErrorCode;

@SpringBootTest
class LectureReservationProgramApplicationTests {

	@Autowired
	ILectureRepo lectureRepo;
	
	@Autowired
	IApplicantRepo applicantRepo;
	
	@Test
	void contextLoads() {
	}

	
	@Test
	public Map<String, Object> getLectures() {
		
		Map<String, Object> res = new HashMap<String, Object>();
		LectureListDto.resultMsg rmg = new LectureListDto.resultMsg();
		List<LectureEntity> lectureEntity = lectureRepo.findAll();

		rmg.setCode("200");
		rmg.setMassage("성공했습니다.");
		
		res.put("resultMsg", rmg);
		res.put("bodyData", lectureEntity);
		
		return res;
	}

	@Test
	public LectureListDto.Response addLectures() throws ParseException {
		
		LectureListDto.Response res = new LectureListDto.Response();
		LectureListDto.resultMsg rmg = new LectureListDto.resultMsg();
		LectureListDto.Request request = new LectureListDto.Request();
		
		String dateStr = "2022-07-08 11:00";         
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");         
		Date date = formatter.parse(dateStr);
			
		//데이터
		request.setLecturer("강연자");
		request.setLectureHall("강연장");
		request.setLectureDay(date);
		request.setLectureContents("강의입니다");
		request.setNumberApplicants(5);
		
        LectureEntity params = LectureEntity.builder()
                .lecturer(request.getLecturer())
                .lectureHall(request.getLectureHall())
                .lectureDay(request.getLectureDay())
                .lectureContents(request.getLectureContents())
                .numberApplicants(request.getNumberApplicants())
                .build();
        	
        lectureRepo.save(params);
        
        rmg.setCode("200");
		rmg.setMassage("성공했습니다.");
        
		res.setResultMsg(rmg);
		return res;
	}

	@Test
	public Map<String, Object> getApplicants() {
		
		String lectureId = "";
		Map<String, Object> res = new HashMap<String, Object>();
		LectureListDto.resultMsg rmg = new LectureListDto.resultMsg();
		List<String> applicantEntity = applicantRepo.findByletureId(lectureId);
		
		if (applicantEntity.isEmpty()) {
			throw new CustomException("강연신청정보가 없습니다.", ErrorCode.APPLICANT_NOT_FOUND);
		}
		
		rmg.setCode("200");
		rmg.setMassage("성공했습니다.");
		
		res.put("resultMsg", rmg);
		res.put("bodyData", applicantEntity);
		
		return res;
	}
}
