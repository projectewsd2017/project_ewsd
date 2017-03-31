<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-dojo-tags" prefix="d"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 5.00 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Student - New Claim</title>
<d:head />
<script src="http://code.jquery.com/jquery-2.1.1.js"></script>
<script type="text/javascript">
	$(document)
			.ready(

					function() {

						$("#formStudent")
								.validate(
										{

											rules : {
												username : {
													required : true,
													minlength : 3
												},
												firstName : "required",
												lastName : "required",

											},
											messages : {
												style : "color:red",
												username : "Please enter your username and username more than 3 character",
												firstName : "Please enter your first name",
												lastName : "Please enter your last name",

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
					<br />
				</div>

			</div>
			<div class="row">
				<div class="col-lg-12">

					<div class="panel-body">
						<div class="row">
							<div class="col-lg-10">
								<s:form action="saveaddstudent"
									cssClass="form-horizontal col-xs-12" id="formStudent"
									enctype="multipart/form-data">



									<div class="form-group">
										<label class="control-label col-sm-4" for="username">Username:</label>
										<div class="col-sm-6">
											<input type="text" class="form-control" id="username"
												maxlength="20" name="username" placeholder="Enter Username">
										</div>
									</div>

									<div class="form-group">
										<label class="control-label col-sm-4" for="firstName">First
											Name:</label>
										<div class="col-sm-6">
											<input type="text" class="form-control" id="firstName"
												maxlength="50" name="firstName"
												placeholder="Enter First Name">
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-sm-4" for="lastName">Last
											Name:</label>
										<div class="col-sm-6">
											<input type="text" class="form-control" id="lastName"
												maxlength="50" name="lastName" placeholder="Enter Last Name">
										</div>
									</div>



									<div class="form-group">
										<label class="control-label col-sm-4" for="dobString">Birth
											Date:</label>
										<div class="col-sm-6">
											<input type="date" class="form-control" id="dobString"
												name="dobString" maxlength="10">

										</div>
									</div>

									<div class="form-group">
										<label class="control-label col-sm-4" for="address">Address:</label>
										<div class="col-sm-6">
											<input type="text" class="form-control" id="address"
												maxlength="10" name="address" placeholder="Enter address">
										</div>
									</div>

									<div class="form-group">
										<label class="control-label col-sm-4">Sex :</label>
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
											<input type="text" class="form-control" maxlength="12"
												id="phoneNumber" name="phoneNumber"
												placeholder="Enter phonenumber">
										</div>
									</div>



									<div class="form-group" style="">
										<label class="control-label col-sm-4" for="faculty">Faculty:</label>
										<div class="col-sm-6">
											<s:select class="form-control" id="faculty"
												list="%{listAllFaculty}" theme="simple" listKey="%{id}"
												style="width:100%" listValue="%{facutlyName}" value="%{id}"
												name="faculty.id" />
										</div>

									</div>

									<div class="form-group">
										<label class="control-label col-sm-4" for="fatherName">Father
											Name:</label>
										<div class="col-sm-6">
											<input type="text" class="form-control" id="fatherName"
												maxlength="50" name="fatherName"
												placeholder="Enter fatherName">
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-sm-4" for="motherName">Mother
											Name:</label>
										<div class="col-sm-6">
											<input type="text" class="form-control" id="motherName"
												maxlength="50" name="motherName"
												placeholder="Enter motherName">
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-sm-4" for="fatherProfession">Father
											Profession:</label>
										<div class="col-sm-6">
											<input type="text" class="form-control" id="fatherProfession"
												maxlength="50" name="fatherProfession"
												placeholder="Enter fatherProfession">
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-sm-4" for="motherProfession">Mother
											Profession:</label>
										<div class="col-sm-6">
											<input type="text" class="form-control" id="motherProfession"
												maxlength="50" name="motherProfession"
												placeholder="Enter motherProfession">
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-sm-4" for="fatherOfWork">Father
											Place Of Work:</label>
										<div class="col-sm-6">
											<input type="text" class="form-control" id="fatherOfWork"
												maxlength="50" name="fatherOfWork"
												placeholder="Enter fatherOfWork">
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-sm-4" for="motherOfWork">Mother
											Place Of Work:</label>
										<div class="col-sm-6">
											<input type="text" class="form-control" id="motherOfWork"
												maxlength="50" name="motherOfWork"
												placeholder="Enter motherOfWork">
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

	</div>

</body>
</html>