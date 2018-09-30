package com.java.solutions;

public class PrimeNumber {

	boolean isPrimeNumber(int n)  {
    	if (n < 2) return false;  

    	for (int i = 2; i < n; i++) {
    		if (n%i == 0) {
    			return false;
    		}
    	}
    	return true;
    }
     
    public static void main(String a[]){
    	PrimeNumber pNumber = new PrimeNumber();
    	System.out.println( "method ->> "+pNumber.isPrimeNumber(17));
    	
    }
}
