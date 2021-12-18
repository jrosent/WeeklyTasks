package weeklytasks.ui;

import java.awt.*;

public class GridBagSetUp extends GridBagConstraints {

    public GridBagSetUp() {
    }


    public void setUpGridBag(double wx, double wy, int gx, int gy,
                                     int fill, int anchor){
        this.weightx = wx;
        this.weighty = wy;
        this.gridx = gx;
        this.gridy = gy;
        this. fill = fill;
        this.anchor = anchor;
    }

    public void setUpGridBag(double wx, double wy, int gx, int gy, int fill){
        this.weightx = wx;
        this.weighty = wy;
        this.gridx = gx;
        this.gridy = gy;
        this.fill = fill;
    }


}
