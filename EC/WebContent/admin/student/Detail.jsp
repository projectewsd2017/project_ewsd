<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student - ${id }</title>
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
										<label class="control-label col-sm-2" for="status">Full Name
											:</label>
										<div class="col-sm-10">

											<s:property value="firstName+ ' '+ lastName" />

										</div>
									</div>
									
									<div class="form-group">
										<label class="control-label col-sm-2" for="status">Username
											:</label>
										<div class="col-sm-10">

											<s:property value="username" />

										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-sm-2" for="status">Email
											:</label>
										<div class="col-sm-10">

											<s:property value="email" />

										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-sm-2" for="status">Date Of Birth
											:</label>
										<div class="col-sm-10">

											<s:property value="dob" />

										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-sm-2" for="status">address
											:</label>
										<div class="col-sm-10">

											<s:property value="address" />

										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-sm-2" for="sex">sex
											:</label>
										<div class="col-sm-10">

											<s:property value="sex" />

										</div>
									</div>
									
									<div class="form-group">
										<label class="control-label col-sm-2" for="faculty">Faculty
											:</label>
										<div class="col-sm-10">

											<s:property value="faculty.facutlyName" />

										</div>
									</div>
									
									<div class="form-group">
										<label class="control-label col-sm-2" for="phonenumber">phonenumber
											:</label>
										<div class="col-sm-10">

											<s:property value="phoneNumber" />

										</div>
									</div>
									
									<div class="form-group">
										<label class="control-label col-sm-2" for="fatherName">fatherName
											:</label>
										<div class="col-sm-10">

											<s:property value="fatherName" />

										</div>
									</div>
									
									<div class="form-group">
										<label class="control-label col-sm-2" for="motherName">motherName
											:</label>
										<div class="col-sm-10">

											<s:property value="motherName" />

										</div>
									</div>
									
									<div class="form-group">
										<label class="control-label col-sm-2" for="fatherProfession">fatherProfession
											:</label>
										<div class="col-sm-10">

											<s:property value="fatherProfession" />

										</div>
									</div>
									
									<div class="form-group">
										<label class="control-label col-sm-2" for="motherProfession">motherProfession
											:</label>
										<div class="col-sm-10">

											<s:property value="motherProfession" />

										</div>
									</div>
									
									<div class="form-group">
										<label class="control-label col-sm-2" for="fatherOfWork">fatherOfWork
											:</label>
										<div class="col-sm-10">

											<s:property value="fatherOfWork" />

										</div>
									</div>
									
									<div class="form-group">
										<label class="control-label col-sm-2" for="motherOfWork">motherOfWork
											:</label>
										<div class="col-sm-10">

											<s:property value="motherOfWork" />

										</div>
									</div>

									
							</div>
							<s:url action="updateClaim" var="updateid">
								<s:param name="id">
									<s:property value="id" />
								</s:param>
								<s:param name="studentId">
									<s:property value="studentId" />
								</s:param>
								<s:param name="title">
									<s:property value="title" />
								</s:param>
								<s:param name="content">
									<s:property value="content" />
								</s:param>
								<s:param name="claimType.claimName">
									<s:property value="claimType.claimName" />
								</s:param>
								<s:param name="pathEvidence1FileName">
									<s:property value="pathEvidence1FileName" />
								</s:param>
								<s:param name="pathEvidence2FileName">
									<s:property value="pathEvidence2FileName" />
								</s:param>
								<s:param name="pathEvidence3FileName">
									<s:property value="pathEvidence3FileName" />
								</s:param>

							</s:url>
							<button class="btn btn-default">
								<s:a href="%{updateid}">Update</s:a>
							</button>

							</s:form>
						</div>
					</div>
				</div>

			</div>

		</div>

	</div>








</body>
</html>