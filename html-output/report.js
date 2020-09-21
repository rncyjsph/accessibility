$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/codemantra/ADH/feature/filerepository.feature");
formatter.feature({
  "name": "File validation in Source folder in ADH application",
  "description": "",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "File upload in existing project",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@AddFilesOnSearchProject"
    }
  ]
});
formatter.step({
  "name": "user search for required \"\u003cproject\u003e\"",
  "keyword": "When "
});
formatter.step({
  "name": "user uploads files and verifies the file count in source folder",
  "keyword": "Then "
});
formatter.step({
  "name": "user validates the generated view file and generated notification",
  "keyword": "And "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "project"
      ]
    },
    {
      "cells": [
        "AutoScript"
      ]
    }
  ]
});
formatter.background({
  "name": "Successful user login with valid credentials",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "User is on login page",
  "keyword": "Given "
});
formatter.match({
  "location": "FileRepoSteps.user_is_on_login_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user verifies Login page title",
  "keyword": "And "
});
formatter.match({
  "location": "FileRepoSteps.user_verifies_Login_page_title()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user verify text on the page",
  "keyword": "And "
});
formatter.match({
  "location": "FileRepoSteps.user_verify_text_on_the_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user types in emailaddress and password",
  "keyword": "When "
});
formatter.match({
  "location": "FileRepoSteps.user_types_in_emailaddress_and_password()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user is navigated to project page",
  "keyword": "Then "
});
formatter.match({
  "location": "FileRepoSteps.user_is_navigated_to_project_page()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "File upload in existing project",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@AddFilesOnSearchProject"
    }
  ]
});
formatter.step({
  "name": "user search for required \"AutoScript\"",
  "keyword": "When "
});
formatter.match({
  "location": "FileRepoSteps.user_search_for_required(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user uploads files and verifies the file count in source folder",
  "keyword": "Then "
});
formatter.match({
  "location": "FileRepoSteps.user_uploads_files_and_verifies_the_file_count_in_source_folder()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user validates the generated view file and generated notification",
  "keyword": "And "
});
formatter.match({
  "location": "FileRepoSteps.user_verifies_the_generated_view_file_and_generated_notification()"
});
formatter.result({
  "status": "passed"
});
});