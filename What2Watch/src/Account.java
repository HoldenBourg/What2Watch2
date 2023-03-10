import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicLong;

public class Account {

    private final String username;
    private final String password;
    private final String firstName;
    private final String lastName;

    private static final String filePath = "/Users/holdenbourg/Desktop/Holden's Projects/Film Filtration System/FFS Data/";


    // TODO constructor
    public Account(String username, String password, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }


    // TODO getters
    public String getUsername() {return username;}
    public String getPassword() {return password;}
    public String getFirstName() {return firstName;}
    public String getLastName() {return lastName;}


    // TODO class methods
    public static int findAccountIndex(String username) throws FileNotFoundException {
        int index = 0;

        for (int i =0; i < readAccountsFromFile().size(); i++){
            Account currentAccount = readAccountsFromFile().get(i);

            if (currentAccount.getUsername().equalsIgnoreCase(username)){
                index = i;
            }
        }

        return index;
    }
    public static void createAccount() throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("First Name: ");
        String firstName = scanner.nextLine();

        System.out.println("Last Name: ");
        String lastName = scanner.nextLine();

        System.out.println("Username: ");
        String username = scanner.nextLine();

        System.out.println("Password: ");
        String password = scanner.nextLine();


        Account account = new Account(username, password, firstName, lastName);
        writeAccountToFile(account);
    }
    public static void login() throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Username: ");
        String username = scanner.nextLine();

        System.out.println("Password: ");
        String password = scanner.nextLine();

        Account account = readAccountsFromFile().get(findAccountIndex(username));

        if(account.getPassword().equalsIgnoreCase(password)) {
            System.out.print(account.getFirstName() + " you've successfully logged in.");
        } else {
            System.out.print("Invalid username or password");
        }
    }


    //TODO read/write/delete
    public static void writeAccountToFile(Account account) throws IOException {
        String outputText = account.getUsername() + "|" + account.getPassword() + "|" + account.getFirstName() + "|" + account.getLastName();

        String path = filePath + "account.txt";
        File file = new File(path);

        FileWriter fw = new FileWriter(file, true);
        PrintWriter pw = new PrintWriter(fw);

        pw.println(outputText);
        pw.close();

    }
    public static ArrayList<Account> readAccountsFromFile() throws FileNotFoundException {
        String path = filePath + "account.txt";
        File file = new File(path);
        Scanner scanner = new Scanner(file);

        ArrayList<Account> accountList = new ArrayList<>();

        while(scanner.hasNextLine()){
            String line = scanner.nextLine();

            String[] properties = line.split("\\|");

            String username = properties[0];
            String password = properties[1];
            String firstName = properties[2];
            String lastName = properties[3];

            Account account = new Account(username, password, firstName, lastName);
            accountList.add(account);
        }

        return accountList;
    }
    public static void deleteAccount(Account account) throws IOException {
        File inputFile = new File(filePath + "account.txt");
        File tempFile = new File(filePath + "myTempAccountFile.txt");

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        String lineToRemove = account.getUsername() + "|" + account.getPassword() + "|" + account.getFirstName() + "|" + account.getLastName();

        String currentLine;

        while((currentLine = reader.readLine()) != null) {
            // trim newline when comparing with lineToRemove
            String trimmedLine = currentLine.trim();

            if(trimmedLine.equals(lineToRemove)) continue;
            writer.write(currentLine + System.getProperty("line.separator"));
        }

        writer.close();
        reader.close();
        tempFile.renameTo(inputFile);
    }


}
