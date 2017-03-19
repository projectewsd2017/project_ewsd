<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<s:head/>
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
						<div class="panel-heading">Add Claim Type</div>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-lg-6">
								<s:form action="saveaddclaimtype" validate="true"
									cssClass="form-horizontal" enctype="multipart/form-data">
									<div class="form-group">
										<label class="control-label col-sm-2" for="claimName">Claim
											Name :</label>
										<div class="col-sm-10">
											<s:textfield class="form-control" id="claimName"
												name="claimName" maxlength="30"
												placeholder="Enter Claim Name" label="Name"/>

										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-sm-2" for="description">Description
											:</label>
										<div class="col-sm-10">
											<s:textarea class="form-control" rows="5" id="description" labelposition="bottom" theme="simple"
												maxlength="300" placeholder="Enter Description" errorPosition="bottom"
												name="description" label="Description"></s:textarea>
										</div>
									</div>
									<div class="form-group">
										<div class="col-sm-offset-2 col-sm-10">
											<button type="submit" class="btn btn-default">Save</button>
										</div>
									</div>
								</s:form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>