public class FractionCalculatorTest{

	 public static void main(String[] args) {

		String str1 = "3/4";
		FractionCalculator FC1 = new FractionCalculator();
		int test1 = FC1.newNumerator(str1);
		System.out.println("test1 = " + test1);
		int test2 = FC1.newDenominator(str1);
		System.out.println("test2 = " + test2);
		String str2 = "1/2 + 2/3";
		Fraction test3 = FC1.getFirstFraction(str2);
		String str3 = test3.toString();
		System.out.println("test3 = " + str3);
		String str4 = "3/4 + 1/2";
		Fraction a = new Fraction(3,10);
		Fraction test4 = FC1.getFirstFraction(str4);
		String str5 = test4.toString();
		System.out.println("test4 = " + str5);
		Fraction test5 = FC1.getNextFraction(str4);
		String str6 = test5.toString();
		System.out.println("test5 = " + str6);
		Fraction test6 = FC1.evaluate(a, str4);
	    String str7 = test6.toString();
		System.out.println(str4 + " = " + str7);
		Fraction test7 = FC1.evaluate(a, "3/4 - 1/2");
	    String str8 = test7.toString();
		System.out.println("3/4 - 1/2 = " + str8);
		Fraction test8 = FC1.evaluate(a, "3/4 * 1/2");
	    String str9 = test8.toString();
		System.out.println("3/4 * 1/2 = " + str9);
		Fraction test9 = FC1.evaluate(a, "3/4 / 1/2");
	    String str10 = test9.toString();
		System.out.println("3/4 / 1/2 = " + str10);
		
	 }
	 
	 
}