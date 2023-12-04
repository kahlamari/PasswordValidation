import java.security.SecureRandom;
import java.util.Random;

public class PasswordValidation {
    public static void main(String[] args) {
        System.out.println("Hello World");
        System.out.println(generateRandomValidPassword());
        System.out.println(generateRandomValidPassword(12));
    }

    public static boolean hasMinimumLength(String password) {
        if (password == null) {
            return false;
        }
        return password.length() > 7;
    }

    public static boolean hasDigit(String password) {
        return password.matches(".*\\d.*");
    }

    public static boolean hasMixedCaseLetters(String password) {
        return !(password.toLowerCase().equals(password) || password.toUpperCase().equals(password));
    }

    public static boolean isNotCommonPassword(String password) {
        String[] commonPasswords = {"password",
                                    "12345678",
                                    "iloveyou",
                                    "123456789",
                                    "1234567890",
                                    "abcd1234",
                                    "Aa345678",
                                    "Password1"};

        for (String commonPassword : commonPasswords) {
            if(commonPassword.equalsIgnoreCase(password)) {
                return false;
            }
        }
        return true;
    }

    public static boolean containsSpecialCharacter(String password) {
        return password.matches(".*[!@#$%&?].*");
    }

    public static boolean isValid(String password) {
        return hasMinimumLength(password) &&
                hasDigit(password) &&
                hasMixedCaseLetters(password) &&
                containsSpecialCharacter(password);
    }

    public static String generateRandomValidPassword() {
        return generateRandomValidPassword(8);
    }

    public static String generateRandomValidPassword(int passwordLength) {
        /*
        Setting up the function by building the space of characters that
        shall be used to generate the password.
         */
        String upperChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numbers = "1234567890";
        String specialChars = "!@#$%&?";
        String allowedSymbols = upperChars + upperChars.toLowerCase() + numbers + specialChars;
        Random random = new SecureRandom();

        /*
        Generating the valid password.
         */
        StringBuilder generatedPassword = new StringBuilder();
        while (!isValid(generatedPassword.toString())) {
            generatedPassword = new StringBuilder();
            for (int i = 0; i < passwordLength; i++) {
                char c = allowedSymbols.toCharArray()[random.nextInt(allowedSymbols.length())];

                generatedPassword.append(c);
            }
        }

        return generatedPassword.toString();
    }
}
