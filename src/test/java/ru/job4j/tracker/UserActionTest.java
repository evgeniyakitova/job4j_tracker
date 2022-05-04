package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserActionTest {
    @Test
    public void whenTestCreateAction() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        CreateAction action = new CreateAction(out);

        Input input = mock(Input.class);
        String itemName = "New item";
        when(input.askStr(any(String.class))).thenReturn(itemName);

        action.execute(input, tracker);

        String ln = System.lineSeparator();
        Item addedItem = tracker.findById(1);
        assertThat(addedItem.getName(), is(itemName));
        assertThat(out.toString(), is("=== Create a new Item ===="
                + ln + "Добавленная заявка: " + addedItem + ln));

    }

    @Test
    public void whenTestFindByIdAction() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        Item item = new Item("new Item");
        tracker.add(item);
        FindByIdAction action = new FindByIdAction(out);

        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(item.getId());

        action.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Find item by id ====" + ln + item + ln));

    }

    @Test
    public void whenTestFindByIdActionAndItemsDoNotExist() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        FindByIdAction action = new FindByIdAction(out);

        int id = 1;
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(id);

        action.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Find item by id ====" + ln
                + "Заявка с введенным id: " + id + " не найдена." + ln));

    }

    @Test
    public void whenTestFindByNameAction() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        Item firstItem = new Item("First Item");
        Item secondItem = new Item("Second Item");
        tracker.add(firstItem);
        tracker.add(secondItem);
        FindByNameAction action = new FindByNameAction(out);

        Input input = mock(Input.class);
        when(input.askStr(any(String.class))).thenReturn(firstItem.getName());

        action.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Find items by name ====" + ln + firstItem + ln));

    }

    @Test
    public void whenTestFindByNameActionAndItemDoesNotExist() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        Item item = new Item("First Item");
        tracker.add(item);
        FindByNameAction action = new FindByNameAction(out);

        Input input = mock(Input.class);
        String name = "Second item";
        when(input.askStr(any(String.class))).thenReturn(name);

        action.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Find items by name ====" + ln
                + "Заявки с именем: " + name + " не найдены." + ln));

    }

    @Test
    public void whenTestReplaceAction() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        tracker.add(new Item("Item"));
        String newName = "New item name";
        ReplaceAction rep = new ReplaceAction(out);

        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(1);
        when(input.askStr(any(String.class))).thenReturn(newName);

        rep.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Edit item ====" + ln + "Замена прошла успешно" + ln));
        assertThat(tracker.findById(1).getName(), is(newName));
    }

    @Test
    public void whenTestReplaceActionAndItemsDoNotExist() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        ReplaceAction rep = new ReplaceAction(out);

        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(1);
        when(input.askStr(any(String.class))).thenReturn("New name");

        rep.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Edit item ====" + ln + "Ошибка замены заявки." + ln));
    }

    @Test
    public void whenTestDeleteAction() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        Item item = new Item("First Item");
        tracker.add(item);
        DeleteAction action = new DeleteAction(out);

        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(item.getId());

        action.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(tracker.findAll().size(), is(0));
        assertThat(out.toString(), is("=== Delete item ====" + ln
                + "Заявка удалена успешно." + ln));

    }

    @Test
    public void whenTestDeleteActionAndItemsDoNotExist() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        DeleteAction action = new DeleteAction(out);

        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(1);
        action.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Delete item ====" + ln
                + "Ошибка удаления заявки." + ln));

    }
}
