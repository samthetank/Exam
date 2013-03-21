<%--
    Document   : Utilisateur
    Created on : 2013-02-15, 11:07:18
    Author     : Vincent
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/include/header.jsp" %>
<div class="formulaire">
    <h3>Utilisateur</h3>
    <div class="box">
        <%@ include file="/include/controles/controleAide.jsp" %>
        <%@ include file="/include/controles/controleErreur.jsp" %>
        <form method="POST" action="Utilisateur" autocomplete = "off">
            <ul style="list-style: none;">
                <li>
                    <label for="nom"><fmt:message key="utilisateurs.form.nom"/>
                        <c:if test="${action=='Ajouter'}" >
                            <img src="${contexte}/resources/styles/images/asterisk2.png" alt="obligatoire" />
                        </c:if>
                    </label>
                    <input class="saisie" id="nom" name="nom" value="${nom}"/>
                </li>
                <li>
                    <label for="prenom"><fmt:message key="utilisateurs.form.prenom"/>
                        <c:if test="${action=='Ajouter'}" >
                            <img src="${contexte}/resources/styles/images/asterisk2.png" alt="obligatoire" />
                        </c:if>
                    </label>
                    <input class="saisie" id="prenom" name="prenom" value="${prenom}"/>
                </li>
                <li>
                    <label for="courriel"><fmt:message key="utilisateurs.form.courriel"/>
                        <c:if test="${action=='Ajouter'}" >
                            <img src="${contexte}/resources/styles/images/asterisk2.png" alt="obligatoire" />
                        </c:if>
                    </label>
                    <input class="saisie" style="width: 180px;" id="courriel" name="courriel" value="${courriel}" placeholder="mon_adresse@email.ca"/>
                </li>
                <li>
                    <label for="nomUtilisateur"><fmt:message key="utilisateurs.form.usager"/>
                        <c:if test="${action=='Ajouter'}" >
                            <img src="${contexte}/resources/styles/images/asterisk2.png" alt="obligatoire" />
                        </c:if>
                    </label>
                    <input class="saisie" id="nomUtilisateur" name="nomUtilisateur"
                           <c:if test="${usager == nomUtilisateur && action!='Ajouter' }" >disabled="true"</c:if>value="${nomUtilisateur}"/>
                    </li>
                    <li>
                        <label for="motDePasse"><fmt:message key="utilisateurs.form.mdp"/>
                        <c:if test="${action=='Ajouter'}" >
                            <img src="${contexte}/resources/styles/images/asterisk2.png" alt="obligatoire" />
                        </c:if>
                    </label>
                    <input class="saisie" id="motDePasse" name="motDePasse" value="${motDePasse}" />
                </li>
                <li>
                    <fieldset <c:if test="${(role == 1 || role == 6) && action!='Ajouter'}" >disabled="true"</c:if>>
                        <legend><fmt:message key="utilisateurs.form.role"/>
                            <img src="${contexte}/resources/styles/images/asterisk2.png" alt="obligatoire" />
                        </legend>
                        <select name="role">
                            <option value="1"
                                    <c:if test="${role == '1'}">selected</c:if>><fmt:message key="utilisateurs.form.role.admin"/></option>
                                    <option value="2"
                                    <c:if test="${role == '2'}">selected</c:if>><fmt:message key="utilisateurs.form.role.gestionnaire"/> +</option>
                                    <option value="3"
                                    <c:if test="${role == '3'}">selected</c:if>><fmt:message key="utilisateurs.form.role.gestionnaire"/></option>
                                    <option value="4"
                                    <c:if test="${role == '4'}">selected</c:if>><fmt:message key="utilisateurs.form.role.surveillant"/> +</option>
                                    <option value="5"
                                    <c:if test="${role == '5'}">selected</c:if>><fmt:message key="utilisateurs.form.role.surveillant"/></option>
                            </select>
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