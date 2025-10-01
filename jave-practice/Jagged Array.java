import java.util.Scanner;

/*  For creating a dynamic matrix */
public class JaggedArr {
    public static void main(String[] args) {
        int[][] arr = new int[2][];
        arr[0] = new int[3];
        arr[1] = new int[2];

        Scanner scr = new Scanner(System.in);
        System.out.println("Enter values for the jagged array:");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = scr.nextInt();
            }
        }
        scr.close();

        System.out.println("Values entered:");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
