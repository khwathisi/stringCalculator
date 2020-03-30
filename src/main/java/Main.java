import java.util.Scanner;

public class Main {
    public static stringCalculator stringCal = new stringCalculator();
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        System.out.println("String Calculator");
        System.out.println("Please enter a string of numbers divided by a comma (,)");
        /*System.out.println("Enter 2 for multiplying");
        while (!in.hasNextInt()){
            System.out.println("enter a number!");
            in.next();
        }*/
        String response = in.nextLine();
        System.out.println(stringCal.add(response));
        /*if(response == 1){
            //adding
            System.out.println(cal.add());
        }else if(response == 2){
            //multiplying
            System.out.println(cal.multiply());
        }else{
            System.out.println("Incorrect option");
        }*/
    }
}
