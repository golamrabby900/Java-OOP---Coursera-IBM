public class EmployeeManagementSystem {

    public static void main(String[] args) {
        // Create employees using different constructors
        Employee emp1 = new Employee("Alice", 30, 5000.0);
        Employee emp2 = new Employee();
        emp2.setName("Bob");
        emp2.setAge(25);
        emp2.setSalary(4000.0);

        // Display employees
        System.out.println("Employee 1:");

        System.out.println(emp1);
        System.out.println("Annual Salary: $" + emp1.calculateAnnualSalary());

        System.out.println("\nEmployee 2:");
        System.out.println(emp2);
        System.out.println("Annual Salary: $" + emp2.calculateAnnualSalary());

        // Give a raise
        emp1.giveRaise(10); // 10% raise
        System.out.println("\nEmployee 1 after raise:");
        System.out.println(emp1);

        // Clone employee
        Employee emp3 = emp1.clone();
        System.out.println("\nCloned Employee (Employee 3):");
        System.out.println(emp3);
    }
}

// Employee class (non-public, inside same file)
class Employee implements Cloneable {
    private String name;
    private int age;
    private double salary;

    // Default constructor
    public Employee() {
        this.name = "Unknown";
        this.age = 18;
        this.salary = 0.0;
    }

    // Parameterized constructor
    public Employee(String name, int age, double salary) {
        setName(name);
        setAge(age);
        setSalary(salary);
    }

    // Copy constructor
    public Employee(Employee other) {
        this.name = other.name;
        this.age = other.age;
        this.salary = other.salary;
    }

    // Getters and setters with validation
    public String getName() { return name; }
    public void setName(String name) {
        if(name != null && !name.isEmpty()) this.name = name;
        else this.name = "Unknown";
    }

    public int getAge() { return age; }
    public void setAge(int age) {
        if(age >= 18 && age <= 65) this.age = age;
        else this.age = 18;
    }

    public double getSalary() { return salary; }
    public void setSalary(double salary) {
        if(salary >= 0) this.salary = salary;
        else this.salary = 0.0;
    }

    // Calculate annual salary
    public double calculateAnnualSalary() { return salary * 12; }

    // Give a raise
    public void giveRaise(double percent) {
        if(percent > 0) salary += salary * percent / 100;
    }

    // Clone method
    @Override
    public Employee clone() { return new Employee(this); }

    // Display employee info
    @Override
    public String toString() {
        return "Name: " + name + "\nAge: " + age + "\nSalary: $" + String.format("%.2f", salary);
    }
}
