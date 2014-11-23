public class FractionCalculatorTest{

	 public static void main(String[] args) {

		String str1 = "3/4";
		FractionCalculator FC1 = new FractionCalculator();
		int test1 = FC1.newNumerator(str1);
		System.out.println("test1 = " + test1);
		int test2 = FC1.newDenominator(str1);
		System.out.println("test2 = " + test2);
		String str2 = "1/2 + 2/3";
		//Fraction test3 = FC1.getFirstFraction();
		//String str3 = test3.toString();
		//System.out.println("test3 = " + str3);
		String str4 = "3/4 + 1/2";
		Fraction a = new Fraction(3,10);
		//Fraction test4 = FC1.getFirstFraction();
		//String str5 = test4.toString();
		//System.out.println("test4 = " + str5);
		//Fraction test5 = FC1.getSecondFraction();
		//String str6 = test5.toString();
		//System.out.println("test5 = " + str6);
		//Fraction test6 = FC1.evaluate(a, str4);
	   	//String str7 = test6.toString();
		//System.out.println(str4 + " = " + str7);
		//Fraction test7 = FC1.evaluate(a, "6/13 - 3/7");
	   // String str8 = test7.toString();
		//System.out.println("6/13 - 3/7 = " + str8);
		//Fraction test8 = FC1.evaluate(a, "6/10 * 2/3");
	    //String str9 = test8.toString();
		//System.out.println("6/10 * 2/3 = " + str9);
		//Fraction test9 = FC1.evaluate(a, "2/3 / 2/5");
	   // String str10 = test9.toString();
		//System.out.println("2/3 / 2/5 = " + str10);
		//String test10 = "9/10 / 8/15 + 1/2";
		//String str11 = FC1.splitFirstThree(test10);
		//System.out.println(str11);
		//Fraction test12 = FC1.getFirstFraction();
		//String str12 = test12.toString();
		//System.out.println("test12 = " + str12);
	//	Fraction test13 = FC1.getSecondFraction();
		//String str13 = test13.toString();
		//System.out.println("test13 = " + str13);
		String str14 = "9/10 / 8/15 + 1/2";
		FC1.addFractions(str14);
		FC1.addOperators(str14);
		System.out.println(FC1.isFracEmpty());
		System.out.println(FC1.isOpEmpty());
		System.out.println(FC1.getNextFrac());
		System.out.println(FC1.getNextFrac());
		System.out.println(FC1.getNextFrac());
		System.out.println(FC1.getNextOp());
		System.out.println(FC1.getNextOp());

		
		
	 }
	 
	 
}