# nauka-trainee
Тестовое задание для ООО "Наука" - стажировка

---

## Запуск
### Docker
```shell
docker-compose up
```

### Локальный
```shell
docker-compose up -f local/docker-compose.yml
```
После этой команды окружение для локального запуска будет поднято.

## Ссылки
[OpenApi](http://localhost:8080/swagger-ui/index.html) 

## Переменные окружения
- `NAUKA_DATABASE_HOST` - хост базы данных, дефолтное значение `localhost`

## Сборка
### Запуск тестов
```shell
mvn clean verify
```

### Сборка docker образа
```shell
 docker build -t lesniklesnik/nauka_trainee_back:0.0.1 .
```
