package dev.dario.service.course;

import dev.dario.service.error.CourseNotFound;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {

  private CourseRepository repository;

  public CourseServiceImpl(CourseRepository repository) {
    this.repository = repository;
  }

  @Override
  public CourseResponseDTO onboardNewCourse(CourseRequestDTO requestDTO) {
    CourseEntity entity = CourseUtil.fromDtoRequest(requestDTO);
    entity = repository.save(entity);
    return CourseUtil.fromEntity(entity);
  }

  @Override
  public CourseResponseDTO findByCourseId(Long id) {
    var entity = repository.findById(id)
        .orElseThrow(() -> new CourseNotFound("Course not found with id " + id));
    return CourseUtil.fromEntity(entity);

  }

  @Override
  public List<CourseResponseDTO> viewAllCourses() {
    List<CourseResponseDTO> responseDTOS = new ArrayList<>();
    repository.findAll().forEach(a -> responseDTOS.add(CourseUtil.fromEntity(a)));
    return responseDTOS;
  }

  @Override
  public void deleteCourse(Long id) {
    repository.deleteById(id);
  }

  @Override
  public CourseResponseDTO updatedCourse(Long id, CourseRequestDTO requestDTO) {
    CourseEntity courseEntity = repository.findById(id)
        .orElseThrow(() -> new RuntimeException("Course not found"));
    courseEntity.setName(requestDTO.getName());
    courseEntity.setTrainerName(requestDTO.getTrainerName());
    courseEntity.setDuration(requestDTO.getDuration());
    courseEntity.setStartDate(requestDTO.getStartDate());
    courseEntity.setCourseType(requestDTO.getCourseType());
    courseEntity.setFees(requestDTO.getFees());
    courseEntity.setCertificateAvailable(requestDTO.isCertificateAvailable());
    courseEntity.setDescription(requestDTO.getDescription());

    CourseEntity updated = repository.save(courseEntity);

    return CourseUtil.fromEntity(updated);
  }
}
