package lectureReservation.api.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lectureReservation.api.dto.ApplicantListDto;
import lectureReservation.api.dto.LectureListDto;
import lectureReservation.api.entity.ApplicantEntity;
import lectureReservation.api.entity.LectureEntity;
import lectureReservation.api.repository.IApplicantRepo;
import lectureReservation.api.repository.ILectureRepo;
import lectureReservation.api.service.FoService;
import lectureReservation.common.exception.CustomException;
import lectureReservation.common.exception.ErrorCode;

@Service
public class FoServiceImpl implements FoService{
	
	@Autowired
	ILectureRepo lectureRepo;
	
	@Autowired
	IApplicantRepo applicantRepo;

	@Override
	public Map<String, Object> getLectures() {
		Map<String, Object> res = new HashMap<String, Object>();
		LectureListDto.resultMsg rmg = new LectureListDto.resultMsg();
		List<LectureEntity> lectures = lectureRepo.findByDay();
		
		rmg.setCode("200");
		rmg.setMassage("성공했습니다.");
		
		res.put("resultMsg", rmg);
		res.put("bodyData", lectures);
		
		return res;
	}

	@Override
	public ApplicantListDto.Response requestLecture(ApplicantListDto.Request request) {
		
		ApplicantListDto.Response res = new ApplicantListDto.Response();
		ApplicantListDto.resultMsg rmg = new ApplicantListDto.resultMsg();
	
		ApplicantEntity params = ApplicantEntity.builder()
                .lectureId(request.getLetureId())
                .employeeId(request.getEmployeeId())
                .build();
		
		Optional<LectureEntity> lectureEntity = lectureRepo.findById(request.getLetureId());
        
		lectureEntity.ifPresentOrElse(getLecture -> {
			int count = getLecture.getNumberApplicants() - 1;
			if (count >= 0) {
				getLecture.setNumberApplicants(count);
				lectureRepo.save(getLecture);
			} else {
				throw new CustomException("신청인원이 마감되었습니다.", ErrorCode.LECTURE_NOT_FOUND);
			}
		}, () -> {
			throw new CustomException("해당하는 강연을 찾을 수 없습니다.", ErrorCode.LECTURE_NOT_FOUND);
		});
		
		applicantRepo.save(params);
		
        rmg.setCode("200");
		rmg.setMassage("성공했습니다.");
		
		res.setResultMsg(rmg);

		return res;
	}

	@Override
	public Map<String, Object> getMyLectures(String employeeId) {
		Map<String, Object> res = new HashMap<String, Object>();
		LectureListDto.resultMsg rmg = new LectureListDto.resultMsg();
		List<String> applicantEntity = applicantRepo.findByEmployeeId(employeeId);
		
		if (applicantEntity.isEmpty()) {
			throw new CustomException("사원 정보가 없습니다.", ErrorCode.EMPLOYEE_NOT_FOUND);
		}
		
		rmg.setCode("200");
		rmg.setMassage("성공했습니다.");
		
		res.put("resultMsg", rmg);
		res.put("bodyData", applicantEntity);
		
		return res;
	}

}
