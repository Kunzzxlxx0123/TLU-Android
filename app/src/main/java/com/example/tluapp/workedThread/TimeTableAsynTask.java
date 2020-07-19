package com.example.tluapp.workedThread;

import android.os.AsyncTask;
import android.os.Build;
import android.os.PowerManager;

import androidx.annotation.RequiresApi;

import com.example.tluapp.Entities.TimeTable;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Map;

public class TimeTableAsynTask extends AsyncTask<Map<String,String>, Integer, ArrayList<TimeTable>> {

    private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.103 Safari/537.36";

    @RequiresApi(api = Build.VERSION_CODES.N)
    static int count = 0;
    private ArrayList<TimeTable> getListTimeTable(Map<String, String>[] cookie) throws IOException {
        ArrayList<TimeTable> list = new ArrayList<>();
        Connection.Response response = Jsoup.connect("http://dkh.tlu.edu.vn/CMCSoft.IU.Web.info/StudyRegister/StudyRegister.aspx")
                .method(Connection.Method.GET)
                .userAgent(USER_AGENT)
                .cookies(cookie[0])
                .execute();

        Document document = response.parse();
        Element timeTable = document.select("table#gridRegistered").first();
        Elements tr = timeTable.getElementsByTag("tr");

        String subName = null;
        String time = null;
        String location = null;

        int count = 0;
        for(Element e : tr){
            Elements td = e.getElementsByTag("td");
            for (Element e1 : td){
                count++;
                if(count == 3) subName = e1.text();
                if(count == 5) time = e1.text();
                if(count == 6) location = e1.text();

            }
            count = 0;
            list.add(new TimeTable(subName, time, location));
        }

        return  list;
    }

    @Override
    protected ArrayList<TimeTable> doInBackground(Map<String, String>... maps) {
        ArrayList<TimeTable> list = new ArrayList<TimeTable>();
        try {
            list = getListTimeTable(maps);
        } catch (IOException e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    protected void onPostExecute(ArrayList<TimeTable> timeTables) {
        super.onPostExecute(timeTables);
    }
}
