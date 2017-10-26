package Querys;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Queries {
    private String saveDir;

    private ArrayList<Query> queryList;
    public Queries(String saveDir){
        this.saveDir=saveDir;
        queryList=new ArrayList<Query>();
    }
    public Queries(){
    }

    public boolean addQuery(int nr, String data){
        boolean result=false;

        String tmpData=data.toUpperCase();
        int select = tmpData.indexOf("SELECT");
        int from = tmpData.indexOf("FROM");
        int where = tmpData.indexOf("WHERE");
        int orderBy = tmpData.indexOf("ORDER BY");

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

        for (int i =0; i<queryList.size();i++ ) {
            if(queryList.get(i).getNr()==nr){
                queryList.set(i,new Query(nr,data));
                return result;
            }
        }

        queryList.add(new Query(nr,data));

        return result;
    }

    public void saveListToFile(String path){
        try {
            PrintWriter writer = new PrintWriter(path, "UTF-8");
            
            Collections.sort(queryList, new Comparator<Query>(){
                public int compare(Query o1, Query o2){
                    if(o1.getNr() == o2.getNr())
                        return 0;
                    return o1.getNr() < o2.getNr() ? -1 : 1;
                }
            });

            for (Query query: queryList
                 ) {
                writer.println("Zad "+query.getNr());
                writer.println(query.data);
                writer.println();
            }

            writer.close();
        }catch(FileNotFoundException e){
            System.out.println(e);
        }catch (UnsupportedEncodingException e1){
            System.out.println(e1);
        }
    }


    private class Query{
        public int getNr() {
            return nr;
        }

        public String getData() {
            return data;
        }

        private int nr;
        private String data;

        public Query (int nr, String data){
            this.nr=nr;
            this.data=data;
        }
    }
}
