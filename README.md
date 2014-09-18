# Gradle multi spring boot project

* Domain layer with jpa
* Admin web app "/admin" with spring security configured against jpa
* main app

## Separation
by separating the admin layer into it's own app we can launch it independently and work on it without the main app. In a larger app there would probably be a /api layer also with it's own security model

## Todo
Launching everything together.
having both the admin layer the base layer and possibly the api layer sharing the same domain

```
/ <- main app
/admin <- admin app
/api <- api app
```