import com.google.gson.Gson;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class UserMenu {

    private ArrayList<Human> humanArrayList;
    private ArrayList<Pet> petArrayList;
    private ArrayList<Home> homeArrayList;

    public UserMenu() {
        humanArrayList = new ArrayList<>();
        humanArrayList.add(new Human("Василий", "Иванович", "Коварцев", 50));
        humanArrayList.add(new Human("Владимир", "Вячеславович", "Коваленко", 20));
        humanArrayList.add(new Human("Юрий", "Михайлович", "Заболотнов", 70));
        petArrayList = new ArrayList<>();
        petArrayList.add(new Pet("Вася", "кот", 2));
        petArrayList.add(new Pet("Машка", "кошка", 1));
        petArrayList.add(new Pet("Шарик", "собака", 3));
        homeArrayList = new ArrayList<>();
        homeArrayList.add(new Home("дача", "Старосемейкино,ул.Советская 5", 6));
        homeArrayList.add(new Home("многоэтажка", "Самара,Московское ш-се 34Б", 20));
        homeArrayList.add(new Home("малоэтажка", "Санкт-Петербург,ул. Садовая 127", 250));
    }

    //перегруз на случай надобности в пустых данных
    public UserMenu(int a) {
        humanArrayList = new ArrayList<>();
        petArrayList = new ArrayList<>();
        homeArrayList = new ArrayList<>();
    }

    public void StartMenu() throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            scanner.reset();
            System.out.flush();
            System.out.println("0 - Вывести таблицу с людьми");
            System.out.println("1 - Вывести питомцев");
            System.out.println("2 - Вывести дома");
            System.out.println("3 - Редактировать");
            System.out.println("4 - Добавить");
            System.out.println("5 - Удалить");
            System.out.println("Чтобы выйти введите иное число");
            System.out.println("Введите номер пункта меню");
            int num = Integer.parseInt(scanner.next());
            switch (num) {
                case 0:
                    System.out.println();
                    PrintTableHuman();
                    System.out.println();
                    break;
                case 1:
                    System.out.println();
                    PrintTablePet();
                    System.out.println();
                    break;
                case 2:
                    System.out.println();
                    PrintTableHome();
                    System.out.println();
                    break;
                case 3:
                    System.out.println();
                    EditTable();
                    System.out.println();
                    break;
                case 4:
                    System.out.println();
                    AddTable();
                    System.out.println();
                    break;
                case 5:
                    System.out.println();
                    DeleteTable();
                    System.out.println();
                    break;
                default:
                    return;
            }
        }
    }

    private void DeleteTable() {
    }

    public void PrintTableHuman() {
        System.out.println("Имя | Отчество | Фамилия | Возраст");
        for (int j = 0; j < humanArrayList.size(); j++) {
            System.out.println(j + " " + humanArrayList.get(j).toString());
        }
    }

    public void PrintTablePet() {
        System.out.println("Кличка | Тип | Возраст");
        for (int j = 0; j < petArrayList.size(); j++) {
            System.out.println(j + " " + petArrayList.get(j).toString());
        }
    }

    public void PrintTableHome() {
        System.out.println("Тип | Адрес | Срок эксплуатации");
        for (int j = 0; j < homeArrayList.size(); j++) {
            System.out.println(j + " " + homeArrayList.get(j).toString());
        }
//        for (Home i : homeArrayList){
//            System.out.print(i.toString());
//        }
    }

    public void EditTable() {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("Введите номер таблицы");
            int num1 = in.nextInt();
            System.out.println("Введите номер пункта таблицы");
            int num2 = in.nextInt();
            switch (num1) {
                case 0:
                    EditTableHuman(num2);
                    in.close();
                    return;
                case 1:
                    EditTablePet(num2);
                    in.close();
                    return;
                case 2:
                    EditTableHome(num2);
                    in.close();
                    return;
                default:
                    in.close();
                    return;
            }
        }
    }

    private void EditTableHome(int line) {
        Home home = homeArrayList.get(line);
        Scanner in = new Scanner(System.in);
        String str;
        while (true) {
            System.out.println("0-тип");
            System.out.println("1-адрес");
            System.out.println("2-возраст");
            System.out.println("Введите номер меняемого параметра");
            int num1 = in.nextInt();
            switch (num1) {
                case 0:
                    str = in.nextLine();
                    home.setType(str);
                    break;
                case 1:
                    str = in.nextLine();
                    home.setAddress(str);
                    break;
                case 2:
                    num1 = in.nextInt();
                    home.setAge(num1);
                    break;
                default:
                    in.close();
                    return;
            }
        }
    }

    private void EditTablePet(int line) {
        Pet pet = petArrayList.get(line);
        Scanner in = new Scanner(System.in);
        String str;
        while (true) {
            System.out.println("0-тип");
            System.out.println("1-кличка");
            System.out.println("2-возраст");
            System.out.println("Для выхода введите любой другой параметр");
            System.out.println("Введите номер меняемого параметра");
            int num1 = in.nextInt();
            switch (num1) {
                case 0:
                    str = in.nextLine();
                    pet.setTypePet(str);
                    break;
                case 1:
                    str = in.nextLine();
                    pet.setName(str);
                    break;
                case 2:
                    num1 = in.nextInt();
                    pet.setAge(num1);
                    break;
                default:
                    in.close();
                    return;
            }
        }
    }

    private void EditTableHuman(int line) {
        Human human = humanArrayList.get(line);
        Scanner in = new Scanner(System.in);
        String str;
        while (true) {
            System.out.println("0-имя");
            System.out.println("1-отчество");
            System.out.println("2-фамилия");
            System.out.println("3-возраст");
            System.out.println("Для выхода введите любой другой параметр");
            System.out.println("Введите номер меняемого параметра");
            int num1 = in.nextInt();
            switch (num1) {
                case 0:
                    str = in.nextLine();
                    human.setName(str);
                    break;
                case 1:
                    str = in.nextLine();
                    human.setSecondName(str);
                    break;
                case 2:
                    str = in.nextLine();
                    human.setSurname(str);
                    break;
                case 3:
                    num1 = in.nextInt();
                    human.setAge(num1);
                    break;
                default:
                    in.close();
                    return;
            }
        }
    }

    //изменить здесь путь к файлу в случае изменения местоположения
    public void AddTable() {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("0-добавить человека");
            System.out.println("1-добавить питомца");
            System.out.println("2-добавить дом");
            System.out.println("3-получить данные из файла");
            System.out.println("Для выхода введите любой другой параметр");
            System.out.println("Введите номер");
            int num1 = in.nextInt();
            switch (num1) {
                case 0:
                    System.out.println("имя");
                    String str1 = in.nextLine();
                    System.out.println("отчество");
                    String str2 = in.nextLine();
                    System.out.println("фамилия");
                    String str3 = in.nextLine();
                    System.out.println("возраст");
                    int str4 = in.nextInt();
                    humanArrayList.add(new Human(str1, str2, str3, str4));

                    break;
                case 1:
                    System.out.println("тип");
                    str1 = in.nextLine();
                    System.out.println("кличка");
                    str2 = in.nextLine();
                    System.out.println("возраст");
                    str4 = in.nextInt();
                    petArrayList.add(new Pet(str2, str1, str4));

                    break;
                case 2:
                    System.out.println("тип");
                    str1 = in.nextLine();
                    System.out.println("адрес");
                    str2 = in.nextLine();
                    System.out.println("возраст");
                    str4 = in.nextInt();
                    homeArrayList.add(new Home(str1, str2, str4));

                    break;
                case 3:
                    String fileWay = "C:\\Users\\79878\\IdeaProjects\\NetCrack_Pr\\src\\main\\resources\\";
                    //                    FileReader fw = new FileReader("C:\\Users\\79878\\IdeaProjects\\NetCrack_Pr\\src\\main\\resources\\human.json");
//                    Gson d = new Gson();
//                    Human human = d.fromJson(fw, Human.class);
//                    System.out.println(human.getFullName());
                    System.out.print(fileWay);
                    in.reset();
                    String s = in.next();
                    fileWay += s;
                    MyFParser myFParser = new MyFParser();
                    MyParser myParser = myFParser.ParseTo(fileWay);
                    myParser.Parse();
                    humanArrayList.addAll(myParser.GetHuman());
                    homeArrayList.addAll(myParser.GetHome());
                    petArrayList.addAll(myParser.GetPet());
                    break;
                default:
                    return;
            }
        }
    }

}


//
//
//    //нехороший вариант
//    private void ParseJson(String fileWay) throws FileNotFoundException {
//        FileReader fr = new FileReader(fileWay);
//        Scanner scan = new Scanner(fr);
//        String jsonString = "";
//        while (scan.hasNextLine()) {
//            jsonString = jsonString + (scan.nextLine());
//        }
//        //fr.close();
//        Gson d = new Gson();
//        if (jsonString.contains("surname")){
//            Human human = d.fromJson(jsonString, Human.class);
//            humanArrayList.add(human);
//        }
//        if (jsonString.contains("address")) {
//            Home home = d.fromJson(jsonString, Home.class);
//            homeArrayList.add(home);
//        }
//        if (jsonString.contains("typePet")) {
//            Pet pet = d.fromJson(jsonString, Pet.class);
//            petArrayList.add(pet);
//        }
//    }
//
//    //заменить на private при потере необход
//    public void ParserXml(String wayfile) {
//        try {
//            int count = 0;
//            // Создается построитель документа
//            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
//            // Создается дерево DOM документа из файла
//            Document document = documentBuilder.parse(wayfile);
//
//            // Получаем корневой элемент
//            Node root = document.getDocumentElement();
//
//            //System.out.println("List of books:");
//            //System.out.println();
//            // Просматриваем все подэлементы корневого - т.е. непоред данные
//            NodeList books = root.getChildNodes();
//            for (int i = 0; i < books.getLength(); i++) {
//                Node book = books.item(i);
//                // Если нода не текст, то это данные - заходим внутрь
//                if (book.getNodeType() != Node.TEXT_NODE) {
//                    NodeList bookProps = book.getChildNodes();
//                    String str = book.getNodeName();
//                    switch (str) {
//                        case "human":
//                            String name = "";
//                            String secondName = "";
//                            String surname ="";
//                            int age = 0;
//                            for (int j = 0; j < bookProps.getLength(); j++) {
//                                Node bookProp = bookProps.item(j);
//                                // Если нода не текст, то это один из параметров данных - заполняем
//                                if (bookProp.getNodeType() != Node.TEXT_NODE) {
//                                    switch (bookProp.getNodeName()){
//                                        case "name":
//                                            name = bookProp.getChildNodes().item(0).getTextContent();
//                                            break;
//                                        case "surname":
//                                            surname = bookProp.getChildNodes().item(0).getTextContent();
//                                            break;
//                                        case "secondName":
//                                            secondName = bookProp.getChildNodes().item(0).getTextContent();
//                                            break;
//                                        case "age":
//                                            age = Integer.parseInt(bookProp.getChildNodes().item(0).getTextContent());
//                                            break;
//                                        default:
//                                            System.out.println(bookProp.getNodeName() + ":" + bookProp.getChildNodes().item(0).getTextContent());
//                                    }
//
//                                }
//                            }
//                            humanArrayList.add(new Human(name,secondName,surname,age));
//                            break;
//                        case "pet":
//                            String name1 = "";
//                            String typePet = "";
//                            int age1 = 0;
//                            for (int j = 0; j < bookProps.getLength(); j++) {
//                                Node bookProp = bookProps.item(j);
//                                // Если нода не текст, то это один из параметров данных - заполняем
//                                if (bookProp.getNodeType() != Node.TEXT_NODE) {
//                                    switch (bookProp.getNodeName()){
//                                        case "name":
//                                            name1 = bookProp.getChildNodes().item(0).getTextContent();
//                                            break;
//                                        case "typePet":
//                                            typePet = bookProp.getChildNodes().item(0).getTextContent();
//                                            break;
//                                        case "age":
//                                            age1 = Integer.parseInt(bookProp.getChildNodes().item(0).getTextContent());
//                                            break;
//                                        default:
//                                            System.out.println(bookProp.getNodeName() + ":" + bookProp.getChildNodes().item(0).getTextContent());
//                                    }
//
//                                }
//                            }
//                            petArrayList.add(new Pet(name1,typePet,age1));
//                            break;
//                        case "home":
//                            String address = "";
//                            String type = "";
//                            int age2 = 0;
//                            for (int j = 0; j < bookProps.getLength(); j++) {
//                                Node bookProp = bookProps.item(j);
//                                // Если нода не текст, то это один из параметров данных - заполняем
//                                if (bookProp.getNodeType() != Node.TEXT_NODE) {
//                                    switch (bookProp.getNodeName()){
//                                        case "address":
//                                            address = bookProp.getChildNodes().item(0).getTextContent();
//                                            break;
//                                        case "type":
//                                            type = bookProp.getChildNodes().item(0).getTextContent();
//                                            break;
//                                        case "age":
//                                            age2 = Integer.parseInt(bookProp.getChildNodes().item(0).getTextContent());
//                                            break;
//                                        default:
//                                            System.out.println(bookProp.getNodeName() + ":" + bookProp.getChildNodes().item(0).getTextContent());
//                                    }
//
//                                }
//                            }
//                            homeArrayList.add(new Home(type,address,age2));
//                            break;
//                        default:
//                            for (int j = 0; j < bookProps.getLength(); j++) {
//                                Node bookProp = bookProps.item(j);
//                                // Если нода не текст, то это один из параметров данных - печатаем
//                                if (bookProp.getNodeType() != Node.TEXT_NODE) {
//                                    System.out.println(bookProp.getNodeName() + ":" + bookProp.getChildNodes().item(0).getTextContent());
//                                }
//                            }
//                            break;
//                    }
//                    count++;
//                }
//            }
//
//        } catch (ParserConfigurationException | IOException | SAXException ex) {
//            ex.printStackTrace(System.out);
//        }
//    }
//
//    //определение расширения файла
//    public Optional<String> getExtensionByStringHandling(String filename) {
//        return Optional.ofNullable(filename)
//                .filter(f -> f.contains("."))
//                .map(f -> f.substring(filename.lastIndexOf(".") + 1));
//    }