import java.io.PrintWriter;
import java.util.ArrayList;

public class Recursion {

    public static long factorialR(long value){
        if(value < 0) {
            throw new IllegalArgumentException("The value: " + value + " is invalid");
        }
        if(value == 0) {
            return 1;
        }
        return value * factorialR(value - 1);
    
    }
    
    public static boolean palindromeR(String str, int start, int end){
        if(start >= end){
            return true;
        }
        if(str.charAt(start) != str.charAt(end)){
            return false;
        }
        return palindromeR(str, start + 1, end - 1);
    }

    public static void reverseStringR(PrintWriter outputWriter, String str){
        if (str == null || str.length() == 0){
            return;
        }
        reverseStringR(outputWriter, str.substring(1));
        outputWriter.print(str.charAt(0));

    }

    public static boolean isPrimeR(int value, int n) {
        if(value <= 1){
            return false;
        }
        if(n > Math.sqrt(value)){
            return true;
        }
        if(value % n == 0){
            return false;
        }
        return isPrimeR(value, n + 1);
    }
 
    public static int sumR(ArrayList<Integer> nums, int pos) {
        if(pos == nums.size()) {
            return 0;
        }
        return nums.get(pos) + sumR(nums, pos + 1);
    }
 

}

   