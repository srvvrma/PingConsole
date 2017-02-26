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
		<li>Environment</li>
		<li class="active">create-update</li>
	</ol>
</section>
<section class="content">
	<div class="row">
		<div class="col-md-12">
			<!-- Horizontal Form -->
			<div class="box box-info">
				<div class="box-header with-border">
					<h3 class="box-title">Environment Form :</h3>
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
									value="CAS" required="required" /> CAS
							</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<label> <form:radiobutton path="environmentType"
									value="LMS" required="required" /> LMS
							</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<label> <form:radiobutton path="environmentType"
									value="INTEGRATION" required="required" /> INTEGRATION
							</label>
						</div>
						<input type="hidden" path="id"
							value="${environmentDTO.id}" />
						<spring:bind path="envName">
							<div
								class="form-group has-feedback ${status.error ? 'has-error' : ''}">
								<label for="exampleInputEmail1">Environment Name</label>
								<div class="input-group">
									<div class="input-group-addon">
										<i class="fa fa-user"></i>
									</div>
									<form:input type="text" path="envName"
										class="form-control pull-righ" placeholder="Environment Name"
										autofocus="true" required="required"></form:input>
								</div>
								<form:errors class="help-block" path="envName"></form:errors>
							</div>
						</spring:bind>
						<spring:bind path="envUrl">
							<div
								class="form-group has-feedback ${status.error ? 'has-error' : ''}">
								<label for="exampleInputEmail1">Environment Url</label>
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
						<spring:bind path="revisionNumber">
							<div
								class="form-group has-feedback ${status.error ? 'has-error' : ''}">
								<label for="revisionNumber">Revision Number</label>
								<div class="input-group">
									<div class="input-group-addon">
										<i class="fa fa-envelope"></i>
									</div>
									<form:input type="text" path="revisionNumber"
										class="form-control pull-righ" placeholder="Revision Number"
										autofocus="true" required="required"></form:input>
								</div>
								<form:errors class="help-block" path="revisionNumber"></form:errors>
							</div>
						</spring:bind>
						<spring:bind path="envLogUrl">
							<div
								class="form-group has-feedback ${status.error ? 'has-error' : ''}">
								<label for="envLogUrl">Logs Location</label>
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
								<label for="envLogUser">WinScp User Name</label>
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
								<label for="envLogPass">WinScp User Name</label>
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
								<label for="envLog">Logs Location</label>
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
								<label for="envLogPass">WAR Location</label>
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
								<label for="envServerLog">Server Logs Location</label>
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
								<label for="dbUrl">DB Location</label>
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
								<label for="dbUser">DB Location</label>
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
								<label for="dbPass">DB Location</label>
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
								<label for="dbSchema">DB Location</label>
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
	$('#environmentForm').submit(function(e) {
		// this code prevents form from actually being submitted
		e.preventDefault();
		submitEnvironmentForm();
	});
</script>