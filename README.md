# Dmoney-API-Automation-With-Rest-Assured
## About Dmoney
Dmoney is a demo financial related project. where fake money can be transferred. In this project i have automate the D-money api using Rest Assured.
## About this project:
## API's from this Collection: https://api.postman.com/collections/1844288-143eb923-423f-4c91-a198-fe6e56d20e35?access_key=PMAT-01GJ3CC22Q0066PJWP3T0XHQ8G
## Here I automate the following Steps:
1. Do Login by admin
2. Create 2 new customers and a agent
3. Give 2000 tk from System account to the newly created agent
4. Deposit 1500 tk to a customer from the agent account
5. Withdraw 500 tk by the customer to the agent
6. Send money 500 tk to another customer
7. Payment 100 tk to a merchant (01686606905) by the recipient customer
8. Check balance of the recipient customer
   
## Tools & Technology used:
- Language: Java
- Build Tool: Gradle
- IDE: Intellij IDEA
 
 ## Dependencies
- rest-assured
- testng
- commons-configuration
- jackson-databind
- javafaker
- json-simple
- allure-testng

## How to run this project: 
- Clone this project
- follow this instruction:
- ```  build.gradle ```
- ``` open it on Intellij IDE as project ```
  
## Open Terminal Follow that Command:
- ``` gradle clean test ```
- ``` allure generate allure-results --clean -output ```
- ``` allure serve allure-results ```
  
## Allure Reports:
![screencapture-192-168-1-100-1839-index-html-2023-10-21-18_11_29](https://github.com/fahimmahatab/Dmoney-API-Automation-With-Rest-Assured/assets/43899673/a19f3008-77a5-43ab-ac73-b371c27a3c19)
![screencapture-192-168-1-100-1839-index-html-2023-10-21-18_12_11](https://github.com/fahimmahatab/Dmoney-API-Automation-With-Rest-Assured/assets/43899673/30721127-0689-4a26-83f6-214f93f5123c)

## Thanks for Visit.
