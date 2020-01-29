import lombok.Getter;

import java.util.ArrayList;

public interface MyParser {
    ArrayList<Human> HUMAN_ARRAY_LIST = new ArrayList<>();
    ArrayList<Home> HOME_ARRAY_LIST = new ArrayList<>();
    ArrayList<Pet> PET_ARRAY_LIST = new ArrayList<>();
    void Parse();
    ArrayList<Human> GetHuman();
    ArrayList<Home> GetHome();
    ArrayList<Pet> GetPet();

}
