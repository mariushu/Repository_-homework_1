package pl.stqa.ptf.addressbook.tests;

import org.testng.annotations.Test;


public class ContactDeletionTest extends TestBase{


    
    @Test
    public void ContactDeletionTest() {
        app.getContactHelper().goToModificationPage();
        app.getContactHelper().initContactModification();
        app.getContactHelper().deleteContact();

        //app.getContactHelper().closeAlert();


    }



}
