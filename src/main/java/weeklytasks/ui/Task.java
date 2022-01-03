package weeklytasks.ui;

import javax.swing.*;
import java.util.Date;

public class Task {
    private Object[] taskInfo;
    private Boolean inProgress = false;

    public Task(){
        taskInfo = new Object[4];
    }

    public Task(int num, String desc, String date){
        taskInfo = new Object[4];
        taskInfo[0] = String.valueOf(num);
        taskInfo[1] = desc;
        taskInfo[2] = date;
        taskInfo[3] = inProgress;
    }

    /**
     * Gets the information about this task.
     * @return Object array of the task's information
     */
    public Object[] getTaskInfo(){
        return taskInfo;
    }

    public void editTask(String desc, String due){
        taskInfo[1] = desc;
        taskInfo[2] = due;
    }

}
