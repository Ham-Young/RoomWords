package com.example.roomwords;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface WordDao {

    //添加单词
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Word word);
//删除所有单词
@Query("DELETE FROM word_table")
    void deleteAll();

//查询所有单词
@Query("SELECT * from word_table ORDER BY word ASC")

 LiveData< List<Word>> getAllWords();


//查询任意单词，返回一条记录
    @Query("SELECT * from word_table LIMIT 1")
    Word[] getAnyWord();


    //删除单个单词
    @Delete
    void deleteWord(Word word);

}
