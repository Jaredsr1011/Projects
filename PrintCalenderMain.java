import java.util.Scanner;

/**
 * A program that prints a calendar month or year.
 * 
 * Jared Roque
 * CSC 15-09
 *
 */
public class PrintCalenderMain {
	/**
	 * Use the getValidInt() method to get a valid year between 1800 and 3000.
	 * Within the do loop, add code where it has the "your code" comment to prompt
	 * them to enter a "y" or an "m" and if they answer "m" you will also need to
	 * ask them for a number between 1 and 12 using the getValidInt() method. If
	 * they answered "y" then print out every month for that year. If they answered
	 * "m" then print out just the one month. If they answered anything else then
	 * output an error message.
	 * 
	 * @param args Command-line arguments
	 */
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int month;

		// Prompt the user to enter the year

		boolean repeat;

		do {
			String prompt = ("Enter a year between 1800 and 3000: ");
			int year = PrintCalendarHelper.getValidInt(kb, prompt, 1800, 3000);
			System.out.println("Select one of the following options:");
			System.out.println("To get the month calendar press m or M");
			System.out.println("To get the calendar for the year enter y or Y");
			System.out.print("Enter your choice: ");
			char choice = kb.next().charAt(0);
			if (choice == 'y' || choice == 'Y') {
				for (int i = 1; i <= 12; i++) {
					printMonth(year, i);
				}
			
			} else if (choice == 'm' || choice == 'M') {
				do {
					System.out.print("Enter the month of the year (1 through 12): ");
					month = kb.nextInt();
					kb.nextLine();
				} while (month < 1 || month > 12);
				printMonth(year, month);
			}

			String answer;

			do {
				System.out.println();
				System.out.print("Do you have another year to print the calender:yes/no--> ");
				answer = kb.next();

			} while (!answer.equalsIgnoreCase("no") && !answer.equalsIgnoreCase("yes"));

			repeat = answer.equalsIgnoreCase("yes");
		} while (repeat); // repeat as long as the user wants to

	}

	/**
	 * Outputs a month on the calendar for a given year. Use the printTitle() and
	 * the printMonthBody() methods to do the actual printing
	 * 
	 * @param year  The year to print
	 * @param month The month to print
	 */
	public static void printMonth(int year, int month) {
		// call the method printTitle with the values year and month
		printMonthTitle(year, month);

		// call the method printMonthBody with the values year and month
		printMonthBody(year, month);

	}

	/**
	 * Prints the month name, a separator line and then the days of the week (Sun,
	 * Mon, ..., Sat)
	 * 
	 * @param year  The year of the month title to print.
	 * @param month The month to print.
	 */
	public static void printMonthTitle(int year, int month) {
		// output the title for each month of the year
		System.out.println();
		String monthName = PrintCalendarHelper.getMonthName(month);
		System.out.println("\t" + monthName + " " + year);
		for (int i = 1; i <= 28; i++) {
			System.out.print("-");
		}
		System.out.println();
		System.out.println("Sun Mon Tue Wed Thu Fri Sat");
	}

	/**
	 * This method prints the body of the calendar for the given month by first
	 * determining the start day of the month (using the getStartDay() method) and
	 * then calling the print method to actually print the rest of the calendar.
	 * 
	 * @param year The year of the month to print
	 * @param The  month to print. (1 = January and 12 = December)
	 */
	public static void printMonthBody(int year, int month) {
		// call the method getStartDay to get the start day for the given month of
		// the year
		int start = PrintCalendarHelper.getStartDay(year, month);

		// call the method print to print the calendar for the month and pass
		// the first day of the month as the parameter
		// print(day, year, month);
		print(start, year, month);
	}

	/**
	 * Prints the calendar for the given month.
	 * 
	 * @param startDay The day of the week that the month begins on. (0 = Sunday and
	 *                 6 = Saturday)
	 * @param year     The year of the month
	 * @param month    The month to print. (1 = January and 12 = December)
	 */
	public static void print(int startDay, int year, int month) {
		final int numDays = PrintCalendarHelper.getNumberOfDaysInMonth(year, month);
		// call the method getNumberOfdaysInMonth to find out the number of the
		// days in the month
		// PrintCalendarHelper.getNumberOfDaysInMonth();

		// use a for loop to print spaces up to the start day for each month
		//int start = PrintCalendarHelper.getStartDay(year, month);
		for (int i = 0; i < startDay; i++) {
			System.out.print("    ");
		}
		// use another for loop to print the rest of the days in the calendar
		// if the month is November calculate the thanksgiving day and output

		for (int i = 1; i <= numDays; i++) {
			if(i < 10) {
				System.out.print(" " + i + "  ");
			} else {
				System.out.print(" " + i + " ");
			}
			if((startDay + i) % 7 == 0) {
				System.out.println();
			}
		}
		int thanks = PrintCalendarHelper.thanks(PrintCalendarHelper.getStartDay(year, month));
		if (month == 11) {
			System.out.println("\n**Thanks giving day is on the " + thanks + "th");
		}
	}
}