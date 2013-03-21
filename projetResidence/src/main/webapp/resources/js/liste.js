/*
 * Fonctions utilisés pour l'affichage des listes
 */
$(function() {
    $('#historique').tipsy({
        gravity: 'w', 
        fade: true
    });
    $('#add').tipsy({
        gravity: 'w', 
        fade: true
    });
    $('*').tipsy({
        gravity: 'ne'
    });
});

var sorter = new TINY.table.sorter("sorter");
sorter.head = "head";
sorter.asc = "asc";
sorter.desc = "desc";
sorter.even = "evenrow";
sorter.odd = "oddrow";
sorter.evensel = "evenselected";
sorter.oddsel = "oddselected";
sorter.paginate = true;
sorter.currentid = "currentpage";
sorter.limitid = "pagelimit";
sorter.init("table",1);