/*  1:   */ package com.icss.model;
/*  2:   */ 
/*  3:   */ public class RoleMenu
/*  4:   */ {
/*  5:   */   private String id;
/*  6:   */   private String roleId;
/*  7:   */   private String menuNo;
/*  8:   */   
/*  9:   */   public String getId()
/* 10:   */   {
/* 11:11 */     return this.id;
/* 12:   */   }
/* 13:   */   
/* 14:   */   public void setId(String id)
/* 15:   */   {
/* 16:15 */     this.id = (id == null ? null : id.trim());
/* 17:   */   }
/* 18:   */   
/* 19:   */   public String getRoleId()
/* 20:   */   {
/* 21:19 */     return this.roleId;
/* 22:   */   }
/* 23:   */   
/* 24:   */   public void setRoleId(String roleId)
/* 25:   */   {
/* 26:23 */     this.roleId = (roleId == null ? null : roleId.trim());
/* 27:   */   }
/* 28:   */   
/* 29:   */   public String getMenuNo()
/* 30:   */   {
/* 31:27 */     return this.menuNo;
/* 32:   */   }
/* 33:   */   
/* 34:   */   public void setMenuNo(String menuNo)
/* 35:   */   {
/* 36:31 */     this.menuNo = (menuNo == null ? null : menuNo.trim());
/* 37:   */   }
/* 38:   */ }