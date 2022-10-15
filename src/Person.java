import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;
public class Person {
	private int _id, _gender;
	private String _firstName, _lastName, _address, _phoneNo;

	private String[] _genCon = {"Male", "Female"};

	public Person(String firstName, String lastName, int gender, String address, String phoneNumber) {
		_id = generateID();
		_firstName = firstName;
		_lastName = lastName;
		_gender = gender;
		_address = address;
		_phoneNo = phoneNumber;
	}

	/**
	 * Display Function
	 * */
	public void DisplayPerson() //Displays the attributes of the class Person
	{
		System.out.printf("║ %-10d ║ %-10s ║ %-13s ║ %-6s ║ %-11s ║ %10s ", _id, _firstName, _lastName, _genCon[_gender - 1], _address, _phoneNo);
//		System.out.println("ID: " + _id);
//		System.out.println("First Name: " + _firstName);
//		System.out.println("Last Name: " + _lastName);
//		System.out.println("Gender: " + _genCon[_gender - 1]);
//		System.out.println("Address: " + _address);
//		System.out.println("Phone Number: " + _phoneNo);
	}

	/**
	 * Generate Unique ID
	 */
	//set current year as prefix
	Date d = new Date();
	int year = (d.getYear() + 1900) * 1000000;
	private static AtomicLong idCounter = new AtomicLong();

//	public static String createID() //Makes sures that the id genereated is unique
//	{
//		return String.valueOf(idCounter.getAndIncrement());
//	}

	public int generateID() //Generates the unique ID
	{
		return (int) (year + idCounter.getAndIncrement());
	}

	/**
 	* Getters
 	* */
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
	 * */

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