package LAB1.question6RotateArray;

import java.util.Scanner;

public class Main {
    static int[] rotateArr(int[] arr, int pos){

        int[] newArr=new int[arr.length];
        for(int i = 0;i< arr.length;i++){
            if(i+pos <arr.length){
                newArr[i+pos] = arr[i];
            }
            else{
                newArr[(i+pos)%arr.length] = arr[i];
            }
        }
        return newArr;
    }
    static void printArr(int[] arr){
        for (int i: arr){
            System.out.print(i+" \t");
        }
        System.out.println("\n");
    }
    static int[] scanArr(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of array elements: ");
        int[] arr=new int[sc.nextInt()];
        System.out.println("Enter the array elements: ");
        for(int i=0;i<arr.length;i++){
            arr[i]=sc.nextInt();
        }

        return arr;

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = scanArr();
        System.out.println("The original array is: ");
        printArr(arr);
        System.out.print("Enter the positions to rotate through: ");
        int pos = sc.nextInt();
        System.out.println("The rotated array is: ");
        printArr(rotateArr(arr,pos));
    }
}
