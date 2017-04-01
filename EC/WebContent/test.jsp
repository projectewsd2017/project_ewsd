<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Email Form</title>
<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>
<div id="chart_div"></div>

</head>
<script type="text/javascript">
	google.charts.load('current', {
		packages : [ 'corechart', 'line' ]
	});
	google.charts.setOnLoadCallback(drawBackgroundColor);

	function drawBackgroundColor() {
		var data = new google.visualization.DataTable();
		data.addColumn('number', '${b}');
		data.addColumn('number', 'Dogs');

		data.addRows([ [ ${a},10 ], [ 2, 20 ], [ 3, 227 ], [ 4, 33 ], [ 5, 39 ],
				[ 6, 21 ], [ 7, 55 ], [ 9, 56 ], [ 10, 99 ], [ 11, 12 ],
				[ 12, 32 ] ]);
		

		var options = {
			hAxis : {
				title : 'Time'
			},
			vAxis : {
				title : 'Popularity'
			},
			backgroundColor : '#f1f8e9'
		};

		var chart = new google.visualization.LineChart(document
				.getElementById('chart_div'));
		chart.draw(data, options);
	}
</script>
<body>
	<em>The form below uses Google's SMTP server. So you need to enter
		a gmail username and password </em>
	<form action="emailer">

		<label for="to">To</label><br /> <input type="text" name="to" /><br />
		<label for="subject">Subject</label><br /> <input type="text"
			name="subject" /><br /> <label for="body">Body</label><br /> <input
			type="text" name="body" /><br /> <input type="submit"
			value="Send Email" />
	</form>
</body>
</html>