package seedu.address.testutil;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.task.model.TaskManager;
import seedu.task.model.task.Task;
import seedu.task.model.task.UniqueTaskList;

/**
 *
 */
public class TypicalTestTasks {

    public TestTask alice, benson, carl, daniel, elle, fiona, george, hoon, ida;

    public TypicalTestTasks() {
        try {
            alice = new TaskBuilder().withTitle("Alice Pauline")
                    .withDescription("123, Jurong West Ave 6, #08-111").withStartDate("alice@gmail.com")
                    .withDeadline("85355255")
                    .withTags("friends").build();
            benson = new TaskBuilder().withTitle("Benson Meier").withDescription("311, Clementi Ave 2, #02-25")
                    .withStartDate("johnd@gmail.com").withDeadline("98765432")
                    .withTags("owesMoney", "friends").build();
            carl = new TaskBuilder().withTitle("Carl Kurz").withDeadline("95352563")
                    .withStartDate("heinz@yahoo.com").withDescription("wall street").build();
            daniel = new TaskBuilder().withTitle("Daniel Meier").withDeadline("87652533")
                    .withStartDate("cornelia@google.com").withDescription("10th street").build();
            elle = new TaskBuilder().withTitle("Elle Meyer").withDeadline("9482224")
                    .withStartDate("werner@gmail.com").withDescription("michegan ave").build();
            fiona = new TaskBuilder().withTitle("Fiona Kunz").withDeadline("9482427")
                    .withStartDate("lydia@gmail.com").withDescription("little tokyo").build();
            george = new TaskBuilder().withTitle("George Best").withDeadline("9482442")
                    .withStartDate("anna@google.com").withDescription("4th street").build();

            // Manually added
            hoon = new TaskBuilder().withTitle("Hoon Meier").withDeadline("8482424")
                    .withStartDate("stefan@mail.com").withDescription("little india").build();
            ida = new TaskBuilder().withTitle("Ida Mueller").withDeadline("8482131")
                    .withStartDate("hans@google.com").withDescription("chicago ave").build();
        } catch (IllegalValueException e) {
            e.printStackTrace();
            assert false : "not possible";
        }
    }

    public static void loadTaskManagerWithSampleData(TaskManager ab) {
        for (TestTask task : new TypicalTestTasks().getTypicalTasks()) {
            try {
                ab.addTask(new Task(task));
            } catch (UniqueTaskList.DuplicateTaskException e) {
                assert false : "not possible";
            }
        }
    }

    public TestTask[] getTypicalTasks() {
        return new TestTask[]{alice, benson, carl, daniel, elle, fiona, george};
    }

    public TaskManager getTypicalTaskManager() {
        TaskManager ab = new TaskManager();
        loadTaskManagerWithSampleData(ab);
        return ab;
    }
}
