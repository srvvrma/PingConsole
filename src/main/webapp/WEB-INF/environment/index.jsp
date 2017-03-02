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
		<li class="active">Roles</li>
	</ol>
</section>

<!-- Main content -->
<section id="main-container" class="content">
	<div class="row">
		<div class="col-xs-12">
			<div class="box box-skin">
				<div class="box-header">
					<h3 class="box-title">Roles Data Table</h3>
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
								<th>Type</th>
								<th>Environment Name</th>
								<th>Url</th>
								<th>Revision No.</th>
								<th>Status</th>
								<th>Option</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${environments}" var="environment">
								<tr>
									<td>${environment.environmentType}</td>
									<td>${environment.envName}</td>
									<td>${environment.envUrl}</td>
									<td><span class="label label-success">Running</span></td>
									<td>${environment.revisionNumber}</td>
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
																<i class="fa  fa-external-link"></i>&nbsp;&nbsp;Open
															</button>
										</div></td>
								</tr>
							</c:forEach>
						</tbody>
						<tfoot>
							<tr>
								<th>Type</th>
								<th>Environment Name</th>
								<th>Url</th>
								<th>Revision No.</th>
								<th>Status</th>
								<th>Option</th>
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
	});
</script>

