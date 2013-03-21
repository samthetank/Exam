<%--
    Document   : ListeAppartement
    Created on : 2013-02-18, 11:52:16
    Author     : 0910062
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/include/header.jsp" %>
<%-- On prend les variables requete et on les mets dans les variables
     de la de page pour tester les droits --%>
<c:set var="btnAjouter" value="${requestScope.btnAjouter}" scope="page" />
<c:set var="btnEffacer" value="${requestScope.btnEffacer}" scope="page" />
<c:set var="btnModifier" value="${requestScope.btnModifier}" scope="page" />
<link rel="stylesheet" href="${contexte}/resources/styles/supression.css" />
<div class="box">
    <form id="target" method="GET" action="ListeAppartements" name="liste" >
        <table cellpadding="5" cellspacing="0" border="0"
               id="table" class="sortable" style="width: 100%">
            <thead>
                <tr>
                    <th class="head" style="border-left: solid 1px black;"><fmt:message key="appartements.table.no"/></th>
                    <th class="head"><fmt:message key="appartements.table.etage"/></th>
                    <th class="head"><fmt:message key="appartements.table.phase"/></th>
                    <th class="head"><fmt:message key="appartements.table.taille"/></th>
                    <th class="head" style="border-right: solid 1px black;"><fmt:message key="appartements.table.nbPieces"/></th>
                    <c:if test="${nbControles > 0}" >
                        <th class="nosort" style="border-right: solid 1px black; text-align: center;" colspan="${nbControles}"><fmt:message key="controles.table.actions"/></th>
                    </c:if>
                </tr>
            </thead>

            <tbody>
                <c:forEach var="appartement" items="${liste}">
                    <tr>
                        <td>${appartement.noAppartement}</td>
                        <td>${appartement.etage}</td>
                        <td>${appartement.phase}</td>
                        <td>${appartement.dimension}</td>
                        <td>${appartement.nbPieces}</td>

                        <!-- Modif -->
                        <c:if test="${pageScope.btnModifier == 'true'}" >
                            <td class="tdEdit" id="tdControle" title="<fmt:message key="controles.table.modifier"/>"
                                onclick="setType('modifier');">
                                <button type="submit" id="${appartement.idAppartement}" name="id" value="${appartement.idAppartement}">
                                    <img src="${contexte}/resources/styles/images/pencil2.png" alt="submit" alt="edit" />
                                </button>
                            </td>
                        </c:if>

                        <!-- Suppression -->
                        <c:if test="${pageScope.btnEffacer == 'true'}" >
                            <td class="item" id="tdControle" title="<fmt:message key="controles.table.effacer"/>"
                                onclick="setType('suppression',${appartement.idAppartement})">
                                <button class="delete"  type="submit" onclick="return false">
                                    <img  src="${contexte}/resources/styles/images/delete.png" alt="submit" alt="delete" />
                                </button>
                            </td>
                        </c:if>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <!-- Pour passer le type de requete effectué -->
        <input type="hidden" name="action">
        <input type="hidden" id="id" name="id">

    </form>
                    <table style="width: 100%"><tr>
                            <td>
    <!-- BOUTON AJOUTER -->
    <c:if test="${pageScope.btnAjouter == 'true'}" >
        <form method="POST" action="ListeAppartements" name="ajouter">
            <%@ include file="/include/controles/controleAjouter.jsp" %>
        </form>
    </c:if>
                            </td><td>
    <!-- CONTROLES DE TABLE -->
    <%@ include file="/include/controles/controlesTable.jsp" %>
                            </td></tr></table>

</div>
<%@ include file="/include/javascript/table.jsp" %>
<%@ include file="/include/footer.jsp" %>
