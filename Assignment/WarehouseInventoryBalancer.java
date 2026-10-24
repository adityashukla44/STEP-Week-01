import java.util.Scanner;

public class WarehouseInventoryBalancer {
    public static void analyzeInventory(int[] sectionA, int[] sectionB) {
        if (sectionA.length != sectionB.length) {
            System.out.println("Error: Both sections must contain the same number of items.");
            return;
        }
        if (sectionA.length == 0) {
            System.out.println("No inventory items provided.");
            return;
        }

        long totalA = 0;
        long totalB = 0;
        for (int quantity : sectionA) {
            totalA += quantity;
        }
        for (int quantity : sectionB) {
            totalB += quantity;
        }

        String status = totalA == totalB ? "Balanced" : "Not Balanced";
        System.out.println("Section A Total: " + totalA + " | Section B Total: " + totalB
                + " | Status: " + status);

        int highestQuantity = Integer.MIN_VALUE;
        String highestSection = "Section A";
        int highestIndex = 0;

        for (int i = 0; i < sectionA.length; i++) {
            if (sectionA[i] > highestQuantity) {
                highestQuantity = sectionA[i];
                highestSection = "Section A";
                highestIndex = i;
            }
        }
        for (int i = 0; i < sectionB.length; i++) {
            if (sectionB[i] > highestQuantity) {
                highestQuantity = sectionB[i];
                highestSection = "Section B";
                highestIndex = i;
            }
        }

        System.out.println("Highest Quantity: " + highestQuantity + " ("
                + highestSection + ", Item " + (highestIndex + 1) + ")");
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
            count = readInteger(scanner, "Number of item categories: ");
            if (count <= 0) {
                System.out.println("Enter at least one item category.");
            }
        } while (count <= 0);

        int[] sectionA = new int[count];
        int[] sectionB = new int[count];
        System.out.println("Enter quantities for Section A:");
        for (int i = 0; i < count; i++) {
            sectionA[i] = readInteger(scanner, "Item " + (i + 1) + ": ");
        }
        System.out.println("Enter quantities for Section B:");
        for (int i = 0; i < count; i++) {
            sectionB[i] = readInteger(scanner, "Item " + (i + 1) + ": ");
        }

        analyzeInventory(sectionA, sectionB);
        scanner.close();
    }
}
