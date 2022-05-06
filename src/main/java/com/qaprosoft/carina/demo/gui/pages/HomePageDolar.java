package com.qaprosoft.carina.demo.gui.pages;


import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import org.slf4j.Logger;

public class HomePageDolar extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy (xpath = "//button[normalize-space()='VER DATOS']")
    private ExtendedWebElement viewDates;

    @FindBy (xpath = "//input[@value='06-04-2022']")
    private ExtendedWebElement dateFrom;

    @FindBy (xpath = "(//td[normalize-space()='05-05-2022'])[1]")
    private ExtendedWebElement date;

    public HomePageDolar(WebDriver driver) {
        super(driver);
    }

    public void changeDateFrom(){
        dateFrom.type("20-02-2002");
    }

    public void clickViewDates(){
        viewDates.click();
    }
}
