package weeklytasks;

import weeklytasks.ui.CategoryInfoDialog;
import weeklytasks.ui.Frame;
import weeklytasks.ui.TaskInfoDialog;

import javax.swing.*;

public class Start {

    public static void main(String[] args){
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        }
        catch(Exception e){
            System.out.println("LAF didn't work");
        }
        Frame starter = new Frame(1000,1000);
        //TaskInfoDialog cat = new TaskInfoDialog();
    }
}
