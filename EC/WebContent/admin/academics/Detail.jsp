<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="resources/vendor/jquery/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Claim Type - ${id}</title>
</head>
<body>
	<div id="wrapper">
		<s:include value="../../index.jsp"></s:include>
		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">

					<div class="panel-body">
						<div class="row">
							<div class="col-lg-6">
								<s:form class="form-horizontal" enctype="multipart/form-data">
									<div class="form-group">
										<label class="control-label col-sm-2" for="openDate">Name :</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" id="name"
												name="name" value="${name}" readonly="readonly">

										</div>

									</div>

									<div class="form-group">
										<label class="control-label col-sm-2" for="openDate">Open
											Date :</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" id="openDate"
												name="openDate" value="${openDate}" readonly="readonly">

										</div>

									</div>

									<div class="form-group">
										<label class="control-label col-sm-2" for="des">Closure
											Date :</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" id="closureDate"
												name="closureDate" value="${closureDate}"
												readonly="readonly">

										</div>
									</div>
							</div>
							<s:url action="updateAcademic" var="updateid">
								<s:param name="id">
									<s:property value="id" />
								</s:param>
								<s:param name="name">
									<s:property value="name" />
								</s:param>
								<s:param name="openDate">
									<s:property value="openDate" />
								</s:param>
								<s:param name="closureDate">
									<s:property value="closureDate" />
								</s:param>


							</s:url>
							<s:url action="deleteAcademic" var="deleteid">
								<s:param name="id">
									<s:property value="id" />
								</s:param>
							</s:url>
							<div style="text-align: right">
								<button class="btn btn-default">
									<s:a href="%{updateid}">Update</s:a>
								</button>
								&nbsp

								<button class="btn btn-default">
									<s:a href="%{deleteid}">Delete</s:a>
								</button>
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