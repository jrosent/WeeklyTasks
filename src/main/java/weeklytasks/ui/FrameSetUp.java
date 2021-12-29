package weeklytasks.ui;

import javax.swing.*;
import java.awt.*;

public class FrameSetUp {
    //Frame
    private JFrame frame;

    //Panels
    private JPanel taskButtons;
    private TaskAreaPanel center;
    private ToDoPanel taskArea;
    private CompletedPanel completedArea;
    private ButtonPanel buttonPanel;

    //Buttons
    private CompletedButtonPanel taskComplete;

    //Labels and Text
    private JLabel label;
    private JTextField input;
    private JTextArea ta;

    //Other
    private int width;
    private int height;

    public FrameSetUp(int w, int h){

        frame = new JFrame();
        taskButtons = new JPanel(new GridLayout(6,1));
        center = new TaskAreaPanel();
        taskArea = new ToDoPanel();
        completedArea = new CompletedPanel();
        buttonPanel = new ButtonPanel(center);
        buttonPanel.setButtonClick();

        taskComplete = new CompletedButtonPanel(center);

        width = w;
        height = h;
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    /**
     * Sets up and adds all the panels to the frame's ContentPane.
     */
    public void setUp(){

        //Set layout for content Pane
        Container cp = frame.getContentPane();

        cp.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        gc.gridx = 0;
        gc.gridy = 0;
        gc.weightx = 1;
        gc.weighty = 20;
        gc.fill = GridBagConstraints.BOTH;

        cp.add(buttonPanel,gc);

        gc.gridx = 1;
        gc.weightx = 20;

        cp.add(center,gc);

        gc.gridx = 0;
        gc.gridy = 1;
        gc.weightx = 1;
        gc.weighty = 2;
        gc.gridwidth = 2;

        cp.add(taskComplete,gc);

        frame.setSize(width,height);
        frame.setTitle("Task Master");
    }

    /**
     * Move selected tasks to completed
     */
    public void taskCompleted(){
        center.moveTasks();
    }
}
