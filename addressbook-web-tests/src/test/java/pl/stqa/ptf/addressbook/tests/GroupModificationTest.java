package pl.stqa.ptf.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.stqa.ptf.addressbook.model.GroupData;

import java.util.Set;

public class GroupModificationTest extends TestBase{

  @BeforeMethod
  public void esurePreconditions() {
    app.goTo().GroupPage();
    if  (app.group().all().size() == 0) {
      app.group().create(new GroupData().withName("test1"));
    }
  }

  @Test
  public void testGroupModification() {
    Set<GroupData> before = app.group().all();
    GroupData modifiedGroup = before.iterator().next();

    GroupData group = new GroupData().withId(modifiedGroup.getId())
            .withName("test1").withHeader("test2").withFooter("test3");
    app.group().modify(group);
    Set<GroupData> after = app.group().all();
    Assert.assertEquals(after.size(), before.size());


    before.remove(modifiedGroup);
    before.add(group);
    Assert.assertEquals(before, after);
  }



}

