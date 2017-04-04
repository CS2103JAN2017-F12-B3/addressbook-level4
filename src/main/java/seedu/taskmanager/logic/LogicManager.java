package seedu.taskmanager.logic;

import java.util.logging.Logger;

import javafx.collections.ObservableList;
import seedu.taskmanager.commons.core.ComponentManager;
import seedu.taskmanager.commons.core.LogsCenter;
import seedu.taskmanager.logic.commands.Command;
import seedu.taskmanager.logic.commands.CommandResult;
import seedu.taskmanager.logic.commands.exceptions.CommandException;
import seedu.taskmanager.logic.parser.Parser;
import seedu.taskmanager.model.Model;
import seedu.taskmanager.model.task.ReadOnlyTask;
import seedu.taskmanager.storage.Storage;

/**
 * The main LogicManager of the app.
 */
public class LogicManager extends ComponentManager implements Logic {

    private final Logger logger = LogsCenter.getLogger(LogicManager.class);

    // @@author A0140032E
    //Singleton pattern
    private static LogicManager instance = null;
    private Model model;
    private Parser parser;
    private Storage storage;
    private String commandText;

    // @@author A0140032E
    //Singleton pattern
    private LogicManager() {
    }

    public static LogicManager getInstance() {
        if (instance == null) {
            instance = new LogicManager();
        }
        return instance;
    }

    public void init(Model model, Storage storage) {
        this.model = model;
        this.storage = storage;
        this.parser = new Parser();
    }

    @Override
    public CommandResult execute(String commandText) throws CommandException {
        logger.info("----------------[USER COMMAND][" + commandText + "]");
        this.commandText = commandText;
        Command command = parser.parseCommand(commandText);
        command.setData(model);
        command.setStorage(storage);
        return command.execute();
    }
    // @@author

    @Override
    public ObservableList<ReadOnlyTask> getFilteredTaskList() {
        return model.getFilteredTaskList();
    }

    // @@author A0140032E
    public String getCommandText() {
        return this.commandText;
    }
    // @@author
}
