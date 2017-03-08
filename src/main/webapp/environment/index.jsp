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
		<li class="active"><spring:message code="label.environment" /></li>
	</ol>
</section>

<!-- Main content -->
<section id="main-container" class="content">
	<div class="row">
		<div class="col-xs-12">
			<div class="box box-skin">
				<div class="box-header">
					<h3 class="box-title"><spring:message code="label.environment.index.header" /></h3>
					<!-- <a class="btn btn-skin btn-sm btn-social pull-right">
                		<i class="fa fa-user-plus"></i> Add New Role
              		</a> -->
				</div>
				<!-- /.box-header -->
				<div class="box-body">
					<table id="environmentDataTable"
						class="table table-bordered table-striped">
						<thead>
							<tr>
								<th><spring:message code="label.environment.type" /></th>
								<th><spring:message code="label.environment.name" /></th>
								<th><spring:message code="label.environment.revision.number" /></th>
								<th><spring:message code="label.environment.status" /></th>
								<th><spring:message code="label.environment.options" /></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${environments}" var="environment">
								<tr>
									<td>${environment.environmentType}</td>
									<td>${environment.envName}</td>
									<td>${environment.revisionNumber}</td>
									<td><span class="label label-success" id="environment_status_${environment.id}">Running</span></td>
									<td><div class="btn-group">
											<button type="button" class="btn btn-default btn-sm"
												onclick="createOrEditEnvironment('${environment.id}')">
												<i class="fa fa-edit"></i>
											</button>
											<button type="button" class="btn btn-default btn-sm"
												onclick="showEnvironmentDetails('${environment.id}')">
												<i class="fa fa-binoculars"></i>
											</button>
											<button type="button" class="btn btn-default btn-sm"
												onclick="showEnvironmentSettings('${environment.id}')">
												<i class="fa fa-gear"></i>
											</button>
											<button type="button" class="btn btn-default btn-sm"
												onclick="shareEnvironmentDetails('${environment.id}')">
												<i class="fa  fa-share-alt"></i>
											</button>
											<button type="button" class="btn btn-default btn-sm" onclick="deleteEnvironment('${environment.id}')">
												<i class="fa  fa-trash-o"></i>
											</button>
											<button type="button" class="btn btn-default btn-sm" onclick="window.open('${environment.envUrl }')">
																<i class="fa  fa-external-link"></i>&nbsp;&nbsp;<spring:message code="label.open" />
															</button>
										</div></td>
								</tr>
							</c:forEach>
						</tbody>
						<tfoot>
							<tr>
								<th><spring:message code="label.environment.type" /></th>
								<th><spring:message code="label.environment.name" /></th>
								<th><spring:message code="label.environment.revision.number" /></th>
								<th><spring:message code="label.environment.status" /></th>
								<th><spring:message code="label.environment.options" /></th>
							</tr>
						</tfoot>
					</table>
				</div>
			</div>
		</div>
	</div>
</section>
<!-- /.content -->
<script>
	console.debug('Environment page loaded.');
	$(document).ready(function() {
		$('#environmentDataTable').DataTable();
		FetchData();
		setInterval(FetchData, 60000);
	});
</script>

