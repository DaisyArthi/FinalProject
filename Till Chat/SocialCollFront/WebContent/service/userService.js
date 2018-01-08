app.factory('UserService',function($http){
	var userService={};
	var BASE_URL="http://localhost:8084/SocialColl/"
		
	userService.registerUser=function(user){
		return $http.post(BASE_URL+"/register",user)
	}	
	
	userService.validateUser=function(user){
		return $http.post(BASE_URL+"/login",user)
	}
	
	userService.updateUser=function(user){
		return $http.put(BASE_URL+"/updateUser",user)
	}
	
	userService.getUser=function(){
		return $http.get(BASE_URL+"/getAllUsers")
	}
	
	userService.logout=function(){
		return $http.get(BASE_URL+"/logout")
	}
	return userService;
})