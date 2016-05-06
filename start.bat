setx POSTGRES_URL "jdbc:postgresql://127.0.0.1:5432/orderserver"
setx POSTGRES_PASSWORD "postgres" 
setx POSTGRES_USERNAME "postgres"

java -jar target\orderserver-1.0-SNAPSHOT.jar

pause