package StepDefinition;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import Object_repository.properties;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Myproject extends properties {

	WebDriver driver = null;

	@Given("Browser is up")
	public void browser_is_up() {
		System.out.println("User is on login page");
		// String projectPath = System.getProperty("user.dir");
		// System.out.println("projectpath"+projectPath);

		System.setProperty("webdriver.chrome.driver", "C:\\BrowserDriver\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@Given("drop down url is up")
	public void drop_down_url_is_up() {
		driver.get(properties.dropdow);
		;

	}

	@And("User select drop down option")
	public void user_select_drop_down_option() throws InterruptedException {
		WebElement srt = driver.findElement(By.xpath("//*[@id=\"post-2646\"]/div[2]/div/div/div/p/select"));
		srt.click();
		Select select = new Select(srt);
		select.selectByIndex(1);
		Thread.sleep(2000);
		select.selectByValue("AND");
		Thread.sleep(2000);
		select.selectByVisibleText("Bhutan");
		driver.close();

	}

	@And("checkbox down url is up")
	public void checkbox_down_url_is_up() {
		driver.get("https://accounts.google.com/signup/v2/webcreateaccount?flowName=GlifWebSignIn&flowEntry=SignUp");
	}

	@And("User click on checkbox")
	public void user_click_on_checkbox() throws InterruptedException {
		driver.findElement(By.xpath(properties.chkbx)).click();
		Thread.sleep(2000);
		driver.close();
	}

	@Given("checkbox url is up")
	public void checkbox_url_is_up() {
		driver.get("https://www.facebook.com/signup");
	}

	@Given("user able to click on radio button")
	public void user_able_to_click_on_radio_button() throws InterruptedException {
		driver.findElement(By.xpath(properties.radio)).click();
		List<WebElement> srt = driver.findElements(By.tagName("a"));
		System.out.println("total url = " + srt.size());
		Thread.sleep(2000);
		driver.close();
	}

	@And("autosuggestion url is up")
	public void autosuggestion_url_is_up() {
		driver.navigate().to(properties.autosuggestion);
	}

	@Then("user click on leaving from field")
	public void user_click_on_leaving_from_field() throws InterruptedException {
		WebElement srtr = driver.findElement(By.xpath(properties.searchfrom));
		srtr.click();

	}

	@Then("user select option and select")
	public void user_select_option_and_select() throws InterruptedException {
		WebElement auto = driver.findElement(By.xpath("//input[@data-stid='origin_select-menu-input']"));
		auto.sendKeys("pa");
		Thread.sleep(2000);
		auto.sendKeys(Keys.ARROW_DOWN);
		auto.sendKeys(Keys.ARROW_DOWN);
		auto.sendKeys(Keys.ENTER);
		driver.close();
	}

	@Given("frameswitch url is up")
	public void frameswitch_url_is_up() {
		driver.get(properties.frameswitch);
	}

	@Given("user switch to respected frame")
	public void user_switch_to_respected_frame() {
		driver.switchTo().frame(properties.frame);
	}

	@Given("user click on school link")
	public void user_click_on_school_link() throws InterruptedException {
		driver.findElement(By.xpath(properties.w3school)).click();
		Thread.sleep(2000);
		driver.close();
	}

	@Given("Alert url is up")
	public void alert_url_is_up() throws InterruptedException {
		driver.navigate().to(properties.alert_url);
		System.out.println("url is opened");
		Thread.sleep(5000);
	}

	@Given("user switch to required frame section")
	public void user_switch_to_required_frame_section() {
		driver.switchTo().frame("iframeResult");
		System.out.println("frame switched");
	}

	@Given("user click on Try button")
	public void user_click_on_try_button() {
		driver.findElement(By.xpath(properties.try_it)).click();
		System.out.println("button clicked");
	}

	@Given("user handing alert")
	public void user_handing_alert() throws InterruptedException {
		driver.switchTo().alert().sendKeys("uday");
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
//	    driver.close();
	}

	@Given("window handle url is up")
	public void window_handle_url_is_up() {
		driver.get(properties.window_handle);
		driver.findElement(By.xpath("//pbc-button[@data-link-text='Start free trial']")).click();
	}

	@Given("user switch to respecetd window")
	public void user_switch_to_respecetd_window() {
		Set<String> obc = driver.getWindowHandles();
		Iterator<String> obc1 = obc.iterator();
		String pp = obc1.next();
		String cc = obc1.next();
		driver.switchTo().window(cc);
	}

	@Given("user perform function on that window")
	public void user_perform_function_on_that_window() throws InterruptedException {
		driver.findElement(By.xpath(properties.mailid)).sendKeys("usd@gmail.com");
		Thread.sleep(2000);
		driver.quit();
	}

	@And("drag&drop url is up")
	public void drag_drop_url_is_up() {
		driver.get(properties.drang_drop_url);
		System.out.println("draager url is up");
		WebElement frm = driver.findElement(By.xpath(properties.iframedragdrop));
		driver.switchTo().frame(frm);
		System.out.println("switch to frame");
	}

	@And("user perfrom drag&drop option")
	public void user_perfrom_drag_drop_option() throws InterruptedException {
		WebElement drag = driver.findElement(By.xpath(properties.drag));
		WebElement drop = driver.findElement(By.xpath(properties.drop));
		Actions sct = new Actions(driver);
		sct.dragAndDrop(drag, drop).perform();
		Thread.sleep(2000);
		driver.close();
	}

	@Given("cursor moving url is up")
	public void cursor_moving_url_is_up() throws InterruptedException {
		driver.get("https://www.ebay.com/");
		Actions act = new Actions(driver);
		WebElement srt = driver.findElement(By.xpath(properties.movetourl));
		act.moveToElement(srt).perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/ul/li[3]/div[2]/div[1]/nav[2]/ul/li[1]/a"))
				.click();
		System.out.println("move to url");
		if (driver.getPageSource().contains("Apple Cell Phone Cases and Covers"))
			System.out.println("text is available");
		driver.close();
	}

	@Given("user open admin username and password")
	public void user_open_admin_username_and_password() {
		// driver.get("https://"+properties.username1+":"+properties.password1+"@the-internet.herokuapp.com/basic_auth");

		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		driver.close();
	}

	@Given("User able to take screenshot")
	public void user_able_to_take_screenshot() throws IOException {
		driver.get("https://www.flipkart.com/");
		File ss = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(ss, new File(".//screenshot/image2.png"));
		driver.close();

	}

	@Given("User check Implicit wait or explicit or fluent wait")
	public void user_check_implicit_wait_or_explicit_or_fluent_wait() {
		// inplicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// explicit wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(properties.alert_url)));
		// fluent wait
		Wait<WebDriver> wait1 = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofSeconds(2))
				.ignoring(NoSuchElementException.class)
				.withMessage("uday kumar");
		/*
		 * Wait<WebDriver> wait1 = new FluentWait<WebDriver>(driver)
		 * .withTimeout(Duration.ofSeconds(20)) .pollingEvery(Duration.ofSeconds(5))
		 * .ignoring(NoSuchElementException.class);
		 */
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(properties.alert_url)));

	}

}
