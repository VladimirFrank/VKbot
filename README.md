# VKbot

Бот для VK.com на java.

Стек:
1. Java 8;
2. Spring boot (старт, инициализация сервера);
3. Spring MVC (распределение, обработка запросов);
4. Google GSON (парсинг запросов, ответов VK api);
5. Apache HTTP client (отправка запросов к VK api);

Бот умеет:
1. На сообщение 'help' отправлять список доступных команд;
2. Отвечать на сообщения 'привет.' и 'как дела?';
3. По запросу 'скинь трек' присылать случайное видео из хранилища (специальный альбом видеозаписей отдельного пользователя);
