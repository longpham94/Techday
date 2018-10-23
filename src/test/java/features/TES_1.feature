Feature: 

	
	@TES-1
	Scenario: login with valid credential
		Given I open browser and navigate to the website.
		And I provide a valid credential of testcase "TES_1".
		And I click on Submit button.
		Then I should login successfully.