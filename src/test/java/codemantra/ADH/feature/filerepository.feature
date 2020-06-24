#@tag
Feature: File validation in Source folder in ADH application 


Background: Successful user login with valid credentials 
	Given User is on login page 
	And user verifies Login page title 
	And user verify text on the page 
	When user types in emailaddress and password 
	Then user is navigated to project page 
	
@AddProject 
Scenario Outline: Addition of new project 
	When user clicks on Add Project 
	Then user navigates to Add Project page 
	Then user enters "<project>" 
	And user clicks on Save and Continue button 
	Then user navigates to File Repository page with "<project>" 
	
	Examples: 
		| project |
		| Madras_005 |
		
	@AddFiles
	Scenario: File upload in source folder
	When user clicks on Add Files icon
	Then user enters the file path onto the file-selection input field
	And user click the open button
	Then user verify the success message