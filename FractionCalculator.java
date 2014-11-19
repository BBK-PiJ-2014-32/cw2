public class FractionCalculator{
	private

String calcin, numin1, numin2;
int count, split = 0, split2 = 0;
double num1 = 0, num2 = 0, answer = 0;
char opin, opout = '0';
	println("Please enter some text: ");
	calcin = System.console().readLine();
	count = calcin.length();


for(int j=0; j < count; j++){

	opin = calcin.charAt(j);
	if (opin == '+'){
		opout = '+';
		split = j;
 	} else if (opin == '-'){
		opout = '-';
		split = j;
 	}else if (opin == '*'){
		opout = '*';
		split = j;
	}else if (opin == '/'){
		opout = '/';
		split = j;
	}
 }
 println(opout);
 println(split);

 numin1 = calcin.substring(0,split);
 num1 = Double.parseDouble(numin1);

 split2 = split + 1;
 numin2 = calcin.substring(split2,count);
 num2 = Double.parseDouble(numin2);

 	if (opout == '+'){
 		answer = num1 + num2;
 		println(answer);
 	}else if (opout == '-' ){
 		answer = num1 - num2;
 		println(answer);
 	}else if (opout == '*' ){
 		answer = num1 * num2;
 		println(answer);
 	}else if (opout == '/'){
 		answer = num1 / num2;
 		println(answer);
 	} else {
 		println("Please input a valid operator!");
		}
}