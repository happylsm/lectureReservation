package lectureReservation.api.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lectureReservation.api.dto.LectureListDto;
import lectureReservation.api.entity.LectureEntity;
import lectureReservation.api.repository.IApplicantRepo;
import lectureReservation.api.repository.ILectureRepo;
import lectureReservation.api.service.BoService;
import lectureReservation.common.exception.CustomException;
import lectureReservation.common.exception.ErrorCode;

@Service
public class BoServiceImpl implements BoService{

	@Autowired
	ILectureRepo lectureRepo;
	
	@Autowired
	IApplicantRepo applicantRepo;
	
	@Override
	@Transactional(readOnly = true)
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

	@Override
	public LectureListDto.Response addLectures(LectureListDto.Request request) {
		
		LectureListDto.Response res = new LectureListDto.Response();
		LectureListDto.resultMsg rmg = new LectureListDto.resultMsg();
		
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

	@Override
	@Transactional(readOnly = true)
	public Map<String, Object> getApplicants(String lectureId) {
		
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
