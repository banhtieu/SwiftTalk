

var application = angular.module("SwiftTalkApp", ['services']);

application.controller('LoginController', ['$scope', 'userService', function ($scope, userService){
	$scope.userService = userService;
}]);