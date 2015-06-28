var app = angular.module('myApp', []);
app.controller('myCtrl', function($scope ,$http) {
	 alert("hello");
		$scope.clickme=function(){
			 $http.get("http://www.truemd.in/api/medicine_suggestions/?id=aciloc&key=bafea2f5ba8792c85822f3bbe4a749")
	    .success(function(response) {
	    	$scope.data = response;
	    });
		};
		
		});


