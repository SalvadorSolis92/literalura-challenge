# LiterAlura

Este es un proyecto de ejemplo en Spring Boot llamado `LiterAlura`. Creado durante el curso de Alura Latam, se desarrolló un Catálogo de Libros que ofrece interacción textual (vía consola) con los usuarios, proporcionando 5 opciones de interacción. Los libros se buscarán a través de la API Gutendex (JSON web API for Project Gutenberg ebook metadata). 

## Las opciones disponibles son
- 1 - Buscar libro por título
- 2 - Listar libros registrados
- 3 - Listar autores registrados
- 4 - Listar autores vivos en un año determinado
- 5 - Listar libros por idioma
- 0 - Salir

A continuación, se detallan los pasos para configurar, construir y ejecutar el proyecto.

## Requisitos

- **Java**: JDK 17 o superior
- **Maven**: 3.6.3
- **Spring Boot**: 3.2.6
- **PostgreSQL**: 14.12

## Configuración de Versiones

### Java

Asegúrate de que tu entorno tenga configurado el JDK adecuado. Puedes verificar tu versión de Java con el siguiente comando:

```sh
java -version
```

## Construcción del Proyecto
Para construir el proyecto, navega hasta el directorio raíz del proyecto y ejecuta el siguiente comando:
```sh
mvn clean install
```

## Ejecución del Proyecto
Después de construir el proyecto, puedes ejecutarlo utilizando el siguiente comando:
```sh
mvn spring-boot:run
```

Alternativamente, puedes ejecutar el archivo JAR generado en el directorio target:
```sh
java -jar target/literalura-0.0.1-SNAPSHOT.jar
```
## Estructura del Proyecto
La estructura básica del proyecto es la siguiente
```css
proyectitospring
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── alura
│   │   │           └── literalura
│   │   │               ├── LiteraluraApplication.java
│   │   │               └── principal
│   │   │                   └── Principal.java
│   │   └── resources
│   │       ├── application.properties
│   │       └── static
│   │       └── templates
├── target
├── .gitignore
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md
```

## Configuración de Propiedades
Puedes configurar las propiedades de la aplicación en el archivo src/main/resources/application.properties. Por ejemplo:
```properties
server.port=8080
spring.datasource.url=jdbc:postgresql://localhost:3306/mydb
spring.datasource.username=root
spring.datasource.password=root
```