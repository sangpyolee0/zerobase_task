/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.97
 * Generated at: 2024-12-09 14:26:26 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(4);
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"css/index.css\">\r\n");
      out.write("    <title>와이파이 정보 구하기</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("        <h1>와이파이 정보 구하기</h1>\r\n");
      out.write("        <nav>\r\n");
      out.write("            <a href=\"index.jsp\">홈</a>\r\n");
      out.write("            <span>|</span>\r\n");
      out.write("            <a href=\"history.jsp\">위치 히스토리 목록</a>\r\n");
      out.write("            <span>|</span>\r\n");
      out.write("            <a href=\"add-wifi.jsp\">Open API 와이파이 정보 가져오기</a>\r\n");
      out.write("        </nav>\r\n");
      out.write("        <form id=\"wifiForm\">\r\n");
      out.write("            <label for=\"lat\">LAT:</label>\r\n");
      out.write("            <input type=\"text\" id=\"lat\" name=\"lat\" placeholder=\"위도 입력\">\r\n");
      out.write("            <label for=\"lnt\">LNT:</label>\r\n");
      out.write("            <input type=\"text\" id=\"lnt\" name=\"lnt\" placeholder=\"경도 입력\">\r\n");
      out.write("            <button type=\"button\" onclick=\"setCustomLocation()\">내 위치 설정</button>\r\n");
      out.write("            <button type=\"button\" onclick=\"fetchWifiData()\">근처 WIFI 정보 보기</button>\r\n");
      out.write("        </form>\r\n");
      out.write("        <table>\r\n");
      out.write("            <thead>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <th>거리(Km)</th>\r\n");
      out.write("                    <th>관리번호</th>\r\n");
      out.write("                    <th>자치구</th>\r\n");
      out.write("                    <th>와이파이명</th>\r\n");
      out.write("                    <th>도로명주소</th>\r\n");
      out.write("                    <th>상세주소</th>\r\n");
      out.write("                    <th>설치위치(층)</th>\r\n");
      out.write("                    <th>설치유형</th>\r\n");
      out.write("                    <th>설치기관</th>\r\n");
      out.write("                    <th>서비스구분</th>\r\n");
      out.write("                    <th>망종류</th>\r\n");
      out.write("                    <th>설치년도</th>\r\n");
      out.write("                    <th>실내외구분</th>\r\n");
      out.write("                    <th>WIFI접속환경</th>\r\n");
      out.write("                    <th>X좌표</th>\r\n");
      out.write("                    <th>Y좌표</th>\r\n");
      out.write("                    <th>작업일자</th>\r\n");
      out.write("                </tr>\r\n");
      out.write("            </thead>\r\n");
      out.write("            <tbody id=\"wifiTable\">\r\n");
      out.write("                <!-- 데이터가 렌더링됩니다. -->\r\n");
      out.write("            </tbody>\r\n");
      out.write("        </table>\r\n");
      out.write("        <p class=\"message\">위치 정보를 입력한 후에 조회해 주세요.</p>\r\n");
      out.write("    </div>\r\n");
      out.write("</body>\r\n");
      out.write("<script>\r\n");
      out.write("    // 사용자 입력 위치로 설정\r\n");
      out.write("    function setCustomLocation() {\r\n");
      out.write("        const lat = document.getElementById('lat').value;\r\n");
      out.write("        const lnt = document.getElementById('lnt').value;\r\n");
      out.write("\r\n");
      out.write("        if (!lat || !lnt) {\r\n");
      out.write("            alert('위도와 경도를 모두 입력해야 합니다.');\r\n");
      out.write("        } else {\r\n");
      out.write("            alert(`위치가 설정되었습니다: LAT=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${lat}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(", LNT=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${lnt}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("`);\r\n");
      out.write("        }\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    // 근처 WiFi 데이터 가져오기\r\n");
      out.write("    function fetchWifiData() {\r\n");
      out.write("        const lat = document.getElementById('lat').value;\r\n");
      out.write("        const lnt = document.getElementById('lnt').value;\r\n");
      out.write("\r\n");
      out.write("        if (!lat || !lnt) {\r\n");
      out.write("            alert('위도와 경도를 입력하세요.');\r\n");
      out.write("            return;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        fetch(`nearby-wifi.jsp?lat=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${lat}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("&lnt=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${lnt}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("`)\r\n");
      out.write("            .then(response => {\r\n");
      out.write("                if (!response.ok) {\r\n");
      out.write("                    throw new Error('네트워크 응답이 실패했습니다.');\r\n");
      out.write("                }\r\n");
      out.write("                return response.json();\r\n");
      out.write("            })\r\n");
      out.write("            .then(data => {\r\n");
      out.write("                const tableBody = document.getElementById('wifiTable');\r\n");
      out.write("                tableBody.innerHTML = ''; // 테이블 초기화\r\n");
      out.write("                if (data.length === 0) {\r\n");
      out.write("                    alert('근처 WiFi 정보를 찾을 수 없습니다.');\r\n");
      out.write("                    return;\r\n");
      out.write("                }\r\n");
      out.write("\r\n");
      out.write("                data.forEach(wifi => {\r\n");
      out.write("                    const row = document.createElement('tr');\r\n");
      out.write("                    row.innerHTML = `\r\n");
      out.write("                        <td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${wifi.distance}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</td>\r\n");
      out.write("                        <td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${wifi.id || 'N/A'}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</td>\r\n");
      out.write("                        <td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${wifi.district || 'N/A'}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</td>\r\n");
      out.write("                        <td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${wifi.name || 'N/A'}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</td>\r\n");
      out.write("                        <td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${wifi.roadAddress || 'N/A'}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</td>\r\n");
      out.write("                        <td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${wifi.detailAddress || 'N/A'}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</td>\r\n");
      out.write("                        <td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${wifi.floor || 'N/A'}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</td>\r\n");
      out.write("                        <td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${wifi.installType || 'N/A'}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</td>\r\n");
      out.write("                        <td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${wifi.installAgency || 'N/A'}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</td>\r\n");
      out.write("                        <td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${wifi.serviceType || 'N/A'}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</td>\r\n");
      out.write("                        <td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${wifi.networkType || 'N/A'}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</td>\r\n");
      out.write("                        <td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${wifi.installYear || 'N/A'}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</td>\r\n");
      out.write("                        <td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${wifi.indoorOutdoor || 'N/A'}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</td>\r\n");
      out.write("                        <td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${wifi.environment || 'N/A'}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</td>\r\n");
      out.write("                        <td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${wifi.xCoord || 'N/A'}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</td>\r\n");
      out.write("                        <td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${wifi.yCoord || 'N/A'}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</td>\r\n");
      out.write("                        <td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${wifi.date || 'N/A'}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</td>\r\n");
      out.write("                    `;\r\n");
      out.write("                    tableBody.appendChild(row);\r\n");
      out.write("                });\r\n");
      out.write("            })\r\n");
      out.write("            .catch(error => {\r\n");
      out.write("                console.error('Error fetching WiFi data:', error);\r\n");
      out.write("                alert('WiFi 데이터를 가져오는 중 오류가 발생했습니다.');\r\n");
      out.write("            });\r\n");
      out.write("    }\r\n");
      out.write("</script>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
