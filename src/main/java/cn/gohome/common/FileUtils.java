package cn.gohome.common;

import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * Created by Ned on 2015/9/25.
 * Modified by Jason on 2016/6/22.
 */
public class FileUtils {
    private static final int BUFFER_SIZE = 100 * 1024;//2*1024

    public static void saveUploadFile(MultipartFile src, File dst) {
        InputStream in = null;
        OutputStream out = null;
        try {
            if (dst.exists()) {
                out = new BufferedOutputStream(new FileOutputStream(dst, true),
                        BUFFER_SIZE);
            } else {
                out = new BufferedOutputStream(new FileOutputStream(dst),
                        BUFFER_SIZE);
            }
            in = new BufferedInputStream(src.getInputStream(), BUFFER_SIZE);

            byte[] buffer = new byte[BUFFER_SIZE];
            int len = 0;
            while ((len = in.read(buffer)) > 0) {
                out.write(buffer, 0, len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != in) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != out) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void isPathExist(String path) {
        File file = new File(path);
        if (!file.exists())
            file.mkdirs();
    }

    /**
     * 以字符为单位读取文件，常用于读文本，数字等类型的文件
     * Added by Jason
     *
     * @param File file
     *             return String
     */
    public static String readFileByChars(File file) {
        //      File file = new File(fileName);
        Reader reader = null;
        String s = "";

        try {
            System.out.println("以字符为单位读取文件内容，一次读一个字节：");
            // 一次读一个字符  
            reader = new InputStreamReader(new FileInputStream(file));
            int tempchar;
            int i = 0;
            while ((tempchar = reader.read()) != -1) {
                // 对于windows下，rn这两个字符在一起时，表示一个换行。  
                // 但如果这两个字符分开显示时，会换两次行。  
                // 因此，屏蔽掉r，或者屏蔽n。否则，将会多出很多空行。  
                if (((char) tempchar) != 'r') {
                    char tmp = (char) tempchar;
                    //data[i]=tmp;
                    s += tmp;
                    i++;
                }
            }
            //
            //char[] --> String
            // s=data.toString();
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        /*
        finally{
        	if(reader!=null)
        	{
        		try{
        			reader.close();
        		}catch(IOException e1){}
        	}
        }*/
        return s;
    }


}
