package seedu.taskmanager.logic.commands;

import seedu.taskmanager.model.TaskManager;

/**
 * Clears the address book.
 */
public class ClearCommand extends Command {

    public static final String COMMAND_WORD = "clear";
    public static final String MESSAGE_SUCCESS = "Address book has been cleared!";


    @Override
    public CommandResult execute() {
        assert model != null;
        model.resetData(new TaskManager());
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
