<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- Content Header (Role index Page header) -->
<section class="content-header" id="main-breadcrumb">
	<h1>
		<spring:message code="label.application.name" /> <small><spring:message code="label.application.version" /></small>
	</h1>
	<ol class="breadcrumb">
		<li><a href="#"><i class="fa fa-dashboard"></i> <spring:message code="label.home" /></a></li>
		<li><spring:message code="label.menu.environmetUsers" /></li>
		<li class="active"><spring:message code="label.menu.environmetUsers.newEdit" /></li>
	</ol>
</section>
<section class="content">
	<div class="row">
		<div class="col-md-12">
			<!-- Horizontal Form -->
			<div class="box box-info">
				<div class="box-header with-border">
					<h3 class="box-title"><spring:message code="label.environmetUsers.form.header" />:</h3>
				</div>
				<!-- /.box-header -->
				<!-- form start -->
				<form:form id="environmentUserForm" method="POST"
					action="${contextPath}/environmentUser/save"
					modelAttribute="environmentUserDTO" class="form-signin">
					<form:input type="hidden" path="id"></form:input>
					<div class="box-body">
						<spring:bind path="userName">
							<div
								class="form-group has-feedback ${status.error ? 'has-error' : ''}">
								<label for="userName"><spring:message code="label.environmetUsers.form.username" /></label>
								<div class="input-group">
									<div class="input-group-addon">
										<i class="fa fa-envelope"></i>
									</div>
									<form:input type="text" path="userName"
										class="form-control pull-righ" placeholder="Enter User Name..."
										autofocus="true" required="required"></form:input>
								</div>
								<form:errors class="help-block" path="userName"></form:errors>
							</div>
						</spring:bind>
						<spring:bind path="password">
							<div
								class="form-group has-feedback ${status.error ? 'has-error' : ''}">
								<label for="userPassword"><spring:message code="label.environmetUsers.form.password" /></label>
								<div class="input-group">
									<div class="input-group-addon">
										<i class="fa fa-envelope"></i>
									</div>
									<form:input type="text" path="password"
										class="form-control pull-righ" placeholder="Enter Password..."
										autofocus="true" required="required"></form:input>
								</div>
								<form:errors class="help-block" path="password"></form:errors>
							</div>
						</spring:bind>
						<spring:bind path="environmentIds">
							<div
								class="form-group has-feedback ${status.error ? 'has-error' : ''}">
								<label for="roles"><spring:message code="label.menu.environment" /></label>
								<div class="input-group">
									<div class="input-group-addon">
										<i class="fa fa-user"></i>
									</div>
									<form:select path="environmentIds" multiple="true" items="${ENVIRONMENTS}"
										itemLabel="envName" itemValue="id" id="environmentId"
										class="form-control select2 pull-righ" />
								</div>
								<form:errors class="help-block" path="environmentIds"></form:errors>
							</div>
						</spring:bind>
					</div>
					<!-- /.box-body -->

					<div class="box-footer">
						<button type="reset" class="btn btn-default"
							onclick="loadAllEnvironment();"><spring:message code="label.cancel" /></button>
						<button type="button" class="btn btn-info margin" onclick=""><spring:message code="label.refresh" /></button>
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
		$('.select2').select2();
	});
	$('#environmentUserForm').submit(function(e) {
		// this code prevents form from actually being submitted
		e.preventDefault();
		submitEnvironmentUserForm();
	});
</script>