# Getting Started

<p align="center">
    <img src="https://img.shields.io/badge/Java-v1.11-orange.svg" />
    <img src="https://img.shields.io/badge/contributions-welcome-orange.svg" />
</p>

### Master Pom
Micro service бүр энэд дэд модуль болоод явна. Ингэхдээ сервисүүдийн помуудын парент пом нь энэ пом байна.

* системийг асаахдаа: docker-composer -d up

### ELK Stack Docker ###

### DOCKER ###

* ELK Docker stack асаахдаа: docker-compose -f "docker-compose-elk.yml" -f "docker-compose-app.yml" up --build -d*


### Нэмэлтээр хийх ажилууд ###

* Header data search  query section
* Jaeger golang based tool ашиглан Sleuth connection хийх боломжтой байдаг ба Zipkin ээс илүү олон давуу талтай юм байна.


https://tracing.cloudnative101.dev/docs/lab-jaeger-java.html
