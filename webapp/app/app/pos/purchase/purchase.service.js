(function() {
	'use strict';

	angular.module('yamaApp').factory('RestPurchaseService', restPurchaseService);

	function restPurchaseService(Restangular) {
		return Restangular.service('purchases');
	}
})();
