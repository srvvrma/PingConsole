<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- Content Header (Role index Page header) -->
<section class="content-header" id="main-breadcrumb">
	<h1>
		neoPing <small>Console</small>
	</h1>
	<ol class="breadcrumb">
		<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
		<li>Users</li>
		<li class="active">edit</li>
	</ol>
</section>
<section class="content">
	<div class="row">
		<div class="col-md-12">
			<!-- Horizontal Form -->
			<div class="box box-info">
				<div class="box-header with-border">
					<h3 class="box-title">Edit User Form</h3>
				</div>
				<!-- /.box-header -->
				<!-- form start -->
				<form:form method="POST" modelAttribute="userDTO"
					class="form-signin">
					<div class="box-body">
						<spring:bind path="userName">
							<div
								class="form-group has-feedback ${status.error ? 'has-error' : ''}">
								<label for="exampleInputEmail1">User Full Name</label>
								<div class="input-group">
									<div class="input-group-addon">
										<i class="fa fa-user"></i>
									</div>
									<form:input type="text" path="userName"
										class="form-control pull-righ" placeholder="Username"
										autofocus="true"></form:input>
									<form:errors path="userName"></form:errors>
								</div>
							</div>
						</spring:bind>
						<spring:bind path="userId">
							<div
								class="form-group has-feedback ${status.error ? 'has-error' : ''}">
								<label for="exampleInputEmail1">User Id</label>
								<div class="input-group">
									<div class="input-group-addon">
										<i class="fa fa-user"></i>
									</div>
									<form:input type="text" path="userId"
										class="form-control pull-righ" placeholder="User Id"
										autofocus="true"></form:input>
									<form:errors path="userId"></form:errors>
								</div>
							</div>
						</spring:bind>
						<spring:bind path="email">
							<div
								class="form-group has-feedback ${status.error ? 'has-error' : ''}">
								<label for="exampleInputEmail1">Email address</label>
								<div class="input-group">
									<div class="input-group-addon">
										<i class="fa fa-envelope"></i>
									</div>
									<form:input type="text" path="email"
										class="form-control pull-righ" placeholder="Username"
										autofocus="true"></form:input>
									<form:errors path="email"></form:errors>
								</div>
							</div>
						</spring:bind>
						<spring:bind path="dob">
							<div
								class="form-group has-feedback ${status.error ? 'has-error' : ''}">
								<label>Date:</label>

								<div class="input-group date">
									<div class="input-group-addon">
										<i class="fa fa-calendar"></i>
									</div>
									<form:input type="text" path="dob"
										class="form-control pull-right" placeholder="Dob"
										autofocus="true" id="datepicker"></form:input>
									<form:errors path="dob"></form:errors>
								</div>
								<!-- /.input group -->
							</div>
						</spring:bind>
					</div>
					<!-- /.box-body -->

					<div class="box-footer">
						<button type="reset" class="btn btn-default">Cancel</button>
						<button type="button" class="btn btn-info margin">Refresh</button>
						<button type="submit" class="btn btn-info pull-right margin">Sign
							in</button>
					</div>
				</form:form>
			</div>
			<!-- /.box-body -->
		</div>
		<!-- /.box -->
	</div>
</section>
<script>
	//Date picker
	$('#datepicker').datepicker({
		autoclose : true
	});
</script>