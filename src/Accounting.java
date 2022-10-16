import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Accounting {
    private List<Teacher> _teachers = new ArrayList<Teacher>();
    private List<Student> _students = new ArrayList<Student>();

    /**
     * Student Management Functions
     **/
    //Adds student to the list
    public void addStudent(Student student) {
        _students.add(student);
    }

    //Updates student by ID with new information
    public void updateStudent(int inputID, Student updatedInfo) {
        _students.replaceAll(e -> e.getID() == inputID ? updatedInfo : e);
        System.out.println("Student updated successfully");
    }

    //Display Balance of a student from ID
    public void showBalanceStudent(int id) {
        for (Student s : _students) {
            if (id == s.getID()) {
                s.computeNumberOfModules();
                s.computeTotalAmount();
                s.computeBalance();
                displayStudentBalanceOnly();
                s.displayBalance();
            }
        }
    }

    private void displayStudentBalanceOnly() {
        DisplayPersonHeader();
        displayAllStudentsHeader("║ %-11s ║ %-7s ║ %-12s ║%n", "Amount Paid", "Balance",
                "Total Amount", "", "", "");
        System.out.printf("╠════════════╬════════════╬═══════════════╬════════╬═════════════╬════════════╬" +
                "═════════════╬═════════╬══════════════╣%n");
    }

    //Gets the amount paid of the student
    public void feeDeposit(int id) {
        boolean found = false;
        Scanner scan = new Scanner(System.in);
        for (Student s : _students) {
            if (id == s.getID()) {
                displayStudentBalanceOnly();
                s.displayBalance();
                System.out.print("Enter Amount of Payment: ");
                int amount = scan.nextInt();
                s.setAmountPaid(s.getAmountPaid() + amount);
                s.computeBalance();
                System.out.println("Fee Deposit Successful!");
                found = true;
            }
        }
        if (!found) {
            System.out.println("Student not found");
        }
    }

    public void displayAllStudentsHeaderNeck() {
        System.out.printf("╠════════════╬════════════╬═══════════════╬════════╬═════════════╬════════════╬" +
                "═════════════╬═════════╬══════════════╬═════════════╬══════════════════╬═══════════════╣%n");
    }

    public void displayStudentBalanceHeader() {
        DisplayPersonHeader();

    }

    //Displays all students with zero balance
    public void displayAllZeroBalance() {
        DisplayPersonHeader();
        displayAllStudentsHeader("║ %-11s ║ %-7s ║ %-12s ║ %-11s ║ %-16s ║ %-13s ║%n",
                "Amount Paid", "Balance", "Total Amount",
                "New Modules", "Repeated Modules", "Total Modules");
        displayAllStudentsHeaderNeck();
        for (Student s : _students) {
            s.computeNumberOfModules();
            s.computeTotalAmount();
            s.computeBalance();
            if (s.getAmountBalance() == 0) {
                s.displayStudentInfo();
            }
        }
    }

    private static void displayAllStudentsHeader(String format, String Amount_Paid, String Balance, String Total_Amount,
                                                 String New_Modules, String Repeated_Modules, String Total_Modules) {
        System.out.printf(format, Amount_Paid, Balance, Total_Amount, New_Modules, Repeated_Modules, Total_Modules);
    }

    //Displays all students with non-zero balance
    public void displayAllStudents(boolean all, boolean zero) {
        DisplayPersonHeader();
        displayAllStudentsHeader("║ %-11s ║ %-7s ║ %-12s ║ %-11s ║ %-16s ║ %-13s ║%n",
                "Amount Paid", "Balance", "Total Amount",
                "New Modules", "Repeated Modules", "Total Modules");
        displayAllStudentsHeaderNeck();
        for (Student s : _students) {
            s.computeNumberOfModules();
            s.computeTotalAmount();
            s.computeBalance();
            if (!all) {
                if (zero) {
                    if (s.getAmountBalance() == 0) {
                        s.displayStudentInfo();
                    }
                } else {
                    if (s.getAmountBalance() != 0) {
                        s.displayStudentInfo();
                    }
                }
            } else {
                s.displayStudentInfo();
            }
        }
    }

    //Deletes student from list by ID
    public void deleteStudent(int inputID) {
        _students.removeIf(e -> (e.getID() == inputID));
        System.out.println("Student Deleted Successfully");
    }


    //Gets student's information
    public Student addStud() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the First Name of the Student: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter the Last Name of the Student: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter the Gender of the Student [1]M | [2]F: ");
        int gender = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter the Phone Number of the Student: ");
        String phoneNo = scanner.nextLine();
        System.out.print("Enter the Address of the Student: ");
        String address = scanner.nextLine();
        int repeatModules;
        int newModules = 0;
        int totalModules = 0;
        do {
            System.out.print("Enter the Number of Repeat Modules of the Student: ");
            repeatModules = scanner.nextInt();
            scanner.nextLine();
            if (repeatModules < 3 && repeatModules >= 0) {
                do {
                    totalModules = repeatModules;
                    System.out.print("Enter the Number of New Modules of the Student " +
                                     "(total modules cannot be more than 6): ");
                    newModules = scanner.nextInt();
                    scanner.nextLine();
                    totalModules += newModules;
                } while (totalModules > 6 || totalModules < 0);
            }
        } while (repeatModules > 6 || repeatModules < 0);
        return new Student(firstName, lastName, gender, address, phoneNo, newModules, repeatModules);
    }

    //get new information and update existing student record by id
    public Student updateStud(int id) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the First Name of the Student: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter the Last Name of the Student: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter the Gender of the Student [1]M | [2]F: ");
        int gender = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter the Phone Number of the Student: ");
        String phoneNo = scanner.nextLine();
        System.out.print("Enter the Address of the Student: ");
        String address = scanner.nextLine();
        int repeatModules;
        int newModules = 0;
        do {
            System.out.print("Enter the Number of Repeat Modules of the Student: ");
            repeatModules = scanner.nextInt();
            int totalModules;
            if (repeatModules < 3) {
                do {
                    totalModules = repeatModules;
                    System.out.print("Enter the Number of New Modules of the Student: ");
                    newModules = scanner.nextInt();
                    scanner.nextLine();
                    totalModules += newModules;
                } while (totalModules > 6 || totalModules < 0);
            }
        } while (repeatModules > 3);

        return new Student(id, firstName, lastName, gender, address, phoneNo, newModules, repeatModules);

    }


    //Adds student to the list
    public void AddS() {
        addStudent(addStud());
        Main.Clear();
        System.out.printf("Student Added with ID: %d%n", _students.get(_students.size() - 1).getID());
        Main.Pause();
    }

    /**
     * Teacher Management Functions
     */
    //Adds teacher to the list
    public void addTeacher(Teacher teacher) {
        _teachers.add(teacher);
    }

    //Searches for teacher by ID and updates the information
    public void updateTeacher(int ID, Teacher entry) {
        _teachers.replaceAll(e -> e.getID() == ID ? entry : e);
    }

    //Searches for teacher by ID and deletes the information
    public void deleteTeacher(int Id) {
        _teachers.removeIf(entry -> entry.getID() == Id);
        System.out.println("Teacher Deleted Successfully");
    }

    //Searches for teacher by ID and calculates the salary
    public void calculateSalary(int Id) {
        boolean found = false;
        for (Teacher t : _teachers) {
            if (Id == t.getID()) {
                found = true;
                System.out.println("Base Salary: " + 1200);
                System.out.println("Teaching hours: " + t.getTeachingHours());
                System.out.printf("OT = %.2f%n", t.getOt());
                System.out.printf("HA = %.2f%n", t.getHa());
                System.out.printf("MA = %.2f%n", t.getMa());
                System.out.printf("TA = %.2f%n", t.getTa());
                System.out.println("Net Salary is " + t.getSalary());
            }
        }
        if (!found) {
            System.out.println("Teacher Not Found");
        }
    }

    public void DisplayPersonHeader() {
        displayAllStudentsHeader("║ %6s     ║ %-10s ║ %11s   ║ %-6s ║ %9s   ║ %7s    ",
                "ID", "First Name", "Last Name", "Gender",
                "Address", "Phone");
    }

    //Displays all teachers
    public void viewAllTeachers() {
        DisplayPersonHeader();
        System.out.printf("║ %-10s ║ %13s   ║ %7s  ║ %3s ║%n", "Department", "Designation", "Salary", "Hrs");
        System.out.printf("╠════════════╬════════════╬═══════════════╬════════╬═════════════╬════════════╬" +
                "════════════╬═════════════════╬══════════╬═════╣%n");
        for (Teacher entry : _teachers) {
            entry.displayTeacher();
        }
    }

    public void addTeacher() {
        addTeacher(addTeach());
        System.out.println("Teacher Added");
    }

    //Gets teacher's information
    public Teacher addTeach() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the First Name of the teacher: ");
        String firstName = scanner.next();
        scanner.nextLine();
        System.out.print("Enter the Last Name of the teacher: ");
        String lastName = scanner.next();
        scanner.nextLine();
        System.out.print("Enter the Gender of the teacher [1]M | [2]F: ");
        int gender = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter the Phone Number of the teacher: ");
        String phoneNo = scanner.nextLine();
        System.out.print("Enter the Address of the teacher: ");
        String address = scanner.next();
        scanner.nextLine();
        System.out.print("[1] for Computing \n[2] for Business \nEnter the department of the teacher: ");
        int department = scanner.nextInt();
        System.out.print("[1] Head of Faculty\n[2] Coordinator\n[3] Lecturer\nEnter the designation of the teacher: ");
        int designation = scanner.nextInt();
        System.out.print("Enter Number of Teaching Hours: ");
        int teachingHours = scanner.nextInt();

        return new Teacher(firstName, lastName, gender, address, phoneNo, department, designation, teachingHours);
    }

    public Teacher updateTeach(int id) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the First Name of the teacher: ");
        String firstName = scanner.next();
        scanner.nextLine();
        System.out.print("Enter the Last Name of the teacher: ");
        String lastName = scanner.next();
        scanner.nextLine();
        System.out.print("Enter the Gender of the teacher [1]M | [2]F: ");
        int gender = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter the Phone Number of the teacher: ");
        String phoneNo = scanner.nextLine();
        System.out.print("Enter the Address of the teacher: ");
        String address = scanner.next();
        scanner.nextLine();
        System.out.print("[1] for Computing \n[2] for Business \nEnter the department of the teacher: ");
        int department = scanner.nextInt();
        System.out.print("[1] Head of Faculty\n[2] Coordinator\n[3] Lecturer\nEnter the designation of the teacher: ");
        int designation = scanner.nextInt();
        System.out.print("Enter Number of Teaching Hours: ");
        int teachingHours = scanner.nextInt();

        return new Teacher(id, firstName, lastName, gender, address, phoneNo, department, designation, teachingHours);

    }

    public void checkId(int id, boolean delete, boolean teacher) {
        boolean found = false;
        if (teacher) {
            if (delete) {
                for (Teacher t : _teachers) {
                    if (id == t.getID()) {
                        found = true;
                        deleteTeacher(id);
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Teacher Not Found");
                }
            } else {
                for (Teacher t : _teachers) {
                    if (id == t.getID()) {
                        found = true;
                        updateTeacher(id, updateTeach(id));
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Teacher Not Found");
                }
            }
        } else {
            if (delete) {
                for (Student s : _students) {
                    if (id == s.getID()) {
                        found = true;
                        deleteStudent(id);
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Student Not Found");
                }
            } else {
                for (Student s : _students) {
                    if (id == s.getID()) {
                        found = true;
                        updateStudent(id, updateStud(id));
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Student Not Found");
                }
            }
        }
    }
}
