package guitests;

//import static org.junit.Assert.assertTrue;
//
//import org.junit.Test;

import seedu.taskmanager.model.TaskManager;
//import seedu.taskmanager.model.task.Task;
//import seedu.taskmanager.model.util.SampleDataUtil;
import seedu.taskmanager.testutil.TestUtil;

public class SampleDataTest extends TaskManagerGuiTest {
    @Override
    protected TaskManager getInitialData() {
        // return null to force test app to load data from file only
        return null;
    }

    @Override
    protected String getDataFileLocation() {
        // return a non-existent file location to force test app to load sample data
        return TestUtil.getFilePathInSandboxFolder("SomeFileThatDoesNotExist1234567890.xml");
    }

}
