<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 5.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<s:head />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Claim - Edit ${id}</title>
</head>
<body>
	<div id="wrapper">
		<s:include value="../../index.html"></s:include>
		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">Update Claim Type</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<div class="row">
				<div class="col-lg-12">

					<div class="panel-body">
						<div class="row">
							<div class="col-lg-6">
								<s:form action="saveupdateclaimtype" validate="true"
									cssClass="form-horizontal col-xs-12"
									enctype="multipart/form-data">
									<s:textfield name="id" type="hidden"></s:textfield>
									<s:textfield class="form-control table" id="claimName"
										name="claimName" maxlength="30"
										label="Claim Name" style="width:100%"
										placeholder="Enter Claim Name" />

									<s:textarea class="form-control table" rows="5"
										id="description" labelposition="bottom" maxlength="300"
										label="Description" placeholder="Enter Description"
										errorPosition="bottom" name="description"></s:textarea>

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