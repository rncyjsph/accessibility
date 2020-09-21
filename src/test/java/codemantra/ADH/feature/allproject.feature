##@tag
#Feature: File validation in Source folder in ADH application 
#
#
#Background: Successful user login with valid credentials 
#	Given User is on login page 
#	And user verifies Login page title 
#	And user verify text on the page 
#	When user types in emailaddress and password 
#	Then user is navigated to project page 
#	
#@AddProject 
#Scenario Outline: Addition of new project 
#	When user clicks on Add Project 
#	Then user navigates to Add Project page 
#	Then user enters "<project>" and "<assets>" and "<instruction>" and "<pages>" and "<customer_ID>" and "<division>" and "<department>"
#	And user clicks on Save and Continue button 
#	Then user navigates to File Repository page with "<project>" 
#	
#	Examples: 
#		| project |assets|instruction|pages|customer_ID|division|department|
#		| mathml | MathML | Testing purpose | 3 | 001 | abc | gov |
#	#	| mathdescription | Math Description | Testing purpose | 3 | 002 | def | school |
#	#	| mathml_mathdesc | MathML/Math Description | Testing purpose | 3 | 003 | ghi | sales |
#	#	| none |  | Testing purpose | 4 | 003 | lmn | accounts |
#		
#		
#		
#		@Savebtn_Cancelbtn_EnableCheck 
#		Scenario Outline: 
#			Checking if Save and Continue button is disabled and Cancel button is enabled on Add Projects page 
#			When user clicks on Add Project 
#			Then user navigates to Add Project page 
#			When user selects "<assets>" asset 
#			And user enters "<instruction>" and "<pages>" and "<customer_ID>" and "<division>" and "<department>" 
#			Then press cancel button if Save and Continue button is disabled
#			
#						
#			Examples: 
#				|assets|instruction|pages|customer_ID|division|department|
#				|MathML|Test in progress|10|001|abc|testing|
#				|Math Description|Test2|20|002|def|development|
#				|MathML/Math Description|Test3|30|003|ghi|support|
#				|None|Test4|40|004|jkl|admin|
