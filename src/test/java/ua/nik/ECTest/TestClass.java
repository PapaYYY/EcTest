package ua.nik.ECTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class TestClass extends BaseTestClass {

	String randomBoardName = Helper.getRandomNameFor("Board");

	@Test (groups = {"functional", "all"})
	public void TestCrossFunctionality() {

		/*User should have no boards before running this test*/

		//login app
		basePage.login("kolya.may@gmail.com", "Password1");

		//create board
		basePage.createBoardForUserWithoutBoards(randomBoardName, "Some description for testing");

		//checking that board is created
		boardsPage.checkThatBoardWIthNameIsVisisble(randomBoardName);

		//go to Photos
		photosPage = basePage.goToPhotosPage();

		//open photos topic
		photosPage.openPhotosTopic("Couple Photos");

		//selecting and adding photo to board
		photosPage.addPhotoWithNumberToBoardWithName(2 , randomBoardName);

		//check number of added photos
		$(byXpath("//div[@class=\"board-item-content\"]")).shouldBe(visible);
		Assert.assertTrue(!boardsPage.getListOfPhotosOnCurrentBoard().isEmpty());

		//select all photos and delete them
		boardsPage.selectAndDeleteAllPhotosFromCurrentBoard();

		//checking that all photos are deleted
		$(byText("Select all")).shouldNotBe(visible);

		//deleting current board
		boardsPage.deleteCurrentBoard();

		//checkin that board is deleted
		$(byText("Collect what you love. Start with a search.")).shouldBe(visible);

		//sign out
		basePage.signOut();
	} 
}
