#@tag
Feature: File validation in Source folder in ADH application 

Background: Successful user login with valid credentials 
	Given User is on login page 
	And user verifies Login page title 
	And user verify text on the page 
	When user types in emailaddress and password 
	Then user is navigated to project page 
	
@AddFilesOnProjectcreation
Scenario Outline: File upload in source folder
	When user selects Add Project 
	#When user selects Add Project after verifying for the projectname existence
	Then navigate to Add Project page 
	Then user enters "<project>" and "<assets>" and "<instruction>" and "<pages>" and "<customer_ID>" and "<division>" and "<department>"
	#And user click on Save and Continue button 
	Then File Repository page is displayed with "<project>" 
	
#	When user clicks on Add Files icon
#	And enters the file path onto the file-selection input field
#	And user verifies the file count in Source folder
#	Then user click on Source folder to verify the view file tab is visible
	
	Examples: 
		| project | assets | instruction|pages|customer_ID|division|department|
		| mathml3 | MathML | Testing purpose | 3 | 001 | abc | gov |
		#| mathdescription3 | Math Description | Testing purpose | 3 | 002 | def | school |
		#| mathml_mathdesc3 | MathML/Math Description | Testing purpose | 3 | 003 | ghi | sales |
		#| none |  | Testing purpose | 4 | 003 | lmn | accounts |
		
@EditProjectDetails
Scenario Outline: Editing project details
When user search for required "<project>"
Then user edits the details of project with pages and department and division and ID and inst
Then user click cancel to cancel the updates

Examples:
| project |
#| Chennai1993 |
| AutoScript |
		
@AddFilesOnSearchProject
Scenario Outline: File upload in existing project
When user search for required "<project>"
Then user upload file
And user validates and downloads the generated view file and log file 
Then user deletes the files in all folders

Examples:
| project |
| MathProject |
#| AutoScript  |
#| MathML_Desc |


@MultipleFileUpload
Scenario Outline: Multiple File upload in existing project
Then user searches for the required "<project>"
And uploads multiple file to the selected project


Examples:
| project |
| Multipleupload_simple |
#| AutoScript |


