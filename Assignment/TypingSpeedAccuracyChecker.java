import java.util.Scanner;

public class TypingSpeedAccuracyChecker {
    public static void checkTypingAccuracy(String original, String typed) {
        if (original.length() != typed.length()) {
            System.out.println("Error: The original and typed strings must have equal length.");
            System.out.println("Original length: " + original.length() + " | Typed length: " + typed.length());
            return;
        }

        if (original.isEmpty()) {
            System.out.println("Both strings are empty; accuracy cannot be calculated.");
            return;
        }

        int matched = 0;
        int firstMismatch = -1;
        for (int i = 0; i < original.length(); i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matched++;
            } else if (firstMismatch == -1) {
                firstMismatch = i;
            }
        }

        double accuracy = matched * 100.0 / original.length();
        System.out.printf("Matched: %d/%d | Accuracy: %.2f%%%n", matched, original.length(), accuracy);

        if (firstMismatch == -1) {
            System.out.println("No Mismatches");
        } else {
            System.out.println("First Mismatch at position " + (firstMismatch + 1)
                    + " ('" + original.charAt(firstMismatch) + "' vs '"
                    + typed.charAt(firstMismatch) + "')");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the original passage: ");
        String original = scanner.nextLine();
        System.out.print("Enter your typed passage (same length): ");
        String typed = scanner.nextLine();

        checkTypingAccuracy(original, typed);
        scanner.close();
    }
}
