# backend-finalprocject
Backend for bootcamp final project - web store for selling cell phones
In order to run project please follow the instructions below:

BACKEND:
git clone https://github.com/martaProsniak/backend-finalprocject.git
cd docker
sudo docker-compose up -d
cd ..
mvn clean install 
cd target
java -jar finalProject-0.0.1-SNAPSHOT.jar

FRONTEND:
git clone https://github.com/martaProsniak/frontend-finalproject.git
npm install -g @angular/cli
ng serve --open //will open your web browser on localost:4200
