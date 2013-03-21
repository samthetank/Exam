<%@ include file="/include/header.jsp" %>
<h1 style="text-align: center;"><fmt:message key="login.label.titre" /></h1>
<div class="error" id="error">${error}</div>
<!--
<p>Les nom d'utilisateurs de base : admin, iDube, gestionM, surveilP et surveil</p>
-->
<div id="contentLogin">
    <form id="login" action="Login" method="post">
        
            <fmt:message key="login.input.identifiant" var="identifiantValue" />
            <input type="text" name="login" class="user-input" value="${identifiantValue}" onblur="onBlur(this)" onfocus="onFocus(this)"/>

            <br/>
            <fmt:message key="login.input.motPasse" var="motPasseValue" />
            <input type="text" name="pass" class="pass-input" value="${motPasseValue}" onblur="onBlur(this)" onfocus="onFocus(this)"/>

            <!-- Pour l'oubli de mot de passe -->
            <a id="oublimdplink" href="#oublimdpdiv"><fmt:message key="login.button.forgotmdp" /></a>

            <fmt:message key="login.button.submit" var="submitValue" />
            <input type="submit" class="buttonSubmit" value="${submitValue}"/>


    </form>

    <!-- Pour l'oubli de mot de passe -->
    <div id="oublimdpdiv">
        <span id="close" >&#215;</span><br/>
        <p> Saisissez votre identifiant afin que
            nous puissions vous envoyer un courriel
            pour réinitialiser votre mot de passe.
        </p>
        <form method="POST" action="Login" name="oubliMotDePasse">
            <label> Entrez votre identifiant: </label>
            <input name="username" type="text"  class="user-input" value="identifiant" onblur="onBlur(this)" onfocus="onFocus(this)"/>
            <input id="submitOubli" class="buttonSubmit" type="submit" value="Envoyer" onclick="setCommandeMdpOubli();"/>
            <input id="submitOubli" type="hidden" value="" name="oubliMdp"/>
        </form>
    </div>
</div>
<div id="lean_overlay"></div>
<SCRIPT>
    // Pour popup oubli de mot de passe
    $(function() {
        $('#oublimdplink').leanModal({ top : 300, closeButton: "#close" });
    });
</SCRIPT>
<SCRIPT>
    var error= '${error}';

    if (error == "")
        document.getElementById('error').className = 'noError';
    else
        document.getElementById('error').className = 'error';
</SCRIPT>
<SCRIPT>
    function onBlur(el) {
        document.getElementById("oublimdpdiv").style.background = "#C0C0C0";
        document.getElementById("oublimdpdiv").style.background = "#C0C0C0";
        if (el.value == '') {
            el.type='text';
            el.value = el.defaultValue;
            el.style.color = "#C0C0C0";
        } else {
            el.style.color = "black";
        }
    }
    function onFocus(el) {
        document.getElementById("oublimdpdiv").style.background = "#dcdcdc";
        document.getElementById("oublimdpdiv").style.background = "#dcdcdc";
        if (el.value == el.defaultValue) {
            if (el.name == 'pass')
                el.type='password';

            el.style.color = "black";
            el.value = '';
        }
    }

    function setCommandeMdpOubli(){
        document.oubliMotDePasse.oubliMdp.value = "mdpOubli";
    }
</SCRIPT>
<%@ include file="/include/footer.jsp" %>