package com.codewithsurya;

import java.lang.*;

public class DisplayPositionSetter {
    static int VerticalSpaceFactor, HorizontalSpaceFactor;
    final static int circleDiameter =60;
    public static NodeStructure[] queue = new NodeStructure[Main.nodes];
    private static int front=-1, rear=-1;

    public static void PositionSetter() {
        spaceFactorSetter();
        reset();
        int x=0;
        int levels = HeapUtility.getHeight();
        int nodeCount=Main.nodes;
        for(int i=1; i<=levels; i++) {
            int totalAccommodation=HeapUtility.power(2,i-1); // max nodes the level can accommodate....
            for(int j=1; j<=HeapUtility.power(2,i-1)&& nodeCount>0; j++) {
                nodeCount--;
                enqueue((float)((j*HeapUtility.getTreeBaseLength())/(totalAccommodation+1))+30, i*HorizontalSpaceFactor+70, Main.arr[x++]);
            }
        }
    }

    public static void childEdgeSetter() {
        for(int i=0; i<Main.nodes; i++) {
            if(2*i+1<Main.nodes) {
                queue[i].leftChildXPos = (int)queue[2*i+1].HorizontalPos + (circleDiameter /2);
                queue[i].leftChildYPos = queue[2*i+1].VerticalPos;
            }
            else {
                queue[i].leftChildXPos = (int)queue[i].HorizontalPos + (circleDiameter /2);
                queue[i].leftChildYPos = queue[i].VerticalPos + circleDiameter;
            }
            if(2*i+2<Main.nodes) {
                queue[i].rightChildXPos = (int)queue[2*i+2].HorizontalPos + (circleDiameter /2);
                queue[i].rightChildYPos = queue[2*i+2].VerticalPos;
            }
            else {
                queue[i].rightChildXPos = (int)queue[i].HorizontalPos + (circleDiameter /2);
                queue[i].rightChildYPos = queue[i].VerticalPos + circleDiameter;
            }
        }
    }

    private static void spaceFactorSetter() {
        if(Main.nodes<=3) {
            VerticalSpaceFactor=20;
            HorizontalSpaceFactor=90;
        }
        else if(Main.nodes<=7) {
            VerticalSpaceFactor=15;
            HorizontalSpaceFactor=90;
        }
        else if(Main.nodes<=15) {
            System.out.println("..");
            VerticalSpaceFactor=6;
            HorizontalSpaceFactor=110;
        }
        else {
            VerticalSpaceFactor=4;
            HorizontalSpaceFactor=100;
        }
    }
    private static void enqueue(float VerticalPos, float HorizontalPos, int data) {
        if(front == -1 && rear == -1) {
            front++;
        }
        queue[++(rear)]= new NodeStructure(VerticalPos, (int)HorizontalPos, data);
    }
    private static NodeStructure dequeue() {
        if(front<=rear) {
            return queue[front++];
        }
        else {
            front=-1;
            rear=-1;
            return new NodeStructure(0,0, 0);
        }
    }
    private static void displayNodeStructureQueue() {
        while(!isEmpty()) {
            NodeStructure t = dequeue();
            System.out.println(t.data+" ("+t.HorizontalPos+", "+t.VerticalPos+")");
        }
    }
    private static void reset() {
        front=-1;
        rear=-1;
    }
    private static boolean isEmpty() {
        return front==-1;
    }
}
