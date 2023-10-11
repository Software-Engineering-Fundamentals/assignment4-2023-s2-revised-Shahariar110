
/**
 * Class to hold information about a student
 */
public class Student {

    private final String name;
    private final int studentNumber;
    private double marks;
    private String department;
    private int numberOfCourses = 0;

    /**
     * Create a new student object.
     * @param name: Name of the student
     * @param studentNumber:  Unqiue id of the student.
     */
    public Student(String name, int studentNumber) {
        this.name = name;
        this.studentNumber = studentNumber;
    }

    public String getName() {
        return name;
    }
    
    public int getId() {
        return studentNumber;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    public double getMarks() {
        return marks;
    }

    public String getDepartment() {
        return department;
    }

    public int getNumberOfCourses() {
        return numberOfCourses;
    }

    public void setNumberOfCourses(int numberOfCourses) {
        this.numberOfCourses = numberOfCourses;
    }


    

}
