import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorsGame {
    private static final String[] MOVES = {"Rock", "Paper", "Scissors"};

    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equalsIgnoreCase(computerMove)) {
            return "Draw";
        }

        boolean playerWins =
                (playerMove.equalsIgnoreCase("Rock") && computerMove.equalsIgnoreCase("Scissors"))
                || (playerMove.equalsIgnoreCase("Paper") && computerMove.equalsIgnoreCase("Rock"))
                || (playerMove.equalsIgnoreCase("Scissors") && computerMove.equalsIgnoreCase("Paper"));

        return playerWins ? "Player Wins" : "Computer Wins";
    }

    private static String readPlayerMove(Scanner scanner, int round) {
        while (true) {
            System.out.print("Round " + round + " - Enter Rock, Paper, or Scissors: ");
            String move = scanner.nextLine().trim();
            for (String validMove : MOVES) {
                if (validMove.equalsIgnoreCase(move)) {
                    return validMove;
                }
            }
            System.out.println("Invalid move. Please enter Rock, Paper, or Scissors.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int rounds;
        while (true) {
            System.out.print("Number of rounds (suggested: 5): ");
            String input = scanner.nextLine().trim();
            try {
                rounds = Integer.parseInt(input);
                if (rounds > 0) {
                    break;
                }
            } catch (NumberFormatException ignored) {

            }
            System.out.println("Please enter a positive whole number.");
        }

        String[] playerMoves = new String[rounds];
        String[] computerMoves = new String[rounds];
        String[] results = new String[rounds];
        int wins = 0;
        int losses = 0;
        int draws = 0;

        for (int i = 0; i < rounds; i++) {
            playerMoves[i] = readPlayerMove(scanner, i + 1);
            computerMoves[i] = MOVES[random.nextInt(MOVES.length)];
            results[i] = playRound(playerMoves[i], computerMoves[i]);

            if (results[i].equals("Player Wins")) {
                wins++;
            } else if (results[i].equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }
            System.out.println("Computer chose: " + computerMoves[i] + " | Result: " + results[i]);
        }

        System.out.println("\nFINAL SCOREBOARD");
        System.out.printf("%-8s %-16s %-18s %-16s%n", "Round", "Player Move", "Computer Move", "Result");
        System.out.println("------------------------------------------------------------");
        for (int i = 0; i < rounds; i++) {
            System.out.printf("%-8d %-16s %-18s %-16s%n",
                    i + 1, playerMoves[i], computerMoves[i], results[i]);
        }

        double winPercentage = (wins * 100.0) / rounds;
        System.out.println("\nWins: " + wins + " | Losses: " + losses + " | Draws: " + draws);
        System.out.printf("Win Percentage: %.1f%%%n", winPercentage);
        scanner.close();
    }
}
