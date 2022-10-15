import java.util.HashMap;
import java.util.Map;

public class Teacher extends Person {
    private int _department;
    private int _designation;
    private double _salary = 1200f;
    private int _teachingHours;
    private double _ma;
    private double _ta;
    private double _ha;
    private double _ot;
    private String[] conDep = {"Business", "Computing"};
    private String[] conDes = {"Head of Faculty", "Coordinator", "Lecturer"};

    public Teacher(String firstName, String lastName, int gender, String address, String phoneNumber, int department, int designation, int teachingHours) {
        super(firstName, lastName, gender, address, phoneNumber);
        _department = department;
        _designation = designation;
        _teachingHours = teachingHours;
    }

    private Map<Integer, String> Designation = new HashMap<Integer, String>() //assign a specific number to a designation
    {
        {{
            put(1, "HOF");
            put(2, "CO");
            put(3, "L");
        }}
    };

    public double getMa() {
        return _ma;
    }

    public void set_Ma(double _ma) {
        this._ma = _ma;
    }

    public double getTa() {
        return _ta;
    }

    public void setTa(double _ta) {
        this._ta = _ta;
    }

    public double getHa() {
        return _ha;
    }

    public void setHa(double _ha) {
        this._ha = _ha;
    }

    public double getOt() {
        return _ot;
    }

    public void setOt(double _ot) {
        this._ot = _ot;
    }

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
        if (_designation == 1) {
            //Head of Faculty
            if (_teachingHours > 8) {
                _ot += (_teachingHours - 8) * 325;
            } else {
                _ot = 0;
            }
        } else if (_designation == 2) {
            //Coordinator
            if (_teachingHours > 13) {
                _ot += (_teachingHours - 13) * 325;
            } else {
                _ot = 0;
            }
        } else if (_designation == 3) {
            //Lecturer
            if (_teachingHours > 18) {
                _ot += (_teachingHours - 18) * 325;
            } else {
                _ot = 0;
            }
        }

        _salary += _ot;
        _ha = _salary * 0.1;
        _ma = _salary*0.03;
        _ta = _salary*0.05;
        _salary += _ha +_ma+_ta;

    }

    /**
     * Display Function
     * */

    public void displayTeacher() //Displays the attributes of the Teacher Class
    {
        DisplayPerson();
        System.out.printf("║ %-10s ║ %-15s ║ %8.2f ║ %-3d ║%n", conDep[_department - 1], conDes[_designation - 1], _salary, _teachingHours);
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