class NumberConverter {
	static boolean NUM_IS_ROMAN = false;
	private static boolean NUM_IS_ARABIC = false;

	private static ArabicAndRomanNumerals approximateRomanToArabic(int num) {
		var result = ArabicAndRomanNumerals.ONE;
		for (ArabicAndRomanNumerals value : ArabicAndRomanNumerals.values()) {
			if (value.getArabicNum() <= num)
				result = value;
			else
				return result;
		}
		return result;
	}

	public static String convertArabicToRoman(int num) {
		ArabicAndRomanNumerals numbersRomanAndArabic;
		var result = "";
		while (num > 0) {
			numbersRomanAndArabic = approximateRomanToArabic(num);
			result += numbersRomanAndArabic.getRomanNum();
			num -= numbersRomanAndArabic.getArabicNum();
		}
		return result;
	}

	public static int convertRomanToArabic(String num) {
		for (ArabicAndRomanNumerals value : ArabicAndRomanNumerals.values()) {
			if (value.getRomanNum().equals(num)) {
				NUM_IS_ROMAN = true;
				return value.getArabicNum();
			}
		}
		return 0;
	}

	public static int convertToInteger(String number) throws Exception {
		int num;
		num = convertRomanToArabic(number);
		if (num == 0) {
			try {
				NUM_IS_ARABIC = true;
				num = Integer.parseInt(number);
			} catch (NumberFormatException ex) {
				throw new Exception("'" + number + "'" + " — данное число не удовлетворяет требованиям ТЗ");
			}
		}
		if (num > 10 || num < 1)
			throw new Exception("Калькулятор принимает на вход числа от 1 до 10 включительно, не более");
		else if (NUM_IS_ROMAN && NUM_IS_ARABIC)
			throw new Exception("Используются одновременно разные системы счисления");
		return num;
	}
}