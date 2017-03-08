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
		<li>Environment</li>
		<li class="active">Details</li>
	</ol>
</section>

<!-- Main content -->
<section id="main-container" class="content">
	<div class="row">
		<div class="col-md-3 col-sm-6 col-xs-12">
			<div class="info-box bg-green">
				<span class="info-box-icon"><i class="fa fa-thumbs-o-up"></i></span>

				<div class="info-box-content">
					<span class="info-box-text">Up Time</span>
					<!-- <span class="info-box-number">41,410</span> -->

					<div class="progress">
						<div class="progress-bar" style="width: 70%"></div>
					</div>
					<span class="progress-description"> 70% Increase in 30 Days
					</span>
				</div>
				<!-- /.info-box-content -->
			</div>
			<!-- /.info-box -->
		</div>
		<!-- /.col -->
		<div class="col-md-3 col-sm-6 col-xs-12">
			<div class="info-box bg-red">
				<span class="info-box-icon"><i class="fa  fa-thumbs-o-down"></i></span>

				<div class="info-box-content">
					<span class="info-box-text">Down Time</span>
					<!-- <span class="info-box-number">41,410</span> -->

					<div class="progress">
						<div class="progress-bar" style="width: 70%"></div>
					</div>
					<span class="progress-description"> 70% Increase in 30 Days
					</span>
				</div>
				<!-- /.info-box-content -->
			</div>
			<!-- /.info-box -->
		</div>
		<!-- /.col -->
		<div class="col-md-3 col-sm-6 col-xs-12">
			<div class="info-box bg-yellow">
				<span class="info-box-icon"><i class="fa fa-calendar"></i></span>

				<div class="info-box-content">
					<span class="info-box-text">Integration Status</span> <span
						class="info-box-number">41,410</span>

					<div class="progress">
						<div class="progress-bar" style="width: 70%"></div>
					</div>
					<span class="progress-description"> 70% Increase in 30 Days
					</span>
				</div>
				<!-- /.info-box-content -->
			</div>
			<!-- /.info-box -->
		</div>
		<!-- /.col -->
		<div class="col-md-3 col-sm-6 col-xs-12">
			<div class="info-box bg-aqua">
				<span class="info-box-icon"><i class="fa fa-comments-o"></i></span>

				<div class="info-box-content">
					<span class="info-box-text">Status</span> <span
						class="info-box-number">41,410</span>

					<div class="progress">
						<div class="progress-bar" style="width: 70%"></div>
					</div>
					<span class="progress-description"> 70% Increase in 30 Days
					</span>
				</div>
				<!-- /.info-box-content -->
			</div>
			<!-- /.info-box -->
		</div>
		<!-- /.col -->
	</div>
	<div class="row">
		<div class="col-md-12">

			<!-- Main Box -->
			<div class="box box-skin">
				<div class="box-body box-profile">
					<h3 class="profile-username text-center">${environment.envName }&nbsp;<small>${environment.environmentType }</small>
					</h3>
					<ul class="list-group list-group-unbordered">
						<li class="list-group-item"><b>Envirironment Type</b> <a
							class="pull-right">${environment.environmentType}</a></li>
						<li class="list-group-item"><b>Environment Url</b> <a
							class="pull-right">${environment.envUrl }</a></li>
						<li class="list-group-item"><b>Revision Number</b> <a
							class="pull-right">${environment.revisionNumber}</a></li>
						<li class="list-group-item"><b>Status</b> <a
							class="pull-right"><span class="label label-success" id="environment_status_${environment.id}">Running</span></a></li>
					</ul>
					<a href="#" class="btn btn-skin btn-block"
						onclick="showEnvironmentDetails('${environment.id}')"><b>Refresh</b></a>
				</div>
				<!-- /.box-body -->
			</div>
			<!-- /.box -->
			<!-- Remote Machine detail box -->
			<div class="box box-skin">
				<div class="box-header with-border">
					<h3 class="box-title">Remote Machine Details</h3>
					<div class="box-tools pull-right">
						<button type="button" class="btn btn-box-tool"
							data-widget="collapse">
							<i class="fa fa-minus"></i>
						</button>
						<button type="button" class="btn btn-box-tool"
							data-widget="remove">
							<i class="fa fa-times"></i>
						</button>
					</div>
				</div>
				<div class="box-body box-profile">
					<ul class="list-group list-group-unbordered">
						<li class="list-group-item"><b>Machine URL</b> <a
							class="pull-right">${environment.envLogUrl}</a></li>
						<li class="list-group-item"><b>User Name</b> <a
							class="pull-right">${environment.envLogUser }</a></li>
						<li class="list-group-item"><b>Password</b> <a
							class="pull-right">${environment.envLogPass}</a></li>
						<li class="list-group-item"><b>Application Log Location</b> <a
							class="pull-right">${environment.envLog}</a></li>
						<li class="list-group-item"><b>Server Logs</b> <a
							class="pull-right">${environment.envServerLog}</a></li>
						<li class="list-group-item"><b>Revision Number</b> <a
							class="pull-right">${environment.envWar}</a></li>
					</ul>
				</div>
				<!-- /.box-body -->
			</div>
			<!-- /.box -->
			
			<!-- DB Details Box -->
			<div class="box box-skin">
				<div class="box-header with-border">
					<h3 class="box-title">DataBase Details</h3>
					<div class="box-tools pull-right">
						<button type="button" class="btn btn-box-tool"
							data-widget="collapse">
							<i class="fa fa-minus"></i>
						</button>
						<button type="button" class="btn btn-box-tool"
							data-widget="remove">
							<i class="fa fa-times"></i>
						</button>
					</div>
				</div>
				<div class="box-body box-profile">
					<ul class="list-group list-group-unbordered">
						<li class="list-group-item"><b>DB Location</b> <a
							class="pull-right">${environment.dbUrl}</a></li>
						<li class="list-group-item"><b>User Name</b> <a
							class="pull-right">${environment.dbUser }</a></li>
						<li class="list-group-item"><b>Password</b> <a
							class="pull-right">${environment.dbPass}</a></li>
						<li class="list-group-item"><b>Schema</b> <a
							class="pull-right">${environment.dbSchema}</a></li>
					</ul>
				</div>
				<!-- /.box-body -->
			</div>
			<!-- /.box -->

			<!-- About Me Box -->
			<div class="box box-skin">
				<div class="box-header with-border">
					<h3 class="box-title">Integration Details</h3>
					<div class="box-tools pull-right">
						<button type="button" class="btn btn-box-tool"
							data-widget="collapse">
							<i class="fa fa-minus"></i>
						</button>
						<button type="button" class="btn btn-box-tool"
							data-widget="remove">
							<i class="fa fa-times"></i>
						</button>
					</div>
				</div>
				<!-- /.box-header -->
				<div class="box-body">
					<table id="integrationEnvironmentDataTable"
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
							<c:forEach items="${environment.integrationEnvironments}" var="integrationEnvironments">
								<tr>
									<td>${integrationEnvironments.environmentType}</td>
									<td>${integrationEnvironments.envName}</td>
									<td>${integrationEnvironments.revisionNumber}</td>
									<td><span class="label label-success" id="environment_status_${integrationEnvironments.id}">Running</span></td>
									<td><div class="btn-group">
											<button type="button" class="btn btn-default btn-sm"
												onclick="createOrEditEnvironment('${integrationEnvironments.id}')">
												<i class="fa fa-edit"></i>
											</button>
											<button type="button" class="btn btn-default btn-sm"
												onclick="showEnvironmentDetails('${integrationEnvironments.id}')">
												<i class="fa fa-binoculars"></i>
											</button>
											<button type="button" class="btn btn-default btn-sm"
												onclick="showEnvironmentSettings('${integrationEnvironments.id}')">
												<i class="fa fa-gear"></i>
											</button>
											<button type="button" class="btn btn-default btn-sm"
												onclick="shareEnvironmentDetails('${integrationEnvironments.id}')">
												<i class="fa  fa-share-alt"></i>
											</button>
											<button type="button" class="btn btn-default btn-sm" onclick="deleteEnvironment('${integrationEnvironments.id}')">
												<i class="fa  fa-trash-o"></i>
											</button>
											<button type="button" class="btn btn-default btn-sm" onclick="window.open('${integrationEnvironments.envUrl }')">
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
				<!-- /.box-body -->
			</div>
			<!-- /.box -->
		</div>
	</div>
</section>
<script>
	console.debug('Dashboard page loaded.');
	$(document).ready(function() {
		$('#integrationEnvironmentDataTable').DataTable();
		FetchData();
		setInterval(FetchData, 60000);
	});
</script>