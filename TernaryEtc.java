package week3;

public class TernaryEtc {

	public static void main(String[] args) {
		int num1,num2, result;
		String bigWord;
		num1=2;
		num2=49;
		result = (num1!=num2)? num1:num2+3;
		// Nested ternary
		bigWord = num1>num2 ? "Num 1 is biggest":
			(num2 > num1)? "Num2 is biggest":"Values same";
System.out.println(bigWord+result);

switch (bigWord) {
case "Num 1 is biggest":
	System.out.println("Number 1");
	break;
case "Num 2 is biggest":
	System.out.println("Number 2");
	break;
default:
	System.out.println("Numbers the same");
	//throw new IllegalArgumentException("Unexpected value: " + bigWord);
}

switch(num1) {
case 1 :System.out.println("number was 1");
case 2 : System.out.println("number was 2");
case 3: System.out.println("number was 3");
default: System.out.println("It was another number");
}
	
int numa,numb,num3,answer;
numa = 45;
numb = 12;
num3 = 15;

answer = (numa>= numb? num1: numb);
answer = (answer>num3? numb:num3);
//answer = answer % num3;
System.out.println(answer);
int month;
month = 13;

switch (month) {
case 1:
case 2:
case 12:
   System.out.println("Winter");
   break;
case 3:
case 4:
case 5:
   System.out.println("Spring");
   break;
case 6:
case 7:
case 8:
   System.out.println("Summer");
   break;
case 9:
case 10:
case 11:
   System.out.println("Autumn");
   break;
default:
   System.out.println("You living on Mars?");
}
int faCupWins =12;
switch (faCupWins) {
case 13:
	System.out.println("Arsenal");
case 12:
	System.out.println("Man U");
case 11:
case 10:
case 9:
case 8:
	System.out.println("Spurs (behind Arsenal as usual)");
case 7:
	System.out.println("Liverpool");
	System.out.println("Chelski");
	System.out.println("Aston Villa");
	
default:
	System.out.println("Hardly worth mentioning");
}}
}
