FROM openjdk:17
#COPY dataset/GOOG_MAX.csv GOOG_MAX.csv
COPY target/LocalStorageMarketData-0.0.1-SNAPSHOT.jar LocalStorageMarketData-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/LocalStorageMarketData-0.0.1-SNAPSHOT.jar"]