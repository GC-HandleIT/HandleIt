<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="shortcut icon" type="image/x-icon" href="img/logo-tnx.png" />

<title>Search for a NonProfit</title>

<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="css/clean-blog.min.css" rel="stylesheet">

<!-- Custom Fonts -->
<link
	href="http://maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link
	href='http://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic'
	rel='stylesheet' type='text/css'>
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800'
	rel='stylesheet' type='text/css'>

</head>

<body>

	<!-- Navigation -->
	<nav class="navbar navbar-default navbar-custom navbar-fixed-top">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header page-scroll">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="index.jsp">HandleIT</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav navbar-right">
				<!-- <li><a href="index.jsp">Home</a></li>
					<li><a href="writenptable.jsp">Non-Profits Write</a></li>
					<li><a href="writedevtable.jsp">Developer Write</a></li> -->
				<li><a href="contact.jsp">Contact</a></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container --> </nav>

	<!-- Page Header -->
	<!-- Set your background image for this header on the line below. -->
	<header class="intro-header"
		style="background-image: url('img/read.jpg')">
	<div class="container">
		<div class="row">
			<div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
				<div class="post-heading">
					<h1 style="text-shadow: 2px 2px 4px #000000; text-align: center;">Search
						for a NonProfit</h1>
					<hr class="small">
					<span style="text-shadow: 2px 2px 4px #000000" class="subheading"></span>
				</div>
			</div>
		</div>
	</div>
	</header>

	<!-- Post Content -->
	<article>
	<div class="container">
		<div class="row">
			<div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
				<form action="NonProfServlet" method="post">
					<h1>Search by</h1>
					<hr>
					<table style="width: 100%" align="center"; >
						<tr style="padding: 5m">
							<th>Project Type</th>
							<th>Focus</th>
						</tr>

						<td><select name="project_type">
								<option value="*">All</option>
								<option value="Database">Databases</option>
								<option value="Simple Website">Simple Website</option>
								<option value="Web Application">Web Application</option>
								<option value="Android Application">Android Application</option>
								<option value="IOS Application">IOS Application</option>
						</select></td>

						<td><select name="focus">
								<option value="*">All</option>
								<option value="Animals">Animals</option>
								<option value="Children">Children</option>
								<option value="Environment">Environment</option>
								<option value="Homelessness">Homelessness</option>
								<option value="LGBTQIA">LGBTQIA</option>
								<option value="Mental Health">Mental Health</option>
								<option value="Science, Technology, Engineering, and Mathematics">Science, Technology, Engineering,
									and Mathematics</option>
								<option value="Social Equality">Social Equality</option>
								<option value="Women's Social Issues">Women's Social Issues</option>
								<option value="Other">Other</option>
						</select></td>
					</table>
					<hr>
					<div id="success"></div>
					<div class="row">
						<div class="form-group col-xs-12">
							<button id="subBtn" type="submit" class="btn btn-default">Submit</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	</article>

	<hr>

	<!-- Footer -->
	<footer>
	<div class="container">
		<div class="row">
			<div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
				<ul class="list-inline text-center">

					<li><a href="https://github.com/GC-HandleIT/HandleIt"
						target="_blank"> <span class="fa-stack fa-lg"> <i
								class="fa fa-circle fa-stack-2x"></i> <i
								class="fa fa-github fa-stack-1x fa-inverse"></i>
						</span>
					</a></li>
				</ul>
				<p class="copyright text-muted">Copyright &copy; The HandleIT
					Project 2016</p>
			</div>
		</div>
	</div>
	</footer>

	<!-- jQuery -->
	<script src="js/jquery-2.2.3.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>

	<!-- Custom Theme JavaScript -->
	<script src="js/clean-blog.min.js"></script>

</body>

</html>
