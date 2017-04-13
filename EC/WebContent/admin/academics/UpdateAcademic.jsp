<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 5.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="resources/vendor/jquery/jquery.min.js"></script>
<s:head />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Academics - Edit ${id}</title>
</head>
<body>
	<div id="wrapper">
		<s:include value="../../index.jsp"></s:include>
		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">Update Academics</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<div class="row">
				<div class="col-lg-12">

					<div class="panel-body">
						<div class="row">
							<div class="col-lg-6">
								<s:form action="saveupdateacademic" validate="true"
									cssClass="form-horizontal col-xs-12"
									enctype="multipart/form-data">
									<s:textfield name="id" type="hidden"></s:textfield>
									<div class="form-group">
										<label class="control-label col-sm-4" for="name">Name:</label>
										<div class="col-sm-6">
											<input type="text" class="form-control" id="name" value="${name }"
												maxlength="50" name="name" placeholder="Enter Name">
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-sm-4" for="openDateString">Open
											Date:</label>
										<div class="col-sm-6">
											<input type="date" class="form-control" id="dob"
												name="openDateString" value="${openDate}">
										</div>
									</div>

									<div class="form-group">
										<label class="control-label col-sm-4" for="openDateString">Closure
											Date:</label>
										<div class="col-sm-6">
											<input type="date" class="form-control" id="dob"
												name="closureDateString" value="${closureDate}">
										</div>
									</div>

									<s:submit class="btn btn-default" />



								</s:form>

							</div>
						</div>
					</div>

				</div>

			</div>

		</div>
</body>
</html>