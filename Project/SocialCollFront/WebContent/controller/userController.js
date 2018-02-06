app.controller('myUser',function($scope,UserService,$rootScope,$location)
		{
	     $scope.user={}
	    /* if($rootScope.currentUser!=undefined){
	    	 UserService.getUser($scope.user).then(function(response){
	    		 $rootScope.message="getalluser"
	    		 $scope.user=response.data;
	    		 $location.path('/getAllUsers')
	    	 },function(response){
	    		 console.log(response.status)
	    		 $location.path('/')
	    	 })
	     }
	    */ 
	     
	     $scope.registerUser=function(){
	    	 UserService.registerUser($scope.user).then(function(response){
	    		 $rootScope.message="Registered successfully...please login again"
	    		 console.log($rootScope.message)
	    		 $location.path('/')
	    	 },function(response){
	    		 console.log(response.status)
	    		 console.log(response.data)
	    		 $location.path('/register')
	    	 })
	     }
	     
	     $scope.validateUser=function(){
	    	 UserService.validateUser($scope.user).then(function(response){
	    		 console.log(response.data)
	    		 $rootScope.currentUser=response.data
	    		 $location.path('/')
	    	 },function(response){
	    		 $scope.error=response.data
	    		 console.log(response.status)
	    		 $location.path('/login')
	    	 })
	     }
	     
	     $scope.updateUser=function(){
	    	 UserService.updateUser($scope.user).then(function(response){
	    		 alert("updated successfully...")
	    		 $location.path('/')
	    	 },function(response){
	    		 console.log(response.data)
	    		 if(response.status==401)
	    			 $location.path('/login')
	    		$location.path('/updateUser')	 
	    	 })
	    	 
	     }
		})