package pl.stqa.ptf.addressbook.tests;

import org.testng.annotations.Test;
import pl.stqa.ptf.addressbook.model.GroupData;

public class GroupCreationTest  extends TestBase{

  @Test
  public void testGroupCreation() {
    app.getNavigationHelper().goToGroupPage();
    app.getGroupHelper().initGroupCreation();
    app.getGroupHelper().fillGroupForm(new GroupData("test1", null, null));
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnGroupPage();
  }

}