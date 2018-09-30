package com.java.solutions;

import java.util.HashMap;
import java.util.Map;

/*
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9. 
X can be placed before L (50) and C (100) to make 40 and 90. 
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.
 */
public class RomanToInteger {

	RomanToInteger(){
		symbolMap.put("I", 1);
		symbolMap.put("V", 5);
		symbolMap.put("X", 10);
		symbolMap.put("L", 50);
		symbolMap.put("C", 100);
		symbolMap.put("D", 500);
		symbolMap.put("M", 1000);
	}
	Map<String,Integer> symbolMap = new HashMap<>();
	
	public int romanToInt(String s) {
        
		char[] charArr = s.toCharArray();
		int totalSum=0, preVal=-1, curVal=-1;
		
		for(int i=0; i<charArr.length;i++) {
			preVal = curVal;
			curVal = symbolMap.get(String.valueOf(charArr[i]));
			
			if(i%2 != 0 && preVal != -1 && preVal < curVal) {
				totalSum += curVal - (2*preVal);
			} else {
				totalSum += curVal;
			}
		}
		return totalSum;
    }
	
	public static void main(String[] args){
		
		RomanToInteger rI = new RomanToInteger();
		System.out.println( rI.romanToInt("MCMXCIV"));
		
	}
	

}
