$(function() {

	$('.msg').puimessages();

	$('.input_text').puiinputtext();

	$('.create_button').puibutton({
		icon: 'fa-plus',
		click: function() {
			$('#applicant').puidialog('show');
		}
	});
	
	$('.edit_button').puibutton({
		icon: 'fa-pencil'
	});
	
	$('.delete_button').puibutton({
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
					updateApplicantsDataTable();	
				});
			}
		}]
	});

	updateApplicantsDataTable();
});


	function updateApplicantsDataTable() {

	$('#applicants_data_table').puidatatable({
		caption: 'Applicants',
		paginator: { rows: 10 },
		selectionMode: "single",
		resizableColumns: true,
		columns: [
			{field: 'id', headerText: 'Id'},
			{field: 'surname', headerText: 'Surname'},
			{field: 'name', headerText: 'Name'},
			{field: 'patronymic', headerText: 'Patronymic'}
		],
		datasource: function(callback) {
			$.ajax({
				type: "GET",
				url: "/api/applicants",
				dataType: "json",
				context: this,
				success: function(response) {
					callback.call(this, response);
				}
			});
		}
	});
	}
