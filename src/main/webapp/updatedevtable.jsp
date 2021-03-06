<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="Dev DB Entryform" content="">
<meta name="" content="">
<link rel="shortcut icon" type="image/x-icon" href="img/logo-tnx.png" />

<title>HandleIT Developer Update</title>

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
				<li><a href="contact.jsp">Contact</a></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container --> </nav>

	<!-- Page Header -->
	<header class="intro-header"
		style="background-image: url('img/signup.jpg')"> <!-- Header Box -->
	<div class="container">
		<div class="row">
			<div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
				<div class="page-heading">
					<h1 style="text-shadow: 2px 2px 4px #000000">Developer Profile
						Update</h1>
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
				<p>Please verify your original email and password.</p>

				<form action="UpdateProfileServlet" method="post">

					<!-- Verify Email -->
					<div class="row control-group">
						<div
							class="form-group col-xs-12 floating-label-form-group controls">
							<label>Email Address</label> <input type="text"
								class="form-control" placeholder="Email Address"
								name="verify-email_address" id="email_address" required
								data-validation-required-message="Please enter the email address.">
							<p class="help-block text-danger"></p>
						</div>
					</div>

					<!-- Verify Password -->
					<div class="row control-group">
						<div
							class="form-group col-xs-12 floating-label-form-group controls">
							<label>Password</label> <input type="text" class="form-control"
								placeholder="Password" name="verify-password" id="password"
								required
								data-validation-required-message="Please enter a password.">
							<p class="help-block text-danger"></p>
						</div>
					</div>

					<br>
					<p>Please fill out each field.</p>

					<!-- Up First Name -->
					<div class="row control-group">
						<div
							class="form-group col-xs-12 floating-label-form-group controls">
							<label>First Name</label> <input type="text" class="form-control"
								placeholder="First Name" name="update-first_name"
								id="first_name" required
								data-validation-required-message="Please enter the first name.">
							<p class="help-block text-danger"></p>
						</div>
					</div>

					<!-- Up Last Name -->
					<div class="row control-group">
						<!-- 3 -->
						<div
							class="form-group col-xs-12 floating-label-form-group controls">
							<label>Last Name</label> <input type="text" class="form-control"
								placeholder="Last Name" name="update-last_name" id="last_name"
								required
								data-validation-required-message="Please enter the last name.">
							<p class="help-block text-danger"></p>
						</div>
					</div>

					<!-- Up Password -->
					<div class="row control-group">
						<!-- 2 -->
						<div
							class="form-group col-xs-12 floating-label-form-group controls">
							<label>Password</label> <input type="text" class="form-control"
								placeholder="Password" name="update-password" id="password"
								required
								data-validation-required-message="Please enter a password.">
							<p class="help-block text-danger"></p>
						</div>
					</div>

					<!-- Up Email -->
					<div class="row control-group">
						<div
							class="form-group col-xs-12 floating-label-form-group controls">
							<label>Email Address</label> <input type="text"
								class="form-control" placeholder="Email Address"
								name="update-email_address" id="email_address" required
								data-validation-required-message="Please enter the email address.">
							<p class="help-block text-danger"></p>
						</div>
					</div>

					<!-- Up Location -->
					<div class="row control-group">
						<div
							class="form-group col-xs-12 floating-label-form-group controls">
							<label>Location</label> <input type="text" class="form-control"
								placeholder="Location" name="update-location" id="location"
								required
								data-validation-required-message="Please enter the location.">
							<p class="help-block text-danger"></p>
						</div>
					</div>

					<!-- Up LinkedIn Link -->
					<div class="row control-group">
						<div
							class="form-group col-xs-12 floating-label-form-group controls">
							<label>LinkedIn Profile Url</label> <input type="text"
								class="form-control" placeholder="LinkedIn Profile Url"
								name="update-profile_url" id="profile_url" required
								data-validation-required-message="Please enter the profile url.">
						</div>
					</div>

					<!-- Up Project Types -->
					<div class="row control-group">
						<div
							class="form-group col-xs-12 floating-label-form-group controls">
							<label>Projects</label>
							<div style="font-size: 1.5em; color: #808080;">
								<p>Projects</p>
								<input type="checkbox" name="update-project_type" value="*">All</input><br>
								<input type="checkbox" name="update-project_type"
									value="Databases">Databases</input><br> <input
									type="checkbox" name="update-project_type"
									value="Simple Websites">Simple Websites</input><br> <input
									type="checkbox" name="update-project_type"
									value="Web Applications">Web Applications</input><br> <input
									type="checkbox" name="update-project_type"
									value="Android Applications">Android Applications</input><br>
								<input type="checkbox" name="update-project_type"
									value="IOS Applications">IOS Applications</input>
							</div>
						</div>
					</div>

					<!-- Up Skills -->
					<div class="row control-group">
						<div
							class="form-group col-xs-12 floating-label-form-group controls">
							<label>Skills</label>
							<div style="font-size: 1.5em; color: #808080;">
								<p>Skills</p>
								<input type="checkbox" name="update-skills" value="*">All</input><br>
								<input type="checkbox" name="update-skills" value=".Net">.Net</input><br>
								<input type="checkbox" name="update-skills" value="AngularJS">AngularJS</input><br>
								<input type="checkbox" name="update-skills" value="C">C</input><br>
								<input type="checkbox" name="update-skills" value="C#">C#</input><br>
								<input type="checkbox" name="update-skills" value="C++">C++</input><br>
								<input type="checkbox" name="update-skills" value="HTML/CSS">HTML/CSS</input><br>
								<input type="checkbox" name="update-skills" value="Java">Java</input><br>
								<input type="checkbox" name="update-skills" value="JavaScript">Javascript</input><br>
								<input type="checkbox" name="update-skills" value="Node.js">Node.js</input><br>
								<input type="checkbox" name="update-skills" value="Objective C">Objective
								C</input><br> <input type="checkbox" name="update-skills"
									value="PHP">PHP</input><br> <input type="checkbox"
									name="update-skills" value="Python">Python</input><br> <input
									type="checkbox" name="update-skills" value="Ruby">Ruby</input><br>
								<input type="checkbox" name="update-skills" value="SQL">SQL</input><br>
								<input type="checkbox" name="update-skills" value="Swift">Swift</input><br>
							</div>
						</div>
					</div>

					<div id="success"></div>
					<div class="row">
						<div class="form-group col-xs-12">
							<br>
							<button id="subBtn" type="submit" class="btn btn-default">Submit</button>
						</div>
					</div>

				</form>
			</div>
		</div>
	</div>

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


	<script src="js/mailgun_validator.js"></script>

	<!-- API -->
	<script>
		$(function() {

			// capture all enter and do nothing
			$("#email_address").keypress(function(e) {
				if (e.which == 13) {
					$("#email_address").trigger('focusout');
					return false;
				}
			});

			// capture clicks on validate and do nothing
			$("#email_address").blur(function() {
				return false;
			});

			// capture clicks on validate and do nothing
			$("#email_address").blur(function() {
				return true;
			});

			// attach jquery plugin to validate address
			$("#email_address").mailgun_validator({
				api_key : 'pubkey-83a6-sl6j2m3daneyobi87b3-ksx3q29',
				success : validation_success,
				error : validation_error,
			});

		});
		// if email successfull validated
		function validation_success(data) {
			$('#status').html(
					get_suggestion_str(data['is_valid'], data['did_you_mean']));
		}

		// if email is invalid
		function validation_error(error_message) {
			$('#status').html(error_message);
		}

		// suggest a valid email
		function get_suggestion_str(is_valid, alternate) {
			if (is_valid) {
				var result = '<span class="success">Address is valid.</span>';
				if (alternate) {
					result += '<span class="warning"> (Though did you mean <em>'
							+ alternate + '</em>?)</span>';
				}
				return result
			} else if (alternate) {
				return '<span class="warning">Did you mean <em>' + alternate
						+ '</em>?</span>';
			} else {
				return '<span class="error">Address is invalid.</span>';
			}
		}
	</script>


</body>

</html>
