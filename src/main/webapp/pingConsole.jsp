<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>PingConsole | Dashboard</title>
<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<%@include file="templates/include-header.jsp"%>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<script type="text/javascript">

var contextPath = '${contextPath}';
</script>
	<div class="wrapper">
		<%@include file="templates/main-header.jsp"%>

		<%@include file="templates/sidebar.jsp"%>
	
		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper" id="mainContentId">
				
		</div>
		<!-- /.content-wrapper -->
		<%@include file="templates/footer.jsp"%>
	
		<!-- Control Sidebar -->
		<%@include file="templates/control-sidebar.jsp"%>					
		<!-- /.control-sidebar -->
	</div>
	<!-- ./wrapper -->
	<%@include file="templates/include-footer.jsp"%>
	
</body>
</html>
