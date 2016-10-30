$(function() {

	$('.msg').puimessages();

	$('.input-text').puiinputtext();

	$('.add-button').puibutton({
		icon: 'fa-plus',
		click: function() {
			$('#category-dialog').puidialog('show');
		}
	});
	
	$('.edit-button').puibutton({
		icon: 'fa-pencil'
	});
	
	$('.delete-button').puibutton({
		icon: 'fa-trash'
	});

	$('#category-dialog').puidialog({
        title: 'Category',
        width: 600,
        minWidth: 300,
        height: 300,
		minHeight: 200,
		modal: false,
		buttons: [{
			text: 'Cancel',
			icon: 'fa-ban',
			click: function() {
				$('#category-dialog').puidialog('hide');
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
					$("#category-dialog").puidialog("hide"); 
					updateCategoryDataTable();	
				});
			}
		}]
	});

	updateCategoryDataTable();
});


function updateCategoryDataTable() {

	$('#category-data-table').puidatatable({
		caption: 'Categories',
		paginator: { rows: 10 },
		selectionMode: "single",
		resizableColumns: true,
		columns: [
			{field: 'id', headerText: 'Id'},
			{field: 'name', headerText: 'Name'},
		],
		datasource: function(callback) {
			$.ajax({
				type: "GET",
				url: "/api/categories",
				dataType: "json",
				context: this,
				success: function(response) {
					callback.call(this, response);
				}
			});
		}
	});
	}
