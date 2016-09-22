package com.youtu.service;

import java.util.List;

/**
 * Created by jiax on 2016/9/21.
 */
public interface LosterService {
    /**
     * 获得地址列表
     * @param age
     * @param gender
     * @return
     */
    List<String> getUrl (int age, int gender);

    /**
     * 获得地址列表
     * @param maxAge
     * @param minAge
     * @param gender
     * @return
     */
    List<String> getUrl (int minAge, int maxAge ,int gender);
}
