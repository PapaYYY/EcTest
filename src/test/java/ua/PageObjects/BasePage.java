package ua.PageObjects;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selectors.*;

public class BasePage {

	//xpath section
	String xPathLogOut = "//a[@id=\"hypSignOut\"]";
	String xPathAccount = "//li[text()='Account']";

	public void login(String user, String password) {
		$(byText("Sign in")).click();
		$("#new_session_username").setValue(user);
		$("#new_session_password").setValue(password);
		$("#sign_in").click(); 
	}

	public void createBoardForUserWithoutBoards(String boardName, String description) {
		$("#open_board").click();
		$(byXpath("//input[@name='boardname']")).setValue(boardName);
		$(by("placeholder","Board description (optional)")).setValue(description);
		$(byText("Create")).click();
	}

	public void createBoardForUserWithBoards(String boardName, String description) {
		$("#open_board").click();
		$(by("board-id-getter-setter", "boardPickerSelection")).click();
		$(byText("Create a Board")).click();
		$(by("name","boardname")).setValue(boardName);
		$(by("placeholder","Board description (optional)")).setValue(description);
		$(byText("Create")).click();
	}

	public PhotosPage goToPhotosPage() {
		$(by("data-nav", "nav=nav_Photos")).click();
		return new PhotosPage();
	}

	public void signOut() {
		$(byXpath(xPathAccount)).click();
		$(byXpath(xPathLogOut)).click();
	}
}
