@OrangeHRM
  Feature: Orange Check Test Cases

    @AllEmpty
    Scenario: Empty Username & Empty Password
      Given User on login page
      When Click login button
      Then Check Required  message about Username and Password

    @InvalidLogin
    Scenario: Invalid Username & Invalid Password
      Given User on login page
      When  Text Username and Password
      When  Click login button
      Then  Check Invalid Credentials message

    @ValidLogin
    Scenario: Valid Username & Valid Password
      Given User on login page
      When  Text Valid Username and Valid Password
      When  Click login button
      Then  Check Successful login

    @ChangeName
    Scenario: Change First Name & Last Name
      Given User on login page
      When  Text Valid Username and Valid Password
      When  Click login button
      Then  Check Successful login
      When  Click to my info
      When  Change Name & Surname
      When  Click to save button
      Then  Check New name and surname
