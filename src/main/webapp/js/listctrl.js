var app = angular.module('vote',[]);

app.controller('ListCtrl', function($scope){
  $scope.queue =[{"votes":4,"id":"http://youtube.com"},{"votes":3,"id":"http://soundcloud.com"}]
});



