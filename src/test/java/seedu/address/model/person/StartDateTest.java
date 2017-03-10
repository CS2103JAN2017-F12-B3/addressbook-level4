package seedu.address.model.person;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import seedu.task.model.task.StartDate;

public class StartDateTest {

    @Test
    public void isValidStartDate() {
        // blank date
        assertFalse(StartDate.isValidStartDate("")); // empty string
        assertFalse(StartDate.isValidStartDate(" ")); // spaces only

        // missing parts
        assertFalse(StartDate.isValidStartDate("/09/2017")); // missing day part
        assertFalse(StartDate.isValidStartDate("01092017")); // missing '/' symbol
        assertFalse(StartDate.isValidStartDate("01/")); // missing month and year

        // invalid parts
        assertFalse(StartDate.isValidStartDate("aa/09/2017")); // invalid day part
        assertFalse(StartDate.isValidStartDate("01/aa/2017")); // invalid month
//        assertFalse(StartDate.isValidStartDate("peter jack@webmail.com")); // spaces in local part
//        assertFalse(StartDate.isValidStartDate("peterjack@web mail.com")); // spaces in domain name
//        assertFalse(StartDate.isValidStartDate("peterjack@@webmail.com")); // double '@' symbol
//        assertFalse(StartDate.isValidStartDate("peter@jack@webmail.com")); // '@' symbol in local part
//        assertFalse(StartDate.isValidStartDate("peterjack@webmail@com")); // '@' symbol in domain name

        // valid date
        assertTrue(StartDate.isValidStartDate("01/09/2017"));
//        assertTrue(StartDate.isValidStartDate("a@b"));  // minimal
//        assertTrue(StartDate.isValidStartDate("test@localhost"));   // alphabets only
//        assertTrue(StartDate.isValidStartDate("123@145"));  // numeric local part and domain name
//        assertTrue(StartDate.isValidStartDate("a1@sg50.org"));  // mixture of alphanumeric and dot characters
//        assertTrue(StartDate.isValidStartDate("_user_@_do_main_.com_"));    // underscores
//        assertTrue(StartDate.isValidStartDate("peter_jack@a_very_long_domain_AVLD.com"));   // long domain name
//        assertTrue(StartDate.isValidStartDate("if.you.dream.it_you.can.do.it@youth_email.com"));    // long local part
    }
}
