package dev.dario.service.error;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ResponseError> handleException(MethodArgumentNotValidException exception) {

    List<ErrorMessage> errors =
    exception.getFieldErrors().stream()
        .map(e -> new ErrorMessage(e.getField(),e.getDefaultMessage()) ).toList();

    var responseBody = new ResponseError();
    responseBody.setErrorCode("VALIDATION_ERROR");
    responseBody.setErrorMessages(errors);

    return ResponseEntity.badRequest().body(responseBody);

  }

  @ExceptionHandler(CourseNotFound.class)
  public ResponseEntity<ResponseError> handleException(CourseNotFound exception){
    ResponseError error = new ResponseError();
    error.setErrorCode("COURSE_NOT_FOUND");
    ErrorMessage message = new ErrorMessage(exception.getMessage());
    List<ErrorMessage> messages = new ArrayList<>();
    messages.add(message);
    error.setErrorMessages(messages);
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
  }

}
