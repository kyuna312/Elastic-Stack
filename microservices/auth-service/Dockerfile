FROM java:8-jre
MAINTAINER Baasanbat Purevjal <baasanbatp@gmail.com>
ENV SET_CONTAINER_TIMEZONE true
ENV CONTAINER_TIMEZONE Asia/Ulaanbaatar
ENV TZ Asia/Ulaanbaatar
ADD ./target/auth-service.jar /app/
CMD ["java", "-Xmx256m", "-jar", "/app/auth-service.jar"]

EXPOSE 80