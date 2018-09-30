package com.java.solutions;

public class MainSolution
{ 
    // Returns number of times x occurs in arr[0..n-1] 
    static boolean checkIsPresent(int arr[], int n, int x) 
    { 
        boolean isPresent = false;
        for (int i=0; i<n; i++) 
            if (x == arr[i])  {
            	isPresent = true; 
            	break;
            }
        return isPresent; 
    } 
      
    public static void main(String args[]) 
    { 
//        int arr[] = {1, 2, 2, 2, 2, 3, 4, 7 ,8 ,8 }; 
//        int n = arr.length; 
//        int x = 2; 
//        System.out.println(checkIsPresent(arr, n, x)); 
        
        
        double dollar = 1.00;
        double dime = 0.10;
        int number = 7;
        System.out.println(
          "A dollar less " + number + " dimes is $" + 
           (dollar - number * dime)
        );
        
        System.out.println("Results "+ ((0.10 + 0.20) == 0.3) );
    } 
} 

