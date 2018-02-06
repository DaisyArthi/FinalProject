app.factory('BlogService',function($http){
	var blogService={};
	
	blogService.addblog=function(blog){
		return $http.post("http://localhost:8084/SocialColl/addblog",blog)
	}
	
	blogService.getblog=function(id){
		return $http.get("http://localhost:8084/SocialColl/getblog/"+id)
	}
	
	blogService.approveblog=function(id){
		return $http.get("http://localhost:8084/SocialColl/approveblog/"+id)
	}
	
	blogService.rejectblog=function(id){
		return $http.get("http://localhost:8084/SocialColl/rejectblog/"+id)
	}
	
	blogService.fetchallblog=function(){
		return $http.get("http://localhost:8084/SocialColl/getallblogs")
	}
	
	blogService.updateblog=function(blog){
		return $http.post("http://localhost:8084/SocialColl/updateblog",blog)
	}
	
	return blogService;
})