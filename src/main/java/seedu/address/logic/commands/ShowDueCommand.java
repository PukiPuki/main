package seedu.address.logic.commands;

import java.time.LocalDateTime;

/**
 * Lists all cards in the card book.
 */
public class ShowDueCommand extends Command {
    public static final String COMMAND_WORD = "showdue";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": List all cards due today. ";
    public static final String MESSAGE_SUCCESS = "Listed all cards due today";

    private final LocalDateTime date;

    public ShowDueCommand(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public CommandResult execute(){
        model.showDueCards(this.date);
        return new CommandResult(MESSAGE_SUCCESS);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof ShowDueCommand // instanceof handles nulls
                && date.equals(((ShowDueCommand) other).date));
    }
}
