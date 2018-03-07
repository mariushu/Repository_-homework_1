package pl.stqa.ptf.addressbook.tests;

import org.testng.annotations.Test;
import pl.stqa.ptf.addressbook.model.GroupData;

public class GroupModificationTest extends TestBase{

  @Test
  public void testGroupModification() {
    app.getNavigationHelper().goToGroupPage();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().initGroupModification();
    app.getGroupHelper().fillGroupForm(new GroupData("test01", "test02", "test03"));
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returnGroupPage();

  }



}
