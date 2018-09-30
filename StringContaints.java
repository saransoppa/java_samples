package com.java.solutions;

public class StringContaints {

	public static void main(String[] args) {
	    String source = "xxhxxqxxxqrxxgxxxqr";
	    String target = "xxxqr";
	    char[] parentArray = source.toCharArray();
	    char[] childArray = target.toCharArray();
	    System.out.println("first complete ocurrence of child in parent : " + strContains(childArray, parentArray));
	}

	public static int strContains(char[] childArr, char[] parentArr) {
	    for (int i = 0; i < parentArr.length - childArr.length+1; i++) {
	        for (int j = 0; j < childArr.length; j++) {
	            if (parentArr[i + j] == childArr[j]) {
	                if (j == childArr.length - 1) {
	                    return i;
	                }
	            } else {
	                break;
	            }
	        }
	    }
	    return -1;
	}
}
