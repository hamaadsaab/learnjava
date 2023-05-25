
// Write a class Student with data members: name, roll number, password, section and credit 
// hours. Provide all required constructors and getter/setter functions. 
// Create a class ProgramCoorinator with following functions: 
//  registerNewStudent() to add a new student into the system (with default 15 credit hours). 
//  assignASection()to assign the same section to all students within the system (i.e., available in 
// ArrayList). 
//  removeCourse()to decrease 3 credit hours from a specific student’s record. 
//  removeAStudent() to remove a specific student from the system on searching by his/her roll number. 
//  displayAStudent() to print the information of a specific student from the system on searching by 
// his/her roll number. 
// Implement a class Driver and provide a full menu to demonstrate the execution of your program

import java.util.*;

class Student {
    String name;
    int roll_number;
    int password;
    String section;
    double credit_hours;

    public Student() {
    }

    public Student(String name, int roll_number, int password, String section, double credit_hours) {
        this.name = name;
        this.roll_number = roll_number;
        this.password = password;
        this.section = section;
        this.credit_hours = credit_hours;
    }

    public Student(Student stu) {
        this.name = stu.name;
        this.roll_number = stu.roll_number;
        this.password = stu.password;
        this.section = stu.section;
        this.credit_hours = stu.credit_hours;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getrollnumber() {
        return roll_number;
    }

    public void setrollnumber(int roll_number) {
        this.roll_number = roll_number;
    }

    public int getpassword() {
        return password;
    }

    public void setpassword(int password) {
        this.password = password;
    }

    public String getsection() {
        return section;
    }

    public void setsection(String section) {
        this.section = section;
    }

    public double getcredithours() {
        return credit_hours;
    }

    public void setcredithours(double credit_hours) {
        this.credit_hours = credit_hours;
    }

}

class ProgramCoorinator {
    ArrayList<Student> obj;

    public ProgramCoorinator() {
        obj = new ArrayList<>();
    }

    void registerNewStudent() {
        // Student st = new Student();
        Scanner scanner = new Scanner(System.in);
        // System.out.println("enter the name:");
        // String n = reg.nextLine();
        // st.setName(n);
        // obj.add(st);

        // System.out.println("enter the password:");
        // int pas = reg.nextInt();
        // st.setpassword(pas);
        // obj.add(st);

        // System.out.println("enter the roll number:");
        // int r = reg.nextInt();
        // st.setrollnumber(r);
        // obj.add(st);

        // System.out.println("enter the section:");
        // String s = reg.nextLine();
        // st.setsection(s);
        // obj.add(st);

        // System.out.println("enter the password:");
        // double cre = reg.nextDouble();
        // st.setcredithours(cre);
        // obj.add(st);

        System.out.print("Enter the name: ");
        String name = scanner.nextLine();

        System.out.print("Enter the roll number: ");
        int rollNumber = scanner.nextInt();

        System.out.print("Enter the password: ");
        int password = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        System.out.print("Enter the section: ");
        String section = scanner.nextLine();

        double defaultCreditHours = 15.0; // Default value for credit hours
        Student newStudent = new Student(name, rollNumber, password, section, defaultCreditHours);
        obj.add(newStudent);

    }

    public void assignASection(String section) {
        for (Student student : obj) {
            student.setsection(section);
        }
    }
    // removeCourse()to decrease 3 credit hours from a specific student’s record.

    public void removeCourse(int roll_number) {
        for (Student stu_dent : obj) {
            if (stu_dent.getrollnumber() == (roll_number)) {
                double currentcredithour = stu_dent.getcredithours();
                if (currentcredithour >= 3) {
                    stu_dent.setcredithours(currentcredithour - 3);
                    System.out.println("3 credit hours removed from student: " + stu_dent.getName());
                } else {
                    System.out.println("Insufficient credit hours for student: " + stu_dent.getName());
                }
                return;
            }
        }
        System.out.println("Student with ID " + roll_number + " not found.");

    }
    //  removeAStudent() to remove a specific student from the system on searching
    // by his/her roll number.

    public void removeAStudent(int roll_number) {
        Iterator<Student> iterator = obj.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getrollnumber() == roll_number) {
                iterator.remove();
                System.out.println("Student with roll number " + roll_number + " has been removed.");
                return;
            }
        }
        System.out.println("Student with roll number " + roll_number + " not found.");
    }

    //  displayAStudent() to print the information of a specific student from the
    // system on searching by
    // his/her roll number.
    public void displayAStudent(int roll_number) {
        Iterator<Student> iterator = obj.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getrollnumber() == roll_number) {
                System.out.println("Roll  number = " + student.getrollnumber());
                System.out.println("Name = " + student.getName());
                System.out.println("section = " + student.getsection());
                System.out.println(" password = " + student.getpassword());
                System.out.println("credit hours = " + student.getcredithours());
            }
            return;
        }
        System.out.println("Student with roll number " + roll_number + " not found.");

    }

}
// Implement a class Driver and provide a full menu to demonstrate the execution
// of your program

public class Arraylist01 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        ProgramCoorinator pc = new ProgramCoorinator();
        System.out.println("enter the number ");
        int choice = s.nextInt();
        while (true) {
            System.out.println("Student Menu : ");
            System.out.println("enter 1 for register the  new student : ");
            System.out.println("enter 2 for assign the section to student : ");
            System.out.println("enter 3 for remove  the  course of student : ");
            System.out.println("enter 4 for remove the   student : ");
            System.out.println("enter 5 for display the   record of student : ");
            System.out.println("enter 6 for Exit: ");

            switch (choice) {
                case 1:
                    pc.registerNewStudent();
                    break;
                case 2:
                    System.out.println("enter the section ");
                    String sec = s.nextLine();
                    pc.assignASection(sec);
                    break;
                case 3:
                    System.out.println("enter the roll number ");
                    int rc = s.nextInt();
                    pc.removeCourse(rc);
                    break;
                case 4:
                    System.out.println("enter the roll number ");
                    int rs = s.nextInt();
                    pc.removeAStudent(rs);
                    break;
                case 5:
                    System.out.println("enter the roll number ");
                    int ds = s.nextInt();
                    pc.displayAStudent(ds);
                    break;
                case 6:
                    System.out.println("exit the prigram");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;

            }
        }
        // pc.registerNewStudent();
        // pc.displayAStudent(531);
    }
}
