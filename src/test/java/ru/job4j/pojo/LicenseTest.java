package ru.job4j.pojo;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class LicenseTest {

    @Test
    public void whenEqNameThenTrue() {
        License first = new License();
        first.setCode("audio");
        License second = new License();
        second.setCode("audio");
        assertThat(first, is(second));
    }

    @Test
    public void whenEqOwnerThenFalse() {
        License first = new License();
        first.setOwner("Elena");
        License second = new License();
        second.setOwner("Mariya");
        assertThat(first, not(second));
    }
}