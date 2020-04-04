import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static stringCalculator stringCal = new stringCalculator();
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        //validating input
        try
        {
            System.out.println("String Calculator");
            System.out.println("Please enter a string");

            String response = in.nextLine();
            if(!response.equals(""))
            {
                int responseLength = response.length();
                String first = Character.toString(response.charAt(0));
                String last = Character.toString(response.charAt(responseLength - 1));

                Pattern digit = Pattern.compile("[0-9]");
                Matcher hasDigit = digit.matcher(first);

                Pattern special = Pattern.compile("[$&+:;=?@#|'\\]<>.\\[^*()%!/]");
                Matcher hasSpecial = special.matcher(response);

                if(first.equals(" ") || last.matches("\\D"))
                {
                    System.out.println("ERROR: invalid input");
                    System.exit(0);
                }
                if(hasDigit.find() && hasSpecial.find())
                {
                    System.out.println("ERROR: invalid input");
                    System.exit(0);
                }
            }
            System.out.println(stringCal.add(response));
        }catch (Exception e)
        {
            System.out.println("ERROR: validating input");
        }
    }
}
