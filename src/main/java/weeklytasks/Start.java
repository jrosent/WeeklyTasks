package weeklytasks;

import weeklytasks.ui.FrameSetUp;
import weeklytasks.ui.TaskAreaPanel;

import javax.swing.*;

public class Start {

    public static void main(String[] args){
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        }
        catch(Exception e){
            System.out.println("LAF didn't work");
        }
        FrameSetUp starter = new FrameSetUp(1000,500);
        starter.setUp();
    }
}
