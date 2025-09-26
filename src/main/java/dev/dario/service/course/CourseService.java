package dev.dario.service.course;

import java.util.List;

public interface CourseService {

  CourseResponseDTO onboardNewCourse(CourseRequestDTO requestDTO);

  CourseResponseDTO findByCourseId(Long id);

  // TODO pagination
  List<CourseResponseDTO> viewAllCourses();

  void deleteCourse(Long id);

  CourseResponseDTO updatedCourse(Long id, CourseRequestDTO dto);



}
