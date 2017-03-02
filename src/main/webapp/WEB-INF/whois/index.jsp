<!-- Content Header (Role index Page header) -->
<section class="content-header" id="main-breadcrumb">
	<h1>
		PingConsole<small>v1.0.0</small>
	</h1>
	<ol class="breadcrumb">
		<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
		<li><a href="#"><i class="fa fa-dashboard"></i> Network Tools</a></li>
		<li class="active">WhoIs</li>
	</ol>
</section>

<section id="main-container" class="content">
	<div class="row">
		<div class="col-xs-12">
			<div class="box box-skin">
				<div class="box-header">
					<h3 class="box-title">WhoIs Lookup</h3>
				</div>
				<!-- /.box-header -->
				<div class="box-body">
					<form id="whoisDomainForm" action="#" method="get" class="">
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
						<div class="input-group">
							<input name="domainName" id="domainName" class="form-control"
								placeholder="Enter a Domain...." type="text"> <span
								class="input-group-btn">
								<button type="button" name="search" id="search-btn"
									class="btn btn-flat" onclick="searchWhoisDomain()">
									<i class="fa fa-search"></i>
								</button>
							</span>
						</div>
					</form>
				</div>
				<div id="whoisResult1" class="box-body">
					<dl>
						<dt>Description lists</dt>
						<dd id="whoisResult" style="white-space:pre-wrap;"></dd>
					</dl>
				</div>
			</div>
		</div>
	</div>
</section>