package dreamvault;

import java.util.Scanner;

public class Main {

		 public static void main(String[] args) {
		        Scanner sc = new Scanner(System.in);
		        DreamVault vault = new DreamVault();

		        boolean running = true;
		        while (running) {
		            System.out.println("\n==== Dream Vault Menu ====");
		            System.out.println("1. Add a new dream");
		            System.out.println("2. View all dreams");
		            System.out.println("3. Add a micro-goal to a dream");
		            System.out.println("4. Complete a micro-goal");
		            System.out.println("5. Exit");
		            System.out.print("Choose an option: ");

		            int choice = -1;
		            try {
		                choice = Integer.parseInt(sc.nextLine());
		            } catch (NumberFormatException e) {
		                System.out.println("Please enter a valid number.");
		                continue;
		            }

		            switch (choice) {
		                case 1:
		                    System.out.print("Enter dream name: ");
		                    String name = sc.nextLine();
		                    System.out.print("Enter dream description: ");
		                    String desc = sc.nextLine();
		                    vault.addDream(name, desc);
		                    break;
		                case 2:
		                    vault.viewDreams();
		                    break;
		                case 3:
		                    System.out.print("Enter dream index to add micro-goal: ");
		                    int dIndex = Integer.parseInt(sc.nextLine());
		                    System.out.print("Enter micro-goal task: ");
		                    String task = sc.nextLine();
		                    vault.addMicroGoalToDream(dIndex, task);
		                    break;
		                case 4:
		                    System.out.print("Enter dream index: ");
		                    int dreamIdx = Integer.parseInt(sc.nextLine());
		                    System.out.print("Enter micro-goal index to mark complete: ");
		                    int microIdx = Integer.parseInt(sc.nextLine());
		                    vault.completeMicroGoal(dreamIdx, microIdx);
		                    break;
		                case 5:
		                    running = false;
		                    System.out.println("Exiting Dream Vault. Keep chasing your dreams!");
		                    break;
		                default:
		                    System.out.println("Invalid option. Try again.");
		            }
		        }
		        sc.close();
		
	}

}
