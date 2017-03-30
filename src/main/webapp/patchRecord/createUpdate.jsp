<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- Content Header (Role index Page header) -->
<section class="content-header" id="main-breadcrumb">
	<h1>
		<spring:message code="label.application.name" />
		<small><spring:message code="label.application.version" /></small>
	</h1>
	<ol class="breadcrumb">
		<li><a href="#"><i class="fa fa-dashboard"></i> <spring:message
					code="label.home" /></a></li>
		<li><spring:message code="label.menu.patchRecord" /></li>
		<li class="active"><spring:message
				code="label.menu.patchRecord.add" /></li>
	</ol>
</section>
<section class="content">
	<div class="row">
		<div class="col-md-12">
			<!-- Horizontal Form -->
			<div class="box box-info">
				<div class="box-header with-border">
					<h3 class="box-title">
						<spring:message code="label.patchRecord.form" />
						:
					</h3>
				</div>
				<!-- /.box-header -->
				<!-- form start -->
				<form:form id="patchRecordForm" method="POST"
					action="${contextPath}/patchRecord/createUpdate"
					modelAttribute="patchRecordDTO" class="form-signin">
					<form:input type="hidden" path="id"></form:input>
					<div class="box-body">
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" /> <input type="hidden" path="id"
							value="${patchRecordDTO.id}" />
						<spring:bind path="name">
							<div
								class="form-group has-feedback ${status.error ? 'has-error' : ''}">
								<label for="roleName"><spring:message
										code="label.patchRecord.name" /></label>
								<div class="input-group">
									<div class="input-group-addon">
										<i class="fa fa-user"></i>
									</div>
									<form:input type="text" path="name"
										class="form-control pull-righ"
										placeholder="Enter Patch Record Name" autofocus="true"
										required="required"></form:input>
								</div>
								<form:errors class="help-block" path="name"></form:errors>
							</div>
						</spring:bind>
						<spring:bind path="environment">
							<div
								class="form-group has-feedback ${status.error ? 'has-error' : ''}">
								<label for="privileges"><spring:message
										code="label.patchRecord.environment" /></label>
								<div class="input-group">
									<div class="input-group-addon">
										<i class="fa fa-user"></i>
									</div>
									<form:select path="environment" items="${environments}"
										itemLabel="envName" itemValue="id" id="environments"
										class="form-control select2 pull-righ" />
								</div>
								<form:errors class="help-block" path="environment"></form:errors>
							</div>
						</spring:bind>
						<spring:bind path="createDate">
							<div
								class="form-group has-feedback ${status.error ? 'has-error' : ''}">
								<label><spring:message
										code="label.patchRecord.createDate" /></label>

								<div class="input-group date">
									<div class="input-group-addon">
										<i class="fa fa-calendar"></i>
									</div>
									<form:input type="date" path="createDate"
										class="form-control pull-right" placeholder="Enter Patch Date"
										autofocus="true" id="createDate" required="required"></form:input>
								</div>
								<form:errors path="createDate"></form:errors>
								<!-- /.input group -->
							</div>
						</spring:bind>
						<spring:bind path="users">
							<div
								class="form-group has-feedback ${status.error ? 'has-error' : ''}">
								<label for="users"><spring:message
										code="label.patchRecord.users" /></label>
								<div class="input-group">
									<div class="input-group-addon">
										<i class="fa fa-user"></i>
									</div>
									<form:select path="users" items="${allUsers}"
										itemLabel="userName" itemValue="id" id="users"
										class="form-control select2 pull-righ" />
								</div>
								<form:errors class="help-block" path="users"></form:errors>
							</div>
						</spring:bind>
						<spring:bind path="jiraId">
							<div
								class="form-group has-feedback ${status.error ? 'has-error' : ''}">
								<label for="jiraId"><spring:message
										code="label.patchRecord.jiraId" /></label>
								<div class="input-group">
									<div class="input-group-addon">
										<i class="fa fa-user"></i>
									</div>
									<form:input type="text" path="jiraId"
										class="form-control pull-righ" placeholder="Enter JIRA Id"
										autofocus="true" required="required"></form:input>
								</div>
								<form:errors class="help-block" path="jiraId"></form:errors>
							</div>
						</spring:bind>
						<spring:bind path="description">
							<div
								class="form-group has-feedback ${status.error ? 'has-error' : ''}">
								<label for="description"><spring:message
										code="label.patchRecord.description" /></label>
								<div class="input-group">
									<div class="input-group-addon">
										<i class="fa fa-user"></i>
									</div>
									<form:input type="text" path="description"
										class="form-control pull-righ" placeholder="Enter Description"
										autofocus="true" required="required"></form:input>
								</div>
								<form:errors class="help-block" path="description"></form:errors>
							</div>
						</spring:bind>
						<spring:bind path="patchData">
							<div
								class="form-group has-feedback ${status.error ? 'has-error' : ''}">
								<label for="roleCode"><spring:message
										code="label.patchRecord.patchData" /></label>
								<div class="input-group">
									<div class="input-group-addon">
										<i class="fa fa-user"></i>
									</div>
									<form:textarea path="patchData" rows="10" class="form-control"
										id="jsondata" name="rawJson" style="resize: vertical;"></form:textarea>
								</div>
								<form:errors class="help-block" path="patchData"></form:errors>
							</div>
						</spring:bind>

					</div>
					<!-- /.box-body -->

					<div class="box-footer">
						<button type="reset" class="btn btn-default"
							onclick="loadAllPatchManager();">
							<spring:message code="label.cancel" />
						</button>
						<button type="button" class="btn btn-info margin" onclick="">
							<spring:message code="label.refresh" />
						</button>
						<button type="submit" class="btn btn-skin pull-right margin"
							onclick="">
							<spring:message code="label.save" />
						</button>
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
		//Date picker
		$('#createDate').datepicker({
			autoclose : true
		});
	});
	
</script>