package seedu.task.storage;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import seedu.task.commons.exceptions.IllegalValueException;
import seedu.task.model.task.Description;
import seedu.task.model.task.StartDate;
import seedu.task.model.task.Title;
import seedu.task.model.task.Task;
import seedu.task.model.task.EndDate;
import seedu.task.model.task.ReadOnlyTask;
import seedu.task.model.tag.Tag;
import seedu.task.model.tag.UniqueTagList;

/**
 * JAXB-friendly version of the Task.
 */
public class XmlAdaptedTask {

    @XmlElement(required = true)
    private String title;
    @XmlElement(required = true)
    private String description;
    @XmlElement(required = true)
    private String startDate;
    @XmlElement(required = true)
    private String endDate;

    @XmlElement
    private List<XmlAdaptedTag> tagged = new ArrayList<>();

    /**
     * Constructs an XmlAdaptedTask.
     * This is the no-arg constructor that is required by JAXB.
     */
    public XmlAdaptedTask() {}


    /**
     * Converts a given Task into this class for JAXB use.
     *
     * @param source future changes to this will not affect the created XmlAdaptedTask
     */
    public XmlAdaptedTask(ReadOnlyTask source) {
        title = source.getTitle().fullTitle;
        endDate = source.getEndDate().value;
        startDate = source.getStartDate().value;
        description = source.getDescription().value;
        tagged = new ArrayList<>();
        for (Tag tag : source.getTags()) {
            tagged.add(new XmlAdaptedTag(tag));
        }
    }

    /**
     * Converts this jaxb-friendly adapted person object into the model's Task object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted person
     */
    public Task toModelType() throws IllegalValueException {
        final List<Tag> taskTags = new ArrayList<>();
        for (XmlAdaptedTag tag : tagged) {
            taskTags.add(tag.toModelType());
        }
        final Title title = new Title(this.title);
        final EndDate endDate = new EndDate(this.endDate);
        final StartDate startDate = new StartDate(this.startDate);
        final Description description = new Description(this.description);
        final UniqueTagList tags = new UniqueTagList(taskTags);
        return new Task(title, description, startDate,endDate, tags);
    }
}
