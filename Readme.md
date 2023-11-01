1. Использование команды cat в Linux
- Создать два текстовых файла: "Pets"(Домашние животные) и "Pack animals"(вьючные животные), используя команду cat в терминале Linux. В первом файле перечислить собак, кошек и хомяков. Во втором — лошадей, верблюдов и ослов.
Объединить содержимое этих двух файлов в один и просмотреть его содержимое.
Переименовать получившийся файл в "Human Friends"(. Пример конечного вывода после команды “ls” : Desktop Documents Downloads HumanFriends.txt Music PackAnimals.txt Pets.txt Pictures Videos  
В терминале вводим следующую команду:  
`cat >Pets.txt`  
Создается новый файл Pets, наполняем файл значениями в терминале:  
`dog`  
`cat`  
`hamster`   
Далее нажимаем Ctrl+D Аналогично:  
`cat >PackAnimals.txt`  
Создается новый файл PackAnimals, наполняем файл значениями в терминале:  
`horse`  
`camel`  
`donkey`  
Проверяем содержимое корневого каталога командой ls  
`ls`
![1.png](screenshot%2F1.png)  
Объединяем два файла в один и записываем данные в файл HumanFriends:  
`cat Pets PackAnimals >HumanFriends.txt`  
`ls`
![2.png](screenshot%2F2.png)  
Проверим содержимое файла:  
![3.png](screenshot%2F3.png)  
2. Работа с директориями в Linux  
  Создать новую директорию и переместить туда файл "Human Friends".  
   `mkdir animals`  
   `mv HumanFriends.txt animals`  
   `cd animals`  
   `ls`  
![4.png](screenshot%2F4.png)
3. Работа с MySQL в Linux. “Установить MySQL на вашу вычислительную машину ”  
- Подключить дополнительный репозиторий MySQL и установить один из пакетов из этого репозитория.  
`sudo apt install mysql-server mysql-client`  
- ![5.png](screenshot%2F5.png)
4. Управление deb-пакетами.  
- Установить и затем удалить deb-пакет, используя команду dpkg. Скачиваем deb пакет.
- ![6.png](screenshot%2F6.png)  
- ![7.png](screenshot%2F7.png)
- 