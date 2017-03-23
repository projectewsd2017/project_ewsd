<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Claim Type - ${id}</title>
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
										<label class="control-label col-sm-2" for="claimName">Claim
											Name :</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" id="claimName"
												name="claimName" value="${claimName}" readonly="readonly">

										</div>

									</div>

									<div class="form-group">
										<label class="control-label col-sm-2" for="des">Content
											:</label>
										<div class="col-sm-10">
											<textarea class="form-control" rows="5" id="des"
												readonly="readonly" placeholder="Enter Content">${description}</textarea>
										</div>
									</div>
							</div>
							<s:url action="updateClaimType" var="updateid">
								<s:param name="id">
									<s:property value="id" />
								</s:param>
								<s:param name="claimName">
									<s:property value="claimName" />
								</s:param>
								<s:param name="description">
									<s:property value="description" />
								</s:param>


							</s:url>
							<s:url action="deleteType" var="deleteid">
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