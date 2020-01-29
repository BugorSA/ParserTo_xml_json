import com.google.gson.Gson;
import lombok.Getter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class MyParserToJSON implements MyParser {
    @Getter ArrayList<Human> HUMAN_ARRAY_LIST = new ArrayList<>();
    @Getter ArrayList<Home> HOME_ARRAY_LIST = new ArrayList<>();
    @Getter ArrayList<Pet> PET_ARRAY_LIST = new ArrayList<>();
    String pathToFile;

    MyParserToJSON(String pathToFile){
        this.pathToFile = pathToFile;
    }

    @Override
    public void Parse() {
        FileReader fr = null;
        try {
            fr = new FileReader(pathToFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        assert fr != null;
        Scanner scan = new Scanner(fr);
        StringBuilder jsonStringBuilder = new StringBuilder();
        while (scan.hasNextLine()) {
            jsonStringBuilder.append(scan.nextLine());
        }
        String jsonString = jsonStringBuilder.toString();
        //fr.close();
        Gson d = new Gson();
        if (jsonString.contains("surname")){
            Human human = d.fromJson(jsonString, Human.class);
            HUMAN_ARRAY_LIST.add(human);
        }
        if (jsonString.contains("address")) {
            Home home = d.fromJson(jsonString, Home.class);
            HOME_ARRAY_LIST.add(home);
        }
        if (jsonString.contains("typePet")) {
            Pet pet = d.fromJson(jsonString, Pet.class);
            PET_ARRAY_LIST.add(pet);
        }
    }

    @Override
    public ArrayList<Human> GetHuman() {
        return HUMAN_ARRAY_LIST;
    }

    @Override
    public ArrayList<Home> GetHome() {
        return HOME_ARRAY_LIST;
    }

    @Override
    public ArrayList<Pet> GetPet() {
        return PET_ARRAY_LIST;
    }
}
