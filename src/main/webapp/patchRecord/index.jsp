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
		<li><spring:message code="label.menu.patchRecord" /></li><li class="active"><spring:message code="label.menu.patchRecord.all" /></li>
	</ol>
</section>

<!-- Main content -->
<section id="main-container" class="content">
	<div class="row">
		<div class="col-xs-12">
			<div class="box box-skin">
				<div class="box-header">
					<h3 class="box-title"><spring:message code="label.patchRecord.table.header" /></h3>
					<!-- <a class="btn btn-skin btn-sm btn-social pull-right">
                		<i class="fa fa-user-plus"></i> Add New Role
              		</a> -->
				</div>
				<!-- /.box-header -->
				<div class="box-body">
					<table id="patchManagerDataTable"
						class="table table-bordered table-striped">
						<thead>
							<tr>
								<th><spring:message code="label.patchRecord.name" /></th>
								<th><spring:message code="label.patchRecord.environment" /></th>
								<th><spring:message code="label.patchRecord.jiraId" /></th>
								<th><spring:message code="label.patchRecord.description" /></th>
								<th><spring:message code="label.patchManager.options" /></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${patchRecordDTOs}" var="patchRecordDTO">
								<tr>
									<td>${patchRecordDTO.name }</td>
									<td>${patchRecordDTO.environment }</td>
									<td><button type="button" class="btn btn-default btn-sm"
											onclick="window.open('${jiraUrl }${patchRecordDTO.jiraId }')">
											<i class="fa  fa-external-link"></i>&nbsp;&nbsp;${patchRecordDTO.jiraId }
										</button></td>
									<td>${patchRecordDTO.description }</td>
									<td><div class="btn-group">
											<button type="button" class="btn btn-default btn-sm"
												onclick="createOrUpdatePatchManager('${patchRecordDTO.id}')">
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
								<th><spring:message code="label.patchRecord.name" /></th>
								<th><spring:message code="label.patchRecord.environment" /></th>
								<th><spring:message code="label.patchRecord.jiraId" /></th>
								<th><spring:message code="label.patchRecord.description" /></th>
								<th><spring:message code="label.patchManager.options" /></th>
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
	console.debug('patchManagerDataTable page loaded.');
	$(document).ready(function() {

		$('#patchManagerDataTable').DataTable();
	});
</script>

