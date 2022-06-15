package anft.demo.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import static anft.demo.api.ErrorEnum.*;

@Slf4j
@RestControllerAdvice
public class ApiExControllerAdvice {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoHandlerFoundException.class)
    public ErrorField notFoundExHandle(NoHandlerFoundException e) {
        log.error("[exceptionHandle] ex", e);
        return new ErrorField(NOT_FOUND.getStatus(), NOT_FOUND.getCode(), e.getMessage());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler
    public ErrorField exHandle(Exception e) {
        log.error("[exceptionHandle] ex", e);
        return new ErrorField(INTERNAL_SERVER_ERROR.getStatus(), INTERNAL_SERVER_ERROR.getCode(), e.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    public ErrorField illegalExHandle(IllegalArgumentException e) {
        log.error("[exceptionHandle] ex", e);
        return new ErrorField(BAD_REQUEST.getStatus(), BAD_REQUEST.getCode(), e.getMessage());
    }
}
