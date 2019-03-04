# Selenium_training

## Examples of selenium with POM pattern

### Resources
- Selenium 3.141.59
- jUnit 3
- Firefox 42.0

## TestCase 
There's a file called TC_01_Login_Facebok, has a little test case

## Full tree of the project
- Data: Dir to save an external file with the info needed to our test cases, it is an excel file
- Driver: Dir to save each driver you need to each browser
- src_page: Dir with all the java classes
- src_util: Dir with the utilities to set the enviroment of our project,for example the call to the excel file or DB connection


## POM(Page Object Model)
For this pattern we take every part(Section, menu, module) fo the page like an object, our source folder will have the follow structure:

- PageObjects
  - All the objects of each part of the page, our mainly element will be the Web Driver to reach each element of the page, and we're going to have getters to reach inputs, linktext, buttons, etc.
- Actions
  - All the validations, verifications, assertions using jUnit. We need to declare our methods like the name of the dir says: actions, that we are going to use in the next level
- TestCases
  - All the steps of each test case that we wrote on the actions class
- TestSuite
  - Our "Main" with all the test cases we need to run to do the full test

