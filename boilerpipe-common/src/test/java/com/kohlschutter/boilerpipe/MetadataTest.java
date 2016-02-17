package com.kohlschutter.boilerpipe;

import com.kohlschutter.boilerpipe.document.Metadata;
import com.kohlschutter.boilerpipe.document.TextDocument;
import com.kohlschutter.boilerpipe.jsoup.JsoupParser;
import org.junit.Test;
import org.xml.sax.SAXException;

import java.net.URL;

import static junit.framework.TestCase.assertEquals;

/**
 * TODO Add description
 *
 * @author Adnan Selimovic
 */
public class MetadataTest {

    @Test
    public void testExtractOpenGraphData() throws SAXException {
        JsoupParser parser = new JsoupParser();
        TextDocument doc = parser.parse(
                        "<html><head>" +
                        "<meta property=\"og:title\" content=\"About Our Company\"/>\n" +
                        "<meta property=\"og:type\" content=\"article\"/>\n" +
                        "<meta property=\"og:url\" content=\"http://www.mysite.com/article/\"/>\n" +
                        "<meta property=\"og:image\" content=\"http://www.mysite.com/articleimage.jpg\"/>\n" +
                        "<meta property=\"og:video\" content=\"http://www.mysite.com/video.swf\"/>\n" +
                        "<meta property=\"og:description\" content=\"A description of our services and company profile.\"/>" +
                        "</head><body></body></html>"
        );

        Metadata.OpenGraph openGraph = doc.getMetadata().getOpenGraph();

        assertEquals("About Our Company", openGraph.getValue("og:title"));
        assertEquals("article", openGraph.getValue("og:type"));
        assertEquals("http://www.mysite.com/article/", openGraph.getValue("og:url"));
        assertEquals("http://www.mysite.com/articleimage.jpg", openGraph.getValue("og:image"));
        assertEquals("http://www.mysite.com/video.swf", openGraph.getValue("og:video"));
        assertEquals("A description of our services and company profile.", openGraph.getValue("og:description"));
    }
}
