package task.reminder;
import java.time.LocalDate;
public class Task {
      private String name;
      private LocalDate dueDate;
      private String category;
      private int priority;
      private boolean isCompleted;
      
      public Task(String name, LocalDate dueDate, String category, int priority) {
    	  this.name = name;
    	  this.dueDate = dueDate;
    	  this.category = category;
    	  this.priority = priority;
    	  this.isCompleted = false;
      }
      public boolean isCompleted() {
    	  return isCompleted;
      }
      public void setCompleted(boolean completed) {
    	  isCompleted = completed;
      }
      
      public String getName() {
    	  return name;
      }
      public LocalDate getDueDate() {
    	  return dueDate;
      }
      public String getCategory() {
    	  return category;
      }
      public int getPriority() {
    	  return priority;
      }
}
