import src.Student;
import src.StudentStreamFunction;


import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentFunctions implements StudentStreamFunction {

  public Stream<Student> findSecondAndThirdTopStudentForGivenCourse(Stream<Student> studentStream, String name){
      //return studentStream.sorted(Comparator.comparing((Student std) -> std.getCoursesResults().get(name))).limit(3).skip(1);
      return studentStream.sorted((std1, std2) -> std1.getCoursesResults().get(name).compareTo(std2.getCoursesResults().get(name))).limit(3).skip(1);
  }

  public Object[] computeAverageForStudentInSection(Stream<Student> studentStream, int section){
    //Object[] result = studentStream.filter(x -> x.getSection() == section).map(x -> new Object[] {String.format("%s %s %s","Student", x.getFirstName(), x.getLastName()), x.getCoursesResults().entrySet().stream().mapToDouble(Map.Entry::getValue).average()}).toArray();
    Object[] result = studentStream.filter(x -> x.getSection() == section).map(x -> new Object[] {String.format("%s %s %s","Student", x.getFirstName(), x.getLastName()), x.getCoursesResults().values().stream().reduce(0.0,(a,b) -> (a + b)) / (double) x.getCoursesResults().size()}).toArray();
    return result;
  }

  public int getNumberOfSuccessfulStudents(Stream<Student> studentStream) {
    return (int) studentStream.filter(s -> {
      java.util.Collection<Double> x = s.getCoursesResults().values();
      for (Double elm : x) {
        if (elm < 10) return false;
      }
      return true;
    }).count();
  }

  public Student findLastInLexicographicOrder(Stream<Student> studentStream){
    return studentStream.sorted((o1,o2) ->  Comparator.comparing(Student::getLastName).thenComparing(Student::getFirstName).reversed().compare(o1,o2)).findFirst().get();
      //return studentStream.filter((Predicate<? super Student>) Comparator.comparing(Student::getLastName).thenComparing(Student::getFirstName).reversed()).findFirst().get();
  }

  public double getFullSum(Stream<Student> studentStream){
        return studentStream.map(x -> x.getCoursesResults().values().stream().reduce(0.0,(a1,a2)->a1+a2)).reduce(0.0,Double::sum);
  }
}
