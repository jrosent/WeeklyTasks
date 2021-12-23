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
    JButton taskComplete;

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
        buttonPanel = new ButtonPanel(taskArea,completedArea);
        buttonPanel.setButtonClick();

        taskComplete = new JButton("TASK COMPLETE!");

        width = w;
        height = h;
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void setUp(){

        //Set layout for content Pane
        Container cp = frame.getContentPane();
        cp.setLayout(new BorderLayout());


        frame.setSize(width,height);
        frame.setTitle("Tasks");

        //Add buttons to Task Buttons panel and add panel to frame
        cp.add(buttonPanel,BorderLayout.WEST);

        //Format and add task Complete button
        taskComplete.setBackground(Color.GREEN);
        taskComplete.setForeground(Color.BLACK);
        taskComplete.setRolloverEnabled(true);
        taskComplete.setFont(new Font("Cambria", Font.BOLD,20));
        cp.add(taskComplete,BorderLayout.SOUTH);

        /*
        center.setLayout(new GridBagLayout());
        GridBagSetUp gc = new GridBagSetUp();

        gc.setUpGridBag(1,1,0,0,GridBagSetUp.BOTH);
        center.add(taskArea,gc);

        gc.setUpGridBag(.0001,1,1,0,GridBagSetUp.BOTH);
        center.add(Box.createHorizontalStrut(10),gc);

        gc.setUpGridBag(1,1,2, 0,GridBagSetUp.BOTH);
        center.add(completedArea,gc);

         */

        cp.add(center,BorderLayout.CENTER);
    }
}
