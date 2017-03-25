<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<s:head />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Claim - Edit ${id }</title>
<style type="text/css">
.rendered{
	display: none;
}
</style>
<script src="http://code.jquery.com/jquery-2.1.1.js"></script>
<script type="text/javascript">
	$(document)
			.ready(

					function() {
						$.validator.addMethod('filesize', function(value,
								element, param) {
							return this.optional(element)
									|| (element.files[0].size <= param)
						}, 'File size must be less than {0}');
						$("#updateClaim")
								.validate(
										{

											rules : {
												studentId : "required",
												title : "required",
												content : "required",
												pathEvidence1 : {
													filesize : 2097152,
													accept : "image/png,image/jpeg,image/pjpeg,application/pdf"
												},
												pathEvidence2 : {
													filesize : 2097152,
													accept : "image/png,image/jpeg,image/pjpeg,application/pdf"
												},
												pathEvidence3 : {
													filesize : 2097152,
													accept : "image/png,image/jpeg,image/pjpeg,application/pdf"
												}

											},
											messages : {
												style : "color:red",
												studentId : "Please enter your studentId",
												title : "Please enter your title",
												content : "Please enter your content",
												pathEvidence1 : "File must be JPG, PNG or PDF, less than 2MB and file name less than 50 character",
												pathEvidence2 : "File must be JPG, PNG or PDF, less than 2MB and file name less than 50 character",
												pathEvidence3 : "File must be JPG, PNG or PDF, less than 2MB and file name less than 50 character"

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
								<s:form action="saveupdateclaim" id="updateClaim"
									cssClass="form-horizontal col-xs-12"
									enctype="multipart/form-data" validate="true">
									<s:textfield name="id" type="hidden"></s:textfield>
									<div class="form-group">
										<label class="control-label col-sm-2" for="studentId">student Id:</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" id="studentId" readonly="readonly"
												name="studentId" placeholder="Enter studentId" value="${studentId}">
										</div>
									</div>
									
									<div class="form-group">
										<label class="control-label col-sm-2" for="coordinator">Coordinator:</label>
										<div class="col-sm-10">
											<s:select class="form-control" id="coordinator"
												label="Claim Type" list="%{listStaffs}" theme="simple"
												listKey="%{id}" style="width:100%" listValue="%{firstName}"
												value="%{id}" name="staffs.id" />
										</div>

									</div>

									<div class="form-group">
										<label class="control-label col-sm-2" for="title">Title:</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" id="title"
												name="title" placeholder="Enter Title" value="${title }">
										</div>
									</div>



									<div class="form-group" style="">
										<label class="control-label col-sm-2" for="claimtype">Type:</label>
										<div class="col-sm-10">
											<s:select class="form-control" id="claimtype"
												label="Claim Type" list="%{listType}" theme="simple"
												listKey="%{id}" style="width:100%" listValue="%{claimName}"
												value="%{id}" name="claimType.id" />
										</div>

									</div>

									<div class="form-group">
										<label class="control-label col-sm-2" for="content">Content:</label>
										<div class="col-sm-10">

											<textarea class="form-control" id="content" rows="5"
												name="content" placeholder="Enter content" maxlength="300">${content }</textarea>
										</div>
									</div>
									
									<div class="form-group">
										<label class="control-label col-sm-2" for="comment">comment:</label>
										<div class="col-sm-10">

											<textarea class="form-control" id="comment" rows="5"
												name="comment" placeholder="Enter comment" maxlength="500">${content }</textarea>
										</div>
									</div>



									<div class="form-group">
										<label class="control-label col-sm-2" for="title">Evidence:</label>
										<div class="col-sm-10">
											<input type="file" class="form-control" id="pathEvidence1" maxlength="50"
												name="pathEvidence1" value="${pathEvidence1FileName}"> <span id="file_error"></span>
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-sm-2" for="title">Evidence:</label>
										<div class="col-sm-10">
											<input type="file" class="form-control" id="pathEvidence2" maxlength="50"
												name="pathEvidence2" value="${pathEvidence2FileName}"> <span id="file_error"></span>
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-sm-2" for="title">Evidence:</label>
										<div class="col-sm-10">
											<input type="file" class="form-control" id="pathEvidence3" maxlength="50"
												name="pathEvidence3" value="${pathEvidence3FileName}"> <span id="file_error"></span>
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