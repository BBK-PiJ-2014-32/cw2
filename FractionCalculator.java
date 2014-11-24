import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Arrays;
import java.util.List;

public class FractionCalculator{
	private Fraction fraction;
	private Fraction fractionRes;
	private String operator;
	private String nextOperator;
	private int singleInCount = 0;
	private String[] fractionArr = new String[10];
	private String[] operatorArr = new String[10];
	private ArrayList<String> fractionList = new ArrayList<String>();
	private ArrayList<String> operatorList = new ArrayList<String>();
	
		public FractionCalculator(){
			this.fraction = fraction;
			this.fractionRes = fractionRes;
			this.operator = "";
			this.nextOperator = "";
			this.fractionArr = fractionArr;
			this.operatorArr = operatorArr;
			this.fractionList = fractionList;
			this.operatorList = operatorList; 	
		}
		
		 public static void main(String[] args) {
		 	FractionCalculator FC1 = new FractionCalculator();
			FC1.run();
		 }
		 
		 public void run(){
			 System.out.println("--------------------------------------------------------");
			 System.out.println("Hello, welcome to Phil Hannant's Fraction Calculator!");
			 System.out.println("To start please enter your first fraction calculation,");
			 System.out.println("fractions should have no space between them like and ");
			 System.out.println("any operators should be preceeded and followed by a ");
			 System.out.println("space. The absolute value of a fraction can be found by");
			 System.out.println("typing A, to negate the fraction type N, to clear ");
			 System.out.println("the value in the calculator input C and to quit type Q.");
			 System.out.println("--------------------------------------------------------");
			 System.out.println("Please type your first input to start");
			 boolean finished = false;
			 	while (!finished){
			 	   	String inputString = System.console().readLine();
					int x = inputStringLength(inputString);
					if (inputString.equals("Q")){
							System.out.println("Goodbye!");
							finished = true;
					} else if (inputString.equals("A")){
							Fraction f1 = evaluate(fractionRes, inputString);
							printOutRes(f1);		
					} else if (inputString.equals("C")){
							Fraction f1 = evaluate(fractionRes, inputString);
							System.out.println(fractionRes);
					}else if (inputString.equals("N")){
						   	Fraction f1 = evaluate(fractionRes, inputString);
						   	System.out.println(fractionRes);
					}else if (x > 3){
							System.out.println("main - 1a");
							Fraction f1 = evaluate(fractionRes, inputString);
							printOutRes(f1);
					}else if (x == 3){
							System.out.println("main - 1b");
							Fraction f1 = evaluate(fractionRes, inputString);
							printOutRes(f1);
					} else if (x == 2){
							System.out.println("main - 2");
							Fraction f1 = evaluate(fractionRes, inputString);
							printOutRes(f1);
					} else if (x == 1 && inputString.length() == 1 && isOpEmpty() == true && (!inputString.equals("Q"))){
							System.out.println("main - 3a");
							evaluate(fractionRes, inputString);
					} else if (x == 1 && inputString.length() == 1 && isOpEmpty() == true && !inputString.equals("A")){
							System.out.println("main - 3b");
							evaluate(fractionRes, inputString);
					} else if (x == 1 && inputString.length() >= 3 && isFracEmpty() == true){
							System.out.println("main - 4");
							Fraction f1 = evaluate(fractionRes, inputString);
							//printOutRes(f1);
					} else if ((x == 1 && inputString.length() == 1 && isOpEmpty() == false) && !inputString.equals("Q")){
							System.out.println("main - 5");
							Fraction f1 = evaluate(fractionRes, inputString);
							printOutRes(f1);
					} else if (x == 1 && inputString.length() >= 3 && isFracEmpty() == false){
 							System.out.println("main - 6");
							Fraction f1 = evaluate(fractionRes, inputString);
							printOutRes(f1);
					}
				}
		 }
		 //Checks output and if present prints it out on screen.
		 public void printOutRes(Fraction fraction){
			 if (fraction != null){
					String outputString = fraction.toString();
 					System.out.println(outputString);
			 } else {
 					fractionRes = null;
 					fractionList.clear();
 					operatorList.clear(); 
			 		System.out.println("Error1");	
			 }
		 }
		//splits the string input into numerator and denominator.
		public int newNumerator(String str){
			char a;
			int newNumer = 0;
			for(int j = 0; j < str.length(); j++){
				a = str.charAt(j);
					if (a == '/'){
						newNumer = Integer.parseInt(str.substring(0,j));
						return newNumer;
					}
				}
			return newNumer;
		}
		//splits the string input into numerator and denominator.
		public int newDenominator(String str){
			char a;
			int newDenom = 0;
			for(int j = 0; j < str.length(); j++){
				a = str.charAt(j);
					if (a == '/'){
						newDenom = Integer.parseInt(str.substring((j+1),str.length()));
						return newDenom;
					}
				}
			return newDenom;
		}
		public Fraction getFirstFraction(){
					String str = getNextFrac();
						if (str.length() >= 3){
								Fraction firstFrac = new Fraction(newNumerator(str), newDenominator(str));
								return firstFrac;
					} return null;
			}
		
		public Fraction getSecondFraction(){
				String str = getNextFrac();
						if (str.length() >= 3){
							Fraction newFrac = new Fraction(newNumerator(str), newDenominator(str));
							return newFrac;
					}return null;
		}
		//counts the number of elements in the the input string.
		public int inputStringLength(String str){
			String[] splitFrac = str.split("\\s+");
			return splitFrac.length;
		}
		public void addFractions(String str){
			String[] splitFrac = str.split("\\s+");
						for(int i = 0; i < splitFrac.length; i++){ 
						if (splitFrac[i].length() >= 3){
							fractionList.add(splitFrac[i]);
						}
					}
		}
		public void addOperators(String str){
			String[] splitFrac = str.split("\\s+");
						for(int i = 0; i < splitFrac.length; i++){ 
						if(splitFrac[i].equals("A")){ 
						} else if (splitFrac[i].equals("N")){
						} else if (splitFrac[i].equals("C")){
						} else if (splitFrac[i].equals("+")||splitFrac[i].equals("-")||splitFrac[i].equals("*")||splitFrac[i].equals("/")){
							operatorList.add(splitFrac[i]);
						} else if (splitFrac[i].length() == 1){
		 					fractionRes = null;
		 					fractionList.clear();
		 					operatorList.clear(); 
					 		System.out.println("Error2");
						}
					}
		}
		
		/*public String getOperator(String str){
			StringTokenizer st = new StringTokenizer(str, " ");
						while (st.hasMoreTokens()){
						String strIn = st.nextToken();
						if (strIn.length() == 1){
							operator = strIn;
							return operator;
						}
					}return operator;
				}*/
		//Returns next fraction and removes it from the arraylist
		public String getNextFrac(){
			        Iterator<String> iterator = fractionList.iterator();
					String str = iterator.next();
					iterator.remove();
					return str;
		} 
		//Returns next operator and removes it from the arraylist
		public String getNextOp(){
			        Iterator<String> iterator = operatorList.iterator();
					String str = iterator.next();
					iterator.remove();
					return str;
		} 
		/*public String getNextOpNoDel(){
			        Iterator<String> iterator = operatorList.iterator();
					String str = iterator.next();
					return str;
		} */
			
		public boolean isFracEmpty(){
			        Iterator<String> iterator = fractionList.iterator();
					if (iterator.hasNext() == true){
						return false;
					} else
					return true;
		} 
		
		public boolean isOpEmpty(){
			        Iterator<String> iterator = operatorList.iterator();
					if (iterator.hasNext() == true){
						return false;
					} else
					return true;
		} 
		//calculation method.
		public Fraction nextCal(Fraction fraction){
			if (isFracEmpty()==false && isOpEmpty() == false && fraction != null){
			String op = getNextOp();
			System.out.println("next Op = " + op);
			if (op.equals("+")){
				Fraction nextFrac = getSecondFraction();
				Fraction calFrac = fraction.addition(nextFrac);
				fractionRes = calFrac;
				return calFrac;
			} else if (op.equals("-")){
				Fraction nextFrac = getSecondFraction();
				Fraction calFrac = fraction.subtraction(nextFrac);
				System.out.println(calFrac);
				fractionRes = calFrac;
				return calFrac;
			}else if (op.equals("/")){
				Fraction nextFrac = getSecondFraction();
				Fraction calFrac = fraction.divide(nextFrac);
				fractionRes = calFrac;
				return calFrac;
			}else if (op.equals("*")){
				Fraction nextFrac = getSecondFraction();
				Fraction calFrac = fraction.multiply(nextFrac);
				fractionRes = calFrac;
				return calFrac;
			} else {
				System.out.println("Error3");
				fractionRes = null;
				fractionList.clear();
				operatorList.clear();
			} 
		} else {
			System.out.println("Error4");
			fractionRes = null;
			fractionList.clear();
			operatorList.clear();
		}return null;
		}

	//Method to evaulate user fraction input.
	public Fraction evaluate(Fraction fraction, String inputString){
			addFractions(inputString);
			addOperators(inputString);
			int x  = inputStringLength(inputString);
			if (fraction == null && x == 3){
				System.out.println("evaluate - 1a");
				fraction = getFirstFraction();
				Fraction calFrac = nextCal(fraction);
				return calFrac;
			} else if (fraction == null && x > 3){
				fraction = getFirstFraction();
				Fraction calFrac = nextCal(nextCal(fraction));
				System.out.println("evaluate - 1b");
				return calFrac;
			} else if (fraction != null && x > 3){
				Fraction calFrac = nextCal(nextCal(fraction));
				System.out.println("evaluate - 1c");
				return calFrac;
			} else if (fraction != null && x >= 2){
				System.out.println("fractionRes " + fractionRes);
				System.out.println("fraction " + fraction);
				System.out.println("evaluate - 2");
				Fraction calFrac = nextCal(fraction);
				return calFrac;
			}else if (inputString.equals("A")){
				Fraction calFrac = fractionRes.absValue();
				fractionRes = calFrac;
				String str = fractionRes.toString();
				addFractions(str);
				return calFrac;
			}else if (inputString.equals("N")){
				Fraction calFrac = fractionRes.negate();
				fractionRes = calFrac;
				String str = fractionRes.toString();
				addFractions(str);
				return calFrac;
			}else if (inputString.equals("C")){
				fractionRes = null;
				fractionList.clear();
				operatorList.clear();
				return null;			
			} else if (x == 1 && inputString.length() == 1){
				System.out.println("evaluate - 3");
				return null;
			} else if (fraction == null && x == 1 && inputString.length() >= 3){
				System.out.println("evaluate - 4");
				Fraction newFrac = new Fraction(newNumerator(inputString), newDenominator(inputString));
				fractionRes = newFrac;
				return null;
			} else if ((fraction != null) && (inputString.length() >= 3) && (singleInCount == 0)){
				System.out.println("evaluate - 5");
				getNextFrac();
				Fraction calFrac = nextCal(fraction);
				fractionRes = calFrac;
				singleInCount++;
				return calFrac;
			} else if (fraction != null && inputString.length() >= 3 && singleInCount >= 1){
				System.out.println("evaluate - 6" + inputString);
				System.out.println("fractionRes " + fractionRes);
				System.out.println("fraction " + fraction);
				Fraction calFrac = nextCal(fraction);
				fractionRes = calFrac;
				return calFrac;	
			} else {
				System.out.println("Error5");
				fractionRes = null;
				fractionList.clear();
				operatorList.clear();
			}
			return null;
		}
}