package KumaranATM;

public class CardAcountNumberGenerator {
	private static StringBuilder pinNumber;
	private static StringBuilder textBoxCardNumber;
	private static StringBuilder cardNumber;

	public static void main(String[] args) {
		textBoxCardNumber = new StringBuilder();
		pinNumber = new StringBuilder();
		cardNumber = new StringBuilder();
		cardNumber.append("9708-");
		int max = 9;
		int min = 1;
		int range = max - min + 1;

		for (int i = 1; i <= 12; i++) {
			int rand = (int) (Math.random() * range) + min;
			cardNumber.append(rand);
			if (i % 3 == 0) {
				pinNumber.append(rand);
			}
			if (i >= 9)
				textBoxCardNumber.append(rand);
			if (i == 12)
				break;
			if (i % 4 == 0)
				cardNumber.append("-");
		}
		
	}

	public static void setPinNumber(StringBuilder pinNumber) {
		CardAcountNumberGenerator.pinNumber = pinNumber;
	}

	public static void setTextBoxCardNumber(StringBuilder textBoxCardNumber) {
		CardAcountNumberGenerator.textBoxCardNumber = textBoxCardNumber;
	}

	public static void setCardNumber(StringBuilder cardNumber) {
		CardAcountNumberGenerator.cardNumber = cardNumber;
	}

	public static StringBuilder gettextBoxCardNumber() {
		return textBoxCardNumber;
	}

	public static StringBuilder getpinNumber() {
		return pinNumber;
	}

	public static StringBuilder getcardNumber() {
		return cardNumber;
	}
}
