app.factory('FriendService',function($http){
	var friendService={}
	
	friendService.listOfSuggestedUsers=function(){
	  return  $http.get("http://localhost:8084/SocialColl/getsuggestedusers")
	}
	friendService.friendRequest=function(toId){
		  return  $http.post("http://localhost:8084/SocialColl/friendRequest/"+toId)
		}
	
	friendService.listOfPendingRequests=function(toId){
		  return  $http.get("http://localhost:8084/SocialColl/getpendingrequests")
		}
	friendService.getUserDetails=function(fromId){
		  return  $http.get("http://localhost:8084/SocialColl/getuserdetails/"+fromId)
		}
	
	friendService.updatePendingRequest=function(pendingRequest){
		  return  $http.put("http://localhost:8084/SocialColl/updatependingrequest",pendingRequest)
		}
	friendService.listOfFriends=function(){
		return $http.get("http://localhost:8084/SocialColl/friendslist")
	}
	
	return friendService;
})
