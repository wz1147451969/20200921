package com.tjetc.service;

import com.tjetc.domain.Goods;

import java.util.List;

public interface GoodsService {
    String addGoods(Goods g);
    List<Goods> findAll();
}
