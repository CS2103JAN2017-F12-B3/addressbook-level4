package seedu.address.model.task;


import seedu.address.commons.exceptions.IllegalValueException;

/**
 * Represents a Person's phone number in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidStartingTime(String)}
 */
public class StartingTime {

    public static final String MESSAGE_STARTINGTIME_CONSTRAINTS =
            "Person startingTimes should be 2 alphanumeric/period strings separated by '@'";
    public static final String STARTINGTIME_VALIDATION_REGEX = "[\\w\\.]+@[\\w\\.]+";

    public final String value;

    /**
     * Validates given startingTime.
     *
     * @throws IllegalValueException if given startingTime address string is invalid.
     */
    public StartingTime(String startingTime) throws IllegalValueException {
        assert startingTime != null;
        String trimmedStartingTime = startingTime.trim();
        if (!isValidStartingTime(trimmedStartingTime)) {
            throw new IllegalValueException(MESSAGE_STARTINGTIME_CONSTRAINTS);
        }
        this.value = trimmedStartingTime;
    }

    /**
     * Returns if a given string is a valid person startingTime.
     */
    public static boolean isValidStartingTime(String test) {
        return test.matches(STARTINGTIME_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof StartingTime // instanceof handles nulls
                && this.value.equals(((StartingTime) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
