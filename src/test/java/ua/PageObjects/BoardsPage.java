package ua.PageObjects;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.confirm;

import com.codeborne.selenide.ElementsCollection;

public class BoardsPage extends BasePage {

	//xpath section
	String xPathForPhotoblocks = "//div[@class=\"board-item-content\"]";

	public void checkThatBoardWIthNameIsVisisble(String name) {
		$(by("board-id-getter-setter", "boardPickerSelection")).click();
		$(byText(name)).shouldBe(visible);
	}

	public ElementsCollection getListOfPhotosOnCurrentBoard() {
		ElementsCollection listOfPhotos = $$(byXpath(xPathForPhotoblocks));
		return listOfPhotos;
	}

	public void selectAndDeleteAllPhotosFromCurrentBoard() {
		$(byText("Select all")).click();
		$(by("title", "Remove from Board")).click();
	}

	public void deleteCurrentBoard() {
		$(byText("Delete this Board")).click();
		confirm("Are you sure you want to delete this Board?");
	}
}
