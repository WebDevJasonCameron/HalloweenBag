package org.scrapers;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class JSoupWebScraper {

    public static void main(String[] args) {

        try {
            String url = "https://www.imdb.com/";
            Document doc = Jsoup.connect(url).get();

            System.out.println(doc);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
