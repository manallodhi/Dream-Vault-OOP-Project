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
			            System.out.println("5. Update a dream");
			            System.out.println("6. Delete a dream");
			            System.out.println("7. Exit");
			            System.out.print("Choose an option: ");

			            int choice = -1;
			            try {
			                choice = Integer.parseInt(sc.nextLine());
			            } catch (NumberFormatException e) {
			                System.out.println("Please enter a valid number.");
			                continue;
			            }

			            switch (choice) {
	                             
			                case 1 -> {
	                                 
			                	System.out.println();
			                    boolean adding = true;
			                    while (adding) {
			                        System.out.print("Enter dream name: ");
			                        String name = sc.nextLine();

			                        System.out.print("Enter dream description: ");
			                        String desc = sc.nextLine();

			                        vault.addDream(name, desc);
			                        System.out.println("Dream added successfully!");

			                        String response;
			                        while (true) {
			                           System.out.print("\nDo you want to add another dream? (yes/no): ");
			                           response = sc.nextLine().trim().toLowerCase();

			                        if (response.equals("yes")) {
			                            System.out.println();
			                         break; // continue adding
			                        } else if (response.equals("no")) {
			                         adding = false; // this is the correct variable
			                         break;
			                        } else {
			                         System.out.println("[ERROR] Please enter only 'yes' or 'no'.");
			                        }
			                        }

			                        }
			                    }
	                                 
			                case 2 -> vault.viewDreams();
	                                 
			                case 3 -> {
			                	System.out.println();

			                    if (vault.getDreamCount() == 0) {
			                        System.out.println("No dreams available. Please add a dream first.");
			                        break;
			                    }

			                    vault.listDreamTitles();

			                    System.out.print("Enter dream number to add micro-goal: ");
			                    int dIndex;
			                    try {
			                        dIndex = Integer.parseInt(sc.nextLine()) - 1;
			                    } catch (NumberFormatException e) {
			                        System.out.println("[ERROR] Invalid input. Please enter a number.");
			                        break;
			                    }

			                    if (dIndex < 0 || dIndex >= vault.getDreamCount()) {
			                        System.out.println("[ERROR] Invalid dream index.");
			                        break;
			                    }

			                    boolean adding = true;
			                    while (adding) {
			                        System.out.print("Enter micro-goal task: ");
			                        String task = sc.nextLine();
			                        vault.addMicroGoalToDream(dIndex, task);
			                        System.out.println("Micro-goal added.");

			                        while (true) {
			                            System.out.print("\nDo you want to mark another micro-goal for this dream? (yes/no): ");
			                            String again = sc.nextLine().trim().toLowerCase();

			                            if (again.equals("yes")) {
			                               break; // continue the loop
			                            } else if (again.equals("no")) {
			                               adding = false;
			                               break; // exit the loop
			                            } else {
			                               System.out.println("[ERROR] Please enter only 'yes' or 'no'.");
			                            }
			                        }
			                    }
			                }
	                                 
			                case 4 -> {
			                	System.out.println();
			                    if (vault.getDreamCount() == 0) {
			                        System.out.println("No dreams available. Please add a dream first.");
			                        break;
			                    }

			                    vault.listDreamTitles();

			                    System.out.print("\nEnter dream number (e.g., 1, 2, 3): ");
			                    int dreamIdx;
			                    try {
			                        dreamIdx = Integer.parseInt(sc.nextLine()) - 1;
			                        if (dreamIdx < 0 || dreamIdx >= vault.getDreamCount()) {
			                            System.out.println("[ERROR] Invalid dream number.");
			                            break;
			                        }
			                    } catch (NumberFormatException e) {
			                        System.out.println("[ERROR] Invalid input. Please enter a number.");
			                        break;
			                    }

			                    Dream selectedDream = vault.getDream(dreamIdx);
			                    if (selectedDream.getMicroGoalCount() == 0) {
			                        System.out.println("No micro-goals available for this dream.");
			                        break;
			                    }

			                    boolean marking = true;
			                    while (marking) {
			                        selectedDream.viewMicroGoals();
			                        System.out.print("\nEnter the micro-goal number to mark as complete (e.g., 1, 2): ");
			                        int microIdx;
			                        try {
			                            microIdx = Integer.parseInt(sc.nextLine()) - 1;
			                            if (microIdx < 0 || microIdx >= selectedDream.getMicroGoalCount()) {
			                                System.out.println("[ERROR] Invalid micro-goal number.");
			                                continue;
			                            }
			                        } catch (NumberFormatException e) {
			                            System.out.println("[ERROR] Invalid input. Please enter a number.");
			                            continue;
			                        }

			                        vault.completeMicroGoal(dreamIdx, microIdx);
			                        System.out.println("Micro-goal marked as completed!");

			                        while (true) {
			                           System.out.print("\nDo you want to mark another micro-goal for this dream? (yes/no): ");
			                           String again = sc.nextLine().trim().toLowerCase();

			                           if (again.equals("yes")) {
			                               break; // continue the loop
			                           } else if (again.equals("no")) {
			                               marking = false;
			                               break; // exit the loop
			                           } else {
			                               System.out.println("[ERROR] Please enter only 'yes' or 'no'.");
			                           }
			                        }

			                    }
			                }
			                
			                case 5 -> {

			                    System.out.println();

			                    if (vault.getDreamCount() == 0) {
			                        System.out.println("No dreams to update.");
			                        break;
			                    }

			                    vault.listDreamTitles();

			                    System.out.print("Enter dream number to update: ");
			                    int dIndex;
			                    try {
			                        dIndex = Integer.parseInt(sc.nextLine()) - 1;
			                        if (dIndex < 0 || dIndex >= vault.getDreamCount()) {
			                            System.out.println("Invalid dream index.");
			                            break;
			                        }
			                    } catch (NumberFormatException e) {
			                        System.out.println("Invalid input.");
			                        break;
			                    }

			                    System.out.print("Enter new dream name: ");
			                    String newName = sc.nextLine();

			                    System.out.print("Enter new dream description: ");
			                    String newDesc = sc.nextLine();

			                    vault.updateDream(dIndex, newName, newDesc);
			                }

			                case 6 -> {

			                	 System.out.println();

			                	    if (vault.getDreamCount() == 0) {
			                	        System.out.println("No dreams to delete.");
			                	        break;
			                	    }

			                	    vault.listDreamTitles();

			                	    System.out.print("Enter dream number to delete: ");
			                	    int dIndex;
			                	    try {
			                	        dIndex = Integer.parseInt(sc.nextLine()) - 1;
			                	        if (dIndex < 0 || dIndex >= vault.getDreamCount()) {
			                	            System.out.println("Invalid dream index.");
			                	            break;
			                	        }
			                	    } catch (NumberFormatException e) {
			                	        System.out.println("Invalid input.");
			                	        break;
			                	    }

			                
			                    vault.deleteDream(dIndex);
			                }
	                                
			                case 7 -> {
			                	  System.out.println();
	                                 running = false;
	                                 System.out.println("Exiting Dream Vault. Keep chasing your dreams!");
	                             }
	                                 
			                default -> System.out.println("Invalid option. Try again.");
			            
			        }
			       
		} 
			        sc.close();	
	}}

	

