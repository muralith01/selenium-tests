package com.wikia.webdriver.TestCases.AdminDashboardTests;

import org.testng.annotations.Test;

import com.wikia.webdriver.Common.ContentPatterns.URLsContent;
import com.wikia.webdriver.Common.Properties.Credentials;
import com.wikia.webdriver.Common.Templates.NewTestTemplate;
import com.wikia.webdriver.PageObjectsFactory.PageObject.WikiBasePageObject;
import com.wikia.webdriver.PageObjectsFactory.PageObject.Article.ArticlePageObject;
import com.wikia.webdriver.PageObjectsFactory.PageObject.Article.EditMode.VisualEditModePageObject;
import com.wikia.webdriver.PageObjectsFactory.PageObject.Special.SpecialAdminDashboardPageObject;
import com.wikia.webdriver.PageObjectsFactory.PageObject.WikiPageMonoBook.WikiArticleMonoBookPageObject;


/**
 * tests are prepared to test the following feature: https://wikia-inc.atlassian.net/browse/DAR-136
 *
 * @author wikia
 */
public class EditingLocalCssTests extends NewTestTemplate {

	Credentials credentials = config.getCredentials();

	/**
	 * https://wikia-inc.atlassian.net/browse/DAR-293
	 * https://wikia-inc.atlassian.net/browse/DAR-298
	 */
	@Test(groups = {"EditingLocalCss_001", "EditingLocalCss", "AdminDashboard"})
	public void EditingLocalCss_001_UserWithAdminRightsTriesToEditWikiaCss() {
		WikiBasePageObject base = new WikiBasePageObject(driver);
		base.logInCookie(credentials.userNameStaff, credentials.passwordStaff, wikiURL);
		ArticlePageObject article = base.openArticleByName(wikiURL, URLsContent.mediaWikiCss);
		VisualEditModePageObject edit = article.goToCurrentArticleEditPage();
		edit.verifyUrl(URLsContent.specialCSS);
	}

	/**
	 * https://wikia-inc.atlassian.net/browse/DAR-294
	 * https://wikia-inc.atlassian.net/browse/DAR-295
	 * https://wikia-inc.atlassian.net/browse/DAR-296
	 * https://wikia-inc.atlassian.net/browse/DAR-297
	 *
	 */
	@Test(groups = {"EditingLocalCss_002", "EditingLocalCss", "AdminDashboard"})
	public void EditingLocalCss_002_UserWithoutAdminRightsHasNoEditOption() {
		WikiBasePageObject base = new WikiBasePageObject(driver);
		ArticlePageObject article = base.openArticleByName(wikiURL, URLsContent.mediaWikiCss);
		article.verifyEditButtonNotPresent();
		article.goToCurrentArticleEditPage();
		article.verifyPermissionsErrorsPresent();
		article.logInCookie(credentials.userName, credentials.password, wikiURL);
		article.openArticleByName(wikiURL, URLsContent.mediaWikiCss);
		article.verifyEditButtonNotPresent();
		article.goToCurrentArticleEditPage();
		article.verifyPermissionsErrorsPresent();
	}

	/**
	 * https://wikia-inc.atlassian.net/browse/DAR-299
	 */
	@Test(groups = {"EditingLocalCss_003", "EditingLocalCss", "AdminDashboard"})
	public void EditingLocalCss_003_MonobookUserWithAdminRightsEditsWikiaCss() {
		WikiBasePageObject base = new WikiBasePageObject(driver);
		base.logInCookie(credentials.userNameMonobook, credentials.passwordMonobook, wikiURL);
		WikiArticleMonoBookPageObject monobookArticle = new WikiArticleMonoBookPageObject(driver);
		monobookArticle.openArticleByName(wikiURL, URLsContent.mediaWikiCss);
		monobookArticle.clickEdit();
		monobookArticle.verifyEditionArea();
	}

	/**
	 * https://wikia-inc.atlassian.net/browse/DAR-300
	 */
	@Test(groups = {"EditingLocalCss_004", "EditingLocalCss", "AdminDashboard"})
	public void EditingLocalCss_004_MonobookUserWithAdminRightsOpensSpecialCss() {
		WikiBasePageObject base = new WikiBasePageObject(driver);
		base.logInCookie(credentials.userNameMonobook, credentials.passwordMonobook, wikiURL);
		WikiArticleMonoBookPageObject monobookArticle = new WikiArticleMonoBookPageObject(driver);
		monobookArticle.openSpecialCss(wikiURL);
		monobookArticle.verifyOasisOnly();
	}

	/**
	 * https://wikia-inc.atlassian.net/browse/DAR-302
	 */
	@Test(groups = {"EditingLocalCss_005", "EditingLocalCss", "AdminDashboard"})
	public void EditingLocalCss_005_UserWithAdminRightsTriesToAccesSpecialCssFromAdminDashboard() {
		WikiBasePageObject base = new WikiBasePageObject(driver);
		base.logInCookie(credentials.userNameStaff, credentials.passwordStaff, wikiURL);
		SpecialAdminDashboardPageObject adminDashboard = base.openSpecialAdminDashboard(wikiURL);
		adminDashboard.clickCssTool();
		adminDashboard.verifyUrl(URLsContent.specialCSS);
	}
}
