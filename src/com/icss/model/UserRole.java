/*  1:   */ package com.icss.model;
/*  2:   */ 
/*  3:   */ public class UserRole
/*  4:   */ {
/*  5:   */   private String id;
/*  6:   */   private String roleId;
/*  7:   */   private String userId;
/*  8:   */   private String userDep;
/*  9:   */   
/* 10:   */   public String getId()
/* 11:   */   {
/* 12:13 */     return this.id;
/* 13:   */   }
/* 14:   */   
/* 15:   */   public void setId(String id)
/* 16:   */   {
/* 17:17 */     this.id = (id == null ? null : id.trim());
/* 18:   */   }
/* 19:   */   
/* 20:   */   public String getRoleId()
/* 21:   */   {
/* 22:21 */     return this.roleId;
/* 23:   */   }
/* 24:   */   
/* 25:   */   public void setRoleId(String roleId)
/* 26:   */   {
/* 27:25 */     this.roleId = (roleId == null ? null : roleId.trim());
/* 28:   */   }
/* 29:   */   
/* 30:   */   public String getUserId()
/* 31:   */   {
/* 32:29 */     return this.userId;
/* 33:   */   }
/* 34:   */   
/* 35:   */   public void setUserId(String userId)
/* 36:   */   {
/* 37:33 */     this.userId = (userId == null ? null : userId.trim());
/* 38:   */   }
/* 39:   */   
/* 40:   */   public String getUserDep()
/* 41:   */   {
/* 42:37 */     return this.userDep;
/* 43:   */   }
/* 44:   */   
/* 45:   */   public void setUserDep(String userDep)
/* 46:   */   {
/* 47:41 */     this.userDep = (userDep == null ? null : userDep.trim());
/* 48:   */   }
/* 49:   */ }
