import java.util.Scanner;

/**
 * Aid user keyboard input with prompts and error catching.
 *
 * @version 2017.09.24
 */
public class UI
{
    private static Scanner in = new Scanner(System.in);

    /**
     *  Encourage ONLY ONE keyboard Scanner.
     *  @return the Scanner reading the keyboard.
     */
    public static Scanner getKeyboardScanner()
    {
        return in;
    }


    /** Prompt the user for a line and return the line entered.
     *  @param prompt
     *      The prompt for the user to enter the input line.
     *  @return
     *      The line entered by the user.
     */
    public static String promptLine(String prompt) {
        System.out.print(prompt);
        return in.nextLine();
    }


    /** Prompt for a character.
     *  @param prompt
     *      The prompt for the user to enter a character
     *  @return
     *     The first character of the line entered or a blank if the line
     *     is empty.
     */
    public static char promptChar(String prompt)
    {
        String line = promptLine(prompt);
        if (line.length() == 0)
            return ' ';
        return line.charAt(0);
    }

    /** Print a question and return a response.
     *  Repeat until a valid answer is given.
     * @param question
     *    The yes/no question for the user to answer.
     * @return
     *    True if the answer is yes, or False if it is no.
     */
    public static boolean agree(String question)
    {
        String yesStr = "yYtT", noStr = "nNfF",
                legalStr = yesStr + noStr;

        char ans = promptChar(question);
        while (legalStr.indexOf(ans) == -1)
        {
            System.out.println("Respond 'y or 'n':");
            ans = promptChar(question);

        }
        return yesStr.indexOf(ans) >= 0;
    }

    /** Prompt and read an int.
     * Repeat until there is a legal value to return.
     * Read through the end of the line
     *  @param prompt
     *      The prompt for the user to enter a value.
     *  @return
     *      The value entered by the user.
     */
    public static int promptInt(String prompt)
    {
        System.out.print(prompt);
        while (! in.hasNextInt())
        {
            in.next();  // dump the bad token
            in.nextLine(); // dump through the newline
            System.out.println("!! Bad int format!!");
            System.out.print(prompt);
        }
        int val = in.nextInt();
        String rest = in.nextLine().trim(); //clear line
        if (rest.length() > 0)
            System.out.println("Skipping rest of input line.");
        return val;
    }

    /** Prompt and read a double.
     * Repeat until there is a legal value to return.
     *  @param prompt
     *      The prompt for the user to enter a value.
     *  @return
     *      The value entered by the user.
     */
    public static double promptDouble(String prompt)
    {
        System.out.print(prompt);
        while (! in.hasNextDouble())
        {
            in.next();  // dump the bad token
            in.nextLine(); // dump through the newline
            System.out.println("!! Bad double format!!");
            System.out.print(prompt);
        }
        double val = in.nextDouble();
        String rest = in.nextLine().trim(); //clear line
        if (rest.length() > 0)
            System.out.println("Skipping rest of input line.");
        return val;
    }

    /** Prompt and read a line of integers.
     * Repeat until there is a legal line to process.
     *  @param prompt
     *      The prompt for the user to enter data.
     *  @return
     *      The int values entered by the user.
     */
    public static int[] promptIntArray(String prompt)
    {
        while (true) { // exit via return statement
            String line = promptLine(prompt);
            String[] tokens = line.trim().split("\\s+");
            int n = tokens.length;
            int[] nums = new int[n];
            Scanner lineScan = new Scanner(line);
            int i = 0;
            while (i < n && lineScan.hasNextInt() )
            {
                nums[i] = lineScan.nextInt();
                i++;
            }
            if (i == n)
                return nums;
            System.out.format(
                    "Bad input %s. Start your line over.\n", tokens[i]);
        }
    }

    /** Prompt and read a line of numbers.
     * Repeat until there is a legal line to process.
     *  @param prompt
     *      The prompt for the user to enter data.
     *  @return
     *      The double values entered by the user.
     */
    public static double[] promptDoubleArray(String prompt)
    {
        while (true) { // exit via return statement
            String line = promptLine(prompt);
            String[] tokens = line.trim().split("\\s+");
            int n = tokens.length;
            double[] nums = new double[n];
            Scanner lineScan = new Scanner(line);
            int i = 0;
            while (i < n && lineScan.hasNextDouble() )
            {
                nums[i] = lineScan.nextDouble();
                i++;
            }
            if (i == n)
                return nums;
            System.out.format(
                    "Bad input %s. Start the line over.\n", tokens[i]);
        }
    }
}
