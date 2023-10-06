package interfacesegregationprinciple;




//Define an interface for common employee actions
interface EmployeeActions {
 void work();
 void getSalary();
}

//Define an interface for manager-specific actions
interface ManagerActions {
 void hireEmployee(Employee employee);
 void assignTask(Employee employee);
 void evaluateEmployee(Employee employee);
}

//Employee class implementing EmployeeActions
class Employee implements EmployeeActions {
 private String name;
 private double salary;

 public Employee(String name, double salary) {
     this.name = name;
     this.salary = salary;
 }

 @Override
 public void work() {
     System.out.println(name + " is working.");
 }

 @Override
 public void getSalary() {
     System.out.println(name + " receives a salary of $" + salary);
 }
}

//Manager class implementing both EmployeeActions and ManagerActions
class Manager implements EmployeeActions, ManagerActions {
 private String name;

 public Manager(String name) {
     this.name = name;
 }

 @Override
 public void work() {
     System.out.println(name + " is managing employees.");
 }

 @Override
 public void getSalary() {
     System.out.println(name + " receives a salary as a manager.");
 }

 @Override
 public void hireEmployee(Employee employee) {
     System.out.println(name + " hires " + employee);
 }

 @Override
 public void assignTask(Employee employee) {
     System.out.println(name + " assigns a task to " + employee);
 }

 @Override
 public void evaluateEmployee(Employee employee) {
     System.out.println(name + " evaluates " + employee);
 }
}

public class InterfaceSegregationPrinciple {
 public static void main(String[] args) {
     Employee emp1 = new Employee("Employee1", 50000);
     Manager manager1 = new Manager("Manager1");

     emp1.work();
     emp1.getSalary();

     manager1.work();
     manager1.getSalary();
     manager1.hireEmployee(emp1);
     manager1.assignTask(emp1);
     manager1.evaluateEmployee(emp1);
 }
}
