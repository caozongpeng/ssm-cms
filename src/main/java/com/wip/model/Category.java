/**
 * Created by IntelliJ IDEA.
 * User: Kyrie
 * DateTime: 2018/7/19 11:57
 **/
package com.wip.model;

public class Category {
    private Long id;
    private String name;
    private String displayName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}
