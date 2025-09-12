# order-app

Este proyecto es una aplicación de gestión de órdenes desarrollada en Java con Gradle. Permite la creación, consulta y administración de órdenes, integrando buenas prácticas de arquitectura de software.

## Estructura del Proyecto

- **src/main/java/**: Código fuente principal de la aplicación.
- **src/main/resources/**: Archivos de configuración y recursos.
- **src/test/**: Pruebas unitarias e integración.
- **build.gradle**: Archivo de configuración de Gradle.
- **Dockerfile**: Permite la construcción de la imagen Docker de la aplicación.
- **docker-compose.yaml**: Orquestación de servicios para desarrollo y pruebas.
- **k8s/**: Archivos de despliegue para Kubernetes.

## Requisitos Previos

- Java 17 o superior
- Gradle 7.x
- Docker (opcional, para despliegue en contenedores)
- Kubernetes (opcional, para despliegue en clúster)

## Instalación y Ejecución

### 1. Clonar el repositorio

```bash
git clone https://github.com/cesbersi/unisabana-final-as.git
cd order-app
```

### 2. Compilar el proyecto

```bash
./gradlew build
```

### 3. Ejecutar la aplicación

```bash
./gradlew bootRun
```

La aplicación estará disponible en `http://localhost:8080`.

### 4. Ejecutar pruebas

```bash
./gradlew test
```

## Despliegue con Docker

```bash
docker build -t order-app:latest .
docker run -p 8080:8080 order-app:latest
```

## Despliegue con Docker Compose

```bash
docker-compose up --build
```

## Despliegue en Kubernetes

Aplicar los manifiestos en la carpeta `k8s/`:

```bash
kubectl apply -f k8s/
```

## Configuración

La configuración se encuentra en `src/main/resources/application.yaml` y otros archivos en la misma carpeta.

## Pruebas y Cobertura

- Los reportes de pruebas y cobertura se generan en la carpeta `build/reports/`.
- Para ver la cobertura de código, abrir `build/reports/jacoco/test/html/index.html`.

## Estructura de Paquetes

- `com.uni.sabana.diplomado.arquitectura.finalizacion`: Paquete base.
- Subpaquetes para aplicación, dominio, infraestructura, excepciones, etc.

## Contacto

Para dudas o soporte, contactar a los desarrolladores del proyecto.

