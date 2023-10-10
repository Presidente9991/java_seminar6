/* Задание
Реализуйте структуру телефонной книги с помощью HashMap.
Программа также должна учитывать, что в во входной структуре будут повторяющиеся имена с разными телефонами,
их необходимо считать, как одного человека с разными телефонами.
Вывод должен быть отсортирован по убыванию числа телефонов.
*/

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        HashMap<String, List<String>> phoneBook = new HashMap<>();

        addContact(phoneBook, "Иванов Иван Иванович", "1234567890");
        addContact(phoneBook, "Петров Пётр Петрович", "9876543210");
        addContact(phoneBook, "Сидоров Сергей Сергеевич", "5555555555");
        addContact(phoneBook, "Иванов Иван Иванович", "9999999999");
        addContact(phoneBook, "Петров Пётр Петрович", "1111111111");
        addContact(phoneBook, "Иванов Иван Иванович", "2222222222");

        printPhoneBook(phoneBook);
    }

    public static void addContact(HashMap<String, List<String>> phoneBook, String name, String phoneNumber) {

        if (phoneBook.containsKey(name)) {
            List<String> phoneNumbers = phoneBook.get(name);
            phoneNumbers.add(phoneNumber);
        } else {
            List<String> phoneNumbers = new ArrayList<>();
            phoneNumbers.add(phoneNumber);
            phoneBook.put(name, phoneNumbers);
        }
    }

    public static void printPhoneBook(HashMap<String, List<String>> phoneBook) {

        List<Map.Entry<String, List<String>>> sortedEntries = new ArrayList<>(phoneBook.entrySet());
        sortedEntries.sort((entry1, entry2) -> entry2.getValue().size() - entry1.getValue().size());

        for (Map.Entry<String, List<String>> entry : sortedEntries) {
            String name = entry.getKey();
            List<String> phoneNumbers = entry.getValue();
            System.out.println(name + ": " + phoneNumbers);
        }
    }
}