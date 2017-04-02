<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Student - List Student</title>
</head>
<body>
	<div id="wrapper">
		<s:include value="../../index.html"></s:include>
		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header"></h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">Staff List</div>
						<div class="panel-body">
							<table width="100%"
								class="table table-striped table-bordered table-hover"
								id="dataTables-example">
								<tr>
									<th>Username</th>
									<th>First Name</th>
									<th>Last Name</th>
									<th>Email</th>
									<th>Faculty</th>
									<th>Address</th>


									<th colspan="3" style="text-align: center;">Action</th>
								</tr>
								<s:iterator value="listStaffs" var="list">
									<tr>
										<td><s:property value="username" /></td>
										<td><s:property value="firstName" /></td>
										<td><s:property value="lastName" /></td>

										<td><s:property value="email" /></td>
										<td><s:property value="faculty.facutlyName" /></td>
										<td><s:property value="address" /></td>

										
										<s:url action="searchStaffById" var="searchById">
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