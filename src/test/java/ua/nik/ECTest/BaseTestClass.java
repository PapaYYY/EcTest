package ua.nik.ECTest;

import static com.codeborne.selenide.Selenide.open;

import org.testng.annotations.*;
import com.codeborne.selenide.Configuration;
import ua.PageObjects.BasePage;
import ua.PageObjects.BoardsPage;
import ua.PageObjects.PhotosPage;

public class BaseTestClass {

	BasePage basePage = new BasePage();
	BoardsPage boardsPage = new BoardsPage();
	PhotosPage photosPage;

	@BeforeTest (alwaysRun = true)
	public void initializeTest() {
		//		Configuration.browser="chrome";
		Configuration.timeout=5000;
		open("http://istockphoto.com");
	}
}
