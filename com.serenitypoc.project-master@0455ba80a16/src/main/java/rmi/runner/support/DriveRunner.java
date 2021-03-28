package rmi.runner.support;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import net.thucydides.core.webdriver.DriverSource;




public class DriveRunner implements DriverSource {

	public WebDriver newDriver() {
		try {

			
			ChromeOptions options = new ChromeOptions();

			// add parameter which will disable the extension
			options.addArguments("--no-first-run");
			options.addArguments("--homepage=about:blank");
			options.addArguments("--test-type");
			return new ChromeDriver(options);

		} catch (Exception e) {
			throw new Error(e);
		}

	}

	public boolean takesScreenshots() {
		// TODO Auto-generated method stub
		return true;
	}


}
