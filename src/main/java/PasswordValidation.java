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
}
