app.factory('BlogService',function($http){
	var blogService={};
	
	blogService.addblog=function(blog){
		return $http.post("http://localhost:8084/SocialColl/addblog",blog)
	}
	
	blogService.getblog=function(id){
		return $http.get("http://localhost:8084/SocialColl/getblog/"+id)
	}
	
	blogService.getBlogWaitingForApproval=function(){
		return $http.get("http://localhost:8084/SocialColl/getallblogs/0")
	}
	
	blogService.getBlogApproved=function(){
		return $http.get("http://localhost:8084/SocialColl/getallblogs/1")
	}
	
	blogService.updateblog=function(blog){
		return $http.post("http://localhost:8084/SocialColl/updateblog",blog)
	}
	
	return blogService;
})