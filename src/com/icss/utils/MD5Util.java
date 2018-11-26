/*  1:   */ package com.icss.utils;
/*  2:   */ 
/*  3:   */ import java.io.PrintStream;
/*  4:   */ import javax.crypto.Cipher;
/*  5:   */ import javax.crypto.spec.IvParameterSpec;
/*  6:   */ import javax.crypto.spec.SecretKeySpec;
/*  7:   */ 
/*  8:   */ public class MD5Util
/*  9:   */ {
/* 10:   */   public static void main(String[] args)
/* 11:   */   {
/* 12:16 */     System.out.println(EncryptStr("1"));
/* 13:   */   }
/* 14:   */   
/* 15:19 */   private static byte[] _keys = { 18, 52, 86, 120, -112, 
/* 16:20 */     -85, -51, -17 };
/* 17:21 */   private static String _encryptKey = "HytBSoft";
/* 18:   */   
/* 19:   */   public static String EncryptStr(String encryptStr)
/* 20:   */   {
/* 21:24 */     if ((encryptStr != null) && (encryptStr.length() > 0)) {
/* 22:   */       try
/* 23:   */       {
/* 24:26 */         SecretKeySpec key = new SecretKeySpec(_encryptKey.getBytes(), "DES");
/* 25:27 */         Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
/* 26:28 */         IvParameterSpec iv = new IvParameterSpec(_keys);
/* 27:29 */         cipher.init(1, key, iv);
/* 28:30 */         return encode(cipher.doFinal(encryptStr.getBytes()));
/* 29:   */       }
/* 30:   */       catch (Exception e)
/* 31:   */       {
/* 32:33 */         e.printStackTrace();
/* 33:34 */         return null;
/* 34:   */       }
/* 35:   */     }
/* 36:38 */     return null;
/* 37:   */   }
/* 38:   */   
/* 39:40 */   private static final char[] legalChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
/* 40:   */   
/* 41:   */   public static String encode(byte[] data)
/* 42:   */   {
/* 43:47 */     int start = 0;
/* 44:48 */     int len = data.length;
/* 45:49 */     StringBuffer buf = new StringBuffer(data.length * 3 / 2);
/* 46:   */     
/* 47:51 */     int end = len - 3;
/* 48:52 */     int i = start;
/* 49:53 */     int n = 0;
/* 50:55 */     while (i <= end)
/* 51:   */     {
/* 52:56 */       int d = (data[i] & 0xFF) << 16 | 
/* 53:57 */         (data[(i + 1)] & 0xFF) << 8 | 
/* 54:58 */         data[(i + 2)] & 0xFF;
/* 55:   */       
/* 56:60 */       buf.append(legalChars[(d >> 18 & 0x3F)]);
/* 57:61 */       buf.append(legalChars[(d >> 12 & 0x3F)]);
/* 58:62 */       buf.append(legalChars[(d >> 6 & 0x3F)]);
/* 59:63 */       buf.append(legalChars[(d & 0x3F)]);
/* 60:   */       
/* 61:65 */       i += 3;
/* 62:67 */       if (n++ >= 14)
/* 63:   */       {
/* 64:68 */         n = 0;
/* 65:69 */         buf.append(" ");
/* 66:   */       }
/* 67:   */     }
/* 68:73 */     if (i == start + len - 2)
/* 69:   */     {
/* 70:74 */       int d = (data[i] & 0xFF) << 16 | 
/* 71:75 */         (data[(i + 1)] & 0xFF) << 8;
/* 72:   */       
/* 73:77 */       buf.append(legalChars[(d >> 18 & 0x3F)]);
/* 74:78 */       buf.append(legalChars[(d >> 12 & 0x3F)]);
/* 75:79 */       buf.append(legalChars[(d >> 6 & 0x3F)]);
/* 76:80 */       buf.append("=");
/* 77:   */     }
/* 78:81 */     else if (i == start + len - 1)
/* 79:   */     {
/* 80:82 */       int d = (data[i] & 0xFF) << 16;
/* 81:   */       
/* 82:84 */       buf.append(legalChars[(d >> 18 & 0x3F)]);
/* 83:85 */       buf.append(legalChars[(d >> 12 & 0x3F)]);
/* 84:86 */       buf.append("==");
/* 85:   */     }
/* 86:89 */     return buf.toString();
/* 87:   */   }
/* 88:   */ }
