public class App {

    public static void main(String[] args) {

        final String fileName = "data.txt";
        final String finishedTestsWord = "FINISHED";
        FileManager fileManager = new FileManager();

        if (fileManager.openFile(fileName)) {
            if (fileManager.isWordInText(finishedTestsWord)) {
                Integer numberOfTestsPassed = fileManager.countWordsInText("TEST PASS");
                System.out.println("The number of tests passed are: " + numberOfTestsPassed);
            } else {
                System.out.println("Warning: We cannot count the number of test passed because " +
                        "the tests have not finished yet.");
            }
            fileManager.closeFile();
        }
    }
}
