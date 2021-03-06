import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class StringCalculator {
    //public declarations
    public static String delimits;
    public static String[] values;
    public static String stringSum;
    public static List<Integer> listNo = new ArrayList<Integer>();
    public static List<String> negNumbers = new ArrayList<String>();
    public static StringBuilder stringBuilder = new StringBuilder();
    public static StringBuilder stringBuilder1 = new StringBuilder();
    public static String add(String Parameter){
        try{
            //if nothing is entered
            if(Parameter.equals(""))
            {
                return "0";
            }
            //processing single delimits
            try
            {
                int parameterLength = Parameter.length();
                String parameterChar1 = "";
                String parameterChar2 = "";
                if(parameterLength > 1)
                {
                    parameterChar1 = Character.toString(Parameter.charAt(0));
                    parameterChar2 = Character.toString(Parameter.charAt(1));
                }
                if(parameterChar1.equals("/") && parameterChar2.equals("/"))
                {
                    String backSlash;
                    int i = 0;
                    int p = 2;
                    do {
                        backSlash = Character.toString(Parameter.charAt(p));
                        String charToAdd = Character.toString(Parameter.charAt(p));
                        stringBuilder.append(charToAdd);
                        i++;
                        p++;
                    } while (i <= parameterLength && !backSlash.equals("\\"));
                    delimits = stringBuilder.substring(0, stringBuilder.toString().length() - 1);
                }
            }catch(Exception e)
            {
                System.out.println("ERROR: processing single delimits failed");
            }
            //processing multiple delimits
            try
            {
                if(delimits != null)
                {
                    int delimitsLength = delimits.length();
                    String delimitsChar1 = Character.toString(delimits.charAt(0));
                    String delimitsLastChar = Character.toString(delimits.charAt(delimitsLength -1));
                    if(delimitsChar1.equals("[") && delimitsLastChar.equals("]"))
                    {
                        for(int i=0; i<=delimitsLength-1; i++)
                        {
                            String cha = Character.toString(delimits.charAt(i));
                            if(cha.equals("]"))
                            {
                                cha = cha+"|";
                            }
                            stringBuilder1.append(cha);
                        }
                        delimits = stringBuilder1.substring(0, stringBuilder1.toString().length() - 1);
                    }else if(!delimitsChar1.equals("[") && !delimitsLastChar.equals("]"))
                    {
                        delimits = "[" + delimits + "]";
                    }
                }
            }catch(Exception e)
            {
                System.out.println("ERROR: processing multiple delimits failed " + e);
            }
            //splitting the string with delimiters
            try
            {
                delimits = delimits + "|[$&+,:;=?@#|'\\]<>.\\[\\\\^*()%!a-zA-Z\\\\/]";
                values = Parameter.split(delimits);
            }catch(Exception e)
            {
                System.out.println("ERROR: splitting the string with delimiters failed");
            }
            //validating the numbers
            try
            {
                for(int q = 0; q < values.length; q++)
                {
                    Pattern neg = Pattern.compile ("[-]");
                    Matcher hasNegative = neg.matcher(values[q]);
                    try
                    {
                        if(hasNegative.find())
                        {
                            negNumbers.add(values[q]);
                        }else
                        {
                            int No;
                            if(values[q].equals(""))
                            {
                                No = 0;
                                listNo.add(No);
                            }else
                            {
                                No = Integer.parseInt(values[q]);
                                listNo.add(No);
                            }

                        }
                    }catch(Exception e){
                        System.out.println("ERROR: dealing with negatives and positives");
                    }
                }
            }catch(Exception e)
            {
                System.out.println("ERROR: validating the numbers failed" + e);
            }
            //adding the numbers
            try
            {
                int sum = 0;
                for(int j = 0; j < listNo.size(); j++){
                    if(listNo.get(j) < 1000)
                    {
                        sum = sum + listNo.get(j);
                    }
                }
                stringSum = Integer.toString(sum);
                String negNumber = negNumbers.toString();
                negNumber = negNumber.substring(1, negNumber.length() - 1);
                if(negNumbers.size() > 0)
                {
                    return "ERROR: negatives not allowed " + negNumber;
                }
                return stringSum;
            }catch(Exception e)
            {
                System.out.println("ERROR: adding the numbers failed");
            }
        }catch(Exception e)
        {
            System.out.println("Something went wrong");
        }
        return "";
    }
}
