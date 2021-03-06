## World Population Project
- First of all, here you can generate four kind of reports which concern about City, Country, Capital and Population.
- First three reports are about rankings by descending population values and last report for accessibiltiy and language criteria. 

## Software Engineering Methods

- Master Build Status [![Build Status](https://travis-ci.com/Team-3-DevOps/coursework.svg?branch=master)](https://travis-ci.com/Team-3-DevOps/coursework)
- Develop Build Status [![Build Status](https://travis-ci.com/Team-3-DevOps/coursework.svg?branch=master)](https://travis-ci.com/Team-3-DevOps/coursework)
- Code Coverage of tests for Master [![Codecov branch](https://img.shields.io/codecov/c/github/Team-3-DevOps/coursework/master?style=plastic&logo=Codecov)](https://img.shields.io/codecov/c/github/Team-3-DevOps/coursework)
- License [![LICENSE](https://img.shields.io/github/license/Team-3-DevOps/coursework.svg?)](https://github.com/Team-3-DevOps/coursework/blob/master/LICENSE)
- Release [![Releases](https://img.shields.io/github/release/Team-3-DevOps/coursework/all.svg?style=plastic)](https://github.com/Team-3-DevOps/coursework/releases)

### Prerequisites
* IntelliJ IDEA [Get here!](https://www.jetbrains.com/)
* DOCKER [Get here!](https://hub.docker.com/)
* MYSQL [Get here!](https://dev.mysql.com/downloads/installer/)
* JAVA:latest [Get here!](https://www.oracle.com/technetwork/java/javase/downloads/index.html)
* Git for version control [Get here!](https://git-scm.com/downloads)
* Travis for continous integration [Visit there!](https://travis-ci.com/)
* (codecov.io) for code coverage and testing [What is it?](https://codecov.io/)

### How to run? Just follow below instructions properly!
### Database Setup
* Firstly, make sure docker connected with your IntelliJ IDEA and Got to the image section of docker
* Right click on that and pull world database by name of "kevinchalmers/world"
* Once it is done downloading, right click on that downloaded image and choose 'create container' and click "Create"
* At the pop-up dialog box, put this (**-e MYSQL_ROOT_PASSWORD=t3devops -p 33060:3306**) at __run options box__. 
* Then click "Apply and Run" and wait for the database ready for connection. 

### Maven Process
* IntelliJ can detect maven plugins. You can found it at the right top conor of IDEA. if you don't, not a problem.
* So, once you have cloned the whole project, IntelliJ will ask you to enable auto-import maven module.
* Now, You can see Maven panel at this point.

### Building the project
* Run Maven Build at maven panel by clicking green arrow button. 
* Then scroll down **Lifecycle** and **compile project** and the last run **package** to packaging your app. 
* At this point, your project **jar** file should be generated at target folder within your project folder
* ({Driveletter}:\{$foldername}\coursework\target>coursework.jar) 

### Run the project 
* Open your **cmd** as an administrator  
* Change your working directory to this **{Driveletter}:\{$foldername}\{$projectname}\target\**
* Run ***coursework.jar*** file by executing this command ***java -jar coursework.jar***

***ENJOY then, BEST OF LUCK. PEACE OUT!!!***

### REQUIREMENT MET
| ID | Name | Met | Screenshot | 
| -- |:--------:|:-----------:|:------------:|
| 1 | All the countries in the world organised by largest population to smallest | yes | [Check](https://github.com/Team-3-DevOps/coursework/blob/master/screenshots/Screenshot%20(1).png) | 
| 2 | All the countries in a continent organised by largest population to smallest | yes| [Check](https://github.com/Team-3-DevOps/coursework/blob/master/screenshots/Screenshot%20(2).png) | 
| 3 | All the countries in a region organised by largest population to smallest. | yes| [Check](https://github.com/Team-3-DevOps/coursework/blob/master/screenshots/Screenshot%20(3).png) | 
| 4 | The top N populated countries in the world where N is provided by the user | yes| [Check](https://github.com/Team-3-DevOps/coursework/blob/master/screenshots/Screenshot%20(4).png) | 
| 5 | The top N populated countries in a continent where N is provided by the user | yes| [Check](https://github.com/Team-3-DevOps/coursework/blob/master/screenshots/Screenshot%20(5).png) | 
| 6 | The top N populated countries in a region where N is provided by the user | yes| [Check](https://github.com/Team-3-DevOps/coursework/blob/master/screenshots/Screenshot%20(6).png) | 
| 7 | All the cities in the world organised by largest population to smallest | yes| [Check](https://github.com/Team-3-DevOps/coursework/blob/master/screenshots/Screenshot%20(7).png) | 
| 8 | All the cities in a continent organised by largest population to smallest | yes| [Check](https://github.com/Team-3-DevOps/coursework/blob/master/screenshots/Screenshot%20(8).png) | 
| 9 | All the cities in a region organised by largest population to smallest | yes| [Check](https://github.com/Team-3-DevOps/coursework/blob/master/screenshots/Screenshot%20(9).png) | 
| 10 | All the cities in a country organised by largest population to smallest | yes| [Check](https://github.com/Team-3-DevOps/coursework/blob/master/screenshots/Screenshot%20(10).png) | 
| 11 | All the cities in a district organised by largest population to smallest | yes| [Check](https://github.com/Team-3-DevOps/coursework/blob/master/screenshots/Screenshot%20(11).png) | 
| 12 | The top N populated cities in the world where N is provided by the user | yes| [Check](https://github.com/Team-3-DevOps/coursework/blob/master/screenshots/Screenshot%20(12).png) | 
| 13 | The top N populated cities in a continent where N is provided by the user | yes| [Check](https://github.com/Team-3-DevOps/coursework/blob/master/screenshots/Screenshot%20(13).png) | 
| 14 | The top N populated cities in a region where N is provided by the user | yes| [Check](https://github.com/Team-3-DevOps/coursework/blob/master/screenshots/Screenshot%20(14).png) | 
| 15 |The top N populated cities in a country where N is provided by the user | yes| [Check](https://github.com/Team-3-DevOps/coursework/blob/master/screenshots/Screenshot%20(15).png) | 
| 16 | The top N populated cities in a district where N is provided by the user | yes| [Check](https://github.com/Team-3-DevOps/coursework/blob/master/screenshots/Screenshot%20(16).png) | 
| 17 | All the capital cities in the world organised by largest population to smallest.| yes| [Check](https://github.com/Team-3-DevOps/coursework/blob/master/screenshots/Screenshot%20(17).png) | 
| 18 | All the capital cities in a continent organised by largest population to smallest| yes| [Check](https://github.com/Team-3-DevOps/coursework/blob/master/screenshots/Screenshot%20(18).png) |
| 19 |All the capital cities in a region organised by largest to smallest | yes| [Check](https://github.com/Team-3-DevOps/coursework/blob/master/screenshots/Screenshot%20(19).png) | 
| 20 | The top N populated capital cities in the world where N is provided by the user | yes| [Check](https://github.com/Team-3-DevOps/coursework/blob/master/screenshots/Screenshot%20(20).png) | 
| 21 | The top N populated capital cities in a continent where N is provided by the user | yes| [Check](https://github.com/Team-3-DevOps/coursework/blob/master/screenshots/Screenshot%20(21).png) | 
| 22 | The top N populated capital cities in a region where N is provided by the user| yes| [Check](https://github.com/Team-3-DevOps/coursework/blob/master/screenshots/Screenshot%20(22).png) | 
| 23 | The population of people, people living in cities, and people not living in cities in each continent| yes| [Check](https://github.com/Team-3-DevOps/coursework/blob/master/screenshots/Screenshot%20(23).png) | 
| 24 | The population of people, people living in cities, and people not living in cities in each region| yes| [Check](https://github.com/Team-3-DevOps/coursework/blob/master/screenshots/Screenshot%20(24).png) | 
| 25 |The population of people, people living in cities, and people not living in cities in each country| yes| [Check](https://github.com/Team-3-DevOps/coursework/blob/master/screenshots/Screenshot%20(25).png) | 
| 26 | The population of the world| yes| [Check](https://github.com/Team-3-DevOps/coursework/blob/master/screenshots/Screenshot%20(26).png) | 
| 27 | The population of a continent | yes| [Check](https://github.com/Team-3-DevOps/coursework/blob/master/screenshots/Screenshot%20(27).png) | 
| 28 | The population of a region | yes| [Check](https://github.com/Team-3-DevOps/coursework/blob/master/screenshots/Screenshot%20(28).png) | 
| 29 | The population of a country| yes| [Check](https://github.com/Team-3-DevOps/coursework/blob/master/screenshots/Screenshot%20(29).png) | 
| 30 | The population of a district | yes| [Check](https://github.com/Team-3-DevOps/coursework/blob/master/screenshots/Screenshot%20(30).png) | 
| 31 |The population of a city | yes| [Check](https://github.com/Team-3-DevOps/coursework/blob/master/screenshots/Screenshot%20(31).png) | 
| 32 |people who speak the following the following languages from greatest number to smallest, including the percentage of the world population: Chinese, English, Hindi, Spanish, Arabic | yes| [Check](https://github.com/Team-3-DevOps/coursework/blob/master/screenshots/Screenshot%20(32).png) | 




