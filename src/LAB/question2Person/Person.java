package LAB.question2Person;

//Define a superclass Person with fields name and age, and a constructor to initialize these fields. Create a subclass Student that adds a field studentId and initializes all fields using the constructor. Write a main method to demonstrate the creation of a Student object.
public class Person {

    private final String name;
    private final int age;
    Person(String name, int age){
        this.name = name;
        this.age  = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
