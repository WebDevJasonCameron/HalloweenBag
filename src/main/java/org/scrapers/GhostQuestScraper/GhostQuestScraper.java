package org.scrapers.GhostQuestScraper;

import org.models.GhostRecord;

public class GhostQuestScraper {

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

    private GhostRecord ghostRecord = new GhostRecord();



}
