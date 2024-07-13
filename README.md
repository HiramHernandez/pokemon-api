Prueba tecnica para evaluar backend consumiendo la API de POke API
Pasos para ejecutar
1. Instalar dependencias en raiz ejecutar `mvn install`
2. Crear el .jar ejecutar en raíz `mvn package`
3. Lanzar el proyecto en raíz ejecutar `mvn spring-boot:run` y navegar a `http://localhost:8080/swagger-ui/index.htm` y consumir los endpoints
4. Para verificar las pruebas o agregar otras: `mvn test` igualmente en raíz.
5. Ejecutar en docker: `docker build -t myorg/myapp .` y `docker run -p 8080:8080 myorg/myapp`
