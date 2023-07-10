package testcases;

import base.TestBase;
import org.testng.annotations.Test;

public class HomePageLegalFooterTest extends TestBase {
    @Test(groups={"smoke"})
    public void legalNoticeFooter() {
        String title;
        clickElement(driver,"legalNoticeFooter_XPATH");
        title=driver.getTitle();
        verifyEquals("legalNoticeFooter",title,"Legal Notice");

    }
    @Test(groups={"smoke"})
    public void termsOfUseFooter() {
        String title;
        clickElement(driver,"termsOfUseFooter_CSS");
        title=driver.getTitle();
        verifyEquals("termsOfUseFooter",title,"Terms of Use");

    }
    @Test(groups={"smoke"})
    public void privacyPolicyFooter() {
        String title;

        clickElement(driver,"privacyPolicyFooter_CSS");
        title=driver.getTitle();
        verifyEquals("privacyPolicyFooter",title,"Privacy Policy");

    }
    @Test(groups={"smoke"})
    public void accessibilityFooter() {
        String title;

        clickElement(driver,"accessibilityFooter_XPATH");
        title=driver.getTitle();
        verifyEquals("accessibilityFooter",title,"Accessibility");


    }
    @Test(groups={"smoke"})
    public void cookiePolicyFooter() {
        String title;
        clickElement(driver,"cookiePolicyFooter_CSS");
        title=driver.getTitle();
        verifyEquals("cookiePolicyFooter",title,"Cookie Policy");
        driver.navigate().back();

    }

   /* @Test(groups={"smoke"})
    public void cookieSettingsFooter() {
        String title;
        clickElement(driver,"cookieSettingsFooter_CSS");
        title=driver.getTitle();
        verifyEquals("cookieSettingsFooter",title,"Cookie Settings");
        driver.switchTo().alert().accept();
    }*/


}
