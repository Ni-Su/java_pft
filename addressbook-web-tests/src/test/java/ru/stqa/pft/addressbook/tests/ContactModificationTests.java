package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {
    @Test(enabled = false)
    public void testContactModification () {
        app.goTo().gotoHomePage();
        //int before = app.getGroupHelper().getGroupCount();
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(new ContactData("test_name", "test_surname", null), false);
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToHomePage();
        //int after = app.getGroupHelper().getGroupCount();
        //Assert.assertEquals(after, before);
    }
}
