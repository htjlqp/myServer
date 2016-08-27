package org.apache.jsp.common;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.InetAddress;
import java.util.Enumeration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class _500_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(2);
    _jspx_dependants.add("/common/taglibs.jsp");
    _jspx_dependants.add("/common/meta.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_spring_message_text_code_nobody;

  private org.apache.jasper.runtime.ResourceInjector _jspx_resourceInjector;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_spring_message_text_code_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_spring_message_text_code_nobody.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    Throwable exception = org.apache.jasper.runtime.JspRuntimeLibrary.getThrowable(request);
    response.setStatus(((Integer)request.getAttribute("javax.servlet.error.status_code")).intValue());
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.apache.jasper.runtime.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write('\r');
      out.write('\n');
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
pageContext.setAttribute("ctx", request.getContextPath());
      out.write('\n');
      out.write('\n');
request.setAttribute("tenantPrefix", request.getContextPath());
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
response.setStatus(200);
      out.write("\r\n");
      out.write("\r\n");

pageContext.setAttribute("ctx", request.getContextPath());
Throwable ex = null;
if (exception != null) {
	ex = exception;
}
if (request.getAttribute("javax.servlet.error.exception") != null) {
	ex = (Throwable) request.getAttribute("javax.servlet.error.exception");
}

//记录日志
Logger logger = LoggerFactory.getLogger("500.jsp");
String requestInfo = "";
try {
	StringBuilder buff = new StringBuilder();
	buff.append(InetAddress.getLocalHost())
		.append("\n");
    buff.append("Header....\n");
    Enumeration<String> e = request.getHeaderNames();
    String key;
    while(e.hasMoreElements()){
        key = e.nextElement();
        buff.append(key)
			.append("=")
			.append(request.getHeader(key))
			.append("\n");
    }
    buff.append("Attribute....\n");
    e = request.getAttributeNames();
    while(e.hasMoreElements()){
        key = e.nextElement();
        buff.append(key)
			.append("=")
			.append(request.getAttribute(key))
			.append("\n");
    }

    buff.append("Parameter....\n");
    e = request.getParameterNames();
    while(e.hasMoreElements()){
        key = e.nextElement();
		buff.append(key)
			.append("=")
			.append(java.util.Arrays.asList(request.getParameterValues(key)))
			.append("\n");
    }
	requestInfo = buff.toString().replaceAll("<", "&lt;");
} catch(Throwable t) {
    logger.error("fetch request info error", t);
}
logger.error(requestInfo, ex);

      out.write("\r\n");
      out.write("<!doctype html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("\r\n");
      out.write("  <head>\r\n");
      out.write("    ");
      out.write("\n");
      out.write("<meta charset=\"UTF-8\">\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html;charset=utf-8\" />\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("<meta http-equiv=\"Cache-Control\" content=\"no-store\" />\n");
      out.write("<meta http-equiv=\"Pragma\" content=\"no-cache\" />\n");
      out.write("<meta http-equiv=\"Expires\" content=\"0\" />");
      out.write("\r\n");
      out.write("    <title>500 - ");
      if (_jspx_meth_spring_message_0(_jspx_page_context))
        return;
      out.write("</title>\r\n");
      out.write("\t<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/s/bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("\t<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/s/bootstrap/css/bootstrap-responsive.min.css\" rel=\"stylesheet\">\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/s/jquery/jquery.min.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("$(function() {\r\n");
      out.write("\t$('#targetContentDiv').height($(window).innerHeight() - 150);\r\n");
      out.write("})\r\n");
      out.write("    </script>\r\n");
      out.write("\t<style type=\"text/css\">\r\n");
      out.write("#targetContentDiv {\r\n");
      out.write("\tbackground-color: #b8b8b8;\r\n");
      out.write("\tpadding: 70px 0 80px;\r\n");
      out.write("\ttext-align: center;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#targetContentDiv h1 {\r\n");
      out.write("\tfont-size: 120px;\r\n");
      out.write("\tletter-spacing: -2px;\r\n");
      out.write("    line-height: 1;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#targetContentDiv p {\r\n");
      out.write("\tfont-size: 40px;\r\n");
      out.write("    font-weight: 200;\r\n");
      out.write("    line-height: 1.25;\r\n");
      out.write("\tfont-weight: bold;\r\n");
      out.write("\tpadding: 10px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#targetContentDiv li {\r\n");
      out.write("\tdisplay: inline;\r\n");
      out.write("\tlist-style: none outside none;\r\n");
      out.write("}\r\n");
      out.write("\t</style>\r\n");
      out.write("  </head>\r\n");
      out.write("\r\n");
      out.write("  <body>\r\n");
      out.write("\r\n");
      out.write("\t<div id=\"targetContentDiv\">\r\n");
      out.write("\t  <div class=\"container\">\r\n");
      out.write("\t\t<h1>500</h1>\r\n");
      out.write("\t\t<p>");
      if (_jspx_meth_spring_message_1(_jspx_page_context))
        return;
      out.write("</p>\r\n");
      out.write("\t\t<ul>\r\n");
      out.write("\t\t  <li><a class=\"btn btn-primary\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/\">");
      if (_jspx_meth_spring_message_2(_jspx_page_context))
        return;
      out.write("</a></li>\r\n");
      out.write("\t\t  <li><a class=\"btn\" href=\"javascript:void(0);\" onclick=\"\">联系管理员</a></li>\r\n");
      out.write("\t\t  <li><a class=\"btn\" href=\"javascript:void(0);\" onclick=\"$('#output').show();$('#targetContentDiv').hide();\">显示详情</a></li>\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("      </div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div id=\"output\" style=\"display:none\">\r\n");
      out.write("\t  <div style=\"text-align:center;\" class=\"container\">\r\n");
      out.write("\t    <a class=\"btn btn-info container\" href=\"javascript:void(0);\" onclick=\"$('#output').hide();$('#targetContentDiv').show();\">返回</a>\r\n");
      out.write("\t  </div>\r\n");
      out.write("\t  <pre>\r\n");
      out.print(requestInfo);
      out.write("\r\n");
      out.write("<hr>\r\n");

StringWriter writer = new StringWriter();
ex.printStackTrace(new PrintWriter(writer));
out.println(writer.toString());

      out.write("\r\n");
      out.write("\t  </pre>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("  </body>\r\n");
      out.write("\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_spring_message_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  spring:message
    org.springframework.web.servlet.tags.MessageTag _jspx_th_spring_message_0 = (org.springframework.web.servlet.tags.MessageTag) _jspx_tagPool_spring_message_text_code_nobody.get(org.springframework.web.servlet.tags.MessageTag.class);
    _jspx_th_spring_message_0.setPageContext(_jspx_page_context);
    _jspx_th_spring_message_0.setParent(null);
    _jspx_th_spring_message_0.setCode("core.500.error");
    _jspx_th_spring_message_0.setText("系统内部发生错误");
    int[] _jspx_push_body_count_spring_message_0 = new int[] { 0 };
    try {
      int _jspx_eval_spring_message_0 = _jspx_th_spring_message_0.doStartTag();
      if (_jspx_th_spring_message_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_spring_message_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_spring_message_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_spring_message_0.doFinally();
      _jspx_tagPool_spring_message_text_code_nobody.reuse(_jspx_th_spring_message_0);
    }
    return false;
  }

  private boolean _jspx_meth_spring_message_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  spring:message
    org.springframework.web.servlet.tags.MessageTag _jspx_th_spring_message_1 = (org.springframework.web.servlet.tags.MessageTag) _jspx_tagPool_spring_message_text_code_nobody.get(org.springframework.web.servlet.tags.MessageTag.class);
    _jspx_th_spring_message_1.setPageContext(_jspx_page_context);
    _jspx_th_spring_message_1.setParent(null);
    _jspx_th_spring_message_1.setCode("core.500.error");
    _jspx_th_spring_message_1.setText("系统内部发生错误");
    int[] _jspx_push_body_count_spring_message_1 = new int[] { 0 };
    try {
      int _jspx_eval_spring_message_1 = _jspx_th_spring_message_1.doStartTag();
      if (_jspx_th_spring_message_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_spring_message_1[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_spring_message_1.doCatch(_jspx_exception);
    } finally {
      _jspx_th_spring_message_1.doFinally();
      _jspx_tagPool_spring_message_text_code_nobody.reuse(_jspx_th_spring_message_1);
    }
    return false;
  }

  private boolean _jspx_meth_spring_message_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  spring:message
    org.springframework.web.servlet.tags.MessageTag _jspx_th_spring_message_2 = (org.springframework.web.servlet.tags.MessageTag) _jspx_tagPool_spring_message_text_code_nobody.get(org.springframework.web.servlet.tags.MessageTag.class);
    _jspx_th_spring_message_2.setPageContext(_jspx_page_context);
    _jspx_th_spring_message_2.setParent(null);
    _jspx_th_spring_message_2.setCode("core.500.back");
    _jspx_th_spring_message_2.setText("返回首页");
    int[] _jspx_push_body_count_spring_message_2 = new int[] { 0 };
    try {
      int _jspx_eval_spring_message_2 = _jspx_th_spring_message_2.doStartTag();
      if (_jspx_th_spring_message_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_spring_message_2[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_spring_message_2.doCatch(_jspx_exception);
    } finally {
      _jspx_th_spring_message_2.doFinally();
      _jspx_tagPool_spring_message_text_code_nobody.reuse(_jspx_th_spring_message_2);
    }
    return false;
  }
}
