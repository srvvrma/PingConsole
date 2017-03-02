<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>AdminLTE 2 | Registration Page</title>
<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<!-- Bootstrap 3.3.6 -->
<link rel="stylesheet"
	href="${contextPath}/resources/bootstrap/css/bootstrap.min.css">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
<!-- Ionicons -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
<!-- Theme style -->
<link rel="stylesheet"
	href="${contextPath}/resources/dist/css/AdminLTE.min.css">
<!-- iCheck -->
<link rel="stylesheet"
	href="${contextPath}/resources/plugins/iCheck/square/blue.css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>
<body class="hold-transition register-page">
	<div class="register-box">
		<div class="register-logo">
			<a href="${contextPath}"><b>Ping</b>Console</a>
		</div>

		<div class="register-box-body">
			<p class="login-box-msg">Register a new membership</p>

			<form:form method="POST" modelAttribute="userForm"
				class="form-signin">
				<spring:bind path="username">
					<div
						class="form-group has-feedback ${status.error ? 'has-error' : ''}">
						<form:input type="text" path="username" class="form-control"
							placeholder="Username" autofocus="true"></form:input>
						<span class="glyphicon glyphicon-user form-control-feedback"></span>
						<form:errors path="username"></form:errors>
					</div>
				</spring:bind>
				<spring:bind path="fullName">
					<div
						class="form-group has-feedback ${status.error ? 'has-error' : ''}">
						<form:input type="text" path="fullName" class="form-control"
							placeholder="Enter Full Name" autofocus="true"></form:input>
						<span class="glyphicon glyphicon-user form-control-feedback"></span>
						<form:errors path="username"></form:errors>
					</div>
				</spring:bind>
				<spring:bind path="email">
					<div
						class="form-group has-feedback ${status.error ? 'has-error' : ''}">
						<form:input type="text" path="email" class="form-control"
							placeholder="Enter e-mail" autofocus="true"></form:input>
						<span class="glyphicon glyphicon-user form-control-feedback"></span>
						<form:errors path="email"></form:errors>
					</div>
				</spring:bind>
				<spring:bind path="password">
					<div
						class="form-group has-feedback ${status.error ? 'has-error' : ''}">
						<form:input type="password" path="password" class="form-control"
							placeholder="Password"></form:input>
						<span class="glyphicon glyphicon-lock form-control-feedback"></span>
						<form:errors path="password"></form:errors>
					</div>
				</spring:bind>
				<spring:bind path="passwordConfirm">
					<div
						class="form-group has-feedback ${status.error ? 'has-error' : ''}">
						<form:input type="password" path="passwordConfirm"
							class="form-control" placeholder="Confirm your password"></form:input>
						<span class="glyphicon glyphicon-lock form-control-feedback"></span>
						<form:errors path="passwordConfirm"></form:errors>
					</div>
				</spring:bind>
				<div class="row">
					<div class="col-xs-8">
						<div class="checkbox icheck">
							<label> <input type="checkbox" required /> I agree to the
								<a href="#">terms</a>
							</label>
						</div>
					</div>
					<!-- /.col -->
					<div class="col-xs-4">
						<button type="submit" class="btn btn-primary btn-block btn-flat">Register</button>
					</div>
					<!-- /.col -->
				</div>
			</form:form>

			<div class="social-auth-links text-center">
				<p>- OR -</p>
				<a href="#" class="btn btn-block btn-social btn-facebook btn-flat"><i
					class="fa fa-facebook"></i> Sign up using Facebook</a> <a href="#"
					class="btn btn-block btn-social btn-google btn-flat"><i
					class="fa fa-google-plus"></i> Sign up using Google+</a>
			</div>

			<a href="${contextPath}/login" class="text-center">I already have
				a membership</a>
		</div>
		<!-- /.form-box -->
	</div>
	<!-- /.register-box -->

	<!-- jQuery 2.2.3 -->
	<script
		src="${contextPath}/resources/plugins/jQuery/jquery-2.2.3.min.js"></script>
	<!-- Bootstrap 3.3.6 -->
	<script src="${contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
	<!-- iCheck -->
	<script src="${contextPath}/resources/plugins/iCheck/icheck.min.js"></script>
	<script>
  $(function () {
    $('input').iCheck({
      checkboxClass: 'icheckbox_square-blue',
      radioClass: 'iradio_square-blue',
      increaseArea: '20%' // optional
    });
  });
</script>
</body>
</html>
