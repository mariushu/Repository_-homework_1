package pl.stqa.ptf.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.stqa.ptf.addressbook.model.GroupData;

public class GroupModificationTest extends TestBase{

  @Test
  public void testGroupModification() {
    app.getNavigationHelper().goToGroupPage();

    int before = app.getGroupHelper().getGroupCount();
    if  (! app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().createGroup(new GroupData("test1", null, null));
    }
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().initGroupModification();
    app.getGroupHelper().fillGroupForm(new GroupData("test01", "test02", "test03"));
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returnGroupPage();

    int after = app.getGroupHelper().getGroupCount();
    Assert.assertEquals(after, before);
  }



}
