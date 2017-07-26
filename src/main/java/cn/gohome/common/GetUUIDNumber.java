package cn.gohome.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;
import java.util.UUID;

/**
 * Created by jiax on 2016/9/19.
 *
 * 获取UUID序列号
 */
public class GetUUIDNumber {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private GetUUIDNumber(){}

    public static GetUUIDNumber getInstance(){
        return SinglentonHolder.sInstance;
    }

    private static class  SinglentonHolder{
        private static final GetUUIDNumber sInstance = new GetUUIDNumber();
    }

    /**
     * 生成订单的ID
     */
    public synchronized String getUUIDNumber(){
        try {
            Thread.currentThread().sleep(1);
        } catch (InterruptedException e) {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            logger.warn(sw.toString());
        }
        String date = Constants.TWO + Long.valueOf(new Date().getTime()).toString();
        return date;
    }

    /**
     * 此方法用于生成UUId
     *
     * @return uuid
     */
    public static String createUUIDNumber(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString().replaceAll("-", "");
    }
}

