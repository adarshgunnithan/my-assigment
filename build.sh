cd security-sso
source ./env-variable.sh
mvn clean install -Dmaven.test.skip=true

cd ..
cd backend
source ./env-variable.sh
mvn clean package

cd ..
