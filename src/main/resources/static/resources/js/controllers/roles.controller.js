$(document).ajaxStart(function() {
	Pace.restart();
});
$(document).ready(function() {
	console.debug('Document Ready is working now.');
	loadDashboard();
	$(".sidebar-menu .treeview").click(function() {
		$(".treeview").removeClass("active");
		$(".sidebar-menu .treeview .treeview-menu").css("display", "none");
		$(this).addClass("active");
	});

	$(".sidebar-menu .treeview .treeview-menu li").click(function(event) {
		$(".sidebar-menu .treeview .treeview-menu li").removeClass("active");
		$(this).addClass("active");
		event.stopPropagation();
	});
	iziToast.settings({
		timeout : 10000,
		resetOnHover : true,
		icon : 'material-icons',
		transitionIn : 'flipInX',
		transitionOut : 'flipOutX',
		onOpen : function() {
			console.log('callback abriu!');
		},
		onClose : function() {
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
		error : function(xhr, status, error) {
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
		error : function(xhr, status, error) {
			$('#mainContentId').html(xhr.responseText);
		}
	});
}

function submitRoleForm() {
	$.ajax({
		url : '/roles/createUpdate',
		type : "post",
		data : $("#roleForm").serialize(),
		success : function(result) {
			if (result != '') {
				$('#mainContentId').html(result);
			} else {
				loadRoles();
				iziToast.success({
					title : 'OK',
					message : 'Role Successfully Added !',
				});
			}
			e.preventDefault();
		},
		error : function(xhr, status, error) {
			$('#mainContentId').html(xhr.responseText);
		}
	});
}

function createOrUpdate(id) {
	$.ajax({
		url : '/roles/createUpdate?id=' + id,
		success : function(result) {
			$('#mainContentId').html(result);
		},
		error : function(xhr, status, error) {
			$('#mainContentId').html(xhr.responseText);
		}
	});
}

function loadUsers() {
	console.debug('loading All Users......');
	$.ajax({
		url : '/users/loadAllUsers',
		success : function(result) {
			$('#mainContentId').html(result);
		},
		error : function(xhr, status, error) {
			$('#mainContentId').html(xhr.responseText);
		}
	});
}

function loadPrivileges() {
	console.debug('loading All Privileges......');
	$.ajax({
		url : '/privileges/loadAllPrivilages',
		success : function(result) {
			$('#mainContentId').html(result);
		},
		error : function(xhr, status, error) {
			$('#mainContentId').html(xhr.responseText);
		}
	});
}
function createUpdatePrivilege() {
	$.ajax({
		url : '/privileges/createUpdate',
		type : "post",
		data : $("#createUpdatePrivilageForm").serialize(),
		success : function(result) {
			console.log('result ' + result);
			if (result != '') {
				$('#mainContentId').html(result);
			} else {
				$('#createPrivilageModal').modal('hide');
				iziToast.success({
					title : 'OK',
					message : 'Privilege Successfully Added !',
					onClose : function(instance, toast, closedBy) {
						loadPrivileges();
					}
				});
			}
			e.preventDefault();
		},
		error : function(xhr, status, error) {
			$('#mainContentId').html(xhr.responseText);
		}
	});
}

function editPrivilage(id) {
	$('#createUpdatePrivilageForm #privilegeId').val(id);
	$('#createUpdatePrivilageForm #name').val($('#name_' + id).text());
	$('#createUpdatePrivilageForm #code').val($('#code_' + id).text());
	$('#createUpdatePrivilageForm #description').val(
			$('#description_' + id).text());
	$('#createPrivilageModal').modal('show');
}

function editUser(id) {
	console.debug('editing User id : ' + id);
	$.ajax({
		url : '/users/edit/' + id,
		success : function(result) {
			$('#mainContentId').html(result);
		},
		error : function(xhr, status, error) {
			$('#mainContentId').html(xhr.responseText);
		}
	});
}

function submitEditUserForm(redirect) {
	$.ajax({
		url : '/users/save',
		type : "post",
		data : $("#editUserForm").serialize(),
		success : function(result) {
			console.log('result ' + result);
			if (result != '') {
				$('#mainContentId').html(result);
			} else {
				if (redirect) {
					loadUsers();
				}
			}
			e.preventDefault();
		},
		error : function(xhr, status, error) {
			$('#mainContentId').html(xhr.responseText);
		}
	});
}

function whoIsLookup() {
	$.ajax({
		url : '/whoislookup/search',
		type : "get",
		success : function(result) {
			$('#mainContentId').html(result);
		},
		error : function(xhr, status, error) {
			$('#mainContentId').html(xhr.responseText);
		}
	});
}

function searchWhoisDomain() {
	$.ajax({
		url : '/whoislookup/search',
		type : "post",
		data : $('#whoisDomainForm').serialize(),
		success : function(result) {
			$('#whoisResult').html(result);
		},
		error : function(xhr, status, error) {
			$('#whoisResult').html(xhr.responseText);
		}
	});
}

function dnsLookup() {
	$.ajax({
		url : '/dnsLookup/search',
		type : "get",
		success : function(result) {
			$('#mainContentId').html(result);
		},
		error : function(xhr, status, error) {
			$('#mainContentId').html(xhr.responseText);
		}
	});
}

function chat() {
	$.ajax({
		url : '/chat',
		type : "get",
		success : function(result) {
			$('#mainContentId').html(result);
		},
		error : function(xhr, status, error) {
			$('#mainContentId').html(xhr.responseText);
		}
	});
}

function dnsLookupForDomain() {
	$.ajax({
		url : '/dnsLookup/search',
		type : "post",
		data : $('#dnsLookupForm').serialize(),
		success : function(result) {
			$('#dnsLookupResult').html(result);
		},
		error : function(xhr, status, error) {
			$('#dnsLookupResult').html(xhr.responseText);
		}
	});
}

function getLoggedInUsers() {
	$.ajax({
		url : '/getLoggedInUsers',
		type : "get",
		success : function(result) {
			console.log(result);
		},
		error : function(xhr, status, error) {
			console.log('error while getting list.');
		}
	});
}
function loadGroups() {
	$.ajax({
		url : '/group/showAll',
		type : "get",
		success : function(result) {
			$('#mainContentId').html(result);
		},
		error : function(xhr, status, error) {
			$('#mainContentId').html(xhr.responseText);
		}
	});
}

function openGroupInEditMode(id) {
	$('#createGroupForm #id').val(id);
	$('#createGroupForm #name').val($('#group_' + id + '_name').text());
	$('#createGroupForm #code').val($('#group_' + id + '_code').text());
	$('#createGroup').modal('show');
}

function crateEditGroup() {
	$.ajax({
		url : '/group/createEdit',
		type : "post",
		data : $('#createGroupForm').serialize(),
		success : function(result) {
			$('#createGroup').modal('hide');
			iziToast.success({
				title : 'OK',
				message : 'Successfully Group created!',
				onClose : function(instance, toast, closedBy) {
					loadGroups();
				}
			});
		},
		error : function(xhr, status, error) {
			iziToast.error({
				title : 'Error',
				message : 'Illegal operation',
			});
		}
	});
}

function deleteGroup(id) {
	$.ajax({
		url : '/group/remove',
		type : "post",
		data : {
			id : id,
			_csrf : $('#_csrf').val()
		},
		success : function(result) {
			iziToast.success({
				title : 'OK',
				message : 'Group Successfully removed !',

			});
			loadGroups();
		},
		error : function(xhr, status, error) {
			iziToast.error({
				title : 'Error',
				message : 'Illegal operation',
			});
		}
	});
}

function createOrEditEnvironment(id) {
	$.ajax({
		url : '/environment/create?id=' + id,
		type : "get",
		success : function(result) {
			$('#mainContentId').html(result);
		},
		error : function(xhr, status, error) {
			$('#mainContentId').html(xhr.responseText);
		}
	});
}

function showEnvironmentDetails(id) {
	$.ajax({
		url : '/environment/showDetails/' + id,
		type : "get",
		success : function(result) {
			$('#mainContentId').html(result);
		},
		error : function(xhr, status, error) {
			$('#mainContentId').html(xhr.responseText);
		}
	});
}
function share(id){
	$.ajax({
		  url: "/environment/getById/"+id,
		  cache: false,
		  success: function(data){
			  console.log(data);
		    createMail(data);
		  }
		});
}

function createMail(data){
	var subject = data.envName + ' War is Up with rev #  ' + data.revisionNumber ;
    var linker = "mailto:?subject="+ subject + "&body=";
    linker += getBody(data);
    //console.log(linker);
    window.location = linker;
}

function getBody(data){
	var body = 'The '+ data.envName + ' Application is up and running with Revision #  ' + data.revisionNumber +'.\n\n' ;
	body += 'Environment Details::::: \n';
	body += 'Environment Name 	: ' + data.envName + '\n';
	body += 'Environment Location 	: ' + data.envUrl + '\n';
	body += 'Revision Number 		: ' + data.revisionNumber + '\n\n\n\n';
	body += 'Logs Details:::::::::::: \n';
	body += 'Log Host 				: ' + data.envLogUrl + '\n';
	body += 'Log User Name 		: ' + data.envLogUser + '\n';
	body += 'Log Password 		: ' + data.envLogPass + '\n';
	body += 'Application Log Path 	: ' + data.envLog + '\n';
	body += 'WAR Location 		: ' + data.envWar + '\n';
	body += 'Server Logs 			: ' + data.envServerLog + '\n\n\n\n';
	body += 'DataBase Details:::::::: \n';
	body += 'DataBase Server 		: ' + data.dbUrl + '\n';
	body += 'DataBase User Name 	: ' + data.dbUser + '\n';
	body += 'DataBase Password 	: ' + data.dbPass + '\n';
	body += 'Schema Name 		: ' + data.dbSchema + '\n\n\n';
	//body += 'Find UpDated Details : ${baseUrl}/environmentDetails/' + data.key + '\n';
	//body += 'Find All Environment Details : ${baseUrl}/showAll';
	return encodeURI(body);
	
}

function loadJSONFormatter() {
	$.ajax({
		url : '/formatter/json',
		type : "get",
		success : function(result) {
			$('#mainContentId').html(result);
		},
		error : function(xhr, status, error) {
			$('#mainContentId').html(xhr.responseText);
		}
	});
}

function formatJSON() {
	$.ajax({
		url : '/formatter/json',
		type : "post",
		data : $("#jsonForm").serialize(),
		success : function(result) {
			$('#jsondataOutput').val(result);
		},
		error : function(xhr, status, error) {
			$('#mainContentId').html(xhr.responseText);
		}
	});
}

function loadUserProfile() {
	$.ajax({
		url : '/settings/profile/showProfile',
		type : "get",
		success : function(result) {
			$('#mainContentId').html(result);
		},
		error : function(xhr, status, error) {
			$('#mainContentId').html(xhr.responseText);
		}
	});
}
function loadAllEnvironment() {
	$.ajax({
		url : '/environment/showAll',
		type : "get",
		success : function(result) {
			$('#mainContentId').html(result);
		},
		error : function(xhr, status, error) {
			$('#mainContentId').html(xhr.responseText);
		}
	});
}
function submitEnvironmentForm() {
	$.ajax({
		url : '/environment/save',
		type : "post",
		data : $("#environmentForm").serialize(),
		success : function(result) {
			console.log('result ' + result);
			if (result != '') {
				$('#mainContentId').html(result);
			} else {
				loadAllEnvironment();
				iziToast.success({
					title : 'OK',
					message : 'New Environment Successfully Added !',
				});
			}
			e.preventDefault();
		},
		error : function(xhr, status, error) {
			$('#mainContentId').html(xhr.responseText);
		}
	});
}

function loadPatchView() {
	$.ajax({
		url : '/patch/create',
		type : "get",
		success : function(result) {
			$('#mainContentId').html(result);
		},
		error : function(xhr, status, error) {
			$('#mainContentId').html(xhr.responseText);
		}
	});
}
function getEnvironmentStatus() {
	$.ajax({
		url : '/environment/getStatus',
		type : "get",
		success : function(result) {
			$('#mainContentId').html(result);
		},
		error : function(xhr, status, error) {
			$('#mainContentId').html(xhr.responseText);
		}
	});
}
function printData(jiraId, author, date) {
	iziToast.success({
		title : 'Author : ' + author + ' Data : ' + date,
		message : jiraId,

	});
}

function fetchDataFromSVN() {
	console.log();
	var revNumber = $('#revisionNumber').val();
	$.ajax({
		url : "/patch/getDataByRevNo?revNumbers=" + revNumber,
		cache : false,
		success : function(data) {
			printData(data['jiraId'], data['author'], data['date']);
			var jiraId = data['jiraId'];
			jiraId = jiraId.substring(0, jiraId.indexOf('-ReviewedBy'));
			$('#jiraId').val(jiraId);
			$('#patchPath').val(data['path'].join('\r\n'));
		}
	});
}
function FetchData() {
	$.ajax({
		url : '/environment/getStatus',
		type : "get",
		cache : false,
		success : function(result) {
			$.each(result, function(k, v) {
			    // key and value pair
				if(v == true){
					$('[id="environment_status_'+ k +'"]').html("Running").removeAttr('class').addClass("label label-success");
				}else{
					$('[id="environment_status_'+ k +'"]').html("Down").removeAttr('class').addClass("label label-danger");
				}
			});
		},
		error : function(xhr, status, error) {
		}
	});
}
function loadRestTestView() {
	$.ajax({
		url : '/rest/index',
		type : "get",
		success : function(result) {
			$('#mainContentId').html(result);
		},
		error : function(xhr, status, error) {
			$('#mainContentId').html(xhr.responseText);
		}
	});
}
//chat js
var stompClient = null;

function connect() {
	var socket = new SockJS('/newMessage');
	stompClient = Stomp.over(socket);
	stompClient.connect({}, function(frame) {
		stompClient.subscribe('/topic/newMessage', function(message) {
			refreshMessages(JSON.parse(JSON.parse(message.body).content));
		});
	});
}

function disconnect() {
	if (stompClient != null) {
		stompClient.disconnect();
	}
}

function refreshMessages(messages) {
	$
			.each(
					messages.reverse(),
					function(i, message) {
						var curr_date = new Date();
						var msg_date = new Date(message.createDate);

						var hours_diff = Math.abs(msg_date.getHours()
								- curr_date.getHours());
						var minutes_diff = Math.abs(msg_date.getHours()
								* 60 + msg_date.getMinutes()
								- curr_date.getHours() * 60
								- curr_date.getMinutes());
						var time_string
						if (hours_diff > 0) {
							time_string = hours_diff + " hours ago";
						} else {
							time_string = minutes_diff + " minutes ago"
						}
						console.log("xxx has updated " + hours_diff
								+ " hours ago");
						console.log("xxx has updated " + minutes_diff
								+ " minutes ago");
						$container = $('#chat-box');
						if(typeof $container[0] == 'undefined' && $('input[id="notificationTurnOff"]:checked').length == 0){
							iziToast.info({
							    title: 'Hey',
							    icon: 'icon-drafts',
							    message: 'You\'ve new message from ' + message.author,
							    position: 'bottomCenter',
							    image: '/resources/dist/img/user3-128x128.jpg',
							    balloon: true,
							    buttons: [
							      ['<button>Photo</button>',
							        function(instance, toast) {

							          // instance.hide({ transitionOut: 'fadeOutUp' }, toast);

							          iziToast.show({
							            color: 'dark',
							            icon: 'icon-photo',
							            title: 'OK',
							            message: 'Callback Photo!',
							            position: 'bottomCenter',
							            // iconText: 'star',
							          });

							        }
							      ],
							      ['<button>Message</button>',
							        function(instance, toast) {

							          // instance.hide({ transitionOut: 'fadeOutUp' }, toast);

							          iziToast.show({
							            color: 'dark',
							            icon: 'icon-ondemand_video',
							            message: message.text,
							            position: 'bottomCenter',
							            // iconText: 'star',
							          });

							        }
							      ],
							      ['<button>Goto Chat</button>',
							        function(instance, toast) {
							    	  
							          instance.hide({ transitionOut: 'fadeOutUp' }, toast);
							          chat();
							        }
							      ],
							    ]
							  });
							return;
						}
						$("#chat-box")
								.append(
										'<div class="item">'
												+ '<img src="'
												+ contextPath
												+'/resources/dist/img/user3-128x128.jpg" alt="user image" class="offline">'
												+ '<p class="message">'
												+ '<a href="#" class="name">'
												+ '<small class="text-muted pull-right"><i class="fa fa-clock-o"></i> '
												+ time_string + '</small>'
												+ message.author + '</a>'
												+ message.text + '</p>'
												+ '</div>');

						/* $(".media-list").append('<li class="media"><div class="media-body"><div class="media"><div class="media-body">'
						+ message.text + '<br/><small class="text-muted">' + message.author + ' | ' + new Date(message.createDate) + '</small><hr/></div></div></div></li>'); */
					});
	$container = $('#chat-box');
	$container[0].scrollTop = $container[0].scrollHeight;
	$container.animate({
		scrollTop : $container[0].scrollHeight
	}, "slow");
}
function sendMessage() {
	$container = $('#chat-box');
	$container[0].scrollTop = $container[0].scrollHeight;
	var message = $("#messageText").val();

	stompClient.send("/app/newMessage", {}, JSON.stringify({
		'text' : message,
		'author' : author
	}));

	$("#messageText").val("")
	$container.animate({
		scrollTop : $container[0].scrollHeight
	}, "slow");

}
connect();

/*
 *  js for patch manager
 */ 

function createOrUpdatePatchManager(id){
	$.ajax({
		url : '/patchManager/createUpdate?id=' + id,
		success : function(result) {
			$('#mainContentId').html(result);
		},
		error : function(xhr, status, error) {
			$('#mainContentId').html(xhr.responseText);
		}
	});
}

function submitPatchManagerForm(){
	
}


/*
 *  end js for patch manager
 */

/*
 * JS for Rest API Testing
 */ 


function startRestAPITest() {
	$.ajax({
		url : '/rest/test',
		type : "post",
		data : $("#restAPITestForm").serialize(),
		success : function(result) {
			if (result != '') {
				$('#mainContentId').html(result);
			} else {
				loadRoles();
				iziToast.success({
					title : 'OK',
					message : 'Role Successfully Added !',
				});
			}
			e.preventDefault();
		},
		error : function(xhr, status, error) {
			$('#mainContentId').html(xhr.responseText);
		}
	});
}



/*
 * End JS For Rest API Testing
 */
