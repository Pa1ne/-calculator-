enum ArabicAndRomanNumerals {
	ONE(1, "I"), TWO(2, "II"),
	THREE(3, "III"), FOUR(4, "IV"),
	FIVE(5, "V"), SIX(6, "VI"),
	SEVEN(7, "VII"), EIGHT(8, "VIII"),
	NINE(9, "IX"), TEN(10, "X"),
	FORTY(40, "XL"), FIFTY(50, "L"),
	NINETY(90, "XC"), HUNDRED(100, "C");

	private final int arabicNum;
	private final String romanNum;

	ArabicAndRomanNumerals(int arabicNumber, String romanNumber) {
		this.arabicNum = arabicNumber;
		this.romanNum = romanNumber;
	}

	public String getRomanNum() {
		return romanNum;
	}

	public int getArabicNum() {
		return arabicNum;
	}
}