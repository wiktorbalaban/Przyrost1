package Quartz;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class QuerySaveJob implements org.quartz.Job {

    //final static Logger logger = Logger.getLogger(QuerySaveJob.class);

    public QuerySaveJob() {
    }

    public void execute(JobExecutionContext context) throws JobExecutionException {
       //logger.info("QuerySaveJob is execute.");

        BufferedReader br = null;
        FileReader fr = null;

        try {

            //br = new BufferedReader(new FileReader(FILENAME));
            fr = new FileReader("SQLQueryData/Zad/"+2+".txt");
            br = new BufferedReader(fr);

            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                System.out.println(sCurrentLine);
            }

        } catch (IOException e) {

           // logger.error(e);
            //e.printStackTrace();

        } finally {

            try {

                if (br != null)
                    br.close();

                if (fr != null)
                    fr.close();

            } catch (IOException ex) {

                ex.printStackTrace();

            }

        }
    }
}
