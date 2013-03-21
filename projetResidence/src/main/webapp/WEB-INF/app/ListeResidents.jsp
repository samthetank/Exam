<%--
    Document   : ListeResidents
    Created on : 2013-02-15, 14:10:17
    Author     : Vincent
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
    <form method="POST" action="ListeResidents" name="liste" onsubmit="return confirmerSuppression();">
        <table cellpadding="5" cellspacing="0" border="0" id="table" class="sortable" style="width: 100%">
            <thead>
                <tr>
                    <th class="head" style="border-left: solid 1px black;"><fmt:message key="residents.table.nom" /></th>
                    <th class="head"><fmt:message key="residents.table.prenom" /></th>
                    <th class="head"><fmt:message key="residents.table.numTel" /></th>
                    <th class="head"><fmt:message key="residents.table.numTelSec" /></th>
                    <th class="head"><fmt:message key="residents.table.couleur" /></th>
                    <th class="head" style="border-right: solid 1px black;"><fmt:message key="residents.table.vehicule" /></th>
                    <c:if test="${nbControles > 0}" >
                        <th class="nosort" style="border-right: solid 1px black; text-align: center;" colspan="${nbControles}"><fmt:message key="controles.table.actions"/></th>
                    </c:if>
                </tr>
            </thead>

            <tbody>
                <c:forEach var="residents" items="${liste}">
                    <tr>
                        <td>${residents.nom}</td>
                        <td>${residents.prenom}</td>
                        <td>${residents.telephone}</td>
                        <td>${residents.telephoneSecondaire}</td>
                        <td>${residents.couleurIntervention}</td>
                        <td>${residents.nomVehicule}</td>

                        <!-- Modif -->
                        <c:if test="${pageScope.btnModifier == 'true'}" >
                            <td class="tdEdit" id="tdControle" title="<fmt:message key="controles.table.modifier"/>" onclick="setType('modifier');">
                                <button type="submit" id="${residents.idResident}" name="id" value="${residents.idResident}">
                                    <img src="${contexte}/resources/styles/images/pencil2.png" alt="submit" alt="edit" onclick="setType('modif')"/>
                                </button>
                            </td>
                        </c:if>

                        <!-- Suppression -->
                        <c:if test="${pageScope.btnEffacer == 'true'}" >
                            <td class="tdSuppr" id="tdControle" title="<fmt:message key="controles.table.effacer"/>" onclick="setType('suppression')">
                                <button type="submit"  id="${residents.idResident}" name="id" value="${residents.idResident}">
                                    <img src="${contexte}/resources/styles/images/delete.png" alt="submit" alt="delete" onclick="setType('suppression')"/>
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
                    <table style="width: 100%"><tr><td>
    <!-- BOUTON AJOUTER -->
    <c:if test="${pageScope.btnAjouter == 'true'}" >
        <form method="POST" action="ListeResidents" name="ajouter">
            <%@ include file="/include/controles/controleAjouter.jsp" %>
        </form>
    </c:if></td>
                        <td>
    <!-- CONTROLES DE TABLE -->
    <%@ include file="/include/controles/controlesTable.jsp" %>
                            </td></tr></table>
</div>
<%@ include file="/include/javascript/table.jsp" %>
<%@ include file="/include/footer.jsp" %>
