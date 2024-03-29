package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTests extends TestBase {
    @Test
    public void testGroupCreation() {
        app.goTo().groupPage();
        Groups before = app.group().all();
        GroupData group = new GroupData().withName("test2");
        app.group().create(group);
        assertThat(app.group().count(), equalTo(before.size() +1));
        Groups after = app.group().all();
        //Assert.assertEquals(after.size(), before.size() + 1);//сравниваем размеры списков полученных методом getGroupList()

        assertThat(after, equalTo(
                before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    }
    @Test
    public void testBadGroupCreation() {
        app.goTo().groupPage();
        Groups before = app.group().all();
        GroupData group = new GroupData().withName("test'");
        app.group().create(group);
        assertThat(app.group().count(), equalTo(before.size()));

        Groups after = app.group().all();
        //Assert.assertEquals(after.size(), before.size() + 1);//сравниваем размеры списков полученных методом getGroupList()
        assertThat(after, equalTo(before));
    }
}
//int max1 = after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId();
//список превращаем в поток, по потоку пробегается функция сравниватель и находит максимальный элемент,
//сраниваются объекту ГрупДейта по ID, на выходе группа с макс ID - берём этот ID