package LAB.question2Person;

public class Student extends Person{
    private final int studentId;
    Student(String name, int age, int studentId){
        super(name,age);
        this.studentId=studentId;
    }
    public int getStudentId() {
        return studentId;
    }

}
