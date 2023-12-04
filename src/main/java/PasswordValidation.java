import java.security.SecureRandom;
import java.util.Random;

public class PasswordValidation {

    public static boolean isValid(String password) {
        return hasMinimumLength(password) &&
                hasDigit(password) &&
                hasMixedCaseLetters(password) &&
                containsSpecialCharacter(password);
    }
    public static void main(String[] args) {
        System.out.println("Hello World");
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

    public static String generateRandomValidPassword() {
        /*
        Setting up the function by building the space of characters that
        shall be used to generate the password.
         */
        String upperChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numbers = "1234567890";
        String specialChars = "!@#$%&?";
        String symbols = upperChars + upperChars.toLowerCase() + numbers + specialChars;
        int passwordLength = 8;
        Random random = new SecureRandom();

        /*
        Generating the valid password.
         */
        StringBuilder generatedPassword = new StringBuilder();
        while (!isValid(generatedPassword.toString())) {
            generatedPassword = new StringBuilder();
            for (int i = 0; i < passwordLength; i++) {
                char c = symbols.toCharArray()[random.nextInt(symbols.length())];

                generatedPassword.append(c);
            }
        }

        return generatedPassword.toString();
    }
}
