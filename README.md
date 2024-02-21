# Фреймворк Spring (семинары)
## Урок 10. Spring Testing. JUnit и Mockito для написания тестов.

#### Домашнее задание

Разработайте тесты для службы аутентификации
`AuthService`

Этот сервис имеет методы
`login(String username, String password)`
,
`register(User user)`
и
`logout(Long userId)`

Служба использует
`UserRepository`
для управления данными пользователя и
`SessionRepository`
для управления сессионными данными.


Создайте mock-объекты для
`UserRepository`
и
`SessionRepository`


Напишите тест, который проверяет, что при успешной регистрации метод
`save`
репозитория пользователя вызывается.

Напишите тест, который проверяет, что при входе в систему для существующего пользователя создается новая сессия.

Напишите тест, проверяющий корректное завершение сессии при выходе из системы.

Желательно использовать `spring security` в работе

# Описание кода
Код представляет собой пример простого веб-сервиса аутентификации, написанного с использованием фреймворка Spring. Он включает в себя классы для моделей пользователей и сессий, репозитории для доступа к данным, а также сервис аутентификации для регистрации, входа и выхода пользователей из системы.

### Модель данных
`User:` Представляет собой сущность пользователя в системе с полями `id`, `username` и `password`.

`UserSession:` Представляет собой сущность сессии пользователя с полями `id` и `userId`.

### Репозитории
`UserRepository:` Интерфейс для доступа к данным пользователей.

`UserSessionRepository: `Интерфейс для доступа к данным сессий пользователей.
Сервис аутентификации

`AuthService:` Интерфейс для регистрации, входа и выхода пользователей из системы.

`AuthServiceImpl:` Реализация сервиса аутентификации.

### Тесты
`AuthServiceTest:` Набор тестов для проверки функциональности сервиса аутентификации.
