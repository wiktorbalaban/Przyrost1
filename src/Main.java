import java.util.Scanner;
import Querys.Queries;

public class Main {

    public static void main(String[] args) {

        Queries queries = new Queries("SQLQueryData");

        while (true) {
            System.out.println("Podaj numer zadania:");
            Scanner scanner = new Scanner(System.in);
            int zadNr = Integer.parseInt( scanner.nextLine());
            System.out.println("Podaj zapytanie:");
            String query=scanner.nextLine();

            if(queries.addQuery(zadNr,query)==false){
                System.err.println("Błędne zapytanie!");
            }
            System.out.println("Kontynuować?[y/n]");
            if(scanner.nextLine().equals("n"))break;
        }
        queries.saveListToFile("SQLQueryData/odp.txt");
    }
}
