package LAB.lab2Question7TwoSum;

import java.util.Scanner;

//Write a program that finds all pairs of integers in an array
// whose sum is equal to a given number.
// For example, in the array [1, 2, 3, 4, 5],
// the pairs with sum 5 are (1, 4) and (2, 3).
public class Main {
    static int[] scanArr(Scanner sc){
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
        int[] arr = scanArr(sc);
        System.out.print("Enter the target value: ");
        int target = sc.nextInt();
        boolean resFound = false;
        for(int i=0;i<arr.length;i++){
            for(int j = i;j<arr.length-1;j++){
                if(arr[i]+arr[j]==target){
                    System.out.println("( "+arr[i]+", "+arr[j]+" )");
                    resFound = true;
                }
            }
        }
        if(!resFound){
            System.out.println("No possible pair");

        }

    }
}
