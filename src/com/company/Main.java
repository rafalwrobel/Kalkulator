package com.company;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Kalkulator - Rafał Wróbel IISt 4.7/13");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new Okienko().getMojPanel());
        frame.setMinimumSize(new Dimension(600,600));
        frame.pack();
        frame.setVisible(true);

    }
}
