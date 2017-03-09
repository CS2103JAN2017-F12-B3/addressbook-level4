package seedu.task.model.util;

import seedu.task.commons.exceptions.IllegalValueException;
import seedu.task.model.ReadOnlyTaskManager;
import seedu.task.model.TaskManager;
import seedu.task.model.tag.UniqueTagList;
import seedu.task.model.task.Description;
import seedu.task.model.task.StartDate;
import seedu.task.model.task.Task;
import seedu.task.model.task.Title;
import seedu.task.model.task.UniqueTaskList.DuplicateTaskException;
import seedu.task.model.task.EndDate;

public class SampleDataUtil {
    public static Task[] getSampleTasks() {
        try {
            return new Task[] {
                new Task(new Title("Read Harry Potter"), new Description("Chapter 5 - 7"), new StartDate("15/03/12"),
                    new EndDate("17/03/12"),
                    new UniqueTagList("friends")),
                new Task(new Title("Bernice Yu"), new Description("Blk 30 Lorong 3 Serangoon Gardens, #07-18"), new StartDate("berniceyu@gmail.com"),
                    new EndDate("99272758"),
                    new UniqueTagList("colleagues", "friends")),
                new Task(new Title("Charlotte Oliveiro"), new Description("Blk 11 Ang Mo Kio Street 74, #11-04"), new StartDate("charlotte@yahoo.com"),
                    new EndDate("93210283"),
                    new UniqueTagList("neighbours")),
                new Task(new Title("David Li"), new Description("Blk 436 Serangoon Gardens Street 26, #16-43"), new StartDate("lidavid@google.com"),
                    new EndDate("91031282"),
                    new UniqueTagList("family")),
                new Task(new Title("Irfan Ibrahim"), new Description("Blk 47 Tampines Street 20, #17-35"), new StartDate("irfan@outlook.com"),
                    new EndDate("92492021"),
                    new UniqueTagList("classmates")),
                new Task(new Title("Roy Balakrishnan"), new Description("Blk 45 Aljunied Street 85, #11-31"), new StartDate("royb@gmail.com"),
                    new EndDate("92624417"),
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
