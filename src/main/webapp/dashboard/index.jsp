<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- Content Header (Page header) -->
<section class="content-header" id="main-breadcrumb">
	<h1>
		PingConsole<small>v1.0.0</small>
	</h1>
	<ol class="breadcrumb">
		<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
		<li class="active">Console</li>
	</ol>
</section>

<!-- Main content -->
<section id="main-container" class="content">

	<div class="row">
		<div class="col-lg-3 col-xs-6">
			<!-- small box -->
			<div class="small-box bg-aqua">
				<div class="inner">
					<h3>150</h3>

					<p>New Orders</p>
				</div>
				<div class="icon">
					<i class="ion ion-bag"></i>
				</div>
				<a href="#" class="small-box-footer">More info <i
					class="fa fa-arrow-circle-right"></i></a>
			</div>
		</div>
		<!-- ./col -->
		<div class="col-lg-3 col-xs-6">
			<!-- small box -->
			<div class="small-box bg-green">
				<div class="inner">
					<h3>
						53<sup style="font-size: 20px">%</sup>
					</h3>

					<p>Bounce Rate</p>
				</div>
				<div class="icon">
					<i class="ion ion-stats-bars"></i>
				</div>
				<a href="#" class="small-box-footer">More info <i
					class="fa fa-arrow-circle-right"></i></a>
			</div>
		</div>
		<!-- ./col -->
		<div class="col-lg-3 col-xs-6">
			<!-- small box -->
			<div class="small-box bg-yellow">
				<div class="inner">
					<h3>44</h3>

					<p>User Registrations</p>
				</div>
				<div class="icon">
					<i class="ion ion-person-add"></i>
				</div>
				<a href="#" class="small-box-footer">More info <i
					class="fa fa-arrow-circle-right"></i></a>
			</div>
		</div>
		<!-- ./col -->
		<div class="col-lg-3 col-xs-6">
			<!-- small box -->
			<div class="small-box bg-red">
				<div class="inner">
					<h3>65</h3>

					<p>Unique Visitors</p>
				</div>
				<div class="icon">
					<i class="ion ion-pie-graph"></i>
				</div>
				<a href="#" class="small-box-footer">More info <i
					class="fa fa-arrow-circle-right"></i></a>
			</div>
		</div>
		<!-- ./col -->
	</div>







	<div class="row">
		<div class="col-md-12">
			<div class="box box-skin">
				<div class="box-header with-border">
					<h3 class="box-title">Monthly Recap Report</h3>

					<div class="box-tools pull-right">
						<button type="button" class="btn btn-box-tool"
							data-widget="collapse">
							<i class="fa fa-minus"></i>
						</button>
						<div class="btn-group">
							<button type="button" class="btn btn-box-tool dropdown-toggle"
								data-toggle="dropdown">
								<i class="fa fa-wrench"></i>
							</button>
							<ul class="dropdown-menu" role="menu">
								<li><a href="#">Action</a></li>
								<li><a href="#">Another action</a></li>
								<li><a href="#">Something else here</a></li>
								<li class="divider"></li>
								<li><a href="#">Separated link</a></li>
							</ul>
						</div>
						<button type="button" class="btn btn-box-tool"
							data-widget="remove">
							<i class="fa fa-times"></i>
						</button>
					</div>
				</div>
				<!-- /.box-header -->
				<div class="box-body">
					<div class="row">
						<div class="col-md-8">
							<p class="text-center">
								<strong>Sales: 1 Jan, 2014 - 30 Jul, 2014</strong>
							</p>

							<div class="chart">
								<!-- Sales Chart Canvas -->
								<canvas id="salesChart" style="height: 180px; width: 1072px;"
									height="180" width="1072"></canvas>
							</div>
							<!-- /.chart-responsive -->
						</div>
						<!-- /.col -->
						<div class="col-md-4">
							<p class="text-center">
								<strong>Goal Completion</strong>
							</p>

							<div class="progress-group">
								<span class="progress-text">Add Products to Cart</span> <span
									class="progress-number"><b>160</b>/200</span>

								<div class="progress sm">
									<div class="progress-bar progress-bar-aqua" style="width: 80%"></div>
								</div>
							</div>
							<!-- /.progress-group -->
							<div class="progress-group">
								<span class="progress-text">Complete Purchase</span> <span
									class="progress-number"><b>310</b>/400</span>

								<div class="progress sm">
									<div class="progress-bar progress-bar-red" style="width: 80%"></div>
								</div>
							</div>
							<!-- /.progress-group -->
							<div class="progress-group">
								<span class="progress-text">Visit Premium Page</span> <span
									class="progress-number"><b>480</b>/800</span>

								<div class="progress sm">
									<div class="progress-bar progress-bar-green" style="width: 80%"></div>
								</div>
							</div>
							<!-- /.progress-group -->
							<div class="progress-group">
								<span class="progress-text">Send Inquiries</span> <span
									class="progress-number"><b>250</b>/500</span>

								<div class="progress sm">
									<div class="progress-bar progress-bar-yellow"
										style="width: 80%"></div>
								</div>
							</div>
							<!-- /.progress-group -->
						</div>
						<!-- /.col -->
					</div>
					<!-- /.row -->
				</div>
				<!-- ./box-body -->
				<div class="box-footer">
					<div class="row">
						<div class="col-sm-3 col-xs-6">
							<div class="description-block border-right">
								<span class="description-percentage text-green"><i
									class="fa fa-caret-up"></i> 17%</span>
								<h5 class="description-header">$35,210.43</h5>
								<span class="description-text">TOTAL REVENUE</span>
							</div>
							<!-- /.description-block -->
						</div>
						<!-- /.col -->
						<div class="col-sm-3 col-xs-6">
							<div class="description-block border-right">
								<span class="description-percentage text-yellow"><i
									class="fa fa-caret-left"></i> 0%</span>
								<h5 class="description-header">$10,390.90</h5>
								<span class="description-text">TOTAL COST</span>
							</div>
							<!-- /.description-block -->
						</div>
						<!-- /.col -->
						<div class="col-sm-3 col-xs-6">
							<div class="description-block border-right">
								<span class="description-percentage text-green"><i
									class="fa fa-caret-up"></i> 20%</span>
								<h5 class="description-header">$24,813.53</h5>
								<span class="description-text">TOTAL PROFIT</span>
							</div>
							<!-- /.description-block -->
						</div>
						<!-- /.col -->
						<div class="col-sm-3 col-xs-6">
							<div class="description-block">
								<span class="description-percentage text-red"><i
									class="fa fa-caret-down"></i> 18%</span>
								<h5 class="description-header">1200</h5>
								<span class="description-text">GOAL COMPLETIONS</span>
							</div>
							<!-- /.description-block -->
						</div>
					</div>
					<!-- /.row -->
				</div>
				<!-- /.box-footer -->
			</div>
			<!-- /.box -->
		</div>
		<!-- /.col -->
	</div>














	<div class="row">
		<div class="col-md-12">
			<!-- Custom Tabs -->
			<div class="nav-tabs-custom">
				<ul id="groupEnvTab" class="nav nav-tabs">
					<c:forEach items="${groupList}" var="group">
						<li class=""><a href="#tab_${group.id }" data-toggle="tab"
							aria-expanded="false">${group.name }</a></li>
					</c:forEach>
					<li class="pull-right"><a href="#" class="text-muted"><i
							class="fa fa-gear"></i></a></li>
					<li class="dropdown pull-right"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#" aria-expanded="false">
							Dropdown <span class="caret"></span>
					</a>
						<ul class="dropdown-menu">
							<li role="presentation"><a role="menuitem" tabindex="-1"
								href="#">Action</a></li>
							<li role="presentation"><a role="menuitem" tabindex="-1"
								href="#">Another action</a></li>
							<li role="presentation"><a role="menuitem" tabindex="-1"
								href="#">Something else here</a></li>
							<li role="presentation" class="divider"></li>
							<li role="presentation"><a role="menuitem" tabindex="-1"
								href="#">Separated link</a></li>
						</ul></li>
				</ul>
				<div class="tab-content">
					<c:forEach items="${groupList}" var="group">
						<!-- .tab-pane -->
						<div class="tab-pane" id="tab_${group.id}">
							<div class="row">
								<div class="col-xs-12">
									<table id="envDataTable_${group.id}"
										class="table table-bordered table-striped">
										<thead>
											<tr>
												<th>Role Name</th>
												<th>Role Code</th>
												<th>Description</th>
												<th>Status</th>
												<th>Options</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${group.environmentList}" var="environment">
												<tr>
													<td>${environment.envName }</td>
													<td>${environment.id }</td>
													<td>${environment.envName }</td>
													<td><span class="label label-success">Running</span></td>
													<td><div class="btn-group">
															<button type="button" class="btn btn-default btn-sm"
																onclick="createOrEditEnvironment('${environment.id}')">
																<i class="fa fa-edit"></i>
															</button>
															<button type="button" class="btn btn-default btn-sm" onclick="showEnvironmentDetails('${environment.id}');">
																<i class="fa fa-binoculars"></i>
															</button>
															<button type="button" class="btn btn-default btn-sm">
																<i class="fa fa-share-alt"></i>
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
												<th>Role Name</th>
												<th>Role Code</th>
												<th>Description</th>
												<th>Status</th>
												<th>Options</th>
											</tr>
										</tfoot>
									</table>

								</div>
							</div>
						</div>
						<!-- /.tab-pane -->
					</c:forEach>
				</div>
				<!-- /.tab-content -->
			</div>
			<!-- nav-tabs-custom -->
		</div>
		<!-- /.col -->
	</div>


</section>
<!-- /.content -->

<script>
	console.debug('Dashboard page loaded.');
	$(document).ready(function() {
		<c:forEach items="${groupList}" var="group">
			$('#envDataTable_${group.id}').DataTable();
		</c:forEach>
		$('#groupEnvTab a:first').tab('show');
	});
</script>
