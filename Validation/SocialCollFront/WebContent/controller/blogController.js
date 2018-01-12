app.controller('myBlog',function(BlogService,$scope,$location,$routeParams){
	
	var id=$routeParams.id
	
	$scope.blog={}
	
	$scope.addblog=function(){
		BlogService.addblog($scope.blog).then(function(response){
			console.log(response.status)
			alert('Blog added in the table successfully....Is waiting for approval')
			$location.path('/getallblogs')
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
	
	$scope.updateblog=function(){
		BlogService.updateblog($scope.blog).then(function(response){
			console.log(response.status)
			alert("Blog updated successfully....")
			$location.path('/getallblogs')
		},function(response){
			console.log(response.data)
			if(response.status==401)
				$location.path('/login')
		})
	}
	
	BlogService.getBlogWaitingForApproval().then(function(response){
		$scope.blogWaitingForApproval=response.data;
	},function(response){
		if(response.status==401)
			$location.path('/login')
	})
	
	BlogService.getBlogApproved().then(function(response){
		$scope.blogApproved=response.data;
	},function(response){
		if(response.status==401)
			$location.path('/login')
	})
})
