<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<style type="text/css">
.fixed-panel {
	min-height: 500px;
	max-height: 500px;
}

.media-list {
	overflow: auto;
}
</style>
<!-- Content Header (Role index Page header) -->
<section class="content-header" id="main-breadcrumb">
	<h1>
		<spring:message code="label.application.name" /><small><spring:message code="label.application.version" /></small>
	</h1>
	<ol class="breadcrumb">
		<li><a href="#"><i class="fa fa-dashboard"></i> <spring:message code="label.home" /></a></li>
		<li class="active"><spring:message code="label.menu.chat" /></li>
	</ol>
</section>

<section class="content">
	<div class="row">
		<div class="col-xs-12">
			<!-- USERS LIST -->
			<div class="box box-danger">
				<div class="box-header with-border">
					<h3 class="box-title"><spring:message code="label.chat.latest.users" /></h3>

					<div class="box-tools pull-right">
						<span class="label label-danger"><spring:message code="label.chat.new.users" /></span>
						<button type="button" class="btn btn-box-tool"
							data-widget="collapse">
							<i class="fa fa-minus"></i>
						</button>
					</div>
				</div>
				<!-- /.box-header -->
				<div class="box-body no-padding">
					<ul class="users-list clearfix">
						<li style="width: 8%;"><img
							src="${contextPath}/resources/dist/img/user1-128x128.jpg"
							alt="User Image"> <a class="users-list-name" href="#">Alexander
								Pierce</a> <span class="users-list-date">Today</span></li>
						<li style="width: 8%;"><img
							src="${contextPath}/resources/dist/img/user8-128x128.jpg"
							alt="User Image"> <a class="users-list-name" href="#">Norman</a>
							<span class="users-list-date">Yesterday</span></li>
						<li style="width: 8%;"><img
							src="${contextPath}/resources/dist/img/user7-128x128.jpg"
							alt="User Image"> <a class="users-list-name" href="#">Jane</a>
							<span class="users-list-date">12 Jan</span></li>
						<li style="width: 8%;"><img
							src="${contextPath}/resources/dist/img/user6-128x128.jpg"
							alt="User Image"> <a class="users-list-name" href="#">John</a>
							<span class="users-list-date">12 Jan</span></li>
						<li style="width: 8%;"><img
							src="${contextPath}/resources/dist/img/user2-160x160.jpg"
							alt="User Image"> <a class="users-list-name" href="#">Alexander</a>
							<span class="users-list-date">13 Jan</span></li>
						<li style="width: 8%;"><img
							src="${contextPath}/resources/dist/img/user5-128x128.jpg"
							alt="User Image"> <a class="users-list-name" href="#">Sarah</a>
							<span class="users-list-date">14 Jan</span></li>
						<li style="width: 8%;"><img
							src="${contextPath}/resources/dist/img/user4-128x128.jpg"
							alt="User Image"> <a class="users-list-name" href="#">Nora</a>
							<span class="users-list-date">15 Jan</span></li>
						<li style="width: 8%;"><img
							src="${contextPath}/resources/dist/img/user3-128x128.jpg"
							alt="User Image"> <a class="users-list-name" href="#">Nadia</a>
							<span class="users-list-date">15 Jan</span></li>
					</ul>
					<!-- /.users-list -->
				</div>
				<!-- /.box-body -->
				<div class="box-footer text-center">
					<a href="javascript:void(0)" class="uppercase"><spring:message code="label.chat.all.users" /></a>
				</div>
				<!-- /.box-footer -->
			</div>
			<!--/.box -->
		</div>
		<div class="col-xs-12">
			<!-- Chat box -->
			<div class="box box-success">
				<div class="box-header">
					<i class="fa fa-comments-o"></i>

					<h3 class="box-title"><spring:message code="label.chat.header" /></h3>

					<div class="box-tools pull-right" data-toggle="tooltip"
						title="Status">
						<div class="btn-group" data-toggle="btn-toggle">
							<button type="button" class="btn btn-default btn-sm active">
								<i class="fa fa-square text-green"></i>
							</button>
							<button type="button" class="btn btn-default btn-sm">
								<i class="fa fa-square text-red"></i>
							</button>
						</div>
					</div>
				</div>
				<div class="box-body chat" id="chat-box"
					style="max-height: 350px; overflow-y: auto;"></div>
				<!-- /.chat -->
				<div class="box-footer">
					<div class="input-group">
						<input class="form-control" placeholder="Type message..."
							id="messageText">

						<div class="input-group-btn">
							<button type="button" class="btn btn-success" id="sendMessage">
								<spring:message code="label.chat.send" /> <i class="glyphicon glyphicon-send"></i>
							</button>
						</div>
					</div>
				</div>
			</div>
			<!-- /.box (chat box) -->
		</div>
	</div>
</section>
<script>
	console.debug('chat page loaded.');
	$(document).ready(function() {
		$.get("/messages", function(messages) {
			refreshMessages(messages)
		});

		$("#sendMessage").on("click", function() {
			sendMessage()
		});

		$('#messageText').keyup(function(e) {
			if (e.keyCode == 13) {
				sendMessage();
			}
		});
	});
</script>