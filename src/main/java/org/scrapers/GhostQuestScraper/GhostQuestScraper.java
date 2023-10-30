package org.scrapers.GhostQuestScraper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.models.GhostRecord;

import javax.print.Doc;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GhostQuestScraper {

    // VARs
    private static String[] states = {        "alabama",
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
    private static String targetUrl = "https://www.ghostquest.net/haunted-places-" + "washington" + "-usa.html";
    private List<GhostRecord> ghostRecords = new ArrayList<>();

    // FUN
    public static Document ghostRecordScraper(String targetUrl) {

        try {

            Document doc = Jsoup.connect(targetUrl).timeout(6000).get();
            Elements body = doc.select("div.container");

            for(Element e : body.select("div.paragraph")){
                String upperMeta = e.select("div.paragraph").text();
                System.out.println(upperMeta);
                System.out.println("---");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) {
        ghostRecordScraper(targetUrl);
    }
}
