# GroupProject-Account
The purpose of the account micro service is to perform various methods to do with the accounts in our application. It encrypts the passwords, checks if the account information is valid, checks whether accounts already exist with the same credentials and also checks logins. 

# Training Planner
The overall project is a web application which solves an issue with the current system of planning training withing the QA academy. Each of the microservices for the project is availible on this GitHub(RochQA) and all of the microservices will be needed for the appliccatin to run properly. These microservices can be launched from Spring Tool Suite or using the following command from the terminal in each services folder;
```
mvn spring-boot:run
```
## Microservices:
- [GATEWAY](https://github.com/RochQA/GroupProject-Gateway)
- [ACCOUNT](https://github.com/RochQA/GroupProject-Account)
- [PLAN](https://github.com/RochQA/GroupProject-Plan)
- [TRAINER](https://github.com/RochQA/GroupProject-Trainer)
- [GETTER](https://github.com/RochQA/GroupProject-Getter)
- [DISCSERV](https://github.com/RochQA/GroupProject-DiscServ)

## Front-End:
The front-end of the application has been developed using React.js, it provides a clean and easy to use interface for users. It can be launched from the command line using the following commands from the terminal in repository folder;
```
npm install -g start-react-app
npm start
```
**In order to properly run the application you will need to have the following installed on the machine you are running from:**
- **[Node](https://www.guru99.com/download-install-node-js.html)**
- **[Java](https://www.java.com/en/download/)**
- **[Maven](https://www.baeldung.com/install-maven-on-windows-linux-mac)**
