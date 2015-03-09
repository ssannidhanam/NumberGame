import java.util.Scanner;

public class NumberGame {
	
	private static final String EQUAL = "equal";
	private static final String HIGHER = "higher";
	private static final String LOWER = "lower";
	private static final String EXIT = "exit";

	public static void main(String[] args) {
		
		

		int tries = 0;
		Scanner guessValue = new Scanner(System.in);
		int guess = 0;
		int lowValue;
		int highValue;
		String inputValue;
		boolean game = false;
		System.out
				.println("************************************************************************************************************************************"
						+ "\n");
		System.out
				.println("                                                          Number Game Rules             "
						+ "\n");
		
		System.out
				.println("  First You Need to enter lower value and higher value your number needs to be in between  "
						+ "\n");
		System.out
				.println("  Application will give the guessed values based on the value you need to type 'Lower' 'Higher' 'Equal'  "
						+ "\n");
		System.out
				.println("************************************************************************************************************************************"
						+ "\n");
		

		do {

			System.out
					.println("Enter Lowest  Number not less than 1 :");
			inputValue = guessValue.next();
			lowValue = getValue(inputValue);
		} while (lowValue < 0);

		do {

			System.out
					.println("Enter Highest  Number not less than 1 :");
			inputValue = guessValue.next();
			highValue = getValue(inputValue);
		} while (highValue < 1);
		
		if(highValue < lowValue){
			System.out
			.println("  High Value cannot be less than low value. Good Bye  "
					+ "\n");
			System.exit(0);
			
		}

		guess = (lowValue + highValue) / 2;

		while (!game) {
			System.out
					.println("Based on the below number Please Type higher , lower, equal");
			System.out.println("Is your Guess a number is " + guess + " ? :");
			inputValue = guessValue.next();
			tries++;
			if (inputValue.equalsIgnoreCase(EQUAL)) {
				game = true;
				System.out
						.println("Number of Tries  :  "
								+ tries);
				System.out.println("Thank You");
			} else if (inputValue.equalsIgnoreCase(LOWER)) {
				highValue = guess;
				guess = (highValue + lowValue) / 2;
			} else if (inputValue.equalsIgnoreCase(HIGHER)) {
				lowValue = guess;
				guess = (highValue + lowValue) / 2;
			} else if (inputValue.equalsIgnoreCase(EXIT)) {
				break;
			}
		}

	}

	/*
	 * Below Value will give the positive Integer Value if it negative or not an
	 * integer returns -1
	 */

	private static int getValue(String intValue) {
		try {
			return (Integer.parseInt(intValue));
		} catch (NumberFormatException e) {
			System.out.println("Given Numbers are not Integers");
			return -1;
		}
	}

}
