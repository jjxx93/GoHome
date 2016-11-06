package cn.gohome.service;

import com.alibaba.fastjson.JSONArray;

/**
 * Created by jiax on 2016/11/3.
 */
public interface CommonService {
    /**
     * 获取rows条数据
     * @param rows
     * @return
     */
    JSONArray getList (int rows);

    /**
     * 获取latestTime时间后的rows条数据
     * @param latestTime
     * @param rows
     * @return
     */
    JSONArray getList (String latestTime, int rows);

    /**
     * 获取earliestTime时间前的rows条数据
     * @param rows
     * @param earliestTime
     * @return
     */
    JSONArray getList (int rows, String earliestTime);
}
