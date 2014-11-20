import java.util.StringTokenizer;

public class FractionCalculator{

	private Fraction fraction;
	private String inputString;
	private String operand;

		public FractionCalculator(){
			this.fraction = null;
			this.inputString = null;
			this.operand = "";
		}

		//method to split string.
		public Fraction splitString (String str){
			Fraction newFrac = null;
			StringTokenizer st = new StringTokenizer(str, " ");
						while (st.hasMoreTokens()){
						String strIn = st.nextToken();
					}
					return newFrac;
		}
		
		//splits the string input into numerator and denominator.
		public int newNumerator(String str){
			char a;
			int newNumer = 0;
			for(int j = 0; j < str.length(); j++){
				a = str.charAt(j);
					if (a == '/'){
						newNumer = Integer.parseInt(str.substring(0,j));
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
					}
				}
			return newDenom;
		}



	//Method to evaulate user fraction input.
	public Fraction evaluate(Fraction fraction, String inputString){
			Fraction newFrac = null;
			return newFrac;
		}
}