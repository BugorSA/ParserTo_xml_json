import lombok.Getter;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

public class MyParserToXML implements MyParser {
    ArrayList<Human> HUMAN_ARRAY_LIST = new ArrayList<>();
    ArrayList<Home> HOME_ARRAY_LIST = new ArrayList<>();
    ArrayList<Pet> PET_ARRAY_LIST = new ArrayList<>();
    String pathToFile;

    MyParserToXML(String pathToFile) {
        this.pathToFile = pathToFile;
    }

    @Override
    public void Parse() {
        {
            try {
                int count = 0;
                // Создается построитель документа
                DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
                // Создается дерево DOM документа из файла
                Document document = documentBuilder.parse(pathToFile);

                // Получаем корневой элемент
                Node root = document.getDocumentElement();

                //System.out.println("List of books:");
                //System.out.println();
                // Просматриваем все подэлементы корневого - т.е. непоред данные
                NodeList books = root.getChildNodes();
                for (int i = 0; i < books.getLength(); i++) {
                    Node book = books.item(i);
                    // Если нода не текст, то это данные - заходим внутрь
                    if (book.getNodeType() != Node.TEXT_NODE) {
                        NodeList bookProps = book.getChildNodes();
                        String str = book.getNodeName();
                        switch (str) {
                            case "human":
                                String name = "";
                                String secondName = "";
                                String surname = "";
                                int age = 0;
                                for (int j = 0; j < bookProps.getLength(); j++) {
                                    Node bookProp = bookProps.item(j);
                                    // Если нода не текст, то это один из параметров данных - заполняем
                                    if (bookProp.getNodeType() != Node.TEXT_NODE) {
                                        switch (bookProp.getNodeName()) {
                                            case "name":
                                                name = bookProp.getChildNodes().item(0).getTextContent();
                                                break;
                                            case "surname":
                                                surname = bookProp.getChildNodes().item(0).getTextContent();
                                                break;
                                            case "secondName":
                                                secondName = bookProp.getChildNodes().item(0).getTextContent();
                                                break;
                                            case "age":
                                                age = Integer.parseInt(bookProp.getChildNodes().item(0).getTextContent());
                                                break;
                                            default:
                                                System.out.println(bookProp.getNodeName() + ":" + bookProp.getChildNodes().item(0).getTextContent());
                                        }

                                    }
                                }
                                HUMAN_ARRAY_LIST.add(new Human(name, secondName, surname, age));
                                break;
                            case "pet":
                                String name1 = "";
                                String typePet = "";
                                int age1 = 0;
                                for (int j = 0; j < bookProps.getLength(); j++) {
                                    Node bookProp = bookProps.item(j);
                                    // Если нода не текст, то это один из параметров данных - заполняем
                                    if (bookProp.getNodeType() != Node.TEXT_NODE) {
                                        switch (bookProp.getNodeName()) {
                                            case "name":
                                                name1 = bookProp.getChildNodes().item(0).getTextContent();
                                                break;
                                            case "typePet":
                                                typePet = bookProp.getChildNodes().item(0).getTextContent();
                                                break;
                                            case "age":
                                                age1 = Integer.parseInt(bookProp.getChildNodes().item(0).getTextContent());
                                                break;
                                            default:
                                                System.out.println(bookProp.getNodeName() + ":" + bookProp.getChildNodes().item(0).getTextContent());
                                        }

                                    }
                                }
                                PET_ARRAY_LIST.add(new Pet(name1, typePet, age1));
                                break;
                            case "home":
                                String address = "";
                                String type = "";
                                int age2 = 0;
                                for (int j = 0; j < bookProps.getLength(); j++) {
                                    Node bookProp = bookProps.item(j);
                                    // Если нода не текст, то это один из параметров данных - заполняем
                                    if (bookProp.getNodeType() != Node.TEXT_NODE) {
                                        switch (bookProp.getNodeName()) {
                                            case "address":
                                                address = bookProp.getChildNodes().item(0).getTextContent();
                                                break;
                                            case "type":
                                                type = bookProp.getChildNodes().item(0).getTextContent();
                                                break;
                                            case "age":
                                                age2 = Integer.parseInt(bookProp.getChildNodes().item(0).getTextContent());
                                                break;
                                            default:
                                                System.out.println(bookProp.getNodeName() + ":" + bookProp.getChildNodes().item(0).getTextContent());
                                        }

                                    }
                                }
                                HOME_ARRAY_LIST.add(new Home(type, address, age2));
                                break;
                            default:
                                for (int j = 0; j < bookProps.getLength(); j++) {
                                    Node bookProp = bookProps.item(j);
                                    // Если нода не текст, то это один из параметров данных - печатаем
                                    if (bookProp.getNodeType() != Node.TEXT_NODE) {
                                        System.out.println(bookProp.getNodeName() + ":" + bookProp.getChildNodes().item(0).getTextContent());
                                    }
                                }
                                break;
                        }
                        count++;
                    }
                }

            } catch (ParserConfigurationException | IOException | SAXException ex) {
                ex.printStackTrace(System.out);
            }
        }
    }

        @Override
        public ArrayList<Human> GetHuman () {
            return HUMAN_ARRAY_LIST;
        }

        @Override
        public ArrayList<Home> GetHome () {
            return HOME_ARRAY_LIST;
        }

        @Override
        public ArrayList<Pet> GetPet () {
            return PET_ARRAY_LIST;
        }
    }
