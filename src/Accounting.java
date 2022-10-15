import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Accounting {
    private List<Teacher> _teachers = new ArrayList<Teacher>();
    private List<Student> _students = new ArrayList<Student>();

    /**
     * Student Management Functions
     **/
    public void addStudent(Student student) //Adds student to the list
    {
        _students.add(student);
    }

    public void updateStudent(int inputID, Student updatedInfo) //Updates student by ID with new information
    {
        _students.replaceAll( e -> e.getID() == inputID? updatedInfo : e);
    }

    public void showBalanceStudent(int id) //Display Balance of a student from ID
    {
        for (Student s : _students) {
            if (id == s.getID()){
                s.computeNumberOfModules();
                s.computeTotalAmount();
                s.computeBalance();
                System.out.println("Student ID: " + s.getID());
                System.out.println("Student Name: " + s.getFirstName() + " " + s.getLastName());
                System.out.println("Student Balance: " + s.getAmountBalance());
            }
        }
    }

    public void feeDeposit(int id) //Gets the amount paid of the student
    {
        Scanner scan = new Scanner(System.in);
        for (Student s : _students) {
            if (id == s.getID()){
                System.out.print("Enter Amount of Payment: ");
                int amount = scan.nextInt();
                s.setAmountPaid(s.getAmountPaid() + amount);
                s.computeBalance();
                System.out.println("Your new balance is: " + s.getAmountBalance());
            }
        }
    }

    public void displayAllStudentsHeader() {
        System.out.printf("╠════════════╬════════════╬═══════════════╬════════╬═════════════╬════════════╬═════════════╬═════════╬══════════════╬═════════════╬══════════════════╬═══════════════╣%n");
    }

    public void displayAllZeroBalance() //Displays all students with zero balance
    {
        DisplayPersonHeader();
        System.out.printf("║ %-11s ║ %-7s ║ %-12s ║ %-11s ║ %-16s ║ %-13s ║%n", "Amount Paid", "Balance", "Total Amount", "New Modules", "Repeated Modules", "Total Modules");
        displayAllStudentsHeader();
        for (Student s : _students) {
            s.computeNumberOfModules();
            s.computeTotalAmount();
            s.computeBalance();
            if (s.getAmountBalance() == 0){
                s.displayStudentInfo();
            }
        }
    }

    public void displayAllNonZeroBalance() //Displays all students with non zero balance
    {
        DisplayPersonHeader();
        System.out.printf("║ %-11s ║ %-7s ║ %-12s ║ %-11s ║ %-16s ║ %-13s ║%n", "Amount Paid", "Balance", "Total Amount", "New Modules", "Repeated Modules", "Total Modules");
        displayAllStudentsHeader();
        for (Student s : _students) {
            s.computeNumberOfModules();
            s.computeTotalAmount();
            s.computeBalance();
            if (s.getAmountBalance() != 0){
               s.displayStudentInfo();
            }
        }
    }
    public void deleteStudent(int inputID) //Deletes student from list by ID
    {
        _students.removeIf(e -> (e.getID() == inputID));
    }


    public Student StudentInfo()//Gets student's information
    {
        Scanner scanner = new Scanner(System.in);
        int newModules = 0;
        System.out.print("Enter the First Name of the Student: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter the Last Name of the Student: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter the Gender of the Student [1]M|[2]F: ");
        int gender = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter the Phone Number of the Student: ");
        String phoneNo = scanner.nextLine();
        System.out.print("Enter the Address of the Student: ");
        String address = scanner.nextLine();
        System.out.print("Enter the Number of Repeat Modules of the Student: ");
        int repeatModules = scanner.nextInt();
        int totalModules = repeatModules;
        if (repeatModules < 3) {
            do{
                newModules = 0;
                Main.Clear();
                System.out.println("Enter the Number of New Modules of the Student: ");
                newModules = scanner.nextInt();
                totalModules += newModules;
            }while(totalModules <=6);
        }
        Student student1 = new Student(firstName, lastName, gender, phoneNo, address, newModules, repeatModules);
        return student1;
    }


    public void AddS()//Adds student to the list
    {
        addStudent(StudentInfo());
        Main.Clear();
        System.out.println("Student Added");
        Main.Pause();
    }

    /**
     * Teacher Management Functions
     * */
    public void addTeacher(Teacher teacher)  //Adds teacher to the list
    {
        _teachers.add(teacher);
    }

    public void updateTeacher(int ID, Teacher entry)//Searches for teacher by ID and updates the information
    {
        _teachers.replaceAll(e -> e.getID() == ID ? entry : e);
    }

    public void deleteTeacher(int Id)  //Searches for teacher by ID and deletes the information
    {
        _teachers.removeIf(entry -> entry.getID() == Id);
    }

    public void calculateSalary(int Id) //Searches for teacher by ID and calculates the salary
    {
        for (Teacher t : _teachers) {
            if (Id == t.getID()){
                t.calculateSalary();
                System.out.println("Salary Calculated");
                System.out.println("Salary: " + t.getSalary());
            }
        }
    }

    public void DisplayPersonHeader()
    {
        System.out.printf("║ %6s     ║ %-10s ║ %11s   ║ %-6s ║ %9s   ║ %7s    ", "ID", "First Name", "Last Name", "Gender", "Address", "Phone");
    }

    public void viewAllTeachers() //Displays all teachers
    {
        DisplayPersonHeader();
        System.out.printf("║ %-10s ║ %13s   ║ %7s  ║ %3s ║%n", "Department", "Designation", "Salary", "Hrs");
        System.out.printf("╠════════════╬════════════╬═══════════════╬════════╬═════════════╬════════════╬════════════╬═════════════════╬══════════╬═════╣%n");
        for (Teacher entry : _teachers) {
            entry.displayTeacher();
        }
    }

    public void addTeacher()
    {
        addTeacher(TeacherInfo());
        System.out.println("Teacher Added");
    }

    public Teacher TeacherInfo() //Gets teacher's information
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the First Name of the teacher: ");
        String firstName = scanner.next();
        scanner.nextLine();
        System.out.print("Enter the Last Name of the teacher: ");
        String lastName = scanner.next();
        scanner.nextLine();
        System.out.print("Enter the Gender of the teacher [1]M|[2]F: ");
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

        Teacher teacher = new Teacher(firstName, lastName, gender, address, phoneNo, department, designation, teachingHours);
        return teacher;
    }
}
