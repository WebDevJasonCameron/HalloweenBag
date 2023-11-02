package org.scrapers.ParanormalDatabaseScraper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.models.GhostRecord;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
                                    "https://www.paranormaldatabase.com/derbyshire/derbdata.php",   // 5
                                    "https://www.paranormaldatabase.com/leicestershire/leicdata.php",
                                    "https://www.paranormaldatabase.com/lincolnshire/lincdata.php",
                                    "https://www.paranormaldatabase.com/northants/pages/nantdata.php",
                                    "https://www.paranormaldatabase.com/nottinghamshire/nottdata.php",
                                    "https://www.paranormaldatabase.com/Rutland/rutlanddata.php",
                                    "https://www.paranormaldatabase.com/hotspots/derby.php",
                                    "https://www.paranormaldatabase.com/hotspots/glossop.php",
                                    "https://www.paranormaldatabase.com/hotspots/Leicester.php",
                                    "https://www.paranormaldatabase.com/hotspots/newark.php",
                                    "https://www.paranormaldatabase.com/hotspots/northampton.php",
                                    "https://www.paranormaldatabase.com/hotspots/nottingham.php",
                                "https://www.paranormaldatabase.com/hereford/heredata.php", // 6
                                "https://www.paranormaldatabase.com/shropshire/shrodata.php",
                                "https://www.paranormaldatabase.com/staffordshire/stafdata.php",
                                "https://www.paranormaldatabase.com/warwickshire/warwdata.php",
                                "https://www.paranormaldatabase.com/westmidlands/westdata.php",
                                "https://www.paranormaldatabase.com/hotspots/birmingham.php",
                                "https://www.paranormaldatabase.com/hotspots/burtonontrent.php",
                                "https://www.paranormaldatabase.com/hotspots/coventry.php",
                                    "https://www.paranormaldatabase.com/cheshire/chesdata.php", // 7
                                    "https://www.paranormaldatabase.com/cumbria/cumbdata.php",
                                    "https://www.paranormaldatabase.com/greatermanchester/index.php",
                                    "https://www.paranormaldatabase.com/lancashire/lancdata.php",
                                    "https://www.paranormaldatabase.com/merseyside/index.php",
                                    "https://www.paranormaldatabase.com/hotspots/blackpool.php",
                                    "https://www.paranormaldatabase.com/hotspots/bolton.php",
                                    "https://www.paranormaldatabase.com/hotspots/burnley.php",
                                    "https://www.paranormaldatabase.com/hotspots/carlisle.php",
                                    "https://www.paranormaldatabase.com/hotspots/chester.php",
                                    "https://www.paranormaldatabase.com/hotspots/liverpool.php",
                                    "https://www.paranormaldatabase.com/hotspots/manchester.php",
                                "https://www.paranormaldatabase.com/durham/durhdata.php",   // 8
                                "https://www.paranormaldatabase.com/northumberland/nhumdata.php",
                                "https://www.paranormaldatabase.com/tyneandwear/index.php",
                                "https://www.paranormaldatabase.com/yorkshire/Pages/yorkdata.php",
                                "https://www.paranormaldatabase.com/hotspots/Darlington.php",
                                "https://www.paranormaldatabase.com/hotspots/durham.php",
                                "https://www.paranormaldatabase.com/hotspots/leeds.php",
                                "https://www.paranormaldatabase.com/hotspots/newcastle.php",
                                "https://www.paranormaldatabase.com/hotspots/sheffield.php",
                                "https://www.paranormaldatabase.com/hotspots/wakefield.php",
                                "https://www.paranormaldatabase.com/yorkshire/Pages/york.php",
                                    "https://www.paranormaldatabase.com/highlands/aberdata.php", // 9
                                    "https://www.paranormaldatabase.com/highlands/Argydata.php",
                                    "https://www.paranormaldatabase.com/highlands/Highdata.php",
                                    "https://www.paranormaldatabase.com/highlands/Invedata.php",
                                    "https://www.paranormaldatabase.com/islands/orcndata.php",
                                    "https://www.paranormaldatabase.com/islands/outedata.php",
                                    "https://www.paranormaldatabase.com/islands/Shetdata.php",
                                    "https://www.paranormaldatabase.com/lowlands/Angudata.php",
                                    "https://www.paranormaldatabase.com/lowlands/Ayrsdata.php",
                                    "https://www.paranormaldatabase.com/lowlands/borddata.php",
                                    "https://www.paranormaldatabase.com/lowlands/clacdata.php",
                                    "https://www.paranormaldatabase.com/lowlands/dumbdata.php",
                                    "https://www.paranormaldatabase.com/lowlands/dumfdata.php",
                                    "https://www.paranormaldatabase.com/lowlands/falkdata.php",
                                    "https://www.paranormaldatabase.com/lowlands/Fifedata.php",
                                    "https://www.paranormaldatabase.com/lowlands/lanadata.php",
                                    "https://www.paranormaldatabase.com/lowlands/lothdata.php",
                                    "https://www.paranormaldatabase.com/lowlands/moradata.php",
                                    "https://www.paranormaldatabase.com/lowlands/pertdata.php",
                                    "https://www.paranormaldatabase.com/lowlands/renfdata.php",
                                    "https://www.paranormaldatabase.com/lowlands/sterdata.php",
                                    "https://www.paranormaldatabase.com/hotspots/aberdeen.php",
                                    "https://www.paranormaldatabase.com/hotspots/edinburgh.php",
                                    "https://www.paranormaldatabase.com/hotspots/glasgow.php",
                                "https://www.paranormaldatabase.com/wales/clwyd.php", // 10
                                "https://www.paranormaldatabase.com/wales/Dyfed.php",
                                "https://www.paranormaldatabase.com/wales/Gwent.php",
                                "https://www.paranormaldatabase.com/wales/Gwynedd.php",
                                "https://www.paranormaldatabase.com/wales/MidGlamorgan.php",
                                "https://www.paranormaldatabase.com/wales/Powys.php",
                                "https://www.paranormaldatabase.com/wales/SouthGlamorgan.php",
                                "https://www.paranormaldatabase.com/wales/WestGlamorgan.php",
                                    "https://www.paranormaldatabase.com/ireland/antrim.php", // 11
                                    "https://www.paranormaldatabase.com/ireland/armagh.php",
                                    "https://www.paranormaldatabase.com/ireland/down.php",
                                    "https://www.paranormaldatabase.com/ireland/fermanagh.php",
                                    "https://www.paranormaldatabase.com/ireland/londonderry.php",
                                    "https://www.paranormaldatabase.com/ireland/tyrone.php",
                                "https://www.paranormaldatabase.com/ireland/carlow.php", // 12
                                "https://www.paranormaldatabase.com/ireland/cavan.php",
                                "https://www.paranormaldatabase.com/ireland/clare.php",
                                "https://www.paranormaldatabase.com/ireland/cork.php",
                                "https://www.paranormaldatabase.com/ireland/donegal.php",
                                "https://www.paranormaldatabase.com/ireland/dublin.php",
                                "https://www.paranormaldatabase.com/ireland/galway.php",
                                "https://www.paranormaldatabase.com/ireland/kerry.php",
                                "https://www.paranormaldatabase.com/ireland/kildare.php",
                                "https://www.paranormaldatabase.com/ireland/kilkenny.php",
                                "https://www.paranormaldatabase.com/ireland/laois.php",
                                "https://www.paranormaldatabase.com/ireland/leitrim.php",
                                "https://www.paranormaldatabase.com/ireland/limerick.php",
                                "https://www.paranormaldatabase.com/ireland/longford.php",
                                "https://www.paranormaldatabase.com/ireland/louth.php",
                                "https://www.paranormaldatabase.com/ireland/mayo.php",
                                "https://www.paranormaldatabase.com/ireland/meath.php",
                                "https://www.paranormaldatabase.com/ireland/monaghan.php",
                                "https://www.paranormaldatabase.com/ireland/offaly.php",
                                "https://www.paranormaldatabase.com/ireland/roscommon.php",
                                "https://www.paranormaldatabase.com/ireland/sligo.php",
                                "https://www.paranormaldatabase.com/ireland/tipperary.php",
                                "https://www.paranormaldatabase.com/ireland/waterford.php",
                                "https://www.paranormaldatabase.com/ireland/westmeath.php",
                                "https://www.paranormaldatabase.com/ireland/westmeath.php",
                                "https://www.paranormaldatabase.com/ireland/wexford.php",
                                "https://www.paranormaldatabase.com/ireland/wicklow.php",
                                    "https://www.paranormaldatabase.com/isleofman/mandata.php", // 13
                                    "https://www.paranormaldatabase.com/channelislands/channelislands.php",
                                    "https://www.paranormaldatabase.com/europe/index.php",
                                    "https://www.paranormaldatabase.com/channelislands/guernsey.php",
                                    "https://www.paranormaldatabase.com/channelislands/jersey.php"} ;

    private static String targetUrl = urls[0];
    private List<GhostRecord> ghostRecords = new ArrayList<>();


    // FUN
    public static void paranormalDatabaseScraper(String targetUrl) {

        try {

            Document doc = Jsoup.connect(targetUrl).timeout(6000).get();
            Elements elements = doc.select("div.w3-border-left.w3-border-top.w3-left-align");

            for (Element element : elements){
                List<String> elementData = new ArrayList<>();

                elementData.add(element.select("div h4 span").text());                  //   title to array

                for (Element e2 : element.select("div p span")) {                       //   each to array
                    String output = Objects.requireNonNull(e2.nextSibling()).toString().trim();

                    if (!output.isEmpty()){                                                      //   skip blanks
                        elementData.add(output);
                    }
                }

                if (!elementData.get(0).isEmpty()){

                    String title = elementData.get(0);
                    String location = elementData.get(1);
                    String type = elementData.get(2);
                    String dateTime = elementData.get(3);
                    String comments = elementData.get(4);

                    System.out.println("Title: " + title);
                    System.out.println("Location: " + location);
                    System.out.println("Type: " + type);
                    System.out.println("Date & Time: " + dateTime);
                    System.out.println("Additional Comments: " + comments);
                } else {
                    break;
                }
                System.out.println("\n---\n");
            }



        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("App Completed");
    }

    // RUNs
    public static void main(String[] args) {
        paranormalDatabaseScraper(targetUrl);
    }

}
