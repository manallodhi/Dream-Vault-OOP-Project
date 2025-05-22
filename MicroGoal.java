package dreamvault;

public class MicroGoal {
	
	private String taskName;
    private boolean isCompleted;

    // Constructor
    public MicroGoal(String taskName) {
        this.taskName = taskName;
        this.isCompleted = false;
    }

    // Mark the task as completed
    public void complete() {
        this.isCompleted = true;
    }

    // Getters
    public String getTaskName() {
        return taskName;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    // To display the task
    @Override
    public String toString() {
        return (isCompleted ? "[✓] " : "[ ] ") + taskName;
    }

}
