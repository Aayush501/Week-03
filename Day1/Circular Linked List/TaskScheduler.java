// definition of TaskNode class
class TaskNode {
    // declaring the attributes of this class
    private String taskName, taskID, priority, dueDate;
    TaskNode next;
    
    // created a parameterized constructor to initialize the object
    TaskNode(String taskName, String taskID, String priority, String dueDate) {
        this.taskName = taskName;
        this.taskID = taskID;
        this.priority = priority;
        this.dueDate = dueDate;
    }

    // created getter methods to maintain encapsulation and data security
    public String getTaskID()   {   return this.taskID;    }

    public String getTaskName() {   return this.taskName;    }

    public String getDueDate()  {   return this.dueDate;    }

    public String getPriority() {   return this.priority;    }
}

// definition of Task class
class Task {
    // declaring the attributes of this class
    TaskNode head, tail; // head of the linked list
    static int totalTasks=0;
    
    // created a parameterized constructor to initialize a linked list of Tasks
    Task(String taskName, String taskID, String priority, String dueDate) {
        head = new TaskNode(taskName, taskID, priority, dueDate);
        tail = head;
        tail.next = head; // this makes a circular list
        totalTasks++;
    }
    
    // created a method to display all Task records
    public void displayAllRecords() {
        TaskNode task = head;
        while (task != tail) {
            System.out.println("Name of the task: " + task.getTaskName() + "\nTask ID: " + task.getTaskID() + "\npriority: " + task.getPriority() + "\ndueDate: " + task.getDueDate() + "\n");
            task = task.next;
        }
        // displaying the details of the tail node
        System.out.println("Name of the task: " + task.getTaskName() + "\nTask ID: " + task.getTaskID() + "\npriority: " + task.getPriority() + "\ndueDate: " + task.getDueDate() + "\n");
    }
    
    // created a method addNewTask to add a new Task at the end of the list
    public void addTask(String taskName, String taskID, String priority, String dueDate) {
        addTask(taskName, taskID, priority, dueDate, totalTasks+1);
    }

    // created a method to add a record at any position of the list including the beginning and end position
    public void addTask(String taskName, String taskID, String priority, String dueDate, int position) {
        if (position == 1) { // if user wants to add a record at the beginning
            TaskNode newTask = new TaskNode(taskName, taskID, priority, dueDate);
            newTask.next = head;
            head = newTask;
            tail.next = head;
            totalTasks++;
            return;
        }
        if (position == totalTasks+1) { // if user wants to add a record at the end
            TaskNode newTask = new TaskNode(taskName, taskID, priority, dueDate);
            newTask.next = head;
            tail.next = newTask;
            tail = newTask;
            totalTasks++;
            return;
        }

        // if the inserting position is not the beginning
        TaskNode task1 = head;
        TaskNode task2 = null;

        // created an integer variable to iterate through the list till we reach to the position
        int i=1;
        while (i<position) { // after this loop we have to insert the new record between task1 and task2 nodes
            task2 = task1;
            task1 = task1.next;
            i++;
        }

        // initializing a new Task record
        TaskNode newTask = new TaskNode(taskName, taskID, priority, dueDate);

        // inserting the new record between task1 and task2
        newTask.next = task1;
        task2.next = newTask;
        totalTasks++;
    }

    /*
     created a method to search records by priority
     this method displays all records with required priority
    */
    public void searchTask(String priority) {
        // iterator for the list
        TaskNode task = head;
        while (task != tail) { // with this loop task1 will reach to the position that is required
            if (task.getPriority().equals(priority)) {
                System.out.println("Details of the Task:\nName: " + task.getTaskName() + "\nTask ID: " + task.getTaskID() + "\npriority: " + task.getPriority() + "\ndueDate: " + task.getDueDate() + "\n");
            }
            task = task.next;
        }
        if (task.getPriority().equals(priority)) { // condition for tail node
            System.out.println("Details of the Task:\nName: " + task.getTaskName() + "\nTask ID: " + task.getTaskID() + "\npriority: " + task.getPriority() + "\ndueDate: " + task.getDueDate() + "\n");
        } else {
            System.out.println("There are no tasks left with this priority.\n");
        }
    }

    // created a method to delete a record by taskID
    public void deleteByTaskID(String taskID) {
        if(head.getTaskID().equals(taskID)) { // if task ID is of head node
            tail.next = head.next;
            head = head.next;
            return;
        }

        // iterators for the list
        TaskNode task1 = head.next;
        TaskNode task2 = null;
        while (task1 != head) { // with this loop task1 will reach to the position that is needed to be deleted
            if (task1.getTaskID().equals(taskID)) {
                task2.next = task1.next;
                if(task1 == tail){
                    tail = task2;
                }
                task1 = null;
                totalTasks--;
                return;
            }
            task2 = task1;
            task1 = task1.next;
        }
        System.out.println("This Task does not exist.");
    }
}

// definition of TaskScheduler class
public class TaskScheduler {
    public static void main(String[] args) {
        // created a linked list of Tasks
        Task tasks = new Task("Task1", "1", "High", "29/01/2025");

        // iteration to add new Tasks
        for (int i = 0; i < 4; i++) {
            tasks.addTask("Task" + (i+2), "" + (i+2), (i%3==0)? "Medium" :(i%3==1)? "Low" : "High", "29/01/2025");
        }

        // displaying details of all Tasks
        tasks.displayAllRecords();

        // adding new record at beginning of the list
        tasks.addTask("Task0", "0", "Low", "29/01/2025", 1);

        // adding new record at the end of the list
        tasks.addTask("Task6", "6", "High", "29/01/2025", Task.totalTasks+1);

        // searching tasks of high priority
        tasks.searchTask("High");

        // searching tasks of medium priority
        tasks.searchTask("Medium");

        // searching tasks of Low priority
        tasks.searchTask("Low");

        // deleting a Task record by taskID
        tasks.deleteByTaskID("4");

        // displaying details of all Tasks
        tasks.displayAllRecords();
    }
}