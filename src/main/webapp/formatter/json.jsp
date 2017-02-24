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
		<li><a href="#"><i class="fa fa-dashboard"></i> Settings</a></li>
		<li class="active">Profile</li>
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
					<div class="row">
						<div class="col-xs-2"
							style="margin-top: 70px; text-align: center; display: block;">
							<i class="fa fa-mail-forward fa-5x"></i> <br> <br>
							<p>Paste in JSON.</p>
						</div>
						<div class="col-xs-8">
							<div class="form-group">
								<label for="exampleInputFile">JSON Data</label>
								<div class="jsondataholder">
									<textarea rows="8" class="form-control" id="jsondata"
										name="jsondata" style="resize: vertical;"></textarea>
									<div class="btn-group btn-group-sm">
										<button type="button" class="btn btn-link btn-clear btn-sm">
											<i class="fa fa-trash-o"></i>
										</button>
									</div>
								</div>
							</div>
						</div>
						<div class="col-xs-2">
							<!-- <div class="form-group">
								<label for="exampleInputFile">JSON Standard</label> <select
									class="form-control" id="jsonstandard" name="jsonstandard">
									<option value="1" selected="">RFC 4627</option>
									<option value="2">RFC 7159</option>
									<option value="3">ECMA-404</option>
									<option value="0">Do Not Validate</option>
								</select>
							</div> -->
						</div>
					</div>
					<div class="row">
						<div class="col-xs-8 col-md-offset-2 text-center">
							<button type="button" id="process"
								class="btn btn-action btn-lg btn-skin"
								data-loading-text="<i class='fa fa-cog fa-spin'></i>">Process</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="row">
	<div class="col-xs-12">
          <div class="box box-default">
            <div class="box-header with-border">
              <i class="fa fa-bullhorn"></i>
              <h3 class="box-title">Callouts</h3>
            </div>
            <!-- /.box-header -->
            <div class="box-body">
              
            <!-- /.box-body -->
          </div>
          <!-- /.box -->
        </div>
	</div>
</section>
<!-- /.content -->
<script>
	console.debug('Group page loaded.');
</script>

