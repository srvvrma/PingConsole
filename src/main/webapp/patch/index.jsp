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
		<li>Patch</li>
		<li class="active">Create</li>
	</ol>
</section>
<section class="content">
	<div class="row">
		<div class="col-xs-12">
			<div class="box box-skin">
				<div class="box-header">
					<div class="pull-left">
						<h3 class="box-title">DNS Lookup</h3>
					</div>
					<div class="pull-right">
						<button onclick="getBuildDetails();" id="getEnvDetails"
							class="btn btn-skin btn-block" type="button">Create
							Patch</button>
					</div>
				</div>
				<!-- /.box-header -->
				<div class="box-body">
					<form method="post" class="form-horizontal style-form"
						action="${baseUrl}/patch/generatePatch">
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
						<div class="form-group">
							<div class="col-sm-4">
								<input type="text" value="" class="form-control"
									placeholder="Revision Number Eg:1234,1235,... or 1223-3212"
									name="revisionNumber" id="revisionNumber">
							</div>
							<div class="col-sm-4">
								<input type="text" value="" class="form-control"
									placeholder="JIRA issue ID" name="jiraId" id="jiraId">
							</div>
							<div class="col-sm-4">
								<button onclick="fetchDataFromSVN();" id="fetchData"
									class="btn btn-skin btn-block" type="button">Fetch
									Data</button>
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-12">
								<textarea class="form-control"
									style="min-width: 100%; min-height: 400px;" id="patchPath"
									name="patchPath" placeholder="Enter Path................"></textarea>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-0"></label>
							<div class="col-sm-12">
								<button id="addButton"
									class="btn btn-skin btn-block" type="submit">Create
									Patch</button>
							</div>
						</div>

					</form>
				</div>
			</div>
		</div>
	</div>
</section>