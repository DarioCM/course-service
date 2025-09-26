package dev.dario.service.course;

public class CourseUtil {

  public static CourseEntity fromDtoRequest(CourseRequestDTO requestDTO) {
    CourseEntity courseEntity = new CourseEntity();
    //courseEntity.setCourseId();
    courseEntity.setName(requestDTO.getName());
    courseEntity.setTrainerName(requestDTO.getTrainerName());
    courseEntity.setDuration(requestDTO.getDuration());
    courseEntity.setStartDate(requestDTO.getStartDate());
    courseEntity.setCourseType(requestDTO.getCourseType());
    courseEntity.setFees(requestDTO.getFees());
    courseEntity.setCertificateAvailable(requestDTO.isCertificateAvailable());
    courseEntity.setDescription(requestDTO.getDescription());
    return courseEntity;
  }

  public static CourseEntity fromDtoResponse(CourseResponseDTO responseDTO) {
    CourseEntity courseEntity = new CourseEntity();
    courseEntity.setCourseId(responseDTO.getCourseId());
    courseEntity.setName(responseDTO.getName());
    courseEntity.setTrainerName(responseDTO.getTrainerName());
    courseEntity.setDuration(responseDTO.getDuration());
    courseEntity.setStartDate(responseDTO.getStartDate());
    courseEntity.setCourseType(responseDTO.getCourseType());
    courseEntity.setFees(responseDTO.getFees());
    courseEntity.setCertificateAvailable(responseDTO.isCertificateAvailable());
    courseEntity.setDescription(responseDTO.getDescription());
    return courseEntity;
  }

  public static CourseResponseDTO fromEntity(CourseEntity entity) {
    CourseResponseDTO courseResponseDTO = new CourseResponseDTO();
    courseResponseDTO.setCourseId(entity.getCourseId());
    courseResponseDTO.setName(entity.getName());
    courseResponseDTO.setTrainerName(entity.getTrainerName());
    courseResponseDTO.setDuration(entity.getDuration());
    courseResponseDTO.setStartDate(entity.getStartDate());
    courseResponseDTO.setCourseType(entity.getCourseType());
    courseResponseDTO.setFees(entity.getFees());
    courseResponseDTO.setCertificateAvailable(entity.isCertificateAvailable());
    courseResponseDTO.setDescription(entity.getDescription());
    return courseResponseDTO;
  }


}
