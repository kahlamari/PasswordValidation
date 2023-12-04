public class PasswordValidation {
    public static void main(String[] args) {
        System.out.println("Hello World");
    }

    public static boolean hasMinimumLength(String password) {
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
}
