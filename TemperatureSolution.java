package com.apple.ist.idms.a3clienttest;

import java.util.Arrays;

public class TemperatureSolution {

	public static void main(String[] args){
		
		TemperatureSolution solution = new TemperatureSolution();
		int[] temp = new int[]{-3,-14,-5,7,8,42,8,3};//{2,-3,3,1,10,8,2,5,13,-5,3,-18};
		System.out.println( solution.solution(temp));
				
	}
	public String solution( int[] T ) {
		
		String[] seasons = {"WINTER", "SPRING", "SUMMER", "AUTUMN"}; 
		//winter, spring, summer, autumn
		
	  int size = T.length / 4;
	 
	  int index = 0;
	  int counter = 0;
	  int seasonTmp[] = new int[seasons.length];
	  
	  int h=0,l=0;
	 
	  
	  for(int temp: T) {
		  if(counter < size ) {
			  if( l==0 && h == 0){
			    l = temp;
			    h = temp;
			  } else if( temp < l ) {
				  h=l;
				  l=temp;
			  } else if( temp > h) {
				  h = temp;
			  }
			  counter++;
		  } else {
			  seasonTmp[index++] = h-l;
			    l = temp;
			    h = temp;
			  counter = 1;
		  }

	  }
	  seasonTmp[index++] = h-l;
	  System.out.println(Arrays.toString( seasonTmp));
	  
	  int maxTmpInx = 0;
	  
	  for(int i=0;i<seasonTmp.length;i++){
		  if(seasonTmp[i] > seasonTmp[maxTmpInx]) {
			  maxTmpInx = i;
		  }
	  }
	  System.out.println("maxTmpInx ->"+ maxTmpInx);
	  return seasons[maxTmpInx];
	}
}
