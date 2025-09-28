package dev.dario.service.error;

import java.util.List;

public class ResponseError {

  private String errorCode;
  private List<ErrorMessage> errorMessages;

  public String getErrorCode() {
    return errorCode;
  }

  public void setErrorCode(String errorCode) {
    this.errorCode = errorCode;
  }

  public List<ErrorMessage> getErrorMessages() {
    return errorMessages;
  }

  public void setErrorMessages(List<ErrorMessage> errorMessages) {
    this.errorMessages = errorMessages;
  }
}
