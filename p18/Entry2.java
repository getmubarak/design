class Student{
}
class Course{
}
class Register{
  List<Course> courses;
  List<Student> students;
  Map<int,List<Course> > studentCourses;
  Map<int,List<Student> > courseStudents;
  
  ...  
}
