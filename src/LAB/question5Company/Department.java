package LAB.question5Company;

import java.util.ArrayList;

class Department {
    String departmentName;
    ArrayList<Employee> employees;

    public Department(String departmentName) {
        this.departmentName = departmentName;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void display() {
        System.out.println("Department Name: " + departmentName);
        for (Employee employee : employees) {
            System.out.println(employee.getName());
        }
    }
}