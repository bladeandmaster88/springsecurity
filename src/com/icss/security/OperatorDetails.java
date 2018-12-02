/*   1:    */ package com.icss.security;
/*   2:    */ 
/*   3:    */ import java.util.Collection;
/*   4:    */ import java.util.Date;
/*   5:    */ import org.springframework.security.core.GrantedAuthority;
/*   6:    */ import org.springframework.security.core.userdetails.User;
/*   7:    
/*   8:    */ public class OperatorDetails
/*   9:    */   extends User
/*  10:    */ {
/*  11:    */   private static final long serialVersionUID = 1L;
/*  12:    */   private Date loginTime;
/*  13:    */   private String guid;
/*  14:    */   private String dispatcherAccount;
/*  15:    */   private String dispatcherPwd;
/*  16:    */   private String dispatcherName;
/*  17:    */   private String depId;
/*  18:    */   private String depName;
/*  19:    */   private String realName;
/*  20:    */   private String userId;
/*  21:    */   private String mobile;
/*  22:    */   
/*  23:    */   public OperatorDetails(String dispatcherAccount, String dispatcherPwd, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<GrantedAuthority> authorities)
/*  24:    */     throws IllegalArgumentException
/*  25:    */   {
/*  26: 29 */     super(dispatcherAccount, dispatcherPwd, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
/*  27:    */   }
/*  28:    */   
/*  29:    */   public Date getLoginTime()
/*  30:    */   {
/*  31: 33 */     return this.loginTime;
/*  32:    */   }
/*  33:    */   
/*  34:    */   public void setLoginTime(Date loginTime)
/*  35:    */   {
/*  36: 37 */     this.loginTime = loginTime;
/*  37:    */   }
/*  38:    */   
/*  39:    */   public String getDispatcherPwd()
/*  40:    */   {
/*  41: 41 */     return this.dispatcherPwd;
/*  42:    */   }
/*  43:    */   
/*  44:    */   public void setDispatcherPwd(String dispatcherPwd)
/*  45:    */   {
/*  46: 45 */     this.dispatcherPwd = dispatcherPwd;
/*  47:    */   }
/*  48:    */   
/*  49:    */   public String getUserId()
/*  50:    */   {
/*  51: 49 */     return this.userId;
/*  52:    */   }
/*  53:    */   
/*  54:    */   public void setUserId(String userId)
/*  55:    */   {
/*  56: 53 */     this.userId = userId;
/*  57:    */   }
/*  58:    */   
/*  59:    */   public static long getSerialversionuid()
/*  60:    */   {
/*  61: 57 */     return 1L;
/*  62:    */   }
/*  63:    */   
/*  64:    */   public String getGuid()
/*  65:    */   {
/*  66: 61 */     return this.guid;
/*  67:    */   }
/*  68:    */   
/*  69:    */   public void setGuid(String guid)
/*  70:    */   {
/*  71: 65 */     this.guid = guid;
/*  72:    */   }
/*  73:    */   
/*  74:    */   public String getDispatcherAccount()
/*  75:    */   {
/*  76: 69 */     return this.dispatcherAccount;
/*  77:    */   }
/*  78:    */   
/*  79:    */   public void setDispatcherAccount(String dispatcherAccount)
/*  80:    */   {
/*  81: 73 */     this.dispatcherAccount = dispatcherAccount;
/*  82:    */   }
/*  83:    */   
/*  84:    */   public String getDispatcherName()
/*  85:    */   {
/*  86: 77 */     return this.dispatcherName;
/*  87:    */   }
/*  88:    */   
/*  89:    */   public void setDispatcherName(String dispatcherName)
/*  90:    */   {
/*  91: 81 */     this.dispatcherName = dispatcherName;
/*  92:    */   }
/*  93:    */   
/*  94:    */   public String getDepId()
/*  95:    */   {
/*  96: 85 */     return this.depId;
/*  97:    */   }
/*  98:    */   
/*  99:    */   public void setDepId(String depId)
/* 100:    */   {
/* 101: 89 */     this.depId = depId;
/* 102:    */   }
/* 103:    */   
/* 104:    */   public String getDepName()
/* 105:    */   {
/* 106: 93 */     return this.depName;
/* 107:    */   }
/* 108:    */   
/* 109:    */   public void setDepName(String depName)
/* 110:    */   {
/* 111: 97 */     this.depName = depName;
/* 112:    */   }
/* 113:    */   
/* 114:    */   public String getRealName()
/* 115:    */   {
/* 116:101 */     return this.realName;
/* 117:    */   }
/* 118:    */   
/* 119:    */   public void setRealName(String realName)
/* 120:    */   {
/* 121:105 */     this.realName = realName;
/* 122:    */   }
/* 123:    */   
/* 124:    */   public String getMobile()
/* 125:    */   {
/* 126:109 */     return this.mobile;
/* 127:    */   }
/* 128:    */   
/* 129:    */   public void setMobile(String mobile)
/* 130:    */   {
/* 131:113 */     this.mobile = mobile;
/* 132:    */   }
/* 133:    */ }
