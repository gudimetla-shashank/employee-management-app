package shashank;

import java.util.*;

//Employee class with attributes EmpId, EmpName, EmpDept, EmpSalary
class Employee {
 public int empId;
 public String empName;
 public String empDept;
 public double empSalary;

 public Employee(int empId, String empName, String empDept, double empSalary) {
     this.empId = empId;
     this.empName = empName;
     this.empDept = empDept;
     this.empSalary = empSalary;
 }

 // Getters and Setters
 public int getEmpId() {
     return empId;
 }

 public void setEmpId(int empId) {
     this.empId = empId;
 }

 public String getEmpName() {
     return empName;
 }

 public void setEmpName(String empName) {
     this.empName = empName;
 }

 public String getEmpDept() {
     return empDept;
 }

 public void setEmpDept(String empDept) {
     this.empDept = empDept;
 }

 public double getEmpSalary() {
     return empSalary;
 }

 public void setEmpSalary(double empSalary) {
     this.empSalary = empSalary;
 }
}

//Employee Management System class
class EmployeeManagementSystem {
 private List<Employee> employees;

 public EmployeeManagementSystem() {
     employees = new ArrayList<>();
 }

 public void addEmployee(Employee employee) {
     employees.add(employee);
 }

 public List<Employee> getAllEmployees() {
     return employees;
 }

 public Map<String, Integer> groupEmployeesByDepartment() {
     Map<String, Integer> departmentCount = new HashMap<>();
     for (Employee employee : employees) {
         String department = employee.getEmpDept();
         departmentCount.put(department, departmentCount.getOrDefault(department, 0) + 1);
     }
     return departmentCount;
 }

 public double totalSalaryForDepartment(String department) {
     double totalSalary = 0;
     for (Employee employee : employees) {
         if (employee.getEmpDept().equals(department)) {
             totalSalary += employee.getEmpSalary();
         }
     }
     return totalSalary;
 }
}

public class EmployeeManagementApp {
 public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);
     EmployeeManagementSystem empManagementSystem = new EmployeeManagementSystem();

     // Login
     System.out.print("Enter password to login: ");
     String password = scanner.nextLine();
     if (!password.equals("admin")) {
         System.out.println("Incorrect password. Exiting...");
         return;
     }

     // Adding employees dynamically
     boolean addMoreEmployees = true;
     while (addMoreEmployees) {
         System.out.println("\nEnter employee details:");
         System.out.print("Employee ID: ");
         int empId = scanner.nextInt();
         scanner.nextLine();  // consume newline character
         System.out.print("Employee Name: ");
         String empName = scanner.nextLine();
         System.out.print("Employee Department: ");
         String empDept = scanner.nextLine();
         System.out.print("Employee Salary: ");
         double empSalary = scanner.nextDouble();
         scanner.nextLine();  // consume newline character

         empManagementSystem.addEmployee(new Employee(empId, empName, empDept, empSalary));

         System.out.print("\nDo you want to add another employee? (yes/no): ");
         String choice = scanner.nextLine();
         addMoreEmployees = choice.equalsIgnoreCase("yes");
     }

     // Operations
     while (true) {
         System.out.println("\nChoose an operation:");
         System.out.println("1. Get All Employees");
         System.out.println("2. Group Employees by Department");
         System.out.println("3. Add salary of all employees belonging to IT department");
         System.out.println("4. Exit");

         int choice = scanner.nextInt();
         scanner.nextLine();  // consume newline character

         switch (choice) {
             case 1:
                 List<Employee> employees = empManagementSystem.getAllEmployees();
                 System.out.println("\nAll Employees:");
                 for (Employee employee : employees) {
                     System.out.println("ID: " + employee.getEmpId() + ", Name: " + employee.getEmpName() +
                             ", Department: " + employee.getEmpDept() + ", Salary: " + employee.getEmpSalary());
                 }
                 break;
             case 2:
                 Map<String, Integer> departmentCount = empManagementSystem.groupEmployeesByDepartment();
                 System.out.println("\nEmployees Grouped by Department:");
                 for (Map.Entry<String, Integer> entry : departmentCount.entrySet()) {
                     System.out.println("Department: " + entry.getKey() + ", Count: " + entry.getValue());
                 }
                 break;
             case 3:
                 double totalSalaryIT = empManagementSystem.totalSalaryForDepartment("IT");
                 System.out.println("\nTotal Salary for IT Department: " + totalSalaryIT);
                 break;
             case 4:
                 System.out.println("Exiting...");
                 return;
             default:
                 System.out.println("Invalid choice. Please try again.");
         }
     }
 }
}
