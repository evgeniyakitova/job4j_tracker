package ru.job4j.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class NotifyAccountTest {

    @Test
    public void whenIsNoDuplicate() {
        List<Account> accounts = Arrays.asList(
                new Account("123", "Petr Arsentev", "eDer3432f"),
                new Account("142", "Petr Arsentev", "000001")
        );
        HashSet<Account> expect = new HashSet<>(
                Arrays.asList(
                        new Account("123", "Petr Arsentev", "eDer3432f"),
                        new Account("142", "Petr Arsentev", "000001")
                )
        );
        assertThat(NotifyAccount.sent(accounts), is(expect));
    }

    @Test
    public void whenOneDuplicateIsDeleted() {
        List<Account> accounts = Arrays.asList(
                new Account("150", "Katya", "1d2d3d"),
                new Account("150", "Katya", "1d2d3d"),
                new Account("155", "Katya", "1f2f3f")
        );
        HashSet<Account> expect = new HashSet<>(
                Arrays.asList(
                        new Account("150", "Katya", "1d2d3d"),
                        new Account("155", "Katya", "1f2f3f")
                )
        );
        assertThat(NotifyAccount.sent(accounts), is(expect));
    }
}