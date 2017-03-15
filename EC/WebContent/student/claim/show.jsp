<%@ page language="java" contentType="text/html; charset=UTF-8"
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
					
					<div class="panel-body">
						<div class="row">
							<div class="col-lg-6">
								<s:form class="form-horizontal" enctype="multipart/form-data">

									<div class="form-group">
										<label class="control-label col-sm-2" for="studentid">Student
											ID:</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" id="studentid"
												name="studentId" placeholder="Enter Student ID"
												value="${studentId}">
										</div>
									</div>

									<div class="form-group">
										<label class="control-label col-sm-2" for="title">Title
											:</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" id="title"
												name="title" placeholder="Enter Title" value="${title }">

										</div>

									</div>

									<div class="form-group">
										<label class="control-label col-sm-2" for="content">Content
											:</label>
										<div class="col-sm-10">
											<textarea class="form-control" rows="5" id="content"
												name="content" placeholder="Enter Content">${content}</textarea>
										</div>
									</div>
									
									<div class="form-group">
										<label class="control-label col-sm-2" for="createDate">Created Date
											:</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" id="createDate"
												name="createDate" placeholder="Enter Title" value="${createDate }">

										</div>
									</div>
									
									<div class="form-group">
										<label class="control-label col-sm-2" for="dueDate">Due Date
											:</label>
										<div class="col-sm-10">
											
												<s:property value="dueDate"/>

										</div>
									</div>

									<div class="form-group">
										<label class="control-label col-sm-2" for="pathEvidence">Evidence:</label>
										<div class="col-sm-10">
											<a
											href="evidence/<s:property value="pathEvidenceFileName"/>"
											download>download file</a>
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