<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="resources/vendor/jquery/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Claim - ${id }</title>
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
				<div class="col-lg-10">

					<div class="panel-body">
						<div class="row">
							<div class="col-lg-12">
								<s:form class="form-horizontal" enctype="multipart/form-data">

									<div class="form-group">
										<label class="col-sm-4 text-right" for="studentid">Student
											ID:</label>
										<div class="col-sm-6">
											<input type="text" class="form-control" id="studentid"
												name="studentId" placeholder="Enter Student ID"
												value="${studentId}" readonly="readonly">
										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-4 text-right" for="title">Title :</label>
										<div class="col-sm-6">
											<input type="text" class="form-control" id="title"
												name="title" placeholder="Enter Title" value="${title }"
												readonly="readonly">

										</div>

									</div>

									<div class="form-group">
										<label class="col-sm-4 text-right" for="content">Content
											:</label>
										<div class="col-sm-6">
											<textarea class="form-control" rows="5" id="content"
												readonly="readonly" name="content"
												placeholder="Enter Content">${content}</textarea>
										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-4 text-right" for="title">Claim
											Type :</label>
										<div class="col-sm-6">
											<input type="text" class="form-control" id="title"
												name="title" placeholder="Enter Title"
												value="${claimType.claimName}" readonly="readonly">

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
										<label class="col-sm-4 text-right" for="comment">Comment
											:</label>
										<div class="col-sm-6">
											<textarea class="form-control" rows="5" id="content"
												readonly="readonly" name="comment"
												placeholder="Enter Content">${content}</textarea>
										</div>
									</div>

									<div class="form-group" id="${ checkFile1  ? 'show' : 'hide' }">
										<label class="col-sm-4 text-right" for="pathEvidence">Evidence:</label>
										<div class="col-sm-6">
											<a
												href="evidence/<s:property value="pathEvidence1FileName"/>"
												download>download file</a>
										</div>

									</div>

									<div class="form-group" id="${ checkFile2  ? 'show' : 'hide' }">
										<label class="col-sm-4 text-right" for="pathEvidence">Evidence:</label>
										<div class="col-sm-6">
											<a
												href="evidence/<s:property value="pathEvidence2FileName"/>"
												download>download file</a>
										</div>

									</div>

									<div class="form-group" id="${ checkFile3  ? 'show' : 'hide' }">
										<label class="col-sm-4 text-right" for="pathEvidence">Evidence:</label>
										<div class="col-sm-6">
											<a
												href="evidence/<s:property value="pathEvidence3FileName"/>"
												download>downlolad file</a>
										</div>

									</div>
							</div>
							<s:url action="updateClaimCoo" var="updateid">
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
								<s:param name="comment">
									<s:property value="comment" />
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
							<s:url action="deleteClaimCo" var="deleteid">
								<s:param name="id">
									<s:property value="id" />
								</s:param>
							</s:url>
							
							<div style="text-align: center" id="${ checkOverdue  ? 'hide' : 'show' }">
								<button class="btn btn-default">
									<s:a href="%{updateid}">Update</s:a>
								</button>
								&nbsp&nbsp&nbsp&nbsp
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