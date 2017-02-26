<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- Content Header (Role index Page header) -->
<section class="content-header" id="main-breadcrumb">
	<h1>
		Ping <small>Console</small>
	</h1>
	<ol class="breadcrumb">
		<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
		<li>Role</li>
		<li class="active">create-update</li>
	</ol>
</section>
<section class="content">
	<div class="row">
		<div class="col-md-12">
			<!-- Horizontal Form -->
			<div class="box box-info">
				<div class="box-header with-border">
					<h3 class="box-title">Role Form :</h3>
				</div>
				<!-- /.box-header -->
				<!-- form start -->
				<form:form id="roleForm" method="POST"
					action="${contextPath}/role/createUpdate" modelAttribute="roleDTO"
					class="form-signin">
					<form:input type="hidden" path="id"></form:input>
					<div class="box-body">
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" /> <input type="hidden" path="id"
							value="${roleDTO.id}" />
						<spring:bind path="name">
							<div
								class="form-group has-feedback ${status.error ? 'has-error' : ''}">
								<label for="exampleInputEmail1">Role Name</label>
								<div class="input-group">
									<div class="input-group-addon">
										<i class="fa fa-user"></i>
									</div>
									<form:input type="text" path="name"
										class="form-control pull-righ" placeholder="Role Name"
										autofocus="true" required="required"></form:input>
								</div>
								<form:errors class="help-block" path="name"></form:errors>
							</div>
						</spring:bind>
						<spring:bind path="code">
							<div
								class="form-group has-feedback ${status.error ? 'has-error' : ''}">
								<label for="exampleInputEmail1">Role Code</label>
								<div class="input-group">
									<div class="input-group-addon">
										<i class="fa fa-user"></i>
									</div>
									<form:input type="text" path="code"
										class="form-control pull-righ" placeholder="Role Code"
										autofocus="true" required="required"></form:input>
								</div>
								<form:errors class="help-block" path="code"></form:errors>
							</div>
						</spring:bind>
						<spring:bind path="code">
							<div
								class="form-group has-feedback ${status.error ? 'has-error' : ''}">
								<label for="privileges">Role Code</label>
								<div class="input-group">
									<div class="input-group-addon">
										<i class="fa fa-user"></i>
									</div>
									<form:select path="code" multiple="true" items="${privileges}" itemLabel="code" itemValue="name" id="privileges" class="form-control select2 pull-righ"/>
								</div>
								<form:errors class="help-block" path="code"></form:errors>
							</div>
						</spring:bind>
						
					</div>
					<!-- /.box-body -->

					<div class="box-footer">
						<button type="reset" class="btn btn-default"
							onclick="loadAllEnvironment();">Cancel</button>
						<button type="button" class="btn btn-info margin" onclick="">Refresh</button>
						<button type="submit" class="btn btn-skin pull-right margin"
							onclick="">Save</button>
					</div>
				</form:form>
			</div>
			<!-- /.box-body -->
		</div>
		<!-- /.box -->
	</div>
</section>
<script>
	$(document).ready(function() {
		  $("#privileges").select2();
		});
	$('#roleForm').submit(function(e) {
		// this code prevents form from actually being submitted
		e.preventDefault();
		submitRoleForm();
	});
</script>