package com.example.rick.recyclerslimani.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface User_DAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public void addUser(User user);

    @Query("select * from users where username =:username")
    public List<User> getUser(String username);

    @Query("select * from users")
    public List<User> getUsers();

    @Delete
    public void deleteUser(User user);

    @Update
    public void updateUser(User user);

}
