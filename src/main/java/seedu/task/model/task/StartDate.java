package seedu.task.model.task;


import seedu.address.commons.exceptions.IllegalValueException;

/**
 * Represents a Person's phone number in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidStartDate(String)}
 */
public class StartDate {

    public static final String MESSAGE_STARTINGTIME_CONSTRAINTS =
            "Task start date should be of dd/mm/yyyy format";
    public static final String STARTINGTIME_VALIDATION_REGEX = "([0-9]{2})\\([0-9]{2})\\([0-9]{4})";

    public final String value;

    /**
     * Validates given startDate.
     *
     * @throws IllegalValueException if given startDate address string is invalid.
     */
    public StartDate(String startDate) throws IllegalValueException {
        assert startDate != null;
        String trimmedStartDate = startDate.trim();
        if (!isValidStartDate(trimmedStartDate)) {
            throw new IllegalValueException(MESSAGE_STARTINGTIME_CONSTRAINTS);
        }
        this.value = trimmedStartDate;
    }

    /**
     * Returns if a given string is a valid person startDate.
     */
    public static boolean isValidStartDate(String test) {
        return test.matches(STARTINGTIME_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof StartDate // instanceof handles nulls
                && this.value.equals(((StartDate) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
