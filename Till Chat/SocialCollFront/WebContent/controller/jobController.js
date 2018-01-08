app.controller('myJob',function(JobService,$scope,$location){
	$scope.showJobDetails=false;
	
	$scope.job={}
	
	function getAllJobs(){
		JobService.getAllJobs().then(function(response){
			$scope.job=response.data;
			console.log("----------------->"+$scope.job.jobId)
		},function(response){
			$location.path('/login')
		})
	}
	
	$scope.addjob=function(){
		JobService.addjob($scope.job).then(function(response){
			console.log(response.status)
			alert('Job added Successfully....')
			$location.path('/getAllJobs')
		},function(response){
			if(response.status==401)
				$location.path('/login')
			$location.path('/addjob')	
		})
	}
	
	$scope.getJobDetails=function(jobId){
		$scope.showJobDetails=true
		JobService.getJobDetails(jobId).then(function(response){
			$scope.job=response.data;
		},function(response){
			console.log(response.data)
			$location.path('/login')
		})
	}
	
getAllJobs()	
})