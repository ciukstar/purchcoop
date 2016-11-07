$(function() {
    var $category = $('#category-dialog');
    var $categories = $('#category-data-table');

	$('#create-new-category-button').puibutton({
		click: function() { $('#category-dialog').puidialog('show'); }
	});

    $('#category-image-upload-button').on('click', function() {
        $('#category-image-input-file').click();
    });

	$category.puidialog({
        title: 'Category',
        width: 600,
        minWidth: 300,
        height: 300,
		minHeight: 200,
		modal: true,
		buttons: [{
			text: 'Cancel',
			icon: 'fa-ban',
			click: function() {
				$category.puidialog('hide');
			}
		},{
			text: 'Save',
			icon: 'fa-save',
			click: function() {
				var category = {
					name: $("#category-name").val()
				};
				$.ajax({
					url: "/api/categories",
					type: "POST",
					contentType: "application/json; charset=utf-8",
					data: JSON.stringify(category),
					traditional: true,
					dataType: "json",
				}).done(function(data) { 
					$category.puidialog("hide"); 
					$categories.puidatatable('reload');
				});
			}
		}]
	});

	$categories.puidatatable({
		caption: 'Categories',
		paginator: { rows: 10 },
		selectionMode: "single",
		resizableColumns: true,
		columns: [
			{field: 'id', headerText: 'Id'},
			{field: 'name', headerText: 'Name'}
        ],
		datasource: function(callback) {
			$.ajax({
                url: "/api/categories",
				method: "GET",
				dataType: "json",
				context: this,
				success: function(response) {
					callback.call(this, response);
				}
			});
		}
	});
});
