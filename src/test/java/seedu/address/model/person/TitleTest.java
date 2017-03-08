package seedu.address.model.person;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import seedu.task.model.task.Title;

public class TitleTest {

    @Test
    public void isValidTitle() {
        // invalid title
        assertFalse(Title.isValidTitle("")); // empty string
        assertFalse(Title.isValidTitle(" ")); // spaces only

        // valid title
        assertTrue(Title.isValidTitle("Do homework"));
        assertTrue(Title.isValidTitle("-")); // one character
        assertTrue(Title.isValidTitle("Do lots and lots and lots and lots and lots and lots and lots and lots of homework")); // long title
    }
}
