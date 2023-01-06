PAUSE
CD build
CD install
CD prueba01
start java -Dserver.port=8080 -classpath lib/* com.distribuida.Servidor
start java -Dserver.port=8084 -classpath lib/* com.distribuida.Servidor
start java -Dserver.port=8085 -classpath lib/* com.distribuida.Servidor
start java -Dserver.port=8086 -classpath lib/* com.distribuida.Servidor
PAUSE