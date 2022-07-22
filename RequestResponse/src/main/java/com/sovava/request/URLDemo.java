package com.sovava.request;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Description: TODO
 *
 * @author: ykn
 * @date: 2022年07月21日 21:24
 **/
public class URLDemo {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String username = "张三";
        //编码
        String encode = URLEncoder.encode(username,"utf-8");
        System.out.println(encode);
        //解码
        String decode = URLDecoder.decode(encode,"ISO-8859-1");
        System.out.println(decode);


        byte[] bytes = decode.getBytes("ISO-8859-1");
        System.out.println(bytes);
        for (byte b:bytes){
            System.out.print(b);
        }
        System.out.println();

        String s = new String(bytes,"utf-8");
        System.out.println(s);

    }
}
