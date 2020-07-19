package com.example.tluapp.workedThread;

import android.app.Activity;
import android.os.AsyncTask;

import com.example.tluapp.Entities.SubjectMark;
import com.example.tluapp.init.Init;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.FormElement;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Map;

public class SubMarkAsynTask extends AsyncTask<Map<String, String>, Integer, ArrayList<SubjectMark>> {
    private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.103 Safari/537.36";
    private static final String USER_NAME = "1651171173";
    private static final String PASSWORD = "01674918220t";



    private ArrayList<SubjectMark> getSubjectMark(Map<String, String>[] cookie) throws NoSuchAlgorithmException, IOException {
        ArrayList<SubjectMark> listMark = new ArrayList<>();

        Connection.Response goToStudentMark = Jsoup.connect("http://dkh.tlu.edu.vn/CMCSoft.IU.Web.info/StudentMark.aspx")
                .method(Connection.Method.GET)
                .userAgent(USER_AGENT)
                .cookies(cookie[0])
                .execute();
        Document document = goToStudentMark.parse();
        Element studentMark = document.select("table#tblStudentMark").first();
        Elements rowPoint = studentMark.getElementsByTag("tr");
        String subName = null;
        String subMark = null;
        String strMark = null;
        int count = 0;
        for(Element e : rowPoint){
            Elements p = e.getElementsByTag("td");
            for(Element e1 : p){
                count++;
                if (count == 3) subName = e1.text();
                if (count == 13) subMark = e1.text();
                if (count == 14) strMark = e1.text();
            }
            count = 0;
            listMark.add(new SubjectMark(subName, subMark, strMark));
        }
        return listMark;
    }



    @Override
    protected ArrayList<SubjectMark> doInBackground(Map<String, String>... maps) {
        ArrayList<SubjectMark> list = new ArrayList<>();
        try {
            list = getSubjectMark(maps);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    protected void onPostExecute(ArrayList<SubjectMark> subjectMarks) {
        super.onPostExecute(subjectMarks);
    }
}
