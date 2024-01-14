package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Set;

public class ContactModificationTests extends TestBase {
    @BeforeMethod
    public void ensurePrecondition() {
    //переход на нужную страницу, проверка предусловия, если нужно то подготовкасостояния
    //перходим на homePage, если контактов нет создаём новый
        app.goTo().homePage();
        if (app.contact().all().size() == 0) { //не работает множество - контакты есть но записываются в множество
            app.contact().create(new ContactData().withFirstName("testM").withLastName("testM"));
        }
    }

    @Test(enabled = true)
    public void testContactModification () {
        Set<ContactData> before = app.contact().all();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData()
                .withId(modifiedContact.getId()).withFirstName("1401");
        app.contact().modify(20, contact);
        Set<ContactData> after = app.contact().all();
        Assert.assertEquals(after.size(), before.size());

        before.remove(modifiedContact);
        before.add(contact);
        Assert.assertEquals(before, after);
    }
}
