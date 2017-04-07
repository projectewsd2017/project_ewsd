<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="resources/vendor/jquery/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Student - ${id }</title>
<style>
#hide {
	display: none;
}

#show {
	display: block;
}
</style>
</head>
<body>
	<div id="wrapper">
		<s:include value="../../indexCoo.jsp"></s:include>
		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">

					<div class="panel-body">
						<div class="row">
							<div class="col-lg-10">
								<s:form class="form-horizontal" enctype="multipart/form-data">

									<div class="form-group">
										<label class="col-sm-4 text-right" for="fullname">Full
											Name :</label>
										<div class="col-sm-6">
											<s:property value="firstName+ ' '+ lastName" />

										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-4 text-right" for="username">Username
											:</label>
										<div class="col-sm-6">

											<s:property value="username" />

										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-4 text-right" for="email">Email
											:</label>
										<div class="col-sm-6">

											<s:property value="email" />

										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-4 text-right" for="dob">Date
											Of Birth :</label>
										<div class="col-sm-6">

											<s:property value="dob" />

										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-4 text-right" for="address">Address
											:</label>
										<div class="col-sm-6">

											<s:property value="address" />

										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-4 text-right" for="sex">Sex :</label>
										<div class="col-sm-6">

											<s:property value="sex" />

										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-4 text-right" for="faculty">Faculty
											:</label>
										<div class="col-sm-6">

											<s:property value="faculty.facutlyName" />

										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-4 text-right" for="phonenumber">Phone Number
											:</label>
										<div class="col-sm-6">

											<s:property value="phoneNumber" />

										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-4 text-right" for="fatherName">Father Name
											:</label>
										<div class="col-sm-6">

											<s:property value="fatherName" />

										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-4 text-right" for="motherName">Mother Name
											:</label>
										<div class="col-sm-6">

											<s:property value="motherName" />

										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-4 text-right" for="fatherProfession">Father Profession
											:</label>
										<div class="col-sm-6">

											<s:property value="fatherProfession" />

										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-4 text-right" for="motherProfession">Mother Profession
											:</label>
										<div class="col-sm-6">

											<s:property value="motherProfession" />

										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-4 text-right" for="fatherOfWork">Father Place Of Work
											:</label>
										<div class="col-sm-6">

											<s:property value="fatherOfWork" />

										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-4 text-right" for="motherOfWork">Mother Place OfWork
											:</label>
										<div class="col-sm-6">

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
							<div style="text-align: right" id="${ admin  ? 'show' : 'hide' }">
								<button class="btn btn-default">
									<s:a href="%{updateid}">Update</s:a>
								</button>
								&nbsp

								<button class="btn btn-default" >
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