import classes.FilePathReader;

public class Main {
    public static void main(String[] args) {

        FilePathReader filePathReader = new FilePathReader("files/tecnologias.txt");

        String input = filePathReader.readFile();

        System.out.printf(input);


    }
}
