package dev.dario.service.error;

public class CourseNotFound extends RuntimeException {

  public CourseNotFound(String message) {
    super(message);
  }
}
