var app=angular.module("app",['ngRoute','ngCookies'])

app.config(function($routeProvider){
	$routeProvider
	.when('/home',
			{
		      templateUrl : 'views/home.html'
			})
	.when('/register',
			{
		      templateUrl : 'views/register.html',
		      controller : 'myUser'
		     })		
	.when('/login',
			{
		      templateUrl : 'views/login.html',
		      controller : 'myUser'
			})		
	.when('/updateUser',
			{
		      templateUrl : 'views/updateuser.html',
		      controller : 'myUser'
			})		
	/*.when('/getAllUsers',
			{
		      templateUrl :'views/listofuser.html',
		      controller :'myUser'
			})		*/
	.when('/addblog',
			{
		      templateUrl : 'views/blog.html',
		      controller : 'myBlog'
			})		
	.when('/getallblogs',
			{
		      templateUrl :'views/listofblogs.html',
		      controller : 'myBlog'
			})		
	.when('/approveblog',
			{
		      templateUrl : 'views/adminblog.html',
		      controller : 'myBlog'
			})		
	.when('/getblog',
			{
		      templateUrl : 'views/blogdetails.html',
		      controller : 'myBlog'
			})		
	.when('/addjob',
			{
		      templateUrl :'views/job.html',
		      controller : 'myJob'
			})		
	.when('/getAllJobs',
			{
		      templateUrl : 'views/jobdetails.html',
		      controller : 'myJob'
			})		
	.when('/suggesteduserslist',
			{
		      templateUrl : 'views/listofsuggestedusers.html',
		      controller : 'myFriend'
			})		
	.when('/pendingfriendrequests',
			{
		      templateUrl : 'views/listofpendingrequests.html',
		      controller : 'myFriend'
			})		
	.when('/getUserDetails/:fromId',
			{
		      templateUrl : 'views/userdetails.html',
		      controller : 'myFriendCtrl'
			})		
	.when('/friendsList',
			{
		      templateUrl : 'views/ListofFriends.html',
		      controller : 'myFriend'
			})		
	.when('/profilepicture',
			{
		      templateUrl : 'views/ProfilePicture.html'
			})		
	.when('/viewprofile',
			{
		      templateUrl : 'views/viewprofile.html',
		      controller : 'myDetailCtrl'
			})		
	.when('/chat',
			{
		      templateUrl : 'views/chat.html',
		      controller : 'myChat'
			})		
})

app.run(function($rootScope,$cookieStore,UserService,$location)
		{
	     if($rootScope.currentUser==undefined)
	    	 $rootScope.currentUser=$cookieStore.get("currentUser")
	    	 
	    	 $rootScope.logout=function(){
	    	 UserService.logout().then(function(response){
	    		 $rootScope.logoutSuccess="Loggedout Successfully...."
	    			 delete $rootScope.currentUser
	    			 $cookieStore.remove("currentUser")
	    			 $location.path('/login')
	    	 },function(response){
	    		 $location.path('/login')
	    	 })
	     }
		})