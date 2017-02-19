<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- Content Header (Role index Page header) -->
<section class="content-header" id="main-breadcrumb">
	<h1>
		PingConsole<small>v1.0.0</small>
	</h1>
	<ol class="breadcrumb">
		<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
		<li class="active">Groups</li>
	</ol>
</section>

<!-- Main content -->
<section id="main-container" class="content">
	<div class="row">
		<div class="col-xs-12">
			<div class="box box-skin">
				<div class="box-header">
					<h3 class="box-title">Group Data Table</h3>
					<!-- Button trigger modal -->
					<button type="button" class="btn btn-skin pull-right" data-toggle="modal"
						data-target="#createGroup">Create New Group</button>
					<div class="clearfix"></div>
				</div>
				<!-- /.box-header -->
				<div class="box-body">
					<table id="groupDataTable"
						class="table table-bordered table-striped">
						<thead>
							<tr>
								<th><spring:message code="label.group.name" /></th>
								<th><spring:message code="label.group.code" /></th>
								<th><spring:message code="label.options" /></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${groups}" var="group">
								<tr>
									<td>${group.name}</td>
									<td>${group.code}</td>
									<td><div class="btn-group">
											<button type="button" class="btn btn-default btn-sm"
												onclick="editUser('${group.id}')">
												<i class="fa fa-edit"></i>
											</button>
											<button type="button" class="btn btn-default btn-sm">
												<i class="fa  fa-trash-o"></i>
											</button>
										</div></td>
								</tr>
							</c:forEach>
						</tbody>
						<tfoot>
							<tr>
								<th><spring:message code="label.group.name" /></th>
								<th><spring:message code="label.group.code" /></th>
								<th><spring:message code="label.options" /></th>
							</tr>
						</tfoot>
					</table>
				</div>
			</div>
		</div>
	</div>
	<!-- Modal -->
	<div class="modal fade" id="createGroup" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header btn-skin">
					<h5 class="modal-title pull-left" id="exampleModalLabel">Create New Group </h5>
					<button type="button" class="close pull-right" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<div class="clearfix"></div>
				</div>
				<div class="modal-body">
					<form:form id="createGroupForm" method="POST" action="${contextPath}/group/create" modelAttribute="group"
					class="form-signin">
						<spring:bind path="name">
							<div
								class="form-group has-feedback ${status.error ? 'has-error' : ''}">
								<label for="groupName">Group Name</label>
								<div class="input-group">
									<div class="input-group-addon">
										<i class="fa fa-user"></i>
									</div>
									<form:input type="text" path="name"
										class="form-control pull-righ" placeholder="Group Name"
										autofocus="true" required="required"></form:input>
								</div>
								<form:errors class="help-block" path="name"></form:errors>
							</div>
						</spring:bind>
						<spring:bind path="code">
							<div
								class="form-group has-feedback ${status.error ? 'has-error' : ''}">
								<label for="groupCode">Group Code</label>
								<div class="input-group">
									<div class="input-group-addon">
										<i class="fa fa-user"></i>
									</div>
									<form:input type="text" path="code"
										class="form-control pull-righ" placeholder="Group Code"
										autofocus="true" required="required"></form:input>
								</div>
								<form:errors class="help-block" path="code"></form:errors>
							</div>
						</spring:bind>
					</form:form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
					<button type="button" class="btn btn-skin">Save changes</button>
				</div>
			</div>
		</div>
	</div>
</section>
<!-- /.content -->
<script>
	console.debug('Group page loaded.');
	$(document).ready(function() {
		$('#groupDataTable').DataTable();
	});
</script>

