(function() {
	'use strict';

	angular.module('yamaApp').config(applicationRoute);

	function applicationRoute($stateProvider) {
		$stateProvider.state('app.pos.product', {
			url: '/products',
			templateUrl: 'app/pos/product/product.list.html',
			controller: 'PosProductListCtrl as ctrl'
		});
	}
})();
