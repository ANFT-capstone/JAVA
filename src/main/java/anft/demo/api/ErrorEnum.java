package anft.demo.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorEnum {
    NOT_FOUND(404,"PAGE NOT FOUND"),
    INTERNAL_SERVER_ERROR(500,"INTERNAL SERVER ERROR"),
    BAD_REQUEST(400,"WRONG PARAMETER");

    private final int status;
    private final String code;
}
