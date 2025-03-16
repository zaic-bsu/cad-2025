# Spring Data.Управление транзакциями

Spring Data — это проект из семейства Spring, который упрощает и стандартизирует работу с различными технологиями хранения данных (реляционными и NoSQL-базами данных).

Spring Data предоставляет абстракцию поверх различных технологий (JPA, JDBC, MongoDB, Redis и др.), избавляя разработчика от написания повторяющегося (boilerplate) кода.

Основные возможности Spring Data:

+ Создание репозиториев с минимальным количеством кода.
+ Автоматическая генерация стандартных CRUD-операций.
+ Поддержка создания запросов через именование методов.
+ Простое создание собственных и сложных запросов с помощью аннотации @Query.
+ Поддержка пагинации и сортировки.

``` kotlin

dependencies {
    // Spring Core и Context
    implementation("org.springframework:spring-context:6.1.5")

    // Spring Data JPA и ORM
    implementation("org.springframework.data:spring-data-jpa:3.2.5")
    implementation("org.springframework:spring-orm:6.1.5")

    // Hibernate (JPA provider)
    implementation("org.hibernate.orm:hibernate-core:6.4.4.Final")

    // H2 Database
    implementation("com.h2database:h2:2.2.224")

    // Jakarta Persistence API
    implementation("jakarta.persistence:jakarta.persistence-api:3.1.0")
}

```

## CrudRepository

CrudRepository — это основной интерфейс из проекта Spring Data, предоставляющий базовый набор CRUD-операций (создание, чтение, обновление и удаление) для работы с сущностями без необходимости писать дополнительный код.

+ Интерфейс CrudRepository входит в Spring Data и предоставляет набор стандартных методов CRUD (Create, Read, Update, Delete).
+ Работает с JPA, Hibernate, MongoDB, Redis и другими хранилищами через расширения Spring Data.
+ Автоматически генерирует реализацию методов на основе анализа объявленных интерфейсов репозиториев.


| Метод                                            | Описание                                                      | Пример использования                           |
|--------------------------------------------------|---------------------------------------------------------------|-----------------------------------------------|
| `save(entity)`                                   | Сохраняет новую или изменяет существующую сущность            | `studentRepository.save(student);`            |
| `findById(id)`                                   | Ищет сущность по идентификатору (возвращает Optional)         | `studentRepository.findById(1L);`             |
| `existsById(id)`                                 | Проверяет существование сущности с указанным ID               | `studentRepository.existsById(1L);`           |
| `findAll()`                                      | Возвращает все сущности                                       | `studentRepository.findAll();`                |
| `findAllById(Iterable<ID> ids)`                  | Возвращает все сущности с указанными ID                       | `studentRepository.findAllById(List.of(1L,2L));`|
| `count()`                                        | Возвращает количество сущностей в репозитории                 | `studentRepository.count();`                  |
| `delete(entity)`                                 | Удаляет переданную сущность                                   | `studentRepository.delete(student);`          |
| `deleteById(id)`                                 | Удаляет сущность по ID                                        | `studentRepository.deleteById(1L);`           |
| `deleteAll()`                                    | Удаляет все сущности из репозитория                           | `studentRepository.deleteAll();`              |
| `existsById(id)`                                 | Проверяет, существует ли сущность с указанным ID              | `studentRepository.existsById(1L);`           |