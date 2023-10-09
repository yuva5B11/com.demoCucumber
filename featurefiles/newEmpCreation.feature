#Author: your.email@your.domain.com

Feature: New Emp creation
		I want to use this template for my feature file
	@tag1
		Scenario: New employee creation
		Given i open browser with url "http://orangehrm.qedgetech.com/"
		Then i should see login page
		When i enter username as "Admin"
		And i enter password as "Qedge123!@#"
		And i click login button
		Then i should see Admin module
		When i go to add employee page
		And i enter firstname as "Nani"
		And i enter lastname as "test1"
		And i click Save
		Then i should see newly created employee in EmployeeList
		When i click logout
		Then i should see login page
		When i close browser 
