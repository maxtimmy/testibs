

##  Запуск нагрузочных тестов


```bash
cd jmeter

# Пример: 50 потоков, рампап 10 с, 100 циклов
jmeter -n -t stub-load-test.jmx \
  -l results/results_50.jtl \
  -Jthreads=50 -Jrampup=10 -Jloops=100
