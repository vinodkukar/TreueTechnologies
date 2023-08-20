package online.parking.system;

import java.util.Scanner;

public class ParkingApp {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ParkingSystem parkingSystem = new ParkingSystem(10);

		System.out.println("Welcome to the Online Parking System");
		System.out.println("Enter your username: ");
		String username = scanner.nextLine();
		System.out.println("Enter your password: ");
		String password = scanner.nextLine();

		if (parkingSystem.login(username, password)) {
			System.out.println("Login Successful");

			boolean running = true;
			while (running) {
				System.out.println("\n.....Dashboard....");
				System.out.println("1. My Slot");
				System.out.println("2. Book New Slot");
				System.out.println("3. Remove Slot");
				System.out.println("4. Logout");
				System.out.println("Enter your choice: ");
				int choice = scanner.nextInt();
				scanner.nextLine();

				switch (choice) {
				case 1:
					parkingSystem.displayBookings(username);
					break;
				case 2:
					parkingSystem.showAvailableParkingSpots();
					System.out.println("Enter the spot number to book: ");
					int spotNumber = scanner.nextInt();
					scanner.nextLine();
					boolean bookingStatus = parkingSystem.bookParkingSpot(username, spotNumber);
					if (bookingStatus) {
						System.out.println("Booking successful");
					} else {
						System.out.println("Failed to book the spot.please try again.");
					}
					break;
				case 3:
					parkingSystem.displayBookings(username);
					System.out.println("Enter the spot number to release: ");
					int spotToRelease = scanner.nextInt();
					boolean releaseStatus = parkingSystem.releaseParkingSpot(username, spotToRelease);
					if (releaseStatus) {
						System.out.println("Slot released successfully");
					} else {
						System.out.println("Failed to release the slot. please try again.");
					}
					break;
				case 4:
					System.out.println("Thanks for using the app. Do visit again!!!");
					running = false;
					break;
				default:
					System.out.println("Invalid choice. please try again.");
				}
			}
		} else {
			System.out.println("Invalid username or password. please try again.");
		}
		scanner.close();
	}

}
