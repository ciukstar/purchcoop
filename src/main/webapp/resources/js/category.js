$(function() {

	$('.msg').puimessages();

	$('.input-text').puiinputtext();

	$('.add-button').puibutton({
		icon: 'fa-plus',
		click: function() {
			$('#category').puidialog('show');
		}
	});
	
	$('.edit-button').puibutton({
		icon: 'fa-pencil'
	});
	
	$('.delete-button').puibutton({
		icon: 'fa-trash'
	});

	$('#category').puidialog({
		minWidth: 600,
		minHeight: 500,
		modal: true,
		buttons: [{
			text: 'Cancel',
			icon: 'fa-ban',
			click: function() {
				$('#category').puidialog('hide');
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
					$("#category").puidialog("hide"); 
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
