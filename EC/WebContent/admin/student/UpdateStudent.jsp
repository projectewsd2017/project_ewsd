<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 5.00 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<s:head />
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
												username : "required",
												firstName : "required",
												lastName : "required",
												email : "required",

											},
											messages : {
												style : "color:red",
												username : "Please enter your username",
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
								<s:form action="saveupdatestudent" id="updateStudent"
									cssClass="form-horizontal col-xs-12"
									enctype="multipart/form-data" validate="true">
									<s:textfield name="id" type="hidden"></s:textfield>
									<div class="form-group">
										<label class="control-label col-sm-2" for="username">Username:</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" id="username"
												value="${username }" name="username"
												placeholder="Enter Username">
										</div>
									</div>

									<div class="form-group">
										<label class="control-label col-sm-2" for="firstName">First
											Name:</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" id="firstName"
												value="${firstName }" name="firstName"
												placeholder="Enter First Name">
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-sm-2" for="lastName">Last
											Name:</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" id="lastName"
												value="${lastName }" name="lastName"
												placeholder="Enter Last Name">
										</div>
									</div>

									<div class="form-group">
										<label class="control-label col-sm-2" for="email">Email:</label>
										<div class="col-sm-10">
											<input type="email" class="form-control" id="email"
												value="${email }" name="email" placeholder="Enter email">
										</div>
									</div>

									<div class="form-group">
										<label class="control-label col-sm-2" for="dob">Birth
											Date:</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" id="dob" name="dob"
												value="${dob }" placeholder="Enter Birth Date">
										</div>
									</div>

									<div class="form-group">
										<label class="control-label col-sm-2" for="address">Address:</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" id="address"
												value="${address }" name="address"
												placeholder="Enter address">
										</div>
									</div>

									<div class="form-group">
										<label class="control-label col-sm-2" for="sex">sex:</label>
										<div class="col-sm-10">
											<input type="radio" class="form-control" id="sex" name="sex"
												value="${sex }" placeholder="Enter sex">
										</div>
									</div>

									<div class="form-group">
										<label class="control-label col-sm-2" for="phoneNumber">phonenumber:</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" id="phoneNumber"
												value="${phoneNumber }" name="phoneNumber"
												placeholder="Enter phonenumber">
										</div>
									</div>



									<div class="form-group">
										<label class="control-label col-sm-2" for="faculty">Faculty:</label>
										<div class="col-sm-10">
											<s:select class="form-control" id="faculty"
												list="%{listAllFaculty}" theme="simple" listKey="%{id}"
												style="width:100%" listValue="%{facutlyName}" value="%{id}"
												name="faculty.id" />
										</div>

									</div>

									<div class="form-group">
										<label class="control-label col-sm-2" for="fatherName">fatherName:</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" id="fatherName"
												value="${fatherName }" name="fatherName"
												placeholder="Enter fatherName">
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-sm-2" for="motherName">motherName:</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" id="motherName"
												value="${motherName }" name="motherName"
												placeholder="Enter motherName">
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-sm-2" for="fatherProfession">fatherProfession:</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" id="fatherProfession"
												value="${fatherProfession }" name="fatherProfession"
												placeholder="Enter fatherProfession">
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-sm-2" for="motherProfession">motherProfession:</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" id="motherProfession"
												value="${motherProfession }" name="motherProfession"
												placeholder="Enter motherProfession">
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-sm-2" for="fatherOfWork">fatherPlaceOfWork:</label>
										<div class="col-sm-10">
											<input type="text" class="form-control"
												value="${fatherOfWork }" id="fatherOfWork"
												name="fatherOfWork" placeholder="Enter fatherOfWork">
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-sm-2" for="motherOfWork">mother
											Place Of Work:</label>
										<div class="col-sm-10">
											<input type="text" class="form-control"
												value="${motherOfWork }" id="motherOfWork"
												name="motherOfWork" placeholder="Enter motherOfWork">
										</div>
									</div>




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