<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<s:head />
<script src="http://code.jquery.com/jquery-2.1.1.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Academic</title>
<script type="text/javascript">
	$(document)
			.ready(

					function() {
						$.validator.addMethod("greaterThan", function(value,
								element, params) {

							if (!/Invalid|NaN/.test(new Date(value))) {
								if ($(params).val()) {
									return new Date(value) > new Date($(params)
											.val());
								}

							}
							if ($(params).val()) {
								return isNaN(value)
										&& isNaN($(params).val())
										|| (Number(value) > Number($(params)
												.val()));
							} else {
								return true
							}
						});

						$("#addAcademicForm")
								.validate(
										{

											rules : {
												name : "required",
												closureDateString : {
													required : true,
													greaterThan : "#openDateString"
												},
												openDateString : {
													required : true,

												}

											},
											messages : {
												style : "color:red",
												name : "Please enter Academic name",
												closureDateString : "Closure Date must be required and less than Open Date",
												openDateString : "Please enter open date"

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
					<h1 class="page-header">Add Academic</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<div class="row">
				<div class="col-lg-12">

					<div class="panel-body">
						<div class="row">
							<div class="col-lg-6">
								<s:form action="saveaddacademic" validate="true"
									cssClass="form-horizontal col-xs-12" id="addAcademicForm"
									enctype="multipart/form-data">

									<div class="form-group">
										<label class="control-label col-sm-4" for="name">Name:</label>
										<div class="col-sm-6">
											<input type="text" class="form-control" id="name"
												maxlength="50" name="name" placeholder="Enter Name">
										</div>
									</div>

									<div class="form-group">
										<label class="control-label col-sm-4" for="openDateString">Open
											Date:</label>
										<div class="col-sm-6">
											<input type="date" class="form-control" id="openDateString"
												name="openDateString" maxlength="10">

										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-sm-4" for="closureDateString">Closure
											Date:</label>
										<div class="col-sm-6">
											<input type="date" class="form-control"
												id="closureDateString" name="closureDateString"
												maxlength="10">

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