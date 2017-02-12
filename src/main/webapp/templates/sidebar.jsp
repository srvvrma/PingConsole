
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
			<li class="header">MAIN NAVIGATION</li>
			<li class="active treeview">
				<a href="#" onclick="loadDashboard();"> <i class="fa fa-dashboard"></i>
					<span>Dashboard</span>
				</a>
			</li>
			
			<!-- Showing Role Controller for creating and edit roles -->
			<li class="treeview">
				<a href="#" onclick="loadUsers();"> <i class="fa fa-group"></i>
					<span>Users</span>
				</a>
			</li>
			
			<!-- Showing Role Controller for creating and edit roles -->
			<li class="treeview">
				<a href="#"> <i class="fa fa-user-plus"></i>
					<span>Roles</span> <span class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
					</span>
				</a>
				<ul class="treeview-menu" style="display: none;">
					<li class=""><a href="#"><i class="fa fa-circle-o"></i> Add New Role</a></li>
					<li><a href="#" onclick="loadRoles();"><i class="fa fa-circle-o"></i> All Roles</a></li>
				</ul>
			</li>
			
			<!-- Showing Role Controller for creating and edit roles -->
			<li class="treeview">
				<a href="#" onclick="loadAuthorities();"> <i class="fa fa-user-secret"></i>
					<span>Privileges</span>
				</a>
			</li>

			<li class="header">LABELS</li>
			<li><a href="#"><i class="fa fa-circle-o text-red"></i> <span>Important</span></a></li>
			<li><a href="#"><i class="fa fa-circle-o text-yellow"></i> <span>Warning</span></a></li>
			<li><a href="#"><i class="fa fa-circle-o text-aqua"></i> <span>Information</span></a></li>
		</ul>
	</section>
	<!-- /.sidebar -->
</aside>

