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
			 System.out.println("the value in the calculator input clr and to quit type Q.");
			 System.out.println("--------------------------------------------------------");
			 System.out.println("Please type your first input to start");
			 boolean finished = false;
			 	while (!finished){
			 	   	String inputString = System.console().readLine();
					int x = inputStringLength(inputString);
					if (x == 3){
							Fraction a = evaluate(fractionRes, inputString);
							String outputString = a.toString();
			 				System.out.println(a);
					} else if (x == 2){
							Fraction a = evaluate(fractionRes, inputString);
							String outputString = a.toString();
			 				System.out.println(a);
					} else if (x == 1 && inputString.length() == 1){
						evaluate(fractionRes, inputString);
					} else if (x == 1 && inputString.length() >= 3){
						Fraction a = evaluate(fractionRes, inputString);
						String outputString = a.toString();
		 				System.out.println(a);
					}
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
			//String[] splitFrac = str.split("\\s+");
				//for(int i = 1; i < splitFrac.length; i++){ 
					String str = getNextFrac();
						if (str.length() >= 3){
								Fraction firstFrac = new Fraction(newNumerator(str), newDenominator(str));
								return firstFrac;
								//}
					} return null;
			}
		
		public Fraction getSecondFraction(){
			//String[] splitFrac = str.split("\\s+");
			//			for(int i = 1; i < splitFrac.length; i++){ 
				String str = getNextFrac();
						if (str.length() >= 3){
							Fraction newFrac = new Fraction(newNumerator(str), newDenominator(str));
							return newFrac;
							//}
					}return null;
		}
		//counts the number of elements in the the input string.
		public int inputStringLength(String str){
			String[] splitFrac = str.split("\\s+");
			return splitFrac.length;
		}
		//returns a new string of just the first elements when the user inputs more than 3 elements.
		public String splitFirstThree(String str){
			String newStr = "";
			String[] splitFrac = str.split("\\s+");
			if (splitFrac.length > 3){
				for(int i = 0; i < 3; i++){
					newStr = newStr + " " + splitFrac[i];
					newStr = newStr.trim();	
					}	
			}return newStr;
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
						if (splitFrac[i].length() == 1){
							operatorList.add(splitFrac[i]);
						}
					}
		}
		
		public String getOperator(String str){
			StringTokenizer st = new StringTokenizer(str, " ");
						while (st.hasMoreTokens()){
						String strIn = st.nextToken();
						if (strIn.length() == 1){
							operator = strIn;
							return operator;
						}
					}return operator;
				}
		
		public String getNextFrac(){
			        Iterator<String> iterator = fractionList.iterator();
					String str = iterator.next();
					iterator.remove();
					return str;
		} 
		
		public String getNextOp(){
			        Iterator<String> iterator = operatorList.iterator();
					String str = iterator.next();
					iterator.remove();
					return str;
		} 
		
		public Fraction firstCal(){
			String op = getNextOp();
			if (op.equals("+")){
				Fraction newFrac = getFirstFraction();
				Fraction nextFrac = getSecondFraction();
				Fraction calFrac = newFrac.addition(nextFrac);
				fractionRes = calFrac;
				return calFrac;
			} else if (op.equals("-")){
				Fraction newFrac = getFirstFraction();
				Fraction nextFrac = getSecondFraction();
				Fraction calFrac = newFrac.subtraction(nextFrac);
				fractionRes = calFrac;
				return calFrac;
			}else if (op.equals("/")){
				Fraction newFrac = getFirstFraction();
				Fraction nextFrac = getSecondFraction();
				Fraction calFrac = newFrac.divide(nextFrac);
				fractionRes = calFrac;
				return calFrac;
			}else if (op.equals("*")){
				Fraction newFrac = getFirstFraction();
				Fraction nextFrac = getSecondFraction();
				Fraction calFrac = newFrac.multiply(nextFrac);
				fractionRes = calFrac;
				return calFrac;
			} return null;
		}
	
		public Fraction nextCal(Fraction fraction){
			String op = getNextOp();
			if (op.equals("+")){
				Fraction nextFrac = getSecondFraction();
				Fraction calFrac = fraction.addition(nextFrac);
				fractionRes = calFrac;
				return calFrac;
			} else if (op.equals("-")){
				Fraction nextFrac = getSecondFraction();
				Fraction calFrac = fraction.subtraction(nextFrac);
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
			} return null;
		}
	

	//Method to evaulate user fraction input.
	public Fraction evaluate(Fraction fraction, String inputString){
			addFractions(inputString);
			addOperators(inputString);
			if (fraction == null){
				Fraction calFrac = firstCal();
				return calFrac;
			} else if (fraction != null){
				Fraction calFrac = nextCal(fraction);
				return calFrac;
			}
			return null;
		}
}