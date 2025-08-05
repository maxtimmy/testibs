# Мониторинг (Prometheus -> InfluxDB -> Grafana)

## 1. Запуск стека



```bash
cd monitoring
docker compose up -d --build

Доступные сервисы:
	•	stub (заглушка): http://localhost:8081
	•	Prometheus: http://localhost:9090
	•	InfluxDB: http://localhost:8086
	    •	Логин: admin
	    •	Пароль: adminpass
	•	Grafana: http://localhost:3001
	    •	Логин: admin
	    •	Пароль: admin