package dreamvault;

import java.util.ArrayList;

public class DreamVault {

    private ArrayList<Dream> dreams = new ArrayList<>(); // initialized directly, no constructor needed

    public void addDream(String name, String description) {
        Dream d = new Dream();
        d.setName(name);
        d.setDescription(description);
        dreams.add(d);
    }     

public void viewDreams() {
        if (dreams.isEmpty()) {
            System.out.println("No dreams found.");
            return;
        }
        for (int i = 0; i < dreams.size(); i++) {
            Dream d = dreams.get(i);
            // changed i to i + 1 
            System.out.println("\nDream #" + (i+1) + ": " + d.getName());
            System.out.println("Description: " + d.getDescription());
            
            int progress = d.getProgress();
            String bar = "";
            for (int j = 0; j < 10; j++) {
                if (j < progress / 10) bar += "#";
                else bar += "-";
            }

            System.out.println("Progress: " + bar + " , " + progress + "%");   
            d.viewMicroGoals();
        }
    }


public int getDreamCount() {
    return dreams.size();
    }
    
    public Dream getDream(int index) {
    return dreams.get(index);
    }

    public void addMicroGoalToDream(int dreamIndex, String taskName) {
        if (dreamIndex >= 0 && dreamIndex < dreams.size()) {
            dreams.get(dreamIndex).addMicroGoal(taskName);
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
    
    public void updateDream(int dreamIndex, String newName, String newDescription) {
        if (dreamIndex >= 0 && dreamIndex < dreams.size()) {
            Dream d = dreams.get(dreamIndex);
            d.setName(newName);
            d.setDescription(newDescription);
            System.out.println("Dream updated successfully!");
        } else {
            System.out.println("Invalid dream index.");
        }
    }

    public void deleteDream(int dreamIndex) {
        if (dreamIndex >= 0 && dreamIndex < dreams.size()) {
            dreams.remove(dreamIndex);
            System.out.println("Dream deleted successfully!");
        } else {
            System.out.println("Invalid dream index.");
        }
    }
    
    public void listDreamTitles() {
        if (dreams.isEmpty()) {
            System.out.println("No dreams found.");
            return;
        }
        for (int i = 0; i < dreams.size(); i++) {
            System.out.println("Dream #" + (i + 1) + ": " + dreams.get(i).getName());
        }
    }



}



