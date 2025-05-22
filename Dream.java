package dreamvault;

import java.util.ArrayList;

public class Dream {
	
	private String name;
    private String description;
    private ArrayList<MicroGoal> microGoals;

    public Dream(String name, String description) {
        this.name = name;
        this.description = description;
        this.microGoals = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void addMicroGoal(String taskName) {
        microGoals.add(new MicroGoal(taskName));
    }

    public void completeMicroGoal(int index) {
        if (index >= 0 && index < microGoals.size()) {
            microGoals.get(index).complete();
            System.out.println("Micro-goal marked as completed!");
        } else {
            System.out.println("Invalid micro-goal index.");
        }
    }

    public void viewMicroGoals() {
        if (microGoals.isEmpty()) {
            System.out.println("No micro-goals added yet.");
            return;
        }
        for (int i = 0; i < microGoals.size(); i++) {
            System.out.println(i + ": " + microGoals.get(i));
        }
    }

    public int getProgress() {
        if (microGoals.isEmpty()) return 0;

        int completedCount = 0;
        for (MicroGoal mg : microGoals) {
            if (mg.isCompleted()) completedCount++;
        }
        return (completedCount * 100) / microGoals.size();
    }
}
