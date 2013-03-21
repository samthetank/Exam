<%--
    Document   : voirLog
    Author     : Sam
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/include/header.jsp" %>
<div class="formulaire">
    <h3>Log</h3>
    <div class="box">
        <%@ include file="/include/controles/controleAide.jsp" %>
        <%@ include file="/include/controles/controleErreur.jsp" %>
        <form method="POST" action="Log" autocomplete = "off">
            <div>
                <legend><fmt:message key="Log.form.comment1"/></legend>
                <textarea class="saisie" readonly="true" rows="6" cols="45" name="valeur"  />${valeur}</textarea>
            </div>
            <div>    
                <legend><fmt:message key="Log.form.comment2"/></legend>
                <textarea class="saisie" readonly="true" rows="6" cols="45" name="ancienneValeur"  />${ancienneValeur}</textarea>
            </div>
            <div class="button-group" style="margin-left: -8px; height: 20px; padding-bottom: 0px;">
                <input type="submit" class="button" name="action" value="<fmt:message key='controles.form.annuler'/>" />
            </div>
        </form>
    </div>
</div>

<%@ include file="/include/javascript/formulaire.jsp" %>
<%@ include file="/include/footer.jsp" %>
