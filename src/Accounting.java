import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Accounting {
    private List<Teacher> _teachers = new ArrayList<Teacher>();
    private List<Student> _students = new ArrayList<Student>();

    /**
     * Student Management Functions
     */

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
                return;
            }
        }
        System.out.println("Student not found");
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


    //Gets student's information and add to the list
    public Student addStud() {
        Scanner scanner = new Scanner(System.in);
        String firstName = inputString("Enter the First Name of the Student: ", false);
        String lastName = inputString("Enter the Last Name of the Student: ", false);
        int gender = inputInt("Enter the Gender of the Student [1]M | [2]F: ", false);
        String phoneNo = inputString("Enter the Phone Number of the Student: ", true);
        String address = inputString("Enter the Address of the Student: ");
        int repeatModules;
        int newModules = 0;
        int totalModules = 0;
        do {
            repeatModules = inputInt("Enter the Number of Repeat Modules of the Student: ");
            if (repeatModules < 3 && repeatModules >= 0) {
                do {
                    totalModules = repeatModules;
                    newModules = inputInt("Enter the Number of New Modules of the Student " +
                            "(total modules cannot be more than 6): ");
                    totalModules += newModules;
                } while (totalModules > 6 || totalModules < 0);
            }
        } while (repeatModules > 6 || repeatModules < 0);
        return new Student(firstName, lastName, gender, address, phoneNo, newModules, repeatModules);
    }

    //get new information and update existing student record by id
    public Student updateStud(int id) {
        Scanner scanner = new Scanner(System.in);
        String firstName = inputString("Enter the First Name of the Student: ", false);
        String lastName = inputString("Enter the Last Name of the Student: ", false);
        int gender = inputInt("Enter the Gender of the Student [1]M | [2]F: ", false);
        String phoneNo = inputString("Enter the Phone Number of the Student: ", true);
        String address = inputString("Enter the Address of the Student: ");
        int repeatModules;
        int newModules = 0;
        do {
            repeatModules = inputInt("Enter the Number of Repeat Modules of the Student: ");
            int totalModules;
            if (repeatModules < 3) {
                do {
                    totalModules = repeatModules;
                    newModules = inputInt("Enter the Number of New Modules of the Student " +
                            "(total modules cannot be more than 6): ");
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

    //add teacher to the list
    public void addTeacher() {
        addTeacher(addTeach());
        System.out.println("Teacher Added");
    }

    //Gets teacher's information
    public Teacher addTeach() {
        Scanner scanner = new Scanner(System.in);
        String firstName = inputString("Enter the First Name of the teacher: ", false);
        String lastName = inputString("Enter the Last Name of the teacher: ", false);
        int gender = inputInt("Enter the Gender of the teacher [1]M | [2]F: ", false);
        String phoneNo = inputString("Enter the PhoneNo of the teacher: ", true);
        String address = inputString("Enter the Address of the teacher: ");
        int department = inputInt("[1] for Computing \n[2] for Business \nEnter the department of the teacher: ", false);
        int designation = inputInt("[1] Head of Faculty\n[2] Coordinator\n[3] Lecturer\nEnter the designation of the teacher: ", true);
        int teachingHours = inputInt("Enter Number of Teaching Hours: ");

        return new Teacher(firstName, lastName, gender, address, phoneNo, department, designation, teachingHours);
    }

    //get new information and update existing teacher information by id
    public Teacher updateTeach(int id) {
        Scanner scanner = new Scanner(System.in);
        String firstName = inputString("Enter the First Name of the teacher: ", false);
        String lastName = inputString("Enter the Last Name of the teacher: ", false);
        int gender = inputInt("Enter the Gender of the teacher [1]M | [2]F: ", false);
        String phoneNo = inputString("Enter the Phone Number of the teacher: ", true);
        String address = inputString("Enter the Address of the teacher: ");
        int department = inputInt("[1] for Computing \n[2] for Business \nEnter the department of the teacher: ", false);
        int designation = inputInt("[1] Head of Faculty\n[2] Coordinator\n[3] Lecturer\nEnter the designation of the teacher: ", true);
        int teachingHours = inputInt("Enter Number of Teaching Hours");

        return new Teacher(id, firstName, lastName, gender, address, phoneNo, department, designation, teachingHours);

    }

    /**
     * Entry Validation
     */

    public int inputInt(String prompt) {
        Scanner scanner = new Scanner(System.in);
        int input = 0;
        boolean invalid = true;
        do {
            try {
                System.out.print(prompt);
                input = scanner.nextInt();
                invalid = input < 0;
                if (invalid) {
                    System.out.println("Cannot be negative");
                }

            } catch (Exception e) {
                invalid = true;
                System.out.println("Invalid Input");
                scanner.nextLine();
            }
        } while (invalid);

        return input;
    }

    public int inputInt(String prompt, boolean til3) {
        Scanner scanner = new Scanner(System.in);
        int input  = 0;
        boolean invalid = true;
        do {
            try {
                if (til3) {
                    do {
                        System.out.print(prompt);
                        input = scanner.nextInt();
                        invalid = input < 1 || input > 3;
                    } while (invalid);
                } else {
                    do {
                        System.out.print(prompt);
                        input = scanner.nextInt();
                        invalid = input < 1 || input > 2;
                    } while (invalid);
                }
            } catch (Exception e) {
                invalid = true;
                System.out.println("\nInput must be a number");
                scanner.nextLine();
            }
        } while (invalid);
        return input;
    }
    public String inputString(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        return scanner.nextLine();
    }
    public String inputString(String prompt, boolean aNumber) {
        Scanner scanner = new Scanner(System.in);
        String input;
        boolean invalid = true;
        if (aNumber) {
            do {
                System.out.print(prompt);
                input = scanner.nextLine();
                invalid = !input.matches("\\d{10}");
                if (invalid) {
                    System.out.println("\nPhone Number must be 10 digits");
                }
            } while (invalid);
        } else {
            do {
                System.out.print(prompt);
                input = scanner.nextLine();
                invalid = input.matches(".*\\d.*");
                if (invalid) {
                    System.out.println("\nInput cannot contain numbers");
                } else if (input.matches("^[\\s\\n\\r]*$")) {
                    invalid = true;
                    System.out.println("\nInput cannot be empty");
                }
            } while (invalid);
        }
        return input;
    }

    //checks if ID exists in the lists and decides whether to add an entry to the list or update an entry
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
