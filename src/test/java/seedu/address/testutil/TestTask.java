package seedu.address.testutil;

import seedu.task.model.tag.UniqueTagList;
import seedu.task.model.task.Deadline;
import seedu.task.model.task.Description;
import seedu.task.model.task.ReadOnlyTask;
import seedu.task.model.task.StartDate;
import seedu.task.model.task.Title;

/**
 * A mutable task object. For testing only.
 */
public class TestTask implements ReadOnlyTask {

    private Title name;
    private Description address;
    private StartDate email;
    private Deadline phone;
    private UniqueTagList tags;

    public TestTask() {
        tags = new UniqueTagList();
    }

    /**
     * Creates a copy of {@code taskToCopy}.
     */
    public TestTask(TestTask taskToCopy) {
        this.name = taskToCopy.getTitle();
        this.phone = taskToCopy.getDeadline();
        this.email = taskToCopy.getStartDate();
        this.address = taskToCopy.getDescription();
        this.tags = taskToCopy.getTags();
    }

    public void setTitle(Title name) {
        this.name = name;
    }

    public void setDescription(Description address) {
        this.address = address;
    }

    public void setStartDate(StartDate email) {
        this.email = email;
    }

    public void setDeadline(Deadline phone) {
        this.phone = phone;
    }

    public void setTags(UniqueTagList tags) {
        this.tags = tags;
    }

    @Override
    public Title getTitle() {
        return name;
    }

    @Override
    public Deadline getDeadline() {
        return phone;
    }

    @Override
    public StartDate getStartDate() {
        return email;
    }

    @Override
    public Description getDescription() {
        return address;
    }

    @Override
    public UniqueTagList getTags() {
        return tags;
    }

    @Override
    public String toString() {
        return getAsText();
    }

    public String getAddCommand() {
        StringBuilder sb = new StringBuilder();
        sb.append("add " + this.getTitle().fullTitle + " ");
        sb.append("a/" + this.getDescription().value + " ");
        sb.append("p/" + this.getDeadline().value + " ");
        sb.append("e/" + this.getStartDate().value + " ");
        this.getTags().asObservableList().stream().forEach(s -> sb.append("t/" + s.tagName + " "));
        return sb.toString();
    }
}
