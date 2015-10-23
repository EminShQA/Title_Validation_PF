package core;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Title_Validation_PF {

	public static void main(String[] args) {
		WebDriver driver = new HtmlUnitDriver();

		Properties properties = new Properties();

		try {
			properties.load(new FileInputStream("./src/main/resources/test.properties"));
		} catch (FileNotFoundException e) {
			System.out.println("No file");//e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error IO");//e.printStackTrace();
		}

		String text_case_id = properties.getProperty("text_case_id");
		String url = properties.getProperty("url");
		String expected_result = properties.getProperty("expected_result");

		driver.get(url);
		driver.manage().timeouts().implicitlyWait(11, TimeUnit.SECONDS);
		String actual_result = driver.getTitle();

		if (expected_result.equals(actual_result)) {
			System.out.println("Test Case ID: \t\t" + text_case_id);
			System.out.println("URL: \t\t\t" + url);
			System.out.println("Expected Result: \t" + expected_result);
			System.out.println("Actual Result: \t\t" + actual_result);
			System.out.println("Test Case Result: \t" + "CONGRATS,YOU PASSED");
		} else {
			System.out.println("Test Case ID: \t\t" + text_case_id);
			System.out.println("URL: \t\t\t" + url);
			System.out.println("Expected Result: \t" + expected_result);
			System.out.println("Actual Result: \t" + actual_result);
			System.out.println("Test Case Result: \t" + "SORRY, YOU FAILED");
		}
		driver.quit();
	}
}
