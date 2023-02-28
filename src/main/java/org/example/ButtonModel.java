package org.example;

import javax.swing.*;

public class ButtonModel  extends DefaultButtonModel {
    @Override
    public boolean isPressed() {
        return false;
    }

    @Override
    public boolean isRollover() {
        return false;
    }

    @Override
    public void setRollover(boolean b) {
        // No operation.
    }
}
