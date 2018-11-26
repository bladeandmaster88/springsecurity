/*  1:   */ package com.icss.utils;
/*  2:   */ 
/*  3:   */ import java.util.UUID;
/*  4:   */ 
/*  5:   */ public class GUID
/*  6:   */ {
/*  7:   */   private static String guid;
/*  8:   */   
/*  9:   */   public static String getGuid()
/* 10:   */   {
/* 11:13 */     guid = UUID.randomUUID().toString();
/* 12:14 */     return guid;
/* 13:   */   }
 }
