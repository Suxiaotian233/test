package com.stx.fl.dao;

import core.DbTools;
import com.stx.fl.entity.Words;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WordsDao {


    public List<Words> selectAll() {
        List<Words> wordsList = new ArrayList<>();
        Connection conn =null;
        PreparedStatement stmt = null;
        ResultSet rs =null;

        Words words = null;
        try {
            conn = DbTools.getConnection();
            String sql = "SELECT * FROM words";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()){
                words = new Words();
                words.setId(rs.getInt("id"));
                words.setWord(rs.getString("word"));
                words.setTranslate(rs.getString("translate"));

                Timestamp time = rs.getTimestamp("addtime");
                Date addTime = new Date(time.getTime());
                words.setAddTime(addTime);

                wordsList.add(words);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbTools.close(rs);
            DbTools.close(stmt);
            DbTools.close(conn);
        }


        return wordsList;
    }
}
