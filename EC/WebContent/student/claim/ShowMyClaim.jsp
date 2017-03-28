<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
#comment{
	word-break: break-all;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Claim - ${id }</title>
</head>
<body>
	<div id="wrapper">
		<s:include value="../../home.html"></s:include>
		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-10">

					<div class="panel-body">
						<div class="row">
							<div class="col-lg-12">
								<s:form class="form-horizontal" enctype="multipart/form-data">

									<div class="form-group">
										<label class="col-sm-4 text-right" for="studentid">Student
											ID:</label>
										<div class="col-sm-6">
											<s:property value="studentId" />
										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-4 text-right" for="title">Title
											:</label>
										<div class="col-sm-6">
										<s:property value="title" />

										</div>

									</div>

									<div class="form-group">
										<label class="col-sm-4 text-right" for="content">Content
											:</label>
										<div class="col-sm-6">
											<s:property value="content" />
										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-4 text-right" for="type">Claim
											Type :</label>
										<div class="col-sm-6">
											<s:property value="claimType.claimName" />

										</div>

									</div>

									<div class="form-group">
										<label class="col-sm-4 text-right" for="createDate">Created
											Date :</label>
										<div class="col-sm-6">
											<s:property value="createDate" />

										</div>
									</div>
									
									<div class="form-group">
										<label class="col-sm-4 text-right" for="comment">Comment :</label>
										<div class="col-sm-6" id="comment">
											<s:property value="comment"/>

										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-4 text-right" for="dueDate">Due
											Date :</label>
										<div class="col-sm-6">

											<s:property value="dueDate" />

										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-4 text-right" for="status">status
											:</label>
										<div class="col-sm-6">

											<s:property value="status" />

										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-4 text-right" for="pathEvidence">Evidence:</label>
										<div class="col-sm-6">
											<a
												href="evidence/<s:property value="pathEvidence1FileName"/>"
												download>download file</a>
										</div>

									</div>

									<div class="form-group">
										<label class="col-sm-4 text-right" for="pathEvidence">Evidence:</label>
										<div class="col-sm-6">
											<a
												href="evidence/<s:property value="pathEvidence2FileName"/>"
												download>download file</a>
										</div>

									</div>

									<div class="form-group">
										<label class="col-sm-4 text-right" for="pathEvidence">Evidence:</label>
										<div class="col-sm-6">
											<a
												href="evidence/<s:property value="pathEvidence3FileName"/>"
												download>downlolad file</a>
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