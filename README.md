# hotlineProject
For test execution at local machine:
- clone repository: https://github.com/Museua/hotlineProject
- in root project directory run command be terminal: mvn clean test
    - run test with custom browser use next command: mvn test -P {browser_name}

Aditional config for choosing browser for IDE run: config.properties
For report generation execute command by terminal at root directory: allure generate allure-results