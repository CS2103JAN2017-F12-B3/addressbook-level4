package seedu.task.logic.commands;

import java.util.List;
import java.util.Optional;

import seedu.task.commons.core.Messages;
import seedu.task.commons.util.CollectionUtil;
import seedu.task.logic.commands.exceptions.CommandException;
import seedu.task.model.task.Task;
import seedu.task.model.task.EndDate;
import seedu.task.model.task.Description;
import seedu.task.model.task.Title;
import seedu.task.model.task.StartDate;
import seedu.task.model.task.ReadOnlyTask;
import seedu.task.model.task.UniqueTaskList;
import seedu.task.model.tag.UniqueTagList;

/**
 * Edits the details of an existing task in the task book.
 */
public class EditCommand extends Command {

    public static final String COMMAND_WORD = "edit";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Edits the details of the task identified "
            + "by the index number used in the last task listing. "
            + "Existing values will be overwritten by the input values.\n"
            + "Parameters: INDEX (must be a positive integer) [TASK] [s/STARTING_DATE] [f/FINISHING_DATE] [#TAG]...\n"
            + "Example: " + COMMAND_WORD + " 1 f/Wednesday";

    public static final String MESSAGE_EDIT_TASK_SUCCESS = "Edited Task: %1$s";
    public static final String MESSAGE_NOT_EDITED = "At least one field to edit must be provided.";
    public static final String MESSAGE_DUPLICATE_TASK = "This task already exists in the task manager.";

    private final int filteredTaskListIndex;
    private final EditTaskDescriptor editTaskDescriptor;

    /**
     * @param filteredTaskListIndex the index of the task in the filtered task list to edit
     * @param editTaskDescriptor details to edit the task with
     */
    public EditCommand(int filteredTaskListIndex, EditTaskDescriptor editTaskDescriptor) {
        assert filteredTaskListIndex > 0;
        assert editTaskDescriptor != null;

        // converts filteredTaskListIndex from one-based to zero-based.
        this.filteredTaskListIndex = filteredTaskListIndex - 1;

        this.editTaskDescriptor = new EditTaskDescriptor(editTaskDescriptor);
    }

    @Override
    public CommandResult execute() throws CommandException {
        List<ReadOnlyTask> lastShownList = model.getFilteredTaskList();

        if (filteredTaskListIndex >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_TASK_DISPLAYED_INDEX);
        }

        ReadOnlyTask taskToEdit = lastShownList.get(filteredTaskListIndex);
        Task editedTask = createEditedTask(taskToEdit, editTaskDescriptor);

        try {
            model.updateTask(filteredTaskListIndex, editedTask);
        } catch (UniqueTaskList.DuplicateTaskException dpe) {
            throw new CommandException(MESSAGE_DUPLICATE_TASK);
        }
        model.updateFilteredListToShowAll();
        return new CommandResult(String.format(MESSAGE_EDIT_TASK_SUCCESS, taskToEdit));
    }

    /**
     * Creates and returns a {@code Task} with the details of {@code taskToEdit}
     * edited with {@code editTaskDescriptor}.
     */
    private static Task createEditedTask(ReadOnlyTask taskToEdit,
                                             EditTaskDescriptor editTaskDescriptor) {
        assert taskToEdit != null;

        Title updatedTitle = editTaskDescriptor.getTitle().orElseGet(taskToEdit::getTitle);
        Description description = editTaskDescriptor.getDescription().orElseGet(taskToEdit::getDescription);
        StartDate startDate = editTaskDescriptor.getStartDate().orElseGet(taskToEdit::getStartDate);
        EndDate endDate = editTaskDescriptor.getEndDate().orElseGet(taskToEdit::getEndDate);
        UniqueTagList updatedTags = editTaskDescriptor.getTags().orElseGet(taskToEdit::getTags);

        return new Task(updatedTitle, description, startDate, endDate, updatedTags);
    }

    /**
     * Stores the details to edit the task with. Each non-empty field value will replace the
     * corresponding field value of the task.
     */
    public static class EditTaskDescriptor {
        private Optional<Title> title = Optional.empty();
        private Optional<Description> description = Optional.empty();
        private Optional<StartDate> startDate = Optional.empty();
        private Optional<EndDate> endDate = Optional.empty();
        private Optional<UniqueTagList> tags = Optional.empty();

        public EditTaskDescriptor() {}

        public EditTaskDescriptor(EditTaskDescriptor toCopy) {
            this.title = toCopy.getTitle();
            this.startDate = toCopy.getStartDate();
            this.endDate = toCopy.getEndDate();
            this.tags = toCopy.getTags();
        }

        /**
         * Returns true if at least one field is edited.
         */
        public boolean isAnyFieldEdited() {
            return CollectionUtil.isAnyPresent(this.title, this.startDate, this.endDate, this.tags);
        }

        public void setTitle(Optional<Title> title) {
            assert title != null;
            this.title = title;
        }

        public Optional<Title> getTitle() {
            return title;
        }
        
        public void setDescription(Optional<Description> description) {
        	assert description != null;
        	this.description = description;
        }
        
        public Optional<Description> getDescription() {
        	return description;
        }

        public void setStartDate(Optional<StartDate> startDate) {
            assert startDate != null;
            this.startDate = startDate;
        }

        public Optional<StartDate> getStartDate() {
            return startDate;
        }

        public void setEndDate(Optional<EndDate> endDate) {
            assert endDate != null;
            this.endDate = endDate;
        }

        public Optional<EndDate> getEndDate() {
            return endDate;
        }

        public void setTags(Optional<UniqueTagList> tags) {
            assert tags != null;
            this.tags = tags;
        }

        public Optional<UniqueTagList> getTags() {
            return tags;
        }
    }
}
