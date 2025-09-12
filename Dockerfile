# BUILD
FROM eclipse-temurin:17-jdk-alpine AS build
WORKDIR /app

# Wrapper y config
COPY gradlew gradlew
COPY gradle gradle
COPY build.gradle settings.gradle ./
RUN chmod +x gradlew && ./gradlew --no-daemon dependencies || true

# Código
COPY src src

# Build del JAR
RUN ./gradlew --no-daemon clean bootJar -x test

# RUNTIME
FROM eclipse-temurin:17-jre-alpine

# Crea grupo/usuario solo si no existen (evita choque de IDs)
RUN apk add --no-cache shadow && \
    set -eux; \
  if ! getent group appgroup >/dev/null; then groupadd -r appgroup; fi; \
  if ! id -u appuser >/dev/null 2>&1; then \
    useradd -r -g appgroup -m -d /home/appuser -s /usr/sbin/nologin appuser; \
  fi

WORKDIR /app

# Copia el JAR (usa patrón genérico si no es SNAPSHOT)
COPY --from=build /app/build/libs/*.jar /app/app.jar

# Permisos y usuario no-root
RUN chown -R appuser:appgroup /app
USER appuser:appgroup

ENV DB_USER="testEnv"
ENV DB_PASSWORD="testEnv"
ENV DB_URL="jdbc:h2:mem:testEvdDb"
EXPOSE 8080
ENTRYPOINT ["sh","-c","java $JAVA_OPTS -jar /app/app.jar"]
