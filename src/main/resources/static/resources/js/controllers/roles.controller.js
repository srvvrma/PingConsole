$(document).ajaxStart(function() { Pace.restart(); });
$(document).ready(function() {	
	console.debug('Document Ready is working now.');
	loadDashboard();
	$(".sidebar-menu .treeview").click(function() {
		$(".treeview").removeClass("active");
		$(".sidebar-menu .treeview .treeview-menu").css("display","none");
		$(this).addClass("active");
	});
	
	$(".sidebar-menu .treeview .treeview-menu li").click(function(event) {
		$(".sidebar-menu .treeview .treeview-menu li").removeClass("active");
		$(this).addClass("active");
		event.stopPropagation();
	});
	iziToast.settings({
	    timeout: 10000,
	    resetOnHover: true,
	    icon: 'material-icons',
	    transitionIn: 'flipInX',
	    transitionOut: 'flipOutX',
	    onOpen: function(){
	        console.log('callback abriu!');
	    },
	    onClose: function(){
	        console.log("callback fechou!");
	    }
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

function whoIsLookup(){
	$.ajax({
		url : '/whoislookup/search',
		type : "get",
		success: function(result) {
				$('#mainContentId').html(result);
		},
		error : function(xhr, status, error){
			$('#mainContentId').html(xhr.responseText);
		}
	});
}

function searchWhoisDomain(){
	$.ajax({
		url : '/whoislookup/search',
		type : "post",
		data : $('#whoisDomainForm').serialize(),
		success: function(result) {
			$('#whoisResult').html(result);
		},
		error : function(xhr, status, error){
			$('#whoisResult').html(xhr.responseText);
		}
	});
}

function dnsLookup(){
	$.ajax({
		url : '/dnsLookup/search',
		type : "get",
		success: function(result) {
			$('#mainContentId').html(result);
		},
		error : function(xhr, status, error){
			$('#mainContentId').html(xhr.responseText);
		}
	});
}

function chat(){
	$.ajax({
		url : '/chat',
		type : "get",
		success: function(result) {
			$('#mainContentId').html(result);
		},
		error : function(xhr, status, error){
			$('#mainContentId').html(xhr.responseText);
		}
	});
}

function dnsLookupForDomain(){
	$.ajax({
		url : '/dnsLookup/search',
		type : "post",
		data : $('#dnsLookupForm').serialize(),
		success: function(result) {
			$('#dnsLookupResult').html(result);
		},
		error : function(xhr, status, error){
			$('#dnsLookupResult').html(xhr.responseText);
		}
	});
}

function getLoggedInUsers(){
	$.ajax({
		url : '/getLoggedInUsers',
		type : "get",
		success: function(result) {
			console.log(result);
		},
		error : function(xhr, status, error){
			console.log('error while getting list.');
		}
	});
}
function loadGroups(){
	$.ajax({
		url : '/group/showAll',
		type : "get",
		success: function(result) {
			$('#mainContentId').html(result);
		},
		error : function(xhr, status, error){
			$('#mainContentId').html(xhr.responseText);
		}
	});
}

function openGroupInEditMode(id){
	$('#createGroupForm #id').val(id);
	$('#createGroupForm #name').val($('#group_'+id+'_name').text());
	$('#createGroupForm #code').val($('#group_'+id+'_code').text());
	$('#createGroup').modal('show'); 
}

function crateEditGroup(){
	$.ajax({
		url : '/group/createEdit',
		type : "post",
		data : $('#createGroupForm').serialize(),
		success: function(result) {
			$('#createGroup').modal('hide');
			iziToast.success({
			    title: 'OK',
			    message: 'Successfully Group created!',
			    onClose: function(instance, toast, closedBy){
			    	loadGroups();
			    }
			});
		},
		error : function(xhr, status, error){
			iziToast.error({
			    title: 'Error',
			    message: 'Illegal operation',
			});
		}
	});
}

function deleteGroup(id){
	$.ajax({
		url : '/group/remove',
		type : "post",
		data : {
			id : id,
			_csrf : $('#_csrf').val()
		},
		success: function(result) {
			$('#createGroup').modal('hide');
			iziToast.success({
			    title: 'OK',
			    message: 'Group Successfully removed !',
			    onClose: function(instance, toast, closedBy){
			    	loadGroups();
			    }
			});
		},
		error : function(xhr, status, error){
			iziToast.error({
			    title: 'Error',
			    message: 'Illegal operation',
			});
		}
	});
}
