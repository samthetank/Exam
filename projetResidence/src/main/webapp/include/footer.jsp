<%--
    Document   : footer
    Created on : Jan 2, 2013, 6:26:51 PM
    Author     : francisbeauchamps
--%>

<%@ page import="java.util.GregorianCalendar" %>
<%
    // Initialisation de l'année courante pour le copyright
    GregorianCalendar dateCourante = new GregorianCalendar();
    int anneeCourante = dateCourante.get(GregorianCalendar.YEAR);
%>

<div class="push"></div>
</div>
<div id="footer">
    <div id="footer-wrap">
        <div id="footer-container">
            <p class="left">Powered by Java</p><p><fmt:message key="footer.copyright" /> - <%= anneeCourante%> - <a href="#">Alpaga</a></p>
        </div>
    </div>
</div>
</body>
</html>