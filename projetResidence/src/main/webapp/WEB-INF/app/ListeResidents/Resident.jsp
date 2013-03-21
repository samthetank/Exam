<%--
    Document   : ListeAttente
    Created on : Jan 29, 2013, 9:07:07 PM
    Author     : francisbeauchamps
--%>

<%@page import="util.UtilitaireDate"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/include/header.jsp" %>
<div class="formulaire">
    <h3>Résident</h3>
    <div class="box">
        <%@ include file="/include/controles/controleAide.jsp" %>
        <%@ include file="/include/controles/controleErreur.jsp" %>
        <form method="POST" action="Resident" autocomplete = "off">
            <ul style="list-style: none;">
                <li>
                    <label for="nom"><fmt:message key="resident.form.nom"/>
                        <c:if test="${action=='Ajouter'}" >
                            <img src="${contexte}/resources/styles/images/asterisk2.png" alt="obligatoire" />
                        </c:if>
                    </label>
                    <input type="text" class="saisie" id="nom" name="nom" value="${nom}"/>
                </li>
                <li>
                    <label for="prenom"><fmt:message key="resident.form.prenom"/>
                        <c:if test="${action=='Ajouter'}" >
                            <img src="${contexte}/resources/styles/images/asterisk2.png" alt="obligatoire" />
                        </c:if>
                    </label>
                    <input type="text" class="saisie" id="prenom" name="prenom" value="${prenom}"/>
                </li>
                <li>
                    <label for="telephone"><fmt:message key="resident.form.numTel"/>
                        <c:if test="${action=='Ajouter'}" >
                            <img src="${contexte}/resources/styles/images/asterisk2.png" alt="obligatoire" />
                        </c:if>
                    </label>
                    <input type="text" class="saisie" id="telephone" name="telephone" value="${telephone}"/>
                </li>
                <li>
                    <label for="telephoneSecondaire"><fmt:message key="resident.form.numTelSec"/></label>
                    <input type="text" class="saisie" id="telephoneSecondaire" name="telephoneSecondaire" value="${telephoneSecondaire}"/>
                </li>
                <li>
                    <fieldset>
                        <legend><fmt:message key="resident.form.titre"/>
                            <c:if test="${action=='Ajouter'}" >
                                <img src="${contexte}/resources/styles/images/asterisk2.png" alt="obligatoire" />
                            </c:if>
                        </legend>
                        <label><input type="radio" id="titreResident" name="titreResident" value="M." <c:if test="${titreResident == 'M.'}">checked</c:if> /><fmt:message key="resident.form.titre.homme"/></label>
                        <label><input type="radio" id="titreResident" name="titreResident" value="Mme." <c:if test="${titreResident == 'Mme.'}">checked</c:if> /> <fmt:message key="resident.form.titre.femme"/></label>
                        </fieldset>
                    </li>
                    <li>
                        <label for="dateNaissance"><fmt:message key="resident.form.naissance"/>
                        <c:if test="${action=='Ajouter'}" >
                            <img src="${contexte}/resources/styles/images/asterisk2.png" alt="obligatoire" />
                        </c:if>
                    </label>
                    <input type="date" class="saisie" id="dateNaissance" name="dateNaissance" value="${dateNaissance}"/>
                </li>
                <li>
                    <label for="dateArrivee"><fmt:message key="resident.form.arrivee"/>
                        <c:if test="${action=='Ajouter'}" >
                            <img src="${contexte}/resources/styles/images/asterisk2.png" alt="obligatoire" />
                        </c:if>
                    </label>
                    <c:choose>
                        <c:when test="${dateArrivee} != ''">
                            <input type="date" class="saisie" id="dateArrivee" name="dateArrivee" value="${dateArrivee}"/>
                        </c:when>
                        <c:otherwise>
                            <input type="date" class="saisie" id="dateArrivee" name="dateArrivee" value="<%= UtilitaireDate.greorianToString(UtilitaireDate.dateDuJour()) %>"/>
                        </c:otherwise>
                    </c:choose>
                </li>
                <li>
                    <label for="couleurIntervention"><fmt:message key="resident.form.couleur"/>
                        <c:if test="${action=='Ajouter'}" >
                            <img src="${contexte}/resources/styles/images/asterisk2.png" alt="obligatoire" />
                        </c:if>
                    </label>
                    <select id="couleurIntervention" name="couleurIntervention">
                        <option value="V"
                                <c:if test="${couleurIntervention=='V'}">selected</c:if>><fmt:message key="resident.form.couleur.vert"/></option>
                                <option value="J"
                                <c:if test="${couleurIntervention=='J'}">selected</c:if>><fmt:message key="resident.form.couleur.jaune"/></option>
                                <option value="R"
                                <c:if test="${couleurIntervention=='R'}">selected</c:if>><fmt:message key="resident.form.couleur.rouge"/></option>
                        </select>
                    </li>
                    <li>
                        <label for="nomVehicule"><fmt:message key="resident.form.vehicule"/></label>
                    <input type="text" class="saisie" id="nomVehicule" name="nomVehicule" value="${nomVehicule}"/>
                </li>
                <li>
                    <label for="plaqueImmatriculation"><fmt:message key="resident.form.immatriculation"/></label>
                    <input type="text" class="saisie" id="plaqueImmatriculation" name="plaqueImmatriculation" value="${plaqueImmatriculation}"/>
                </li>
                <li class="last">
                    <fieldset>
                        <legend><fmt:message key="resident.form.comment1"/></legend>
                        <textarea class="saisie" rows="4" cols="35" name="commentaire">${commentaire}</textarea>
                    </fieldset>
                </li>
                <li class="last">
                    <fieldset>
                        <legend><fmt:message key="resident.form.comment2"/></legend>
                        <textarea class="saisie" rows="4" cols="35" name="commentaireIntervention">${commentaireIntervention}</textarea>
                    </fieldset>
                </li>
                <li class="last">
                    <fieldset>
                        <legend><fmt:message key="resident.form.comment3"/></legend>
                        <textarea class="saisie" rows="4" cols="35" name="commentairePlainte">${commentairePlainte}</textarea>
                    </fieldset>
                </li>
                <li>
                    <%@ include file="/include/controles/controleAction.jsp" %>
                </li>
            </ul>
        </form>
    </div>
</div>

<%@ include file="/include/javascript/formulaire.jsp" %>
<%@ include file="/include/footer.jsp" %>
