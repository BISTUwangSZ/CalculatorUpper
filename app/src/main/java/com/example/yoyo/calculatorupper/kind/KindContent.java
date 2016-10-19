package com.example.yoyo.calculatorupper.kind;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class KindContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<KindItem> ITEMS = new ArrayList<KindItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, KindItem> ITEM_MAP = new HashMap<String, KindItem>();

    private static final int COUNT = 25;

    static {
        // Add some sample items.
        addItem(new KindItem("1","长度","长度"));
        addItem(new KindItem("2","重量","重量"));
        addItem(new KindItem("3","时间","时间"));

    }

    private static void addItem(KindItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }


    /**
     * A dummy item representing a piece of content.
     */
    public static class KindItem {
        public final String id;
        public final String content;
        public final String kinds;


        public KindItem(String id,String content,String kinds) {
            this.id = id;
            this.content = content;
            this.kinds = kinds;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}
