$(document).ready(function() {

    var $msgs = $('#role-messages');
    var $role = $('#role-dialog');
    var $roles = $('#role-data-table');
    var $rolesContextMenu = $('#roles-context-menu');
    
    
    $('#action-panel').puipanel({ toggleable: true });
    $('#nav-panel').puipanel({ toggleable: true });
    $msgs.puimessages();
    
    $role.puidialog({
        width: 600, height: 300, modal: false,
        showEffect: 'fade', hideEffect: 'fade',
        buttons: [{
            text: 'Cancel', icon: 'fa-ban',
            click: function(e) { $role.puidialog('hide'); }
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
                    $role.puidialog('hide');
                    $roles.puidatatable('reload');
                }).fail(function(data) {
                    $msgs.puimessages('show', 'error', {summary: 'Error', detail: data.message});
                });
            }
        }]
    });
    
    $roles.puidatatable({
        caption: 'Roles',
        selectionMode: 'single',
        columns: [
            { field: 'id', headerText: 'Id' },
            { field: 'name', headerText: 'Name'}
        ],
        datasource: function(callback) {
            $.ajax({
                url: '/api/roles',
                method: 'GET',
                dataType: 'json',
                context: this,
                success: function(response) {
                    callback.call(this, response);
                }
            });
        }
    });

    $rolesContextMenu.puicontextmenu({
        target: $roles
    });

    $('#create-new-role-anchor, #edit-selected-role-anchor').on('click', function() { $role.puidialog('show'); });
    $('#delete-selected-role-anchor').on('click', function() { $role.puidialog('show') });
});
