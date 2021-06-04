import java.util.Scanner;
import java.util.Arrays;

public class searchStudent {
  public static int binarySearchStudent(String[] students, String student) {
    int min = 0;
    int length = students.length - 1;
    while (min <= length) {
      int middle = min + (length - min) / 2;
      // Compares student
      int compare = student.compareTo(students[middle]);
      // Checks to see if desired name in the middle of array
      if (compare == 0)
        return middle;
      // If x is less, the left side is where desired name is located
      else if (compare > 0)
        min = middle + 1;
      // If x is greater, the right side is where the desired name is located
      else
        length = middle - 1;
    }
    return -1; // Returns -1 if student is not in array
  }

  public static void main(String[] args) {
    String[] students = { "Corey", "Daniel", "David", "Lilala", "Nathan", "Tommy", "Randy", "Bob", "Fred", "Joe","Tom"};
    // Sorts the student array for the binary search
    Arrays.sort(students);
    // Scanner object for user input, asks user for input
    Scanner myObj = new Scanner(System.in);
    System.out.print("Search for Student:");
    String userIn = myObj.nextLine();

    int Search = binarySearchStudent(students, userIn);
    // If Search is -1, the student is not in array
    if (Search == -1)
      System.out.println("Student not in database.");
    // If not -1 the student is in the array
    else
      System.out.println(userIn + " was found in database");
  }
}