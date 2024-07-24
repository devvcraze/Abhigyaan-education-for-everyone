package com.example.abhigyaan;

public class Item {
    private String key;
    private String title;
    private String section1;
    private String section2;
    private String section3;
    private boolean expanded;

    public Item() {
        // Default constructor required for calls to DataSnapshot.getValue(Item.class)
    }

    public Item(String key, String title, String section1, String section2, String section3) {
        this.key = key;
        this.title = title;
        this.section1 = section1;
        this.section2 = section2;
        this.section3 = section3;
        this.expanded = false;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getTitle() {
        return title;
    }

    public String getSection1() {
        return section1;
    }

    public String getSection2() {
        return section2;
    }

    public String getSection3() {
        return section3;
    }

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }
}
