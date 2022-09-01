package com.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.DriverManager;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;

	public String getPropertyFileValue(String key) throws FileNotFoundException, IOException {

		Properties properties = new Properties();
		properties.load(new FileInputStream("C:\\Users\\Welcome\\eclipse-workspace\\OMRBranchAdactinAutomation\\Config\\Config.properties"));
		String value = (String) properties.get(key);
		return value;

	}

	// 1.get driver;
	
	
	public static void getDriver(String browserType) {
		switch (browserType) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "ie":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		default:
			break;
		}
	}

	// 2.get Url;
	public  static void getUrl(String url) {
		driver.get(url);
	}

	// 3.maximize Window;
	public static void maximizeWindow() {
		driver.manage().window().maximize();
	}

	// 4.sendKeys;
	public void elementSendKeys(WebElement element, String data) {
		element.sendKeys(data);

	}

	// 5.click;
	public void click(WebElement element) {
		element.click();
	}

	// 6.alert click
	public void alertclick() {
		Alert al = driver.switchTo().alert();
		al.accept();
	}

	// 7.alert cancel
	public void alertCancel() {
		Alert al = driver.switchTo().alert();
		al.dismiss();
	}

	// 8.get text
	public String webPageText(WebElement element) {
		String text = element.getText();
		return text;

	}

	// 9.close All window
	public static void closeAllWindow() {
		driver.quit();

	}

	// 10.close Current window
	public void closeCurrentWindow() {
		driver.close();

	}

	public String getAttribute(WebElement element) {
		String attribute = element.getAttribute("value");
		return attribute;
	}

	public String elementGetAttribute(WebElement element, String name) {
		String text = element.getAttribute("value");
		return text;

	}

	// 11.get title
	public String getTitle() {
		String title = driver.getTitle();
		return title;
	}

	// 12.get url
	public String getCurrentUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}

	// 13.select by visible text
	public void selectByText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	// 14.select by value
	public void selectByAttribute(WebElement element, String Value) {
		Select select = new Select(element);
		select.selectByValue(Value);
	}

	// 15.select by index
	public void selectByIndex(WebElement element, int i) {
		Select select = new Select(element);
		select.selectByIndex(i);
	}

	// 16.Insert text bu JavaScript
	public void textBoxUsingJs(WebDriver element, String text) {
		JavascriptExecutor execute = (JavascriptExecutor) driver;
		execute.executeScript("aruguments[0].setAttribute('value','" + text + "')", element);
	}

	// 17.launch chrome
	public void launchChromeBrowser(String path) {
		System.setProperty("webdriver.chrome.driver", "path");
		WebDriver driver = new ChromeDriver();
	}

	// 18.switch to child window
	public void switchToChildWindow() {
		String windowHandle = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();
		for (String child : windowHandles) {
			if (!windowHandle.equals(windowHandles)) {
				driver.switchTo().window(child);

			}

		}

	}

	// 19.Switch to frame by index
	public void switchToFrameByIndex(int index) {
		driver.switchTo().frame(index);
	}

	// 20.find locator by id
	public WebElement findElementById(String id) {
		WebElement element = driver.findElement(By.id(id));
		return element;
	}

	// 21.find locator by name
	public WebElement findElementByName(String name) {
		WebElement element = driver.findElement(By.name(name));
		return element;
	}

	// 22.find locator by class name
	public WebElement findElementByClassName(String name) {
		WebElement element = driver.findElement(By.className(name));
		return element;
	}

	// 23.find locator by xpath
	public WebElement findElementByXpath(String xpath) {
		WebElement element = driver.findElement(By.xpath(xpath));
		return element;
	}

	// 24.drag and drop
	public void dragAndDrop(WebElement source, WebElement target) {
		Actions action = new Actions(driver);
		action.dragAndDrop(source, target).perform();
	}

	// 25.move to element
	public void moveToElement(WebElement target) {
		Actions action = new Actions(driver);
		action.moveToElement(target).perform();
	}

	// 26.navigate back
	public void navigateBack() {
		Navigation navigate = driver.navigate();
		navigate.back();

	}

	// 27.navigate forward
	public void navigateForward() {
		Navigation navigate = driver.navigate();
		navigate.forward();
	}

	// 28.navigate refresh
	public void navigateRefersh() {
		Navigation navigate = driver.navigate();
		navigate.refresh();
	}

	// 29.element is visible
	public boolean elementIsVisible(WebElement element) {
		boolean displayed = element.isDisplayed();
		return displayed;
	}

	// 30.element is enabled
	public boolean elementIsEnabled(WebElement element) {
		boolean enabled = element.isEnabled();
		return enabled;

	}

	// 31.element is selected
	public boolean elementIsSelected(WebElement element) {
		boolean selected = element.isSelected();
		return selected;

	}

	// 32.Right Click
	public void rightClick(WebElement element) {
		Actions action = new Actions(driver);
		action.contextClick(element).perform();
	}

	// 33.press key
	public void pressKey(int keycode) throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(keycode);
	}

	// 34.release key
	public void releasekey(int keycode) throws AWTException {
		Robot robot = new Robot();
		robot.keyRelease(keycode);

	}

	// 35.double click
	public void doubleClick(WebElement element) {
		Actions action = new Actions(driver);
		action.doubleClick().perform();
	}

	// 36.text alert
	public void alertText(String text) {
		Alert al = driver.switchTo().alert();
		al.sendKeys(text);
		al.accept();
	}

	// 37.Scroll down
	public void scrollDown(WebElement element) {
		JavascriptExecutor execute = (JavascriptExecutor) driver;
		execute.executeScript("arguments[0].scrollIntoView(true)", element);
	}

	// 38.scroll up
	public void scrollUp(WebElement element) {
		JavascriptExecutor execute = (JavascriptExecutor) driver;
		execute.executeScript("arguments[0].scrollIntoView(false)", element);
	}

	// 39.Take ScreenShot
	public void takeScreenShot(String pathname) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File screenshotAs = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(pathname);
		FileUtils.copyFile(screenshotAs, file);
	}

	// 40.Get options
	public String getOptions(WebElement element) {
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		String string = options.toString();
		return string;
	}

	// 41.get all selected options
	public String getAllSelectedOptions(WebElement element) {
		Select select = new Select(element);
		List<WebElement> allSelectedOptions = select.getAllSelectedOptions();
		String string = allSelectedOptions.toString();
		return string;

	}

	// 42.Get First Selected Option
	public String getFirstSelectedOptions(WebElement element) {
		Select select = new Select(element);
		WebElement firstSelectedOption = select.getFirstSelectedOption();
		String string = firstSelectedOption.toString();
		return string;
	}

	// 43.is Multiple
	public boolean isMultiple(WebElement element) {
		Select select = new Select(element);
		boolean multiple = select.isMultiple();
		return multiple;
	}

	// 44. DeSelecte By Index
	public void deSelectByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.deselectByIndex(index);

	}

	// 45.Deselect By Value
	public void deSelectByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.deselectByValue(value);
	}

	// 46.Deselected By Visible Text
	public void deSelectByVisibleText(WebElement element, String text) {
		Select select = new Select(element);
		select.deselectByVisibleText(text);
	}

	// 47.Deselect all
	public void deSelectAll(WebElement element) {
		Select select = new Select(element);
		select.deselectAll();

	}

	// 48.Swtich to Frame By Name or Id
	public void switchToFrameByNameOrId(WebElement nameOrId) {
		driver.switchTo().frame(nameOrId);
	}

	// 49.switch to Frame By Element
	public void switchToFrameByElement(WebElement frameElement) {
		driver.switchTo().frame(frameElement);
	}

	// 50.Switch to Frame By Index
	public void switchToFrameByIndex(WebElement element, int index) {
		driver.switchTo().frame(index);

	}

	// 51.Frame Count
	public int frameCount(WebElement elements, String tagName) {
		List<WebElement> findElements = driver.findElements(By.tagName(tagName));
		int size = findElements.size();
		System.out.println(size);
		return size;
	}

	// 52.Return From Frame
	public void returnFromFrame() {
		driver.switchTo().defaultContent();
	}

	// 53.maven excel getdata
	public void readExcelData(String sheetName, int rownum, int cellnum) throws IOException {
		File file = new File("C:\\Users\\Welcome\\eclipse-workspace\\M\\Excel\\maven.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		CellType cellType = cell.getCellType();
		switch (cellType) {
		case STRING:
			String text = cellType.toString();
			System.out.println(text);
			break;
		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				String format = dateFormat.format(dateCellValue);
				System.out.println(format);
			} else {

				double d = cell.getNumericCellValue();
				BigDecimal b = new BigDecimal(d);
				String string = b.toString();
				System.out.println(string);
				break;
			}
		}
	}

	// 54.Create New workbook and insert value in Sheet
	public String insertValueInExcelData(String fileName, int rowIndex, int cellIndex, String setValue)
			throws IOException {
		File file = new File("C:\\Users\\Welcome\\eclipse-workspace\\M\\Excel\\maven.xlsx");
		Workbook workbook = new XSSFWorkbook(fileName);
		Sheet createSheet = workbook.createSheet();
		Row createRow = createSheet.createRow(rowIndex);
		Cell createCell = createRow.createCell(cellIndex);
		createCell.setCellValue(setValue);
		FileOutputStream output = new FileOutputStream(file);
		workbook.write(output);
		return setValue;

	}

	// 55.Update value in Sheet
	public void updateExcelData(String newData, String oldData, int cellIndex, int rowIndex, String sheetName)
			throws IOException {
		File file = new File("C:\\Users\\Welcome\\eclipse-workspace\\M\\Excel\\maven.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowIndex);
		Cell cell = row.getCell(cellIndex);
		String cellValue = cell.getStringCellValue();
		if (cellValue.equals(oldData)) {
			cell.setCellValue(newData);
		}
		FileOutputStream output = new FileOutputStream(file);
		workbook.write(output);
	}

	// 56.Get the Value IN sheet
	public String ReadValueInExcelSheet(String sheetName, int rownum, int cellnum) throws IOException {
		String res = " ";

		File file = new File("C:\\Users\\Welcome\\eclipse-workspace\\M\\Excel\\maven.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		CellType cellType = cell.getCellType();
		switch (cellType) {
		case STRING:
			res = cell.getStringCellValue();
			break;
		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
				res = dateformat.format(dateCellValue);
			} else {
				double d = cell.getNumericCellValue();
				long check = Math.round(d);
				if (check == d) {
					res = String.valueOf(check);
				} else {
					res = String.valueOf(d);
				}
			}
		default:
			break;
		}
		return res;
	}

	// 56.insert value in cell
	public void insertTheValueInCell(String sheetName, int rownum, int cellnum, String value) throws IOException {

		File file = new File("C:\\Users\\Welcome\\eclipse-workspace\\M\\Excel\\maven.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rownum);
		Cell createCell = row.createCell(cellnum);
		createCell.setCellValue(value);
		FileOutputStream output = new FileOutputStream(file);
		workbook.write(output);

	}

	// 57.contains text
	public WebElement containsText(String xpath) {
		WebElement element = driver.findElement(By.xpath(xpath));
		return element;

	}

	// 58.get Text
	public String gettext(WebElement element) {
		String text = element.getText();
		return text;

	}

	// 59. clear
	public void clear(WebElement element) {
		element.clear();

	}

	public void type(WebElement element, String data) {
		element.sendKeys(data);
	}

}
