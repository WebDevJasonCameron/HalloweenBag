package org.scrapers.ParanormalDatabaseScraper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.models.GhostRecord;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParanormalDatabaseScraper {

    // VARs
    private static String[] urls = { "https://www.paranormaldatabase.com/berkshire/berkdata.php",       // 1
                                    "https://www.paranormaldatabase.com/buckinghamshire/buckdata.php",
                                    "https://www.paranormaldatabase.com/hampshire/hampdata.php",
                                    "https://www.paranormaldatabase.com/islewight/wighdata.php",
                                    "https://www.paranormaldatabase.com/kent/kentdata.php",
                                    "https://www.paranormaldatabase.com/oxfordshire/oxfodata.php",
                                    "https://www.paranormaldatabase.com/surrey/surrdata.php",
                                    "https://www.paranormaldatabase.com/sussex/suspages/sussdata.php",
                                    "https://www.paranormaldatabase.com/hotspots/brighton.php",
                                    "https://www.paranormaldatabase.com/hotspots/canterbury.php",
                                    "https://www.paranormaldatabase.com/hotspots/eastbourne.php",
                                    "https://www.paranormaldatabase.com/hotspots/pluckley.php",
                                    "https://www.paranormaldatabase.com/hotspots/portsmouth.php",
                                    "https://www.paranormaldatabase.com/hotspots/rye.php",
                                    "https://www.paranormaldatabase.com/hotspots/winchester.php",
                                    "https://www.paranormaldatabase.com/cornwall/pages/corndata.php",   // 2
                                    "https://www.paranormaldatabase.com/devon/devodata.php",
                                    "https://www.paranormaldatabase.com/dorset/dorsdata.php",
                                    "https://paranormaldatabase.com/gloucestershire/glosdata.php",
                                    "https://www.paranormaldatabase.com/somerset/somedata.php",
                                    "https://www.paranormaldatabase.com/wiltshire/wiltdata.php",
                                    "https://www.paranormaldatabase.com/hotspots/avebury.php",
                                    "https://www.paranormaldatabase.com/hotspots/bath.php",
                                    "https://www.paranormaldatabase.com/hotspots/blandford.php",
                                    "https://www.paranormaldatabase.com/hotspots/bournemouth.php",
                                    "https://www.paranormaldatabase.com/hotspots/bristol.php",
                                    "https://www.paranormaldatabase.com/hotspots/dartmoor.php",
                                    "https://www.paranormaldatabase.com/hotspots/devizes.php",
                                    "https://www.paranormaldatabase.com/hotspots/dorchester.php",
                                    "https://www.paranormaldatabase.com/hotspots/exeter.php",
                                    "https://www.paranormaldatabase.com/hotspots/poole.php",
                                    "https://www.paranormaldatabase.com/hotspots/salisbury.php",
                                    "https://www.paranormaldatabase.com/hotspots/swindon.php",
                                    "https://www.paranormaldatabase.com/london/lonpages/londdata.php",  // 3
                                    "https://www.paranormaldatabase.com/reports/underground.php",
                                    "https://www.paranormaldatabase.com/hotspots/E1.php",
                                    "https://www.paranormaldatabase.com/hotspots/EC1.php",
                                    "https://www.paranormaldatabase.com/hotspots/EC3.php",
                                    "https://www.paranormaldatabase.com/hotspots/EC4.php",
                                    "https://www.paranormaldatabase.com/hotspots/NW3.php",
                                    "https://www.paranormaldatabase.com/hotspots/SE1.php",
                                    "https://www.paranormaldatabase.com/hotspots/SW1.php",
                                    "https://www.paranormaldatabase.com/hotspots/W1.php",
                                    "https://www.paranormaldatabase.com/hotspots/W4.php",
                                    "https://www.paranormaldatabase.com/hotspots/WC1.php",
                                    "https://www.paranormaldatabase.com/hotspots/WC2.php",
                                    "https://www.paranormaldatabase.com/bedfordshire/bedforddata.php",  // 4
                                    "https://www.paranormaldatabase.com/cambridge/campages/cambdata.php",
                                    "https://www.paranormaldatabase.com/essex/esspages/essedata.php",
                                    "https://www.paranormaldatabase.com/hertfordshire/hertdata.php",
                                    "https://www.paranormaldatabase.com/norfolk/norpages/norfdata.php",
                                    "https://www.paranormaldatabase.com/suffolk/sufpages/suffdata.php",
                                    "https://www.paranormaldatabase.com/hotspots/bedford.php",
                                    "https://www.paranormaldatabase.com/hotspots/cambridge.php",
                                    "https://www.paranormaldatabase.com/hotspots/ipswich.php",
                                    "https://www.paranormaldatabase.com/hotspots/kingslynn.php",
                                    "https://www.paranormaldatabase.com/hotspots/kingslynn.php",
                                    "https://www.paranormaldatabase.com/hotspots/lowestoft.php",
                                    "https://www.paranormaldatabase.com/hotspots/norwich.php",
                                    "https://www.paranormaldatabase.com/hotspots/peterborough.php",
                                    "https://www.paranormaldatabase.com/hotspots/thetford.php",
    "",
    "",
    "",
    "",
    "",
    "",
    "",
    "",
    "",
    "",
    "",
    "",
    "",
    "",
    "",
    ""} ;

    private static String targetUrl = urls[0];
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

}
