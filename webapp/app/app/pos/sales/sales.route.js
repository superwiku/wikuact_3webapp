(function() {
	'use strict';

	angular.module('yamaApp').config(applicationRoute);

	function applicationRoute($stateProvider) {
		$stateProvider.state('app.pos.sales', {
			url: '/saless',
			templateUrl: 'app/pos/sales/sales.list.html',
			controller: 'PosSalesListCtrl as ctrl'
		});
	}
})();
