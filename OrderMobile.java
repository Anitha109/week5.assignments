package week5.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.sukgu.Shadow;

public class OrderMobile extends BaseClass {
	@Test
	public void orderMobile() throws InterruptedException {
		Shadow dom = new Shadow(driver);
		dom.setImplicitWait(5);
		// Click-All
		dom.findElementByXPath("//div[@id = 'd6e462a5c3533010cbd77096e940dd8c']").click();
		// Enter Service catalog in filter navigator and press enter
		dom.findElementByXPath("//input[@id = 'filter']").sendKeys("Service catalog"); // +
																						// Keys.ENTER);
		dom.findElementByXPath("//mark[text() = 'Service Catalog']").click();
		// Click on mobiles
		Thread.sleep(2000);
		WebElement frameEle = dom.findElementByXPath("//iframe[@id = 'gsft_main']");
		driver.switchTo().frame(frameEle);
		driver.findElement(By.xpath("//h2[contains(text() , 'Mobiles')]")).click();
		// Select Apple iphone13
		driver.findElement(By.className("sc_category_item")).click();
		// Select no for Is this a replacement for a lost or broken iPhone?
		driver.findElement(By.xpath("//label[text() = 'No']")).click();
		WebElement monthlyAllow = driver.findElement(By.id("IO:33494b069747011021983d1e6253af45"));
		Select dd = new Select(monthlyAllow);
		dd.selectByVisibleText("500MB");
		// Update color field to rose gold and storage field to 128GB
		driver.findElement(By.xpath("//label[text() = 'Pink']")).click();
		driver.findElement(By.xpath("//label[text() = '128 GB']")).click();
		// Select Order now option
		driver.findElement(By.id("oi_order_now_button")).click();
		// Verify order is placed and copy the request number"
		String requestNumber = driver.findElement(By.id("requesturl")).getText();
		System.out.println("Reguest Number : " + requestNumber);
	}

}
