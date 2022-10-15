# Automation Testing

***

Репозиторий для домашних работ по Управлению Качеством Разработки Программного Обеспечения

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
*См. **pom.xml** в модуле **AutomationTesting***

***

## 0. Before (делайте самостоятельно)

**Домашние задания перед автоматизированным тестированием**

Схема: ***N. \[с/M (+a)\] T***, где:
- N — Номер домашнего задания;
- c — Полученный балл;
- M — Максимально возможный балл;
- a — Количество полученных доп. баллов;
- T — Название домашнего задания.

1. \[4/4 (+0)\] Нахождение багов в игре **dullrace2**.
2. \[?/7 (+?)\] Сценарии терминала в **XMind**. 
3. \[?/6 (+?)\] **Тест-кейсы** по сценариям терминала.
4. \[?/6 (+?)\] **Классы эквивалентности** калькулятора кредитов.
5. \[?/6 (+?)\] **Баг-репорты** на приложение **ListBoxer**.
6. \[?/4 (+?)\] **XMind**-схема приложения **Text Filter (dumb)** с **баг-репортами**.

***

## 1. Authorization

**Произвести авторизацию на сайте**

1. Скачайте **Google Chrome**, затем **Google Chrome Web Driver** соответствующей версии. *(Опционально: отключите автоматическое обновление браузера).*
2. Скачайте расширение **Katalon Recorder (Selenium tests generator)** в Ваш браузер **Google Chrome**.
3. Откройте окно **Katalon** *(не включайте автоматический перевод с английского языка)* и нажмите кнопку **"Record"**.
4. Произведите все действия для авторизации на Вашем сайте.
5. Нажмите на кнопку **"Stop"** внизу экрана.
6. В левом нижнем углу окна **Katalon** нажмите кнопку **"Export"**.
7. Выберите **"Java (WebDriver + JUnit)"** и укажите абсолютный путь до Вашего **Google Chrome Web Driver**.
8. Нажмите **"Apply"**.
9. Используйте сгенерированный код, отредактировав его под себя.

**Минимальные зависимости Maven:**
- junit
- selenium-chrome-driver
- selenium-support

***
