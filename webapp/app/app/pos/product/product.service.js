(function() {
	'use strict';

	angular.module('yamaApp').factory('RestProductService', restProductService);

	function restProductService(Restangular) {
		return Restangular.service('products');
	}
})();
