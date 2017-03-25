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
										<label class="control-label col-sm-2" for="fullname">Full Name
											:</label>
										<div class="col-sm-10">

											<s:property value="firstName+ ' '+ lastName" />

										</div>
									</div>
									
									<div class="form-group">
										<label class="control-label col-sm-2" for="username">Username
											:</label>
										<div class="col-sm-10">

											<s:property value="username" />

										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-sm-2" for="email">Email
											:</label>
										<div class="col-sm-10">

											<s:property value="email" />

										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-sm-2" for="dob">Date Of Birth
											:</label>
										<div class="col-sm-10">

											<s:property value="dob" />

										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-sm-2" for="address">address
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
							<s:url action="updateStudent" var="updateid">
								<s:param name="id">
									<s:property value="id" />
								</s:param>
								<s:param name="firstName">
									<s:property value="firstName" />
								</s:param>
								<s:param name="lastName">
									<s:property value="lastName" />
								</s:param>
								<s:param name="username">
									<s:property value="username" />
								</s:param>
								<s:param name="dob">
									<s:property value="dob" />
								</s:param>
								<s:param name="email">
									<s:property value="email" />
								</s:param>
								<s:param name="address">
									<s:property value="address" />
								</s:param>
								<s:param name="sex">
									<s:property value="sex" />
								</s:param>
								<s:param name="phoneNumber">
									<s:property value="phoneNumber" />
								</s:param>
								<s:param name="fatherName">
									<s:property value="fatherName" />
								</s:param>
								<s:param name="motherName">
									<s:property value="motherName" />
								</s:param>
								<s:param name="fatherProfession">
									<s:property value="fatherProfession" />
								</s:param>
								<s:param name="motherProfession">
									<s:property value="motherProfession" />
								</s:param>
								<s:param name="fatherOfWork">
									<s:property value="fatherOfWork" />
								</s:param>
								<s:param name="motherOfWork">
									<s:property value="motherOfWork" />
								</s:param>
								<s:param name="faculty.facutlyName">
									<s:property value="faculty.facutlyName" />
								</s:param>

							</s:url>
							<s:url action="deleteStudent" var="deleteid">
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