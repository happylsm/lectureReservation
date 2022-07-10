package lectureReservation.common.exception;

import lombok.Getter;

@Getter
public class CustomException extends RuntimeException {

	private static final long serialVersionUID = 3709553909630028415L;
	private ErrorCode errorCode;

    public CustomException(String message, ErrorCode errorCode){
        super(message);
        this.errorCode = errorCode;
    }

}
