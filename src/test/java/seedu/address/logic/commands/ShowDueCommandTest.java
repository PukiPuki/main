package seedu.address.logic.commands;

import static seedu.address.testutil.TypicalAddressBook.getTypicalAddressBook;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.Before;

import seedu.address.logic.CommandHistory;
import seedu.address.logic.UndoRedoStack;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;

public class ShowDueCommandTest {
    private Model model;
    private Model expectedModel;
    private LocalDateTime todaysDate;

    @Before
    public void setUp() {
        model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
        expectedModel = new ModelManager(model.getAddressBook(), new UserPrefs());
        todaysDate = LocalDate.now().atStartOfDay();
    }

    /**
     * Returns a {@code ShowDueCommand} with parameters {@code date}.
     */
    private ShowDueCommand prepareCommand(LocalDateTime date) {
        ShowDueCommand showDueCommand = new ShowDueCommand(date);
        showDueCommand.setData(model, new CommandHistory(), new UndoRedoStack());
        return showDueCommand;
    }
}
