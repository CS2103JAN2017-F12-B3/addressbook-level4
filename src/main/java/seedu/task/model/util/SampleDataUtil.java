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
                new Task(new Title("title"), new Description("description"), new StartDate("01/11/2011"),
                    new EndDate("01/12/2011"),
                    new UniqueTagList("tags")),
                new Task(new Title("Visit Bernice Yu"), new Description("Blk 30 Lorong 3 Serangoon Gardens, #07-18"), new StartDate("01/11/2011"),
                    new EndDate("01/11/2011"),
                    new UniqueTagList("colleagues", "friends")),
                new Task(new Title("Visit Charlotte Oliveiro"), new Description("Blk 11 Ang Mo Kio Street 74, #11-04"), new StartDate("05/05/2200"),
                    new EndDate("05/05/2200"),
                    new UniqueTagList("neighbours")),
                new Task(new Title("Call David Li"), new Description("Phone number: 12345678"), new StartDate("09/09/2017"),
                    new EndDate("08/10/2017"),
                    new UniqueTagList("family")),
                new Task(new Title("Fetch package from Irfan Ibrahim"), new Description("Blk 47 Tampines Street 20, #17-35"), new StartDate("09/09/2017"),
                    new EndDate("09/10/2017"),
                    new UniqueTagList("classmates")),
                new Task(new Title("Party with Roy Balakrishnan"), new Description("Blk 45 Aljunied Street 85, #11-31"), new StartDate("08/08/2017"),
                    new EndDate("08/08/2017"),
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
            throw new AssertionError("sample data cannot contain duplicate tasks", e);
        }
    }
}
