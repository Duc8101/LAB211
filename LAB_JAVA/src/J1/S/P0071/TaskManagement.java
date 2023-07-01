package J1.S.P0071;

import java.util.*;

public class TaskManagement {

    private final List<Task> list = new ArrayList<>();
    private final Inputter input = new Inputter();

    public TaskManagement() {

    }

    // add task 
    int addTask(int ID) {
        String RequirementName = input.InputRequirementName();
        String TaskType = input.InputTaskType();
        String date = input.InputDate();
        double PlanFrom;
        double PlanTo;
        boolean check;
        // loop until input plan from less than input plan to
        do {
            System.out.print("From: ");
            PlanFrom = input.InputPlan();
            System.out.print("To: ");
            PlanTo = input.InputPlan();
            check = isPlanFromLessThanPlanTo(PlanFrom, PlanTo);
        } while (check == false);
        String assignee = input.InputTrueFormat("Assignee");
        check = isExist(assignee, date, PlanFrom, PlanTo);
        // if task exist
        if (check == true) {
            System.err.println("The assignee had a task in the above time period!!!");
        } else {
            String reviewer = input.InputTrueFormat("Reviewer");
            Task task = new Task(ID, TaskType, RequirementName, date, PlanFrom, PlanTo, assignee, reviewer);
            list.add(task);
            ID++;
            System.out.println("Add successful");
        }
        return ID;
    }

    // check plan from less than plan to
    private boolean isPlanFromLessThanPlanTo(double PlanFrom, double PlanTo) {
        // if plan from greater or equal plan to
        if (PlanFrom >= PlanTo) {
            System.err.println("Plan from must be less than plan to");
            return false;
        }
        return true;
    }

    // check intersection time
    private boolean isIntersectionTime(double planFrom, double planTo, double planFromInList, double planToInList) {
        return (planFrom > planFromInList && planFrom < planToInList && planTo > planToInList)
                || (planTo > planFromInList && planTo < planToInList && planFrom < planFromInList)
                || ((planFrom > planFromInList && planFrom < planToInList) && (planTo > planFromInList && planTo < planToInList))
                || (planFrom < planFromInList && planTo > planToInList);
    }

    // check task exist
    private boolean isExist(String assignee, String date, double planFrom, double planTo) {
        // loop for traverse through list task
        for (Task task : list) {
            // if task exist
            if (assignee.equalsIgnoreCase(task.getAssignee()) && date.equalsIgnoreCase(task.getDate())
                    && isIntersectionTime(planFrom, planTo, task.getPlanFrom(), task.getPlanTo())) {
                return true;
            }
        }
        return false;
    }

    // get task found by ID
    private Task getTask(int ID) {
        // loop for traverse through list
        for (Task task : list) {
            // if ID exist in list
            if (ID == task.getId()) {
                return task;
            }

        }
        return null;
    }

    // delete task
    void deleteTask() {
        // if list empty
        if (list.isEmpty()) {
            System.err.println("List empty");
        } else {
            int ID = input.InputID();
            Task task = getTask(ID);
            // if ID not exist
            if (task == null) {
                System.err.println("Not Found ID");
            } else {
                list.remove(task);
                System.out.println("Delete successful");
            }
        }

    }

    // get data task
    void getDataTasks() {
        // if list is empty
        if (list.isEmpty()) {
            System.err.println("List task is empty");
        } else {
            System.out.println("------------------------------- Task ----------------------------------------");
            System.out.format("%-5s%-15s%-15s%-15s%-10s%-15s%-15s\n", "ID", "Name", "Task Type", "Date", "Time", "Assignee", "Reviewer");
            // loop traverse through all task in list
            for (Task task : list) {
                System.out.format("%-5s%-15s%-15s%-15s%-10.1f%-15s%-15s\n", task.getId(), task.getRequirementName(),
                        task.getTaskType(), task.getDate(), task.getPlanTo() - task.getPlanFrom(),
                        task.getAssignee(), task.getReviewer());
            }
        }

    }

}
