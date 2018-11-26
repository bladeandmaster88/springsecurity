/*   1:    */ package com.icss.model;
/*   2:    */ 
/*   3:    */ import java.util.Date;
/*   4:    */ 
/*   5:    */ public class RoleBean
/*   6:    */ {
/*   7:    */   private String id;
/*   8:    */   private String name;//角色名称
/*   9:    */   private Short status;
/*  10:    */   private String roleDesc;
/*  11:    */   private String creator;
/*  12:    */   private Date createTime;
/*  13:    */   private String updater;
/*  14:    */   private Date updateTime;
/*  15:    */   private String remark;
/*  16:    */   private String cnName;
/*  17:    */   
/*  18:    */   public String getId()
/*  19:    */   {
/*  20: 27 */     return this.id;
/*  21:    */   }
/*  22:    */   
/*  23:    */   public void setId(String id)
/*  24:    */   {
/*  25: 31 */     this.id = (id == null ? null : id.trim());
/*  26:    */   }
/*  27:    */   
/*  28:    */   public String getName()
/*  29:    */   {
/*  30: 35 */     return this.name;
/*  31:    */   }
/*  32:    */   
/*  33:    */   public void setName(String name)
/*  34:    */   {
/*  35: 39 */     this.name = (name == null ? null : name.trim());
/*  36:    */   }
/*  37:    */   
/*  38:    */   public Short getStatus()
/*  39:    */   {
/*  40: 43 */     return this.status;
/*  41:    */   }
/*  42:    */   
/*  43:    */   public void setStatus(Short status)
/*  44:    */   {
/*  45: 47 */     this.status = status;
/*  46:    */   }
/*  47:    */   
/*  48:    */   public String getRoleDesc()
/*  49:    */   {
/*  50: 51 */     return this.roleDesc;
/*  51:    */   }
/*  52:    */   
/*  53:    */   public void setRoleDesc(String roleDesc)
/*  54:    */   {
/*  55: 55 */     this.roleDesc = (roleDesc == null ? null : roleDesc.trim());
/*  56:    */   }
/*  57:    */   
/*  58:    */   public String getCreator()
/*  59:    */   {
/*  60: 59 */     return this.creator;
/*  61:    */   }
/*  62:    */   
/*  63:    */   public void setCreator(String creator)
/*  64:    */   {
/*  65: 63 */     this.creator = (creator == null ? null : creator.trim());
/*  66:    */   }
/*  67:    */   
/*  68:    */   public Date getCreateTime()
/*  69:    */   {
/*  70: 67 */     return this.createTime;
/*  71:    */   }
/*  72:    */   
/*  73:    */   public void setCreateTime(Date createTime)
/*  74:    */   {
/*  75: 71 */     this.createTime = createTime;
/*  76:    */   }
/*  77:    */   
/*  78:    */   public String getUpdater()
/*  79:    */   {
/*  80: 75 */     return this.updater;
/*  81:    */   }
/*  82:    */   
/*  83:    */   public void setUpdater(String updater)
/*  84:    */   {
/*  85: 79 */     this.updater = (updater == null ? null : updater.trim());
/*  86:    */   }
/*  87:    */   
/*  88:    */   public Date getUpdateTime()
/*  89:    */   {
/*  90: 83 */     return this.updateTime;
/*  91:    */   }
/*  92:    */   
/*  93:    */   public void setUpdateTime(Date updateTime)
/*  94:    */   {
/*  95: 87 */     this.updateTime = updateTime;
/*  96:    */   }
/*  97:    */   
/*  98:    */   public String getRemark()
/*  99:    */   {
/* 100: 91 */     return this.remark;
/* 101:    */   }
/* 102:    */   
/* 103:    */   public void setRemark(String remark)
/* 104:    */   {
/* 105: 95 */     this.remark = (remark == null ? null : remark.trim());
/* 106:    */   }
/* 107:    */   
/* 108:    */   public String getCnName()
/* 109:    */   {
/* 110: 99 */     return this.cnName;
/* 111:    */   }
/* 112:    */   
/* 113:    */   public void setCnName(String cnName)
/* 114:    */   {
/* 115:103 */     this.cnName = cnName;
/* 116:    */   }
/* 117:    */ }
