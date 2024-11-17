<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<html>
<head>
    <title>Add Todos Page</title>
    <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<nav class="navbar navbar-expand-md navbar-light bg-light mb-3 p-1">
		<a class="navbar-brand m-1" href="https://courses.in28minutes.com">in28Minutes</a>
		<div class="collapse navbar-collapse">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" href="/todos">Home</a></li>
				<li class="nav-item"><a class="nav-link" href="/todos">Todos</a></li>
			</ul>
		</div>
		<ul class="navbar-nav">
			<li class="nav-item"><a class="nav-link" href="/logout">Logout</a></li>
		</ul>	
	</nav>
	
	
	
	
    <div class="container">
        <h1>Enter Todo Details</h1>
		<form:form method="POST" modelAttribute="todo">
		    <div class="mb-3">
		        <label for="description" class="form-label">Description:</label>
		        <form:input type="text" id="description" path="description" required="required" class="form-control"/>
				<form:errors path="description" cssClass="text-warning"/>
		    </div>
		    <div class="mb-3">
		        <label for="targetDate" class="form-label">Target Date:</label>
		        <form:input type="date" id="targetDate" path="targetDate" required="required" class="form-control"/>
		    </div>
		    <button type="submit" class="btn btn-success">Submit</button>
		</form:form>

    </div>   
    <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
</body>
</html>