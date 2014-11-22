import java.util.StringTokenizer;

public class FractionCalculator{
	private Fraction fractionListStart = null;
	private Fraction fraction;
	private String inputString;
	private String operator;
	private String nextOperator;

		public FractionCalculator(){
			this.fraction = null;
			this.inputString = null;
			this.operator = "";
			this.nextOperator = "";
			
		}

		//method to split string.
		public Fraction splitString (String str){
			Fraction emptyFrac = null;
			StringTokenizer st = new StringTokenizer(str, " ");
						while (st.hasMoreTokens()){
						String strIn = st.nextToken();
						if (strIn.length() > 1){
								Fraction newFrac = new Fraction(newNumerator(strIn), newDenominator(strIn));
								return newFrac; 
						}
					}
					return emptyFrac;
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
		public Fraction getFraction(String str){
			String[] splitFrac = str.split("\\s");
				Fraction firstFrac = new Fraction(newNumerator(splitFrac[0]), newDenominator(splitFrac[0]));
				fractionListStart = firstFrac;
						for(int i = 1; i < splitFrac.length; i++){ 
						if (splitFrac[i].length() <= 3){
							Fraction newFrac = new Fraction(newNumerator(splitFrac[i]), newDenominator(splitFrac[i]));
							newFrac.insert(newFrac);
							return newFrac;
						}
					}return null;
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

		

	//Method to evaulate user fraction input.
	public Fraction evaluate(Fraction fraction, String inputString){
			this.getFraction(inputString);
			String op = getOperator(inputString);
			if (op.equals("+")){
				Fraction newFrac = fraction.getNext().addition(fraction.getNext());
				return newFrac;
			}
			return null;
		}
}