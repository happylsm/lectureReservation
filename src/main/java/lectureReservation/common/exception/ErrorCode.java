package lectureReservation.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

		EMPLOYEE_NOT_FOUND(404,"SM001","EMPLOYEE_NOT_FOUND"),
		LECTURE_NOT_FOUND(404,"SM002","LECTURE_NOT_FOUND"),
		APPLICANT_NOT_FOUND(404,"SM003","APPLICANT_NOT_FOUND"),
		DUPLICATE_APPLICATION(402,"SM004","DUPLICATE_APPLICATION"),
		
	    INTER_SERVER_ERROR(500,"COMMON-ERR-500","INTER SERVER ERROR"),
	    ;

	    private int status;
	    private String errorCode;
	    private String message;
}
