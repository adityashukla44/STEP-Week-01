import java.util.Scanner;

public class TeamBmiCalculator {
    public static String getBmiStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25.0) {
            return "Normal";
        } else if (bmi < 30.0) {
            return "Overweight";
        }
        return "Obese";
    }

    public static void printWellnessReport(double[] heights, double[] weights) {
        if (heights.length != weights.length) {
            throw new IllegalArgumentException("Heights and weights must have the same number of entries.");
        }

        System.out.println("\nTEAM WELLNESS REPORT");
        System.out.printf("%-10s %-14s %-14s %-10s %-14s%n",
                "Person", "Height (m)", "Weight (kg)", "BMI", "Status");
        System.out.println("-----------------------------------------------------------------");

        for (int i = 0; i < heights.length; i++) {
            double bmi = weights[i] / (heights[i] * heights[i]);
            System.out.printf("%-10d %-14.2f %-14.2f %-10.2f %-14s%n",
                    i + 1, heights[i], weights[i], bmi, getBmiStatus(bmi));
        }
    }

    private static double readPositiveDouble(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                double value = Double.parseDouble(input);
                if (value > 0 && Double.isFinite(value)) {
                    return value;
                }
            } catch (NumberFormatException ignored) {

            }
            System.out.println("Please enter a valid positive number.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int people;
        while (true) {
            System.out.print("Number of people (suggested: 10): ");
            String input = scanner.nextLine().trim();
            try {
                people = Integer.parseInt(input);
                if (people > 0) {
                    break;
                }
            } catch (NumberFormatException ignored) {

            }
            System.out.println("Please enter a positive whole number.");
        }

        double[] heights = new double[people];
        double[] weights = new double[people];
        for (int i = 0; i < people; i++) {
            System.out.println("\nPerson " + (i + 1));
            heights[i] = readPositiveDouble(scanner, "Height in metres: ");
            weights[i] = readPositiveDouble(scanner, "Weight in kilograms: ");
        }

        printWellnessReport(heights, weights);
        scanner.close();
    }
}
