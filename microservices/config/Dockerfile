FROM java:8-jre
MAINTAINER Baasanbat Purevjal <baasanbatp@gmail.com>
ENV SET_CONTAINER_TIMEZONE true
ENV CONTAINER_TIMEZONE Asia/Ulaanbaatar
ENV TZ Asia/Ulaanbaatar
ADD ./target/config.jar /app/

CMD ["java", "-Xmx256m", "-jar", "/app/config.jar"]

HEALTHCHECK --interval=30s --timeout=30s CMD curl -f http://localhost:80/actuator/health || exit 1

EXPOSE 80