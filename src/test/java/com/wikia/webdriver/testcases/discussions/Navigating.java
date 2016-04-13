package com.wikia.webdriver.testcases.discussions;

import com.wikia.webdriver.common.contentpatterns.MercuryWikis;
import com.wikia.webdriver.common.contentpatterns.URLsContent;
import com.wikia.webdriver.common.core.Assertion;
import com.wikia.webdriver.common.core.annotations.Execute;
import com.wikia.webdriver.common.core.annotations.InBrowser;
import com.wikia.webdriver.common.core.annotations.RelatedIssue;
import com.wikia.webdriver.common.core.helpers.User;
import com.wikia.webdriver.common.templates.NewTestTemplate;
import com.wikia.webdriver.pageobjectsfactory.pageobject.discussions.PostsListPage;

import org.testng.annotations.Test;

@Test(groups = "discussions")
@Execute(onWikia = MercuryWikis.MEDIAWIKI_119)
public class Navigating extends NewTestTemplate {

  private static final String DESKTOP_RESOLUTION = "1366x768";
  private static final String MOBILE_RESOLUTION = "600x800";

  /**
   * ANONS ON MOBILE SECTION
   */

  @Test(groups = "discussions-anonUserOnMobileCanClickUsername")
  @Execute(asUser = User.ANONYMOUS)
  @InBrowser(browserSize = MOBILE_RESOLUTION)
  public void anonUserOnMobileCanClickUsername() {
    clickUsernameLoadsUserPage();
  }

  /**
   * ANONS ON DESKTOP SECTION
   */

  @Test(groups = "discussions-anonUserOnDesktopCanClickBackToWiki", enabled = false)
  @RelatedIssue(issueID = "XW-1047")
  @Execute(asUser = User.ANONYMOUS)
  @InBrowser(browserSize = DESKTOP_RESOLUTION)
  public void anonUserOnDesktopCanClickBackToWiki() {
    backToWiki();
  }

  @Test(groups = "discussions-anonUserOnDesktopCanClickAvatar", enabled = false)
  @RelatedIssue(issueID = "XW-1047")
  @Execute(asUser = User.ANONYMOUS, onWikia = MercuryWikis.MEDIAWIKI_119)
  @InBrowser(browserSize = DESKTOP_RESOLUTION)
  public void anonUserOnDesktopCanClickAvatar() {
    clickAvatarLoadsUserPage();
  }

  @Test(groups = "discussions-anonUserOnDesktopCanClickUsername")
  @Execute(asUser = User.ANONYMOUS, onWikia = MercuryWikis.MEDIAWIKI_119)
  @InBrowser(browserSize = DESKTOP_RESOLUTION)
  public void anonUserOnDesktopCanClickUsername() {
    clickUsernameLoadsUserPage();
  }

  @Test(groups = "discussions-anonUserOnDesktopCanSeeAppPromotion")
  @Execute(onWikia = "fallout")
  @InBrowser(browserSize = DESKTOP_RESOLUTION)
  public void anonUserOnDesktopCanSeeAppPromotion() {
    discussionsAppPromotionUnitPresentOnPage();
  }

  @Test(groups = "discussions-anonUserOnDesktopCanClickAppleLinkAppPromotion")
  @Execute(onWikia = "fallout")
  @InBrowser(browserSize = DESKTOP_RESOLUTION)
  public void anonUserOnDesktopCanClickAppleLinkAppPromotion() {
    appleLinkRedirectsProperly();
  }

  @Test(groups = "discussions-anonUserOnDesktopCanClickGooglePlayLinkAppPromotion")
  @Execute(onWikia = "fallout")
  @InBrowser(browserSize = DESKTOP_RESOLUTION)
  public void anonUserOnDesktopCanClickGooglePlayLinkAppPromotion() {
    googlePlayLinkRedirectsProperly();
  }

  /**
   * TESTING METHODS SECTION
   */

  public void backToWiki() {
    PostsListPage postsList = new PostsListPage(driver).open();
    postsList.clickBackToWikiLink();
    postsList.verifyUrl(wikiURL);
  }

  public void clickAvatarLoadsUserPage() {
    PostsListPage postsList = new PostsListPage(driver).open();
    postsList.clickUserAvatar();
    Assertion.assertTrue(
            driver.getCurrentUrl().contains(
                    URLsContent.USER_PROFILE.replace("%userName%", "")));
  }

  public void clickUsernameLoadsUserPage() {
    PostsListPage postsList = new PostsListPage(driver).open();
    postsList.clickUsernameLink();
    Assertion.assertTrue(
            driver.getCurrentUrl().contains(
                    URLsContent.USER_PROFILE.replace("%userName%", "")));
  }

  public void discussionsAppPromotionUnitPresentOnPage() {
    PostsListPage postsList = new PostsListPage(driver).open();
    Assertion.assertTrue(postsList.isAppleLinkDisplayed());
    Assertion.assertTrue(postsList.isGooglePlayLinkDisplayed());
    Assertion.assertEquals(postsList.isPromotionAppTextDisplayed(), "Stay up to date on the go. Get the app now!");
  }

  public void appleLinkRedirectsProperly() {
    PostsListPage postsList = new PostsListPage(driver).open();
    postsList.clickAppleLinkInAppPromotion();
    String newWindow = driver.getWindowHandles().toArray()[1].toString();
    driver.switchTo().window(newWindow);
    Assertion.assertTrue(driver.getTitle().contains("Wikia Fan App for: Fallout"));
  }

  public void googlePlayLinkRedirectsProperly() {
    PostsListPage postsList = new PostsListPage(driver).open();
    postsList.clickGooglePlayLinkInAppPromotion();
    String newWindow = driver.getWindowHandles().toArray()[1].toString();
    driver.switchTo().window(newWindow);
    Assertion.assertTrue(driver.getTitle().contains("Wikia: Fallout"));
  }
}
