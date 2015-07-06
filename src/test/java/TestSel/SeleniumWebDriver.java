package TestSel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.UnreachableBrowserException;

public class SeleniumWebDriver {

	private static WebDriver webdriver = new FirefoxDriver(new FirefoxProfile());
	
	static {
		Runtime.getRuntime().addShutdownHook(new Thread(new BrowserCleanup()));	
	}

	public static WebDriver getCurrentDriver() {
		return webdriver;
	}

	private static class BrowserCleanup implements Runnable {
		public void run() {
			close();
		}
	}

	public static void close() {
		try {
			getCurrentDriver().quit();
			webdriver = null;
		} catch (UnreachableBrowserException e) {}
	}

}
