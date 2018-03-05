package pl.stqa.ptf.addressbook.tests;

import org.testng.annotations.Test;
import pl.stqa.ptf.addressbook.model.GroupData;

public class GroupCreationTest  extends TestBase{

  @Test
  public void testGroupCreation() {
    app.goToGroupPage();
    app.initGroupCreation();
    app.fillGroupForm(new GroupData("test1", "test2", "test3"));
    app.submitGroupCreation();
    app.returnGroupPage();
  }

}