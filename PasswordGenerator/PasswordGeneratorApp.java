import java.security.SecureRandom;
import java.util.Scanner;

class PasswordUtil {
    private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUMBERS = "0123456789";
    private static final String SYMBOLS = "!@#$%^&*()_+-=[]{}|;:,.<>?";

    // Method to generate a secure password based on criteria
    public static String generatePassword(int length, boolean useUpper, boolean useLower, boolean useNums, boolean useSyms) {
        StringBuilder allowedChars = new StringBuilder();
        if (useUpper) allowedChars.append(UPPER);
        if (useLower) allowedChars.append(LOWER);
        if (useNums) allowedChars.append(NUMBERS);
        if (useSyms) allowedChars.append(SYMBOLS);

        if (allowedChars.length() == 0) {
            return "Error: You must select at least one character type!";
        }

        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(allowedChars.length());
            password.append(allowedChars.charAt(index));
        }

        return password.toString();
    }

    // Method to evaluate password strength
    public static void evaluateStrength(String password) {
        int score = 0;
        int length = password.length();

        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        boolean hasSymbol = false;

        for (int i = 0; i < length; i++) {
            char ch = password.charAt(i);
            if (Character.isUpperCase(ch)) hasUpper = true;
            else if (Character.isLowerCase(ch)) hasLower = true;
            else if (Character.isDigit(ch)) hasDigit = true;
            else hasSymbol = true;
        }

        // Scoring logic
        if (length >= 8) score++;
        if (length >= 12) score++;
        if (hasUpper) score++;
        if (hasLower) score++;
        if (hasDigit) score++;
        if (hasSymbol) score++;

        System.out.println("\n--- Password Strength Evaluation ---");
        System.out.println("Password Length: " + length);
        System.out.println("Contains Uppercase: " + (hasUpper ? "Yes" : "No"));
        System.out.println("Contains Lowercase: " + (hasLower ? "Yes" : "No"));
        System.out.println("Contains Numbers: " + (hasDigit ? "Yes" : "No"));
        System.out.println("Contains Symbols: " + (hasSymbol ? "Yes" : "No"));

        System.out.print("Strength Rating: ");
        if (score <= 2) {
            System.out.println("WEAK 🔴 (Easily crackable, consider adding length, numbers, and symbols)");
        } else if (score <= 4) {
            System.out.println("MODERATE 🟡 (Decent, but could be stronger with more character variety)");
        } else {
            System.out.println("STRONG 🟢 (Excellent security configuration!)");
        }
        System.out.println("------------------------------------");
    }
}

public class PasswordGeneratorApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=========================================");
        System.out.println("  SECURE PASSWORD GENERATOR & CHECKER    ");
        System.out.println("=========================================");

        boolean exit = false;
        while (!exit) {
            System.out.println("\nMenu:");
            System.out.println("1. Generate a Secure Password");
            System.out.println("2. Evaluate an Existing Password's Strength");
            System.out.println("3. Exit");
            System.out.print("Choose an option (1-3): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    int length = 12;
                    while (true) {
                        System.out.print("Enter desired password length (e.g., 12): ");
                        String lengthInput = scanner.nextLine().trim();
                        try {
                            length = Integer.parseInt(lengthInput);
                            if (length > 0) {
                                break;
                            }
                            System.out.println("Length must be greater than 0. Try again.");
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input! Please enter a valid number (e.g., 12).");
                        }
                    }

                    if (length < 4) {
                        System.out.println("Warning: Short passwords are less secure. Recommended length is 8+.");
                    }

                    System.out.print("Include Uppercase letters (A-Z)? (y/n): ");
                    boolean upper = scanner.nextLine().trim().equalsIgnoreCase("y");

                    System.out.print("Include Lowercase letters (a-z)? (y/n): ");
                    boolean lower = scanner.nextLine().trim().equalsIgnoreCase("y");

                    System.out.print("Include Numbers (0-9)? (y/n): ");
                    boolean nums = scanner.nextLine().trim().equalsIgnoreCase("y");

                    System.out.print("Include Symbols (!@#$...)? (y/n): ");
                    boolean syms = scanner.nextLine().trim().equalsIgnoreCase("y");

                    String generatedPassword = PasswordUtil.generatePassword(length, upper, lower, nums, syms);
                    System.out.println("\nGenerated Password: " + generatedPassword);
                    if (!generatedPassword.startsWith("Error")) {
                        PasswordUtil.evaluateStrength(generatedPassword);
                    }
                    break;



                case 2:
                    System.out.print("Enter the password you want to evaluate: ");
                    String userPassword = scanner.nextLine();
                    PasswordUtil.evaluateStrength(userPassword);
                    break;

                case 3:
                    exit = true;
                    System.out.println("Exiting Password Utility. Stay secure!");
                    break;

                default:
                    System.out.println("Invalid choice. Please choose between 1 and 3.");
            }
        }

        scanner.close();
    }
}
