package weeklytasks.ui;

import java.util.Date;

public class Task {
    private Object[] taskInfo;

    public Task(int num, String desc, String date){
        taskInfo = new String[3];
        taskInfo[0] = String.valueOf(num);
        taskInfo[1] = desc;
        taskInfo[2] = date;
    }

    public Object[] getTaskInfo(){
        return taskInfo;
    }
}
