package com.codewithsurya;

public class HeapUtility {
    public static String adjustCodeSetter(int lineNumber) {
        return switch (lineNumber) {
            case 1 -> "void heapify(int *arr, int n, int parent) {";
            case 2 -> "    //--adjusting w.r.t. node coloured in YELLOW--//";
            case 3 -> "    int max=parent, t;";
            case 4 -> "    int lchild=(2*parent)+1;";
            case 5 -> "    int rchild=(2*parent)+2;";
            case 6 -> "    max = findMax(parent, lchild, rchild)";
            case 7 -> "    if(max!=parent) {";
            case 8 -> "    //---------colouring 'max' in CYAN--------//";
            case 9 -> "        SWAP(arr[max], arr[parent]);";
            case 10 -> "        heapify(arr, n, max); // recursive call ";
            case 11 -> "    }";
            case 12 -> "}";
            default -> "";
        };
    }
    public static String heapSortCodeSetter(int lineNumber) {
        return switch (lineNumber) {
            case 1 -> "void heapsort(int *arr, int n) {";
            case 2 -> "    for(int i=(n/2)-1; i>=0; i--)";
            case 3 -> "        heapify(arr, n, i); ";
            case 4 -> "    // max heap formed";
            case 5 -> "    for(int i=n-1; i>=0; i--) {";
            case 6 -> "    //--colouring arr[0] in PINK";
            case 7 -> "    //--colouring arr[i] in YELLOW";
            case 8 -> "        SWAP(arr[i], arr[0])";
            case 9 -> "        heapify(arr, i, 0);";
            case 10 -> "    }";
            case 11 -> "}";
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
