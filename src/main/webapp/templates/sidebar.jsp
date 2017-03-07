<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!-- Left side column. contains the logo and sidebar -->
<aside class="main-sidebar">
	<!-- sidebar: style can be found in sidebar.less -->
	<section class="sidebar">
		<!-- Sidebar user panel -->
		<div class="user-panel">
			<div class="pull-left image">
				<img src="${contextPath}/resources/dist/img/user2-160x160.jpg"
					class="img-circle" alt="User Image">
			</div>
			<div class="pull-left info">
				<p>${currentUser.fullName}</p>
				<a href="#"><i class="fa fa-circle text-success"></i> Online</a>
			</div>
		</div>
		<!-- search form -->
		<form action="#" method="get" class="sidebar-form">
			<div class="input-group">
				<input type="text" name="q" class="form-control"
					placeholder="Search..."> <span class="input-group-btn">
					<button type="submit" name="search" id="search-btn"
						class="btn btn-flat">
						<i class="fa fa-search"></i>
					</button>
				</span>
			</div>
		</form>
		<!-- /.search form -->
		<!-- sidebar menu: : style can be found in sidebar.less -->
		<ul class="sidebar-menu">
			<li class="header"><spring:message code="label.menu.header" /></li>
			<li class="active treeview"><a href="#"
				onclick="loadDashboard();"> <i class="fa fa-dashboard"></i> <span><spring:message code="label.menu.dashboard" /></span>
			</a></li>
			<sec:authorize access="hasAuthority('ADMIN')">
				<!-- Showing Ures Details-->
				<li class="treeview"><a href="#" onclick="loadUsers();"> <i
						class="fa fa-group"></i> <span><spring:message code="label.menu.users" /></span>
				</a></li>
				<!-- Showing Role Controller for creating and edit roles -->
				<li class="treeview"><a href="#"> <i
						class="fa fa-user-plus"></i> <span><spring:message code="label.menu.role" /></span> <span
						class="pull-right-container"> <i
							class="fa fa-angle-left pull-right"></i>
					</span>
				</a>
					<ul class="treeview-menu" style="display: none;">
						<li class=""><a href="#" onclick="createOrUpdate('');"><i
								class="fa fa-circle-o"></i> <spring:message code="label.menu.roles.add" /></a></li>
						<li><a href="#" onclick="loadRoles();"><i
								class="fa fa-circle-o"></i> <spring:message code="label.menu.roles.all" /></a></li>
					</ul></li>

				<!-- Showing Authorities Controller for creating and edit roles -->
				<li class="treeview"><a href="#" onclick="loadPrivileges();">
						<i class="fa fa-user-secret"></i> <span><spring:message code="label.menu.privileges" /></span>
				</a></li>
				<!-- Showing Groups Details-->
				<li class="treeview"><a href="#" onclick="loadGroups();"> <i
						class="fa fa-group"></i> <span><spring:message code="label.menu.groups" /></span>
				</a></li>
			</sec:authorize>
			<!-- Showing Environment, Create a new or edit old one -->
			<li class="treeview"><a href="#"> <i class="fa fa-user-plus"></i>
					<span><spring:message code="label.menu.environment" /></span> <span class="pull-right-container">
						<i class="fa fa-angle-left pull-right"></i>
				</span>
			</a>
				<ul class="treeview-menu" style="display: none;">
					<li class=""><a href="#" onclick="createOrEditEnvironment('')"><i
							class="fa fa-circle-o"></i> <spring:message code="label.menu.environment.add" /></a></li>
					<li><a href="#" onclick="loadAllEnvironment();"><i
							class="fa fa-circle-o"></i> <spring:message code="label.menu.environment.all" /></a></li>
				</ul></li>
			<!-- Showing Authorities Controller for creating and edit roles -->
			<li class="treeview">
				<a href="#" onclick="chat();"> <i class="fa fa-user-secret"></i>
					<span><spring:message code="label.menu.chat" /></span>
				</a>
			</li>
			<!-- Patch Tool-->
			<li class="treeview">
				<a href="#" onclick="loadPatchView();"> <i class="fa fa-group"></i>
					<span><spring:message code="label.menu.patch" /></span>
				</a>
			</li>
			<!-- Showing Netwok Tools -->
			<li class="treeview"><a href="#"> <i class="fa fa-user-plus"></i>
					<span><spring:message code="label.menu.network.tools" /></span> <span class="pull-right-container">
						<i class="fa fa-angle-left pull-right"></i>
				</span>
			</a>
				<ul class="treeview-menu" style="display: none;">
					<li><a href="#" onclick="whoIsLookup();"><i
							class="fa fa-circle-o"></i> <spring:message code="label.menu.network.tools.whois" /></a></li>
					<li><a href="#" onclick="dnsLookup();"><i
							class="fa fa-circle-o"></i> <spring:message code="label.menu.network.tools.dns" /></a></li>
				</ul></li>
			<!-- Formatter Tools -->
			<li class="treeview"><a href="#"> <i class="fa fa-user-plus"></i>
					<span><spring:message code="label.menu.formatter" /></span> <span class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span>
			</a>
				<ul class="treeview-menu" style="display: none;">
					<li><a href="#" onclick="loadJSONFormatter();"><i
							class="fa fa-circle-o"></i> <spring:message code="label.menu.formatter.json" /></a></li>
				</ul></li>
			<!-- Settings Tools -->
			<li class="treeview"><a href="#"> <i class="fa fa-user-plus"></i>
					<span><spring:message code="label.menu.setting" /></span> <span class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span>
			</a>
				<ul class="treeview-menu" style="display: none;">
					<li><a href="#" onclick="loadUserProfile();"><i
							class="fa fa-circle-o"></i><spring:message code="label.menu.setting.profile" /></a></li>
				</ul></li>


			<li class="header">LABELS</li>
			<li><a href="#"><i class="fa fa-circle-o text-red"></i> <span>Important</span></a></li>
			<li><a href="#"><i class="fa fa-circle-o text-yellow"></i> <span>Warning</span></a></li>
			<li><a href="#"><i class="fa fa-circle-o text-aqua"></i> <span>Information</span></a></li>
		</ul>
	</section>
	<!-- /.sidebar -->
</aside>

