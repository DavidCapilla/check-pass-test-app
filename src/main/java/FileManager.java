import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileManager {

    private String fileName;
    private Scanner file;

    public boolean openFile(String fileName) {

        File file = new File(fileName);
        try {
            this.file = new Scanner(file);
            this.fileName = fileName;
            return true;
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: File not found.");
        }
        return false;
    }

    public void closeFile() {
        file.close();
    }

    private void rewindFile() {
        file.close();
        openFile(fileName);
    }

    public boolean isWordInText(String searchingWord) {

        if (file != null) {
            boolean isWordInText = file.findAll(searchingWord).count() > 0;
            rewindFile();
            return isWordInText;
        }
        return false;
    }

    public Integer countWordsInText(String searchingWord) {

        if (file != null) {
            Integer countWordsInText = (int) file.findAll(searchingWord).count();
            rewindFile();
            return countWordsInText;
        }
        return 0;
    }
}
