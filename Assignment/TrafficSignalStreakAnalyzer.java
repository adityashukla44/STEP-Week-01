import java.util.Locale;
import java.util.Scanner;

public class TrafficSignalStreakAnalyzer {
    public static void findLongestStreak(String signalLog) {
        String signals = signalLog.trim().toUpperCase(Locale.ROOT);
        if (signals.isEmpty()) {
            System.out.println("No signal readings provided.");
            return;
        }

        for (int i = 0; i < signals.length(); i++) {
            char signal = signals.charAt(i);
            if (signal != 'R' && signal != 'Y' && signal != 'G') {
                System.out.println("Invalid signal at position " + (i + 1)
                        + ": use only R, Y, or G.");
                return;
            }
        }

        char longestColor = signals.charAt(0);
        int longestLength = 1;
        char currentColor = signals.charAt(0);
        int currentLength = 1;

        for (int i = 1; i < signals.length(); i++) {
            char current = signals.charAt(i);
            if (current == currentColor) {
                currentLength++;
            } else {
                currentColor = current;
                currentLength = 1;
            }

            if (currentLength > longestLength) {
                longestLength = currentLength;
                longestColor = currentColor;
            }
        }

        System.out.println("Longest Streak: '" + longestColor + "' repeated "
                + longestLength + (longestLength == 1 ? " time" : " times"));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the signal log (R, Y, G), e.g. RRGGGYRR: ");
        String signalLog = scanner.nextLine();
        findLongestStreak(signalLog);
        scanner.close();
    }
}
