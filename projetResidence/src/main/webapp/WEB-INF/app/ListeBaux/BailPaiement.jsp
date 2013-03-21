<%--
    Document   : BailPaiement
    Created on : 2013-02-23, 11:50:06
    Author     : Vincent
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/include/header.jsp" %>

<div class="formulaire">
    <div class="box">
        <%@ include file="/include/controles/controleAide.jsp" %>
        <%@ include file="/include/controles/controleErreur.jsp" %>
        <form method="POST" action="BailPaiement">
            <ul style="list-style: none;">
                <li>
                    <label for="dateDebut"><fmt:message key="bail.form.debut"/>
                        <img src="${contexte}/resources/styles/images/asterisk2.png" alt="obligatoire" /></label>
                    <input type="date" class="saisie" id="dateDebut" name="dateDebut" value="${dateDebut}" />
                </li>
                <li>
                    <label for="dateFin"><fmt:message key="bail.form.fin"/>
                        <img src="${contexte}/resources/styles/images/asterisk2.png" alt="obligatoire" />
                    </label>
                    <input type="date" class="saisie" id="dateFin" name="dateFin" value="${dateFin}" />
                </li>
                <li>
                    <label for="montantMensuel"><fmt:message key="bail.form.loyer"/>
                        <img src="${contexte}/resources/styles/images/asterisk2.png" alt="obligatoire" />
                    </label>
                    <input class="saisie" id="montantMensuel" name="montantMensuel" value="${montantMensuel}" />
                </li>
                <li>
                    <label for="appartementSelect"><fmt:message key="bail.form.appartement"/></label>
                    <select id="appartementSelect" name="appartementSelect">
                        <option value="-1"><fmt:message key="bail.form.appartement.message"/>...</option>
                        <c:forEach var="appartement" items="${appartements}">
                            <option value="${appartement.idAppartement}" ${appartement.idAppartement == appartementSelect ? 'selected' : ''}>${appartement.noAppartement}</option>
                        </c:forEach>
                    </select>
                </li>
                <li>
                    <label for="locataire1"><fmt:message key="bail.form.premLoc"/><sup>1</sup>
                        <img src="${contexte}/resources/styles/images/asterisk2.png" alt="obligatoire" />
                    </label>
                    <select id="locataire1" name="locataire1">
                        <option value="-1"><fmt:message key="bail.form.premLoc.message"/>...</option>
                        <c:forEach var="resident" items="${residents}">
                            <option value="${resident.idResident}" ${resident.idResident == locataire1 ? 'selected' : ''}>${resident.nom}, ${resident.prenom}</option>
                        </c:forEach>
                    </select>
                </li>
                <li>
                    <label for="locataire2"><fmt:message key="bail.form.deuxLoc"/></label>
                    <select id="locataire2" name="locataire2">
                        <option value="-1"><fmt:message key="bail.form.deuxLoc.message"/>...</option>
                        <c:forEach var="resident" items="${residents}">
                            <option value="${resident.idResident}" ${resident.idResident == locataire2 ? 'selected' : ''}>${resident.nom}, ${resident.prenom}</option>
                        </c:forEach>
                    </select>
                </li>
                <li>
                    <label for="estSignataire"><fmt:message key="bail.form.signataire"/><sup>2</sup> : </label>
                    <input type="checkbox" id="estSignataire" name="estSignataire" value="estSignataire" <c:if test="${estSignataire==true}">checked</c:if>>
                    </li>

                    <li class="last">
                        <fieldset>
                            <legend><fmt:message key="bail.form.comment"/></legend>
                        <textarea class="validvisutext" rows="4" cols="35" name="commentaire"  />${commentaire}</textarea>
                    </fieldset>
                </li>
                <li>
                    <%@ include file="/include/controles/controleAction.jsp" %>
                </li>
            </ul>
        </form>
    </div>
    <p>
        1 - <fmt:message key="bail.form.message.1"/></br>
        2 - <fmt:message key="bail.form.message.2"/></br>
    </p>
</div>
<%@ include file="/include/footer.jsp" %>
