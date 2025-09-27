package dev.dario.service.course;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import java.util.Date;

public class CourseRequestDTO {


  @NotBlank( message = "Course name shouldn't be null or empty." )
  private String name;

  @NotEmpty(message = "Trainer name should be define")
  private String trainerName;

  @NotNull(message = "duration must need to specify")
  private String duration; // days

  @JsonFormat(shape = Shape.STRING, pattern = "dd-MM-yyyy")
  @Past(message = "start date cant not be before today. ")
  private Date startDate;

  private String courseType; // live recording]

  @Min(value = 1500, message = "course price cant be less than 1500")
  @Max(value = 5000, message = "course price cant not be mnore than 5000")
  private double fees;
  private boolean isCertificateAvailable;
  private String description;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getTrainerName() {
    return trainerName;
  }

  public void setTrainerName(String trainerName) {
    this.trainerName = trainerName;
  }

  public String getDuration() {
    return duration;
  }

  public void setDuration(String duration) {
    this.duration = duration;
  }

  public Date getStartDate() {
    return startDate;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  public String getCourseType() {
    return courseType;
  }

  public void setCourseType(String courseType) {
    this.courseType = courseType;
  }

  public double getFees() {
    return fees;
  }

  public void setFees(double fees) {
    this.fees = fees;
  }

  public boolean isCertificateAvailable() {
    return isCertificateAvailable;
  }

  public void setCertificateAvailable(boolean certificateAvailable) {
    isCertificateAvailable = certificateAvailable;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
