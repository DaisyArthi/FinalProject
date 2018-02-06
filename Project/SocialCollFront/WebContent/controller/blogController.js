app.controller('myBlog',function(BlogService,$scope,$location,$routeParams){
	
	var id=$routeParams.id
	
	$scope.addblog=function(){
		BlogService.addblog($scope.blog).then(function(response){
			console.log(response.status)
			alert('Blog added in the table successfully........Is waiting for approval')
			$location.path('/approveblog')
		},function(response){
			if(response.status==401)
				$location.path('/login')
			$location.path('/addblog')	
		})
	}
	
	$scope.blog=BlogService.getblog(id).then(function(response){
		$scope.blog=response.data;
		console.log(response.data)
	},function(response){
		if(response.status==401)
			$location.path('/login')
	})
	
	function fetchallblog(){
		BlogService.fetchallblog().then(function(response){
			$scope.blog=response.data;
			console.log("Blog fetched")
			$location.path('/getallblogs')
		})
	}
	
	$scope.approveblog=function(id){
		BlogService.approveblog($scope.blog).then(fetchallblog(),function(response){
			console.log(response.status)
			alert("Blog is approved........")
			$location.path('/getallblogs')
		})	
	}
	
	$scope.rejectblog=function(id){
		BlogService.rejectblog($scope.blog).then(fetchallblog(),function(response){
			console.log(response.status)
			alert("Blog is rejected............")
		})
	}
	
	$scope.likeBlog=function(id){
		BlogService.likeBlog($scope.blog).success(fetchallblog(),function(response){
			console.log("likes incremented")
			$scope.refresh();
			$location.path('/getblog')
		})
	}
	fetchallblog();
})