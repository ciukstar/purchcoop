$(document).ready(function() {
    var $msgs = $('#role-messages');
    var $dlg = $('#role-dialog');

    $msgs.puimessages();

    $('#create-new-role-button')
        .on('click', function(e) { $dlg.puidialog('show'); });
    
    $dlg.puidialog({
        width: 600, height: 300, modal: false,
        showEffect: 'fade', hideEffect: 'fade',
        buttons: [{
            text: 'Cancel', icon: 'fa-ban',
            click: function(e) { $dlg.puidialog('hide'); }
        },{
            text: 'Save', icon: 'fa-save',
            click: function(e) {
                var role = { 
                    name: $('#role-name').val(),
                    description: $('#role-description').val()
                };
                $.ajax({
                   url: 'api/roles',
                   method: 'POST',
                   contentType: "application/json; charset=utf-8",
                   data: JSON.stringify(role),
                   dataType: 'json',
                   traditional: true
                }).done(function(data) {
                    $dlg.puidialog('hide');
                }).fail(function(data) {
                    $msgs.puimessages('show', 'error', {summary: 'Error', detail: data.message});
                });
            }
        }]
    });
})
