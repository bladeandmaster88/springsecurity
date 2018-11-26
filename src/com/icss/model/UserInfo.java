/*   1:    */ package com.icss.model;
/*   2:    */ 
/*   3:    */ import java.util.Date;
/*   4:    */ 
/*   5:    */ public class UserInfo
/*   6:    */ {
/*   7:    */   private String guid;
/*   8:    */   private String userCode;
/*   9:    */   private String password;
/*  10:    */   private String name;
/*  11:    */   private String status;
/*  12:    */   private String createUser;
/*  13:    */   private Date createTime;
/*  14:    */   private String updateUser;
/*  15:    */   private Date updateTime;
/*  16:    */   private String remark;
/*  17:    */   private String roleName;
/*  18:    */   private String roleId;
/*  19:    */   
/*  20:    */   public String getRoleName()
/*  21:    */   {
/*  22: 21 */     return this.roleName;
/*  23:    */   }
/*  24:    */   
/*  25:    */   public void setRoleName(String roleName)
/*  26:    */   {
/*  27: 25 */     this.roleName = roleName;
/*  28:    */   }
/*  29:    */   
/*  30:    */   public String getRoleId()
/*  31:    */   {
/*  32: 29 */     return this.roleId;
/*  33:    */   }
/*  34:    */   
/*  35:    */   public void setRoleId(String roleId)
/*  36:    */   {
/*  37: 33 */     this.roleId = roleId;
/*  38:    */   }
/*  39:    */   
/*  40:    */   public String getGuid()
/*  41:    */   {
/*  42: 47 */     return this.guid;
/*  43:    */   }
/*  44:    */   
/*  45:    */   public void setGuid(String guid)
/*  46:    */   {
/*  47: 51 */     this.guid = (guid == null ? null : guid.trim());
/*  48:    */   }
/*  49:    */   
/*  50:    */   public String getUserCode()
/*  51:    */   {
/*  52: 55 */     return this.userCode;
/*  53:    */   }
/*  54:    */   
/*  55:    */   public void setUserCode(String userCode)
/*  56:    */   {
/*  57: 59 */     this.userCode = (userCode == null ? null : userCode.trim());
/*  58:    */   }
/*  59:    */   
/*  60:    */   public String getPassword()
/*  61:    */   {
/*  62: 63 */     return this.password;
/*  63:    */   }
/*  64:    */   
/*  65:    */   public void setPassword(String password)
/*  66:    */   {
/*  67: 67 */     this.password = (password == null ? null : password.trim());
/*  68:    */   }
/*  69:    */   
/*  70:    */   public String getName()
/*  71:    */   {
/*  72: 71 */     return this.name;
/*  73:    */   }
/*  74:    */   
/*  75:    */   public void setName(String name)
/*  76:    */   {
/*  77: 75 */     this.name = (name == null ? null : name.trim());
/*  78:    */   }
/*  79:    */   
/*  80:    */   public String getStatus()
/*  81:    */   {
/*  82: 79 */     return this.status;
/*  83:    */   }
/*  84:    */   
/*  85:    */   public void setStatus(String status)
/*  86:    */   {
/*  87: 83 */     this.status = (status == null ? null : status.trim());
/*  88:    */   }
/*  89:    */   
/*  90:    */   public String getCreateUser()
/*  91:    */   {
/*  92: 87 */     return this.createUser;
/*  93:    */   }
/*  94:    */   
/*  95:    */   public void setCreateUser(String createUser)
/*  96:    */   {
/*  97: 91 */     this.createUser = (createUser == null ? null : createUser.trim());
/*  98:    */   }
/*  99:    */   
/* 100:    */   public Date getCreateTime()
/* 101:    */   {
/* 102: 95 */     return this.createTime;
/* 103:    */   }
/* 104:    */   
/* 105:    */   public void setCreateTime(Date createTime)
/* 106:    */   {
/* 107: 99 */     this.createTime = createTime;
/* 108:    */   }
/* 109:    */   
/* 110:    */   public String getUpdateUser()
/* 111:    */   {
/* 112:103 */     return this.updateUser;
/* 113:    */   }
/* 114:    */   
/* 115:    */   public void setUpdateUser(String updateUser)
/* 116:    */   {
/* 117:107 */     this.updateUser = (updateUser == null ? null : updateUser.trim());
/* 118:    */   }
/* 119:    */   
/* 120:    */   public Date getUpdateTime()
/* 121:    */   {
/* 122:111 */     return this.updateTime;
/* 123:    */   }
/* 124:    */   
/* 125:    */   public void setUpdateTime(Date updateTime)
/* 126:    */   {
/* 127:115 */     this.updateTime = updateTime;
/* 128:    */   }
/* 129:    */   
/* 130:    */   public String getRemark()
/* 131:    */   {
/* 132:119 */     return this.remark;
/* 133:    */   }
/* 134:    */   
/* 135:    */   public void setRemark(String remark)
/* 136:    */   {
/* 137:123 */     this.remark = (remark == null ? null : remark.trim());
/* 138:    */   }
 }
