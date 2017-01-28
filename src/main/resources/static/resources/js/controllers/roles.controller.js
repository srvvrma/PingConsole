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
		url : '/users/loadAllUsers',
		success : function(result) {
			$('#mainContentId').html(result);
		},
		error : function(xhr, status, error){
			$('#mainContentId').html(xhr.responseText);
		}
	});
}

function loadAuthorities(){
	console.debug('loading All Privileges......');
	$.ajax({
		url : '/privileges/loadAllPrivileges',
		success : function(result) {
			$('#mainContentId').html(result);
		},
		error : function(xhr, status, error){
			$('#mainContentId').html(xhr.responseText);
		}
	});
}

function editUser(id){
	console.debug('editing User id : ' + id);
	$.ajax({
		url : '/users/edit/'+id,
		success : function(result) {
			$('#mainContentId').html(result);
		},
		error : function(xhr, status, error){
			$('#mainContentId').html(xhr.responseText);
		}
	});
}

function submitEditUserForm(){
	$.ajax({
		url : '/users/save',
		type : "post",
		data : $("#editUserForm").serialize(),
		success: function(result) {
			console.log('result ' + result);
			if(result != ''){
				$('#mainContentId').html(result);
			}else{
				loadUsers();
			}
			e.preventDefault();
		},
		error : function(xhr, status, error){
			$('#mainContentId').html(xhr.responseText);
		}
	});
}
