package com.codewithsurya;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.*;

public class HeapConsole extends Frame {
    private final int circleParameter = DisplayPositionSetter.circleDiameter;
    static int unsortedCounter=0;
    static int sortedCounter =0;
    HeapConsole() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
    public void paint(Graphics g) {
        Font currentFont = g.getFont();
        Font newFont = currentFont.deriveFont(currentFont.getSize() * 1.6F);
        g.setFont(newFont);
        for(int i=0; i<Main.nodes; i++, unsortedCounter+=63) {
            g.setColor(Color.lightGray);
            g.fillOval(unsortedCounter + 63, 70, 60, 60);
            g.setColor(Color.BLACK);
            g.drawString(""+Main.arr[i], unsortedCounter +(circleParameter/2)-HeapUtility.positioner(Main.arr[i])+63, 105);
        }
        g.setColor(Color.lightGray);
        g.drawString("Given array", 65, 55);
        DisplayPositionSetter.PositionSetter();
        DisplayPositionSetter.childEdgeSetter();
        //----------- creating a binary tree frame for the number of nodes -----------//
        setComments();
        procedureSleep(3000);

        for(int i=0; i<Main.nodes; i++) {
            g.setColor(Color.LIGHT_GRAY);
            g.fillOval((int)DisplayPositionSetter.queue[i].HorizontalPos,DisplayPositionSetter.queue[i].VerticalPos,circleParameter, circleParameter);
            g.setColor(Color.BLACK);
            g.drawString(""+DisplayPositionSetter.queue[i].data, (int)DisplayPositionSetter.queue[i].HorizontalPos+(circleParameter/2)-HeapUtility.positioner(DisplayPositionSetter.queue[i].data), DisplayPositionSetter.queue[i].VerticalPos+35);
            g.setColor(Color.WHITE);
            if(i>0 && ((i-1)/2)*2+1==i)
                g.drawLine((int)DisplayPositionSetter.queue[(i-1)/2].HorizontalPos + (circleParameter/2), DisplayPositionSetter.queue[(i-1)/2].VerticalPos+(circleParameter), DisplayPositionSetter.queue[(i-1)/2].leftChildXPos,  DisplayPositionSetter.queue[(i-1)/2].leftChildYPos);

            else if(i>0 && ((i-1)/2)*2+2==i)
                g.drawLine((int)DisplayPositionSetter.queue[(i-1)/2].HorizontalPos + (circleParameter/2), DisplayPositionSetter.queue[(i-1)/2].VerticalPos+(circleParameter), DisplayPositionSetter.queue[(i-1)/2].rightChildXPos,  DisplayPositionSetter.queue[(i-1)/2].rightChildYPos);

            procedureSleep(1500);
        }
        procedureSleep(4000);
        codeSetter();

        heapSort();
        procedureSleep(3000);
        clearScreen(g);
        int t=DisplayPositionSetter.queue[Main.nodes-1].VerticalPos+120;
        g.setColor(Color.lightGray);
        g.drawString("Sorted array", 65, t-20);
        procedureSleep(20_000);
        System.exit(0);
    }

    private void adjust(int parent, int n) {
        adjustCodeLineHighlighter(1);
        procedureSleep(1000);
        adjustCodeLineUnHighlighter(1);

        adjustCodeLineHighlighter(2);
        procedureSleep(1000);
        highlightNode(parent, Color.ORANGE); // line 2
        procedureSleep(1600);
        adjustCodeLineUnHighlighter(2);

        adjustCodeLineHighlighter(3);
        procedureSleep(300);
        int max=parent; // line 3
        procedureSleep(300);
        adjustCodeLineUnHighlighter(3);

        adjustCodeLineHighlighter(4);
        procedureSleep(300);
        int lchild=(2*parent)+1; // line 4
        procedureSleep(300);
        adjustCodeLineUnHighlighter(4);

        adjustCodeLineHighlighter(5);
        procedureSleep(300);
        int rchild=(2*parent)+2;
        procedureSleep(300);
        adjustCodeLineUnHighlighter(5);

        adjustCodeLineHighlighter(6);
        procedureSleep(1000);
        if(lchild<n && DisplayPositionSetter.queue[lchild].data>DisplayPositionSetter.queue[max].data) {
            max = lchild;
        }
        if(rchild<n && DisplayPositionSetter.queue[rchild].data>DisplayPositionSetter.queue[max].data) {
            max = rchild;
        }
        procedureSleep(1000);
        adjustCodeLineUnHighlighter(6);

        adjustCodeLineHighlighter(7);
        procedureSleep(800);
        procedureSleep(800);
        adjustCodeLineUnHighlighter(7);
        if(max!=parent) {
            adjustCodeLineHighlighter(8);
            procedureSleep(2000);
            highlightNode(max, Color.CYAN);
            procedureSleep(1000);
            adjustCodeLineUnHighlighter(8);

            adjustCodeLineHighlighter(9);
            procedureSleep(800);
            swapNodes(max, parent, Color.ORANGE, Color.CYAN);
            highlightNode(max, Color.orange);
            adjustCodeLineUnHighlighter(9);

            adjustCodeLineHighlighter(10);
            procedureSleep(1400);
            procedureSleep(1400);
            adjustCodeLineUnHighlighter(10);
            adjust(max, n);
        }
        unHighlightNode(parent);
    }
    private void heapSort() {
        heapSortCodeLineHighlighter(1);
        Graphics g = getCustomGraphics();
        procedureSleep(3000);
        heapSortCodeLineUnHighlighter(1);
        for(int i=(Main.nodes/2)-1; i>=0; i--) {
            heapSortCodeLineHighlighter(2);
            procedureSleep(2_500);
            heapSortCodeLineUnHighlighter(2);
            heapSortCodeLineHighlighter(3);
            adjust(i, Main.nodes);
            procedureSleep(2_500);
            heapSortCodeLineUnHighlighter(3);
            procedureSleep(800);
        }
        heapSortCodeLineHighlighter(4);
        procedureSleep(2_500);
        heapSortCodeLineUnHighlighter(4);
        procedureSleep(2_500);

        for(int i=Main.nodes-1; i>=0; i--) {
            heapSortCodeLineHighlighter(5);
            procedureSleep(2000);
            heapSortCodeLineUnHighlighter(5);

            heapSortCodeLineHighlighter(6);
            highlightNode(0, Color.MAGENTA);
            procedureSleep(2_500);
            heapSortCodeLineUnHighlighter(6);

            heapSortCodeLineHighlighter(7);
            highlightNode(i, Color.ORANGE);
            procedureSleep(2_500);
            heapSortCodeLineUnHighlighter(7);

            heapSortCodeLineHighlighter(8);
            swapNodes(0, i, Color.orange, Color.magenta);
            procedureSleep(2_500);
            heapSortCodeLineUnHighlighter(8);

            highlightNode(i, Color.blue);
            g.setColor(Color.blue);
            g.fillOval(sortedCounter +63, DisplayPositionSetter.queue[Main.nodes-1].VerticalPos+120, 60, 60);
            sortedCounter +=63;
            g.setColor(Color.white);
            g.drawString(""+DisplayPositionSetter.queue[i].data, sortedCounter +(circleParameter/2)-HeapUtility.positioner(DisplayPositionSetter.queue[i].data),DisplayPositionSetter.queue[Main.nodes-1].VerticalPos+155);

            heapSortCodeLineHighlighter(9);
            adjust(0, i);
            procedureSleep(2_500);
            heapSortCodeLineUnHighlighter(9);
        }
    }
    private void codeSetter() {
        Graphics g = getCodeSetterGraphics();
        int lineVerticalPos=DisplayPositionSetter.queue[0].VerticalPos+100;
        g.setFont (new Font ("Monospaced", Font.PLAIN, 18));
        g.setColor(Color.WHITE);
        g.drawString("Heap Sort Code", 850, lineVerticalPos-30);
        procedureSleep(2000);
        g.setFont (new Font ("Monospaced", Font.PLAIN, 14));
        g.setColor(Color.lightGray);
        for(int i=0; i<15; i++, lineVerticalPos+=22) {
            g.drawString(HeapUtility.adjustCodeSetter(i+1), 600-10, lineVerticalPos);
            g.drawString(HeapUtility.heapSortCodeSetter(i+1), 1100-10, lineVerticalPos);
        }
        procedureSleep(3000);
        lineVerticalPos=DisplayPositionSetter.queue[0].VerticalPos+80;
        g.setFont (new Font ("Monospaced", Font.PLAIN | Font.BOLD, 19));
        g.setColor(Color.RED);
        g.drawString("Start", 1100, lineVerticalPos);
        procedureSleep(2500);
        g.setColor(Color.BLACK);
        g.drawString("Start", 1100, lineVerticalPos);
    }
    private void unsetCode() {
        Graphics g = getCodeSetterGraphics();
        int lineVerticalPos=DisplayPositionSetter.queue[0].VerticalPos+100;
        g.setFont (new Font ("Monospaced", Font.PLAIN, 18));
        g.setColor(Color.black);
        g.drawString("Heap Sort Code", 850, lineVerticalPos-30);
        g.setFont (new Font ("Monospaced", Font.PLAIN, 14));
        g.setColor(Color.black);
        for(int i=0; i<15; i++, lineVerticalPos+=22) {
            g.drawString(HeapUtility.adjustCodeSetter(i+1), 600-10, lineVerticalPos);
            g.drawString(HeapUtility.heapSortCodeSetter(i+1), 1100-10, lineVerticalPos);
        }
    }
    private void heapSortCodeLineHighlighter(int lineNumber) {
        Graphics g = getCodeSetterGraphics();
        int lineVerticalPos=DisplayPositionSetter.queue[0].VerticalPos+100;
        for(int i=0; i<lineNumber-1; i++)
            lineVerticalPos+=22;
        g.setColor(Color.green);
        g.drawString(HeapUtility.heapSortCodeSetter(lineNumber), 1100-10, lineVerticalPos);
    }
    private void heapSortCodeLineUnHighlighter(int lineNumber) {
        Graphics g = getCodeSetterGraphics();
        int lineVerticalPos=DisplayPositionSetter.queue[0].VerticalPos+100;
        for(int i=0; i<lineNumber-1; i++)
            lineVerticalPos+=22;
        g.setColor(Color.lightGray);
        g.drawString(HeapUtility.heapSortCodeSetter(lineNumber), 1100-10, lineVerticalPos);
    }
    private void adjustCodeLineHighlighter(int lineNumber) {
        Graphics g = getCodeSetterGraphics();
        int lineVerticalPos=DisplayPositionSetter.queue[0].VerticalPos+100;
        for(int i=0; i<lineNumber-1; i++)
            lineVerticalPos+=22;
        g.setColor(Color.green);
        g.drawString(HeapUtility.adjustCodeSetter(lineNumber), 600-10, lineVerticalPos);
    }
    private void adjustCodeLineUnHighlighter(int lineNumber) {
        Graphics g = getCodeSetterGraphics();
        int lineVerticalPos=DisplayPositionSetter.queue[0].VerticalPos+100;
        for(int i=0; i<lineNumber-1; i++)
            lineVerticalPos+=22;
        g.setColor(Color.lightGray);
        g.drawString(HeapUtility.adjustCodeSetter(lineNumber), 600-10, lineVerticalPos);
    }
    private void swapNodes(int indexA, int indexB, Color c1, Color c2) {
        Graphics g = getCustomGraphics();
        procedureSleep(1000);

        int t = DisplayPositionSetter.queue[indexA].data;
        DisplayPositionSetter.queue[indexA].data=DisplayPositionSetter.queue[indexB].data;
        DisplayPositionSetter.queue[indexB].data=t;

        g.setColor(c1);
        g.fillOval((int) DisplayPositionSetter.queue[indexA].HorizontalPos, DisplayPositionSetter.queue[indexA].VerticalPos, circleParameter, circleParameter);
        g.setColor(Color.BLACK);
        g.drawString("" + DisplayPositionSetter.queue[indexA].data, (int) DisplayPositionSetter.queue[indexA].HorizontalPos + (circleParameter / 2) - HeapUtility.positioner(DisplayPositionSetter.queue[indexA].data), DisplayPositionSetter.queue[indexA].VerticalPos + 35);

        g.setColor(c2);
        g.fillOval((int) DisplayPositionSetter.queue[indexB].HorizontalPos, DisplayPositionSetter.queue[indexB].VerticalPos, circleParameter, circleParameter);
        g.setColor(Color.BLACK);
        g.drawString("" + DisplayPositionSetter.queue[indexB].data, (int) DisplayPositionSetter.queue[indexB].HorizontalPos + (circleParameter / 2) - HeapUtility.positioner(DisplayPositionSetter.queue[indexB].data), DisplayPositionSetter.queue[indexB].VerticalPos + 35);

        procedureSleep(2500);

        g.setColor(Color.LIGHT_GRAY);
        g.fillOval((int) DisplayPositionSetter.queue[indexA].HorizontalPos, DisplayPositionSetter.queue[indexA].VerticalPos, circleParameter, circleParameter);
        g.setColor(Color.BLACK);
        g.drawString("" + DisplayPositionSetter.queue[indexA].data, (int) DisplayPositionSetter.queue[indexA].HorizontalPos + (circleParameter / 2) - HeapUtility.positioner(DisplayPositionSetter.queue[indexA].data), DisplayPositionSetter.queue[indexA].VerticalPos + 35);

        g.setColor(Color.LIGHT_GRAY);
        g.fillOval((int) DisplayPositionSetter.queue[indexB].HorizontalPos, DisplayPositionSetter.queue[indexB].VerticalPos, circleParameter, circleParameter);
        g.setColor(Color.BLACK);
        g.drawString("" + DisplayPositionSetter.queue[indexB].data, (int) DisplayPositionSetter.queue[indexB].HorizontalPos + (circleParameter / 2) - HeapUtility.positioner(DisplayPositionSetter.queue[indexB].data), DisplayPositionSetter.queue[indexB].VerticalPos + 35);
    }
    private void highlightNode(int indexA, Color c) {
        Graphics g = getCustomGraphics();
        g.setColor(c);
        g.fillOval((int) DisplayPositionSetter.queue[indexA].HorizontalPos, DisplayPositionSetter.queue[indexA].VerticalPos, circleParameter, circleParameter);
        if(c==Color.BLUE)
            g.setColor(Color.WHITE);
        else
            g.setColor(Color.BLACK);
        g.drawString("" + DisplayPositionSetter.queue[indexA].data, (int) DisplayPositionSetter.queue[indexA].HorizontalPos + (circleParameter / 2) - HeapUtility.positioner(DisplayPositionSetter.queue[indexA].data), DisplayPositionSetter.queue[indexA].VerticalPos + 35);
    }
    private void unHighlightNode(int indexA) {
        Graphics g = getCustomGraphics();
        g.setColor(Color.lightGray);
        g.fillOval((int) DisplayPositionSetter.queue[indexA].HorizontalPos, DisplayPositionSetter.queue[indexA].VerticalPos, circleParameter, circleParameter);
        g.setColor(Color.BLACK);
        g.drawString("" + DisplayPositionSetter.queue[indexA].data, (int) DisplayPositionSetter.queue[indexA].HorizontalPos + (circleParameter / 2) - HeapUtility.positioner(DisplayPositionSetter.queue[indexA].data), DisplayPositionSetter.queue[indexA].VerticalPos + 35);
    }
    private void setComments() {
        int a=DisplayPositionSetter.queue[0].VerticalPos-10;
        int b=a;
        Graphics g = this.getGraphics();
        g.setFont(new Font ("TimesRoman", Font.ITALIC , 16));
        g.setColor(Color.lightGray);
        g.drawString("Node from which ADJUST (heapify) procedure is called", 600, a);
        g.setColor(Color.ORANGE);
        g.fillRoundRect(580, b-13, 15, 15, 15,15);
        a+=20;
        b-=13;
        g.setColor(Color.lightGray);
        g.drawString("Child node with higher priority than it's parent and sibling (if any)", 600, a);
        g.setColor(Color.CYAN);
        g.fillRoundRect(580, b+20, 15, 15, 15,15);
        a+=20;
        b-=13;
        g.setColor(Color.lightGray);
        g.drawString("Node with the HIGHEST priority key after ADJUST", 600, a);
        g.setColor(Color.magenta);
        g.fillRoundRect(580, b+53, 15, 15, 15,15);
    }
    private void unsetComments() {
        int a=DisplayPositionSetter.queue[0].VerticalPos-10;
        int b=a;
        Graphics g = this.getGraphics();
        g.setFont(new Font ("TimesRoman", Font.ITALIC , 16));
        g.setColor(Color.black);
        g.drawString("Node from which ADJUST (heapify) procedure is called", 600, a);
        g.fillRoundRect(580, b-13, 15, 15, 15,15);
        a+=20;
        b-=13;
        g.drawString("Child node with higher priority than it's parent and sibling (if any)", 600, a);
        g.fillRoundRect(580, b+20, 15, 15, 15,15);
        a+=20;
        b-=13;
        g.drawString("Node with the HIGHEST priority key after ADJUST", 600, a);
        g.fillRoundRect(580, b+53, 15, 15, 15,15);
    }
    private void clearScreen(Graphics g) {
        g.setColor(Color.BLACK);
        for(int i=0; i<Main.nodes; i++) {
            g.fillOval((int)DisplayPositionSetter.queue[i].HorizontalPos,DisplayPositionSetter.queue[i].VerticalPos,circleParameter, circleParameter);
            g.drawString(""+DisplayPositionSetter.queue[i].data, (int)DisplayPositionSetter.queue[i].HorizontalPos+(circleParameter/2)-HeapUtility.positioner(DisplayPositionSetter.queue[i].data), DisplayPositionSetter.queue[i].VerticalPos+35);
            if(i>0 && ((i-1)/2)*2+1==i)
                g.drawLine((int)DisplayPositionSetter.queue[(i-1)/2].HorizontalPos + (circleParameter/2), DisplayPositionSetter.queue[(i-1)/2].VerticalPos+(circleParameter), DisplayPositionSetter.queue[(i-1)/2].leftChildXPos,  DisplayPositionSetter.queue[(i-1)/2].leftChildYPos);
            else if(i>0 && ((i-1)/2)*2+2==i)
                g.drawLine((int)DisplayPositionSetter.queue[(i-1)/2].HorizontalPos + (circleParameter/2), DisplayPositionSetter.queue[(i-1)/2].VerticalPos+(circleParameter), DisplayPositionSetter.queue[(i-1)/2].rightChildXPos,  DisplayPositionSetter.queue[(i-1)/2].rightChildYPos);
        }
        unsetComments();
        unsetCode();
    }
    private Graphics getCodeSetterGraphics() {
        Graphics g = getCustomGraphics();
        g.setFont (new Font ("Monospaced", Font.PLAIN, 14));
        return g;
    }
    private Graphics getCustomGraphics() {
        Graphics g = this.getGraphics();
        Font currentFont = g.getFont();
        Font newFont = currentFont.deriveFont(currentFont.getSize() * 1.6F);
        g.setFont(newFont);
        return g;
    }
    private void procedureSleep(int i2) {
        try {
            Thread.sleep(i2);
        } catch (InterruptedException ignored) {
        }
    }
}