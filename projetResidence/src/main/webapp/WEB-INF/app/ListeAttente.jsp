<%--
    Document   : ListeAttente
    Created on : Jan 29, 2013, 9:07:07 PM
    Author     : francisbeauchamps
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp" %>
<%-- On prend les variables requete et on les mets dans les variables
     de la de page pour tester les droits --%>
<c:set var="btnAjouter" value="${requestScope.btnAjouter}" scope="page" />
<c:set var="btnEffacer" value="${requestScope.btnEffacer}" scope="page" />
<c:set var="btnModifier" value="${requestScope.btnModifier}" scope="page" />
${script}
<div class="box">
    <form method="POST" action="ListeAttente" name="liste" onsubmit="return confirmerSuppression();">
        <%@ include file="/include/controles/controleErreur.jsp" %>
        <table cellpadding="5" cellspacing="0" border="0" id="table" class="sortable" style="width: 100%">
            <thead>
                <tr>
                    <th class="head" style="border-left: solid 1px gray;"><fmt:message key="listeAttente.table.nom"/></th>
                    <th class="head"><fmt:message key="listeAttente.table.prenom"/></th>
                    <th class="head"><fmt:message key="listeAttente.table.numTel"/></th>
                    <th class="head"><fmt:message key="listeAttente.table.date"/></th>
                    <th class="head"><fmt:message key="listeAttente.table.contacte"/></th>
                    <th class="head" style="border-right: solid 1px gray;"><fmt:message key="listeAttente.table.preference"/></th>
                    <c:if test="${nbControles > 0}" >
                        <th class="nosort" style="border-right: solid 1px gray; text-align: center;" colspan="${nbControles}"><fmt:message key="controles.table.actions"/></th>
                    </c:if>
                </tr>
            </thead>

            <tbody>
                <c:forEach var="personne" items="${liste}">
                    <tr <c:if test="${personne.confirme=='false'}">
                            id="unread"
                        </c:if>>
                        <td>${personne.nom}</td>
                        <td>${personne.prenom}</td>
                        <td>${personne.telephone}</td>
                        <td>${personne.date}</td>
                        <td>
                            <c:choose>
                                <c:when test="${personne.confirme=='true'}">
                                    oui
                                </c:when>
                                <c:otherwise>
                                    non
                                </c:otherwise>
                            </c:choose>
                        </td>
                        <td>${personne.preferenceAppartement}</td>

                        <!-- Voir -->
                        <!-- On test pour l'affichage du bouton de visualisation. -->
                        <c:if test="${pageScope.btnModifier == 'true'}" >
                            <td class="tdView" id="tdControle" title="Voir" onclick="setType('voir');">
                                <button type="submit" id="${personne.idInscription}" name="id" value="${personne.idInscription}">
                                    <img src="${contexte}/resources/styles/images/view.png" alt="submit" alt="view" />
                                </button>
                            </td>
                        </c:if>

                        <!-- Modif -->
                        <!-- On test pour l'affichage du bouton modification. -->
                        <c:if test="${pageScope.btnModifier == 'true'}" >
                            <td class="tdEdit" id="tdControle" title="<fmt:message key="controles.table.modifier"/>" onclick="setType('modifier');">
                                <button type="submit" id="${personne.idInscription}" name="id" value="${personne.idInscription}">
                                    <img src="${contexte}/resources/styles/images/pencil2.png" alt="submit" alt="edit" />
                                </button>
                            </td>
                        </c:if>

                        <!-- Suppression -->
                        <!-- On test pour l'affichage du bouton suprression. -->
                        <c:if test="${pageScope.btnEffacer == 'true'}" >
                            <td class="tdSuppr" id="tdControle" title="<fmt:message key="controles.table.effacer"/>" onclick="setType('suppression')">
                                <button type="submit" id="${personne.idInscription}" name="id" value="${personne.idInscription}">
                                    <img src="${contexte}/resources/styles/images/delete.png" alt="submit" alt="delete" />
                                </button>
                            </td>
                        </c:if>

                        <!-- Transférer (transfére liste d'attente -> resident) -->
                        <!-- On test pour l'affichage du bouton de transfert. -->
                        <c:if test="${pageScope.btnModifier == 'true'}" >
                            <td class="tdTransfr" id="tdControle" title="<fmt:message key="controles.table.transferer"/>" onclick="setType('transferer');">
                                <button type="submit" id="${personne.idInscription}" name="id" value="${personne.idInscription}">
                                    <img src="${contexte}/resources/styles/images/transferer.png" alt="submit" alt="transferer" />
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
                    <table style="width: 100%"><tr>
                    <td>
    <!-- BOUTON AJOUTER -->
    <form method="POST" action="ListeAttente" name="ajout">
        <%@ include file="/include/controles/controleAjouter.jsp" %>
    </form></td><td>
    <!-- CONTROLES TABLE -->
    <%@ include file="/include/controles/controlesTable.jsp" %>
                    </td></tr></table>
</div>
<!-- Include des javascript nécessaire à l'affichage des listes -->
<%@ include file="/include/javascript/table.jsp" %>
<%@ include file="/include/footer.jsp" %>
