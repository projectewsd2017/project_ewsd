<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Extenuating Circumstances</title>
<!-- Bootstrap Core CSS -->
<link href="resources/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet" type="text/css">

<!-- MetisMenu CSS -->
<link href="resources/vendor/metisMenu/metisMenu.min.css"
	rel="stylesheet" type="text/css">

<!-- Custom CSS -->
<link href="resources/dist/css/sb-admin-2.css" rel="stylesheet"
	type="text/css">

<!-- Morris Charts CSS -->
<link href="resources/vendor/morrisjs/morris.css" rel="stylesheet"
	type="text/css">

<!-- Custom Fonts -->
<link href="resources/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">

</head>
<body>
<style>
        body{
        	background: url(http://images.adsttc.com/media/images/55e4/31d4/e58e/ce03/1300/009d/slideshow/03_entrance_view_VTN.jpg?1441018318) no-repeat center center fixed; 
           -webkit-background-size: cover;
           -moz-background-size: cover;
           -o-background-size: cover;
           background-size: cover;
        }
        
        .login-box{
        	box-shadow: 
        }
         #btnLogin {
        transition: 0.5s;
    }

    #btnLogin:hover {
        border-radius: 5px;
        box-shadow: 8px 8px 4px lightblue
    }
    
    #btnLogin:focus {
        border-radius: 5px;
        box-shadow: 8px 8px 4px lightblue;
    }
    
    #username:focus {
        box-shadow: 2px 2px 1px #888888;
    }
    
    #pass:focus {
        box-shadow: 2px 2px 1px #888888;
    }
    .login-box-msg {
  margin: 0;
  text-align: center;
  padding: 0 20px 20px 20px;
}
.red {
    color:red;
}
.panel-heading{
	background-color: orange !important;
}

.login-panel{
	border: solid orange;
	box-shadow: 10px 10px 5px #888888;
}
    </style>
	<div class="container">
			<div class="row">
			<div class="col-md-6 col-md-offset-3 login-box">
				<div class="login-panel panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title" style="text-align: center; font-family: 'Comic Sans MS', cursive, sans-serif; font-weight: ">DHHBT University</h3>
					</div>
					<div class="panel-body">
					<p class="login-box-msg">Please fill out the following fields to login</p>
						<s:form action="loginprocess" name="form" id="form">
							<fieldset>
								<div class="form-group">

									<input id="username" class="form-control" placeholder="Username"
										name="username" type="text" autofocus>
								</div>
								<div class="form-group">
									<input id="pass" class="form-control" placeholder="Password" name="pass"
										type="password" value="">
								</div>

								<div class="form-group">

									<button type="submit" id="btnLogin" class="btn btn-lg btn-primary btn-block">Login</button>

								</div>
						</s:form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- jQuery -->
	<script src="resources/vendor/jquery/jquery.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="resources/vendor/bootstrap/js/bootstrap.min.js"></script>

	<!-- Metis Menu Plugin JavaScript -->
	<script src="resources/vendor/metisMenu/metisMenu.min.js"></script>


	<!-- Custom Theme JavaScript -->
	<script src="resources/dist/js/sb-admin-2.js"></script>
</body>
<script>
$(document).ready(function () {
    $("#username").focus();
    $("#username").blur(function () {
        var name = $('#username').val();
        if (name.length == 0) {
            $('#username').next('div.red').remove();
            $('#username').after('<div class="red">Please enter username!</div>');
        } else {
            $(this).next('div.red').remove();
            return true;
        }
    });

    $("#pass").blur(function () {
        var address = $('#pass').val();
        if (address.length == 0) {
            $('#pass').next('div.red').remove();
            $('#pass').after('<div class="red">Please enter password!</div>');
            return false;
        } else {
            $('#pass').next('div.red').remove();
            return true;
        }
    });

});
$('#form').submit(function() {
    if ($.trim($("#username").val()) === "" && $.trim($("#pass").val()) === "") {
        alert('Please enter username & password!');
        return false;
    }
    else if ($.trim($("#username").val()) === ""){
        alert('Please enter username!');
        return false;
	}
    else if ($.trim($("#pass").val()) === ""){
        alert('Please enter password!');
        return false;
	}
});
</script>
</html>