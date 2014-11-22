public class FractionCalculatorTest{

	 public static void main(String[] args) {

		String str = "3/4";
		FractionCalculator FC1 = new FractionCalculator();
		int test1 = FC1.newNumerator(str);
		System.out.println(test1);
		int test2 = FC1.newDenominator(str);
		System.out.println(test2);

	 }
}