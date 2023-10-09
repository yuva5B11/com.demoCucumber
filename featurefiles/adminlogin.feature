#Author: Yuvaraj
@tag
Feature: OrangeHRMS Admin Login
  I want to use this template to chjeck Admin Login Functionality

  @tag1
  Scenario: Admin Login with Valid Data
    Given i open browser with url "http://orangehrm.qedgetech.com/"
		Then i should see login page
		When i enter username as "Admin"
		And i enter password as "Qedge123!@#"
		And i click login button
		Then i should see Admin module
		When i click logout
		Then i should see login page
		When i close browser 
	
	@tag2
	Scenario Outline: Admin Login with Invalid Credentials
		Given i open browser with url "http://orangehrm.qedgetech.com/"
		Then i should see login page
		When i enter username as "<userId>"
		And i enter password as "<password>"
		And i click login button
		Then i should get login error
		When i close browser
		
		Examples:
			|userId|password|
			|Admin|sdkjf|
			|sdjhfi|Qedge123!@#|
			|dfhg|dfkgfdkjh|
