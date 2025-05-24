package dreamvault;

import java.util.ArrayList;

public class Dream {
	
	private String name;
    private String description;
    private ArrayList<MicroGoal> microGoals = new ArrayList<>();

    public Dream() {

    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public int getMicroGoalCount() {
        return microGoals.size();
    }
    
    public void completeMicroGoal(int index) {
        if (index >= 0 && index < microGoals.size()) {
            microGoals.get(index).complete();
            
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
            System.out.println((i + 1) + ": " + microGoals.get(i));

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


public MicroGoal getMicroGoal(int index) {
    if (index >= 0 && index < microGoals.size()) {
        return microGoals.get(index);
    }
    return null;
}
}