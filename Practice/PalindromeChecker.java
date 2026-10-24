import java.util.Locale;
import java.util.Scanner;

public class PalindromeChecker {
    private static String normalizeText(String text) {
        return text.replaceAll("[^\\p{L}\\p{N}]", "").toLowerCase(Locale.ROOT);
    }

    public static boolean isPalindromeIterative(String text) {
        String normalized = normalizeText(text);
        int left = 0;
        int right = normalized.length() - 1;

        while (left < right) {
            if (normalized.charAt(left) != normalized.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static boolean isPalindromeRecursive(String text) {
        String normalized = normalizeText(text);
        return isPalindromeRecursive(normalized, 0, normalized.length() - 1);
    }

    private static boolean isPalindromeRecursive(String text, int left, int right) {
        if (left >= right) {
            return true;
        }
        if (text.charAt(left) != text.charAt(right)) {
            return false;
        }
        return isPalindromeRecursive(text, left + 1, right - 1);
    }

    public static boolean isPalindromeArrayReversal(String text) {
        String normalized = normalizeText(text);
        char[] characters = normalized.toCharArray();

        int left = 0;
        int right = characters.length - 1;
        while (left < right) {
            char temporary = characters[left];
            characters[left] = characters[right];
            characters[right] = temporary;
            left++;
            right--;
        }

        return normalized.equals(new String(characters));
    }

    private static String label(boolean palindrome) {
        return palindrome ? "Palindrome" : "Not Palindrome";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a word or short phrase: ");
        String text = scanner.nextLine();

        boolean iterative = isPalindromeIterative(text);
        boolean recursive = isPalindromeRecursive(text);
        boolean arrayReversal = isPalindromeArrayReversal(text);

        System.out.println("Iterative: " + label(iterative));
        System.out.println("Recursive: " + label(recursive));
        System.out.println("Array Reversal: " + label(arrayReversal));

        if (iterative == recursive && recursive == arrayReversal) {
            System.out.println("All three approaches agree.");
        } else {
            System.out.println("The approaches disagree; check the implementation.");
        }
        scanner.close();
    }
}
