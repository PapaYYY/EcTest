package ua.PageObjects;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

import com.codeborne.selenide.ElementsCollection;

public class PhotosPage extends BasePage {

	//xpath section
	String listOfFlagsForPhotosXpath = "//section[@class=\"board-details\"]//label";

	public void openPhotosTopic(String topicName) {
		$(byXpath("//figcaption[text()[contains(., '"+topicName+"')]]")).click();
	}

	public void addPhotoWithNumberToBoardWithName(int number, String boardName) {
		ElementsCollection listOfFlags =  $$(byXpath(listOfFlagsForPhotosXpath));
		listOfFlags.get(number).click();
		$(byText("Choose an option")).click();
		$(byText("Copy to Board")).click();
		$(byText(boardName)).shouldBe(visible);
		$(byXpath("//a[text()="+"\""+boardName+"\""+"]")).click();
	}
}
