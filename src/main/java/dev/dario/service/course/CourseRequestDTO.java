package dev.dario.service.course;

import java.util.Date;

public class CourseRequestDTO {


  private String name;
  private String trainerName;
  private String duration; // days
  private Date startDate;
  private String courseType; // live recording
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
