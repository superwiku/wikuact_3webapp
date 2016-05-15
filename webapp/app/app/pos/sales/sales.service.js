(function() {
	'use strict';

	angular.module('yamaApp').factory('RestSalesService', restSalesService);

	function restSalesService(Restangular) {
		return Restangular.service('saless');
	}
})();
