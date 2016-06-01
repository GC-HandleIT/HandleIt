<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="google-site-verification"
	content="QKM39okXlan5r9M6GtNIMP3d83rfd3FA0HNb2R-nAT4" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="shortcut icon" type="image/x-icon" href="img/logo-tnx.png" />

<title>HandleIT</title>

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
			<a class="navbar-brand" href="about.jsp"
				style="text-shadow: 2px 2px 4px #000000;">Who We Are</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav navbar-right">

				<li style="position:relative; display: inline-block; text-shadow: 2px 2px 4px #000000;"
					class="dropdown"><a href="javascript:void(0)" class="dropbtn"
					onclick="dropFunctionSign()">Sign-Up</a>
					<div style="position: absolute; display: none; text-shadow: 2px 2px 4px #000000;"
						class="dropdown-content" id="signDropdown">
						<a href="writedevtable.jsp">Developer</a> <a
							href="writenptable.jsp">NonProfit</a>
					</div></li>

				<li style="position: relative; display: inline-block; text-shadow: 2px 2px 4px #000000;"
					class="dropdown"><a href="javascript:void(0)" class="dropbtn"
					onclick="dropFunctionLog()">Login</a>
					<div style="position: absolute; display: none; text-shadow: 2px 2px 4px #000000;"
						class="dropdown-content" id="loginDropdown">
						<a href="devlogin.jsp">Developer</a> <a href="nplogin.jsp">NonProfit</a>
					</div></li>

				<li><a href="contact.jsp"
					style="text-shadow: 2px 2px 4px #000000;">Contact</a></li>
			</ul>
		</div>
	</div>
	
	<!-- /.navbar-collapse -->
	</div>
	<!-- /.container --> </nav>

	<!-- Page Header -->
	<!-- Set your background image for this header on the line below. -->
	<header class="intro-header"
		style="background-image: url('img/awindow.jpg')">
	<div class="container">
		<div class="row">
			<div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
				<div class="site-heading">
					<h1 style="text-shadow: 2px 2px 4px #000000;">HandleIT</h1>
					<hr class="small">
					<span style="text-shadow: 2px 2px 2px #000000; font-weight: 300;"
						class="subheading">Connecting Non-Profits with Applications
						Developers</span>
				</div>
			</div>
		</div>
	</div>
	</header>

	<!-- Main Content -->
	<div class="container">
		<div class="row">
			<div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
				<div class="post-preview">
					<h2 style="text-align: center;" class="post-title">What We Do</h2>
					<p style="font-size: 20px;" class="post-subtitle">We bring
						non-profit organizations and IT professionals together for
						collaboration on mutually beneficial projects
					</h5>
					<!-- <p class="post-meta">
						Posted by <a href="#">Start Bootstrap</a> on September 24, 2014
					</p> -->
				</div>
				<hr>
				<div class="post-preview">
					<h2 style="text-align: center;" class="post-title">Why We Do
						This</h2>
					<p style="font-size: 20px" class="post-subtitle">As developers,
						we see a need in the non-profit arena to lend our skills to
						organizations that help causes we are passionate about while
						building our portfolio and expanding our skill set. Many
						non-profits can not afford skilled IT professionals to help them
						take their vision to the next level. We help the non-profits
						handle their information technology needs by pairing them with
						skilled professionals.</p>
				</div>
				<!-- Pager -->
				<!-- <ul class="pager">
					<li class="next"><a href="#">Older Posts &rarr;</a></li>
				</ul> -->
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

	<script>
		function dropFunctionLog() {
			document.getElementById("loginDropdown").classList.toggle("show");
		}

		function dropFunctionSign() {
			document.getElementById("signDropdown").classList.toggle("show");
		}

		window.onclick = function(event) {
			if (!e.target.matches('.dropbtnlog')) {

				var dropdowns = document
						.getElementsByClassName("dropdown-content");
				for (var i = 0; i < dropdowns.length; i++) {
					var openDropdown = dropdowns[i];

					if (openDropdown.classList.contains('show')) {
						openDropdown.classList.remove('show');
					}
				}
			}
		}

		window.onclick = function(event) {
			if (!event.target.matches('.dropbtn')) {

				var dropdowns = document
						.getElementsByClassName("dropdown-content");
				var i;
				for (i = 0; i < dropdowns.length; i++) {
					var openDropdown = dropdowns[i];
					if (openDropdown.classList.contains('show')) {
						openDropdown.classList.remove('show');
					}
				}
			}
		}

		window.onscroll = function(event) {
			if (!event.target.matches('.dropbtn')) {

				var dropdowns = document
						.getElementsByClassName("dropdown-content");
				var i;
				for (i = 0; i < dropdowns.length; i++) {
					var openDropdown = dropdowns[i];
					if (openDropdown.classList.contains('show')) {
						openDropdown.classList.remove('show');
					}
				}
			}
		}
	</script>

</body>

</html>
