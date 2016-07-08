<nav class="navbar navbar-default">
	<div class="container-fluid">
		<div class="navbar-header">
			<p class="navbar-brand">Bullhorn</p>
		</div>
		<ul class="nav navbar-nav">
			<li><img src="${gravatar}?s=60" alt="gravatar"></li>
			<li class="active"><a href="./Home">Home</a></li>
			<li><a href="./Newsfeed">Newsfeed</a>
			<li><a href="./profile.jsp">Profile</a></li>
			<li><a href="./Logout">Logout</a></li>
		</ul>
		<div class="col-sm-3 col-md-3 pull-right">
		<form class="navbar-form" role="search" action="Search">
			<div class="input-group">
				<input type="text" name="search" id="search" class="form-control" placeholder="Search"
					name="q">
				<div class="input-group-btn">
					<button class="btn btn-default" type="submit">
						<i class="glyphicon glyphicon-search"></i>
					</button>
				</div>
			</div>
		</form>
	</div>
	</div>
</nav>