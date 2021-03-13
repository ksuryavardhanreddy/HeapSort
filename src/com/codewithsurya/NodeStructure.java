package com.codewithsurya;

public class NodeStructure {
    float HorizontalPos;
    int VerticalPos;
    int data;
    int leftChildXPos;
    int leftChildYPos;
    int rightChildXPos;
    int rightChildYPos;
    NodeStructure(float Horizontal, int Vertical, int data) {
        this.VerticalPos=Vertical;
        this.HorizontalPos=Horizontal;
        this.data=data;
    }
    public void show() {
        System.out.println(data+" ("+(int)HorizontalPos+", "+VerticalPos+")");
    }
}
