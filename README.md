# Password Generator & Strength Checker (Core Java)

A lightweight Core Java utility designed to generate cryptographically secure passwords based on user constraints and analyze the complexity/strength of existing passwords.

## Features
- **Customizable Generation:** Specify exact lengths and pick character sets (Uppercase, Lowercase, Digits, Symbols)[cite: 5].
- **Secure Randomness:** Utilizes Java's `SecureRandom` class for high-entropy randomization[cite: 5].
- **Safe Input Parsing:** Handles non-numeric length inputs gracefully without crashing[cite: 6].
- **Detailed Strength Analysis:** Evaluates passwords against length thresholds and character diversity rules, outputting a clear security rating (Weak, Moderate, Strong)[cite: 5, 6].

## How to Compile and Run

1. Open your terminal or command prompt in the project folder[cite: 5].
2. Compile the Java files[cite: 5]:
   ```bash
   javac PasswordGeneratorApp.java
