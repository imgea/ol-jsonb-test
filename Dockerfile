FROM gradle:8.1-jdk17 AS build

ADD . /opt/

WORKDIR /opt/


RUN gradle clean build war -x test --no-daemon --build-cache --info \
  && mv build/libs/ROOT.war /opt/jsonb-concurrency.war


FROM open-liberty:23.0.0.10-kernel-slim-java17-openj9 AS publish


WORKDIR /opt

COPY --chown=1001:0 src/main/liberty/config/ /config/
COPY --from=build --chown=1001:0 /opt/*.war /config/apps

RUN features.sh

RUN configure.sh
