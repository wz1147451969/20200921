/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.37
 * Generated at: 2020-09-22 03:47:51 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class changeDept_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/header.jsp", Long.valueOf(1600697525111L));
  }

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


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

      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <title>更新部门</title>\r\n");
      out.write("    <style>\r\n");
      out.write("        form{\r\n");
      out.write("            text-align: center;\r\n");
      out.write("        }\r\n");
      out.write("    </style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div style=\"margin: auto;text-align: center\" >\r\n");
      out.write("    <a href=\"");
      out.print(application.getContextPath());
      out.write("/addDept.jsp\">添加部门</a>\r\n");
      out.write("    <a href=\"");
      out.print(application.getContextPath());
      out.write("/dept?op=findById\">根据编号查找部门</a>\r\n");
      out.write("    <a href=\"");
      out.print(application.getContextPath());
      out.write("/dept?op=findByName\">根据名称查找部门</a>\r\n");
      out.write("    <a href=\"");
      out.print(application.getContextPath());
      out.write("/dept?op=findByLikeName\">根据名称模糊查找部门</a>\r\n");
      out.write("    <a href=\"");
      out.print(application.getContextPath());
      out.write("/dept?op=findAll\">显示所有部门</a>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("    <form action=\"");
      out.print(application.getContextPath());
      out.write("/dept?op=changeDept\" method=\"post\">\r\n");
      out.write("        <input type=\"text\" name=\"deptNo\" placeholder=\"请输入部门编号\"><br>\r\n");
      out.write("        <input type=\"text\" name=\"deptName\" placeholder=\"请输入部门名称\"><br>\r\n");
      out.write("        <input type=\"text\" name=\"loc\" placeholder=\"请输入部门地点\"><br>\r\n");
      out.write("        <input type=\"submit\" value=\"更新部门\">\r\n");
      out.write("    </form>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
