#@tag
Feature: Login Action in ADH application 

@login_positive 
Scenario: Successful user login with valid credentials 
	Given User in on login page 
	And verify Login page title 
	And verify text on the page 
	When user enters emailaddress and  password 
	Then user navigates to project page 
	
@login_negative 
Scenario Outline: Unsuccessful user login with invalid credentials 
	Given User in on login page 
	When user enters "<emailid>" and "<pwd>" 
	Then user should not be navigated to project page 
	And verify the "<errormessage1>" and "<errormessage2>" displayed 
	
	Examples: 
		| emailid              | pwd      | errormessage1                     | errormessage2              |
		| rincy@codemantra.in  | Rest#123 | Invalid email account or password |                            |
		#| rincy@codemantra.com | Test#123 | Invalid email account or password |                            |
		#| rincy@codemantra.in  |          | Password must not be blank		|                            |
		#|                      | Test#123 | Email must not be blank			|                            |
		#|                      |          | Email must not be blank			| Password must not be blank|
