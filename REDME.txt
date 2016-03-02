Инструкция:
1. Развернуть сервер приложений WildFly в расширенном режиме (standalone.bat -c standalone-full.xml) для работы MDB (JNDI для Queue и ConnectionFactory на сервере созданы по умолчанию)
2. Создать JNDI - "java:/MySqlDS" (или изменить в persistence.xml) для подключения к БД (транзакциями упраляет сервер приложений)
3. Выполнить скрипт в БД (файл - resources/META-INF/db-script.sql)
4. Выполнить pom.xml командой:   mvn package wildfly:deploy
Сервис готов принимать POST запросы JSON пакеты (массив объектов) с типом "Content Type: application/json" по адресу: 
http://127.0.0.1:8080/rservice-1/rs/saveloc

Пример запроса:
POST http://127.0.0.1:8080/rservice-1/rs/saveloc
Content Type: application/json
[{"latitude":0.0,"longitude":0.0,"horizontalAccuracy":0,"speed":4.0,"course":0,"altitude":0,"verticalAccuracy":5,"actuality":"GPS","timestamp":139333763500},{"latitude":1.0,"longitude":2.0,"horizontalAccuracy":3,"speed":4.0,"course":4,"altitude":5,"verticalAccuracy":5,"actuality":"GPS","timestamp":139333763500},{"latitude":2.0,"longitude":4.0,"horizontalAccuracy":6,"speed":4.0,"course":8,"altitude":10,"verticalAccuracy":5,"actuality":"GPS","timestamp":139333763500},{"latitude":3.0,"longitude":6.0,"horizontalAccuracy":9,"speed":4.0,"course":12,"altitude":15,"verticalAccuracy":5,"actuality":"GPS","timestamp":139333763500},{"latitude":4.0,"longitude":8.0,"horizontalAccuracy":12,"speed":4.0,"course":16,"altitude":20,"verticalAccuracy":5,"actuality":"GPS","timestamp":139333763500}]

Результат:
В БД будет создано 5 записей из JSON пакета
В папке bin сервеа приложений будет создан файл my_log.txt (если ещё не создан)
В файл my_log.txt будет внесено время и Body JSON-пакета (логирование реализовано через MDB)
