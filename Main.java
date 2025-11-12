import java.io.*;

import java.util.*;
//Nick Van Norman, 201R-0001, 201L-008L


class Main {
    public static void main(String[] args) {
        String inputFile = "input.txt";
        String outputFile = "output.txt";
        String errorFile = "error.txt";

    System.out.println("Starting Recursion Program");

    try(BufferedReader br = new BufferedReader(new FileReader(inputFile));
        PrintWriter report = new PrintWriter(new FileWriter(outputFile));
        PrintWriter error = new PrintWriter(new FileWriter(errorFile))) {

        String line;
        while((line = br.readLine()) != null) {
            String[] parts = line.split(",");
            String command = parts[0].trim();

            try{
                switch(command){
                    case "factorialR": {
                        if(parts.length < 2) break;
                        String arg = parts[1];
                        if(!isDigits(arg)) {
                            error.println("factorialR Error: factorialR," + arg + ". The value: " + arg + " is invalid.");
                            break;
                        }
                        long val = Long.parseLong(arg);
                        if(val < 0){
                            error.println("factorialR Error: factorialR," + val + ". The value: " + val + " is invalid.");
                            break;
                        }
                        long result = Recursion.factorialR(val);
                        report.println("The factorial of " + val + " is " + result);
                        break;
                    }

                    case "isPrimeR": {
                        if(parts.length < 2) break;
                        String arg = parts[1];
                        if(!isDigits(arg)) {
                            error.println("isPrimeR Error: isPrimeR," + arg + ". The value: " + arg + " is invalid.");
                            break;
                        }
                        int val = Integer.parseInt(arg);
                        boolean prime = Recursion.isPrimeR(val, 2);
                        if(prime){
                            report.println(val + " is a prime number");
                        }
                        else{
                            report.println(val + " is a not prime number");
                        }
                        break;
                    }

                    case "sumR": {
                        ArrayList<Integer> nums = new ArrayList<>();
                        ArrayList<String> invalidValues = new ArrayList<>();
                        
                        for (int i = 1; i < parts.length; i++) {
                            if (!isDigits(parts[i])) {
                                invalidValues.add(parts[i]);
                            } else {
                                nums.add(Integer.parseInt(parts[i]));
                            }
                        }

                        if (!invalidValues.isEmpty()) {
                            error.print("sumR Error: The value");
                            if (invalidValues.size() > 1) error.print("s");
                            error.print(" ");
                            error.print(String.join(", ", invalidValues));
                            error.println(" " + (invalidValues.size() > 1 ? "are" : "is") + " invalid");
                        } else {
                            int sum = Recursion.sumR(nums, 0);
                            report.print("The sum of the values: ");
                            for (int n : nums) report.print(n + " ");
                            report.println(" is " + sum);
                        }
                        break;
                    }

                    case "palindromeR": {
                        if(parts.length < 2) break;
                        String str = parts[1];
                        boolean isPal = Recursion.palindromeR(str, 0, str.length() - 1);
                        if (isPal){
                            report.println(str + " is a palindrome");
                        }
                        else{
                            report.println(str + " is not a palindrome");
                        }
                        break;
                    }

                    case "reverseStringR": {
                        if(parts.length < 2) break;
                        String str = parts[1];
                        report.print("The string " + str + " in reverse is: ");
                        Recursion.reverseStringR(report, str);
                        report.println();
                        break;
                    }

                    default:
                        error.println("Error: Unknown command '" + command + "'");
                }

            } catch(Exception e){
                error.println("Unexpected error for command: " + line + " (" + e.getMessage() + ")");
            }
        }

        } catch (IOException e){
            System.out.println("File error: " + e.getMessage());
        }

        System.out.println("Program complete. Check output.txt and error.txt.");
 
     
 
    }

    public static boolean isDigits(String str){
        if (str == null || str.isEmpty()) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
