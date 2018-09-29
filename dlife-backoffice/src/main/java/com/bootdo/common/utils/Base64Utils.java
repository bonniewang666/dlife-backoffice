package com.bootdo.common.utils;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class Base64Utils {
    public static String encode(String text) throws UnsupportedEncodingException {
        final Base64.Encoder encoder = Base64.getEncoder();
        String encoderData=text;
            final byte[] textByte = text.getBytes("UTF-8");
            encoderData=encoder.encodeToString(textByte);
        return encoderData;
    }

    public static String decode(String encodeText)  {
        final Base64.Decoder decoder = Base64.getDecoder();
        String decodeData=encodeText;
        try {
            decodeData=new String(decoder.decode(encodeText), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } finally {
            return decodeData;
        }
    }

}
