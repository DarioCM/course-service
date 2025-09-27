package dev.dario.service.course;

import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/course")
public class CourseController {

  private final CourseService courseService;
  private CourseService service;

  public CourseController(CourseService service, CourseService courseService) {
    this.service = service;
    this.courseService = courseService;
  }

  @PostMapping
  public ResponseEntity<CourseResponseDTO> addCourse(
      @RequestBody @Valid CourseRequestDTO requestDTO) {
    CourseResponseDTO newCourse = courseService.onboardNewCourse(requestDTO);
    return new ResponseEntity<>(newCourse, HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<List<CourseResponseDTO>> findAllCourses() {
    return new ResponseEntity<>(service.viewAllCourses(), HttpStatus.OK);
  }

  @GetMapping("/search/path/{courseId}")
  public ResponseEntity<CourseResponseDTO> findCourse(@PathVariable Long courseId) {
    return new ResponseEntity<>(service.findByCourseId(courseId), HttpStatus.OK);
  }

  @GetMapping("/search/request")
  public ResponseEntity<CourseResponseDTO> findCourseRequestParam(@RequestParam Long id) {
    return new ResponseEntity<>(service.findByCourseId(id), HttpStatus.OK);
  }

  @DeleteMapping("/{courseId}")
  public ResponseEntity<Void> deleteCourse(@PathVariable Long courseId) {
    service.deleteCourse(courseId);
    return ResponseEntity.noContent().build();
  }

  //update
  @PutMapping("/{courseId}")
  public ResponseEntity<CourseResponseDTO> updateCourse(@PathVariable Long courseId,
      @RequestBody @Valid CourseRequestDTO dto) {
    CourseResponseDTO responseDTO =
        service.updatedCourse(courseId, dto);
    return new ResponseEntity<>(responseDTO, HttpStatus.OK);
  }


}
