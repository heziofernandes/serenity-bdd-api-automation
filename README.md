# serenity-bdd-api-automation
POC using Serenity BDD - Rest Assured - Cucumber.💻

## Integrations
## CI ✅
This project is an integrated with a continuous integration tool for feedback on improvements and test execution, a new build is launched for each commit on the main branch. <br/> <br/>

[![pipeline status](https://gitlab.com/heziofernandes/serenity-bdd-api-automation/badges/main/pipeline.svg)](https://gitlab.com/heziofernandes/serenity-bdd-api-automation/-/commits/main)

## Project based on the fundamentals of API testing, validating some endpoints of Spotify API.
Making calls to the endpoints below validating cover positive and negative scenarios.
* Album
* Artist
* Categories
* Track

## The purpose of this project was to evaluate the tools, considering the following aspects:
* Working CI/CD with artifacts
* Use BDD
* Clean code
* Coverage of testing

## Tech stack
* Serenity BDD
* Rest Assured
* Cucumber
* JUnit
* Gradle

An authentication mechanism was implemented to generate a new authentication token when it expires, the generation key for a new token is being passed through an environment variable in the CI. 🔒

## Setup
Install the dependencies: <br/>
Make sure that [JDK](https://www.oracle.com/pt/java/technologies/javase/javase-jdk8-downloads.html) is installed <br/>
Have installed an IDE of your like <br/>
Navigate to the root of the repo <br/>
#### Gradle 🚀
``` bash
gradle test
```
To check the test report, after running the solution, navigate to:
#### Test Results ✔️
``` bash
target/site/serenity/index.html
```
