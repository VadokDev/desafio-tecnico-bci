# Desafío Técnico para el Banco BCI

## Instrucciones de uso:

```
./gradlew build
./gradlew bootRun 
```

## Body de ejemplo

```
curl  -X POST \
  'http://localhost:8080/users' \
  --header 'Accept: */*' \
  --header 'User-Agent: Thunder Client (https://www.thunderclient.com)' \
  --header 'Content-Type: application/json' \
  --data-raw '{
  "name": "Jacinto",
  "email": "jacinto@email.com",
  "password": "asd",
  "phones": [{
    "number": "1234567",
    "citycode": "1",
    "countrycode": "57"
  }]
}'
```

## TO DO: Diagrama