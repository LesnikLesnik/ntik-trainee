# Базовый образ
FROM openjdk:17-jdk-slim

# Установка переменной окружения
ENV APP_HOME=/app

# Создание директории для приложения
RUN mkdir -p $APP_HOME

# Копирование файлов приложения
COPY target/*.jar $APP_HOME/app.jar

# Назначение рабочей директории
WORKDIR $APP_HOME

# Команда для запуска приложения
CMD ["java", "-jar", "app.jar"]