<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<script>
  $( function() {
    var availableTags = ${studentName};
    
    $( "#tags" ).autocomplete({
      source: availableTags
    });
  } );
 </script>
<style type="text/css">
.ui-autocomplete {
	position: absolute;
	z-index: 1000;
	cursor: default;
	padding: 0;
	margin-top: 2px;
	list-style: none;
	background-color: #ffffff;
	border: 1px solid #ccc -webkit-border-radius: 5px;
	-moz-border-radius: 5px;
	border-radius: 5px;
	-webkit-box-shadow: 0 5px 10px rgba(0, 0, 0, 0.2);
	-moz-box-shadow: 0 5px 10px rgba(0, 0, 0, 0.2);
	box-shadow: 0 5px 10px rgba(0, 0, 0, 0.2);
}

.ui-autocomplete>li {
	padding: 3px 20px;
}

.ui-autocomplete>li.ui-state-focus {
	background-color: #DDD;
}

.ui-helper-hidden-accessible {
	display: none;
}
</style>
</head>
<body>
	<div id="wrapper">
		<s:include value="../../indexCoo.jsp"></s:include>
		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-10">

				</div>
				<!-- /.col-lg-12 -->
			</div>
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">Claims List</div>
						<div class="panel-body">
						<form action="searchClaimByDate">
							<input type="text" id="myInput" onkeyup="myFunction()"
									class="form-control" name="username"
									placeholder="Enter Student Id">
							
							
							</br></br></br>
							<table width="100%"
								class="table table-striped table-bordered table-hover"
								id="myTable">
								<tr>
									<th>Student ID</th>
									<th>Student Name</th>
									<th>Title</th>
									<th>Status</th>
									<th>Created Date</th>
									<th>Due Date</th>


									<th colspan="3" style="text-align: center;">Action</th>
								</tr>
								<s:iterator value="listClaims" var="list">
									<tr>
										<td><s:property value="student.id" /></td>
										<td><s:property
												value="student.firstName +' '+ student.lastName" /></td>
										<td><s:property value="title" /></td>

										<td><s:property value="status" /></td>
										<td><s:property value="createDate" /></td>
										<td><s:property value="dueDate" /></td>

										
										<s:url action="searchByIdCoo" var="searchById">
											<s:param name="id">
												<s:property value="id" />
											</s:param>
										</s:url>
										<td><s:a href="%{searchById}">View</s:a></td>

									</tr>
								</s:iterator>
							</table>
							</form>
						</div>








					</div>
				</div>

			</div>
		</div>
	</div>
<script>
		function myFunction() {
			var input, filter, table, tr, td, i;
			input = document.getElementById("myInput");
			filter = input.value.toUpperCase();
			table = document.getElementById("myTable");
			tr = table.getElementsByTagName("tr");
			for (i = 0; i < tr.length; i++) {
				td = tr[i].getElementsByTagName("td")[0];
				if (td) {
					if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
						tr[i].style.display = "";
					} else {
						tr[i].style.display = "none";
					}
				}
			}
		}
	</script>
</body>
</html>