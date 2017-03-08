package seedu.address.testutil;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.task.model.tag.Tag;
import seedu.task.model.tag.UniqueTagList;
import seedu.task.model.task.Deadline;
import seedu.task.model.task.Description;
import seedu.task.model.task.StartDate;
import seedu.task.model.task.Title;

/**
 *
 */
public class TaskBuilder {

    private TestTask task;

    public TaskBuilder() {
        this.task = new TestTask();
    }

    /**
     * Initializes the TaskBuilder with the data of {@code taskToCopy}.
     */
    public TaskBuilder(TestTask taskToCopy) {
        this.task = new TestTask(taskToCopy);
    }

    public TaskBuilder withTitle(String title) throws IllegalValueException {
        this.task.setTitle(new Title(title));
        return this;
    }

    public TaskBuilder withTags(String ... tags) throws IllegalValueException {
        task.setTags(new UniqueTagList());
        for (String tag: tags) {
            task.getTags().add(new Tag(tag));
        }
        return this;
    }

    public TaskBuilder withDescription(String address) throws IllegalValueException {
        this.task.setDescription(new Description(address));
        return this;
    }

    public TaskBuilder withDeadline(String phone) throws IllegalValueException {
        this.task.setDeadline(new Deadline(phone));
        return this;
    }

    public TaskBuilder withStartDate(String email) throws IllegalValueException {
        this.task.setStartDate(new StartDate(email));
        return this;
    }

    public TestTask build() {
        return this.task;
    }

}
