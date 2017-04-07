<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 5.00 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<s:head />
<script src="resources/vendor/jquery/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Claim - Edit ${id }</title>
<style type="text/css">
.rendered {
	display: none;
}
</style>
<script src="http://code.jquery.com/jquery-2.1.1.js"></script>
<script type="text/javascript">
	$(document)
			.ready(

					function() {

						$("#updateStudent")
								.validate(
										{

											rules : {
												username : {
													required : true,
													minlength : 3
												},
												firstName : "required",
												lastName : "required",
												email : "required",

											},
											messages : {
												style : "color:red",
												username : "Please enter your username and username more than 3 character",
												firstName : "Please enter your first name",
												lastName : "Please enter your last name",
												email : "Please enter your email"

											},

											errorElement : "em",
											errorPlacement : function(error,
													element) {
												// Add the `help-block` class to the error element
												error.addClass("help-block");

												if (element.prop("type") === "checkbox") {
													error.insertAfter(element
															.parent("label"));
												} else {
													error.insertAfter(element);
												}
											},
											highlight : function(element,
													errorClass, validClass) {
												$(element).parents(".col-sm-5")
														.addClass("has-error")
														.removeClass(
																"has-success");
											},
											unhighlight : function(element,
													errorClass, validClass) {
												$(element)
														.parents(".col-sm-5")
														.addClass("has-success")
														.removeClass(
																"has-error");
											}

										});

					})
</script>
</head>
<body>
	<div id="wrapper">
		<s:include value="../../index.jsp"></s:include>
		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">Update Student</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<div class="row">
				<div class="col-lg-12">

					<div class="panel-body">
						<div class="row">
							<div class="col-lg-10">
								<s:form action="saveupdatestudent" id="updateStudent"
									cssClass="form-horizontal col-xs-12"
									enctype="multipart/form-data" validate="true">
									<s:textfield name="id" type="hidden"></s:textfield>
									<div class="form-group">
										<label class="control-label col-sm-4" for="username">Username:</label>
										<div class="col-sm-6">
											<input type="text" class="form-control" id="username"
												value="${username }" name="username"
												placeholder="Enter Username">
										</div>
									</div>

									<div class="form-group">
										<label class="control-label col-sm-4" for="firstName">First
											Name:</label>
										<div class="col-sm-6">
											<input type="text" class="form-control" id="firstName"
												value="${firstName }" name="firstName"
												placeholder="Enter First Name">
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-sm-4" for="lastName">Last
											Name:</label>
										<div class="col-sm-6">
											<input type="text" class="form-control" id="lastName"
												value="${lastName }" name="lastName"
												placeholder="Enter Last Name">
										</div>
									</div>

									<div class="form-group">
										<label class="control-label col-sm-4" for="email">Email:</label>
										<div class="col-sm-6">
											<input type="email" class="form-control" id="email"
												value="${email }" name="email" placeholder="Enter email">
										</div>
									</div>

									<div class="form-group">
										<label class="control-label col-sm-4" for="dob">Birth
											Date:</label>
										<div class="col-sm-6">
											<input type="date" class="form-control" id="dob"
												name="dobString" value="${dob}">
										</div>
									</div>

									<div class="form-group">
										<label class="control-label col-sm-4" for="address">Address:</label>
										<div class="col-sm-6">
											<input type="text" class="form-control" id="address"
												value="${address }" name="address"
												placeholder="Enter address">
										</div>
									</div>

									<div class="form-group">
										<label class="control-label col-sm-4" for="sex">Sex:</label>
										<div class="col-sm-6">
											<label class="radio-inline"> <input type="radio"
												name="sex" value="Male" checked>Male
											</label> <label class="radio-inline"> <input type="radio"
												name="sex" value="Female">Female
											</label> <label class="radio-inline"> <input type="radio"
												name="sex" value="Other">Other
											</label>
										</div>
									</div>

									<div class="form-group">
										<label class="control-label col-sm-4" for="phoneNumber">Phone
											Number:</label>
										<div class="col-sm-6">
											<input type="text" class="form-control" id="phoneNumber"
												value="${phoneNumber }" name="phoneNumber" maxlength="12"
												placeholder="Enter phonenumber">
										</div>
									</div>



									<div class="form-group">
										<label class="control-label col-sm-4" for="faculty">Faculty:</label>
										<div class="col-sm-6">
											<s:select class="form-control" id="faculty"
												list="listAllFaculty" theme="simple" listKey="%{id}"
												listValue="%{facutlyName}" value="%{id}" name="faculty.id" />
										</div>

									</div>

									<div class="form-group">
										<label class="control-label col-sm-4" for="fatherName">Father
											Name:</label>
										<div class="col-sm-6">
											<input type="text" class="form-control" id="fatherName"
												value="${fatherName }" name="fatherName"
												placeholder="Enter fatherName">
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-sm-4" for="motherName">Mother
											Name:</label>
										<div class="col-sm-6">
											<input type="text" class="form-control" id="motherName"
												value="${motherName }" name="motherName"
												placeholder="Enter motherName">
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-sm-4" for="fatherProfession">Father
											Profession:</label>
										<div class="col-sm-6">
											<input type="text" class="form-control" id="fatherProfession"
												value="${fatherProfession }" name="fatherProfession"
												placeholder="Enter fatherProfession">
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-sm-4" for="motherProfession">Mother
											Profession:</label>
										<div class="col-sm-6">
											<input type="text" class="form-control" id="motherProfession"
												value="${motherProfession }" name="motherProfession"
												placeholder="Enter motherProfession">
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-sm-4" for="fatherOfWork">Father
											Place Of Work:</label>
										<div class="col-sm-6">
											<input type="text" class="form-control"
												value="${fatherOfWork }" id="fatherOfWork"
												name="fatherOfWork" placeholder="Enter fatherOfWork">
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-sm-4" for="motherOfWork">Mother
											Place Of Work:</label>
										<div class="col-sm-6">
											<input type="text" class="form-control"
												value="${motherOfWork }" id="motherOfWork"
												name="motherOfWork" placeholder="Enter motherOfWork">
										</div>
									</div>



									<div style="text-align: center">
										<s:submit class="btn btn-default" />
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