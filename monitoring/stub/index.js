import express from "express";
const app = express();
app.use(express.json());

// внутренняя «метрика»
let postTestCount = 0;
let postTestMaxSec = 0;

// бизнес-эндпоинт
app.post("/test", (req, res) => {
  const started = process.hrtime.bigint();

  const count = Number(req.body?.count ?? 1);
  const data = Array.from({ length: count }).map((_, i) => ({
    firstname: `FirstName-${i + 1}`,
    lastname: `LastName-${i + 1}`,
    id: crypto.randomUUID(),
  }));

  // имитируем небольшую работу
  setTimeout(() => {
    const finished = process.hrtime.bigint();
    const durSec = Number(finished - started) / 1e9;

    postTestCount += 1;
    if (durSec > postTestMaxSec) postTestMaxSec = durSec;

    res.json({ data });
  }, 5);
});

// экспорт метрик в формате Prometheus
app.get("/actuator/prometheus", (_req, res) => {
  res.type("text/plain").send(
`# HELP http_server_requests_seconds_count total http requests
# TYPE http_server_requests_seconds_count counter
http_server_requests_seconds_count{method="POST",uri="/test",status="200",outcome="SUCCESS",exception="none",error="none"} ${postTestCount}

# HELP http_server_requests_seconds_max max duration in seconds
# TYPE http_server_requests_seconds_max gauge
http_server_requests_seconds_max{method="POST",uri="/test",status="200",outcome="SUCCESS",exception="none",error="none"} ${postTestMaxSec}
`
  );
});

app.listen(8080, () => console.log("stub on :8080"));