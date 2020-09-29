package com.tjetc.dao;

import com.tjetc.domain.Goods;

import java.util.List;

public interface GoodsDao {
    int insert(Goods g);
    List<Goods> selectAll();
}
