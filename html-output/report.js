$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("D:/ADH_Workspace/codemantra.ADH/src/test/java/codemantra/ADH/feature/filerepository.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#@tag"
    }
  ],
  "line": 2,
  "name": "File validation in Source folder in ADH application",
  "description": "",
  "id": "file-validation-in-source-folder-in-adh-application",
  "keyword": "Feature"
});
formatter.background({
  "line": 5,
  "name": "Successful user login with valid credentials",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 6,
  "name": "User is on login page",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "user verifies Login page title",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "user verify text on the page",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "user types in emailaddress and password",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "user is navigated to project page",
  "keyword": "Then "
});
formatter.match({
  "location": "AllProjectsSteps.user_is_on_login_page()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "AllProjectsSteps.user_verifies_Login_page_title()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "AllProjectsSteps.user_verify_text_on_the_page()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "AllProjectsSteps.user_types_in_emailaddress_and_password()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "AllProjectsSteps.user_is_navigated_to_project_page()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "line": 25,
  "name": "File upload in source folder",
  "description": "",
  "id": "file-validation-in-source-folder-in-adh-application;file-upload-in-source-folder",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 24,
      "name": "@AddFiles"
    }
  ]
});
formatter.step({
  "line": 26,
  "name": "user clicks on Add Files icon",
  "keyword": "When "
});
formatter.step({
  "line": 27,
  "name": "user enters the file path onto the file-selection input field",
  "keyword": "Then "
});
formatter.step({
  "line": 28,
  "name": "user click the open button",
  "keyword": "And "
});
formatter.step({
  "line": 29,
  "name": "user verify the View file button is generated",
  "keyword": "Then "
});
formatter.step({
  "line": 30,
  "name": "user verfiy the file count under source folder",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
});