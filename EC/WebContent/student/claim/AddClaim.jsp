<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-dojo-tags" prefix="d"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<d:head />
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
								<s:form action="saveaddclaim" class="form-horizontal"
									enctype="multipart/form-data">
									<div class="form-group">
										<label class="control-label col-sm-2" for="studentid">Student
											ID:</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" id="studentid"
												name="studentId" placeholder="Enter Student ID"
												required="true" maxlength="10">

										</div>
									</div>

									<div class="form-group">
										<label class="control-label col-sm-2" for="title">Title
											:</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" id="title"
												name="title" placeholder="Enter Title" required="true"
												maxlength="30">
										</div>

									</div>

									<div class="form-group">
										<label class="control-label col-sm-2" for="content">Content
											:</label>
										<div class="col-sm-10">
											<textarea class="form-control" rows="5" id="content"
												maxlength="300" name="content" placeholder="Enter Content"
												required="true"></textarea>
										</div>
									</div>

									<div class="form-group">
										<label class="control-label col-sm-2" for="pathEvidence1">Attach
											supporting evidence:</label>
										<div class="col-sm-10">
											<input type="file" class="form-control" id="pathEvidence1"
												name="pathEvidence1" required="true">
										</div>

									</div>

									<div class="form-group">
										<label class="control-label col-sm-2" for="pathEvidence2">Attach
											supporting evidence:</label>
										<div class="col-sm-10">
											<input type="file" class="form-control" id="pathEvidence2"
												name="pathEvidence2" required="true">
										</div>

									</div>

									<div class="form-group">
										<label class="control-label col-sm-2" for="pathEvidence3">Attach
											supporting evidence:</label>
										<div class="col-sm-10">
											<input type="file" class="form-control" id="pathEvidence3"
												name="pathEvidence3" required="true">
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