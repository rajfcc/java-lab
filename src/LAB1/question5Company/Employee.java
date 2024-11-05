package LAB1.question5Company;

class Employee {
    String name;
    Department department;

    public String getName() {
        return name;
    }

    public Employee(String name, Department department) {
        this.name = name;
        this.department = department;
    }

    public void display() {
        System.out.println("Employee Name: " + name + ", Department: " + department.departmentName);
    }
}




