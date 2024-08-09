package LAB.question5Company;


//   Design a class Company with fields companyName and a list of Employee objects (Aggregation).
//   The Employee class should have fields name and department.
//   Additionally, include a Department class containing a field departmentName and
//   list of Employee objects (Composition).
//   Demonstrate the relationships by creating instances and linking them appropriately.
public class Main {
    public static void main(String[] args) {
        // Create departments
        Department hr = new Department("Human Resources");
        Department it = new Department("Information Technology");

        // Create employees and assign them to departments
        Employee emp1 = new Employee("Ram", hr);
        Employee emp2 = new Employee("Shyam", it);
        Employee emp3 = new Employee("Hari", hr);

        // Add employees to departments (Composition)
        hr.addEmployee(emp1);
        hr.addEmployee(emp3);
        it.addEmployee(emp2);

        // Create a company and add employees to it (Aggregation)
        Company company = new Company("DEMO COMPANY PVT LTD");
        company.addEmployee(emp1);
        company.addEmployee(emp2);
        company.addEmployee(emp3);

        // Display details
        System.out.println("Company Details:");
        company.display();

        System.out.println("\nDepartment Details:");
        hr.display();
        it.display();

    }
}
