package ru.job4j.tracker;

import java.util.Arrays;
import java.util.List;

public class StartUI {
    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    public void init(Input input, Tracker tracker, List<UserAction> actions) {
        boolean run = true;
        while (run) {
            showMenu(actions);
            int select = input.askInt("Select: ");
            if (select < 0 || select >= actions.size()) {
                out.println("Wrong input, you can select: 0 .. " + (actions.size() - 1));
                continue;
            }
            UserAction action = actions.get(select);
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(List<UserAction> actions) {
        out.println("Menu:");
        for (UserAction action : actions) {
            out.println(actions.indexOf(action) + ". " + action.name());
        }
    }

    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
        List<UserAction> actions = Arrays.asList(new CreateAction(output), new ShowAction(output),
                new ReplaceAction(output), new DeleteAction(output),
                new FindByIdAction(output), new FindByNameAction(output),
                new ExitAction());
        new StartUI(output).init(input, tracker, actions);
    }
}
