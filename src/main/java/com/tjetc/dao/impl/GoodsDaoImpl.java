package com.tjetc.dao.impl;

import com.tjetc.dao.GoodsDao;
import com.tjetc.domain.Goods;
import com.tjetc.util.DButil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GoodsDaoImpl implements GoodsDao {
    @Override
    public int insert(Goods g) {
        Connection conn = DButil.getConnection();
        PreparedStatement pstmt = DButil.getPstmt(conn,"insert into goods(name,image,price) values(?,?,?)",g.getName(),g.getImage(),g.getPrice());
        int i = DButil.update(pstmt);
        DButil.close(conn,pstmt,null);
        return i;
    }

    @Override
    public List<Goods> selectAll() {
        Connection conn = DButil.getConnection();
        PreparedStatement pstmt = DButil.getPstmt(conn,"select * from goods");
        ResultSet rs = DButil.query(pstmt);
        List<Goods> list = new ArrayList<Goods>();
        try {
            while (rs.next()){
                list.add(new Goods(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("image"),
                        rs.getDouble("price")));
            }
            return list;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
}
