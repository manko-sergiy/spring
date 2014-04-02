@echooff
start mvn jetty:run
timeout /t 6
start http://localhost:7997/ && exit