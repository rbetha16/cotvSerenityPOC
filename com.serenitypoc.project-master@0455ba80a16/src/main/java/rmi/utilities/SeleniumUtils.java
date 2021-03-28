package rmi.utilities;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.webdriver.SerenityWebdriverManager;

public class SeleniumUtils extends PageObject {
	
		

	public void waitUntillGivenWindowPresent(int Time, int NoofWindows) {

		Set<String> windows = getDriver().getWindowHandles();
		int windowCount = windows.size();
		
		for (int i = 0; i < Time; i++) {

			if (windowCount > NoofWindows) {
				break;
			} else {
				try {
					
					defaultWait(ProjectVariables.MIN_THREAD_WAIT);
				} catch (Exception e1) {
					System.out.println("Waiting for webelement in DOM");
				}

			}
		}

	}

	public void switchWindowUsingWindowCount(int waitTimer, int windowNum) {

		waitUntillGivenWindowPresent(waitTimer, windowNum);
		ArrayList<String> windowHandles = new ArrayList<String>(getDriver().getWindowHandles());
		System.out.println("WINDOWS" + windowHandles.size());
		getDriver().switchTo().window(windowHandles.get(windowNum - 1).toString());

	}

	public static void refresBrowser(WebDriver driver) {
		driver.navigate().refresh();

	}

	public static void defaultWait(int i) {
		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	public static void defaultWait(long i) {
		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	public static String getValueByName(String Name) {

		return Serenity.sessionVariableCalled(Name).toString();
	}

	public String getLastWebelemtFromList(String xpath) {

		List<WebElement> list = getDriver().findElements(By.xpath(xpath));
		int size = list.size();
		System.out.println(size);
		return list.get(size - 1).getText();
	}

	public void switchToNewWindow() {

		String baseWindowHandle = getDriver().getWindowHandle();
		Set<String> openedWindows = getDriver().getWindowHandles();
		String newWindow = null;
		if (openedWindows.size() > 1 && openedWindows.remove(baseWindowHandle)) {
			Iterator<String> openedWindowsIterator = openedWindows.iterator();
			newWindow = (String) openedWindowsIterator.next();
		}
		getDriver().switchTo().window(newWindow);
	}

	public static boolean waitUntillElementisDisplayed(String xpath, int seconds, WebDriver driver) {
		if (checkElementExsist(xpath, seconds, driver)) {
			for (int i = 0; i < seconds; i++) {
				if (driver.findElement(By.xpath(xpath)).isDisplayed())
					return true;
				else
					defaultWait(ProjectVariables.MIN_THREAD_WAIT);
			}
			return false;
		}

		else {
			return false;
		}

	}

	public static boolean waitUntillElementisNotDisplayed(String xpath, int seconds, WebDriver driver) {
		try {
			if (!checkElementNotExsist(xpath, seconds, driver)) {
				for (int i = 0; i < seconds; i++) {

					if (driver.findElement(By.xpath(xpath)).isDisplayed())
						defaultWait(ProjectVariables.MIN_THREAD_WAIT);

					else
						return true;

				}

			}
		} catch (Exception e) {
			return false;
		}

		return false;

	}

	public static boolean checkElementExsist(String xpath, int seconds, WebDriver driver) {
		boolean flag = false;
		try {

			driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
			driver.findElement(By.xpath(xpath));
			flag = true;
		} catch (NoSuchElementException e) {
			flag = false;
		} finally {
			SerenityWebdriverManager.inThisTestThread().getCurrentDriver().manage().timeouts().implicitlyWait(4000,
					TimeUnit.SECONDS);
		}
		return flag;

	}

	public static boolean checkElementNotExsist(String xpath, int seconds, WebDriver driver) {
		boolean flag = false;
		try {
			driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
			driver.findElement(By.xpath(xpath));

			flag = false;
		} catch (NoSuchElementException e) {
			flag = true;
		} finally {

			driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);

		}
		return flag;

	}

	public static ExpectedCondition<Boolean> waitForDomReadyState(WebDriver driver) {

		return new ExpectedCondition<Boolean>() {

			public Boolean apply(WebDriver d) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				boolean flag = js.executeScript("return document.readyState;").equals("complete");
				System.out.println(flag);
				return (js.executeScript("return document.readyState;").equals("complete"));
			}
		};
	}

	public void highlightElement(WebElement element) {

		for (int i = 0; i < ProjectVariables.HIGHLIGHT_COUNT; i++) {
			WebDriver driver = getDriver();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].style.border='7px solid green'", element);
			
			js.executeScript("arguments[0].style.border=''", element);

		}

	}

	public void highlightElement(String Xpath) {

		WebElement element = getDriver().findElement(By.xpath(Xpath));
		for (int i = 0; i < ProjectVariables.HIGHLIGHT_COUNT; i++) {
			WebDriver driver = getDriver();
			JavascriptExecutor js = (JavascriptExecutor) driver;

			js.executeScript("arguments[0].style.border='5px solid green'", element);
			
			js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "");
		}

	}
	public void SwitchToFrame(String sFrame) {		
		WebElement element = getDriver().findElement(By.xpath(sFrame));		
		getDriver().switchTo().frame(element);		
	}
	public void highlightElement_CheckBox(String Xpath) {

		WebElement element = getDriver().findElement(By.xpath(Xpath));
		for (int i = 0; i < 2; i++) {
			WebDriver driver = getDriver();
			JavascriptExecutor js = (JavascriptExecutor) driver;

			js.executeScript("arguments[0].style.border='7px solid yellow'", element);

		}
	}

	public void highlightElement_CheckBox(WebElementFacade element) {

		for (int i = 0; i < 2; i++) {
			WebDriver driver = getDriver();
			JavascriptExecutor js = (JavascriptExecutor) driver;

			js.executeScript("arguments[0].style.border='7px solid yellow'", element);

		}

	}

	public void Remove_highlightElement(String Xpath) {

		WebElement element = getDriver().findElement(By.xpath(Xpath));
		for (int i = 0; i < 2; i++) {
			WebDriver driver = getDriver();
			JavascriptExecutor js = (JavascriptExecutor) driver;

			js.executeScript("arguments[0].style.border=''", element);

		}

	}

	public void Click_given_WebElement(WebElementFacade element) {

		highlightElement(element);
		element.withTimeoutOf(ProjectVariables.MIN_TIME_OUT, TimeUnit.SECONDS).waitUntilVisible().click();
	}

	public void Click_given_Locator(String xpath) {
		highlightElement(xpath);
		$(xpath).withTimeoutOf(ProjectVariables.MIN_TIME_OUT, TimeUnit.SECONDS).waitUntilVisible().click();
	}

	public void Enter_given_Text_Element(WebElementFacade element, String text) {

		highlightElement(element);
		element.withTimeoutOf(ProjectVariables.MIN_TIME_OUT, TimeUnit.SECONDS).waitUntilVisible().clear();
		element.withTimeoutOf(ProjectVariables.MIN_TIME_OUT, TimeUnit.SECONDS).waitUntilVisible().sendKeys(text);
	}

	public void Enter_given_Text_Element(WebElement element, String text) {

		highlightElement(element);
		element.clear();
		element.sendKeys(text);
	}

	public void Enter_given_Text_Element(String xpath, String text) {
		highlightElement(xpath);
		$(xpath).withTimeoutOf(ProjectVariables.MIN_TIME_OUT, TimeUnit.SECONDS).waitUntilVisible().clear();
		$(xpath).withTimeoutOf(ProjectVariables.MIN_TIME_OUT, TimeUnit.SECONDS).waitUntilVisible().sendKeys(text);
	}

	public int get_Matching_WebElement_count(String xpath) {
		highlightElement(xpath);
		return getDriver().findElements(By.xpath(xpath)).size();
	}
	 public String[] get_All_Text_from_Locator(String Xpath) {
		List <WebElement> elements = getDriver().findElements(By.xpath(Xpath));
		String[] text= new String[elements.size()];
		for(int i =0;i<elements.size();i++)
		{
			
			text[i]=elements.get(i).getText();
			System.out.println(text[i]);
		}
	        return text;
	    }



	public String get_TextFrom_Locator(String Xpath) {
		highlightElement(Xpath);
		return $(Xpath).withTimeoutOf(ProjectVariables.MIN_TIME_OUT, TimeUnit.SECONDS).waitUntilVisible()
				.getTextValue();
	}

	public String get_Text_From_WebElement(WebElementFacade element) {

		highlightElement(element);
		return element.withTimeoutOf(ProjectVariables.MIN_TIME_OUT, TimeUnit.SECONDS).waitUntilVisible().getTextValue();
	}

	public String get_Text_From_WebElement(WebElement element) {

		highlightElement(element);
		return element.getText();
	}

	public boolean is_WebElement_Displayed(WebElementFacade element) {
		try {
			highlightElement(element);
			return element.withTimeoutOf(ProjectVariables.MIN_TIME_OUT, TimeUnit.SECONDS).isDisplayed();
		} catch (Exception e) {
			return false;
		}

	}

	public boolean is_WebElement_Present(WebElementFacade element) {
		try {
			highlightElement_CheckBox(element);
			return element.withTimeoutOf(ProjectVariables.MIN_TIME_OUT, TimeUnit.SECONDS).isPresent();
		} catch (Exception e) {
			return false;
		}

	}

	public boolean is_WebElement_Displayed(String Xpath) {
		try {
			highlightElement(Xpath);
			return $(Xpath).withTimeoutOf(ProjectVariables.MIN_TIME_OUT, TimeUnit.SECONDS).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public boolean is_WebElement_Present(String Xpath) {
		try {
			highlightElement_CheckBox(Xpath);
			return $(Xpath).withTimeoutOf(ProjectVariables.MIN_TIME_OUT, TimeUnit.SECONDS).isPresent();
		} catch (Exception e) {
			return false;
		}
	}

	public void scrool_bottom_of_page() {
		JavascriptExecutor jse = ((JavascriptExecutor) getDriver());
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");

	}
	public boolean is_WebElement_Visible(String Xpath) {
		try {
			highlightElement_CheckBox(Xpath);
			return $(Xpath).withTimeoutOf(ProjectVariables.MIN_TIME_OUT, TimeUnit.SECONDS).isVisible();
		} catch (Exception e) {
			return false;
		}
	}

	public void Click_given_WebElement(WebElement webElement) {
		highlightElement(webElement);
		webElement.click();
	
		
	}
public static void scrollingToGivenElement(WebDriver driver,String string) {
		
		WebElement element = driver.findElement(By.xpath(string));
		((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView(true);", element);
	}

public boolean is_WebElement_Displayed(WebElement webElement) {
	try {
		highlightElement(webElement);
		return webElement.isDisplayed();
	} catch (Exception e) {
		return false;
	}
}

public void click_Enter(WebElement webElement) {
	webElement.click();
	webElement.sendKeys(Keys.ENTER);
	
}

}
