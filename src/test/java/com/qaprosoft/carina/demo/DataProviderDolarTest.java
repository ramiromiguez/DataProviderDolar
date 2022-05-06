package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.dataprovider.annotations.XlsDataSourceParameters;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.gui.pages.HomePageDolar;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DataProviderDolarTest implements IAbstractTest {
    @Test(dataProvider = "DataProvider")
    @XlsDataSourceParameters(path = "xls/randomDates.xlsx", sheet = "Sheet1", dsUid = "date", dsArgs = "date, average")
    public void testSumOperation(String date, String average) throws ParseException {
        StringBuilder formatDate = new StringBuilder(date);
        int i = 0;
        for(i=0;i<formatDate.length();i++){
            if(formatDate.charAt(i) == '/'){
                formatDate.setCharAt(i, '-');
            }
        }
        String dateConverted = DateConvert(String.valueOf(formatDate));
        System.out.println(dateConverted);
    }

    // xls->4/20/2018 -> 20/04/2018
    public String DateConvert(String date) throws ParseException {
        SimpleDateFormat in = new SimpleDateFormat("MM-dd-yyyy");
        Date inDate = in.parse(date); // 05-19-1990
        SimpleDateFormat out = new SimpleDateFormat("dd-MM-yyyy");
        String newDate = out.format(inDate);
        return newDate;
    }

    @Test
    public void testDollar(){
        HomePageDolar homePage = new HomePageDolar(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        homePage.changeDateFrom();
        homePage.clickViewDates();
    }
}
