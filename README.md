# Automation Testing

Репозиторий для домашних работ по **Управлению Качеством Разработки Программного Обеспечения**

***

## Содержание

- **До автоматизированного тестирования**
    - **[Before](#before)**
- **Информация**
    - **[Основная информация](#основная-информация)**
    - **[Дополнительная информация](#дополнительная-информация)**
- **Автоматизированное тестирование**
    - **[1. Authorization](#1-authorization)**
    - **[2. Refactoring](#2-refactoring)**
    - **[3. Manager](#3-manager)**

***

## Before

**[<Перейти к каталогу>](https://github.com/GalyautdinovIslam/AutomationTesting/tree/main/Before)**

### *(Делайте самостоятельно)*

**Домашние задания перед автоматизированным тестированием**

Схема: ***N. \[с/M (+a)\] T***, где:

- **N** — Номер домашнего задания;
- **c** — Полученный балл;
- **M** — Максимально возможный балл;
- **a** — Количество полученных доп. баллов;
- **T** — Название домашнего задания.

1. [\[4/4 (+0)\] Нахождение багов в игре **dullrace2**.](https://github.com/GalyautdinovIslam/AutomationTesting/tree/main/Before/1.%20Dullrace2)
2. [\[?/7 (+?)\] Сценарии терминала в **XMind**.](https://github.com/GalyautdinovIslam/AutomationTesting/tree/main/Before/2.%20XMind)
3. [\[?/6 (+?)\] **Тест-кейсы** по сценариям терминала.](https://github.com/GalyautdinovIslam/AutomationTesting/tree/main/Before/3.%20Test%20cases)
4. [\[?/6 (+?)\] **Классы эквивалентности** калькулятора кредитов.](https://github.com/GalyautdinovIslam/AutomationTesting/tree/main/Before/4.%20Equivalence%20classes)
5. [\[?/6 (+?)\] **Баг-репорты** на приложение **ListBoxer**.](https://github.com/GalyautdinovIslam/AutomationTesting/tree/main/Before/5.%20ListBoxer)
6. [\[?/4 (+?)\] **XMind**-схема приложения **Text Filter (dumb)** с **баг-репортами**.](https://github.com/GalyautdinovIslam/AutomationTesting/tree/main/Before/6.%20Text%20Filter%20(dumb))

**[<Содержание>](#содержание)**

***

## Основная информация

### Используются:

- **Java 17**
- **Maven**
- **JUnit 4**
- **Selenium**
- **Google Chrome**
- **Chrome Web Driver**
- **Katalon** *(Google Chrome)*
- **vk.com** *(актуально на осень 2022 года)*

### Ссылки на скачивания нужного

- [Java (если отсутствует)](https://www.oracle.com/java/technologies/downloads/)
- [Intellij IDEA (если отсутствует)](https://www.jetbrains.com/idea/download/)
- [Google Chrome (если отсутствует)](https://www.google.com/intl/ru_ru/chrome/)
- [Chrome Web Driver (сверяйте версии Google Chrome)](https://sites.google.com/chromium.org/driver/downloads)
- [Katalon Recorder (расширение Google Chrome)](https://chrome.google.com/webstore/detail/katalon-recorder-selenium/ljdobmomdgdljniojadhoplhkpialdid)

### Используемые зависимости maven

*См. **[pom.xml](https://github.com/GalyautdinovIslam/AutomationTesting/blob/main/pom.xml)** в модуле
**AutomationTesting***

**[<Содержание>](#содержание)**

***

## Дополнительная информация

### Добавление User-Agent

В методе `setUp()`, помеченным аннотацией `@Before`, заменить инициализацию **WebDriver driver** на:

```
String userAgentOption = "user-agent=Mozilla/5.0 (Macintosh; Intel Mac OS X 10_8_2) AppleWebKit/537.17 (KHTML, like Gecko) Chrome/24.0.1309.0 Safari/537.17";
ChromeOptions options = new ChromeOptions();
options.addArguments(userAgentOption);
driver = new ChromeDriver(options);
```

*(Можете заменить значение User-Agent на своё)*

### Изменение Page Load Strategy

В методе `setUp()`, помеченным аннотацией `@Before`, заменить инициализацию **WebDriver driver** на:

```
ChromeOptions options = new ChromeOptions();
options.setPageLoadStrategy(PageLoadStrategy.EAGER);
driver = new ChromeDriver(options);
```

*(Можете изменить значение PageLoadStrategy)*

**Варианты** Page Load Strategy:

1. (default) `normal` — Selenium ожидает полной загрузки страницы.
   Загружен и проанализирован HTML-контент, проанализированы дополнительные ресурсы.
2. `eager` — Selenium ожидает события DOMContentLoaded.
   Загружен и проанализирован HTML-контент.
3. `none` — Selenium "готов", когда исходное содержимое страницы полностью получено.
   Загружен HTML-контент.

### Имитирование нажатия клавиши без привязки к WebElement'у

Пример отправки клавиши **Escape**:

```
new Actions(driver).sendKeys(Keys.ESCAPE).perform();
```

*Иногда с помощью клавиши **Escape** можно закрыть всплывающие окна*

**[<Содержание>](#содержание)**

***

## 1. Authorization

**[<Перейти к каталогу>](https://github.com/GalyautdinovIslam/AutomationTesting/tree/main/Authorization)**

**Произвести авторизацию на сайте**

1. Скачайте **Google Chrome**, затем **Google Chrome Web Driver** соответствующей версии.
   *(Опционально: отключите автоматическое обновление браузера).*
2. Скачайте расширение **Katalon Recorder (Selenium tests generator)** в Ваш браузер **Google Chrome**.
3. Откройте окно **Katalon** *(не включайте автоматический перевод с английского языка)* и нажмите кнопку **"Record"**.
4. Произведите все действия для авторизации на Вашем сайте.
5. Нажмите на кнопку **"Stop"** внизу экрана.
6. В левом нижнем углу окна **Katalon** нажмите кнопку **"Export"**.
7. Выберите **"Java (WebDriver + JUnit)"** и укажите абсолютный путь до Вашего **Google Chrome Web Driver**.
8. Нажмите **"Apply"**.
9. Используйте сгенерированный код, отредактировав его под себя.

**Минимальные зависимости Maven:**

- [junit](https://mvnrepository.com/artifact/junit/junit)
- [selenium-chrome-driver](https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-chrome-driver)
- [selenium-support](https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-support)

**[<Содержание>](#содержание)**

***

## 2. Refactoring

**[<Перейти к каталогу>](https://github.com/GalyautdinovIslam/AutomationTesting/tree/main/Refactoring)**

**Произвести рефакторинг кода, написать тест для создания сущности**

1. Вынесите некоторый код из **Test-метода** из **[\[1. Authorization\]](#1-authorization)** в отдельные **методы**
   с помощью **"Extract method"**. Теперь **Test-метод** выглядит как **последовательный вызов** только что
   созданных **методов**.
2. Создайте новый класс **TestBase**, вынесите в него **все** методы из вашего Test-класса, которые **не помечены**
   аннотацией `@Test` *(вынесите методы и написанные только что, и с аннотациями `@Before`, `@After`)*.
3. Ваш **Test-класс** должен быть наследником класса **TestBase**.
4. Создайте класс, который будет **хранить в себе данные** для авторизации. Сделайте так, чтобы ваш метод `login()`
   **принимал данный класс и использовал данные оттуда**.
5. Проверьте, что Ваш тест **не сломался**.
6. В вашем **Test-классе** создайте новый Test-метод для создания сущности.
   В нём **пока что придётся** опять добавить методы для авторизации.
7. С помощью **Katalon**'а сгенерируйте код для создания сущности и добавьте его в новый **Test-метод**.
8. Произведите такой же **рефакторинг**, который мы произвели для авторизации, **для нового кода**.
9. Запустите тесты и убедитесь в их правильной работе.

**Минимальные зависимости Maven:**

- [junit](https://mvnrepository.com/artifact/junit/junit)
- [selenium-chrome-driver](https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-chrome-driver)
- [selenium-support](https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-support)

**[<Содержание>](#содержание)**

***

## 3. Manager

**[<Перейти к каталогу>](https://github.com/GalyautdinovIslam/AutomationTesting/tree/main/Manager)**

**Произвести структурирование ранее написанного кода**

1. Создать класс **NavigationHelper** и перенести туда все методы из **TestBase**, связанные с переходами по страницам.
2. Создать класс **LoginHelper** и перенести туда все методы из **TestBase**, связанные с авторизацией.
3. Создать **классы-хелперы** для методов из **TestBase**, взаимодействующих с имеющимися сущностями.
4. Создать **HelperBase** и перенести туда остальные методы, но не `setUp()` и `tearDown()`. Также данный класс должен иметь ссылку на **WebDriver**.
5. Сделать ваши **классы-тестеры** наследниками класса **HelperBase**, перенести данные классы в пакет **helpers**.
6. Создать класс **ApplicationManager**, перенести туда основные поля из **TestBase**, добавить ссылки на только что написанные классы-хелперы.
7. В конструкторе класса **ApplicationManager** произвести инициализацию (взять код из метода `setUp()` класса **TestBase**).
8. Добавить на наши **хелперы** в классе **ApplicationManager** **методы-геттеры**.
9. В **HelperBase** добавить ссылку на **ApplicationManager**.
10. В **TestBase** добавить ссылку на **ApplicationManager**. Удалить из **TestBase** то, что есть в **ApplicationManager**.
11. Перенести логику метода `tearDown()` класса **TestBase** в метод `stop()` класса **ApplicationManager**.
12. Отредактировать наши классы-тесты так, чтобы код компилировался.
13. Проверить выполнение всех тестов.

**Минимальные зависимости Maven:**

- [junit](https://mvnrepository.com/artifact/junit/junit)
- [selenium-chrome-driver](https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-chrome-driver)
- [selenium-support](https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-support)

**[<Содержание>](#содержание)**

***
