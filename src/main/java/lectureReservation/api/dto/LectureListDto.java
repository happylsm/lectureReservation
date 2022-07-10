package lectureReservation.api.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

public class LectureListDto {
	
	@Getter
	@Setter
    public static class Request {
        private String lecturer;
        private String lectureHall;
        @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm", timezone="Asia/Seoul")
        private Date lectureDay;
        private String lectureContents;
        private int numberApplicants;
    }
	
	@Getter
	@Setter
    public static class Response {
        private resultMsg resultMsg;
        private List<data> bodyData;
    }

	@Getter
	@Setter
    public static class resultMsg {
        private String code;
        private String massage;    
    }

	@Getter
	@Setter
    public static class data {
        private String letureId;
        private String version;
        private String lecturer;
        private String lectureHall;
        private Date lectureDay;
        private String lectureContents;
        private int numberApplicants;
    }
}
