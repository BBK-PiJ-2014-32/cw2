/**
 * Created by keith for the second coursework assignment.
 */
public class FractionTest {
	private Fraction fractionListStart = null;
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

	Fraction m = new Fraction(2,3);
	Fraction n = new Fraction(2,4);
	Fraction o = m.multiply(n);
    String strO = m.toString();
	System.out.println("1 " + strO);
	Fraction p = new Fraction(3,5);
	Fraction q = new Fraction(6,15);
	Fraction r = p.divide(q);
	String strR = r.toString();
	System.out.println("2 " + strR);
	Fraction s = new Fraction(1,5);
	Fraction t = new Fraction(3,8);
	Fraction u = s.addition(t);
	String strU = u.toString();
	System.out.println("3 " + strU);
	Fraction v = new Fraction(3,10);
	Fraction w = new Fraction(2,20);
	Fraction x = v.subtraction(w);
    String strX = x.toString();
	System.out.println("4 " + strX);
	FractionTest FT1 = new FractionTest();
	FT1.run();

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
 		public void run(){
		Fraction test4 = new Fraction (2, 4);
		fractionListStart = test4;
		Fraction test5 = new Fraction (5, 3);
		fractionListStart.insert(test5);
		Fraction test6 = new Fraction (7, 2);
		fractionListStart.insert(test6);
		System.out.println(test4.getNext());
		System.out.println(test5.getNext());
		System.out.println(test6.getNext());
		
 }
}
