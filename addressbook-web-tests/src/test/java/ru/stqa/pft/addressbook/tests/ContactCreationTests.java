package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {
    @Test(enabled = true)
    public void testContactCreation () {
        app.goTo().homePage();//не выносим в БефореМетод
        //Contacts before = app.contact().all();//сейчас 0
        ContactData contact = new ContactData().withFirstName("test2").withLastName("test2");
        app.contact().create(contact);
        //assertThat(app.contact().count(), equalTo(before.size() +1));

        //Contacts after = app.contact().all();
        //assertThat(after, equalTo(
        //        before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));

        //app.getContactHelper().initContactCreation();
        //app.getContactHelper().fillContactForm(new ContactData("test_name", "test surname", "test1"), true);
        //app.getContactHelper().submitContactCreation();
        //app.getContactHelper().returnToHomePage();
    }

}
