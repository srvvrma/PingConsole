$(document).ajaxStart(function() { Pace.restart(); });
$(document).ready(function() {	
	console.debug('Document Ready is working now.');
	loadDashboard();
	$(".treeview").click(function() {
		$(".treeview").removeClass("active");
		$(this).addClass("active");
	});
});
function loadDashboard() {
	console.debug('loading Console Main Page......');
	$.ajax({
		url : '/dashboard',
		success : function(result) {
			$('#mainContentId').html(result);
		},
		error : function(xhr, status, error){
			$('#mainContentId').html(xhr.responseText);
		}
	});
}

function loadRoles() {
	console.debug('loading Role Page......');
	$.ajax({
		url : '/roles',
		success : function(result) {
			$('#mainContentId').html(result);
		},
		error : function(xhr, status, error){
			$('#mainContentId').html(xhr.responseText);
		}
	});

}

function loadUsers(){
	console.debug('loading All Users......');
	$.ajax({
		url : '/users',
		success : function(result) {
			$('#mainContentId').html(result);
		},
		error : function(xhr, status, error){
			$('#mainContentId').html(xhr.responseText);
		}
	});
}