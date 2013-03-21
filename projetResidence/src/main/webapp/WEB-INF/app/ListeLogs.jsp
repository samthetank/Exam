<%--
    Document   : ListeLogs
    Author     : Sam
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/include/header.jsp" %>
<%-- On prend les variables requete et on les mets dans les variables
     de la de page pour tester les droits --%>
<c:set var="btnVoir" value="${requestScope.btnVoir}" scope="page" />

<div class="box">
    <form method="GET" action="ListeLogs" name="liste" onsubmit="return confirmerSuppression()">
        <div class="${erreur}" style="font-size: smaller" id="error">${erreurSuppression}</div>
        <table cellpadding="5" cellspacing="0" border="0"
               id="table" class="sortable" style="width: 100%">
            <thead>
                <tr>
                    <th class="head" style="border-left: solid 1px black;"><fmt:message key="listeLogs.table.utilisateur"/></th>
                    <th class="head"><fmt:message key="listeLogs.table.date"/></th>
                    <th class="head" style="border-right: solid 1px black;"><fmt:message key="listeLogs.table.actionSur"/></th>
                    <th class="nosort" class="nosort" style="border-right: solid 1px black; text-align: center;" colspan="${nbControles}"><fmt:message key="listeLogs.table.actionLog"/></th>
                    <c:if test="${nbControles > 0}" >
                        <th class="nosort" style="border-right: solid 1px gray; text-align: center;" colspan="${nbControles}"><fmt:message key="controles.table.actions"/></th>
                    </c:if>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="log" items="${liste}">
                    <tr>
                        <td>${log.nomUtilisateur}</td>
                        <td>${log.dateLog}</td>
                        <td>${log.nomTable}</td>
                        <td>${log.action}</td>

                        <!-- Voir -->
                        <!-- On test pour l'affichage du bouton de visualisation. -->
                        <c:if test="${pageScope.btnVoir == 'true'}" >
                            <td class="tdView" id="tdControle" title="Voir" onclick="setType('voir');">
                                <button type="submit" id="${log.idLog}" name="id" value="${log.idLog}">
                                    <img src="${contexte}/resources/styles/images/view.png" alt="submit" alt="view" />
                                </button>
                            </td>
                        </c:if>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <!-- Pour passer le type de requete effectué -->
        <input type="hidden" name="action">
    </form>
                <table style="width: 100%">
    <!-- CONTROLES TABLE -->
    <tr>
        <td>
    <%@ include file="/include/controles/controlesTable.jsp" %>
        </td>
    </tr>
                </table>
</div>
<!-- Include des javascript nécessaire à l'affichage des listes -->
<%@ include file="/include/javascript/table.jsp" %>
<%@ include file="/include/footer.jsp" %>