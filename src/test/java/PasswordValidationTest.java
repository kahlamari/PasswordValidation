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
}
