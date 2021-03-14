package com.codewithsurya;

public class HeapUtility {
    public static String adjustCodeSetter(int lineNumber) {
        return switch (lineNumber) {
            case 1 -> "void heapify(int *arr, int n, int parent) {";
            case 2 -> "    //---------Colouring 'parent' in yellow--------//";
            case 3 -> "    int max=parent, t;";
            case 4 -> "    int lchild=(2*parent)+1;";
            case 5 -> "    int rchild=(2*parent)+2;";
            case 6 -> "    if(lchild<n && arr[lchild]>arr[max])";
            case 7 -> "        max=lchild;";
            case 8 -> "    if(rchild<n && arr[rchild]>arr[max])";
            case 9 -> "        max=rchild;";
            case 10 -> "    if(max!=parent) {  // check if parent node is not the one with highest priority key";
            case 11 -> "    //---------Colouring 'max' in cyan--------//";
            case 12 -> "        SWAP(arr[max], arr[parent]);";
            case 13 -> "        heapify(arr, n, max); // recursive call ";
            case 14 -> "    }";
            case 15 -> "}";
            default -> "";
        };
    }
    public static String heapSortCodeSetter(int lineNumber) {
        return switch (lineNumber) {
            case 1 -> "void heapsort(int *arr, int n) {";
            case 2 -> "    for(int i=(n/2)-1; i>=0; i--)";
            case 3 -> "    heapify(arr, n, i);";
            case 4 -> "    for(int i=n-1; i>=0; i--) {";
            case 5 -> "        SWAP(arr[i], arr[0])";
            case 6 -> "        heapify(arr, i, 0);";
            case 7 -> "    }";
            case 8 -> "}";
            default -> "";
        };
    }
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
