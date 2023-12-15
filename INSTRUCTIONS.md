## Build jar package with following command
``` mvn clean package ```

## Validate package is running ok
``` java -jar target/package-manager-1.0-SNAPSHOT.jar ``` 

## Build docker image
``` docker build --tag=package-manager:latest . ```

## Run docker image
``` docker run -p8887:8080 package-manager:latest ```

## Access the application
``` http://localhost:8887/<command> ```