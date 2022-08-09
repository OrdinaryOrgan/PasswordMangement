import java.io.*;
import java.util.Scanner;

public class PasswordManagement {
    public static void main(String[] args) throws IOException{
        System.out.println("==============WELCOME==============");
        System.out.println("Welcome to Password Generator and Storage Program");
        informationWelcome();   // Show welcome page

        System.out.println("Enter the number to get the corresponding service: ");
        Scanner console = new Scanner(System.in);
        int userInput = console.nextInt();

        menu(userInput);
    }

    public static void informationWelcome() {
        /*
        ==============WELCOME==============
        Welcome to Password Generator and Storage Program
        ==============MENU==============
        1. Password generator
        2. Save the existing password
        3. List your information
        4. exit
         */
        System.out.println("==============MENU==============");
        System.out.println("1. Password generator");
        System.out.println("2. Save the existing password");
        System.out.println("3. List your information");
        System.out.println("4. exit");
        System.out.println();
    }

    public static void menu(int choiceNum) throws IOException {
        if (choiceNum == 1) {
            passGenerate();
        } else if (choiceNum == 2) {
            save();
        } else if (choiceNum == 3) {
            showPassword();
        } else if (choiceNum == 4) {
            exit();
        }
    }

    public static void exit() {
        System.exit(0);
    }

    public static void passGenerate() throws IOException {
        PasswordGenerator passwordGn = new PasswordGenerator();
        String passwordGenerated = passwordGn.passGenerate();
        System.out.println("This is a safe password with random characters, you can copy and \n" +
                "paste.");
        System.out.println("==============PSW GENERATOR==============");
        System.out.println(passwordGenerated);

        System.out.println("Yes! -y");
        System.out.println("No! -n");
        System.out.println("Do you want to save them?");
        Scanner console = new Scanner(System.in);
        String userInput = console.next();
        userInput.toLowerCase();
        while (!userInput.equals("n") || !userInput.equals("y")) {
            System.out.println("Please enter correctly.");
            System.out.println("Yes! -y");
            System.out.println("No! -n");
            System.out.println("Do you want to save them?");
            console = new Scanner(System.in);
            userInput = console.next();
        }
        if (userInput.equals("n")) {
            System.out.println("We won't save your password.");
            informationWelcome();
        } else {
            save(passwordGenerated);
        }

    }

    public static void save() throws IOException {
        String website = "N/A";
        String username = "N/A";
        String password = "N/A";
        Scanner console = new Scanner(System.in);

        System.out.println("==============SAVE==============");

        System.out.print("Website or APP name: ");
        website = console.next();
        if (website == null) {
            website = "N/A";
        }

        System.out.print("Username: ");
        username = console.next();
        if (username == null) {
            username = "N/A";
        }

        System.out.print("Password: ");
        password = console.next();
        if (password == null) {
            password = "N/A";
        }

        Password savePassword = new Password(website, username, password);
    }

    public static void save(String generatedPassword) throws IOException {
        String website = "N/A";
        String username = "N/A";
        Scanner console = new Scanner(System.in);

        System.out.println("==============SAVE==============");

        System.out.print("Website or APP name: ");
        website = console.next();
        if (website == null) {
            website = "N/A";
        }

        System.out.print("Username: ");
        username = console.next();
        if (username == null) {
            username = "N/A";
        }

        Password savePassword = new Password(website, username, generatedPassword);
    }

    public static void showPassword() {
        String website;
        String username;
        String password;
        String fileName = "passwordSaved.xml";
        System.out.println("==============LIST==============");
        System.out.println("Website/App\tUsername\tPassword");

        // Unfinished
        try {
            BufferedReader out = new BufferedReader(new FileReader(fileName));
            out.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
