import java.lang.Exception;
import java.util.Scanner;

public class Main {
	static int A, B;

	public static void main(String[] args) throws Exception {
		System.out.println("Enter your expression, please: ");
		Scanner scanner = new Scanner(System.in);
		String userInput = scanner.nextLine();
		System.out.println(calc(userInput));
	}

	public static String calc(String input) throws Exception {
		char[] inputArray = input.toCharArray();
		char[] operators = {'-', '+', '*', '/'};
		String numA = "", numB = "";
		var userOperator = ' ';
		var result = 0;
		for (var i = 0; i < input.length(); i++) {
			for (var j : operators) {
				if (i != 0)
					if ((inputArray[i] == j) && (userOperator == ' '))
						userOperator = j;
					else if (inputArray[i] == j)
						throw new Exception("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
			}
			if (!(inputArray[i] == ' '))
				if (userOperator == ' ')
					numA += inputArray[i];
				else if (!(userOperator == inputArray[i]))
					numB += inputArray[i];
		}
		if (userOperator == ' ')
			throw new Exception("Строка не является математической операцией");
		A = NumberConverter.convertToInteger(numA);
		B = NumberConverter.convertToInteger(numB);
		switch (userOperator) {
			case '-' -> result = A - B;
			case '+' -> result = A + B;
			case '*' -> result = A * B;
			case '/' -> result = A / B;
		}
		if (NumberConverter.NUM_IS_ROMAN)
			if (result > 0)
				return NumberConverter.convertArabicToRoman(result);
			else
				throw new Exception("В римской системе нет 0 и отрицательных чисел");
		return Integer.toString(result);
	}
}