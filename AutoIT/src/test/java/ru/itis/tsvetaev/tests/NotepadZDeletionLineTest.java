package ru.itis.tsvetaev.tests;

import org.junit.Assert;
import org.junit.Test;
import ru.itis.tsvetaev.basic.NotepadTestBase;

public class NotepadZDeletionLineTest extends NotepadTestBase {

    @Test
    public void deleteLineTest() {
        int before = applicationManager.getReaderHelper().count();
        int index = (int) Math.floor(Math.random() * before);
        System.out.println(index);
        applicationManager.getWriterHelper().delete(index);
        Assert.assertEquals(before - 1, applicationManager.getReaderHelper().count());
    }
}
