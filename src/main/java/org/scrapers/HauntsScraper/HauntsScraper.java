package org.scrapers.HauntsScraper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.models.GhostRecord;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HauntsScraper {

    // VARs
    private static String[] states = {  "alabama",
            "alaska",
            "arizona",
            "arkansas",
            "california",
            "colorado",
            "connecticut",
            "delaware",
            "florida",
            "georgia",
            "hawaii",
            "idaho",
            "illinois",
            "indiana",
            "iowa",
            "kansas",
            "kentucky",
            "louisiana",
            "maine",
            "maryland",
            "massachusetts",
            "michigan",
            "minnesota",
            "mississippi",
            "missouri",
            "montana",
            "nebraska",
            "nevada",
            "new-hampshire",
            "new-jersey",
            "new-mexico",
            "new-york",
            "north-carolina",
            "north-dakota",
            "ohio",
            "oklahoma",
            "oregon",
            "pennsylvania",
            "rhode-island",
            "south-carolina",
            "south-dakota",
            "tennessee",
            "texas",
            "utah",
            "vermont",
            "virginia",
            "washington",
            "west-virginia",
            "wisconsin",
            "wyoming"
    };
    private static String state = states[0] ;
    private static String targetUrl = "https://www.haunts.com/blog/haunted-places-" + "washington" + "-usa.html";
    private List<GhostRecord> ghostRecords = new ArrayList<>();


    // FUN
    public static Document ghostRecordScraper(String targetUrl) {

        try {

            Document doc = Jsoup.connect(targetUrl).timeout(6000).get();
            Elements body = doc.select("div.container");

            for(Element e : body.select("div h2")){

                System.out.println("---");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
