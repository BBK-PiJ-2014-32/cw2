import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Arrays;
import java.util.Scanner;


public class FractionCalculator{
	private Fraction fraction;
	private Fraction fractionRes;
	private int singleInCount = 0;
	private ArrayList<String> fractionList = new ArrayList<String>();
	private ArrayList<String> operatorList = new ArrayList<String>();

		public FractionCalculator(){
			this.fraction = fraction;
			this.fractionRes = fractionRes;
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
			 System.out.println("Please type your first input to start:");
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
					}else if (inputString.equals("N")){
						   	Fraction f1 = evaluate(fractionRes, inputString);
						   	System.out.println(fractionRes);
					}else if (x > 3){
							Fraction f1 = evaluate(fractionRes, inputString);
							printOutRes(f1);
					}else if (x == 3){
							Fraction f1 = evaluate(fractionRes, inputString);
							printOutRes(f1);
					} else if (x == 2){
							Fraction f1 = evaluate(fractionRes, inputString);
							printOutRes(f1);
					} else if (x == 1 && inputString.length() == 1 && isOpEmpty() == true && isNumeric(inputString) == false){
							evaluate(fractionRes, inputString);
					} else if (x == 1 && inputString.length() == 1 && isOpEmpty() == true && isNumeric(inputString) == true){
							inputString = inputString + "/1";
							evaluate(fractionRes, inputString);
					} else if (inputString.length() == 1 && isNumeric(inputString)){
							Fraction f1 = evaluate(fractionRes, inputString);
							printOutRes(f1);
					} else if (x == 1 && inputString.length() >= 3 && isFracEmpty() == true){
							Fraction f1 = evaluate(fractionRes, inputString);
							printOutRes(f1);
					} else if ((x == 1 && inputString.length() == 1 && isOpEmpty() == false && isNumeric(inputString) == false)){
							Fraction f1 = evaluate(fractionRes, inputString);
							printOutRes(f1);
					} else if (x == 1 && inputString.length() >= 3 && isFracEmpty() == false){
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
				 } 
		 }
		 //checks if single inputs are numeric or operator.
		 public boolean isNumeric(String inputString){
			 if(Character.isDigit(inputString.charAt(0))){
				 return true;
			 }
				 return false;
		 }
		 //checks for whole numbers when creating fractions.
		 public boolean isWhole(String inputString){
			 Scanner scan = new Scanner(inputString);
			 while(scan.hasNext()){
				 if (scan.hasNextInt() == true){
					 return true;
				 }
			 }
			 scan.close();
			 return false;
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
		//Clears contents of calculator.
		public void clearCal(){
				fractionRes = null;
			 	fractionList.clear();
 				operatorList.clear();
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
		//gets next fraction from the list.
		public Fraction getFraction(){
			String str = getNextFrac();
				if (str.length() >= 3){
						Fraction firstFrac = new Fraction(newNumerator(str), newDenominator(str));
						return firstFrac;
				} else if (isWhole(str) == true){
						str = str + "/1";
						Fraction firstFrac = new Fraction(newNumerator(str), newDenominator(str));
						return firstFrac;
				} return null;
			}
		//counts the number of elements in the the input string.
		public int inputStringLength(String str){
			String[] splitFrac = str.split("\\s+");
			return splitFrac.length;
		}
		//adds string tokens to the array list.
		public void addFractions(String str){
			String[] splitFrac = str.split("\\s+");
						for(int i = 0; i < splitFrac.length; i++){
						if (splitFrac[i].length() >= 3 || isNumeric(splitFrac[i]) == true){
							fractionList.add(splitFrac[i]);
						}
					}
		}
		//adds operator tokens to the array list.
		public void addOperators(String str){
			String[] splitFrac = str.split("\\s+");
						for(int i = 0; i < splitFrac.length; i++){
						if(splitFrac[i].equals("A")){
						} else if (splitFrac[i].equals("N")){
						} else if (splitFrac[i].equals("C")){
						} else if (splitFrac[i].equals("+")||splitFrac[i].equals("-")||splitFrac[i].equals("*")||splitFrac[i].equals("/")){
							operatorList.add(splitFrac[i]);
						} else if (isNumeric(splitFrac[i]) == true){
						} else if (splitFrac[i].length() == 1){
							clearCal();
					 		System.out.println("Error");
						}
					}
		}
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
		//checks if array list of fractions is empty.
		public boolean isFracEmpty(){
			        Iterator<String> iterator = fractionList.iterator();
					if (iterator.hasNext() == true){
						return false;
					}
					return true;
		}
		//checks if array list of operators is empty.
		public boolean isOpEmpty(){
			        Iterator<String> iterator = operatorList.iterator();
					if (iterator.hasNext() == true){
						return false;
					}
					return true;
		}
		//Add result onto list.
		public void addRes(Fraction fraction){
					String str = fraction.toString();
					addFractions(str);
		}

		//calculation method.
		public Fraction nextCal(Fraction fraction){
			if (isFracEmpty() == false && isOpEmpty() == false && fraction != null){
				String op = getNextOp();
				if (op.equals("+")){
					Fraction nextFrac = getFraction();
					Fraction calFrac = fraction.addition(nextFrac);
					fractionRes = calFrac;
					return calFrac;
				} else if (op.equals("-")){
					Fraction nextFrac = getFraction();
					Fraction calFrac = fraction.subtraction(nextFrac);
					fractionRes = calFrac;
					return calFrac;
				}else if (op.equals("/")){
					Fraction nextFrac = getFraction();
					Fraction calFrac = fraction.divide(nextFrac);
					fractionRes = calFrac;
					return calFrac;
				}else if (op.equals("*")){
					Fraction nextFrac = getFraction();
					Fraction calFrac = fraction.multiply(nextFrac);
					fractionRes = calFrac;
					return calFrac;
				} else {
					clearCal();
					System.out.println("Error");
				}
		} else {
			clearCal();
			System.out.println("Error");
		}return null;
		}

	//Method to evaulate user fraction input.
	public Fraction evaluate(Fraction fraction, String inputString){
			addFractions(inputString);
			addOperators(inputString);
			int x  = inputStringLength(inputString);
			if (inputString.equals("A")){
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
				clearCal();
				return null;
			} else if (isFracEmpty() == false && isOpEmpty() == false && fraction != null){
				Fraction calFrac = nextCal(fraction);
				fractionRes = calFrac;
				return calFrac;	
			} else if (isFracEmpty() == false && isOpEmpty() == false && fraction == null && x > 3){
				fraction = getFraction();
				Fraction calFrac = nextCal(nextCal(fraction));
				fractionRes = calFrac;
				return calFrac;
			} else if (isFracEmpty() == false && isOpEmpty() == false && fraction == null && x == 3){
				fraction = getFraction();
				Fraction calFrac = nextCal(fraction);
				fractionRes = calFrac;
				return calFrac;
			} else if (isFracEmpty() == false && isOpEmpty() == true && fraction == null){
				fractionRes = getFraction();
				return null;
			} else if (isFracEmpty() == true && isOpEmpty() == false && fraction != null){
				fractionRes = fraction;
				return fractionRes;
			} else if (isFracEmpty() == false && isOpEmpty() == true && fraction != null){
				fractionRes = fraction;
				return fractionRes;
			} else if (isFracEmpty() == true && isOpEmpty() == true && fraction == null){
				return null;	
			} else if (isFracEmpty() == true && isOpEmpty() == false && fraction == null){
				return null;
			}
			return null;
		}
}