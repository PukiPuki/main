package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalAddressBook.getTypicalAddressBook;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;

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

    @Test
    public void execute_showDueFilterToday_showsSameList() {
        ShowDueCommand showDueCommand = prepareCommand(todaysDate);
        String expectedMessage = String.format(ShowDueCommand.MESSAGE_SUCCESS, todaysDate.toLocalDate().toString());
        assertCommandSuccess(showDueCommand, model, expectedMessage, expectedModel);
        assert(model.getFilteredCardList().toString()
            .equals(expectedModel.getFilteredCardList().toString()));
    }

    @Test
    public void execute_showDueFilterLastYear_showsEmptyList() {
        LocalDateTime expectedDate = todaysDate.minusYears(1L);
        ShowDueCommand showDueCommand = prepareCommand(expectedDate);
        String expectedMessage = String.format(ShowDueCommand.MESSAGE_SUCCESS, expectedDate.toLocalDate().toString());
        assertCommandSuccess(showDueCommand, model, expectedMessage, expectedModel);
        assert(model.getFilteredCardList().isEmpty());
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
