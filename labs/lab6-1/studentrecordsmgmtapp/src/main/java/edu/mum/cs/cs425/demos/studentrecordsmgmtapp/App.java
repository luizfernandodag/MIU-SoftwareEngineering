package edu.mum.cs.cs425.demos.studentrecordsmgmtapp;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		int[] ints = { 10, 14, 70, 105, 80 };
		
		System.out.println("Print Hello Word:");
		printHelloWorld(ints);

		System.out.println();
		findSecondBiggest(new int[] { 1, 2, 3, 4, 5 });
		findSecondBiggest(new int[] { 19, 9, 11, 0, 12 });
	}

	public static void printHelloWorld(int[] ints) {
		for (int i : ints) {
			if (i % 5 == 0 && i % 7 == 0) {
				System.out.println("HelloWorld");
			} else if (i % 5 == 0) {
				System.out.println("Hello");
			} else if (i % 7 == 0) {
				System.out.println("World");
			}
		}
	}

	public static void findSecondBiggest(int[] ints) {
		if (ints == null || ints.length < 2) {
			System.out.println("None");
			return;
		}

		System.out.println("Find Second Biggest: " + Arrays.toString(ints));
		int len = ints.length;
		for (int i = 0; i < len; i++) {
			int min = ints[i];
			int idx = i;
			for (int j = i + 1; j < len; j++) {
				if (ints[j] < min) {
					min = ints[j];
					idx = j;
				}
			}

			int temp = ints[i];
			ints[i] = min;
			ints[idx] = temp;
		}

		System.out.println(ints[len - 2]);

	}
}
