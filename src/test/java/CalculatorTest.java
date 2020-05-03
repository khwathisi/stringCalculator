import org.junit.Assert;
import org.junit.Test;
public class CalculatorTest {
    StringCalculator cal = new StringCalculator();
    String testString = "";
    String testString1 = "1,2,3,4";
    String testString2 = "1\n2,3";
    String testString3 = "//;\n1;2";
    String testString4 = "-1,-2,3,4";
    String testString5 = "//;\n1000,1;2";
    String testString6 = "//***\n1***2***3";
    String testString7 = "//[***][%%%]\n1***2%%%3";
    //Change expectedSum according to testString
    String expectedSum = "0";
    @Test
    public void testCalculatorAdd(){
        Assert.assertEquals(cal.add(testString), expectedSum);
    }
}
