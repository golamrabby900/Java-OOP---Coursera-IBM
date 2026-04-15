public class StudentRegistry {

    public static void main(String[] args) {
        // Create students using parameterized constructor
        Student student1 = new Student(101, "Alice", 88.5, true);
        Student student2 = new Student(102, "Bob", 72.0, true);

        // Create a student using default constructor and setters
        Student student3 = new Student();
        student3.setId(103);
        student3.setName("Charlie");
        student3.setGrade(95.0);
        student3.setActive(true);

        // Display student information
        System.out.println("Student 1:");
        System.out.println(student1);
        System.out.println("Student 2:");
        System.out.println(student2);
        System.out.println("Student 3:");
        System.out.println(student3);

        // Compare grades
        System.out.println("\nComparing Student 1 and Student 2:");
        if(student1.hasHigherGradeThan(student2)) {
            System.out.println(student1.getName() + " has a higher grade than " + student2.getName());
        } else {
            System.out.println(student2.getName() + " has a higher grade than " + student1.getName());
        }

        // Calculate letter grades
        System.out.println("\nLetter grades:");
        System.out.println(student1.getName() + ": " + student1.getLetterGrade());
        System.out.println(student2.getName() + ": " + student2.getLetterGrade());
        System.out.println(student3.getName() + ": " + student3.getLetterGrade());
    }
}

// Student class (non-public, inside same file)
class Student {
    // Private instance variables (encapsulation)
    private int id;
    private String name;
    private double grade; // numerical grade out of 100
    private boolean active;

    // Default constructor
    public Student() {
        this.id = 0;
        this.name = "Unknown";
        this.grade = 0.0;
        this.active = false;
    }

    // Parameterized constructor
    public Student(int id, String name, double grade, boolean active) {
        setId(id);
        setName(name);
        setGrade(grade);
        setActive(active);
    }

    // Getters and setters with validation
    public int getId() { return id; }
    public void setId(int id) {
        if(id > 0) this.id = id;
        else System.out.println("Invalid ID. Must be positive.");
    }

    public String getName() { return name; }
    public void setName(String name) {
        if(name != null && !name.isEmpty()) this.name = name;
        else System.out.println("Invalid name. Using 'Unknown'.");
    }

    public double getGrade() { return grade; }
    public void setGrade(double grade) {
        if(grade >= 0 && grade <= 100) this.grade = grade;
        else System.out.println("Invalid grade. Must be 0-100.");
    }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }

    // Utility methods
    public String getLetterGrade() {
        if(grade >= 90) return "A";
        else if(grade >= 80) return "B";
        else if(grade >= 70) return "C";
        else if(grade >= 60) return "D";
        else return "F";
    }

    public boolean hasHigherGradeThan(Student other) {
        return this.grade > other.grade;
    }

    // Display student information
    @Override
    public String toString() {
        return "ID: " + id +
               "\nName: " + name +
               "\nGrade: " + grade +
               "\nActive: " + (active ? "Yes" : "No");
    }
}
