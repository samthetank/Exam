<%--
    Document   : Appartements
    Author     : Sam
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/include/header.jsp" %>
${erreur}
<div class="formulaire">
    <h3><fmt:message key="appartement.form.titre"/></h3>
    <div class="box">
        <%@ include file="/include/controles/controleAide.jsp" %>
        <%@ include file="/include/controles/controleErreur.jsp" %>
        <form method="POST" action="Appartement" autocomplete = "off">
            <ul style="list-style: none;">
                <li>
                    <label for="noAppartement"><fmt:message key="appartement.form.no"/>
                        <c:if test="${action=='Ajouter'}" >
                            <img src="${contexte}/resources/styles/images/asterisk2.png" alt="obligatoire" />
                        </c:if>
                    </label>
                    <input class="saisie" id="noAppartement" name="noAppartement"
                           <c:if test="${action!='Ajouter'}" > disabled </c:if>value="${noAppartement}"/>
                    </li>
                    <li style="display: inline;">
                        <fieldset>
                            <legend style="width: 100px;"><fmt:message key="appartement.form.etage"/>
                            <c:if test="${action=='Ajouter'}" >
                                <img src="${contexte}/resources/styles/images/asterisk2.png" alt="obligatoire" />
                            </c:if>
                        </legend>
                        <select name="etage">
                            <option value="1"
                                    <c:if test="${etage == '1'}">selected</c:if>><fmt:message key="appartement.form.etage.prem"/></option>
                                    <option value="2"
                                    <c:if test="${etage == '2'}">selected</c:if>><fmt:message key="appartement.form.etage.deux"/></option>
                                    <option value="3"
                                    <c:if test="${etage == '3'}">selected</c:if>><fmt:message key="appartement.form.etage.troi"/></option>
                                    <option value="4"
                                    <c:if test="${etage == '4'}">selected</c:if>><fmt:message key="appartement.form.etage.quat"/></option>
                            </select>
                        </fieldset>
                    </li>
                    <li style="display: inline;">
                        <fieldset>
                            <legend style="width: 70px;"><fmt:message key="appartement.form.phase"/>
                            <c:if test="${action=='ajouter'}" >
                                <img src="${contexte}/resources/styles/images/asterisk2.png" alt="obligatoire" />
                            </c:if>
                        </legend>
                        <select name="phase">
                            <option value="1"
                                    <c:if test="${phase == '1'}">selected</c:if>>1</option>
                                    <option value="2"
                                    <c:if test="${phase == '2'}">selected</c:if>>2</option>
                                    <option value="3"
                                    <c:if test="${phase == '3'}">selected</c:if>>3</option>
                            </select>
                        </fieldset>
                    </li>
                    <li style="display: inline;">
                        <fieldset>
                            <legend style="width: 100px;"><fmt:message key="appartement.form.taille"/>
                            <c:if test="${action=='ajouter'}" >
                                <img src="${contexte}/resources/styles/images/asterisk2.png" alt="obligatoire" />
                            </c:if>
                        </legend>
                        <select name="dimension">
                            <option value="P"
                                    <c:if test="${dimension == 'P'}">selected</c:if>><fmt:message key="appartement.form.taille.petit"/></option>
                                    <option value="M"
                                    <c:if test="${dimension == 'M'}">selected</c:if>><fmt:message key="appartement.form.taille.moyen"/></option>
                                    <option value="G"
                                    <c:if test="${dimension == 'G'}">selected</c:if>><fmt:message key="appartement.form.taille.grand"/></option>
                            </select>
                        </fieldset>
                    </li>
                    <li style="display: inline-block;">
                        <fieldset>
                            <legend><fmt:message key="appartement.form.nbPieces"/>
                            <c:if test="${action=='ajouter'}" >
                                <img src="${contexte}/resources/styles/images/asterisk2.png" alt="obligatoire" />
                            </c:if>
                        </legend>
                        <select name="nbPieces">
                            <option value="1"
                                    <c:if test="${nbPieces == '3'}">selected</c:if>>3 &frac12;</option>
                                    <option value="2"
                                    <c:if test="${nbPieces == '4'}">selected</c:if>>4 &frac12;</option>
                            </select>
                        </fieldset>
                    </li>
                    <li style="margin-bottom: 20px;">
                        <fieldset  style="width: 100%">
                            <legend><fmt:message key="appartement.form.description"/></legend>
                        <textarea class="saisie" rows="4" cols="35" name="description">${description}</textarea>
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

