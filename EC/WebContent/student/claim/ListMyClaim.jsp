<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="wrapper">
		<s:include value="../../home.html"></s:include>
		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">Tables</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">Claims List</div>
						<div class="panel-body">
							<table width="100%"
								class="table table-striped table-bordered table-hover"
								id="dataTables-example">
								<tr>
									<th>Student ID</th>
									<th>Student Name</th>
									<th>Title</th>
									<th>Status</th>
									<th>Created Date</th>
									<th>Due Date</th>


									<th colspan="3" style="text-align: center;">Action</th>
								</tr>
								<s:iterator value="listOfStudent" var="list">
									<tr>
										<td><s:property value="student.id" /></td>
										<td><s:property
												value="student.firstName +' '+ student.lastName" /></td>
										<td><s:property value="title" /></td>

										<td><s:property value="status" /></td>
										<td><s:property value="createDate" /></td>
										<td><s:property value="dueDate" /></td>

										<s:url action="deleteClaim" var="deleteid">
											<s:param name="id">
												<s:property value="id" />
											</s:param>
										</s:url>
										<td style="text-align: center"><s:a href="%{deleteid}">Delete</s:a></td>
										<s:url action="searchMyClaim" var="searchById">
											<s:param name="id">
												<s:property value="id" />
											</s:param>
										</s:url>
										<td><s:a href="%{searchById}">View</s:a></td>

									</tr>
								</s:iterator>
							</table>
						</div>








					</div>
				</div>

			</div>
		</div>
	</div>
</body>
</html>