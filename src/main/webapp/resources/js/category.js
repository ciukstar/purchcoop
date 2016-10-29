$(function() {

	$('.msg').puimessages();

	$('.input_text').puiinputtext();

	$('.add-button').puibutton({
		icon: 'fa-plus',
		click: function() {
			$('#applicant').puidialog('show');
		}
	});
	
	$('.edit-button').puibutton({
		icon: 'fa-pencil'
	});
	
	$('.delete-button').puibutton({
		icon: 'fa-trash'
	});

	$('#applicant').puidialog({
		responsive: true,
		minWidth: 600,
		minHeight: 500,
		modal: true,
		buttons: [{
			text: 'Cancel',
			icon: 'fa-ban',
			click: function() {
				$('#applicant').puidialog('hide');
			}
		},{
			text: 'Save',
			icon: 'fa-save',
			click: function() {
				var applicant = {
					surname: $("#applicant_surname").val(),
					name: $("#applicant_name").val(),
					patronymic: $("#applicant_patronymic").val()
				};

				$.ajax({
					url: "/api/applicants",
					type: "POST",
					contentType: "application/json; charset=utf-8",
					data: JSON.stringify(applicant),
					traditional: true,
					dataType: "json",
				}).done(function(data) { 
					$("#applicant").puidialog("hide"); 
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
