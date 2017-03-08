package seedu.address.model.person;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import seedu.task.model.task.Deadline;

public class DeadlineTest {

    @Test
    public void isValidDeadline() {
        /// blank date
        assertFalse(Deadline.isValidDeadline("")); // empty string
        assertFalse(Deadline.isValidDeadline(" ")); // spaces only

        // missing parts
        assertFalse(Deadline.isValidDeadline("/09/2017")); // missing day part
        assertFalse(Deadline.isValidDeadline("01092017")); // missing '/' symbol
        assertFalse(Deadline.isValidDeadline("01/")); // missing month and year

        // invalid parts
        assertFalse(Deadline.isValidDeadline("aa/09/2017")); // invalid day part
        assertFalse(Deadline.isValidDeadline("01/aa/2017")); // invalid month
//        assertFalse(Deadline.isValidDeadline("peter jack@webmail.com")); // spaces in local part
//        assertFalse(Deadline.isValidDeadline("peterjack@web mail.com")); // spaces in domain name
//        assertFalse(Deadline.isValidDeadline("peterjack@@webmail.com")); // double '@' symbol
//        assertFalse(Deadline.isValidDeadline("peter@jack@webmail.com")); // '@' symbol in local part
//        assertFalse(Deadline.isValidDeadline("peterjack@webmail@com")); // '@' symbol in domain name

        // valid date
        assertTrue(Deadline.isValidDeadline("01/09/2017"));
//        assertTrue(Deadline.isValidDeadline("a@b"));  // minimal
//        assertTrue(Deadline.isValidDeadline("test@localhost"));   // alphabets only
//        assertTrue(Deadline.isValidDeadline("123@145"));  // numeric local part and domain name
//        assertTrue(Deadline.isValidDeadline("a1@sg50.org"));  // mixture of alphanumeric and dot characters
//        assertTrue(Deadline.isValidDeadline("_user_@_do_main_.com_"));    // underscores
//        assertTrue(Deadline.isValidDeadline("peter_jack@a_very_long_domain_AVLD.com"));   // long domain name
//        assertTrue(Deadline.isValidDeadline("if.you.dream.it_you.can.do.it@youth_email.com"));    // long local part
    }
}
