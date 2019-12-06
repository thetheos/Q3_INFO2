import src.Student;
import src.StudentStreamFunction;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StudentFunctions implements StudentStreamFunction {

  public Student findFirst(Stream<Student> studentsStream, Map<String, Predicate<?>> conditions){
    Student[] students = findAll(studentsStream, conditions);
      if(students.length == 0) {
        return null;
    }
    return students[0];
  }

  public Student[] findAll(Stream<Student> studentsStream, Map<String, Predicate<?>> conditions){
      Stream<Student> crtStream = studentsStream;
      if(conditions.containsKey("firstName")){
        Predicate<String> fName = (Predicate<String>) conditions.get("firstName");
        crtStream = crtStream.filter(s -> fName.test(s.getFirstName()));
      }
      if(conditions.containsKey("lastName")){
        Predicate<String> lName = (Predicate<String>) conditions.get("lastName");
        crtStream = crtStream.filter(s -> lName.test(s.getLastName()));
      }
      if(conditions.containsKey("section")){
        Predicate<Integer> sct = (Predicate<Integer>) conditions.get("section");
        crtStream = crtStream.filter(s -> sct.test(s.getSection()));
      }
      if(conditions.containsKey("courses_results")){
        Predicate<Map<String, Double>> cReslt = (Predicate<Map<String, Double>>) conditions.get("courses_results");
        crtStream = crtStream.filter(s -> cReslt.test(s.getCourses_results()));
      }
      return (Student[]) crtStream.toArray();

  }

  public boolean exists(Stream<Student> studentsStream, Map<String, Predicate<?>> conditions, int n) {
        Student[] students = findAll(studentsStream, conditions);
        return (students.length >= n);
  }

  public Student[] filterThenSort(Stream<Student> studentsStream, Map<String, Predicate<?>> conditions, Comparator<Student> comparator) {
        Student[] students = findAll(studentsStream, conditions);
        return java.util.Arrays.stream(students).sorted(comparator).toArray(Student[]::new);
  }

  //TODO YOUR CODE HERE
}
