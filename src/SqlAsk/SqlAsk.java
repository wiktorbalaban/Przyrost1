package SqlAsk;

import org.apache.log4j.Logger;

import java.io.*;
import java.util.Scanner;

public class SqlAsk {

    //final static Logger logger = Logger.getLogger(SqlAsk.class);

public static void main(String[] args) {
    System.out.println("Podaj numer zadania:");
    Scanner scanner = new Scanner(System.in);
    int zadNr = Integer.parseInt( scanner.nextLine());
    System.out.println("Podaj zapytanie:");
    String query=scanner.nextLine();

    boolean isQueryOkVar = isQueryOk(query);

    if(isQueryOkVar==false){
       // logger.error("To zapytanie jest błędne!");
    }else{
        try {
            PrintWriter writer = new PrintWriter("SQLQueryData/Zad/"+zadNr+".txt", "UTF-8");
            writer.println(query);
            writer.close();
        }catch(FileNotFoundException  e){
            //logger.error(e);
        }catch (UnsupportedEncodingException e1){
            //logger.error(e1);
        }
    }
}

private static boolean isQueryOk(String query){
    boolean result=false;

    query=query.toUpperCase();
    int select = query.indexOf("SELECT");
    int from = query.indexOf("FROM");
    int where = query.indexOf("WHERE");
    int orderBy = query.indexOf("ORDER BY");

    int tmp=0;
    if(select!=-1){
        tmp=select;
    }
    else {
        tmp=-1;
    }
    if(from!=-1){
        if(from>tmp)tmp=from;
        else return result;
    }
    if(where!=-1){
        if(where>tmp)tmp=where;
        else return result;
    }
    if(orderBy!=-1){
        if(orderBy>tmp);
        else return result;
    }
    result=true;
    return result;
}
}
