import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Arrays;
import java.util.List;

public class FractionCalculator{
	private Fraction fractionListStart = null;
	private Fraction fraction;
	private String operator;
	private String nextOperator;
	private String[] fractionArr = new String[10];
	private String[] operatorArr = new String[10];
	private ArrayList<String> fractionList = new ArrayList<String>();
	private ArrayList<String> operatorList = new ArrayList<String>();
	
		public FractionCalculator(){
			this.fraction = fraction;
			this.operator = "";
			this.nextOperator = "";
			this.fractionArr = fractionArr;
			this.operatorArr = operatorArr;
			this.fractionList = fractionList;
			this.operatorList = operatorList; 
			
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
		public Fraction getFirstFraction(String str){
			String[] splitFrac = str.split("\\s+");
				for(int i = 1; i < splitFrac.length; i++){ 
						if (splitFrac[i].length() >= 3){
								Fraction firstFrac = new Fraction(newNumerator(splitFrac[0]), newDenominator(splitFrac[0]));
								return firstFrac;
							}
					} return null;
			}
		
		public Fraction getSecondFraction(String str){
			String[] splitFrac = str.split("\\s+");
						for(int i = 1; i < splitFrac.length; i++){ 
						if (splitFrac[i].length() >= 3){
							Fraction newFrac = new Fraction(newNumerator(splitFrac[i]), newDenominator(splitFrac[i]));
							return newFrac;
						}
					}return null;
		}
		//counts the number of elements in the the input string.
		public int inputStringlength(String str){
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
						if (splitFrac[i].length() >= 3){
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
		
		
	

	//Method to evaulate user fraction input.
	public Fraction evaluate(Fraction fraction, String inputString){
			addFractions(inputString);
			String op = getOperator(inputString);
			
			if (op.equals("+")){
				Fraction newFrac = getFirstFraction(inputString);
				Fraction nextFrac = getSecondFraction(inputString);
				Fraction calFrac = newFrac.addition(nextFrac);
				return calFrac;
			} else if (op.equals("-")){
				Fraction newFrac = getFirstFraction(inputString);
				System.out.println(newFrac);
				Fraction nextFrac = getSecondFraction(inputString);
				System.out.println(nextFrac);
				Fraction calFrac = newFrac.subtraction(nextFrac);
				return calFrac;
			}else if (op.equals("/")){
				Fraction newFrac = getFirstFraction(inputString);
				System.out.println(newFrac);
				Fraction nextFrac = getSecondFraction(inputString);
				System.out.println(nextFrac);
				Fraction calFrac = newFrac.divide(nextFrac);
				return calFrac;
			}else if (op.equals("*")){
				Fraction newFrac = getFirstFraction(inputString);
				System.out.println(newFrac);
				Fraction nextFrac = getSecondFraction(inputString);
				System.out.println(nextFrac);
				Fraction calFrac = newFrac.multiply(nextFrac);
				return calFrac;
			} 
			
			return null;
		}
}