dashboardApp.controller('categoryController', function($scope, $http, $location, $window) {
   
	
	$http({
		method : 'GET',
		url : 'api/CategoryService/getCategories'
	}).success(function(data, status, headers, config) {
		$scope.categoryList = data.result;
	}).error(function(data, status, headers, config) {
		// called asynchronously if an error occurs
		// or server returns response with an error status.
	});
	
	$scope.getAssetsbyCategory = function(categoryName) {
		console.log(categoryName);
		var url = "http://" + $window.location.host + "/asset.html";
        console.log(url);
        $window.location.href = url;
		//$location.path('asset.html');
		/*$http({
			method : 'POST',
			url : 'api/AssetService/getAssets',
			data : {
				'category' : categoryName
			}
		}).success(function(data, status, headers, config) {
			$scope.assetList = data.result;
		}).error(function(data, status, headers, config) {
			// called asynchronously if an error occurs
			// or server returns response with an error status.
		});*/
	}
	
});