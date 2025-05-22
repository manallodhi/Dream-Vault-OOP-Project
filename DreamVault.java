package dreamvault;

import java.util.ArrayList;

public class DreamVault {

	private ArrayList<Dream> dreams;

    public DreamVault() {
        dreams = new ArrayList<>();
    }

    public void addDream(String name, String description) {
        dreams.add(new Dream(name, description));
        System.out.println("Dream added successfully!");
    }

    public void viewDreams() {
        if (dreams.isEmpty()) {
            System.out.println("No dreams found.");
            return;
        }
        for (int i = 0; i < dreams.size(); i++) {
            Dream d = dreams.get(i);
            System.out.println("\nDream #" + i + ": " + d.getName());
            System.out.println("Description: " + d.getDescription());
            System.out.println("Progress: " + d.getProgress() + "%");
            d.viewMicroGoals();
        }
    }

    public void addMicroGoalToDream(int dreamIndex, String taskName) {
        if (dreamIndex >= 0 && dreamIndex < dreams.size()) {
            dreams.get(dreamIndex).addMicroGoal(taskName);
            System.out.println("Micro-goal added.");
        } else {
            System.out.println("Invalid dream index.");
        }
    }

    public void completeMicroGoal(int dreamIndex, int microGoalIndex) {
        if (dreamIndex >= 0 && dreamIndex < dreams.size()) {
            dreams.get(dreamIndex).completeMicroGoal(microGoalIndex);
        } else {
            System.out.println("Invalid dream index.");
        }
    }
}
