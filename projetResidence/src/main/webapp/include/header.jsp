<%--
    Document   : header
    Created on : Jan 2, 2013, 6:25:33 PM
    Author     : Francis Beauchamp
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="style" value="${not empty param.style ? param.style : not empty style ? style : 'default'}" scope="session" />
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<c:set var="ongletAccueil"      value="${sessionScope.ongletAccueil}"       scope="page" />
<c:set var="ongletUtilisateurs" value="${sessionScope.ongletUtilisateurs}"  scope="page" />
<c:set var="ongletListeAttente" value="${sessionScope.ongletListeAttente}"  scope="page" />
<c:set var="ongletResidents"    value="${sessionScope.ongletResidents}"     scope="page" />
<c:set var="ongletAppartements" value="${sessionScope.ongletAppartements}"  scope="page" />
<c:set var="ongletBaux"         value="${sessionScope.ongletBaux}"          scope="page" />
<c:set var="ongletProfil"       value="${sessionScope.ongletProfil}"        scope="page" />
<c:set var="ongletLogs"         value="${sessionScope.ongletLogs}"        scope="page" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="langue.texte" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>${titre}</title>
        <meta name="author" lang="fr" content="Alpaga" />
        <link rel="shortcut icon" type="image/ico" href="http://www.datatables.net/media/images/favicon.ico" />

        <link rel="stylesheet" href="${contexte}/resources/styles/messages.css" />
        <link rel="stylesheet" href="${contexte}/resources/styles/form.css" />
        <link rel="stylesheet" href="${contexte}/resources/styles/formProfil.css" />

        <link rel="stylesheet" href="${contexte}/resources/styles/${style}.css" />
        <link rel="stylesheet" href="${contexte}/resources/styles/table.css" />
        <link rel="stylesheet" href="${contexte}/resources/styles/tipsy.css" />
        <link rel="stylesheet" href="${contexte}/resources/styles/libnotify.css" />

        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
        <script type="text/javascript" src="${contexte}/resources/js/jquery.leanModal.min.js"></script>
        <script type="text/javascript" src="${contexte}/resources/js/humane.min.js"></script>
        <script type='text/javascript' src='${contexte}/resources/js/recoverScroll.js'></script>

        <script>
            $(function(){
                // Notifications lors d'une suppression
                $(".tdSuppr").click(function(){
                    humane.log("Suppression effectuée !");
                    setTimeout(5000);
                });

            });
        </script>

        <c:if test="${recoverScroll == 'true'}" >
            <script type='text/javascript'>
                RecoverScroll.start();
            </script>
        </c:if>
    </head>
    <body onload="setActivePage('${page}');">
        <!-- HEADER -->
        <div id="header">

            <div id="header-wrap">
                <div id="header-container">
                    <h1><a href="#">Résidence&nbsp;du&nbsp;Carrefour</a></h1>

                </div>
            </div>
            <div id="menu" class="button-group" style="background-color: whitesmoke;">
                <c:if test="${pageScope.ongletAccueil == 'true'}" >
                    <a href="Index" class="button primary" id="index"><fmt:message key="header.nav.index" /></a>
                </c:if>
                <c:if test="${pageScope.ongletAppartements == 'true'}" >
                    <a href="ListeAppartements" class="button" id="listeAppartements"><fmt:message key="header.nav.appartement" /></a>
                </c:if>
                <c:if test="${pageScope.ongletResidents == 'true'}" >
                    <a href="ListeResidents" class="button" id="listeResidents"><fmt:message key="header.nav.residents" /></a>
                </c:if>
                <c:if test="${pageScope.ongletListeAttente == 'true'}" >
                    <a href="ListeAttente" class="button" id="listeAttente">
                        <fmt:message key="header.nav.listeAttente" />
                        <c:if test="${nbNonConfirme > 0}" >
                            <span class="alert">
                                ${nbNonConfirme}
                            </span>
                        </c:if>
                    </a>
                </c:if>
                <c:if test="${pageScope.ongletUtilisateurs == 'true'}" >
                    <a href="ListeUtilisateurs" class="button" id="listeUtilisateurs"><fmt:message key="header.nav.utilisateurs" /></a>
                </c:if>
                <c:if test="${pageScope.ongletLogs == 'true'}" >
                    <a href="ListeLogs" class="button" id="listeLogs"><fmt:message key="header.nav.logs" /></a>
                </c:if>
                <c:if test="${pageScope.ongletBaux == 'true'}" >
                    <a href="ListeBaux" class="button" id="listeBaux"><fmt:message key="header.nav.baux" /></a>
                </c:if>

                <!-- Remplacer par nom avec flêche -->
                <!--<a href="Profil" class="button" id="profil"><fmt:message key="header.nav.profil"/> </a>-->
                <!--<a href="Logout" class="button" id="logout"><fmt:message key="header.nav.logout" /></a>-->



                <form>
                    <select id="language" name="language" onchange="submit()">
                        <option value="fr" <c:if test="${fn:contains(language,'fr')}">selected</c:if>><fmt:message key="header.langue.fr"/></option>
                        <option value="en" <c:if test="${fn:contains(language,'en')}">selected</c:if>><fmt:message key="header.langue.en"/></option>
                    </select>
                    <select id="style" name="style" onchange="submit()">
                        <option value="default" ${style == 'default' ? 'selected' : ''}><fmt:message key="header.css.default"/></option>
                        <option value="alternatif" ${style == 'alternatif' ? 'selected' : ''}><fmt:message key="header.css.alt"/></option>
                    </select>
                </form>
            </div>
            <c:if test="${pageScope.ongletProfil == 'true'}" >
                <ul class="dropList" id="dropList">
                    <li id="userControl">
                        <a class="button" id="control">
                            ${usager}
                            <div id="arrow" class="arrow-right"> </div>
                        </a>
                        <ul>
                            <!--<div id="hide">-->
                            <li><a class="button" style="border-bottom: none" href="Profil"><fmt:message key="header.nav.profil"/></a></li>
                            <li><a class="button" href="Logout"><fmt:message key="header.nav.logout" /></a></li>
                            <!--</div>-->
                        </ul>
                    </li>
                </ul>
            </c:if>
            <SCRIPT>

                document.getElementById('userControl').onmouseover = showDropDown;
                document.getElementById('userControl').onmouseout = hideDropDown;
                function showDropDown(e){

                    document.getElementById('control').style.color ='#7A0000';
                    document.getElementById('control').className = 'button active';
                    document.getElementById('arrow').className = 'arrow-down';
                    //document.getElementById('arrow').style.borderLeftColor = '#7A0000';

                }

                function hideDropDown(){
                    document.getElementById('control').style.color ='black';
                    document.getElementById('arrow').className = 'arrow-right';
                    document.getElementById('control').className = 'button';
                    //document.getElementById('arrow').style.borderLeftColor = 'black';
                }

                function setActivePage(page) {
                    document.getElementById(page).className = "button active";
                }
            </SCRIPT>
        </div>
        <div id="content">
            <h2> ${titre} </h2>
