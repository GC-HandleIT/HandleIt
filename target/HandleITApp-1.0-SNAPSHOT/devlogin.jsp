<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="Dev DB Entryform" content="">
<meta name="ErinBergman" content="">

<title>Developer Login Page</title>

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
				<!-- <li><a href="index.jsp">Home</a></li> -->
				<li><a href="contact.jsp">Contact</a></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container --> </nav>

	<!-- Page Header -->
	<!-- Set your background image for this header on the line below. -->
	<header class="intro-header"
		style="background-image: url('img/devlogin.jpg')">
	<div class="container">
		<div class="row">
			<div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
				<div class="page-heading">
					<h1 style="text-shadow: 2px 2px 4px #000000">Developer Login
						Page</h1>
					<hr class="small">
					<span style="text-shadow: 2px 2px 4px #000000" class="subheading"></span>
				</div>
			</div>
		</div>
	</div>
	</header>
	<!-- Main Content -->
	<div class="container">
		<div class="row">
			<div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
				<p>Please enter your email and password to login</p>
				<form action="LoginServlet" method="post">
					<div class="row control-group">
						<div
							class="form-group col-xs-12 floating-label-form-group controls">
							<label>Email</label> <input type="text" class="form-control"
								placeholder="Email" name="form-dev_login_email" id="v" required
								data-validation-required-message="Please enter your email.">
							<p class="help-block text-danger"></p>
						</div>
					</div>
					<div class="row control-group">
						<!-- 2 -->
						<div
							class="form-group col-xs-12 floating-label-form-group controls">
							<label>Password</label> <input type="password"
								class="form-control" placeholder="Password"
								name="form-dev_login_password" id="login_password" required
								data-validation-required-message="Please enter your password.">
							<p class="help-block text-danger"></p>
						</div>
					</div>
					<br>
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

	<!-- Footer -->
	<footer>
	<div class="container">
		<div class="row">
			<div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
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


	<script>
		document.getElementById("dbEF").onclick = function() {
			password()
		};

		function password() {
			var testV = 1;
			var pass1 = prompt('Please Enter Your Password', ' ');
			while (testV < 3) {
				if (!pass1)

					document
				if (pass1.toLowerCase() == "letmein") {
					document.getElementById("subBtn").disabled = false;
					break;
				}
				testV += 1;
				var pass1 = prompt(
						'Access Denied - Password Incorrect, Please Try Again.',
						'Password');
			}
			if (pass1.toLowerCase() != "password" & testV == 3)
				document.getElementById("subBtn").disabled = true;
			return " ";
		}
	</script>




</body>

</html>
