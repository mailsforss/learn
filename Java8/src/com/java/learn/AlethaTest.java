package com.java.learn;

import java.util.ArrayList;

/*You are given two non-empty linked lists representing two non-negative integers. 
 * The digits are stored in reverse order, and each of their nodes contains a single digit. 
 * Add the two numbers and return the sum as a linked list.
 
You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 
 
Example 1:
 
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
 
Example 2:
 
Input: l1 = [0], l2 = [0]
Output: [0]
 
Example 3:
 
Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]
 * 
 * */

public class AlethaTest {

	public static void main(String[] args) {
		
		ArrayList<Integer> l1 = new ArrayList<Integer>();
		ArrayList<Integer> l2 = new ArrayList<Integer>();

		ArrayList<Integer> l3 = new ArrayList<Integer>();
		
		String a1="";
		String a1t="";
		
		String a2="";
		
	
		
		/*
		 * int a1 =0; int a2=0;
		 */
		
		
		l1.add(2);
		l1.add(3);
		l1.add(4);
		
		
		l2.add(5);
		l2.add(6);
		l2.add(4);
		
		for(int i=l1.size();i>=0;i--) {
			
			if(i!=0)
			a1 = a1.concat(Integer.toString(l1.get(i-1)));
			
			System.out.println(a1);
			
			if(i!=0)
			a2 = a2.concat(Integer.toString(l2.get(i-1)));
			System.out.println(a2);
		}
		int sum=Integer.parseInt(a1)+Integer.parseInt(a2);
		String sumInt=Integer.toString(sum);
		System.out.println("Sum:");
		
		
		
		for (int i=0;i<sumInt.length();i++) {
			l3.add(Integer.parseInt(sumInt.substring(sumInt.length()-(i+1), sumInt.length()-(i))));
			System.out.println(l3.toString());
			
		}
		
		

	}
	
	


}
