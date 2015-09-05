
var service = angular.module("services", ['ngResource']);

service.factory('userService', ['$resource', function($resource){
	var UserRemoteService = $resource("/user/:action", 
		{
			action: "login"
		},
		{
			login: {
				method: "POST",
				params: { 
					action: "login"
				}
			}
		});
	
	var userService = {
		isAuthenticated: true,
		currentUser: null,
		onLogin: function() {
			var accessToken = FB.getAccessToken();
			this.remote.$login({
				'accessToken': accessToken
			}, function (data) {
				userService.currentUser = data;
			});
		},
		login: function(){
			FB.login(function(response){
				if (response.status === 'connected') {
					userService.onLogin();
				}
			})
		},
		remote: new UserRemoteService()
	};

	window.fbAsyncInit = function() {
		FB.init({
			appId      : '470932816419704',
			xfbml      : true,
			version    : 'v2.4'
		});

		FB.getLoginStatus(function(response){
			if (response.status === 'connected'){
				userService.onLogin();
			}
		});
	};
	
	return userService;
}]);
