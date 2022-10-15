
import java.util.Scanner;


public class Main {
	public static void Pause(){
		Scanner scan = new Scanner(System.in);
		System.out.print("Press any key to continue...");
		scan.nextLine();
	}

	public static void Clear() {
		for (int i = 0; i < 50; i++) {
			System.out.println();
		}
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Accounting accounting = new Accounting();
//		enum Department {
//			Business, Computing
//		}
//		enum Designation {
//			//Head of faculty (HOF)
//			//Coordinator (CO)
//			//Lecturer (L)
//			HOF, CO, L
//		}
		accounting.addTeacher(new Teacher("Paul", "Ocampo", 1, "Manila", "9532087238", 2, 3, 2 ));
		accounting.addTeacher(new Teacher("John", "Anderson", 1, "Manila", "9745087238", 2, 3, 2 ));
		accounting.addTeacher(new Teacher("Lee", "Brown", 1, "Manila", "9087232138", 2, 3, 8 ));
		accounting.addTeacher(new Teacher("Thomas", "Lim", 1, "Manila", "9087252338", 2, 2, 16 ));
		accounting.addTeacher(new Teacher("Walker", "White", 1, "Manila", "9087634238", 2, 3, 2 ));
		accounting.addTeacher(new Teacher("Jackson", "Willis", 1, "Manila", "9087734238", 1, 3, 2 ));
		accounting.addTeacher(new Teacher("Amanda", "Garcia", 2, "Manila", "9087233648", 2, 3, 2 ));
		accounting.addTeacher(new Teacher("Jose", "Rizal", 1, "Manila", "9087273438", 2, 1, 17 ));
		accounting.addTeacher(new Teacher("Leo", "Martinez", 1, "Manila", "9087273438", 2, 1, 17 ));
		accounting.addTeacher(new Teacher("Pao", "Guiverra", 1, "Manila", "9087273438", 2, 1, 17 ));
		accounting.addTeacher(new Teacher("Reymart", "Aguinaldo", 1, "Manila", "9087273438", 2, 1, 17 ));

		accounting.addStudent(new Student("Chino","Piscasio", 1, "Balintawak", "9163256789", 2, 2, 1270));
		accounting.addStudent(new Student("Rezin","Corsino", 1, "Caloocan", "9456253452", 6, 0, 500));
		accounting.addStudent(new Student("John","Pagtalunan", 1, "Bulacan", "9125236724", 6, 0, 500));
		accounting.addStudent(new Student("Mark","Bardelomar", 1, "Manila", "9983296724", 6, 0, 800));
		accounting.addStudent(new Student("Ivan","Sandigo", 1, "Recto", "9984298224", 6, 0, 2000));
		accounting.addStudent(new Student("Lim","Kim", 1, "Pasig", "9523981294", 6, 0, 1200));
		accounting.addStudent(new Student("Kang","Yap", 1, "Quezon City", "9598239824", 5, 1, 2735));
		accounting.addStudent(new Student("Gerykko","Manarang", 1, "Cavite", "9968239824", 5, 1, 2735));
		accounting.addStudent(new Student("Carmin","Insider", 2, "Mandaluyong", "9598536724", 2, 1, 1500));
		accounting.addStudent(new Student("Bob","Walker", 1, "Manila", "9083802724", 5, 1, 2000));
		accounting.addStudent(new Student("Luke","Dela Cruz", 1, "Sa Puso Mo", "9682928724", 5, 1, 3000));
		int choice;
		do {

			System.out.println("Welcome to the Management System");
			System.out.println("Please select an option from the choices below:");
			System.out.println("[1] Student");
			System.out.println("[2] Teacher");
			System.out.println("[3] Exit");
			System.out.print("Choice: ");
			choice = scanner.nextInt();
			Clear();
			if (choice == 1) {
				int id;
				do {
					Clear();
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
					choice = scanner.nextInt();
					Clear();
					if (choice == 1) {
						accounting.AddS();
					} else if (choice == 2) {
						System.out.print("Enter the ID of the Student: ");
						id = scanner.nextInt();
						accounting.updateStudent(id, accounting.addStud());
						Pause();
					} else if (choice == 3) {
						System.out.print("Enter the ID of the student: ");
						id = scanner.nextInt();
						accounting.deleteStudent(id);
						Pause();
					} else if (choice == 4) {
						System.out.print("Enter the ID of the student: ");
						id = scanner.nextInt();
						accounting.showBalanceStudent(id);
						Pause();
					} else if (choice == 5) {
						System.out.print("Enter the ID of the student: ");
						id = scanner.nextInt();
						accounting.feeDeposit(id);
						Pause();
					} else if (choice == 6) {
						accounting.displayAllZeroBalance();
						Pause();
					} else if (choice == 7) {
						accounting.displayAllNonZeroBalance();
						Pause();
					}
					else {
						System.out.println("Invalid Input");
					}
				} while (choice != 8);


			} else if (choice == 2) {
				int id;
				do {
					Clear();
					System.out.println("\nWelcome to the Teacher Menu");
					System.out.println("Please select an option from the choices below:");
					System.out.println("[1] Add Teacher");
					System.out.println("[2] Update Teacher");
					System.out.println("[3] Delete Teacher");
					System.out.println("[4] Calculate Salary");
					System.out.println("[5] View All Teachers"); //better display
					System.out.println("[6] Exit");
					System.out.print("Choice: ");
					choice = scanner.nextInt();
					Clear();
					if (choice == 1) {
						accounting.addTeacher();
						Pause();
						Clear();
					} else if (choice == 2) {
						System.out.print("Enter the ID of the teacher you want to update: ");
						id = scanner.nextInt();
						accounting.updateTeacher(id, accounting.addTeach());
						Pause();
						Clear();
					} else if (choice == 3) {
						System.out.print("Enter the ID of the teacher you want to delete: ");
						id = scanner.nextInt();
						accounting.deleteTeacher(id);
						Pause();
						Clear();
					} else if (choice == 4) {
						System.out.print("Enter the ID of teacher: ");
						id = scanner.nextInt();
						accounting.calculateSalary(id);
						Pause();
						Clear();
					} else if (choice == 5) {
						accounting.viewAllTeachers();
						Pause();
						Clear();
					} else {
						System.out.println("Invalid Choice");
						Pause();
						Clear();
					}
				} while (choice != 6);
			} else if(choice == 3) {
				System.out.println("Thank you for using the Management System");
				System.exit(0);
			} else {
				System.out.println("Invalid Choice");
			}

		}while (choice != 3);
	}
}
