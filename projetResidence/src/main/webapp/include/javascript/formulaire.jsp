<!-- Include des javascript nécessaire pour la présentation des formulaire -->
<script type="text/javascript" src="${contexte}/resources/js/jquery.mask.js"></script>

<script>
    jQuery(function($){
        $("#date").mask("99-99-9999",{placeholder:" "});
        $("#noAppartement").mask("9?99",{placeholder:" "});
        $("#telephone").mask("999-999-9999",{placeholder:" "});
        $("#telephoneSecondaire").mask("999-999-9999",{placeholder:" "});
        // $("#tin").mask("99-9999999");
        // $("#ssn").mask("999-99-9999");
    });
</script>
