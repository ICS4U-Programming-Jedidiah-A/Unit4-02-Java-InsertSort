import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
/**
* This program calculates amount of mean median and mode.
*
* @author  Jedidiah Alfred
* @version 1.0
* @since   2023-05-13
*/

public final class InsertSort {
    /**
    * This is a private constructor used to satisfy the
    * style checker.
    *
    * @exception IllegalStateException Utility Class
     */
    private InsertSort() {
        throw new IllegalStateException("Utility Class");
    }
    /**
    * This is the main method.
    *
    * @param args Unused
    * @throws Exception if something goes wrong
    */

    public static void main(String[] args) throws Exception {
        // Initializing variables
        final String err = "Error";
        final String splitStr = " ";

        try {
            // new file object
            final File input = new File("input.txt");

            // Creating the writer
            final FileWriter output = new FileWriter("output.txt");

            try {
                // Creating the scanner.
                final Scanner scanner = new Scanner(input);

                // ArrayList to hold the lines
                final ArrayList<String> lines = new ArrayList<>();

                // Getting the input from the first file
                while (scanner.hasNextLine()) {

                    // Getting next line
                    final String line = scanner.nextLine();
                    lines.add(line);
                }
                for (String line1 : lines) {
                    if (line1.length() != 0) {
                        try {
                            // Reference, Keiden showed me how to code it like
                            // this.
                            final int[] listNum = Arrays.stream(
                                    line1.split(splitStr)
                                ).mapToInt(Integer::parseInt).toArray();
                            final int[] sort = insertSort(listNum);
                            for (int num : sort) {
                                output.write(num + splitStr);
                            }
                            output.write("\n");
                        } catch (NumberFormatException error) {
                            output.write("ERROR: Invalid number\n");
                        }
                    } else {
                        output.write("ERROR: The empty line\n");
                    }
                }
            } catch (IOException error) {
                System.out.println(err + error.getMessage());
            }
            // closes the output
            output.close();
        } catch (IOException error) {
            System.out.println(err + error.getMessage());
        }
    }
    /**
    * This is the method reverseRecs the string.
    *
    * @param listNum This is the array to be sorted
    * @return the sorted array
    */

    private static int[] insertSort(int[] listNum) {
        for (int counter1 = 1; counter1 < listNum.length; counter1++) {
            final int minNum = listNum[counter1];
            int temp = counter1 - 1;
            while (temp >= 0 && listNum[temp] > minNum) {
                listNum[temp + 1] = listNum[temp];
                temp--;
            }
            listNum[temp + 1] = minNum;
        }
        return listNum;
    }
}
