/*   1:    */ package com.icss.model;
/*   2:    */ 
/*   3:    */ import java.util.Date;
/*   4:    */ import java.util.List;
/*   5:    */ 
/*   6:    */ public class MenuModel
/*   7:    */   implements Comparable<MenuModel>
/*   8:    */ {
/*   9:    */   private String id;
/*  10:    */   private String menuNo;
/*  11:    */   private String name;
/*  12:    */   private String menuUrl;
/*  13:    */   private String type;
/*  14:    */   private Short status;
/*  15:    */   private Short menuLevel;
/*  16:    */   private String superNo;
/*  17:    */   private String menuDesc;
/*  18:    */   private String creator;
/*  19:    */   private Date createTime;
/*  20:    */   private String updater;
/*  21:    */   private Date updateTime;
/*  22:    */   private String remark;
/*  23:    */   private String bgUrl;
/*  24:    */   private String menuUrlTwo;
/*  25:    */   private String styleInfo;
/*  26:    */   private String buttonName;
/*  27:    */   private int listOrder;
/*  28:    */   private List<RoleBean> roles;
/*  29:    */   
/*  30:    */   public String getId()
/*  31:    */   {
/*  32: 48 */     return this.id;
/*  33:    */   }
/*  34:    */   
/*  35:    */   public void setId(String id)
/*  36:    */   {
/*  37: 52 */     this.id = (id == null ? null : id.trim());
/*  38:    */   }
/*  39:    */   
/*  40:    */   public String getMenuNo()
/*  41:    */   {
/*  42: 56 */     return this.menuNo;
/*  43:    */   }
/*  44:    */   
/*  45:    */   public void setMenuNo(String menuNo)
/*  46:    */   {
/*  47: 60 */     this.menuNo = (menuNo == null ? null : menuNo.trim());
/*  48:    */   }
/*  49:    */   
/*  50:    */   public String getName()
/*  51:    */   {
/*  52: 64 */     return this.name;
/*  53:    */   }
/*  54:    */   
/*  55:    */   public void setName(String name)
/*  56:    */   {
/*  57: 68 */     this.name = (name == null ? null : name.trim());
/*  58:    */   }
/*  59:    */   
/*  60:    */   public String getMenuUrl()
/*  61:    */   {
/*  62: 72 */     return this.menuUrl;
/*  63:    */   }
/*  64:    */   
/*  65:    */   public void setMenuUrl(String menuUrl)
/*  66:    */   {
/*  67: 76 */     this.menuUrl = (menuUrl == null ? null : menuUrl.trim());
/*  68:    */   }
/*  69:    */   
/*  70:    */   public String getType()
/*  71:    */   {
/*  72: 80 */     return this.type;
/*  73:    */   }
/*  74:    */   
/*  75:    */   public void setType(String type)
/*  76:    */   {
/*  77: 84 */     this.type = (type == null ? null : type.trim());
/*  78:    */   }
/*  79:    */   
/*  80:    */   public Short getStatus()
/*  81:    */   {
/*  82: 88 */     return this.status;
/*  83:    */   }
/*  84:    */   
/*  85:    */   public void setStatus(Short status)
/*  86:    */   {
/*  87: 92 */     this.status = status;
/*  88:    */   }
/*  89:    */   
/*  90:    */   public Short getMenuLevel()
/*  91:    */   {
/*  92: 96 */     return this.menuLevel;
/*  93:    */   }
/*  94:    */   
/*  95:    */   public void setMenuLevel(Short menuLevel)
/*  96:    */   {
/*  97:100 */     this.menuLevel = menuLevel;
/*  98:    */   }
/*  99:    */   
/* 100:    */   public String getSuperNo()
/* 101:    */   {
/* 102:104 */     return this.superNo;
/* 103:    */   }
/* 104:    */   
/* 105:    */   public void setSuperNo(String superNo)
/* 106:    */   {
/* 107:108 */     this.superNo = (superNo == null ? null : superNo.trim());
/* 108:    */   }
/* 109:    */   
/* 110:    */   public String getMenuDesc()
/* 111:    */   {
/* 112:112 */     return this.menuDesc;
/* 113:    */   }
/* 114:    */   
/* 115:    */   public void setMenuDesc(String menuDesc)
/* 116:    */   {
/* 117:116 */     this.menuDesc = (menuDesc == null ? null : menuDesc.trim());
/* 118:    */   }
/* 119:    */   
/* 120:    */   public String getCreator()
/* 121:    */   {
/* 122:120 */     return this.creator;
/* 123:    */   }
/* 124:    */   
/* 125:    */   public void setCreator(String creator)
/* 126:    */   {
/* 127:124 */     this.creator = (creator == null ? null : creator.trim());
/* 128:    */   }
/* 129:    */   
/* 130:    */   public Date getCreateTime()
/* 131:    */   {
/* 132:128 */     return this.createTime;
/* 133:    */   }
/* 134:    */   
/* 135:    */   public void setCreateTime(Date createTime)
/* 136:    */   {
/* 137:132 */     this.createTime = createTime;
/* 138:    */   }
/* 139:    */   
/* 140:    */   public String getUpdater()
/* 141:    */   {
/* 142:136 */     return this.updater;
/* 143:    */   }
/* 144:    */   
/* 145:    */   public void setUpdater(String updater)
/* 146:    */   {
/* 147:140 */     this.updater = (updater == null ? null : updater.trim());
/* 148:    */   }
/* 149:    */   
/* 150:    */   public Date getUpdateTime()
/* 151:    */   {
/* 152:144 */     return this.updateTime;
/* 153:    */   }
/* 154:    */   
/* 155:    */   public void setUpdateTime(Date updateTime)
/* 156:    */   {
/* 157:148 */     this.updateTime = updateTime;
/* 158:    */   }
/* 159:    */   
/* 160:    */   public String getRemark()
/* 161:    */   {
/* 162:152 */     return this.remark;
/* 163:    */   }
/* 164:    */   
/* 165:    */   public void setRemark(String remark)
/* 166:    */   {
/* 167:156 */     this.remark = (remark == null ? null : remark.trim());
/* 168:    */   }
/* 169:    */   
/* 170:    */   public String getBgUrl()
/* 171:    */   {
/* 172:160 */     return this.bgUrl;
/* 173:    */   }
/* 174:    */   
/* 175:    */   public void setBgUrl(String bgUrl)
/* 176:    */   {
/* 177:164 */     this.bgUrl = (bgUrl == null ? null : bgUrl.trim());
/* 178:    */   }
/* 179:    */   
/* 180:    */   public List<RoleBean> getRoles()
/* 181:    */   {
/* 182:168 */     return this.roles;
/* 183:    */   }
/* 184:    */   
/* 185:    */   public void setRoles(List<RoleBean> roles)
/* 186:    */   {
/* 187:172 */     this.roles = roles;
/* 188:    */   }
/* 189:    */   
/* 190:    */   public String getMenuUrlTwo()
/* 191:    */   {
/* 192:176 */     return this.menuUrlTwo;
/* 193:    */   }
/* 194:    */   
/* 195:    */   public void setMenuUrlTwo(String menuUrlTwo)
/* 196:    */   {
/* 197:180 */     this.menuUrlTwo = menuUrlTwo;
/* 198:    */   }
/* 199:    */   
/* 200:    */   public String getStyleInfo()
/* 201:    */   {
/* 202:184 */     return this.styleInfo;
/* 203:    */   }
/* 204:    */   
/* 205:    */   public void setStyleInfo(String styleInfo)
/* 206:    */   {
/* 207:188 */     this.styleInfo = styleInfo;
/* 208:    */   }
/* 209:    */   
/* 210:    */   public String getButtonName()
/* 211:    */   {
/* 212:192 */     return this.buttonName;
/* 213:    */   }
/* 214:    */   
/* 215:    */   public void setButtonName(String buttonName)
/* 216:    */   {
/* 217:196 */     this.buttonName = buttonName;
/* 218:    */   }
/* 219:    */   
/* 220:    */   public int getListOrder()
/* 221:    */   {
/* 222:200 */     return this.listOrder;
/* 223:    */   }
/* 224:    */   
/* 225:    */   public void setListOrder(int listOrder)
/* 226:    */   {
/* 227:204 */     this.listOrder = listOrder;
/* 228:    */   }
/* 229:    */   
/* 230:    */   public int compareTo(MenuModel mm)
/* 231:    */   {
/* 232:210 */     if (this.listOrder > mm.listOrder) {
/* 233:211 */       return 1;
/* 234:    */     }
/* 235:212 */     if (this.listOrder < mm.listOrder) {
/* 236:213 */       return -1;
/* 237:    */     }
/* 238:215 */     return 0;
/* 239:    */   }
/* 240:    */ }
