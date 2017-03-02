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
					<table id="roleDataTable"
						class="table table-bordered table-striped">
						<thead>
							<tr>
								<th>Role Name</th>
								<th>Role Code</th>
								<th>Description</th>
								<th>Options</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${roleDTOs}" var="roleDTO">
								<tr>
									<td>${roleDTO.name }</td>
									<td>${roleDTO.code }</td>
									<td>${roleDTO.name }</td>
									<td><div class="btn-group">
											<button type="button" class="btn btn-default btn-sm"
												onclick="createOrUpdate('${roleDTO.id}')">
												<i class="fa fa-edit"></i>
											</button>
											<button type="button" class="btn btn-default btn-sm">
												<i class="fa fa-unlock-alt"></i>
											</button>
											<button type="button" class="btn btn-default btn-sm">
												<i class="fa  fa-trash-o"></i>
											</button>
										</div></td>
								</tr>
							</c:forEach>
						</tbody>
						<tfoot>
							<tr>
								<th>Role Name</th>
								<th>Role Code</th>
								<th>Description</th>
								<th>Options</th>
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
	console.debug('Roles page loaded.');
	$(document).ready(function() {

		$('#roleDataTable').DataTable();
	});
</script>

