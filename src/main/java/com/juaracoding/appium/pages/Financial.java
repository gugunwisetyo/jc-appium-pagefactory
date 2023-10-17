package com.juaracoding.appium.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class Financial {
    public AndroidDriver<MobileElement> driver;

    public Financial(AndroidDriver<MobileElement> driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.chad.financialrecord:id/fabMenu")
    private MobileElement addData;
    @AndroidFindBy(id = "com.chad.financialrecord:id/btnIncome")
    private MobileElement incomeBtn;
    @AndroidFindBy(id = "com.chad.financialrecord:id/tvDate")
    private MobileElement addDate;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"14 Oktober 2023\"]")
    private MobileElement selectDate;
    @AndroidFindBy(id = "android:id/button1")
    private MobileElement okBtn;
    @AndroidFindBy(id = "com.chad.financialrecord:id/spCategory")
    private MobileElement addCategory;
    @AndroidFindBy(xpath = "//android.widget.ListView/android.widget.LinearLayout[12]/android.widget.LinearLayout/android.widget.TextView")
    private MobileElement selectCategory;
    @AndroidFindBy(id = "com.chad.financialrecord:id/etAmount")
    private MobileElement sum;
    @AndroidFindBy(id = "com.chad.financialrecord:id/etNote")
    private MobileElement note;
    @AndroidFindBy(id = "com.chad.financialrecord:id/btSave")
    private MobileElement save;
    @AndroidFindBy(xpath = "//android.widget.ExpandableListView/android.widget.LinearLayout[1]//android.widget.TextView[contains(@text, 'Bonus')]")
    private MobileElement textNoteincome;
    @AndroidFindBy(xpath = "//android.widget.ExpandableListView/android.widget.LinearLayout[1]//android.widget.TextView[contains(@text, 'Pizza Hut')]")
    private MobileElement textNoteOutcome;


    public void add(){
        addData.click();
    }

    public void income(){
        incomeBtn.click();
        addDate.click();
        selectDate.click();
        okBtn.click();
        addCategory.click();
        selectCategory.click();
        sum.sendKeys("1000000");
        note.sendKeys("Bonus");
        save.click();
    }

    public void outcome(){
        sum.sendKeys("200000");
        note.sendKeys("Pizza Hut");
        save.click();
    }

    public String getTextNoteIncome(){
        return textNoteincome.getText();
    }
    public String getTextNoteOutcome(){
        return textNoteOutcome.getText();
    }

}
