<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- Content Header (Role index Page header) -->
<section class="content-header" id="main-breadcrumb">
	<h1>
		<spring:message code="label.application.name" /><small><spring:message code="label.application.version" /></small>
	</h1>
	<ol class="breadcrumb">
		<li><a href="#"><i class="fa fa-dashboard"></i> <spring:message code="label.home" /></a></li>
		<li><spring:message code="label.menu.users" /></li>
		<li class="active"><spring:message code="label.menu.users.edit" /></li>
	</ol>
</section>
<section class="content">
	<div class="row">
		<div class="col-md-12">
			<!-- Horizontal Form -->
			<div class="box box-info">
				<div class="box-header with-border">
					<h3 class="box-title"><spring:message code="label.users.edit.form.header" /></h3>
				</div>
				<!-- /.box-header -->
				<!-- form start -->
				<form:form id="editUserForm" method="POST"
					action="${contextPath}/users/save" modelAttribute="userDTO"
					class="form-signin">
					<form:input type="hidden" path="id"></form:input>
					<div class="box-body">
						<spring:bind path="userName">
							<div
								class="form-group has-feedback ${status.error ? 'has-error' : ''}">
								<label for="userFullName"><spring:message code="label.users.edit.form.user.full.name" /></label>
								<div class="input-group">
									<div class="input-group-addon">
										<i class="fa fa-user"></i>
									</div>
									<form:input type="text" path="userName"
										class="form-control pull-righ" placeholder="User Full Name"
										autofocus="true" required="required"></form:input>
								</div>
								<form:errors class="help-block" path="userName"></form:errors>
							</div>
						</spring:bind>
						<spring:bind path="userId">
							<div
								class="form-group has-feedback ${status.error ? 'has-error' : ''}">
								<label for="userId"><spring:message code="label.users.edit.form.user.id" /></label>
								<div class="input-group">
									<div class="input-group-addon">
										<i class="fa fa-user"></i>
									</div>
									<form:input type="text" path="userId"
										class="form-control pull-righ" placeholder="Enter User Id"
										autofocus="true" required="required"></form:input>
								</div>
								<form:errors class="help-block" path="userId"></form:errors>
							</div>
						</spring:bind>
						<spring:bind path="email">
							<div
								class="form-group has-feedback ${status.error ? 'has-error' : ''}">
								<label for="exampleInputEmail1"><spring:message code="label.users.edit.form.email" /></label>
								<div class="input-group">
									<div class="input-group-addon">
										<i class="fa fa-envelope"></i>
									</div>
									<form:input type="text" path="email"
										class="form-control pull-righ" placeholder="Enter User Email"
										autofocus="true" required="required"></form:input>
								</div>
								<form:errors class="help-block" path="email"></form:errors>
							</div>
						</spring:bind>
						<spring:bind path="dob">
							<div
								class="form-group has-feedback ${status.error ? 'has-error' : ''}">
								<label><spring:message code="label.users.edit.form.dob" /></label>

								<div class="input-group date">
									<div class="input-group-addon">
										<i class="fa fa-calendar"></i>
									</div>
									<form:input type="date" path="dob"
										class="form-control pull-right" placeholder="Enter Date of Birth"
										autofocus="true" id="datepicker" required="required"></form:input>
								</div>
								<form:errors path="dob"></form:errors>
								<!-- /.input group -->
							</div>
						</spring:bind>
						<spring:bind path="roles">
							<div
								class="form-group has-feedback ${status.error ? 'has-error' : ''}">
								<label for="roles"><spring:message code="label.users.edit.form.role" /></label>
								<div class="input-group">
									<div class="input-group-addon">
										<i class="fa fa-user"></i>
									</div>
									<form:select path="roles" multiple="true" items="${rolesList}"
										itemLabel="code" itemValue="id" id="roles"
										class="form-control select2 pull-righ" />
								</div>
								<form:errors class="help-block" path="roles"></form:errors>
							</div>
						</spring:bind>
						<spring:bind path="groups">
							<div
								class="form-group has-feedback ${status.error ? 'has-error' : ''}">
								<label for="groups"><spring:message code="label.users.edit.form.group" /></label>
								<div class="input-group">
									<div class="input-group-addon">
										<i class="fa fa-user"></i>
									</div>
									<form:select path="groups" multiple="true" items="${groupList}"
										itemLabel="code" itemValue="id" id="groups"
										class="form-control select2 pull-righ" />
								</div>
								<form:errors class="help-block" path="groups"></form:errors>
							</div>
						</spring:bind>
					</div>
					<!-- /.box-body -->

					<div class="box-footer">
						<button type="reset" class="btn btn-default"
							onclick="loadUsers();"><spring:message code="label.cancel" /></button>
						<button type="button" class="btn btn-info margin"
							onclick="editUser('${userDTO.id}')"><spring:message code="label.refresh" /></button>
						<button type="submit" class="btn btn-skin pull-right margin"
							onclick=""><spring:message code="label.save" /></button>
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
		$('#roles').select2();
		$('#groups').select2();
	});
	//Date picker
	$('#datepicker').datepicker({
		autoclose : true
	});

	$('#editUserForm').submit(function(e) {
		// this code prevents form from actually being submitted
		e.preventDefault();
		submitEditUserForm(true);
	});
</script>