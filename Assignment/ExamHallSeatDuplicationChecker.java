import java.util.Scanner;

public class ExamHallSeatDuplicationChecker {
    public static void checkDuplicateSeats(int[] seatNumbers) {
        boolean duplicateFound = false;

        for (int i = 0; i < seatNumbers.length; i++) {
            boolean appearedEarlier = false;
            for (int j = 0; j < i; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    appearedEarlier = true;
                    break;
                }
            }
            if (appearedEarlier) {
                continue;
            }

            boolean appearsAgain = false;
            for (int j = i + 1; j < seatNumbers.length; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    appearsAgain = true;
                    break;
                }
            }

            if (appearsAgain) {
                System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
                duplicateFound = true;
            }
        }

        if (!duplicateFound) {
            System.out.println("No Duplicate Seats Found");
        }
    }

    private static int readInteger(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException ignored) {
                System.out.println("Please enter a whole number.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count;
        do {
            count = readInteger(scanner, "Number of students/seats: ");
            if (count <= 0) {
                System.out.println("Enter at least one seat number.");
            }
        } while (count <= 0);

        int[] seatNumbers = new int[count];
        for (int i = 0; i < count; i++) {
            seatNumbers[i] = readInteger(scanner, "Seat number " + (i + 1) + ": ");
        }

        checkDuplicateSeats(seatNumbers);
        scanner.close();
    }
}
