package weeklytasks.ui;

import javax.swing.*;
import java.util.Date;

public class Task {
    private Object[] taskInfo;
    private Boolean completed = false;
    private final int ARRAYLENGTH = 4;
    private final int TASKNUM = 0;
    private final int DESC = 1;
    private final int  DATE = 2;
    private final int COMPLETEDINDEX = 3;

    public Task(){
        taskInfo = new Object[ARRAYLENGTH];
    }

    public Task(int num, String desc, String date){
        taskInfo = new Object[ARRAYLENGTH];
        taskInfo[TASKNUM] = String.valueOf(num);
        taskInfo[DESC] = desc;
        taskInfo[DATE] = date;
        taskInfo[COMPLETEDINDEX] = completed;
    }

    /**
     * Gets the information about this task.
     * @return Object array of the task's information
     */
    public Object[] getTaskInfo(){
        return taskInfo;
    }

    /**
     * Edits the information in taskInfo array
     * @param desc new task description
     * @param due new due date
     */
    public void editTask(String desc, String due){
        taskInfo[DESC] = desc;
        taskInfo[DATE] = due;
    }

}
