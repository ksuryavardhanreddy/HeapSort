package com.codewithsurya;

public class HeapUtility {
    static public int positioner(int number) {
        int digits=0;
        while(number!=0) {
            number/=10;
            digits++;
        }
        return switch (digits) {
            case 1 -> 5;
            case 2 -> 10;
            case 3 -> 15;
            case 4 -> 20;
            case 5 -> 25;
            default -> 0;
        };
    }
    static public int power(int x, int y) {
        int ans=1;
        for(int i=0; i<y; i++)
            ans*=x;
        return ans;
    }
    static int getTreeBaseLength() {
        return (DisplayPositionSetter.circleDiameter +(2* DisplayPositionSetter.VerticalSpaceFactor))*HeapUtility.power(2,getHeight()-1);
    }
    static int getHeight() {
        return (int) Math.ceil(Math.log(Main.nodes+1)/Math.log(2));
    }
}
