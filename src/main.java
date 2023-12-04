import java.nio.file.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class main {
    private static boolean needsToBeSaved = false;
    private static String currentFileName = ""; // To keep track of the current file name

    public static void main(String[] args) {
        boolean done = false;
        String input = "";
        Scanner in = new Scanner(System.in);
        ArrayList<String> myArrList = new ArrayList<>();
        String regEx = "^[AaDdVvQqOoSsCc]$";

        do {
            input = SafeInput.getRegExString(in, "A - Add an Item to the List\nD - Delete an Item from the List\nV - View the List\nC - Clear the List\nO - Open a list file from disk\nS - Save the current list file to disk\nQ - Quit the Program\n", regEx);

            if (input.equalsIgnoreCase("A")) {
                add(myArrList);
                needsToBeSaved = true;
            } else if (input.equalsIgnoreCase("D")) {
                delete(myArrList);
                needsToBeSaved = true;
            } else if (input.equalsIgnoreCase("V")) {
                view(myArrList);
            } else if (input.equalsIgnoreCase("C")) {
                clear(myArrList);
                needsToBeSaved = true;
            } else if (input.equalsIgnoreCase("O")) {
                openListFromFile(myArrList, in);
                needsToBeSaved = false; // Loaded a list, not modified yet
            } else if (input.equalsIgnoreCase("S")) {
                saveListToFile(myArrList);
                needsToBeSaved = false; // Saved the list
            } else if (input.equalsIgnoreCase("Q")) {
                done = quit();
            }
        } while (!done);
    }

    // Existing methods...

    public static void view(ArrayList<String> arrList) {
        print(arrList);
        needsToBeSaved = false; // Viewing the list does not modify it
    }

    public static void clear(ArrayList<String> arrList) {
        arrList.clear();
        System.out.println("The list has been cleared.");
    }

    public static void openListFromFile(ArrayList<String> arrList, Scanner in) {
        String fileName = SafeInput.getRegExString(in, "Enter the file name to open (without extension):", "^[A-Za-z0-9]+$");
        String filePath = fileName + ".txt";

        try {
            arrList.clear(); // Clear the existing list
            Files.lines(Paths.get(filePath)).forEach(arrList::add);
            System.out.println("List loaded from " + filePath);
            currentFileName = fileName;
        } catch (IOException e) {
            System.out.println("Error loading the list from " + filePath);
        }
    }

    public static void saveListToFile(ArrayList<String> arrList) {
        Scanner in = new Scanner(System.in);
        if (currentFileName.isEmpty()) {
            currentFileName = SafeInput.getRegExString(in, "Enter the file name to save (without extension):", "^[A-Za-z0-9]+$");
        }

        String filePath = currentFileName + ".txt";

        try {
            Files.write(Paths.get(filePath), arrList);
            System.out.println("List saved to " + filePath);
        } catch (IOException e) {
            System.out.println("Error saving the list to " + filePath);
        }
    }
    public static void add(ArrayList<String> arrList){
        String input = "";
        int m = 0;
        Scanner in = new Scanner(System.in);
        input = SafeInput.getNonZeroLenString(in, "What would you like to add to the list");
        m = SafeInput.getInt(in, "What location would you like this list item placed");
        arrList.add(m-1, input);
    }
    public static boolean quit(){
        boolean done = false;
        Scanner in = new Scanner(System.in);
        done = SafeInput.getYNConfirm(in, "Do you want to quit the application? [Y/N]");
        if (done == true){
            done = SafeInput.getYNConfirm(in, "Are you sure? [Y/N]");
        }
        return done;
    }
    public static void print(ArrayList<String> arrList){
        for (int i = 0; i < arrList.size(); i++){
            System.out.println(i+1 + ". " +arrList.get(i));
        }
    }
    public static void delete(ArrayList<String> arrList){
        int m = 0;
        Scanner in = new Scanner(System.in);
        m = SafeInput.getInt(in, "What number would you like to delete");
        arrList.remove(m);
        System.out.println("The item at index " + m + " was deleted.");
    }

}
