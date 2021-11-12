package com.doc.step_definitions;

import com.doc.pages.BasePage;
import com.doc.utilities.ConfigurationReader;
import com.doc.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;


public class TableStepDefinition extends BasePage {

    int numRowsBeforeDel;

    @Given("As a user, I should able to add a user to the table")
    public void as_a_user_I_should_able_to_add_a_user_to_the_table() {
        Driver.get().get(ConfigurationReader.get("url"));
        Driver.waitFor(2);
        addUser.click();
        firstName.sendKeys("John");
        lastName.sendKeys("Edward");
        userName.sendKeys("JohnE");
        password.sendKeys("1234");
        Driver.waitFor(2);
        companyAAA.click();
        Driver.waitFor(2);
        System.out.println("we are in the scenario");
        role.click();
        customer.click();
        Driver.waitFor(1);
        email.sendKeys("john@abc.com");
        Driver.waitFor(1);
        cellPhone.sendKeys("123987654");
        Driver.waitFor(1);
        save.click();
    }

    @When("I should able to validate the user has been added to the table")
    public void i_should_able_to_validate_the_user_has_been_added_to_the_table() {
        List<WebElement> allNames = Driver.get().findElements(By.xpath("//table//tbody//tr/td[1]"));
        Driver.waitFor(2);
        for(WebElement each: allNames){
            System.out.println(each.getText());
            if (each.getText().equals("John")){
                System.out.println("John is here");
                Assert.assertTrue(each.getText().contains("John"));
            }
        }
    }

    @Given("As a user, I should able to delete user User Name: novak")
    public void as_a_user_I_should_able_to_delete_user_User_Name_novak() {
        Driver.get().get(ConfigurationReader.get("url"));
        List<WebElement> allNames = Driver.get().findElements(By.xpath("//table[@class='smart-table table table-striped']//tbody"));
        List<WebElement> rows = Driver.get().findElements(By.xpath("//button[@type='edit']"));

        numRowsBeforeDel = rows.size();
        System.out.println("numRowsBeforeDel = " + numRowsBeforeDel);
        Driver.waitFor(2);
        for(WebElement each: allNames){
            //System.out.println(each.getText());
            for (WebElement eRow: rows){
                System.out.println(eRow.getText());
                if (each.getText().equals("novak")){
                    System.out.println("novak is here");

                    break;
                }
            }
    }
        Driver.waitFor(1);
        deleteNovak.click();
        Driver.waitFor(1);

        okButton.click();
        Driver.waitFor(1);
        }
        @When("I should able to validate user has been deleted")
        public void i_should_able_to_validate_user_has_been_deleted() {
            List<WebElement> rows = Driver.get().findElements(By.xpath("//button[@type='edit']"));
            int numRowsAfterDel = rows.size();
            System.out.println("numRowsAfterDel = " + numRowsAfterDel);

            Assert.assertTrue(numRowsBeforeDel-numRowsAfterDel==1);

    }

}
