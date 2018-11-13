package com.alihn.gituser;

import com.squareup.moshi.Json;

import java.util.List;

public class UserList {

    @Json(name = "items")
    private List<User> items;

    public List<User> getItemList() {
        return items;
    }

    public void setUserList(List<User> itemList) {
        this.items = itemList;
    }

}
