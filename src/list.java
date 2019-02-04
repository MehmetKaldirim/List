import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 */
public class list {
    public static void main(String[] args) {


        /**  Creat two array
         * union them without dublication
         * sort this array
         * and reverse it*/

        System.out.println("  how many values do  you wanna add first Array?");
        int n = askInteger();
        ArrayList<Integer> numbers1 = creatIntegerArray(n);

        System.out.println("  how many values do  you wanna second Arrayt?");
        n = askInteger();
        ArrayList<Integer> numbers2 = creatIntegerArray(n);

        ArrayList<Integer> union = union(numbers1, numbers2);
        System.out.println("Your union array  without dublication");

        Collections.sort(union);
        printIntegerArray(union);

        Collections.reverse(union);
        System.out.println("reverse of array");
        printIntegerArray(union);

        /**  Common Arrays = if there is coomon arrays in two arrays combine them new and print them else sayss
         * no commons:) */
        /*
        System.out.println("  how many values do  you wanna add first Array?");
        int n = getOperationUserInput();
        ArrayList <String> values1=creatStringArray(n);

        System.out.println("  how many values do  you wanna second Arrayt?");
         n = getOperationUserInput();
        ArrayList <String> values2=creatStringArray(n);

        ArrayList <String> common=commonValues(values1,values2);
        printStringArray(common);
         */


        /**  Fibanocci    */

        /* System.out.println("Could you please  how many line of Fibanocci  you wanna see?");
        ArrayList <Integer> numbers= creatFbanocciArray(n);
        printIntegerArray(number);*/


    }

    private static ArrayList<Integer> removeDuplicates(ArrayList<Integer> numbers) {

        ArrayList<Integer> numberWithoutDup = new ArrayList<>();

        for (Integer x : numbers) {
            if (findNumbers(numberWithoutDup, x) == -1) {
                numberWithoutDup.add(x);
            }
        }

        return numberWithoutDup;
    }

    /**
     * @param numbers1 first array
     * @param numbers2 second array
     * @return union to array and remove dublications
     */
    public static ArrayList<Integer> union(
            ArrayList<Integer> numbers1,
            ArrayList<Integer> numbers2) {

        // Return the union of 'values1' and 'values2'
        // that is basically every element contained in
        // any of the two

        ArrayList<Integer> union = new ArrayList<>();

        for (Integer x : numbers1) {
            union.add(x);
        }
        for (Integer x : numbers2) {
            union.add(x);
        }

        return removeDuplicates(union);
    }

    public static String askString () {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    public static int askInteger () {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }


    /**
     * @param n = how many  line do you see
     * @return fibannoci numbers as a array
     */
    public static ArrayList<Integer> creatFbanocciArray ( int n){

        ArrayList<Integer> fibannoci = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            int addNumber = fibanocciFirstofThree(i);

            fibannoci.add(addNumber);
        }

        return fibannoci;
    }

    /**
     * @param n length of array
     * @return any kind of string array (created by user)
     */
    public static ArrayList<String> creatStringArray ( int n){

        ArrayList<String> values = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            System.out.println("enter " + i+ ".nd element");
            String value = askString();

            values.add(value);
        }

        return values;
    }

    /**
     * @param n length of array
     * @return integer array (created by user)
     */
    public static ArrayList<Integer> creatIntegerArray ( int n){

        ArrayList<Integer> numbers = new ArrayList<Integer>();

        for (int i = 0; i < n; i++) {
            System.out.println("enter " + i + ".nd element");
            int number = askInteger();
            numbers.add(number);
        }

        return numbers;
    }


    /**
     * @param values1 string array
     * @param values2 string array
     * @return array which show commons array or says there is not any
     */
    public static ArrayList<String> commonValues (
            ArrayList < String > values1,
            ArrayList < String > values2){
        ArrayList<String> commonArray = new ArrayList<>();
        for (String x : values1) {
            if (findValue(values2, x) != -1 &&
                    findValue(commonArray, x) == -1) {
                commonArray.add(x);
            }

            if (commonArray.size() == 0)
                System.out.println("  there is not any common ");
        }
        return commonArray;
    }


    /**
     * @param values  strings word array
     * @param x string word
     * @return if x not in values return zero , if yes return index number
     */
    public static int findValue (ArrayList < String > values, String x){
        for (int i = 0; i < values.size(); i++) {
            if (values.get(i).equals(x)) {
                return i;
            }
        }
        return -1;
    }


    public static int findNumbers (ArrayList < Integer > numbers, int x){
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i)==x) {
                return i;
            }
        }
        return -1;
    }

    /**
     * @param words  print elements of this array
     */
    public static void printStringArray (ArrayList < String > words) {
        for (String x : words)
            System.out.println(x);
    }


    /**
     * @param  numbers  print elements of this array
     */
    public static void printIntegerArray (ArrayList < Integer > numbers) {
        for (Integer x : numbers)
            System.out.println(x);
    }


    /**
     * @param n indicate number which line of fibannocci wanna see
     * @return
     */
    public static int fibanocciFirstofThree ( int n){
        if (n == 0) {
            return 0;
        } else if (n == 1 || n == 2) {
            return 1;
        } else
            return fibanocciOpr(0, 1, (n - 1));
    }


    /**
     * @param first
     * @param second
     * @param n
     * @return sum the numbers to find next fibannoci numbers( which will be n)
     */
    public static int fibanocciOpr ( int first, int second, int n){
        int count = n;
        if (count == 2) {
            return second + first;
        } else
            return fibanocciOpr(second, (first + second), (n - 1));
    }


}