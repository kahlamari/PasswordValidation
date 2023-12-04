import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordValidationTest {
    @Test
    public void hasMinimumLengthTest_when3Chars_thenFalse() {
        // GIVEN
        String input = "pas";

        // WHEN
        boolean actual = PasswordValidation.hasMinimumLength(input);

        // THEN
        assertFalse(actual);
    }

    @Test
    public void hasMinimumLengthTest_when8Chars_thenTrue() {
        // GIVEN
        String input = "password";

        // WHEN
        boolean actual = PasswordValidation.hasMinimumLength(input);

        // THEN
        assertTrue(actual);
    }

    @Test
    public void hasMinimumLengthTest_whenEmpty_thenFalse() {
        // GIVEN
        String input = "";

        // WHEN
        boolean actual = PasswordValidation.hasMinimumLength(input);

        // THEN
        assertFalse(actual);
    }

    @Test
    public void hasMinimumLengthTest_whenNull_thenFalse() {
        // GIVEN
        String input = null;

        // WHEN
        boolean actual = PasswordValidation.hasMinimumLength(input);

        // THEN
        assertFalse(actual);
    }

    @Test
    public void hasDigitTest_whenNoDigits_thenFalse() {
        // GIVEN
        String input = "pass";

        // WHEN
        boolean actual = PasswordValidation.hasDigit(input);

        // THEN
        assertFalse(actual);
    }

    @Test
    public void hasDigitTest_whenContains1_thenTrue() {
        // GIVEN
        String input = "p4ss";

        // WHEN
        boolean actual = PasswordValidation.hasDigit(input);

        // THEN
        assertTrue(actual);
    }

    @Test
    public void hasMixedCaseLettersTest_whenPASS_thenFalse() {
        // GIVEN
        String input = "PASS";

        // WHEN
        boolean actual = PasswordValidation.hasMixedCaseLetters(input);

        // THEN
        assertFalse(actual);
    }

    @Test
    public void hasMixedCaseLettersTest_whenpass_thenFalse() {
        // GIVEN
        String input = "pass";

        // WHEN
        boolean actual = PasswordValidation.hasMixedCaseLetters(input);

        // THEN
        assertFalse(actual);
    }

    @Test
    public void hasMixedCaseLettersTest_whenPaSs_thenTrue() {
        // GIVEN
        String input = "PaSs";

        // WHEN
        boolean actual = PasswordValidation.hasMixedCaseLetters(input);

        // THEN
        assertTrue(actual);
    }

    @Test
    public void hasMixedCaseLettersTest_whenOnlyDigits_thenFalse() {
        // GIVEN
        String input = "12345678";

        // WHEN
        boolean actual = PasswordValidation.hasMixedCaseLetters(input);

        // THEN
        assertFalse(actual);
    }

    @Test
    public void isNotCommonPasswordTest_when12345678_thenFalse() {
        // GIVEN
        String input = "12345678";

        // WHEN
        boolean actual = PasswordValidation.isNotCommonPassword(input);

        // THEN
        assertFalse(actual);
    }

    @Test
    public void isNotCommonPasswordTest_whenHawef9305_thenTrue() {
        // GIVEN
        String input = "Hawef9305";

        // WHEN
        boolean actual = PasswordValidation.isNotCommonPassword(input);

        // THEN
        assertTrue(actual);
    }

    @Test
    public void containsSpecialCharacterTest_whenContainsSpecialChar_thenTrue() {
        // GIVEN
        String input = "Haw@ef9305";

        // WHEN
        boolean actual = PasswordValidation.containsSpecialCharacter(input);

        // THEN
        assertTrue(actual);
    }

    @Test
    public void containsSpecialCharacterTest_whenPassword_thenFalse() {
        // GIVEN
        String input = "Password";

        // WHEN
        boolean actual = PasswordValidation.containsSpecialCharacter(input);

        // THEN
        assertFalse(actual);
    }
}
