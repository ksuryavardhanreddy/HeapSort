package com.codewithsurya;

import java.awt.*;
import java.awt.event.*;

public class Input extends Frame implements ActionListener {
    Label l = new Label("Array :");
    TextField t = new TextField(20);
    Button b = new Button("Sort");

    Input() {
        this.setLayout(new FlowLayout());
        add(l);
        add(t);
        add(b);
        b.addActionListener(this);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String str = t.getText();
        str.trim();
        String[] integerStingArray = str.split(" ");
        Main.nodes=integerStingArray.length;
        Main.arr = new int[integerStingArray.length];
        for(int i=0; i<Main.arr.length; i++)
            Main.arr[i] = Integer.parseInt(integerStingArray[i]);

        HeapConsole hc =new HeapConsole();
        hc.setSize(HeapUtility.getTreeBaseLength()+1200, HeapUtility.getTreeBaseLength()+500);
        hc.setBackground(Color.BLACK);
        hc.setVisible(true);
    }

    public void paint(Graphics g) {
        g.drawString("1) Type array numbers into the above text-box separated by spaces as in [a b c d...]", 100 ,100);
        g.drawString("2) **Refrain from giving more than 15 numbers to sort", 100 ,120);
        g.drawString("   **Enter numbers less than 99,999 for sorting", 100 ,140);
        g.drawString("**The above restrictions are due display limitations", 100 ,160);
    }
}
