package org.scrapers.GhostQuestScraper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.models.GhostRecord;

import javax.print.Doc;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GhostQuestScraper {

    // VARs
    private String[] states = {        "alabama",
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
    private String state = states[0] ;
    private String targetUrl = "https://www.ghostquest.net/haunted-places-" + state + "-usa.html";
    private List<GhostRecord> ghostRecords = new ArrayList<>();

    // FUN
    public Document ghostRecordScraper() {

        try {
            String url = "https://www.imdb.com/";
            Document doc = Jsoup.connect(url).get();

            System.out.println(doc);
            return doc;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
