<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>neoPing | Console</title>
<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<%@include file="../templates/include-header.jsp"%>
</head>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper" style="margin-left:0px">

			<!-- Main content -->
			<section class="content">
				<div class="error-page">
					<h2 class="headline text-yellow">404</h2>

					<div class="error-content">
						<h3>
							<i class="fa fa-warning text-yellow"></i> Oops! Page not found.
						</h3>

						<p>
							We could not find the page you were looking for. Meanwhile, you
							may <a href="${contextPath}/">return to dashboard</a> or try
							using the search form.
						</p>

						<form class="search-form">
							<div class="input-group">
								<input name="search" class="form-control" placeholder="Search"
									type="text">

								<div class="input-group-btn">
									<button type="submit" name="submit"
										class="btn btn-warning btn-flat">
										<i class="fa fa-search"></i>
									</button>
								</div>
							</div>
							<!-- /.input-group -->
						</form>
					</div>
					<!-- /.error-content -->
				</div>
				<!-- /.error-page -->
			</section>
			<!-- /.content -->
		</div>

	</div>
	<!-- ./wrapper -->
	<%@include file="../templates/include-footer.jsp"%>

</body>
</html>
