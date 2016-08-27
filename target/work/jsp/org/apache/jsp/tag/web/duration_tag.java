package org.apache.jsp.tag.web;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Date;

public final class duration_tag
    extends javax.servlet.jsp.tagext.SimpleTagSupport
    implements org.apache.jasper.runtime.JspSourceDependent {


  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  private JspContext jspContext;
  private java.io.Writer _jspx_sout;
  private org.apache.jasper.runtime.ResourceInjector _jspx_resourceInjector;

  public void setJspContext(JspContext ctx) {
    super.setJspContext(ctx);
    java.util.ArrayList _jspx_nested = null;
    java.util.ArrayList _jspx_at_begin = null;
    java.util.ArrayList _jspx_at_end = null;
    this.jspContext = new org.apache.jasper.runtime.JspContextWrapper(ctx, _jspx_nested, _jspx_at_begin, _jspx_at_end, null);
  }

  public JspContext getJspContext() {
    return this.jspContext;
  }
  private java.util.Date startTime;
  private java.util.Date endTime;

  public java.util.Date getStartTime() {
    return this.startTime;
  }

  public void setStartTime(java.util.Date startTime) {
    this.startTime = startTime;
  }

  public java.util.Date getEndTime() {
    return this.endTime;
  }

  public void setEndTime(java.util.Date endTime) {
    this.endTime = endTime;
  }

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void doTag() throws JspException, java.io.IOException {
    PageContext _jspx_page_context = (PageContext)jspContext;
    HttpServletRequest request = (HttpServletRequest) _jspx_page_context.getRequest();
    HttpServletResponse response = (HttpServletResponse) _jspx_page_context.getResponse();
    HttpSession session = _jspx_page_context.getSession();
    ServletContext application = _jspx_page_context.getServletContext();
    ServletConfig config = _jspx_page_context.getServletConfig();
    JspWriter out = jspContext.getOut();
    if( getStartTime() != null ) {
      _jspx_page_context.setAttribute("startTime", getStartTime());
}
    if( getEndTime() != null ) {
      _jspx_page_context.setAttribute("endTime", getEndTime());
}

    try {

  Date startTime = (Date) jspContext.getAttribute("startTime");
  Date endTime = (Date) jspContext.getAttribute("endTime");

  try {
    long duration = (endTime.getTime() - startTime.getTime()) / 1000;

    long day = duration / (24 * 60 * 60);
    long hour = duration / (60 * 60) % 24;
    long minute = duration / 60 % 60;
    long second = duration % 60;

    StringBuilder buff = new StringBuilder();
    if (day > 0) {
      buff.append(day).append("天");
    }
    if (hour > 0) {
      buff.append(hour).append("时");
    }
    if (minute > 0) {
      buff.append(minute).append("分");
    }
    if (second > 0) {
      buff.append(second).append("秒");
    }
    if (buff.length() > 0) {
      out.print(buff);
    } else {
      out.print("-");
    }
  } catch(Exception ex) {
	  System.out.println("kjkoifiod");
    System.out.println(ex.toString());
  }

    } catch( Throwable t ) {
      if( t instanceof SkipPageException )
          throw (SkipPageException) t;
      if( t instanceof java.io.IOException )
          throw (java.io.IOException) t;
      if( t instanceof IllegalStateException )
          throw (IllegalStateException) t;
      if( t instanceof JspException )
          throw (JspException) t;
      throw new JspException(t);
    } finally {
      ((org.apache.jasper.runtime.JspContextWrapper) jspContext).syncEndTagFile();
    }
  }
}
