package lectureReservation.api.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class ApplicantListDto {
	@Getter
	@Setter
    public static class Request {
        private String letureId;
        private String employeeId;
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
        private String id;
        private String letureId;
        private String employeeId;
    }
}
