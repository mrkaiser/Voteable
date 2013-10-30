var myApp = angular.module('vote',[])

myApp.controller('ListCtrl',[$scope, function($scope){
	//mock some data up
	$scope.queue =[{"votes":4,"id"s:"http://youtube.com"},{"votes":3,"id":"http://soundcloud.com"}]
}]);
