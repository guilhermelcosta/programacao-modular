package classes;

import java.io.*;

public class FilePathReader {

    private BufferedReader bufferedReader;

    public FilePathReader(String filePath) {
        try {
            bufferedReader = new BufferedReader(new FileReader(filePath));
        } catch (FileNotFoundException excecao) {
            System.out.println("File path not found");
        }
    }

    public void closeFile() throws IOException {
        bufferedReader.close();
    }

    public String readFile() {

        String output = null;

        try {
            output = bufferedReader.readLine();
        } catch (IOException exception) {
            System.out.println("Failed to read file");
        }
        return output;
    }

}
