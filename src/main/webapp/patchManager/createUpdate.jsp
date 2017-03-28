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
		<li><spring:message code="label.menu.patchManager" /></li>
		<li class="active"><spring:message code="label.menu.patchManager.add" /></li>
	</ol>
</section>
<section class="content">
	<div class="row">
		<div class="col-md-12">
			<!-- Horizontal Form -->
			<div class="box box-info">
				<div class="box-header with-border">
					<h3 class="box-title"><spring:message code="label.patchManager.form" />:</h3>
				</div>
				<!-- /.box-header -->
				<!-- form start -->
				<form:form id="patchManagerForm" method="POST"
					action="${contextPath}/patchManager/createUpdate" modelAttribute="patchManagerDTO"
					class="form-signin">
					<form:input type="hidden" path="id"></form:input>
					<div class="box-body">
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" /> <input type="hidden" path="id"
							value="${patchManagerDTO.id}" />
						<spring:bind path="name">
							<div
								class="form-group has-feedback ${status.error ? 'has-error' : ''}">
								<label for="roleName"><spring:message code="label.patchManager.name" /></label>
								<div class="input-group">
									<div class="input-group-addon">
										<i class="fa fa-user"></i>
									</div>
									<form:input type="text" path="name"
										class="form-control pull-righ" placeholder="Enter Patch Manager Name"
										autofocus="true" required="required"></form:input>
								</div>
								<form:errors class="help-block" path="name"></form:errors>
							</div>
						</spring:bind>
						<spring:bind path="code">
							<div
								class="form-group has-feedback ${status.error ? 'has-error' : ''}">
								<label for="roleCode"><spring:message code="label.patchManager.code" /></label>
								<div class="input-group">
									<div class="input-group-addon">
										<i class="fa fa-user"></i>
									</div>
									<form:input type="text" path="code"
										class="form-control pull-righ" placeholder="Enter Patch Manager Code"
										autofocus="true" required="required"></form:input>
								</div>
								<form:errors class="help-block" path="code"></form:errors>
							</div>
						</spring:bind>
						<spring:bind path="description">
							<div
								class="form-group has-feedback ${status.error ? 'has-error' : ''}">
								<label for="roleCode"><spring:message code="label.patchManager.description" /></label>
								<div class="input-group">
									<div class="input-group-addon">
										<i class="fa fa-user"></i>
									</div>
									<form:input type="text" path="description"
										class="form-control pull-righ" placeholder="Enter Patch Manager Description"
										autofocus="true" required="required"></form:input>
								</div>
								<form:errors class="help-block" path="description"></form:errors>
							</div>
						</spring:bind>
						<spring:bind path="environmentId">
							<div
								class="form-group has-feedback ${status.error ? 'has-error' : ''}">
								<label for="privileges"><spring:message code="label.patchManager.environment" /></label>
								<div class="input-group">
									<div class="input-group-addon">
										<i class="fa fa-user"></i>
									</div>
									<form:select path="environmentId" items="${environements}" itemLabel="envName" itemValue="id" id="environments" class="form-control select2 pull-righ"/>
								</div>
								<form:errors class="help-block" path="environmentId"></form:errors>
							</div>
						</spring:bind>
						<spring:bind path="description">
							<div
								class="form-group has-feedback ${status.error ? 'has-error' : ''}">
								<label for="svnLocation"><spring:message code="label.patchManager.svnLocation" /></label>
								<div class="input-group">
									<div class="input-group-addon">
										<i class="fa fa-user"></i>
									</div>
									<form:input type="text" path="svnLocation"
										class="form-control pull-righ" placeholder="Enter SVN Location"
										autofocus="true" required="required"></form:input>
								</div>
								<form:errors class="help-block" path="svnLocation"></form:errors>
							</div>
						</spring:bind>
						
					</div>
					<!-- /.box-body -->

					<div class="box-footer">
						<button type="reset" class="btn btn-default"
							onclick="loadAllPatchManager();"><spring:message code="label.cancel" /></button>
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
		  $(".select2").select2();
		});
	$('#patchManagerForm').submit(function(e) {
		// this code prevents form from actually being submitted
		e.preventDefault();
		submitPatchManagerForm();
	});
</script>