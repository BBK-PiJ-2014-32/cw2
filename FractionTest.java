/**
 * Created by keith for the second coursework assignment.
 */
public class FractionTest {
    public static void main(String[] args) {

        // test divide by zero - should print an error and exit
        new Fraction(1, 0);
        // test multiply
	Fraction f = new Fraction(3,10);
	Fraction g = new Fraction(1,2);
	Fraction h = new Fraction(3,5);
	Fraction i = new Fraction(-3,5);
	Fraction j = i.absValue();
	String strJ = j.toString();
	System.out.println(strJ);
	Fraction k = new Fraction(5,1);
	String strK = k.toString();
	System.out.println(strK);
	Fraction l = new Fraction(-5,1);
	test1(new Fraction(-5,3));
	test1(new Fraction(5,-3));
	test1(new Fraction(5,3));
	if (!f.equals(g.multiply(h))) System.out.println("Multiply failed");
        // test equals
	test(new Fraction(1, 2),new Fraction(1, 2),"error test 1");
	test(new Fraction(1, 2),new Fraction(3, 6),"error test 2");
	test(new Fraction(-1, 2),new Fraction(1, -2),"error test 3");
	test(new Fraction(-1, -2),new Fraction(1, 2),"error test 4");
	test(new Fraction(4, -8),new Fraction(1, -2),"error test 5");

        // extend with extra tests
    }

    static void test(Fraction f1, Fraction f2, String msg){
    	if (! f1.equals(f2))
		System.out.println(msg);
    }
	
	public static void test1(Fraction f1){
		Fraction in = f1.negate();
		String str = in.toString();
		System.out.println(str);	
	}

}
