/*   1:    */ package com.icss.model;
/*   2:    */ 
/*   3:    */ import java.util.Date;
/*   4:    */ 
/*   5:    */ public class MenuBean
/*   6:    */ {
/*   7:    */   private String id;
/*   8:    */   private String menuNo;
/*   9:    */   private String name;
/*  10:    */   private String menuUrl;
/*  11:    */   private String type;
/*  12:    */   private Short status;
/*  13:    */   private Short menuLevel;
/*  14:    */   private String superNo;
/*  15:    */   private String menuDesc;
/*  16:    */   private String creator;
/*  17:    */   private Date createTime;
/*  18:    */   private String updater;
/*  19:    */   private Date updateTime;
/*  20:    */   private String remark;
/*  21:    */   private String bgUrl;
/*  22:    */   private String menuUrlTwo;
/*  23:    */   private String styleInfo;
/*  24:    */   private String buttonName;
/*  25:    */   
/*  26:    */   public String getId()
/*  27:    */   {
/*  28: 43 */     return this.id;
/*  29:    */   }
/*  30:    */   
/*  31:    */   public void setId(String id)
/*  32:    */   {
/*  33: 47 */     this.id = (id == null ? null : id.trim());
/*  34:    */   }
/*  35:    */   
/*  36:    */   public String getMenuNo()
/*  37:    */   {
/*  38: 51 */     return this.menuNo;
/*  39:    */   }
/*  40:    */   
/*  41:    */   public void setMenuNo(String menuNo)
/*  42:    */   {
/*  43: 55 */     this.menuNo = (menuNo == null ? null : menuNo.trim());
/*  44:    */   }
/*  45:    */   
/*  46:    */   public String getName()
/*  47:    */   {
/*  48: 59 */     return this.name;
/*  49:    */   }
/*  50:    */   
/*  51:    */   public void setName(String name)
/*  52:    */   {
/*  53: 63 */     this.name = (name == null ? null : name.trim());
/*  54:    */   }
/*  55:    */   
/*  56:    */   public String getMenuUrl()
/*  57:    */   {
/*  58: 67 */     return this.menuUrl;
/*  59:    */   }
/*  60:    */   
/*  61:    */   public void setMenuUrl(String menuUrl)
/*  62:    */   {
/*  63: 71 */     this.menuUrl = (menuUrl == null ? null : menuUrl.trim());
/*  64:    */   }
/*  65:    */   
/*  66:    */   public String getType()
/*  67:    */   {
/*  68: 75 */     return this.type;
/*  69:    */   }
/*  70:    */   
/*  71:    */   public void setType(String type)
/*  72:    */   {
/*  73: 79 */     this.type = (type == null ? null : type.trim());
/*  74:    */   }
/*  75:    */   
/*  76:    */   public Short getStatus()
/*  77:    */   {
/*  78: 83 */     return this.status;
/*  79:    */   }
/*  80:    */   
/*  81:    */   public void setStatus(Short status)
/*  82:    */   {
/*  83: 87 */     this.status = status;
/*  84:    */   }
/*  85:    */   
/*  86:    */   public Short getMenuLevel()
/*  87:    */   {
/*  88: 91 */     return this.menuLevel;
/*  89:    */   }
/*  90:    */   
/*  91:    */   public void setMenuLevel(Short menuLevel)
/*  92:    */   {
/*  93: 95 */     this.menuLevel = menuLevel;
/*  94:    */   }
/*  95:    */   
/*  96:    */   public String getSuperNo()
/*  97:    */   {
/*  98: 99 */     return this.superNo;
/*  99:    */   }
/* 100:    */   
/* 101:    */   public void setSuperNo(String superNo)
/* 102:    */   {
/* 103:103 */     this.superNo = (superNo == null ? null : superNo.trim());
/* 104:    */   }
/* 105:    */   
/* 106:    */   public String getMenuDesc()
/* 107:    */   {
/* 108:107 */     return this.menuDesc;
/* 109:    */   }
/* 110:    */   
/* 111:    */   public void setMenuDesc(String menuDesc)
/* 112:    */   {
/* 113:111 */     this.menuDesc = (menuDesc == null ? null : menuDesc.trim());
/* 114:    */   }
/* 115:    */   
/* 116:    */   public String getCreator()
/* 117:    */   {
/* 118:115 */     return this.creator;
/* 119:    */   }
/* 120:    */   
/* 121:    */   public void setCreator(String creator)
/* 122:    */   {
/* 123:119 */     this.creator = (creator == null ? null : creator.trim());
/* 124:    */   }
/* 125:    */   
/* 126:    */   public Date getCreateTime()
/* 127:    */   {
/* 128:123 */     return this.createTime;
/* 129:    */   }
/* 130:    */   
/* 131:    */   public void setCreateTime(Date createTime)
/* 132:    */   {
/* 133:127 */     this.createTime = createTime;
/* 134:    */   }
/* 135:    */   
/* 136:    */   public String getUpdater()
/* 137:    */   {
/* 138:131 */     return this.updater;
/* 139:    */   }
/* 140:    */   
/* 141:    */   public void setUpdater(String updater)
/* 142:    */   {
/* 143:135 */     this.updater = (updater == null ? null : updater.trim());
/* 144:    */   }
/* 145:    */   
/* 146:    */   public Date getUpdateTime()
/* 147:    */   {
/* 148:139 */     return this.updateTime;
/* 149:    */   }
/* 150:    */   
/* 151:    */   public void setUpdateTime(Date updateTime)
/* 152:    */   {
/* 153:143 */     this.updateTime = updateTime;
/* 154:    */   }
/* 155:    */   
/* 156:    */   public String getRemark()
/* 157:    */   {
/* 158:147 */     return this.remark;
/* 159:    */   }
/* 160:    */   
/* 161:    */   public void setRemark(String remark)
/* 162:    */   {
/* 163:151 */     this.remark = (remark == null ? null : remark.trim());
/* 164:    */   }
/* 165:    */   
/* 166:    */   public String getBgUrl()
/* 167:    */   {
/* 168:155 */     return this.bgUrl;
/* 169:    */   }
/* 170:    */   
/* 171:    */   public void setBgUrl(String bgUrl)
/* 172:    */   {
/* 173:159 */     this.bgUrl = (bgUrl == null ? null : bgUrl.trim());
/* 174:    */   }
/* 175:    */   
/* 176:    */   public String getMenuUrlTwo()
/* 177:    */   {
/* 178:163 */     return this.menuUrlTwo;
/* 179:    */   }
/* 180:    */   
/* 181:    */   public void setMenuUrlTwo(String menuUrlTwo)
/* 182:    */   {
/* 183:167 */     this.menuUrlTwo = menuUrlTwo;
/* 184:    */   }
/* 185:    */   
/* 186:    */   public String getStyleInfo()
/* 187:    */   {
/* 188:171 */     return this.styleInfo;
/* 189:    */   }
/* 190:    */   
/* 191:    */   public void setStyleInfo(String styleInfo)
/* 192:    */   {
/* 193:175 */     this.styleInfo = styleInfo;
/* 194:    */   }
/* 195:    */   
/* 196:    */   public String getButtonName()
/* 197:    */   {
/* 198:179 */     return this.buttonName;
/* 199:    */   }
/* 200:    */   
/* 201:    */   public void setButtonName(String buttonName)
/* 202:    */   {
/* 203:183 */     this.buttonName = buttonName;
/* 204:    */   }
/* 205:    */ }
