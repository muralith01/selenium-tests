package com.wikia.webdriver.testcases.desktop.adstests;

import com.wikia.webdriver.common.contentpatterns.AdsContent;
import com.wikia.webdriver.common.core.annotations.*;
import com.wikia.webdriver.common.core.drivers.Browser;
import com.wikia.webdriver.common.core.helpers.Emulator;
import com.wikia.webdriver.common.core.url.Page;
import com.wikia.webdriver.common.dataprovider.TrackingOptInDataProvider;
import com.wikia.webdriver.common.templates.NewTestTemplate;
import com.wikia.webdriver.pageobjectsfactory.componentobject.TrackingOptInPage;
import com.wikia.webdriver.pageobjectsfactory.pageobject.adsbase.mobile.MobileAdsBaseObject;

import org.testng.annotations.Test;

import java.util.List;

@Execute(trackingOptIn = false, onWikia = "project43")
@InBrowser(browser = Browser.CHROME, emulator = Emulator.GOOGLE_NEXUS_5)
public class TestAdsTrackingOptInRequestsMobileWiki extends NewTestTemplate {

  private static final Page ADS_HOME_PAGE = new Page("project43", "Project43_Wikia");
  private static final Page ADS_ARTICLE1_PAGE = new Page("project43", "TrackingPixels/Article1");
  private static final Page ADS_UAP_PAGE = new Page("project43", "SyntheticTests/UAP");
  private static final Page ADS_MERCURY_PAGE = new Page("mercuryautomationtesting", "/join");
  private static final String DENMARK = "DK";
  private static final String GERMANY = "DE";
  private static final String FRANCE = "FR";

  @NetworkTrafficDump(useMITM = true)
  @Execute(trackingOptIn = false)
  @Test(dataProviderClass = TrackingOptInDataProvider.class, dataProvider = "adsKikimoraRejectedDataProvider", groups = "AdsOptInRejectedMobileWiki")
  public void adsTrackingRejectedForKikimora(String[] instantGlobals, List<String> urlPatterns) {
    networkTrafficInterceptor.startIntercepting();
    TrackingOptInPage modal = new TrackingOptInPage();
    modal.rejectOptInModal(driver, DENMARK, ADS_HOME_PAGE, instantGlobals);

    modal.verifyTrackingRequestsSendForRejected(urlPatterns, networkTrafficInterceptor);
  }

  @NetworkTrafficDump(useMITM = true)
  @Execute(trackingOptIn = false)
  @Test(dataProviderClass = TrackingOptInDataProvider.class, dataProvider = "adsNpaSlotsDataProviderMobile", groups = "AdsOptInRejectedMobileWiki")
  public void adsTrackingRejectedForSlotsAdSlots(List<String> urlPatterns) {
    networkTrafficInterceptor.startIntercepting();
    TrackingOptInPage modal = new TrackingOptInPage();
    modal.rejectOptInModal(driver, GERMANY, ADS_HOME_PAGE);

    modal.verifyTrackingRequestsSendForRejected(urlPatterns, networkTrafficInterceptor);
  }

  @NetworkTrafficDump(useMITM = true)
  @Execute(trackingOptIn = false)
  @Test(dataProviderClass = TrackingOptInDataProvider.class, dataProvider = "adsKruxDataProvider", groups = "AdsOptInOutKruxMobileWiki")
  public void adsTrackingRejectedForKrux(String[] instantGlobals, List<String> urlPatterns) {
    networkTrafficInterceptor.startIntercepting();
    TrackingOptInPage modal = new TrackingOptInPage();
    modal.rejectOptInModal(driver, GERMANY, ADS_HOME_PAGE, instantGlobals);

    modal.verifyTrackingRequestsNotSend(urlPatterns, networkTrafficInterceptor);
  }

  @NetworkTrafficDump(useMITM = true)
  @Execute(trackingOptIn = false)
  @Test(dataProviderClass = TrackingOptInDataProvider.class, dataProvider = "adsNetzAthletenDataProvider", groups = "AdsOptInRejectedMobileWiki")
  public void adsTrackingRejectedForNetzAthleten(
      String[] instantGlobals, List<String> urlPatterns
  ) {
    networkTrafficInterceptor.startIntercepting();
    TrackingOptInPage modal = new TrackingOptInPage();
    modal.rejectOptInModal(driver, GERMANY, ADS_HOME_PAGE, instantGlobals);

    modal.verifyTrackingRequestsNotSend(urlPatterns, networkTrafficInterceptor);
  }

  @NetworkTrafficDump(useMITM = true)
  @Execute(trackingOptIn = false)
  @Test(dataProviderClass = TrackingOptInDataProvider.class, dataProvider = "adsMoatDataProvider", groups = "AdsOptInRejectedMobileWiki")
  public void adsTrackingRejectedForMoat(String[] instantGlobals, List<String> urlPatterns) {
    networkTrafficInterceptor.startIntercepting();
    TrackingOptInPage modal = new TrackingOptInPage();
    modal.rejectOptInModal(driver, GERMANY, ADS_UAP_PAGE, instantGlobals);

    modal.verifyTrackingRequestsSendForRejected(urlPatterns, networkTrafficInterceptor);
  }

  @NetworkTrafficDump(useMITM = true)
  @Execute(trackingOptIn = false)
  @Test(dataProviderClass = TrackingOptInDataProvider.class, dataProvider = "adsPrebidDataProvider", groups = "AdsOptInRejectedMobileWiki")
  public void adsTrackingRejectedForPrebid(String[] instantGlobals, List<String> urlPatterns) {
    networkTrafficInterceptor.startIntercepting();
    TrackingOptInPage modal = new TrackingOptInPage();
    modal.rejectOptInModal(driver, DENMARK, ADS_HOME_PAGE, instantGlobals);

    modal.verifyTrackingRequestsSendForRejected(urlPatterns, networkTrafficInterceptor);
  }

  @NetworkTrafficDump(useMITM = true)
  @Execute(trackingOptIn = false)
  @Test(dataProviderClass = TrackingOptInDataProvider.class, dataProvider = "adsA9DataProvider", groups = "AdsOptInRejectedMobileWiki")
  public void adsTrackingRejectedForA9(String[] instantGlobals, List<String> urlPatterns) {
    networkTrafficInterceptor.startIntercepting();
    TrackingOptInPage modal = new TrackingOptInPage();
    modal.rejectOptInModal(driver, DENMARK, ADS_HOME_PAGE, instantGlobals);

    modal.verifyTrackingRequestsSendForRejected(urlPatterns, networkTrafficInterceptor);
  }

  @NetworkTrafficDump(useMITM = true)
  @Execute(trackingOptIn = false)
  @Test(dataProviderClass = TrackingOptInDataProvider.class, dataProvider = "adsComscoreDataProvider", groups = "AdsOptInOutComscoreMobileWiki")
  public void adsTrackingRejectedForComscore(List<String> urlPatterns) {
    networkTrafficInterceptor.startIntercepting();
    TrackingOptInPage modal = new TrackingOptInPage();
    modal.rejectOptInModal(driver, DENMARK, ADS_HOME_PAGE);

    modal.verifyTrackingRequestsNotSend(urlPatterns, networkTrafficInterceptor);
  }

  @NetworkTrafficDump(useMITM = true)
  @Execute(trackingOptIn = false)
  @Test(dataProviderClass = TrackingOptInDataProvider.class, dataProvider = "adsQuantcastDataProvider", groups = "AdsOptInRejectedMobileWiki")
  public void adsTrackingRejectedForQuantcast(List<String> urlPatterns) {
    networkTrafficInterceptor.startIntercepting();
    TrackingOptInPage modal = new TrackingOptInPage();
    modal.rejectOptInModal(driver, DENMARK, ADS_HOME_PAGE);

    modal.verifyTrackingRequestsSendForRejected(urlPatterns, networkTrafficInterceptor);
  }

  @NetworkTrafficDump(useMITM = true)
  @Execute(trackingOptIn = false)
  @Test(dataProviderClass = TrackingOptInDataProvider.class, dataProvider = "adsGoogleAnalyticsDataProvider", groups = "AdsOptInRejectedMobileWiki")
  public void adsTrackingRejectedForGoogleAnalytics(List<String> urlPatterns) {
    networkTrafficInterceptor.startIntercepting();
    TrackingOptInPage modal = new TrackingOptInPage();
    modal.rejectOptInModal(driver, DENMARK, ADS_HOME_PAGE);

    modal.verifyTrackingRequestsSendForRejected(urlPatterns, networkTrafficInterceptor);
  }

  @NetworkTrafficDump(useMITM = true)
  @Execute(trackingOptIn = false)
  @Test(dataProviderClass = TrackingOptInDataProvider.class, dataProvider = "adsKikimoraAcceptedDataProvider", groups = "AdsOptInAcceptedMobileWiki")
  public void verifyAdsTrackingAcceptedForKikimora(
      String[] instantGlobals, List<String> urlPatterns
  ) {
    networkTrafficInterceptor.startIntercepting();
    TrackingOptInPage modal = new TrackingOptInPage();
    modal.acceptOptInModal(driver, DENMARK, ADS_HOME_PAGE, instantGlobals);

    modal.verifyTrackingRequestsSend(urlPatterns, networkTrafficInterceptor);
  }

  @NetworkTrafficDump(useMITM = true)
  @Execute(trackingOptIn = false)
  @Test(dataProviderClass = TrackingOptInDataProvider.class, dataProvider = "adsKruxDataProvider", groups = "AdsOptInOutKruxMobileWiki")
  public void adsTrackingAcceptedForKrux(String[] instantGlobals, List<String> urlPatterns) {
    networkTrafficInterceptor.startIntercepting();
    TrackingOptInPage modal = new TrackingOptInPage();
    modal.acceptOptInModal(driver, DENMARK, ADS_HOME_PAGE, instantGlobals);

    modal.verifyTrackingRequestsSend(urlPatterns, networkTrafficInterceptor);
  }

  @NetworkTrafficDump(useMITM = true)
  @Execute(trackingOptIn = false)
  @Test(dataProviderClass = TrackingOptInDataProvider.class, dataProvider = "adsNetzAthletenDataProvider", groups = "AdsOptInAcceptedMobileWiki")
  public void adsTrackingAcceptedForNetzAthleten(
      String[] instantGlobals, List<String> urlPatterns
  ) {
    networkTrafficInterceptor.startIntercepting();
    TrackingOptInPage modal = new TrackingOptInPage();
    modal.acceptOptInModal(driver, GERMANY, ADS_HOME_PAGE, instantGlobals);

    modal.verifyTrackingRequestsSend(urlPatterns, networkTrafficInterceptor);
  }

  @NetworkTrafficDump(useMITM = true)
  @Execute(trackingOptIn = false)
  @Test(dataProviderClass = TrackingOptInDataProvider.class, dataProvider = "adsMoatDataProvider", groups = "AdsOptInAcceptedMobileWiki")
  public void adsTrackingAcceptedForMoat(String[] instantGlobals, List<String> urlPatterns) {
    networkTrafficInterceptor.startIntercepting();
    TrackingOptInPage modal = new TrackingOptInPage();
    modal.acceptOptInModal(driver, FRANCE, ADS_UAP_PAGE, instantGlobals);

    modal.verifyTrackingRequestsSend(urlPatterns, networkTrafficInterceptor);
  }

  @NetworkTrafficDump(useMITM = true)
  @Execute(trackingOptIn = false)
  @Test(dataProviderClass = TrackingOptInDataProvider.class, dataProvider = "adsPrebidDataProvider", groups = "AdsOptInAcceptedMobileWiki")
  public void adsTrackingAcceptedForPrebid(String[] instantGlobals, List<String> urlPatterns) {
    networkTrafficInterceptor.startIntercepting();
    TrackingOptInPage modal = new TrackingOptInPage();
    modal.acceptOptInModal(driver, DENMARK, ADS_HOME_PAGE, instantGlobals);

    modal.verifyTrackingRequestsSend(urlPatterns, networkTrafficInterceptor);
  }

  @NetworkTrafficDump(useMITM = true)
  @Execute(trackingOptIn = false)
  @Test(dataProviderClass = TrackingOptInDataProvider.class, dataProvider = "adsA9DataProvider", groups = "AdsOptInAcceptedMobileWiki")
  public void adsTrackingAcceptedForA9(String[] instantGlobals, List<String> urlPatterns) {
    networkTrafficInterceptor.startIntercepting();
    TrackingOptInPage modal = new TrackingOptInPage();
    modal.acceptOptInModal(driver, DENMARK, ADS_HOME_PAGE, instantGlobals);

    modal.verifyTrackingRequestsSend(urlPatterns, networkTrafficInterceptor);
  }

  @NetworkTrafficDump(useMITM = true)
  @Execute(trackingOptIn = false)
  @Test(dataProviderClass = TrackingOptInDataProvider.class, dataProvider = "adsComscoreDataProvider", groups = "AdsOptInOutComscoreMobileWiki")
  public void adsTrackingAcceptedForComscore(List<String> urlPatterns) {
    networkTrafficInterceptor.startIntercepting();
    TrackingOptInPage modal = new TrackingOptInPage();
    modal.acceptOptInModal(driver, DENMARK, ADS_HOME_PAGE);

    modal.verifyTrackingRequestsSend(urlPatterns, networkTrafficInterceptor);
  }

  @NetworkTrafficDump(useMITM = true)
  @Execute(trackingOptIn = false)
  @Test(dataProviderClass = TrackingOptInDataProvider.class, dataProvider = "adsQuantcastDataProvider", groups = "AdsOptInAcceptedMobileWiki")
  public void adsTrackingAcceptedForQuantcast(List<String> urlPatterns) {
    networkTrafficInterceptor.startIntercepting();
    TrackingOptInPage modal = new TrackingOptInPage();
    modal.acceptOptInModal(driver, DENMARK, ADS_HOME_PAGE);

    modal.verifyTrackingRequestsSend(urlPatterns, networkTrafficInterceptor);
  }

  @NetworkTrafficDump(useMITM = true)
  @Execute(trackingOptIn = false)
  @Test(dataProviderClass = TrackingOptInDataProvider.class, dataProvider = "adsGoogleAnalyticsDataProvider", groups = "AdsOptInAcceptedMobileWiki")
  public void adsTrackingAcceptedForGoogleAnalytics(List<String> urlPatterns) {
    networkTrafficInterceptor.startIntercepting();
    TrackingOptInPage modal = new TrackingOptInPage();
    modal.acceptOptInModal(driver, DENMARK, ADS_HOME_PAGE);

    modal.verifyTrackingRequestsNotSendForAccepted(urlPatterns, networkTrafficInterceptor);
  }

  @NetworkTrafficDump(useMITM = true)
  @Execute(trackingOptIn = false)
  @Test(dataProviderClass = TrackingOptInDataProvider.class, dataProvider = "adsNpaSlotsDataProviderMobile", groups = "AdsOptInAcceptedMobileWiki")
  public void adsTrackingAcceptedForAdSlots(List<String> urlPatterns) {
    networkTrafficInterceptor.startIntercepting();
    TrackingOptInPage modal = new TrackingOptInPage();
    modal.acceptOptInModal(driver, DENMARK, ADS_HOME_PAGE);

    modal.verifyTrackingRequestsNotSendForAccepted(urlPatterns, networkTrafficInterceptor);
  }
}
