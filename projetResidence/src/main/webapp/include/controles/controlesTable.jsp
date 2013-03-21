<!-- Controles pour naviguer dans l'affichage des données
     et pour modifier le nombre d'entrées par page -->
<div id="controls">
    <div id="perpage">
        <select onchange="sorter.size(this.value)">
            <option value="5">5</option>
            <option value="10" selected="selected">10</option>
            <option value="20">20</option>
            <option value="50">50</option>
            <option value="100">100</option>
        </select>
        <span><fmt:message key="controles.table.entriesPerPage"/></span>
    </div>
    <div id="navigation">
        <img src="${contexte}/resources/styles/images/first.gif" width="16" height="16" alt="First Page" onclick="sorter.move(-1,true)" />
        <img src="${contexte}/resources/styles/images/previous.gif" width="16" height="16" alt="First Page" onclick="sorter.move(-1)" />
        <img src="${contexte}/resources/styles/images/next.gif" width="16" height="16" alt="First Page" onclick="sorter.move(1)" />
        <img src="${contexte}/resources/styles/images/last.gif" width="16" height="16" alt="Last Page" onclick="sorter.move(1,true)" />
    </div>
    <div id="text"><fmt:message key="controles.table.curPage"/> <span id="currentpage"></span> <fmt:message key="controles.table.curPageOn"/> <span id="pagelimit"></span></div>
</div>