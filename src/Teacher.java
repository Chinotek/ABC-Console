import java.util.HashMap;
import java.util.Map;

public class Teacher extends Person {
    private int _department;
    private int _designation;
    private double _salary = 1200;
    private int _teachingHours;
    private String[] conDep = {"Business", "Computing"};
    private String[] conDes = {"Head of Faculty", "Coordinator", "Lecturer"};

    public Teacher(String firstName, String lastName, int gender, String address, String phoneNumber, int department, int designation, int teachingHours) {
        super(firstName, lastName, gender, address, phoneNumber);
        _department = department;
        _designation = designation;
        _teachingHours = teachingHours;
        calculateSalary();
    }

    private Map<Integer, String> Designation = new HashMap<Integer, String>() //assign a specific number to a designation
    {
        {{
            put(1, "HOF");
            put(2, "CO");
            put(3, "L");
        }}
    };

    public enum Designation {
        HeadOfFaculty,
        Coordinator,
        Lecturer
    }

    /**
    * Computational Functions
    **/

    public void calculateSalary() // Calculates the salary of the teacher
    {
        double ha, ma, ta;
        switch (_designation) {
            case 1:
                System.out.println("Head of Faculty");
                if (_teachingHours > 8) {
                    _salary += (_teachingHours - 8) * 325;
                }

                break;
            case 2:
                System.out.println("Coordinator");
                if (_teachingHours > 13) {
                    _salary += (_teachingHours - 13) * 325;
                }
                break;
            case 3:
                System.out.println("Lecturer");
                if (_teachingHours > 18) {
                    _salary += (_teachingHours - 18) * 325;
                }
                break;
            default:
                System.out.println("Invalid designation");
                break;
        }

        ha = _salary*0.1;
        ma = _salary*0.03;
        ta = _salary*0.05;
        _salary += ha+ma+ta;

    }

    /**
     * Display Function
     * */

    public void displayTeacher() //Displays the attributes of the Teacher Class
    {
        DisplayPerson();
        System.out.printf("║ %-10s ║ %-15s ║ %.2f ║ %3d ║%n", conDep[_department - 1], conDes[_designation - 1], _salary, _teachingHours);
//        System.out.println("Department: " + conDep[_department - 1] );
//        System.out.println("Designation: " + conDes[_designation - 1]);
//        System.out.println("Salary: " + _salary);
//        System.out.println("Teaching Hours: " + _teachingHours);
    }

    /**
    * Getters
    **/

    public int getDepartment() {
        return _department;
    }

    public int getDesignation() {
        return _designation;
    }

    public double getSalary() {
        return _salary;
    }

    public int getTeachingHours() {
        return _teachingHours;
    }

    /**
     * Setters
    **/

    public void setDepartment(int department) {
        _department = department;
    }

    public void setDesignation(int designation) {
        _designation = designation;
    }

    public void setSalary(int salary) {
        _salary = salary;
    }

    public void setTeachingHours(int teachingHours) {
        _teachingHours = teachingHours;
    }
}