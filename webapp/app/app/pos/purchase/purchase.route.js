(function() {
	'use strict';

	angular.module('yamaApp').config(applicationRoute);

	function applicationRoute($stateProvider) {
		$stateProvider.state('app.pos.purchase', {
			url: '/purchases',
			templateUrl: 'app/pos/purchase/purchase.list.html',
			controller: 'PosPurchaseListCtrl as ctrl'
		});
	}
})();
