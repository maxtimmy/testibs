# Запуск Stub Service

Этот сервис — простая заглушка на Spring Boot, принимающая POST-запросы и возвращающая заданное количество объектов.

## Требования

* Java 17+ (JDK)
* Maven 3.6+
* (Опционально) Docker & Docker Compose

## Сборка и запуск локально


   ```bash
   cd stub-service
   ```

   ```bash
   mvn clean package -DskipTests
   ```

   ```bash
   java -jar target/stub-demo-0.0.1-SNAPSHOT.jar
   ```

   По умолчанию  порт **8080**.

## Проверка работы

В другом терминале выполните:

```bash
curl -X POST \
  -H "Content-Type: application/json" \
  -d '{"count":3}' \
  http://localhost:8080/test
```

ответ

```json
{
  "data": [
    { "firstname": "FirstName-1", "lastname": "LastName-1", "id": "<UUID>" },
    { "firstname": "FirstName-2", "lastname": "LastName-2", "id": "<UUID>" },
    { "firstname": "FirstName-3", "lastname": "LastName-3", "id": "<UUID>" }
  ]
}
```

## Запуск в Docker

В проекте есть `Dockerfile`. 



   ```bash
   cd stub-service
   docker build -t stub-demo-stub .
   ```


   ```bash
   docker run -d -p 8080:8080 stub-demo-stub
   ```

## Настройка через Docker Compose

 `docker-compose.yml` из `/monitoring` проекта, сервис `stub` автоматически будет запущен вместе с другими  на порту **8081**:

```yaml
services:
  stub:
    build: ./stub-service
    ports:
      - "8081:8080"
    # ...
```

После `docker compose up -d` :

```
http://localhost:8081/test
```

---

