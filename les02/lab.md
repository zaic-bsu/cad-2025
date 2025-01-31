# Лабораторная работа 1. Gradle. Базовое приложение Spring

## Предварительные требования
1. 

## Выполнение работы 
1. Скачайте и установите [Axiom Standard JDK 17.0.14](https://axiomjdk.ru/pages/downloads/#/java-17-lts) (предпочтительно) или [Temurin JDK 17.0.14](https://adoptium.net/temurin/releases/?version=17). Используйте [руководство по установке](https://axiomjdk.ru/pages/axiomjdk-install-guide-17.0.14/).
2. Скачайте и установите [Gradle 8.12](https://gradle.org/releases/).  Используя [руководство по установке](https://gradle.org/install/).
3. Используя Gradle в директории les02 создайте проект вид Java Applications, используйте [руководство](https://docs.gradle.org/current/samples/sample_building_java_applications.html)
    Проект должен иметь следующие параметры.
    + name - employee-table
    + type - Application
    + language - Java
    + Java version - 17
    + structure - Single application project
    + DSL - Kotlin
    + test framework - JUnit 4
4. Добавьте в ваш проект библиотеку [org.springframework:spring-context:6.2.2](https://mvnrepository.com/artifact/org.springframework/spring-context/6.2.2)
5. Реализуйте следующие приложение
    + Приложение должно представлять собой консольное приложение разработанное с помощью фреймворка спринг и конфигурируемое с помощью Java-конфигурации.
    + Приложение должно читать данные о сотрудниках из csv-файла и выводить их в двух вариантах: в консоль в виде таблицы c двумя столбцами "ФИО"  и в виде HTML-файла содержащим заголовок и таблицу
    + Структура приложения долна соответовать данно  UML-диаграмме
    + Конфигурирование приложение должно быть выполненно в  

6. Выполните сборку приложения в виде jar файла
7. Протестируйте работу приложения с помощью вызова ```java --jar <ВашеПрилоджение>.jar```
8. Оформите отчет о лабаработрной работе.


## Вопросы для защиты
1. 
