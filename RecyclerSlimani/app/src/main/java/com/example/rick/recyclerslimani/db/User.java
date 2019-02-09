package com.example.rick.recyclerslimani.db;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "users")
public class User {

    @PrimaryKey
    @NonNull
    public String username;

    @ColumnInfo(name = "user_pass")
    public String password;

    @NonNull
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(@NonNull String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
