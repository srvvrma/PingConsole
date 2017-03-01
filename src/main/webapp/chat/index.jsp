<script src="//cdnjs.cloudflare.com/ajax/libs/jquery-timeago/1.4.0/jquery.timeago.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.0.0/sockjs.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
 
    <script>
        var stompClient = null;
 
        function connect() {
            var socket = new SockJS('/newMessage');
            stompClient = Stomp.over(socket);
            stompClient.connect({}, function(frame) {
                stompClient.subscribe('/topic/newMessage', function(message){
                    refreshMessages(JSON.parse(JSON.parse(message.body).content));
                });
            });
        }
 
        function disconnect() {
            if (stompClient != null) {
                stompClient.disconnect();
            }
        }
 
        function refreshMessages(messages) {
            $.each(messages.reverse(), function(i, message) {
            	var curr_date = new Date();
            	var msg_date = new Date(message.createDate);

            	var hours_diff=Math.abs(msg_date.getHours()-curr_date.getHours());
            	var minutes_diff=Math.abs(msg_date.getHours()*60+msg_date.getMinutes()-curr_date.getHours()*60-curr_date.getMinutes());
            	var time_string
            	if(hours_diff > 0){
            		time_string = hours_diff + " hours ago";
            	}else{
            		time_string = minutes_diff+" minutes ago"
            	}
            	console.log("xxx has updated "+hours_diff+" hours ago");
            	console.log("xxx has updated "+minutes_diff+" minutes ago");
            	
            	$("#chat-box").append('<div class="item">'
                							+'<img src="${contextPath}/resources/dist/img/user3-128x128.jpg" alt="user image" class="offline">'
												+'<p class="message">'
                  									+'<a href="#" class="name">'
                    									+'<small class="text-muted pull-right"><i class="fa fa-clock-o"></i> '+time_string+'</small>'
                    										+message.author
                  									+'</a>'
                  									+ message.text
               	 								+'</p>'
              							+'</div>');
                /* $(".media-list").append('<li class="media"><div class="media-body"><div class="media"><div class="media-body">'
                + message.text + '<br/><small class="text-muted">' + message.author + ' | ' + new Date(message.createDate) + '</small><hr/></div></div></div></li>'); */
            });
        }
        function sendMessage() {
            $container = $('#chat-box');
            $container[0].scrollTop = $container[0].scrollHeight;
            var message = $("#messageText").val();
            

            stompClient.send("/app/newMessage", {}, JSON.stringify({ 'text': message, 'author': author}));

            $("#messageText").val("")
            $container.animate({ scrollTop: $container[0].scrollHeight }, "slow");

        }
        connect();
        $.get("/messages", function (messages) {
            refreshMessages(messages)
        });

        $("#sendMessage").on("click", function() {
            sendMessage()
        });

        $('#messageText').keyup(function(e){
            if(e.keyCode == 13)
            {
                sendMessage();
            }
        });
    </script>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet"/>
    <style type="text/css">
        .fixed-panel {
        min-height: 500px;
        max-height: 500px;
        }
        .media-list {
        overflow: auto;
        }
    </style>
<!-- Content Header (Role index Page header) -->
<section class="content-header" id="main-breadcrumb">
	<h1>
		PingConsole<small>v1.0.0</small>
	</h1>
	<ol class="breadcrumb">
		<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
		<li class="active"> Chat</li>
	</ol>
</section>

<section class="content">
<!-- 
	<div class="row">
		<div class="col-xs-12">
			<div class="box box-skin">
				<div class="box-header">
					<h3 class="box-title">Users</h3>
				</div>
			</div>
		</div>
		<div class="col-md-3">
			<ul class="list-group">
				<li class="list-group-item">First item</li>
				<li class="list-group-item">Second item</li>
				<li class="list-group-item">Third item</li>
			</ul>
		</div>
		<div class="col-md-9">
            <div class="panel panel-info">
                <div class="panel-heading">
                    <strong><span class="glyphicon glyphicon-list"></span> Chat History</strong>
                </div>
                <div class="panel-body fixed-panel">
                    <ul class="media-list">
                    </ul>
                </div>
                <div class="panel-footer">
                    <div class="input-group">
                        <input type="text" class="form-control" placeholder="Enter Message" id="messageText" autofocus=""/>
                                    <span class="input-group-btn">
                                        <button class="btn btn-info" type="button" id="sendMessage">SEND <span class="glyphicon glyphicon-send"></span></button>
                                    </span>
                    </div>
                </div>
            </div>
        </div>
	</div> -->
	<div class="row">
         <div class="col-xs-12">
              <!-- USERS LIST -->
              <div class="box box-danger">
                <div class="box-header with-border">
                  <h3 class="box-title">Latest Members</h3>

                  <div class="box-tools pull-right">
                    <span class="label label-danger">8 New Members</span>
                    <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                    </button>
                    <!-- <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i>
                    </button> -->
                  </div>
                </div>
                <!-- /.box-header -->
                <div class="box-body no-padding">
                  <ul class="users-list clearfix">
                    <li style="width: 8%;">
                      <img src="${contextPath}/resources/dist/img/user1-128x128.jpg" alt="User Image">
                      <a class="users-list-name" href="#">Alexander Pierce</a>
                      <span class="users-list-date">Today</span>
                    </li>
                    <li style="width: 8%;">
                      <img src="${contextPath}/resources/dist/img/user8-128x128.jpg" alt="User Image">
                      <a class="users-list-name" href="#">Norman</a>
                      <span class="users-list-date">Yesterday</span>
                    </li>
                    <li style="width: 8%;">
                      <img src="${contextPath}/resources/dist/img/user7-128x128.jpg" alt="User Image">
                      <a class="users-list-name" href="#">Jane</a>
                      <span class="users-list-date">12 Jan</span>
                    </li>
                    <li style="width: 8%;">
                      <img src="${contextPath}/resources/dist/img/user6-128x128.jpg" alt="User Image">
                      <a class="users-list-name" href="#">John</a>
                      <span class="users-list-date">12 Jan</span>
                    </li>
                    <li style="width: 8%;">
                      <img src="${contextPath}/resources/dist/img/user2-160x160.jpg" alt="User Image">
                      <a class="users-list-name" href="#">Alexander</a>
                      <span class="users-list-date">13 Jan</span>
                    </li>
                    <li style="width: 8%;">
                      <img src="${contextPath}/resources/dist/img/user5-128x128.jpg" alt="User Image">
                      <a class="users-list-name" href="#">Sarah</a>
                      <span class="users-list-date">14 Jan</span>
                    </li>
                    <li style="width: 8%;">
                      <img src="${contextPath}/resources/dist/img/user4-128x128.jpg" alt="User Image">
                      <a class="users-list-name" href="#">Nora</a>
                      <span class="users-list-date">15 Jan</span>
                    </li>
                    <li style="width: 8%;">
                      <img src="${contextPath}/resources/dist/img/user3-128x128.jpg" alt="User Image">
                      <a class="users-list-name" href="#">Nadia</a>
                      <span class="users-list-date">15 Jan</span>
                    </li>
                  </ul>
                  <!-- /.users-list -->
                </div>
                <!-- /.box-body -->
                <div class="box-footer text-center">
                  <a href="javascript:void(0)" class="uppercase">View All Users</a>
                </div>
                <!-- /.box-footer -->
              </div>
              <!--/.box -->
            </div>
            <div class="col-xs-12">
	<!-- Chat box -->
          <div class="box box-success">
            <div class="box-header">
              <i class="fa fa-comments-o"></i>

              <h3 class="box-title">Chat</h3>

              <div class="box-tools pull-right" data-toggle="tooltip" title="Status">
                <div class="btn-group" data-toggle="btn-toggle">
                  <button type="button" class="btn btn-default btn-sm active"><i class="fa fa-square text-green"></i>
                  </button>
                  <button type="button" class="btn btn-default btn-sm"><i class="fa fa-square text-red"></i></button>
                </div>
              </div>
            </div>
            <div class="box-body chat" id="chat-box" style="max-height: 350px;overflow-y: auto;">
          
              
            </div>
            <!-- /.chat -->
            <div class="box-footer">
              <div class="input-group">
                <input class="form-control" placeholder="Type message..." id="messageText">

                <div class="input-group-btn">
                  <button type="button" class="btn btn-success" id="sendMessage"> Send <i class="glyphicon glyphicon-send"></i></button>
                </div>
              </div>
            </div>
          </div>
          <!-- /.box (chat box) -->
        </div>
	</div>
</section>