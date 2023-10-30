package org.scrapers;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class JSoupWebScraper {

    public static void main(String[] args) {

        String url = "https://www.imdb.com/chart/top/";



        try {

            Document doc = Jsoup.connect(url).timeout(6000).get();
            Elements body = doc.select("ul.ipc-metadata-list");
//            System.out.println(body.select("li").size());

            for(Element e : body.select("li")){
                String title = e.select("div.ipc-metadata-list-summary-item__c").text();
                System.out.println(title);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
