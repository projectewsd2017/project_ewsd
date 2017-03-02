<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div id="wrapper">
		<s:include value="../../index.html"></s:include>
		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">Forms</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">Add Claim</div>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-lg-6">
								<s:form action="saveaddclaim" class="form-horizontal" enctype="multipart/form-data">
									<div class="form-group">
										<label class="control-label col-sm-2" for="studentid">Student
											ID:</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" id="studentid"
												name="studentId" placeholder="Enter Student ID">
										</div>
									</div>

									<div class="form-group">
										<label class="control-label col-sm-2" for="facultyID">Faculty
											ID:</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" id="facultyID"
												name="facultyId" placeholder="Enter Faculty ID">
										</div>

									</div>
									<div class="form-group">
										<label class="control-label col-sm-2" for="file1">Attach
											supporting evidence:</label>
										<div class="col-sm-10">
											<input type="file" class="form-control" id="file1"
												name="userImage">
										</div>

									</div>



									<div class="form-group">
										<div class="col-sm-offset-2 col-sm-10">
											<button type="submit" class="btn btn-default">Save</button>
										</div>
									</div>
							</div>
							</s:form>
						</div>
					</div>
				</div>

			</div>

		</div>

	</div>
</body>
</html>