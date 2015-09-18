/**
 * Student: Joseph Davis
 * Assignment: Exercise 7.15
 * Date: September 15, 2015
 * Description: Write a method that returns a new array by eliminating the
 * duplicate values in the array.
 */

import java.util.Arrays;
import java.util.Scanner;

public class DistinctElements {
  public static void main(String[] args) {
    // get 10 integers from the user
    Scanner input = new Scanner(System.in);
    System.out.print("Enter 10 numbers: ");
    int[] list = new int[10];
    for (int i = 0; i < 10; i++) {
      list[i] = input.nextInt();
    }
    input.close();
    
    // find distinct integers
    int[] distinct = eliminateDuplicates(list);
    
    // print the distinct values
    System.out.print("The distinct numbers are:");
    for (int number : distinct) {
      System.out.print(" " + number);
    }
  }

  public static int[] eliminateDuplicates(int[] list) {
    int[] result = new int[list.length];
    int index = 0;
    for (int number : list) {
      boolean found = false;
      for (int j = 0; j < index; j++) {
        if (result[j] == number) {
          found = true;
          break;
        }
      }
      if (!found)
        result[index++] = number;
    }
    // return an array of the correct length
    return Arrays.copyOf(result, index);
  }
}
