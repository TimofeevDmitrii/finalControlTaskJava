## Описание проекта
* Данный проект был реализован в соответствии с условиями, изложенными в файле "Задание 2.pdf"(прикреплен в репозитории).
Проект реализует розыгрыш игрушек в магазине, учитывая вес каждой из них. Пример использования приложения представлен
в методе main класса Main. 
* Программа содержит функционал добавления игрушек в хранилище для розыгрыша, изменения их веса,
количества. Для удобства все результаты работы программы логируются (записываются) в файл "ToysLotteryResult.txt".
Также можно ознакомиться со статистикой розыгрыша игрушек в файле "LotteryStatistics.txt"
## Структура приложения
"Движком" приложения является объект класса ToyShopController. Он принимает в конструктор при создании
модель магазина игрушек с хранилищем — объект класса-наследника ToyShopWithStore, а также объект, отвечающий 
за вывод сообщений в консоль и реализующий интерфейс SendToConsole. Класс ToyShopController дополнительно содержит в себе
объект класса SaveLotteryResults необходимый для сохранения результатов работы приложения в лог-файл.
Используя методы, присущие этим трем объектам, ToyShopController реализует все необходимые методы для работы приложения.

Класс ModelToyShop является наследником класса ToyShopWithStore и используется в конструкторе при запуске контроллера
в примере в методе main класса Main. Как наследник класса ToyShopWithStore, он содержит в себе объект ToyStore, одной единицей
хранения в котором является объект класса ToyStoreElement. В свою очередь ToyStoreElement включает в себя объект класса Toy и данные,
присущие ячейке хранилища. Также ModelToyShop содержит объект класса ToyElementDataParser (реализующий интерфейс CreateToyElement), 
используемый для парсирования текстовых данных, поступающих на вход, для добавления новой игрушки в хранилище. Соответственно, 
методы модели ModelToyShop реализуются с использованием внутренних объектов, их возможностей(методов), а также дополнительной логики.
Так, например, сам алгоритм нахождения призовой игрушки представлен в методе toyLottery(List<Toy> toysList).
