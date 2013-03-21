<%--
    Document   : ListeUtilisateurs
    Created on : Fev 15, 2013, 9:07:07 AM
    Author     : Vincent Fournier
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/include/header.jsp" %>
<%-- On prend les variables requete et on les mets dans les variables
     de la de page pour tester les droits --%>
<c:set var="btnAjouter" value="${requestScope.btnAjouter}" scope="page" />
<c:set var="btnEffacer" value="${requestScope.btnEffacer}" scope="page" />
<c:set var="btnModifier" value="${requestScope.btnModifier}" scope="page" />

<div class="box">
    <form method="GET" action="ListeUtilisateurs" name="liste" onsubmit="return confirmerSuppression()">
        <div class="${erreur}" style="font-size: smaller" id="error">${erreurSuppression}</div>
        <table cellpadding="5" cellspacing="0" border="0"
               id="table" class="sortable" style="width: 100%">
            <thead>
                <tr>
                    <th class="head" style="border-left: solid 1px black;">No</th>
                    <th class="head"><fmt:message key="utilisateurs.table.nom"/></th>
                    <th class="head"><fmt:message key="utilisateurs.table.prenom"/></th>
                    <th class="head"><fmt:message key="utilisateurs.table.usager"/></th>
                    <th class="head" style="border-right: solid 1px black;"><fmt:message key="utilisateurs.table.role"/></th>
                    <c:if test="${nbControles > 0}" >
                        <th class="nosort" style="border-right: solid 1px black; text-align: center;" colspan="${nbControles}"><fmt:message key="controles.table.actions"/></th>
                    </c:if>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="utilisateur" items="${liste}">
                    <c:if test="${utilisateur.nomUtilisateur != usager}">
                        <tr>
                            <td>${utilisateur.idUtilisateur}</td>
                            <td>${utilisateur.nom}</td>
                            <td>${utilisateur.prenom}</td>
                            <td>${utilisateur.nomUtilisateur}</td>
                            <td>${utilisateur.nomRole}</td>

                            <!-- Modif -->
                            <!-- On test pour l'affichage du bouton modification. -->
                            <c:if test="${pageScope.btnModifier == 'true'}" >
                                <td class="tdEdit" id="tdControle" title="<fmt:message key="controles.table.modifier"/>" onclick="setType('modifier');">
                                    <button type="submit" id="${utilisateur.idUtilisateur}" name="id" value="${utilisateur.idUtilisateur}">
                                        <img src="${contexte}/resources/styles/images/pencil2.png" alt="submit" alt="edit" onclick="setType('modif')"/>
                                    </button>
                                </td>
                            </c:if>

                            <!-- Suppression -->
                            <!-- && usager != utilisateur.nomUtilisateur -->
                            <c:if test="${pageScope.btnEffacer == 'true'}" >
                                <td class="tdSuppr" id="tdControle" title="<fmt:message key="controles.table.effacer"/>" onclick="setType('suppression')">
                                    <button type="submit" id="${utilisateur.idUtilisateur}" name="id" value="${utilisateur.idUtilisateur}">
                                        <img src="${contexte}/resources/styles/images/delete.png" alt="submit" alt="delete" onclick="setType('suppression')"/>
                                    </button>
                                </td>
                            </c:if>
                        </tr>
                    </c:if>
                </c:forEach>
            </tbody>
        </table>
        <!-- Pour passer le type de requete effectué -->
        <input type="hidden" name="action">
    </form>

                    <table style="width: 100%"><tr>
                            <td>
    <!-- BOUTON AJOUTER -->
    <form method="POST" action="ListeUtilisateurs" name="ajouter">
        <%@ include file="/include/controles/controleAjouter.jsp" %>
    </form></td>
                        <td>
    <!-- CONTROLES TABLE -->
    <%@ include file="/include/controles/controlesTable.jsp" %>
                            </td></tr></table>
</div>
<!-- Include des javascript nécessaire à l'affichage des listes -->
<%@ include file="/include/javascript/table.jsp" %>
<%@ include file="/include/footer.jsp" %>