import java.util.HashMap;
import java.util.Map;

public class Teacher extends Person {
    private int _department;
    private int _designation;
    private float _salary = 1200f;
    private int _teachingHours;
    private float _ma;
    private float _ta;
    private float _ha;
    private float _ot;
    private String[] conDep = {"Business", "Computing"};
    private String[] conDes = {"Head of Faculty", "Coordinator", "Lecturer"};

    public Teacher(String firstName, String lastName, int gender, String address,
                   String phoneNumber, int department, int designation, int teachingHours) {
        super(firstName, lastName, gender, address, phoneNumber);
        _department = department;
        _designation = designation;
        _teachingHours = teachingHours;
        calculateSalary();
    }

    /**
    * Computational Functions
    **/

    public void calculateSalary()
    {
        if (_designation == 1) {
            //Head of Faculty
            if (_teachingHours > 8) {
                _ot += (_teachingHours - 8) * 325f;
            } else {
                _ot = 0;
            }
        } else if (_designation == 2) {
            //Coordinator
            if (_teachingHours > 13) {
                _ot += (_teachingHours - 13) * 325f;
            } else {
                _ot = 0;
            }
        } else if (_designation == 3) {
            //Lecturer
            if (_teachingHours > 18) {
                _ot += (_teachingHours - 18) * 325f;
            } else {
                _ot = 0;
            }
        }

        _salary += _ot;
        _ha = _salary *  0.1f;
        _ma = _salary * 0.03f;
        _ta = _salary * 0.05f;
        _salary += _ha +_ma+_ta;

    }

    /**
     * Display Function
     * */

    public void displayTeacher()
    {
        DisplayPerson();
        System.out.printf("║ %-10s ║ %-15s ║ %8.2f ║ %-3d ║%n",
                            conDep[_department - 1], conDes[_designation - 1], _salary, _teachingHours);
    }

    /**
    * Getters
    **/

    public double getMa() {
        return _ma;
    }


    public double getTa() {
        return _ta;
    }


    public float  getHa() {
        return _ha;
    }


    public double getOt() {
        return _ot;
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

    public int getDepartment() {
        return _department;
    }

    /**
     * Setters
    **/

    public void setDepartment(int department) {
        _department = department;
    }
    public void set_Ma(float _ma) {
        this._ma = _ma;
    }
    public void setTa(float _ta) {
        this._ta = _ta;
    }

    public void setDesignation(int designation) {
        _designation = designation;
    }

    public void setHa(float _ha) {
        this._ha = _ha;
    }
    public void setSalary(int salary) {
        _salary = salary;
    }

    public void setTeachingHours(int teachingHours) {
        _teachingHours = teachingHours;
    }

    public void setOt(float _ot) {
        this._ot = _ot;
    }
}