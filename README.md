# STEP Week 01: Java Basics: Strings, Loops and Arrays

My solutions to the Week 1 practice problems and coding assignment of the **STEP Java Programming** track.

## Topics covered

- String handling and character checks
- Loops and nested loops
- Arrays
- Methods and recursion
- Conditional logic and input validation

## Practice

| Program | What it does | Input |
|---------|--------------|-------|
| [`FirstNonRepeatingCharacter`](Practice/FirstNonRepeatingCharacter.java) | Finds the first character that appears only once in a word or sentence | Interactive |
| [`PalindromeChecker`](Practice/PalindromeChecker.java) | Checks for a palindrome three ways (iterative, recursive, array reversal) and compares the results | Interactive |
| [`ReverseCustomerName`](Practice/ReverseCustomerName.java) | Reverses a customer's name character by character | Interactive |
| [`RockPaperScissorsGame`](Practice/RockPaperScissorsGame.java) | Multi-round Rock-Paper-Scissors against the computer with a final scoreboard | Interactive |
| [`TeamBmiCalculator`](Practice/TeamBmiCalculator.java) | Calculates BMI for a team and prints a formatted wellness report | Interactive |

## Assignment

| Program | What it does | Input |
|---------|--------------|-------|
| [`ExamHallSeatDuplicationChecker`](Assignment/ExamHallSeatDuplicationChecker.java) | Reports every seat number that has been assigned more than once | Interactive |
| [`MovieReviewWordLengthProfiler`](Assignment/MovieReviewWordLengthProfiler.java) | Counts the short, medium and long words in a movie review | Interactive |
| [`TrafficSignalStreakAnalyzer`](Assignment/TrafficSignalStreakAnalyzer.java) | Finds the longest streak of the same signal in an R/Y/G signal log | Interactive |
| [`TypingSpeedAccuracyChecker`](Assignment/TypingSpeedAccuracyChecker.java) | Compares typed text with the original passage and reports accuracy and the first mismatch | Interactive |
| [`WarehouseInventoryBalancer`](Assignment/WarehouseInventoryBalancer.java) | Compares the totals of two warehouse sections and finds the highest-stock item | Interactive |

## Project structure

```
.
├── Practice/
│   ├── FirstNonRepeatingCharacter.java
│   ├── PalindromeChecker.java
│   ├── ReverseCustomerName.java
│   ├── RockPaperScissorsGame.java
│   ├── TeamBmiCalculator.java
│   └── README.md
├── Assignment/
│   ├── ExamHallSeatDuplicationChecker.java
│   ├── MovieReviewWordLengthProfiler.java
│   ├── TrafficSignalStreakAnalyzer.java
│   ├── TypingSpeedAccuracyChecker.java
│   ├── WarehouseInventoryBalancer.java
│   └── README.md
└── README.md
```

## How to run

You need JDK 8 or later.

```bash
cd Practice      # or: cd Assignment
javac FileName.java
java FileName
```

Replace `FileName` with the program name. Programs marked **Interactive** read input from the terminal; the rest run a built-in example straight away. Each file is self-contained, so you can also open it in VS Code or IntelliJ and press **Run**.

## Author

**Aditya Shukla** · [@adityashukla44](https://github.com/adityashukla44)
