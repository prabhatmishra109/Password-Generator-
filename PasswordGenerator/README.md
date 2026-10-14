# Password Generator & Strength Checker (Core Java)

A lightweight Core Java utility designed to generate cryptographically secure passwords based on user constraints and analyze the complexity/strength of existing passwords.

## Features
- **Customizable Generation:** Specify exact lengths and pick character sets (Uppercase, Lowercase, Digits, Symbols).
- **Secure Randomness:** Utilizes Java's `SecureRandom` class for high-entropy randomization.
- **Detailed Strength Analysis:** Evaluates passwords against length thresholds and character diversity rules, outputting a clear security rating (Weak, Moderate, Strong).

## How to Compile and Run

1. Open your terminal or command prompt in the project folder.
2. Compile the Java files:
   ```bash
   javac PasswordGeneratorApp.java
   ```
3. Run the application:
   ```bash
   java PasswordGeneratorApp
   ```
