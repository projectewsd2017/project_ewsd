<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<s:head />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="wrapper">
		<s:include value="../../index.html"></s:include>
		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">Update Claim</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<div class="row">
				<div class="col-lg-12">

					<div class="panel-body">
						<div class="row">
							<div class="col-lg-6">
								<s:form action="saveupdateclaim"
									cssClass="form-horizontal col-xs-12"
									enctype="multipart/form-data" validate="true">
									<s:textfield name="id" type="hidden"></s:textfield>
									<s:textfield class="form-control table" id="studentId"
										name="studentId" maxlength="30" label="Student ID"
										style="width:100%" placeholder="Enter Student ID" />

									<div class="form-group">
										<label class="control-label col-sm-3" for="ward">Claim Name:</label>
										<div class="col-sm-9 row">
											<s:select class="form-control table" id="claimtype"
												label="Claim Type" list="%{listType}" theme="simple"
												listKey="%{id}" style="width:100%" listValue="%{claimName}"
												value="%{id}" name="claimType.id" />
										</div>

									</div>
									<s:textfield class="form-control table" id="title" name="title"
										maxlength="30" label="Title" style="width:100%"
										placeholder="Enter Title" />

									<s:textarea class="form-control table" id="content"
										name="content" maxlength="300" label="Content"
										style="width:100%" rows="5" placeholder="Enter Content" />

									<s:file class="form-control table" id="pathEvidence1"
										name="pathEvidence1" label="Evidence" />

									<s:file class="form-control table" id="pathEvidence2"
										name="pathEvidence2" label="Evidence" />

									<s:file class="form-control table" id="pathEvidence3"
										name="pathEvidence3" label="Evidence" />




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