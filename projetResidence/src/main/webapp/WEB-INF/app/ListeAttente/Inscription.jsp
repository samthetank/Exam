<%--
    Document   : InscriptionListeAttente
    Created on : Jan 30, 2013, 8:29:33 AM
    Author     : francisbeauchamps
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/include/header.jsp" %>
<div class="formulaire">
    <h3>Inscription</h3>
    <div class="box">
        <%@ include file="/include/controles/controleAide.jsp" %>
        <%@ include file="/include/controles/controleErreur.jsp" %>
        <form method="POST" action="Inscription" autocomplete = "off">
            <ul style="list-style: none;">
                <li>
                    <label for="nom"><fmt:message key="listeAttente.form.nom"/>
                        <c:if test="${action=='Ajouter'}" >
                            <img src="${contexte}/resources/styles/images/asterisk2.png" alt="obligatoire" />
                        </c:if>
                    </label>
                    <input class="saisie" id="nom" name="nom" value="${nom}"/>
                </li>
                <li>
                    <label for="prenom"><fmt:message key="listeAttente.form.prenom"/>
                        <c:if test="${action=='Ajouter'}" >
                            <img src="${contexte}/resources/styles/images/asterisk2.png" alt="obligatoire" />
                        </c:if>
                    </label>
                    <input class="saisie" id="prenom" name="prenom" value="${prenom}"/>
                </li>
                <li>
                    <label for="telephone"><fmt:message key="listeAttente.form.numTel"/>
                        <c:if test="${action=='Ajouter'}" >
                            <img src="${contexte}/resources/styles/images/asterisk2.png" alt="obligatoire" />
                        </c:if>
                    </label>
                    <input class="saisie" id="telephone" name="telephone" value="${telephone}"/>
                </li>
                <li>
                    <label for="courriel"><fmt:message key="listeAttente.form.courriel"/></label>
                    <input class="saisie" style="width: 180px;" id="courriel" name="courriel" value="${courriel}" placeholder="mon_adresse@email.ca"/>
                </li>
                <li>
                    <fieldset>
                        <legend><fmt:message key="listeAttente.form.preferenceApp"/>
                            <c:if test="${action=='Ajouter'}" >
                                <img src="${contexte}/resources/styles/images/asterisk2.png" alt="obligatoire" />
                            </c:if></legend>
                        <select name="prefApp">
                            <option value="3"
                                    <c:if test="${prefApp == '3'}">selected</c:if>><fmt:message key="listeAttente.form.preferenceApp.3"/></option>
                                    <option value="4"
                                    <c:if test="${prefApp == '4'}">selected</c:if>><fmt:message key="listeAttente.form.preferenceApp.4"/></option>
                                    <option value="aucune"
                                    <c:if test="${prefApp == 'aucune'}">selected</c:if>><fmt:message key="listeAttente.form.preferenceApp.aucun"/></option>
                            </select>
                        </fieldset>
                    </li>
                    <li>
                        <fieldset>
                            <legend><fmt:message key="listeAttente.form.preferenceEta"/>
                            <c:if test="${action=='Ajouter'}" >
                                <img src="${contexte}/resources/styles/images/asterisk2.png" alt="obligatoire" />
                            </c:if></legend>
                        <select name="prefEtage">
                            <option value="1"
                                    <c:if test="${prefApp == '1'}">selected</c:if>><fmt:message key="listeAttente.form.preferenceEta.SS"/></option>
                                    <option value="2"
                                    <c:if test="${prefApp == '2'}">selected</c:if>><fmt:message key="listeAttente.form.preferenceEta.RDC"/></option>
                                    <option value="3"
                                    <c:if test="${prefApp == '3'}">selected</c:if>><fmt:message key="listeAttente.form.preferenceEta.prem"/></option>
                                    <option value="3"
                                    <c:if test="${prefApp == '4'}">selected</c:if>><fmt:message key="listeAttente.form.preferenceEta.deux"/></option>
                            </select>
                        </fieldset>
                    </li>
                    <li>
                        <label for="confirme"><fmt:message key="listeAttente.form.confirme"/>
                        <c:if test="${action=='Ajouter'}" >
                            <img src="${contexte}/resources/styles/images/asterisk2.png" alt="obligatoire" />
                        </c:if>
                    </label>
                    <input type="checkbox" id="confirme" name="confirme" <c:if test="${confirme==true}">checked</c:if>/>
                    </li>
                    <li class="last">
                        <fieldset>
                            <legend><fmt:message key="listeAttente.form.comment1"/></legend>
                        <textarea class="saisie" rows="4" cols="35" name="comment"  />${comment}</textarea>
                    </fieldset>
                </li>
                <li class="last">
                    <fieldset>
                        <legend><fmt:message key="listeAttente.form.comment2"/></legend>
                        <textarea class="saisie" rows="4" cols="35" name="commentAdmin"  />${commentAdmin}</textarea>
                    </fieldset>
                </li>
                <li class="last">
                    <fieldset>
                        <legend><fmt:message key="listeAttente.form.comment3"/></legend>
                        <textarea class="saisie" rows="4" cols="35" name="commentRefus"  />${commentRefus}</textarea>
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
