<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 5.0 Transitional//EN">
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

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
<link href="resources/vendor/mySite/site.css" rel="stylesheet"
	type="text/css">

<!-- Custom Fonts -->
<link href="resources/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">

<style>
#hide {
	display: none;
}

#show {
	display: block;
}
</style>

</head>

<body>

	<div id="wrapper">

		<!-- Navigation -->
		<nav class="navbar navbar-default navbar-static-top" role="navigation"
			style="margin-bottom: 0">
		<div class="navbar-header">
			<a class="navbar-brand" href="addClaim">DHHBT University</a>

		</div>
		<!-- /.navbar-header -->
		<ul class="nav navbar-nav">

			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#">Claim<span class="caret"></span></a>
				<ul class="dropdown-menu">
					<li><a href="addClaim">New Claim</a></li>
					<li><a href="searchClaimByStudentId">My Claim</a></li>
				</ul></li>

		</ul>
		<ul class="nav navbar-top-links navbar-right">
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#"> <i class="fa fa-user fa-fw"></i>
					<i class="fa fa-caret-down"></i>
			</a>
				<ul class="dropdown-menu dropdown-user">
					<li><a href="login"><i class="fa fa-sign-in fa-fw"></i>
							Login</a></li>
					<li><a href="profile"><i class="fa fa-user fa-fw"></i>
							User Profile</a></li>
					<li><a href="logout"><i class="fa fa-sign-out fa-fw"></i>
							Logout</a></li>
				</ul></li>

		</ul>



		</nav>



	</div>
	<!-- jQuery -->
	<script src="resources/vendor/jquery/jquery.min.js"></script>
	<script src="resources/vendor/jquery/jquery.validate.js"></script>
	<script src="resources/vendor/jquery/jquery.validate.min.js"></script>
	<script src="resources/vendor/jquery/additional-methods.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="resources/vendor/bootstrap/js/bootstrap.min.js"></script>

	<!-- Metis Menu Plugin JavaScript -->
	<script src="resources/vendor/metisMenu/metisMenu.min.js"></script>
	<script type="text/javascript"
		src="resources/vendor/bootstrap/js/bootstrap-datetimepicker.js"
		charset="UTF-8"></script>

	<!-- Custom Theme JavaScript -->
	<script src="resources/dist/js/sb-admin-2.js"></script>
</body>

</html>

