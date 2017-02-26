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
		<li class="active">Privilages</li>
	</ol>
</section>

<!-- Main content -->
<section id="main-container" class="content">
	<div class="row">
		<div class="col-xs-12">
			<div class="box box-skin">
				<div class="box-header">
					<h3 class="box-title">Privilages Data Table</h3>
					<!-- Button trigger modal -->
					<button type="button" class="btn btn-skin pull-right" data-toggle="modal"
						data-target="#createPrivilageModal">Create New Group</button>
					<div class="clearfix"></div>
				</div>
				<!-- /.box-header -->
				<div class="box-body">
					<table id="privilegeDataTable"
						class="table table-bordered table-striped">
						<thead>
							<tr>
								<th>Privilarge Name</th>
								<th>Privilage Code</th>
								<th>Description</th>
								<th>Options</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${privileges}" var="privilege">
								<tr>
									<td id="name_${privilege.id}">${privilege.name}</td>
									<td id="code_${privilege.id}">${privilege.code}</td>
									<td id="description_${privilege.id}">${privilege.description}</td>
									<td><div class="btn-group">
											<button type="button" class="btn btn-default btn-sm"
												onclick="editPrivilage('${privilege.id}')">
												<i class="fa fa-edit"></i>
											</button>
											<button type="button" class="btn btn-default btn-sm">
												<i class="fa fa-unlock-alt"></i>
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
								<th>Privilarge Name</th>
								<th>Privilage Code</th>
								<th>Description</th>
								<th>Options</th>
							</tr>
						</tfoot>
					</table>
				</div>
			</div>
		</div>
	</div>
	<!-- Modal -->
	<div class="modal fade" id="createPrivilageModal" tabindex="-1" role="dialog"
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
					<form:form id="createUpdatePrivilageForm" method="POST" action="${contextPath}/privilage/createUpdate" modelAttribute="privilage"
					class="form-signin">
					<input type="hidden" id="_csrf" value="${_csrf.token}"/>
					<input type="hidden" name="id" value="" id="privilegeId"/>
						<spring:bind path="name">
							<div
								class="form-group has-feedback ${status.error ? 'has-error' : ''}">
								<label for="groupName">Privilege Name</label>
								<div class="input-group">
									<div class="input-group-addon">
										<i class="fa fa-user"></i>
									</div>
									<form:input type="text" id="name" path="name"
										class="form-control pull-righ" placeholder="Group Name"
										autofocus="true" required="required"></form:input>
								</div>
								<form:errors class="help-block" path="name"></form:errors>
							</div>
						</spring:bind>
						<spring:bind path="code">
							<div
								class="form-group has-feedback ${status.error ? 'has-error' : ''}">
								<label for="groupCode">Privilege Code</label>
								<div class="input-group">
									<div class="input-group-addon">
										<i class="fa fa-user"></i>
									</div>
									<form:input type="text" id="code" path="code"
										class="form-control pull-righ" placeholder="Group Code"
										autofocus="true" required="required"></form:input>
								</div>
								<form:errors class="help-block" path="code"></form:errors>
							</div>
						</spring:bind>
						<spring:bind path="description">
							<div
								class="form-group has-feedback ${status.error ? 'has-error' : ''}">
								<label for="groupCode">Description</label>
								<div class="input-group">
									<div class="input-group-addon">
										<i class="fa fa-user"></i>
									</div>
									<form:input type="text" id="description" path="description"
										class="form-control pull-righ" placeholder="Group Code"
										autofocus="true" required="required"></form:input>
								</div>
								<form:errors class="help-block" path="description"></form:errors>
							</div>
						</spring:bind>
					</form:form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
					<button type="button" class="btn btn-skin" onclick="createUpdatePrivilege()">Save changes</button>
				</div>
			</div>
		</div>
	</div>
</section>
<!-- /.content -->
<script>
	console.debug('Privilege page loaded.');
	$(document).ready(function() {
		$('#privilegeDataTable').DataTable();
	});
</script>

