<div class="${erreur}" style="font-size: smaller" id="error">
    <c:forEach var="msgErreur" items="${listeErreur}">
        ${msgErreur.value}<br>
    </c:forEach>
</div>