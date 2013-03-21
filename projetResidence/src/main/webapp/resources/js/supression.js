/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */




    $('.item .delete').click(function(){

        var elem = $(this).closest('.item');

        $.confirm({
            'title'		: 'Confirmation de suppression',
            'message'	: 'Vous êtes sur le point de supprimer cet élément. <br />Cette action n\'est pas réversible! Continuer?',
            'buttons'	: {
                'Oui'	: {
                    'class'	: 'blue',
                    'action': function(){
                        elem.slideUp();
                        $('#target').submit();
                    }
                },
                'Non'	: {
                    'class'	: 'gray',
                    'action': function(){}	// Nothing to do in this case. You can as well omit the action property.
                }
            }
        });

    });

