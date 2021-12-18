package weeklytasks.ui;

import javax.swing.*;
import java.awt.*;

public class TaskCategory extends JPanel {

    private TaskTable taskTable;
    private JScrollPane taskScrollPane;
    private JLabel title;

    public TaskCategory(String title){
        this.setLayout(new GridBagLayout());
        GridBagSetUp gc = new GridBagSetUp();
        this.title = new JLabel(title);
        TaskTable taskTable = new TaskTable();
        taskScrollPane = new JScrollPane(taskTable);
        gc.setUpGridBag(1,1,0,
                0,GridBagSetUp.NONE,GridBagSetUp.SOUTHWEST);
        this.add(this.title,gc);
        gc.setUpGridBag(1,15,0,
                1,GridBagSetUp.BOTH,GridBagSetUp.WEST);
        this.add(taskScrollPane,gc);
    }
}
