package pl.stqa.ptf.addressbook.tests;

import org.testng.annotations.Test;
import pl.stqa.ptf.addressbook.model.GroupData;
import pl.stqa.ptf.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTest  extends TestBase {

  @Test
  public void testGroupCreation() {
    app.goTo().GroupPage();
    Groups before = app.group().all();
    GroupData group = new GroupData().withName("test2");
    app.group().create(group);

    Groups after = app.group().all();

    assertThat(after.size(), equalTo(before.size() + 1));

    assertThat(after, equalTo(
            before.withAdded(group.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt()))));
    }

  }