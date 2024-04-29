package sit707_week2.handlers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserHandler {

	
	
	private WebDriver webDriver;

	public BrowserHandler(String browserName) {
        
		switch (browserName.toLowerCase()) {
            case "chrome":
                this.webDriver = new ChromeDriver();
                break;
            case "firefox":
                this.webDriver = new FirefoxDriver();
                break;
            case "edge":
                this.webDriver = new EdgeDriver();
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browserName);
        }
    }
	
	public WebDriver getDriver() {
		return webDriver;
	}
	
}
