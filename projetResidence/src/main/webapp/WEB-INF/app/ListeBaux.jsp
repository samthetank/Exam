<%--
    Document    : ListeBaux
    Created on  : 2013-02-22, 10:37:13
    Author      : Vince
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp" %>
<c:set var="btnAjouter" value="${requestScope.btnAjouter}" scope="page" />
<c:set var="btnEffacer" value="${requestScope.btnEffacer}" scope="page" />
<c:set var="btnModifier" value="${requestScope.btnModifier}" scope="page" />
<link rel="stylesheet" href="${contexte}/resources/styles/supression.css" />

<div class="box">
    <form id="target" method="GET" action="ListeBaux" name="liste" onsubmit="$.confirm()" >
        <table cellpadding="5" cellspacing="0" border="0" id="table" class="sortable" style="width: 100%">
            <thead>
                <tr>
                    <th class="head" style="border-left: solid 1px black;"><fmt:message key="bail.table.no"/></th>
                    <th class="head"><fmt:message key="bail.table.debut"/></th>
                    <th class="head"><fmt:message key="bail.table.fin"/></th>
                    <th class="head"><fmt:message key="bail.table.loyer"/></th>
                    <th class="head"><fmt:message key="bail.table.premLoc"/></th>
                    <th class="head"><fmt:message key="bail.table.deuxLoc"/></th>
                    <th class="head" style="border-right: solid 1px black;"><fmt:message key="bail.table.dernier"/></th>
                    <th class="nosort" style="border-right: solid 1px black; text-align: center;" colspan="${nbControles}"><fmt:message key="controles.table.actions"/></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="map" items="${liste}">
                    <tr>
                        <td>${map['noAppartement']}</td>
                        <td>${map['dateDebut']}</td>
                        <td>${map['dateFin']}</td>
                        <td>${map['montantLoyer']}</td>
                        <td>${map['locataire1']}</td>
                        <td>${map['locataire2']}</td>
                        <td>${map['dernierMois']}</td>

                        <!-- Suppression -->
                        <!-- On test pour l'affichage du bouton suprression. -->
                        <c:if test="${pageScope.btnEffacer == 'true'}" >
                            <td id="tdControle" title="Effacer" onclick="setType('suppression',${map['idBail']})">
                                <button class="item" type="submit" onclick="return false;">
                                    <img class="delete" onclick="return false;" src="${contexte}/resources/styles/images/delete.png" alt="submit" alt="delete" />
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
        <form method="POST" action="ListeBaux" name="Ajouter">
            <%@ include file="/include/controles/controleAjouter.jsp" %>
        </form>
    </c:if></td>
                    <td>
    <!-- BOUTON HISTORIQUE -->
    <form method="POST" action="ListeBaux" name="historique">
        <button type="submit" style="border: 0; background: transparent; cursor: pointer;" >
            <div id="historique" title="<fmt:message key="controles.table.historique"/>">
                <img src="${contexte}/resources/styles/images/book.png" width="30" alt="submit" alt="nadd" style="cursor: pointer;"/>
            </div>
        </button>
        <input type="hidden" name="action" value="historique">
    </form></td>
            <td>
    <!-- CONTROLES DE TABLE -->
    <%@ include file="/include/controles/controlesTable.jsp" %>
                        </td></tr></table>
</div>
<!-- Include des javascript nécessaire à l'affichage des listes -->
<%@ include file="/include/javascript/table.jsp" %>
<%@ include file="/include/footer.jsp" %>
