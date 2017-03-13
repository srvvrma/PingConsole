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
		<li>Rest Test</li>
		<li class="active">Rest Test Builder</li>
	</ol>
</section>
<!-- Main content -->
<section id="main-container" class="content">
	<div class="row">
		<div class="col-xs-12">
			<div class="box box-skin">
				<div class="box-header with-border">
					<h3 class="box-title">Rest Test Builder</h3>
					<!-- Button trigger modal -->
					<div class="pull-right">
						<div class="btn-group">
							<button type="button" class="btn btn-skin">Action</button>
							<button type="button" class="btn btn-skin dropdown-toggle"
								data-toggle="dropdown" aria-expanded="false">
								<span class="caret"></span> <span class="sr-only">Toggle
									Dropdown</span>
							</button>
							<ul class="dropdown-menu pull-right" role="menu">
								<li><a href="#">Action</a></li>
								<li><a href="#">Another action</a></li>
								<li><a href="#">Something else here</a></li>
								<li class="divider"></li>
								<li><a href="#">Separated link</a></li>
							</ul>
						</div>
						<!-- Button trigger modal -->
						<div class="btn-group">
							<button type="button" class="btn btn-skin dropdown-toggle"
								data-toggle="dropdown" aria-expanded="false">
								<i class="fa fa-gear"></i><span class="sr-only">Toggle
									Dropdown</span>
							</button>
							<ul class="dropdown-menu pull-right" role="menu">
								<li><a href="#">Action</a></li>
								<li><a href="#">Another action</a></li>
								<li><a href="#">Something else here</a></li>
								<li class="divider"></li>
								<li><a href="#">Separated link</a></li>
							</ul>
						</div>
					</div>

				</div>
				<!-- /.box-header -->
				<div class="box-body">
					<form role="form">
						<div class="box-body">
							<div class="row">
								<div class="col-md-6">
									<div class="form-group">
										<label>Minimal</label> <select class="form-control select2"
											style="width: 100%;">
											<option selected="selected">Environment</option>
											<option>Alaska</option>
											<option>California</option>
											<option>Delaware</option>
											<option>Tennessee</option>
											<option>Texas</option>
											<option>Washington</option>
										</select>
									</div>
								</div>
								<!-- /.col -->
								<div class="col-md-6">
									<div class="form-group">
										<label>Labels</label> <select class="form-control select2"
											multiple="multiple" data-placeholder="Select a State"
											style="width: 100%;">
											<option>Alabama</option>
											<option>Alaska</option>
											<option>California</option>
											<option>Delaware</option>
											<option>Tennessee</option>
											<option>Texas</option>
											<option>Washington</option>
										</select>
									</div>
									<!-- /.form-group -->
								</div>
								<!-- /.col -->
							</div>
							<div class="row">
								<div class="col-md-2">
									<div class="form-group" style="width: 100%;">
										<div class="input-group" style="width: 100%;">
											<select class="form-control select2">
												<option selected="selected" value="GET">GET</option>
												<option value="POST">POST</option>
												<option value="PUT">PUT</option>
												<option value="PATCH">PATCH</option>
												<option value="DELETE">DELETE</option>
												<option value="COPY">COPY</option>
												<option value="HEAD">HEAD</option>
												<option value="OPTIONS">OPTIONS</option>
												<option value="LINK">LINK</option>
												<option value="UPLINK">UPLINK</option>
												<option value="PURGE">PURGE</option>
												<option value="UNLOCK">UNLOCK</option>
											</select>
										</div>
									</div>
								</div>
								<div class="col-md-8"
									style="padding-right: 0px; padding-left: 0px">
									<div class="input-group" style="width: 100%;">
										<input type="text" class="form-control"
											aria-label="Text input with dropdown button"
											placeholder="Put Rest Url (http://rest.api/)">
										<div class="input-group-btn">
											<button type="button" class="btn btn-skin">
												Run Test &nbsp;&nbsp;<i class="fa fa-play"></i>
											</button>
										</div>

									</div>
								</div>
								<div class="col-md-2 pull-right">
									<div class="btn-group pull-right">
										<button type="button" class="btn btn-skin">
											<i class="fa fa-save"></i>&nbsp;&nbsp;Save Test
										</button>
										<button type="button" class="btn btn-skin dropdown-toggle"
											data-toggle="dropdown" aria-expanded="false">
											<span class="caret"></span> <span class="sr-only">Toggle
												Dropdown</span>
										</button>
										<ul class="dropdown-menu pull-right" role="menu">
											<li><a href="#">Action</a></li>
											<li><a href="#">Another action</a></li>
											<li><a href="#">Something else here</a></li>
											<li class="divider"></li>
											<li><a href="#">Separated link</a></li>
										</ul>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-12">
									<!-- Custom Tabs -->
									<div class="nav-tabs-custom">
										<ul class="nav nav-tabs">
											<li class="active"><a href="#authorization"
												data-toggle="tab" aria-expanded="true">Authorization</a></li>
											<li class=""><a href="#header" data-toggle="tab"
												aria-expanded="false">Header</a></li>
											<li class=""><a href="#body" data-toggle="tab"
												aria-expanded="false">Body</a></li>
											<li class=""><a href="#script" data-toggle="tab"
												aria-expanded="false">Pre-Request Script</a></li>
											<li class=""><a href="#test" data-toggle="tab"
												aria-expanded="false">Test</a></li>
											<li class="dropdown pull-right"><a
												class="dropdown-toggle" data-toggle="dropdown" href="#"
												aria-expanded="false"> Dropdown <span class="caret"></span>
											</a>
												<ul class="dropdown-menu">
													<li role="presentation"><a role="menuitem"
														tabindex="-1" href="#">Action</a></li>
													<li role="presentation"><a role="menuitem"
														tabindex="-1" href="#">Another action</a></li>
													<li role="presentation"><a role="menuitem"
														tabindex="-1" href="#">Something else here</a></li>
													<li role="presentation" class="divider"></li>
													<li role="presentation"><a role="menuitem"
														tabindex="-1" href="#">Separated link</a></li>
												</ul></li>
											<li class="pull-right"><a href="#" class="text-muted"><i
													class="fa fa-gear"></i></a></li>
										</ul>
										<div class="tab-content">
											<div class="tab-pane active" id="authorization">
												<div class="box-body">
													<div class="form-group">
														<div class="row">
															<label for="inputEmail3" class="col-md-2 control-label">TYPE</label>

															<div class="col-md-10">
																<select class="form-control select2">
																	<option selected="selected" value="NO_AUTH">No
																		Auth</option>
																	<option value="BASIC_AUTH">Basic Auth</option>
																	<option value="DIGEST_AUTH">Digest Auth</option>
																	<option value="OAUTH_1_0">OAuth 1.0</option>
																	<option value="OAUTH_2_0">OAuth 2.0</option>
																	<option value="HAWK_AUTH">Hawk Authentication</option>
																	<option value="AWS_SIGN">AWS Signature</option>
																</select>
															</div>
														</div>
														<hr class="half-rule" />
													</div>
												</div>
											</div>
											<!-- /.tab-pane -->
											<div class="tab-pane" id="header">
												<div class="box-body no-padding">
													<table class="table">
														<tbody>
															<tr>
																<th style="width: 10px">#</th>
																<th>Task</th>
																<th>Progress</th>
																<th style="width: 40px"><a href="#"
																	class="text-muted"><i class="fa fa-plus"></i></a></th>
															</tr>
															<tr>
																<td><input value="" type="checkbox"></td>
																<td width="48%"><input class="form-control"
																	aria-label="Text input with dropdown button"
																	placeholder="Header Key" type="text" list="exampleHeaders"></td>
																<td width="48%"><input class="form-control"
																	aria-label="Text input with dropdown button"
																	placeholder="Header Value" type="text" list="exampleHeadersValue"></td>
																<td><a href="#" class="text-muted text-center"
																	style="text-align: center;"><i
																		class="fa fa-trash-o"></i></a></td>
															</tr>
															<tr>
																<td><input value="" type="checkbox"></td>
																<td width="48%"><input class="form-control"
																	aria-label="Text input with dropdown button"
																	placeholder="Header Key" type="text" list="exampleHeaders"></td>
																<td width="48%"><input class="form-control"
																	aria-label="Text input with dropdown button"
																	placeholder="Header Value" type="text" list="exampleHeadersValue"></td>
																<td><a href="#" class="text-muted text-center"
																	style="text-align: center;"><i
																		class="fa fa-trash-o"></i></a></td>
															</tr>
															<datalist id="exampleHeaders">
																<option value="Accept">
																<option value="Accept-Charset">
																<option value="Accept-Encoding">
																<option value="Accept-Language">
																<option value="Accept-Datetime">
																<option value="Authorization">
																<option value="Cache-Control">
																<option value="Connection">
																<option value="Cookie">
																<option value="Content-Length">
																<option value="Content-MD5">
																<option value="Content-Type">
																<option value="Date">
																<option value="Expect">
																<option value="Forwarded">
																<option value="From">
																<option value="Host">
																<option value="If-Match">
																<option value="If-Modified-Since">
																<option value="If-None-Match">
																<option value="If-Range">
																<option value="If-Unmodified-Since">
																<option value="Max-Forwards">
																<option value="Origin">
																<option value="Pragma">
																<option value="Proxy-Authorization">
																<option value="Range">
																<option value="TE">
																<option value="User-Agent">
																<option value="Upgrade">
																<option value="Via">
																<option value="Warning">
																<option value="X-Requested-With">
																<option value="DNT">
																<option value="X-Forwarded-For">
																<option value="X-Forwarded-Host">
																<option value="X-Forwarded-Proto">
																<option value="Front-End-Https">
																<option value="X-Http-Method-Override">
																<option value="X-ATT-DeviceId">
																<option value="X-Wap-Profile">
																<option value="Proxy-Connection">
																<option value="X-UIDH">
																<option value="X-Csrf-Token">
																<option value="X-Request-ID">
															</datalist>
															<datalist id="exampleHeadersValue">
																<option value="text/plain">
																<option value="utf-8">
																<option value="deflate">
																<option value="gzip">
																<option value="en-US">
																<option value="no-cache">
																<option value="keep-alive">
																<option value="Upgrade">
																<option value="application/x-www-form-urlencoded">
																<option value="no-cache">
															</datalist>
														</tbody>
													</table>
												</div>
											</div>
											<!-- /.tab-pane -->
											<div class="tab-pane" id="body">
												<div class="box-body no-padding">
													<div class="form-group">
														<label> <input id="requestParameter1"
															name="requestParameter" required="required" value="form-data"
															checked="checked" type="radio"> form-data
														</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
														<label> <input id="requestParameter2"
															name="requestParameter" required="required" value="urlencoded"
															type="radio"> x-www-form-urlencoded
														</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
														<label> <input id="requestParameter3"
															name="requestParameter" required="required"
															value="INTEGRATION" type="radio"> raw
														</label>
													</div>
													<table class="table">
														<tbody>
															<tr>
																<th style="width: 10px">#</th>
																<th>Key</th>
																<th>Value</th>
																<th style="width: 40px"><a href="#"
																	class="text-muted"><i class="fa fa-plus"></i></a></th>
															</tr>
															<tr>
																<td><input value="" type="checkbox"></td>
																<td width="48%"><input class="form-control"
																	aria-label="Text input with dropdown button"
																	placeholder="Key" type="text"></td>
																<td width="48%"><input class="form-control"
																	aria-label="Text input with dropdown button"
																	placeholder="Value" type="text"></td>
																<td><a href="#" class="text-muted text-center"
																	style="text-align: center;"><i
																		class="fa fa-trash-o"></i></a></td>
															</tr>
														</tbody>
													</table>
												</div>
											</div>
											<!-- /.tab-pane -->
											<div class="tab-pane" id="script">script.</div>
											<!-- /.tab-pane -->
											<div class="tab-pane" id="test">
												<div class="box-body no-padding">
													<table class="table">
														<tbody>
															<tr>
																<th style="width: 10px">#</th>
																<th>Task</th>
																<th>Progress</th>
																<th style="width: 40px"><a href="#"
																	class="text-muted"><i class="fa fa-plus"></i></a></th>
															</tr>
															<tr>
																<td><input value="" type="checkbox"></td>
																<td width="48%"><select
																	class="form-control select2" style="width: 100%">
																		<option selected="selected" value="NO_AUTH">No
																			Auth</option>
																		<option value="TEST_1">Has Response Header</option>
																		<option value="TEST_2">Response JSON has</option>
																		<option value="TEST_3">Response Time less
																			than</option>
																		<option value="TEST_4">Response Time greater
																			than</option>
																		<option value="TEST_5">Response Code is</option>
																		<option value="TEST_6">Response JSON has like</option>
																</select></td>
																<td width="48%"><input class="form-control"
																	aria-label="Text input with dropdown button"
																	placeholder="" type="text"></td>
																<td><a href="#" class="text-muted text-center"
																	style="text-align: center;"><i
																		class="fa fa-trash-o"></i></a></td>
															</tr>
														</tbody>
													</table>
												</div>

											</div>
											<!-- /.tab-pane -->
										</div>
										<!-- /.tab-content -->
									</div>
									<!-- nav-tabs-custom -->
								</div>
								<!-- /.col -->
							</div>

						</div>
						<!-- /.box-body -->

						<div class="box-footer">
							<div class="box-header with-border">
								<h3 class="box-title">Response</h3>
							</div>
							<div class="box-body">
								<div class="row">
									<div class="col-md-12">
										<!-- Custom Tabs -->
										<div class="nav-tabs-custom">
											<ul class="nav nav-tabs">
												<li class="active"><a href="#response"
													data-toggle="tab" aria-expanded="true">Response</a></li>
												<li class=""><a href="#rawRequest" data-toggle="tab"
													aria-expanded="false">Raw Request</a></li>
												<li class="dropdown pull-right"><a
													class="dropdown-toggle" data-toggle="dropdown" href="#"
													aria-expanded="false"> Dropdown <span class="caret"></span>
												</a>
													<ul class="dropdown-menu">
														<li role="presentation"><a role="menuitem"
															tabindex="-1" href="#">Action</a></li>
														<li role="presentation"><a role="menuitem"
															tabindex="-1" href="#">Another action</a></li>
														<li role="presentation"><a role="menuitem"
															tabindex="-1" href="#">Something else here</a></li>
														<li role="presentation" class="divider"></li>
														<li role="presentation"><a role="menuitem"
															tabindex="-1" href="#">Separated link</a></li>
													</ul></li>
												<li class="pull-right"><a href="#" class="text-muted"><i
														class="fa fa-gear"></i></a></li>
											</ul>
											<div class="tab-content">
												<div class="tab-pane active" id="response">
													<b>#authorization:</b>

													<p>
														Exactly like the original bootstrap tabs except you should
														use the custom wrapper
														<code>.nav-tabs-custom</code>
														to achieve this style.
													</p>
													A wonderful serenity has taken possession of my entire
													soul, like these sweet mornings of spring which I enjoy
													with my whole heart. I am alone, and feel the charm of
													existence in this spot, which was created for the bliss of
													souls like mine. I am so happy, my dear friend, so absorbed
													in the exquisite sense of mere tranquil existence, that I
													neglect my talents. I should be incapable of drawing a
													single stroke at the present moment; and yet I feel that I
													never was a greater artist than now.
												</div>
												<!-- /.tab-pane -->
												<div class="tab-pane" id="rawRequest">header header
													headerThe European languages are members of the same
													family. Their separate existence is a myth. For science,
													music, sport, etc, Europe uses the same vocabulary. The
													languages only differ in their grammar, their pronunciation
													and their most common words. Everyone realizes why a new
													common language would be desirable: one could refuse to pay
													expensive translators. To achieve this, it would be
													necessary to have uniform grammar, pronunciation and more
													common words. If several languages coalesce, the grammar of
													the resulting language is more simple and regular than that
													of the individual languages.</div>
												<!-- /.tab-pane -->
												<div class="tab-pane" id="test">test.</div>
												<!-- /.tab-pane -->
											</div>
											<!-- /.tab-content -->
										</div>
										<!-- nav-tabs-custom -->
									</div>
									<!-- /.col -->
								</div>
							</div>

						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</section>
<script>
	$(document).ready(function() {
		$('.select2').select2();
	});
</script>