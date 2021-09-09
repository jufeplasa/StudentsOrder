package ui;

import java.util.Scanner;

public class Main {
	private static Scanner sc= new Scanner(System.in);
	public static void main(String [] args) {
		int n = 0;
		System.out.println("Please enter the number of test lines");
		n=sc.nextInt();
		sc.nextLine();
		enterOrderStudents(n);
	}
	
	public static void enterOrderStudents(int n) {
		String order="";
		String [] orderStudent;
		double[] orderYears;
		for(int i=0; i<n;i++) {
			System.out.println("Please enter the year old of the students in the line");
				order=sc.next();
				orderStudent=order.split(" ");
				System.out.println(orderStudent[0]);
				orderYears= new double[orderStudent.length];
			for(int j=0; j<orderStudent.length;j++) {
				orderYears[j]=Double.parseDouble(orderStudent[j]);
			}
			orderStudents(orderYears);
		}
	}
	
	public static void orderStudents(double[] orderYears) {
		double temp;
		for(int i=0;i<(orderYears.length-1);i++) {
			if (orderYears[i+1]<orderYears[i]) {
				temp=orderYears[i];
				orderYears[i]=orderYears[i+1];
				orderYears[i+1]=temp;
			}
		}
		printArray(orderYears);
	}
	
	public static void printArray(double[] orderYears) {
		for(int i=0;i<(orderYears.length-1);i++) {
			System.out.println(orderYears[i]+" ");
		}
		System.out.println("\n");
	}
	
}
