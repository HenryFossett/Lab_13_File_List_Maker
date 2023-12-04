import java.util.Scanner;

public class SafeInput {

    /**
     * returns a string input by the user that must be at least one character
     * @param pipe the scanner to use for user input
     * @param prompt the message for the user telling them what to input
     * @return a string of at least one character
     */
    public static String getNonZeroLenString(Scanner pipe, String prompt){
        boolean done = false;
        String response = "";
        do{

            System.out.print(prompt + ": ");
            response = pipe.nextLine();
            if(response.length()>0){
                done = true;
            }else{
                System.out.println("\nPlease enter at least one character\n");
            }

        }while(!done);

        return response;
    }
    /**
     * gets an int val from the user with no constraints
     * @param pipe the scanner used for inputed
     * @param prompt the message for the user telling them what to input
     * @return an int value and nothing else
     */
    public static int getInt(Scanner pipe, String prompt){

        boolean done = false;
        int response = 0;
        String trash = "";
        do{

            System.out.print(prompt + ": ");
            if (pipe.hasNextInt()){
                response = pipe.nextInt();
                pipe.nextLine();
                done = true;
            }else{
                trash = pipe.nextLine();
                System.out.println("\nEnter an int value not " + trash+"\n");
            }

        }while(!done);
        return response;
    }

    /**
     * gets a double value from user input
     * @param pipe the scanner used for input
     * @param prompt the message telling the user what to input
     * @return a double value and no data of any other type
     */
    public static double getDouble(Scanner pipe, String prompt){
        boolean done = false;
        double response = 0.0;
        String trash = "";

        do{
            System.out.print(prompt + ": ");
            if(pipe.hasNextDouble()){
                response = pipe.nextDouble();
                pipe.nextLine();
                done = true;
            }else{
                trash = pipe.nextLine();
                System.out.println("\nEnter a double value not: " + trash);
            }

        }while(!done);
        return response;
    }

    /**
     * gets an int value from the user and validates that it is in range
     * @param pipe the scanner used for user input
     * @param prompt the message telling the user what to input
     * @param low the lowest value in range
     * @param high the highest value in range
     * @return an int value that is in the set range
     */
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high){
        boolean done = false;
        int response = 0;
        String trash = "";
        do{
            System.out.print(prompt + ": ");
            if (pipe.hasNextInt()){
                response = pipe.nextInt();
                pipe.nextLine();
                if (response >= low && response <= high){
                    done = true;
                }else{
                    System.out.println("Enter an int value that is in range [" + low+ " - " + high +"]: " + response);
                }
            }else{
                trash = pipe.nextLine();
                System.out.println("Enter an int value not: " + trash);
            }

        }while(!done);
        return response;
    }
    /**
     * gets a double value from the user and checks that it is in range
     * @param pipe the scanner used for user input
     * @param prompt the message telling the user what to input
     * @param low the low end of the range
     * @param high the high end of the range
     * @return a double that is in range
     */
    public static double getRangedDouble(Scanner pipe, String prompt, double
            low, double high){
        boolean done = false;
        double response = 0;
        String trash = "";
        do{
            System.out.print(prompt + ": ");
            if (pipe.hasNextDouble()){
                response = pipe.nextDouble();
                pipe.nextLine();
                if (response >= low && response <= high){
                    done = true;
                }else{
                    System.out.println("Enter a double value that is in range [" + low+ " - " + high +"]: " + response);
                }
            }else{
                trash = pipe.nextLine();
                System.out.println("Enter a double value not: " + trash);
            }

        }while(!done);
        return response;
    }
    /**
     * confirms yes or no from the user and returns a boolean value
     * @param pipe the scanner used for user input
     * @param prompt the message telling the user what to input
     * @return a boolean value, true for yes and false for no
     */
    public static boolean getYNConfirm(Scanner pipe, String prompt){
        boolean done = false;
        boolean YorN = false;
        String response = "";

        do{
            System.out.print(prompt + ": ");
            response = pipe.nextLine();
            if(response.toUpperCase().matches("[YN]")){
                done = true;
                if(response.equalsIgnoreCase("Y")) {
                    YorN = true;
                }else{ YorN = false;}
            }else{
                System.out.println("\nYou must enter a [y/n]");
            }
        }while(!done);
        return YorN;
    }
    /**
     * takes a regEx string and returns a valid match from the user
     * @param pipe the scanner used for user input
     * @param prompt the message to user that tells them what to input
     * @param regEx a string that represents a regular expression to use for the test
     * @return a string value that matches the regular expression
     */
    public static String getRegExString(Scanner pipe, String prompt, String
            regEx){
        boolean done = false;
        String response = "";
        do{

            System.out.print(prompt + " " + regEx + ": ");
            response = pipe.nextLine();
            if(response.matches(regEx)){
                done = true;
            }else{
                System.out.println("\nPlease enter a String that matches the pattern " + regEx + "!\n");
            }

        }while(!done);

        return response;
    }
    /**
     * takes a string and centers it within a decorative border
     * @param msg the message to be centered in the border
     */
    public static void prettyHeader(String msg){
        for(int i = 0; i < 60; i++){
            System.out.print("*");
        }
        System.out.println("");
        for(int b = 0; b < 3; b++){
            System.out.print("*");
        }
        for(int d = 0; d < 27 - (msg.length()/2); d++){
            System.out.print(" ");
        }
        System.out.print(msg);
        for(int e = 60; e > 34 + (msg.length()/2); e--){
            System.out.print(" ");
        }
        for(int a = 60; a > 57 ; a--){
            System.out.print("*");
        }
        System.out.println("");
        for(int c = 0; c < 60; c++){
            System.out.print("*");
        }
    }

}

