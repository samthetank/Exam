<%-- 
    Document   : Profil
    Created on : 2013-02-18, 16:01:39
    Author     : Thomas Lelievre
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/include/header.jsp" %>
${erreur}
<div class="formulaire">
    <div class="box">
        <%@ include file="/include/controles/controleErreur.jsp" %>
        <form method="POST" action="Profil">   
            <fieldset class="fdstProfil">
                <legend class="lgdProfil">Prénom & nom</legend>

                <label class="lbl" for="nom"> Changer le nom: </label>
                <input class="inptProfil" type="text" name="nom" value="${nom}" />

                <label class="lbl" for="prenom"> Changer le prénom: </label>
                <input class="inptProfil" type="text" name="prenom" value="${prenom}" /> 
            </fieldset>

            <fieldset class="fdstProfil">
                <legend class="lgdProfil">Mot de passe</legend>

                <label class="lbl" for="mdp"> Saisir le mot de passe actuel: </label>
                <input class="inptProfil" type="password" name="mdp" />

                <label class="lbl" for="modifmdp1"> Saisir le nouveau mot de passe: </label>
                <input class="inptProfil" type="password" name="modifmdp1" placeholder="xxxxxxxxxx" />

                <label class="lbl" for="modifmdp2"> Resaisir le nouveau mot de passe: </label> 
                <input class="inptProfil" type="password" name="modifmdp2" placeholder="xxxxxxxxxx" />
            </fieldset>

            <fieldset class="fdstProfil">
                <legend class="lgdProfil">Courriel</legend>   

                <label class="lbl" for="courriel"> Changer le courriel: </label>
                <input class="inptProfil" type="text" name="courriel" value="${courriel}" />
            </fieldset>

            <div style="display:block;">
                <%@ include file="/include/controles/controleAction.jsp" %>
            </div>
        </form>
    </div>
</div>
<%@ include file="/include/footer.jsp" %>
