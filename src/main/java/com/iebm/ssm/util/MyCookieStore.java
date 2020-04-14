package com.iebm.ssm.util;

import org.apache.http.client.CookieStore;

import java.io.*;

public class MyCookieStore {

    /**
     * 保存cookies
     * @param cookie
     * @param savePath
     * @throws IOException
     */
    public static void saveCookieStore(CookieStore cookie, String savePath) throws IOException {
        FileOutputStream fos = new FileOutputStream(savePath);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(cookie);
        oos.close();
    }


    /**
     *读取cookies
     * @param savePath
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static CookieStore readCookieStore(String savePath) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("cookie");
        ObjectInputStream ois = new ObjectInputStream(fis);
        CookieStore cookieStore = (CookieStore) ois.readObject();
        ois.close();
        return cookieStore;
    }
}
