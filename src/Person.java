import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

public class Person {
    private int _id, _gender;
    private String _firstName, _lastName, _address, _phoneNo;

    private String[] _genCon = {"Male", "Female"};

    /**
     * Constructors
     */

    public Person(String firstName, String lastName, int gender, String address, String phoneNumber) {
        _id = generateID();
        _firstName = firstName;
        _lastName = lastName;
        _gender = gender;
        _address = address;
        _phoneNo = phoneNumber;
    }

    public Person(int id, String firstName, String lastName, int gender, String address, String phoneNumber) {
        _id = id;
        _firstName = firstName;
        _lastName = lastName;
        _gender = gender;
        _address = address;
        _phoneNo = phoneNumber;
    }

    /**
     * Display Function
     */

    //Displays the attributes of the class Person
    public void DisplayPerson() {
        System.out.printf("║ %-10d ║ %-10s ║ %-13s ║ %-6s ║ %-11s ║ %10s ",
                _id, _firstName, _lastName, _genCon[_gender - 1], _address, _phoneNo);
    }

    /**
     * Generate Unique ID
     */

    //set current year as prefix
    Date d = new Date();
    int year = (d.getYear() + 1900) * 1000000;
    private static AtomicLong idCounter = new AtomicLong();

    //Generates the unique ID
    public int generateID() {
        return (int) (year + idCounter.getAndIncrement());
    }

    /**
     * Getters
     */

    public int getID() {
        return _id;
    }

    public String getFirstName() {
        return _firstName;
    }

    public String getLastName() {
        return _lastName;
    }

    public int getGender() {
        return _gender;
    }

    public String getAddress() {
        return _address;
    }

    public String getPhoneNumber() {
        return _phoneNo;
    }

    /**
     * Setters
     */

    public void setID(int ID) {
        this._id = ID;
    }

    public void setFirstName(String firstName) {
        _firstName = firstName;
    }

    public void setLastName(String lastName) {
        _lastName = lastName;
    }

    public void setGender(int gender) {
        _gender = gender;
    }

    public void setAddress(String address) {
        _address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        _phoneNo = phoneNumber;
    }

}