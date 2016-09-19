package com.youtu.common;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * UUID序列号
 * Created by jiax on 2016/9/19.
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

    /**生成订单的ID
     * @return
     */
    @SuppressWarnings("static-access")
    public synchronized String getUUIDNumber(){
        try {
            Thread.currentThread().sleep(1);
        } catch (InterruptedException e) {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            logger.warn(sw.toString());
        }
        String date = YoutuConstants.TWO + Long.valueOf(new Date().getTime()).toString();
        return date;
    }

//
//
//	/**该方法已经用于生成以日期为订单号。(最后两位最为随机数，让其不要相同)
//	 * @return
//	 */
//	public static String getUUIDNumber() {
//		Date currentTime = new Date();
////		Long result = currentTime.getTime();
//		SimpleDateFormat formatter = new SimpleDateFormat("yyMMddHHmmss");
//		String dateString = formatter.format(currentTime);
//		dateString = dateString.substring(0, dateString.length()-2)+GetRand.randWithFour();
//		UUID uuid = UUID.randomUUID();
////		return uuid.toString().replaceAll("-", "");
////		return result.toString();
//		return dateString;
//	}

    /**此方法用于生成UUId
     * @return
     */
    public static String createUUIDNumber(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString().replaceAll("-", "");
    }
}

