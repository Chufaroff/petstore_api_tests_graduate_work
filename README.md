# <span style="color: white"> Дипломая работа по автоматизации тестовых сценариев API сервиса [Petstore](https://petstore.swagger.io/) </span>

#### Petstore — образец приложения, которое можно использовать для практики REST-запросов. Этот сайт имитирует онлайн-зоомагазин, и пользователи могут добавлять и получать информацию о своих питомцах.
<p align="center">
<img title="petstore" src="media/petstore.jpg">
</p>



## :pushpin: Содержание:

- [Использованный стек технологий](#computer-использованный-стек-технологий)
- [Сборка в Jenkins](#-сборка-в-jenkins)
- [Пример Allure-отчета](#-пример-allure-отчета)
- [Интеграция с Allure TestOps](#-интеграция-с-allure-testops)
- [Интеграция с Jira](#-интеграция-с-jira)
- [Уведомления в Telegram с использованием бота](#-уведомления-в-telegram-с-использованием-бота)

## :computer: Использованный стек технологий

<p align="center">
<a href="https://www.jetbrains.com/idea/"><img width="6%" title="IntelliJ IDEA" src="media/Intelij_IDEA.svg"></a>
<a href="https://www.java.com/"><img width="6%" title="Java" src="media/Java.svg"></a>
<a href="https://docs.qameta.io/allure-report/"><img width="6%" title="Allure Report" src="media/Allure_Report.svg"></a>
<a href="https://qameta.io/"><img width="5%" title="Allure TestOps" src="media/AllureTestOps.svg"></a>
<a href="https://gradle.org/"><img width="6%" title="Gradle" src="media/Gradle.svg"></a>
<a href="https://junit.org/junit5/docs/current/user-guide/"><img width="6%" title="JUnit5" src="media/JUnit5.svg"></a>
<a href="https://github.com/"><img width="6%" title="GitHub" src="media/GitHub.svg"></a>
<a href="https://www.jenkins.io/"><img width="6%" title="Jenkins" src="media/Jenkins.svg"></a>
<a href="https://telegram.org/?1"><img width="6%" title="Telegram" src="media/Telegram.svg"></a>
<a href="https://www.atlassian.com/ru/software/jira"><img width="5%" title="Jira" src="media/Jira.svg"></a>
</p>

- В данном проекте автотесты написаны на языке <code>Java</code>.
- В качестве сборщика был использован - <code>Gradle</code>.
- Для тестирования API использованы инструменты <code>REST Assured</code> и <code>Lombock</code>.
- Для удаленного запуска реализована параметризированная джоба в <code>Jenkins</code> с формированием Allure-отчета и отправкой результатов в <code>Telegram</code> при помощи бота.
- Осуществлена интеграция с <code>Allure TestOps</code> и <code>Jira</code>

###  Команда на запуск тестов сборки Jenkins

```
clean
${TASK}
```

### <img src="media/param.svg" title="Параметры сборки" width="4%"/> Параметры сборки

* <code>TASK</code> – задача на прогон тестов. Варианты: <code>regress_test</code>, <code>users_test</code>, <code>store_test</code>, <code>pet_test</code>.



##  <a href="https://jenkins.autotests.cloud/job/petstore-api-test-graduate-work/"><img src="media/Jenkins.svg" title="Jenkins" width="4%"/> Сборка в Jenkins</a>
<p align="center">
<img title="Jenkins Build" src="media/JenkinsBuild.png">
</p>

##  <a href="https://jenkins.autotests.cloud/job/petstore-api-test-graduate-work/5/allure/"><img src="media/Allure_Report.svg" title="Allure Report" width="4%"/> Пример Allure-отчета</a>


<p align="center">
<img title="Allure Overview" src="media/AllureReport.png">
</p>

##  <a href="https://allure.autotests.cloud/project/3477/dashboards"><img src="media/AllureTestOps.svg" title="Allure TestOps" width="4%"/> Интеграция с Allure TestOps</a>

Выполнена интеграция сборки <code>Jenkins</code> с <code>Allure TestOps</code>.
Результат выполнения автотестов отображается в <code>Allure TestOps</code>
На Dashboard в <code>Allure TestOps</code> отображена статистика пройденных тестов.

<p align="center">
<img title="Allure TestOps DashBoard" src="media/Allure.png">
</p>

##  <a href="https://jira.autotests.cloud/browse/HOMEWORK-777"><img src="media/Jira.svg" title="Jira" width="4%"/> Интеграция с Jira</a>

Реализована интеграция <code>Allure TestOps</code> с <code>Jira</code>, в тикете отображается информация, какие тест-кейсы были написаны в рамках задачи и результат их прогона.

<p align="center">
<img title="Jira Task" src="media/jiraTask.png">
</p>

##  <img width="4%" style="vertical-align:middle" title="Telegram" src="media/Telegram.svg"> Уведомления в Telegram с использованием бота

После завершения сборки, бот созданный в <code>Telegram</code>, автоматически обрабатывает и отправляет сообщение с результатом.

| ALL PASSED                            | WITH FAILED AND SKIPPED                |
|---------------------------------------|----------------------------------------|
| ![pos](media/notification.png) | ![neg](media/notification2.png) |
