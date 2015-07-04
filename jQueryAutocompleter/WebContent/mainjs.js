var baseURL="http://gshyam:8080/healthokapp/rest/";
var app=angular.module('formExample', ['ngCookies']);
app.controller('ExampleController', ['$scope','$http','$cookies','$cookieStore','$window', function($scope,$http,$cookies,$cookieStore,$window) 
{
	$scope.sending = function() 
	{
    	var name=$scope.username;
    	var pass=$scope.userpass;
    	$http.get(baseURL+'auth/'+name+'/'+pass).
        success(function(data) 
        {
            $scope.greeting = data;
            if($scope.greeting.status==5)
            {  
            	$cookieStore.put('email',name);
            	$cookieStore.put('password',pass);
            	window.location="newang.html";
            }
            else
            {
            	window.location="login.html";
            }
        });
    };
}
]);
var myApp=angular.module("myApp",['ngCookies']);
myApp.controller("SimpleController",function($scope,$http,$cookieStore)
{ 
	$scope.mail=$cookieStore.get("email");
	if($scope.mail==null)
	{
		window.location="login.html";
	};
	$scope.logout=function()
	{
		$cookieStore.remove("email");
		window.location="login.html";
	};
	$scope.invoice = 
	{
	  items: []
	};
	 $http.get(baseURL+'buffer/cart/'+$scope.mail).success(function (data){
		 
	$scope.cart=data;	 
	angular.forEach($scope.cart, function(item) 
	        {
		        $scope.invoice.items.push({
		        id: item.medicineId,
		        quantity: item.quantity, 
		        medicineName: item.medicineName,
		        price: item.price 
		    	});
	        })
	});
	
	$scope.addItem = function()  
	{
        $scope.invoice.items.push({
        id: $scope.details.medicineId,
        quantity: 1, 
        medicineName: $scope.details.medicineName,
        price: $scope.details.price 
    	});
        $http.get(baseURL+'buffer/'+$scope.mail+'/'+$scope.details.medicineId+'/'+'1').success(function (data){});
    };
    $scope.updateqty= function(index)
    {   
    	$http.get(baseURL+'buffer/change/'+$scope.mail+'/'+$scope.invoice.items[index].id+'/'+$scope.invoice.items[index].quantity).success(function (data){});
    };
    $scope.removeItem = function(index) 
    {   
        $http.get(baseURL+'buffer/'+$scope.mail+'/'+$scope.invoice.items[index].id).success(function (data){});
        $scope.invoice.items.splice(index, 1);
    };
    $scope.total = function() 
    {
        var total = 0;
        angular.forEach($scope.invoice.items, function(item) 
        {
            total += item.quantity * item.price;
        })
        return total;
    };
	$scope.st=false;
	$scope.st2=true;
	$scope.sending=function()
	{
    	$scope.st=false;
    	$scope.st2=true;
    	$http.get(baseURL+'medicine/max/'+$scope.search).success(function (data)
    	{
      		$scope.names=data;
    	}); 
	};
	$scope.filldata=function(name)
	{
		$scope.search=name;
		$scope.st=true;
		$http.get(baseURL+'medicine/'+$scope.search).success(function (data)
	    {
				      $scope.details=data;
				      $scope.st2=false;
		});
	};
	$scope.place=function()
	{
		var tota=$scope.total();
		$cookieStore.put('total',tota);
    	$cookieStore.put('vat',25);
    	$cookieStore.put('delivery',50);
		window.location="user.html";
	}
});
angular.module('fExample', ['ngCookies'])
.controller('EController', ['$scope','$http','$cookies','$cookieStore','$window', function($scope,$http,$cookies,$cookieStore,$window) 
	{    
		$scope.mail=$cookieStore.get('email');
	    $scope.orderid=$cookieStore.get('orderid');  
		if($scope.mail==null)
		{
		window.location="login.html";
		};
	    $scope.logout=function()
	    {
		$cookieStore.remove("email");
		window.location="login.html";
	    };
	    $http.get(baseURL+'orderitems/'+$scope.orderid).
        success(function(data) 
        {
           $scope.items=data; 
        });
	    $http.get(baseURL+'order/'+$scope.orderid).
        success(function(data) 
        {
           $scope.order=data; 
        });
		
	}
]);
angular.module('forExample', ['ngCookies'])
.controller('ExamController', ['$scope','$http','$cookies','$cookieStore','$window', function($scope,$http,$cookies,$cookieStore,$window) 
	{    
		$scope.mail=$cookieStore.get('email'); 
		$scope.total=$cookieStore.get('total'); 
		$scope.vat=$cookieStore.get('vat'); 
		$scope.delivery=$cookieStore.get('delivery'); 
		
		if($scope.mail==null)
		{
		window.location="login.html";
		}
		$scope.deliver=function(index)
		{
			$http.get(baseURL+'order/'+$scope.mail+'/'+$scope.total+'/'+$scope.vat+'/'+$scope.delivery+'/'+$scope.addresses[index].addressId).
	        success(function(datas) 
	        {
	        	$scope.order=datas;
	        	if($scope.order.status>0)
	            {
	        	$cookieStore.put('orderid',$scope.order.status); 
				window.location="details.html";
	            }
        	});
 
		}
		$scope.deletion =function(index)
		{
			$http.get(baseURL+'address/delete/'+$scope.addresses[index].addressId).success(function(datas){
				$http.get(baseURL+'address/'+$scope.mail).
		        success(function(data) {
		            $scope.addresses = data;
		        });
			});
			
		}
	    $scope.logout=function()
	    {
		$cookieStore.remove("email");
		window.location="login.html";
	    };
		$http.get(baseURL+'address/'+$scope.mail).
        success(function(data) {
            $scope.addresses = data;
        });
		$scope.id=0;
		$scope.st=true;
		$scope.Adding= function()
		{
			$scope.st=true;
		}
		$scope.edit=function(index)
		{
		   $scope.st=false;
           $scope.house=$scope.addresses[index].housenumber;
           $scope.street=$scope.addresses[index].street;
           $scope.city=$scope.addresses[index].city;
           $scope.state=$scope.addresses[index].state;
           $scope.country=$scope.addresses[index].country;
           $scope.pincode=$scope.addresses[index].pincode;
		   $scope.fname=$scope.addresses[index].fullname;
		   $scope.phone=$scope.addresses[index].phone;
		   $scope.id=$scope.addresses[index].addressId;
		};
		 $scope.sending = function() {
			  
			    var email=$scope.mail;
		    	var house=$scope.house;
		    	var street=$scope.street;
		    	var city=$scope.city;
		    	var state=$scope.state;
		    	var country=$scope.country;
		    	var pincode=$scope.pincode;
		    	var fname=$scope.fname;
		    	var phone=$scope.phone;
		    	$http.get(baseURL+'address/'+house+'/'+street+'/'+city+'/'+state+'/'+country+'/'+pincode+'/'+email+'/'+fname+'/'+phone).
		        success(function(data) 
		        {
		            $scope.greeting = data;
					if($scope.greeting.status>0)
		            	{
		            	$http.get(baseURL+'order/'+$scope.mail+'/'+$scope.total+'/'+$scope.vat+'/'+$scope.delivery+'/'+$scope.greeting.status).
				        success(function(datas) 
				        {
				        	$scope.order=datas;
				        	if($scope.order.status>0)
				            {
				        	$cookieStore.put('orderid',$scope.order.status); 
							window.location="details.html";
				            }
		            	});
		            	}
		            	else
		            	{
		            		window.location="search.html";
		            	}
		        });
		 }
		 $scope.updating = function() {
			    var email=$scope.mail;
		    	var house=$scope.house;
		    	var street=$scope.street;
		    	var city=$scope.city;
		    	var state=$scope.state;
		    	var country=$scope.country;
		    	var pincode=$scope.pincode;
		    	var fname=$scope.fname;
		    	var phone=$scope.phone;
		    	$http.get(baseURL+'address/update/'+house+'/'+street+'/'+city+'/'+state+'/'+country+'/'+pincode+'/'+$scope.id+'/'+fname+'/'+phone).
		        success(function(data) 
		        {
		            $scope.greeting = data;
		            	$http.get(baseURL+'order/'+$scope.mail+'/'+$scope.total+'/'+$scope.vat+'/'+$scope.delivery+'/'+$scope.id).
				        success(function(datas) 
				        {
				        	$scope.order=datas;
				        	if($scope.order.status>0)
				            {
				        	$cookieStore.put('orderid',$scope.order.status); 
							window.location="details.html";
				            }
		            	});
		            
		        });
		 }
		 $scope.updateonly = function() 
		 {
			    var email=$scope.mail;
		    	var house=$scope.house;
		    	var street=$scope.street;
		    	var city=$scope.city;
		    	var state=$scope.state;
		    	var country=$scope.country;
		    	var pincode=$scope.pincode;
		    	var fname=$scope.fname;
		    	var phone=$scope.phone;
		    	$http.get(baseURL+'address/update/'+house+'/'+street+'/'+city+'/'+state+'/'+country+'/'+pincode+'/'+$scope.id+'/'+fname+'/'+phone).
		        success(function(data) 
		        {
		            $scope.greeting = data;
		            $http.get(baseURL+'address/'+$scope.mail).
				    success(function(datas) 
				    {
				       $scope.addresses=datas;
		            });
		            
		        });
		 }
	}
]);
var newApp=angular.module('foracc', ['ngCookies']);
newApp.controller('ExampleController', ['$scope','$http','$cookies','$cookieStore','$window', function($scope,$http,$cookies,$cookieStore,$window) 
{    
	$scope.mail=$cookieStore.get('email'); 	
	$http.get(baseURL+'personal/allorder/'+$scope.mail).
    success(function(data) {
        $scope.personalorders = data;
    });
	
	$scope.logout=function()
	{
		$cookieStore.remove("email");
		window.location="login.html";
	};
	$scope.stt=false;
	$scope.showme=function (index)
	{
		 $scope.stt=true;
		 $scope.orderid=$scope.personalorders[index].orderId;
		 $http.get(baseURL+'orderitems/'+$scope.orderid).
	        success(function(data) 
	        {
	           $scope.items=data; 
	        });
	};
}
]);
newApp.config(function ($routeProvider)
{
$routeProvider
.when('/personal',
		{
    	controller: 'ExampleController',
	    	templateUrl: 'personal.html'
	    })
.when('/orders',
		{
	    	controller: 'ExampleController',
	    	templateUrl: 'orders.html'
	    })
.when('/cancel',
		{
	    	controller: 'ExampleController',
	    	templateUrl: 'cancel.html'
	    })
});