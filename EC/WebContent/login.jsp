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
	<div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div class="login-panel panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Please Sign In</h3>
					</div>
					<div class="panel-body">
						<s:form action="loginprocess">
							<fieldset>
								<div class="form-group">

									<input class="form-control" placeholder="Username"
										name="username" type="text" autofocus>
								</div>
								<div class="form-group">
									<input class="form-control" placeholder="Password" name="pass"
										type="password" value="">
								</div>

								<div class="form-group">
									
										<button type="submit" class="btn btn-lg btn-success btn-block">Login</button>
									
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
</html>