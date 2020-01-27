import com.google.gson.Gson;
import com.google.gson.JsonParser;
import jdk.nashorn.internal.parser.JSONParser;

import javax.xml.parsers.DocumentBuilder;
import java.io.*;
import java.util.Optional;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        UserMenu userMenu = new UserMenu();
        userMenu.StartMenu();


    }
}

//    private static String ReadJson() throws IOException {
////        String jsonStr = "";
////        FileReader fw = new FileReader( "human.json" );
////        Gson d = new Gson();
////        Human human = d.fromJson(fw, Human.class);
//        return null;
//
//
////        Scanner scan = new Scanner(fw);
////        int i = 1;
////
////        while (scan.hasNextLine()) {
////            jsonStr = jsonStr + scan.nextLine();
////            i++;
////        }
////        fw.close();
////        return jsonStr;
//    }

//        Gson g = new Gson();
//        String jsonString = "{\n" +
//                "  \"name\": \"Иван\",\n" +
//                "  \"secondName\": \"Иванович\",\n" +
//                "  \"surname\": \"Иванов\",\n" +
//                "  \"address\": {\n" +
//                "    \"streetAddress\": \"Московское ш., 101, кв.101\",\n" +
//                "    \"city\": \"Лен    инград\",\n" +
//                "    \"postalCode\": 101101\n" +
//                "  },\n" +
//                "  \"phoneNumbers\": [\n" +
//                "    \"812 123-1234\",\n" +
//                "    \"916 123-4567\"\n" +
//                "  ],\n" +
//                "  \"age\": \"21\"\n" +
//                "}";
//        //File file = new File("human.json");
//        Human human =  g.fromJson(jsonString,Human.class);