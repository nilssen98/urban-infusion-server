# Let's use Amazon Corretto as the base image. It includes a performance-optimized version of OpenJDK
FROM amazoncorretto:17.0.2

# Set a timezone to fix the timezone issue
ENV TZ=Europe/Oslo
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

# Copy the JAR file to /app.jar
COPY target/*.jar app.jar

# When the container starts, we will launch command `java -jar -Dspring.profiles.active=prod app.jar`
ENTRYPOINT ["java","-jar", "-Dspring.profiles.active=prod", "/app.jar"]

# In this project we use docker-compose tool
# To run all the services inside Docker, run the following command in the terminal:
#   docker-compose up

# NB: Before doing that you may also want to rebuild the .jar file (mvn package) and
# rebuild the docker image for the application. Either run the build command:
#   docker build -t nontnu/docker-demo

# Or rebuild the image when you start docker-compose by including the --build argument:
#   docker-compose up --build

# Rebuild just the server container without touching the DB:
#   docker-compose up --build server


# Useful options:
#  -d   Detached mode: Run containers in the background
