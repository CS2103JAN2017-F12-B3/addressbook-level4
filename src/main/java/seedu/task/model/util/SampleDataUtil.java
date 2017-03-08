package seedu.task.model.util;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.task.model.ReadOnlyTaskManager;
import seedu.task.model.TaskManager;
import seedu.task.model.tag.UniqueTagList;
import seedu.task.model.task.Description;
import seedu.task.model.task.StartDate;
import seedu.task.model.task.Task;
import seedu.task.model.task.Title;
import seedu.task.model.task.UniqueTaskList.DuplicateTaskException;
import seedu.task.model.task.Deadline;

public class SampleDataUtil {
    public static Task[] getSampleTasks() {
        try {
            return new Task[] {
                new Task(new Title("Alex Yeoh"), new Deadline("87438807"), new StartDate("alexyeoh@gmail.com"),
                    new Description("Blk 30 Geylang Street 29, #06-40"),
                    new UniqueTagList("friends")),
                new Task(new Title("Bernice Yu"), new Deadline("99272758"), new StartDate("berniceyu@gmail.com"),
                    new Description("Blk 30 Lorong 3 Serangoon Gardens, #07-18"),
                    new UniqueTagList("colleagues", "friends")),
                new Task(new Title("Charlotte Oliveiro"), new Deadline("93210283"), new StartDate("charlotte@yahoo.com"),
                    new Description("Blk 11 Ang Mo Kio Street 74, #11-04"),
                    new UniqueTagList("neighbours")),
                new Task(new Title("David Li"), new Deadline("91031282"), new StartDate("lidavid@google.com"),
                    new Description("Blk 436 Serangoon Gardens Street 26, #16-43"),
                    new UniqueTagList("family")),
                new Task(new Title("Irfan Ibrahim"), new Deadline("92492021"), new StartDate("irfan@outlook.com"),
                    new Description("Blk 47 Tampines Street 20, #17-35"),
                    new UniqueTagList("classmates")),
                new Task(new Title("Roy Balakrishnan"), new Deadline("92624417"), new StartDate("royb@gmail.com"),
                    new Description("Blk 45 Aljunied Street 85, #11-31"),
                    new UniqueTagList("colleagues"))
            };
        } catch (IllegalValueException e) {
            throw new AssertionError("sample data cannot be invalid", e);
        }
    }

    public static ReadOnlyTaskManager getSampleTaskManager() {
        try {
            TaskManager sampleAB = new TaskManager();
            for (Task sampleTask : getSampleTasks()) {
                sampleAB.addTask(sampleTask);
            }
            return sampleAB;
        } catch (DuplicateTaskException e) {
            throw new AssertionError("sample data cannot contain duplicate persons", e);
        }
    }
}
