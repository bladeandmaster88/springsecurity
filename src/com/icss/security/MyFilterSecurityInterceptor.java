/*  1:   */ package com.icss.security;
/*  2:   */ 
/*  3:   */ import java.io.IOException;
/*  4:   */ import javax.servlet.Filter;
/*  5:   */ import javax.servlet.FilterChain;
/*  6:   */ import javax.servlet.FilterConfig;
/*  7:   */ import javax.servlet.ServletException;
/*  8:   */ import javax.servlet.ServletRequest;
/*  9:   */ import javax.servlet.ServletResponse;
/* 10:   */ import org.apache.log4j.Logger;
/* 11:   */ import org.springframework.security.access.SecurityMetadataSource;
/* 12:   */ import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
/* 13:   */ import org.springframework.security.access.intercept.InterceptorStatusToken;
/* 14:   */ import org.springframework.security.web.FilterInvocation;
/* 15:   */ import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
/* 16:   */ 
/* 17:   */ public class MyFilterSecurityInterceptor extends AbstractSecurityInterceptor implements Filter
/* 20:   */ {
/* 21:28 */   private static final Logger logger = Logger.getLogger(MyFilterSecurityInterceptor.class);
/* 22:   */   private FilterInvocationSecurityMetadataSource securityMetadataSource;
/* 23:   */   
/* 24:   */   public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
/* 25:   */     throws IOException, ServletException
/* 26:   */   {
/* 27:36 */     FilterInvocation fi = new FilterInvocation(request, response, chain);
/* 28:37 */     invoke(fi);
/* 29:   */   }
/* 30:   */   
/* 31:   */   public FilterInvocationSecurityMetadataSource getSecurityMetadataSource()
/* 32:   */   {
/* 33:42 */     return this.securityMetadataSource;
/* 34:   */   }
/* 35:   */   
/* 36:   */   public Class<? extends Object> getSecureObjectClass()
/* 37:   */   {
/* 38:47 */     return FilterInvocation.class;
/* 39:   */   }
/* 40:   */   
/* 41:   */   public void invoke(FilterInvocation fi)
/* 42:   */     throws IOException, ServletException
/* 43:   */   {
/* 44:51 */     InterceptorStatusToken token = super.beforeInvocation(fi);
/* 45:   */     try
/* 46:   */     {
/* 47:53 */       fi.getChain().doFilter(fi.getRequest(), fi.getResponse());
/* 48:   */     }
/* 49:   */     finally
/* 50:   */     {
/* 51:55 */       super.afterInvocation(token, null);
/* 52:   */     }
/* 53:   */   }
/* 54:   */   
/* 55:   */   public SecurityMetadataSource obtainSecurityMetadataSource()
/* 56:   */   {
/* 57:61 */     return this.securityMetadataSource;
/* 58:   */   }
/* 59:   */   
/* 60:   */   public void setSecurityMetadataSource(FilterInvocationSecurityMetadataSource newSource)
/* 61:   */   {
/* 62:65 */     this.securityMetadataSource = newSource;
/* 63:   */   }
/* 64:   */   
/* 65:   */   public void destroy() {}
/* 66:   */   
/* 67:   */   public void init(FilterConfig arg0)
/* 68:   */     throws ServletException
/* 69:   */   {}
/* 70:   */ }
