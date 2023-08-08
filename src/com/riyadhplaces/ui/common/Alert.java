package com.riyadhplaces.ui.common;

import java.awt.Component;
import javax.swing.Icon;
import javax.swing.JOptionPane;

public class Alert {

    private Alert() {

    }

    public static void info(Component target, String message) {
        JOptionPane.showMessageDialog(target, message);
    }

    public static void error(Component target, String message, String title) {
        JOptionPane.showMessageDialog(
                target,
                message,
                title,
                JOptionPane.ERROR_MESSAGE);
    }

    public static void info(Component target, String message, String title, Icon icon) {
        JOptionPane.showMessageDialog(
                target,
                message,
                title,
                JOptionPane.INFORMATION_MESSAGE,
                icon);
    }
}
