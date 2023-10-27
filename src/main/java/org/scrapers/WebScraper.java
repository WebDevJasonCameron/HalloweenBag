package org.scrapers;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class WebScraper {

    private static final String PURL = "https://www.ghostquest.net/haunted-places-washington-usa.html";

    public static void main(String[] args) throws IOException {

        InputStream stream = null;
        BufferedInputStream buf = null;

        try {
            URL url = new URL(PURL);
            stream = url.openStream();
            buf = new BufferedInputStream(stream);

            StringBuilder sb = new StringBuilder();

            while (true) {
                int data = buf.read();

                if (data == -1) {
                    break;
                } else {
                    sb.append((char) data);
                }
            }

            System.out.println(sb);


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            stream.close();
            buf.close();
            System.out.println("Completed Run");
        }

    }

}
