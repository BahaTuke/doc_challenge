package com.doc.pages;

import com.doc.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public abstract class BasePage {
    @FindBy(xpath = "//button[@class='btn btn-link pull-right']")
    public WebElement addUser;

    @FindBy(xpath = "//input[@name='FirstName']")
    public WebElement firstName;

    @FindBy(xpath = "//input[@name='LastName']")
    public WebElement lastName;

    @FindBy(xpath = "//input[@name='UserName']")
    public WebElement userName;

    @FindBy(xpath = "//input[@name='Password']")
    public WebElement password;

    @FindBy(xpath = "//input[@name='optionsRadios']")
    public WebElement companyAAA;

    @FindBy(xpath = "//select[@name='RoleId']")
    public WebElement role;

    @FindBy(xpath = "//option[@value='1']")
    public WebElement customer;

    @FindBy(xpath = "//input[@name='Email']")
    public WebElement email;

    @FindBy(xpath = "//input[@name='Mobilephone']")
    public WebElement cellPhone;

    @FindBy(xpath = "//button[@class='btn btn-success']")
    public WebElement save;

    @FindBy(xpath = "")
    public List<WebElement> table;

    @FindBy(xpath = "")
    public List<WebElement> row;


    @FindBy(xpath = "//tbody //td[.='novak']/../td[11]/button[@class='btn btn-link']")
    public WebElement deleteNovak;


    @FindBy(xpath = "//button[.='OK']")
    public WebElement okButton;

    @FindBy(xpath = "//td[.='Novak']")
    public WebElement Novak;

    @FindBy(xpath = "//table[@class='smart-table table table-striped']//tbody/tr")
    public List<WebElement> tableRows2;


    public BasePage() {
        PageFactory.initElements(Driver.get(), this);


    }
}
