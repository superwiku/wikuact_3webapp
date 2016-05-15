(function() {
	'use strict';

	angular.module('yamaApp').config(posRoute);

	function posRoute($stateProvider) {
		$stateProvider.state('app.pos', {
			url: '/pos',
			templateUrl: 'app/pos/pos.html',
			controller: 'PosCtrl as ctrl'
		});
	}
})();
