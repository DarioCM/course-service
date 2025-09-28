package dev.dario.service.error;

import java.util.ArrayList;
import java.util.List;
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

}
