instructions to set up application in linux enviroment 

1.Check out app
----------------------------------
 1. check out application from 
    https://gitlab-cts.stackroute.in/Adarsh.GUnnithan/movie-cruiser.git

2.Setup backend app
----------------------------------
1. naviagate to movie-cruiser/backend
2. execute source ./env.sh to set enviroment varibles
3. on same terminal execute mvn clean install
4. on same terminal navigate to target folder
5. on same terminal, for running application use java -jar movie-cruiser-0.0.1-SNAPSHOT.jar

3.Setup Security server
----------------------------------
1. naviagate to movie-cruiser/security-sso
2. execute source ./env-variable.sh to set enviroment varibles
3. on same terminal execute mvn clean install
4. on same terminal navigate to target folder
5. on same terminal ,for running application use java -jar security-sso-0.0.1-SNAPSHOT.jar

4. Set up front end
----------------------------------
1. navigate to movie-cruiser/frontend/movie-cruiser-ui
2. do npm install
3. do ng build
4.  do ng serve

5. For execute e2e UI test cases
----------------------------------
1.  navigate to movie-cruiser/frontend/movie-cruiser-ui
2.  do npm install
3.  do ng build
4.  kill process in port 4200, if 4200 is already in use
5.   execute ng e2e --port 4200






