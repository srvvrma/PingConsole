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
		<li><spring:message code="label.environment" /></li>
		<li class="active"><spring:message code="label.environment.create.update" /></li>
	</ol>
</section>
<section class="content">
	<div class="row">
		<div class="col-md-12">
			<!-- Horizontal Form -->
			<div class="box box-info">
				<div class="box-header with-border">
					<h3 class="box-title"><spring:message code="label.environment.form.header" />:</h3>
				</div>
				<!-- /.box-header -->
				<!-- form start -->
				<form:form id="environmentForm" method="POST"
					action="${contextPath}/environment/save"
					modelAttribute="environmentDTO" class="form-signin">
					<form:input type="hidden" path="id"></form:input>
					<div class="box-body">
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
						<div class="form-group">
							<label> <form:radiobutton path="environmentType"
									value="CAS" required="required" /> <spring:message code="label.environment.cas" />
							</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<label> <form:radiobutton path="environmentType"
									value="LMS" required="required" /> <spring:message code="label.environment.lms" />
							</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<label> <form:radiobutton path="environmentType"
									value="INTEGRATION" required="required" /> <spring:message code="label.environment.integration" />
							</label>
						</div>
						<input type="hidden" path="id" value="${environmentDTO.id}" />
						<spring:bind path="groupId">
							<div
								class="form-group has-feedback ${status.error ? 'has-error' : ''}">
								<label for="groups"><spring:message code="label.environment.form.groups" /></label>
								<div class="input-group">
									<div class="input-group-addon">
										<i class="fa fa-user"></i>
									</div>
									<form:select path="groupId" multiple="true" items="${groups}"
										itemLabel="code" itemValue="id" id="groupId"
										class="form-control select2 pull-righ" />
								</div>
								<form:errors class="help-block" path="groupId"></form:errors>
							</div>
						</spring:bind>
						<spring:bind path="envName">
							<div
								class="form-group has-feedback ${status.error ? 'has-error' : ''}">
								<label for="environmentName"><spring:message code="label.environment.form.name" /></label>
								<div class="input-group">
									<div class="input-group-addon">
										<i class="fa fa-user"></i>
									</div>
									<form:input type="text" path="envName"
										class="form-control pull-righ" placeholder="Enter Environment Name"
										autofocus="true" required="required"></form:input>
								</div>
								<form:errors class="help-block" path="envName"></form:errors>
							</div>
						</spring:bind>
						<spring:bind path="envUrl">
							<div
								class="form-group has-feedback ${status.error ? 'has-error' : ''}">
								<label for="environmentUrl"><spring:message code="label.environment.form.url" /></label>
								<div class="input-group">
									<div class="input-group-addon">
										<i class="fa fa-user"></i>
									</div>
									<form:input type="text" path="envUrl"
										class="form-control pull-righ" placeholder="Environment Url"
										autofocus="true" required="required"></form:input>
								</div>
								<form:errors class="help-block" path="envUrl"></form:errors>
							</div>
						</spring:bind>
						<spring:bind path="pingUrl">
							<div
								class="form-group has-feedback ${status.error ? 'has-error' : ''}">
								<label for="pingUrl"><spring:message code="label.environment.form.pingurl" /></label>
								<div class="input-group">
									<div class="input-group-addon">
										<i class="fa fa-user"></i>
									</div>
									<form:input type="text" path="pingUrl"
										class="form-control pull-righ" placeholder="Ping Url"
										autofocus="true" required="required"></form:input>
								</div>
								<form:errors class="help-block" path="pingUrl"></form:errors>
							</div>
						</spring:bind>
						<spring:bind path="revisionNumber">
							<div
								class="form-group has-feedback ${status.error ? 'has-error' : ''}">
								<label for="revisionNumber"><spring:message code="label.environment.form.revision.number" /></label>
								<div class="input-group">
									<div class="input-group-addon">
										<i class="fa fa-envelope"></i>
									</div>
									<form:input type="text" path="revisionNumber"
										class="form-control pull-righ" placeholder="Enter Revision Number"
										autofocus="true" required="required"></form:input>
								</div>
								<form:errors class="help-block" path="revisionNumber"></form:errors>
							</div>
						</spring:bind>
						<spring:bind path="envLogUrl">
							<div
								class="form-group has-feedback ${status.error ? 'has-error' : ''}">
								<label for="envLogUrl"><spring:message code="label.environment.form.log.location" /></label>
								<div class="input-group">
									<div class="input-group-addon">
										<i class="fa fa-envelope"></i>
									</div>
									<form:input type="text" path="envLogUrl"
										class="form-control pull-righ"
										placeholder="Log Machine Url..." autofocus="true"
										required="required"></form:input>
								</div>
								<form:errors class="help-block" path="envLogUrl"></form:errors>
							</div>
						</spring:bind>
						<spring:bind path="envLogUser">
							<div
								class="form-group has-feedback ${status.error ? 'has-error' : ''}">
								<label for="envLogUser"><spring:message code="label.environment.form.log.user" /></label>
								<div class="input-group">
									<div class="input-group-addon">
										<i class="fa fa-envelope"></i>
									</div>
									<form:input type="text" path="envLogUser"
										class="form-control pull-righ" placeholder="WinScp User Name"
										autofocus="true" required="required"></form:input>
								</div>
								<form:errors class="help-block" path="envLogUser"></form:errors>
							</div>
						</spring:bind>
						<spring:bind path="envLogPass">
							<div
								class="form-group has-feedback ${status.error ? 'has-error' : ''}">
								<label for="envLogPass"><spring:message code="label.environment.form.log.password" /></label>
								<div class="input-group">
									<div class="input-group-addon">
										<i class="fa fa-envelope"></i>
									</div>
									<form:input type="text" path="envLogPass"
										class="form-control pull-righ" placeholder="WinScp Password"
										autofocus="true" required="required"></form:input>
								</div>
								<form:errors class="help-block" path="envLogPass"></form:errors>
							</div>
						</spring:bind>
						<spring:bind path="envLog">
							<div
								class="form-group has-feedback ${status.error ? 'has-error' : ''}">
								<label for="envLogPath"><spring:message code="label.environment.form.application.log.path" /></label>
								<div class="input-group">
									<div class="input-group-addon">
										<i class="fa fa-envelope"></i>
									</div>
									<form:input type="text" path="envLog"
										class="form-control pull-righ"
										placeholder="Application Logs location..." autofocus="true"
										required="required"></form:input>
								</div>
								<form:errors class="help-block" path="envLog"></form:errors>
							</div>
						</spring:bind>
						<spring:bind path="envWar">
							<div
								class="form-group has-feedback ${status.error ? 'has-error' : ''}">
								<label for="envLogPass"><spring:message code="label.environment.form.war.path" /></label>
								<div class="input-group">
									<div class="input-group-addon">
										<i class="fa fa-envelope"></i>
									</div>
									<form:input type="text" path="envWar"
										class="form-control pull-righ" placeholder="Logs location..."
										autofocus="true" required="required"></form:input>
								</div>
								<form:errors class="help-block" path="envWar"></form:errors>
							</div>
						</spring:bind>
						<spring:bind path="envServerLog">
							<div
								class="form-group has-feedback ${status.error ? 'has-error' : ''}">
								<label for="envServerLog"><spring:message code="label.environment.form.server.log.path" /></label>
								<div class="input-group">
									<div class="input-group-addon">
										<i class="fa fa-envelope"></i>
									</div>
									<form:input type="text" path="envServerLog"
										class="form-control pull-righ"
										placeholder="Server log location..." autofocus="true"
										required="required"></form:input>
								</div>
								<form:errors class="help-block" path="envServerLog"></form:errors>
							</div>
						</spring:bind>
						<spring:bind path="dbUrl">
							<div
								class="form-group has-feedback ${status.error ? 'has-error' : ''}">
								<label for="dbLocation"><spring:message code="label.environment.form.database.location" /></label>
								<div class="input-group">
									<div class="input-group-addon">
										<i class="fa fa-envelope"></i>
									</div>
									<form:input type="text" path="dbUrl"
										class="form-control pull-righ"
										placeholder="DB Server location..." autofocus="true"
										required="required"></form:input>
								</div>
								<form:errors class="help-block" path="dbUrl"></form:errors>
							</div>
						</spring:bind>
						<spring:bind path="dbUser">
							<div
								class="form-group has-feedback ${status.error ? 'has-error' : ''}">
								<label for="dbUser"><spring:message code="label.environment.form.database.user" /></label>
								<div class="input-group">
									<div class="input-group-addon">
										<i class="fa fa-envelope"></i>
									</div>
									<form:input type="text" path="dbUser"
										class="form-control pull-righ" placeholder="DB User..."
										autofocus="true" required="required"></form:input>
								</div>
								<form:errors class="help-block" path="dbUser"></form:errors>
							</div>
						</spring:bind>
						<spring:bind path="dbPass">
							<div
								class="form-group has-feedback ${status.error ? 'has-error' : ''}">
								<label for="dbPass"><spring:message code="label.environment.form.database.password" /></label>
								<div class="input-group">
									<div class="input-group-addon">
										<i class="fa fa-envelope"></i>
									</div>
									<form:input type="text" path="dbPass"
										class="form-control pull-righ" placeholder="DB Password..."
										autofocus="true" required="required"></form:input>
								</div>
								<form:errors class="help-block" path="dbPass"></form:errors>
							</div>
						</spring:bind>
						<spring:bind path="dbSchema">
							<div
								class="form-group has-feedback ${status.error ? 'has-error' : ''}">
								<label for="dbSchema"><spring:message code="label.environment.form.database.schema" /></label>
								<div class="input-group">
									<div class="input-group-addon">
										<i class="fa fa-envelope"></i>
									</div>
									<form:input type="text" path="dbSchema"
										class="form-control pull-righ" placeholder="DB Schema..."
										autofocus="true" required="required"></form:input>
								</div>
								<form:errors class="help-block" path="dbSchema"></form:errors>
							</div>
						</spring:bind>
						<spring:bind path="intergrationEnvironmentDTOs">
							<div
								class="form-group has-feedback ${status.error ? 'has-error' : ''}">
								<label for="roles"><spring:message code="label.menu.environment" /></label>
								<div class="input-group">
									<div class="input-group-addon">
										<i class="fa fa-user"></i>
									</div>
									<form:select path="intergrationEnvironmentDTOs" multiple="true" items="${INT_ENV}"
										itemLabel="envName" itemValue="id" id="intergrationEnvironmentDTOs"
										class="form-control select2 pull-righ" />
								</div>
								<form:errors class="help-block" path="intergrationEnvironmentDTOs"></form:errors>
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
		$('#groupId').select2();
		$('#intergrationEnvironmentDTOs').select2();
	});
	$('#environmentForm').submit(function(e) {
		// this code prevents form from actually being submitted
		e.preventDefault();
		submitEnvironmentForm();
	});
</script>