# Тестовое задание

Этот проект содержит:
1. **stub-service/** — Spring Boot приложение-заглушка
2. **monitoring/** — Docker-Compose стек: Prometheus → InfluxDB → Grafana
3. **jmeter/** — JMeter скрипты для тестирования заглушки и для авторизации в Grafana


---

## Как запустить “заглушку” (пункт 1)

```bash
cd project-root/stub-service
mvn clean package
# локальный запуск
java -jar target/stub-demo-0.0.1-SNAPSHOT.jar