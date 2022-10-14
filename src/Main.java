
import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Accounting accounting = new Accounting();
		enum Department {
			Business, Computing
		}
		enum Designation {
			//Head of faculty (HOF)
			//Coordinator (CO)
			//Lecturer (L)
			HOF, CO, L
		}
		accounting.addTeacher(new Teacher(2020210, "Paul", "Ocampo", 1, "Manila", "9087238", 2, 3, 2 ));
		accounting.addTeacher(new Teacher(2020210, "John", "Anderson", 1, "Manila", "9087238", 2, 3, 2 ));
		accounting.addTeacher(new Teacher(2020210, "Lee", "Brown", 1, "Manila", "9087238", 2, 3, 8 ));
		accounting.addTeacher(new Teacher(2020210, "Thomas", "Lim", 1, "Manila", "9087238", 2, 2, 16 ));
		accounting.addTeacher(new Teacher(2020210, "Walker", "White", 1, "Manila", "9087238", 2, 3, 2 ));
		accounting.addTeacher(new Teacher(2020210, "Jackson", "Willis", 1, "Manila", "9087238", 1, 3, 2 ));
		accounting.addTeacher(new Teacher(2020210, "Amanda", "Garcia", 2, "Manila", "9087238", 2, 3, 2 ));
		accounting.addTeacher(new Teacher(2020210, "White", "Mill", 1, "Manila", "9087238", 2, 1, 17 ));

		accounting.addStudent(new Student(202222,"Chino","Piscasio", 1, "Caloocan", "09123456789", 2, 2, 1270));
		accounting.addStudent(new Student(202212,"Rezin","Corsino", 1, "Caloocan", "09123453452", 1, 1, 0));
		accounting.addStudent(new Student(202223,"John","Pagtalunan", 1, "Pasig", "09123456724", 2, 1, 0));
			int choice;
		do {
			System.out.println("Welcome to the Management System");
			System.out.println("Please select an option from the choices below:");
			System.out.println("[1] Student");
			System.out.println("[2] Teacher");
			System.out.println("[3] Exit");
			System.out.print("Choice: ");
			choice = scanner.nextInt();

			if (choice == 1) {
				int choice2, id;
				do {
					System.out.println("\nWelcome to the Student Menu");
					System.out.println("Please select an option from the choices below:");
					System.out.println("[1] Add Student");
					System.out.println("[2] Update Student");
					System.out.println("[3] Delete Student");
					System.out.println("[4] Show Remaining Balance");
					System.out.println("[5] Fee Deposit");
					System.out.println("[6] Display All Students with Zero Balance");
					System.out.println("[7] Display All Students with Non-Zero Balance");
					System.out.println("[8] Exit");
					System.out.print("Choice: ");
					choice2 = scanner.nextInt();

					if (choice2 == 1) {
						accounting.AddS();
					} else if (choice2 == 2) {
						System.out.print("Enter the ID of the Student: ");
						id = scanner.nextInt();
						accounting.updateStudent(id, accounting.StudentInfo());
					} else if (choice2 == 3) {
						System.out.print("Enter the ID of the student: ");
						id = scanner.nextInt();
						accounting.removeStudent(id);
						System.out.println("Student Deleted");
					} else if (choice2 == 4) {
						System.out.print("Enter the ID of the student: ");
						id = scanner.nextInt();
						accounting.showBalanceStudent(id);
					} else if (choice2 == 5) {
						System.out.print("Enter the ID of the student: ");
						id = scanner.nextInt();
						accounting.feeDeposit(id);
					} else if (choice2 == 6) {
						accounting.displayAllZeroBalance();
					} else if (choice2 == 7) {
						accounting.displayAllNonZeroBalance();
					}
					else {
						System.out.println("Invalid Input");
					}
				} while (choice2 != 8);


			} else if (choice == 2) {
				int choice2, id;
				do {
					System.out.println("\nWelcome to the Teacher Menu");
					System.out.println("Please select an option from the choices below:");
					System.out.println("[1] Add Teacher");
					System.out.println("[2] Update Teacher");
					System.out.println("[3] Delete Teacher");
					System.out.println("[4] Calculate Salary");
					System.out.println("[5] View All Teachers"); //better display
					System.out.println("[6] Exit");
					System.out.print("Choice: ");
					choice2 = scanner.nextInt();

					if (choice2 == 1) {
						accounting.addTeacher();
					} else if (choice2 == 2) {
						System.out.print("Enter the ID of the teacher you want to update: ");
						id = scanner.nextInt();
						accounting.updateTeacher(id, accounting.TeacherInfo());
					} else if (choice2 == 3) {
						System.out.print("Enter the ID of the teacher you want to delete: ");
						id = scanner.nextInt();
						accounting.deleteTeacher(id);
					} else if (choice2 == 4) {
						System.out.print("Enter the ID of teacher: ");
						id = scanner.nextInt();
						accounting.calculateSalary(id);
					} else if (choice2 == 5) {
						accounting.viewAllTeachers();
					} else {
						System.out.println("Invalid Choice");
					}
				} while (choice2 != 6);
			} else if(choice == 3) {
				System.out.println("Thank you for using the Management System");
				System.exit(0);
			} else {
				System.out.println("Invalid Choice");
			}

		}while (choice != 3);
	}
}
