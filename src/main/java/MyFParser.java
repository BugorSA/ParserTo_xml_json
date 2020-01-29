import java.util.Optional;

public class MyFParser {
    public MyParser ParseTo(String pathToFile) {
        MyParser myParser = null;
        if (getExtensionByStringHandling(pathToFile).isPresent()) {
            String line = getExtensionByStringHandling(pathToFile).get();
            if (line.equals("json")) {
                myParser = new MyParserToJSON(pathToFile);
            } else if (line.equals("xml")) {
                myParser = new MyParserToXML(pathToFile);
            } else System.out.println("Такой файл не обрабатывается");
        } else System.out.println("Файл не распознан");
        return myParser;
    }

    //определение расширения файла
    public Optional<String> getExtensionByStringHandling(String filename) {
        return Optional.ofNullable(filename)
                .filter(f -> f.contains("."))
                .map(f -> f.substring(filename.lastIndexOf(".") + 1));
    }
}
