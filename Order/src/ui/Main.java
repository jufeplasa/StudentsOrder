package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
	private static Scanner sc= new Scanner(System.in);
	public static void main(String [] args) throws IOException {
		int n = 0;
		System.out.println("Please enter the number of test lines");
		n=sc.nextInt();
		sc.nextLine();
		enterOrderStudents(n);
	}
	
	public static void enterOrderStudents(int n) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String order="";
		String [] orderStudent;
		double[] orderYears;
		for(int i=0; i<n;i++) {
			System.out.println("Please enter the year old of the students in the line");
				order=br.readLine();
				orderStudent=order.split("\\ ");
				orderYears= new double[orderStudent.length];
			for(int j=0; j<orderStudent.length;j++) {
				orderYears[j]=Double.parseDouble(orderStudent[j]);
			}
			orderStudents(orderYears);
		}
		br.close();
	}
	
	public static void orderStudents(double[] orderYears) {
		double temp;
		int size=orderYears.length;
		while(size>=0) {
			for(int i=0;i<(orderYears.length-1);i++) {
				if (orderYears[i+1]<orderYears[i]) {
					temp=orderYears[i];
					orderYears[i]=orderYears[i+1];
					orderYears[i+1]=temp;
					System.out.println(orderYears[i]+" y "+orderYears[i+1]); 
				}
			}
			--size;
		}
		printArray(orderYears);
	}
	
	public static void printArray(double[] orderYears) {
		for(int i=0;i<(orderYears.length);i++) {
			System.out.print(orderYears[i]+" ");
		}
		System.out.println("\n");
	}
	
}
