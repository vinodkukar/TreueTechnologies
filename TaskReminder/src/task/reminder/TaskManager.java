package task.reminder;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {
	private List<Task> tasks;

	public TaskManager() {
		this.tasks = new ArrayList<>();
	}

	public void addTask(Task task) {
		tasks.add(task);
	}

	public void markTaskAsCompleted(int taskId) {
		if (taskId >= 0 && taskId <= tasks.size()) {
			int index = taskId - 1;
			tasks.get(index).setCompleted(true);
		} else
			System.out.println("Invalid Task ID");
	}

	public Task getTask(int index) {
		if (index >= 0 && index < tasks.size()) {
			return tasks.get(index);
		}
		return null;
	}

	public int getTaskCount() {
		return tasks.size();
	}
}
