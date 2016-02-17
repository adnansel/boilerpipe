package com.kohlschutter.boilerpipe.document;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * TODO Add description
 *
 * @author Adnan Selimovic
 */
public class Metadata {

    private final OpenGraph openGraph;

    public Metadata() {
        openGraph = new OpenGraph();
    }

    public OpenGraph getOpenGraph() {
        return openGraph;
    }

    public static class OpenGraph {
        public static String TITLE = "og:title";
        public static String TYPE = "og:type";
        public static String IMAGE = "og:image";
        public static String URL = "og:url";
        public static String VIDEO = "og:video";
        public static String DESCRIPTION = "og:description";

        public static Set<String> OG_TAGS = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);

        private final Map<String, String> values;

        static {
            OG_TAGS.add(TITLE);
            OG_TAGS.add(TYPE);
            OG_TAGS.add(IMAGE);
            OG_TAGS.add(URL);
            OG_TAGS.add(VIDEO);
            OG_TAGS.add(DESCRIPTION);
        }


        public OpenGraph() {
            this.values = new HashMap<>();
        }

        public void setValue(String tag, String value) {
            this.values.put(tag, value);
        }

        public String getValue(String tag) {
            return this.values.getOrDefault(tag, null);
        }

        public static boolean isValidTag(String tag) {
            return OG_TAGS.contains(tag);
        }


    }
}
