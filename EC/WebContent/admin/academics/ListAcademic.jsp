<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Claim - List Claim Type</title>
<script src="resources/vendor/jquery/jquery.min.js"></script>
</head>
<body>
	<div id="wrapper">
		<s:include value="../../index.jsp"></s:include>
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
						<div class="panel-heading">Academics List</div>
						<div class="panel-body">
							<table width="100%"
								class="table table-striped table-bordered table-hover"
								id="dataTables-example">
								<tr>
									<th>Name</th>
									<th>Open Date</th>
									<th>Closure Date</th>
									<th colspan="3" style="text-align: center;">Action</th>
								</tr>
								<s:iterator value="listAcademics" var="list">
									<tr>
										<td><s:property value="name" /></td>
										<td><s:property value="openDate" /></td>
										<td><s:property value="closureDate" /></td>



										<s:url action="searchByIdAcademic" var="searchById">
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