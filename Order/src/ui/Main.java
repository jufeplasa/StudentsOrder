package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
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
		double[] orderYears = null;
		boolean condition=true;

		for(int i=0; i<n;i++) {
			condition=true;
			while(condition) {
				System.out.println("Please enter the year old of the students in the line");
				order=br.readLine();
				orderStudent=order.split("\\ ");
				orderYears= new double[orderStudent.length];
				for(int j=0; j<orderStudent.length;j++) {
					orderYears[j]=Double.parseDouble(orderStudent[j]);
				}
				if(repeatAge(orderYears)) {
					condition=true;
					System.out.println("there are any age repeated. \n Please enter the Ages again.");
				}
				else if(positiveAge(orderYears)) {
					condition=true;
					System.out.println("There are any age less than 0. \n Please enter the Ages again. ");
				}
				else {
					condition=false;
				}
			}
			orderStudents(orderYears);
		}
		br.close();
	}

	private static boolean positiveAge(double[] orderYears) {
		for(int i=0;i<orderYears.length;i++) {
			if(orderYears[i]<=0) {
				return true;
			}
		}
		return false;
	}

	private static boolean repeatAge(double[] orderYears) {
		for(int i=0;i<orderYears.length;i++) {
			for(int j=i+1;j<orderYears.length;j++) {
				if(orderYears[i]==orderYears[j]) {
					return true;
				}
			}
		}
		return false;
	}

	public static void orderStudents(double[] orderYears) {
		double temp;
		int size=orderYears.length;
		double changes;
		double totalChanges = 0;
		double turn = 0;
		double average;
		while(size>=0) {
			changes=0;
			for(int i=0;i<(orderYears.length-1);i++) {
				if (orderYears[i+1]<orderYears[i]) {
					temp=orderYears[i];
					orderYears[i]=orderYears[i+1];
					orderYears[i+1]=temp;
					changes++;
				}
			}
			totalChanges+=changes;
			--size;
		}
		turn=orderYears.length-1;
		average=totalChanges/turn;
		printArray(orderYears,average);
	}

	public static void printArray(double[] orderYears, double average) {
		DecimalFormat formato = new DecimalFormat("#.##");
		System.out.print(formato.format(average)+" - ");
		for(int i=0;i<(orderYears.length);i++) {
			System.out.print(orderYears[i]+" ");
		}
		System.out.println("\n");
	}

}
