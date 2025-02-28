package com.wikia.webdriver.pageobjectsfactory.pageobject.adsbase;

import com.wikia.webdriver.common.contentpatterns.AdsContent;
import com.wikia.webdriver.common.core.Assertion;
import com.wikia.webdriver.common.logging.Log;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdsPrebidObject extends AdsBaseObject {

  private static final String CUSTOM_ADAPTER_CREATIVE = "Wikia Creative";
  private static final String NEXT_PV = "a[href='/wiki/SyntheticTests/RTB/Prebid.js/Wikia/2']";
  private static final String NEXT_TITLE = "SyntheticTests/RTB/Prebid.js/Wikia/2";

  public AdsPrebidObject(WebDriver driver, String testedPage) {
    super(testedPage);
  }

  public void verifyKeyValues(String slotName, String adapter, String size, String price) {

    WebElement gptNode = driver.findElement(By.cssSelector(slotName));

    try {
      JSONObject keyValues = new JSONObject(gptNode.getAttribute("data-gpt-slot-params"));

      assertKeyValue(keyValues, "hb_bidder", adapter, "Bidder passed in slot key-values");
      assertKeyValue(keyValues, "hb_size", size, "Size passed in slot key-values");
      assertKeyValue(keyValues, "hb_pb", price, "Price passed in slot key-values");
    } catch (JSONException exception) {
      Log.log("Prebid.js key-values", "Prebid.js key-values not found in slot div", false);
      Log.log("Prebid.js key-values", exception, false);
    }
  }

  public void verifyPrebidCreative(String slotName, boolean rendered) {
    WebElement iframe = driver.findElement(By.cssSelector(slotName + " " + "iframe"));
    driver.switchTo().frame(iframe);

    WebElement body = driver.findElement(By.cssSelector("body"));
    if (rendered) {
      Assertion.assertStringContains(body.getText(), CUSTOM_ADAPTER_CREATIVE);
    } else {
      Assertion.assertStringNotContains(body.getText(), CUSTOM_ADAPTER_CREATIVE);
    }

    driver.switchTo().defaultContent();
  }

  public void goToNextPageView() {
    WebElement nextArticleLink = driver.findElement(By.cssSelector(NEXT_PV));
    wait.forElementVisible(nextArticleLink);
    nextArticleLink.click();
    waitTitleChangesTo(NEXT_TITLE);
  }

  private void assertKeyValue(JSONObject keyValues, String key, String value, String comment)
      throws JSONException {
    if (value == null) {
      Assertion.assertFalse(keyValues.has(key), comment);
    } else {
      Assertion.assertEquals(keyValues.getString(key), value, comment);
    }
  }
}
