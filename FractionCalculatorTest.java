public class FractionCalculatorTest{

	 public static void main(String[] args) {

		String str1 = "3/4";
		FractionCalculator FC1 = new FractionCalculator();
		int test1 = FC1.newNumerator(str1);
		System.out.println(test1);
		int test2 = FC1.newDenominator(str1);
		System.out.println(test2);
		Fraction test3 = FC1.splitString(str1);
		String str2 = test3.toString();
		System.out.println(str2);
		
	 }
}