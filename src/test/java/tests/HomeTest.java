package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;

public class HomeTest extends BaseTest {

    @Test
    public void verifyHomePage() {

        System.out.println("Current Thread : " + Thread.currentThread().getId());

        Assert.assertTrue(true);
    }
}