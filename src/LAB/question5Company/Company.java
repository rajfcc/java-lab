package LAB.question5Company;

import java.util.ArrayList;

class Company {
    String companyName;
    ArrayList<Employee> employees;

    public Company(String companyName) {
        this.companyName = companyName;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void display() {
        System.out.println("Company Name: " + companyName);
        for (Employee employee : employees) {
            employee.display();
        }
    }
}