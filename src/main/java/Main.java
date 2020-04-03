import java.util.Scanner;

public class Main {
    public static stringCalculator stringCal = new stringCalculator();
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        System.out.println("String Calculator");
        System.out.println("Please enter a string");

        while(in.hasNext()) {
            System.out.println("Invalid, please try again");
            in.next();
        }
        String response = in.nextLine();
        System.out.println(stringCal.add(response));
    }
}
