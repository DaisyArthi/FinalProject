app.factory('JobService',function($http){
	
	var jobService = {};
	
	jobService.addjob = function(job){
		return $http.post("http://localhost:8084/SocialColl/addjob",job)
	}
	
	jobService.getAllJobs = function(){
		return $http.get("http://localhost:8084/SocialColl/getAllJobs")
	}
	
	jobService.getJobDetails = function(jobId){
		return $http.get("http://localhost:8084/SocialColl/getJob/{jobId}"+jobId)
	}
	
	return jobService;
})